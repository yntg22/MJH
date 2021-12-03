package k_jdbc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import e_oop.ScanUtil;

public class JDBCBoard {

	ArrayList<HashMap<String, Object>> boardTable = new ArrayList<>();
	SimpleDateFormat format = new SimpleDateFormat("MM-dd");
	
	
	public static void main(String[] args) {
		/*
		 * ArrayList와 HashMap을 사용해 게시판 테이블을 만들고,
		 * 조회, 등록, 수정, 삭제가 가능한 게시판을 만들어주세요.
		 * 
		 * 번호, 제목, 내용, 작성자, 작성일
		 * 
		 * 목록에서는 조회, 등록, 종료
		 * 상세화면에서는 수정, 삭제, 목록
		 */
		new JDBCBoard().start();
	}
	//게시글을 나타내려면,
	//DB에 저장된 내용을 가져와야함.
	JDBCUtil jdbc = JDBCUtil.getInstance(); //
	//꺼낼거니까 SELECT쿼리문을 날려서 받아와서 출력하자
	//첫 메인화면은 모든 자료들을 한줄씩 출력해야겠지
	private void start() {
		while(true){
			System.out.println("=================게시판===================");
			System.out.println("========================================");
			System.out.println("번호\t제목\t작성자\t작성일");
		
			String sql = "select * from tb_jdbc_board";
			List<Map<String, Object>> list = jdbc.selectList(sql);
			for(int i = list.size() - 1; i >= 0 ; i--){
				System.out.println("------------------------------------");
				System.out.println(list.get(i).get("BOARD_NO")
						+ "\t" + list.get(i).get("TITLE")
						+ "\t" + list.get(i).get("MEM_ID")
						+ "\t" + format.format(list.get(i).get("REG_DATE")));
			}
			
			System.out.println("=========================================");
			
			System.out.print("1.조회  2.등록  0.종료>");
			int input = ScanUtil.nextInt();
			
			switch (input) {
			case 1:
				read();
				break;
			case 2:
				insert();
				break;
			case 0:
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
				break;
			}
		}
	}

	private void read() {
		System.out.print("조회할 게시물 번호>");
		int boardNo = ScanUtil.nextInt();
		String sql = "select * from tb_jdbc_board where board_no = ?";
		
		ArrayList<Object> param = new ArrayList<>();
		param.add(boardNo);
		
		Map<String, Object> map = jdbc.selectOne(sql, param);
		
		System.out.println("=======================");
		System.out.println("번호\t: " + map.get("BOARD_NO"));
		System.out.println("-----------------------");
		System.out.println("작성자\t: " + map.get("MEM_ID"));
		System.out.println("-----------------------");
		System.out.println("작성일\t: " + map.get("REG_DATE"));
		System.out.println("-----------------------");
		System.out.println("제목\t: " + map.get("TITLE"));
		System.out.println("-----------------------");
		System.out.println("내용\t: " + map.get("CONTENT"));
		System.out.println("=======================");
		
		System.out.print("1.수정  2.삭제  0.목록>");
		int input = ScanUtil.nextInt();
		//조회까지 OK
		switch (input) {
		case 1:
			update(map);
			break;
		case 2:
			delete(map);
			break;
		case 0:
			
			break;
		}
	}

	private void delete(Map<String, Object> board) {
		System.out.print("정말 삭제 하시겠습니까?(Y/N)>");
		String input = ScanUtil.nextLine();
		
		switch (input) {
		case "Y":
		{
			//Y면 삭제 쿼리 날려주자
			String sql = "delete from tb_jdbc_board where board_no = ?";
			ArrayList<Object> param = new ArrayList<>();
			param.add(board.get("BOARD_NO"));

			int result = jdbc.update(sql,param);
			System.out.println(result+"개의 게시글이 삭제되었습니다.");
			break;
		}
			
		}

	}

	private void update(Map<String, Object> board) {
		//수정할때 받는것 map
		String sql = "update tb_jdbc_board set title = ?, content = ? where board_no = ?";
		ArrayList<Object> param = new ArrayList<>();
		System.out.println("바꿀 제목 :");
		param.add(ScanUtil.nextLine());
		System.out.println("바꿀 내용 :");
		param.add(ScanUtil.nextLine());
		param.add(board.get("BOARD_NO"));
		int result = jdbc.update(sql, param);

		System.out.println(result + "개 게시글이 수정되었습니다.");
	}

	private void insert() {  //게시글 등록

		//생성할떄 게시글번호는 자동으로 생성해야 한다?
		String sql = "insert into tb_jdbc_board(board_no,title,content,reg_date,mem_id) values(?,?,?,sysdate,?)";
		ArrayList<Object> param = new ArrayList<>();
		//처음등록할때는 .. 그래서 IF문을 썻다 나는..
		String boardnum = "SELECT A.BOARD_NO FROM (SELECT BOARD_NO FROM TB_JDBC_BOARD ORDER BY 1 DESC) A WHERE ROWNUM =1";
		Map<String, Object> map = jdbc.selectOne(boardnum);
		if(map.get("BOARD_NO") == null) {
			param.add(1);
		}
		else{param.add(Integer.parseInt(String.valueOf(map.get("BOARD_NO")))+1);}
	
		System.out.println("제목 : ");
		param.add(ScanUtil.nextLine());
		System.out.println("내용 : ");
		param.add(ScanUtil.nextLine());
		System.out.println("작성자 : ");
		param.add(ScanUtil.nextLine());
		
		
		
		int result=jdbc.update(sql, param); //sql문과 ? ?값들을 파라미터로 넘겨줘야함
		
		
		System.out.println("작성하신 게시글이" + result+"개 등록되었습니다.");
		
		
	}

}





