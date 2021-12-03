package k_jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import e_oop.ScanUtil;

public class JDBCBoardT {

	public static void main(String[] args) {
		new JDBCBoardT().start();
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();

	private void start() {
		while(true) {
			System.out.println("---------------[ 목록 ]----------------");
			String sql = "SELECT A.BOARD_NO"
					+ "     , A.TITLE"
					+ "     , B.MEM_NAME"
					+ "     , TO_CHAR(A.REG_DATE, 'MM-DD') AS REG_DATE"
					+ "  FROM TB_JDBC_BOARD A"
					+ "  LEFT OUTER JOIN MEMBER B ON A.MEM_ID = B.MEM_ID"
					+ " ORDER BY A.BOARD_NO DESC";
			
			List<Map<String, Object>> boardList = jdbc.selectList(sql);

			System.out.println("=====================================");
			System.out.println("번호\t제목\t작성자\t작성일");
			System.out.println("-------------------------------------");
			for(int i = 0; i < boardList.size(); i++) {
				Map<String, Object> board = boardList.get(i);
				System.out.print(board.get("BOARD_NO") + "\t");
				System.out.print(board.get("TITLE") + "\t");
				System.out.print(board.get("MEM_NAME") + "\t");
				System.out.print(board.get("REG_DATE") + "\n");
			}
			System.out.println("=====================================");
			
			System.out.println("1.조회  2.등록  0.종료>");
			int input = ScanUtil.nextInt();
			switch (input) {
			case 1: read(); break;
			case 2: insert(); break;
			case 0: 
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
			}
		}
	}

	private void read() {
		System.out.println("---------------[ 조회 ]----------------");
		System.out.print("조회할 게시물 번호>");
		int boardNo = ScanUtil.nextInt();
		
		String sql = "SELECT A.BOARD_NO"
				+ "     , A.TITLE"
				+ "     , A.CONTENT"
				+ "     , B.MEM_NAME"
				+ "     , TO_CHAR(A.REG_DATE, 'MM-DD') AS REG_DATE"
				+ "  FROM TB_JDBC_BOARD A"
				+ "  LEFT OUTER JOIN MEMBER B ON A.MEM_ID = B.MEM_ID"
				+ " WHERE A.BOARD_NO = ?";
		
		List<Object> param = new ArrayList<>();
		param.add(boardNo);
		
		Map<String, Object> board = jdbc.selectOne(sql, param);

		System.out.println("=====================================");
		System.out.println("번호\t: " + board.get("BOARD_NO"));
		System.out.println("작성자\t: " + board.get("MEM_NAME"));
		System.out.println("작성일\t: " + board.get("REG_DATE"));
		System.out.println("제목\t: " + board.get("TITLE"));
		System.out.println("내용\t: " + board.get("CONTENT"));
		System.out.println("=====================================");
		
		System.out.print("1.수정  2.삭제  0.목록>");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1: update(boardNo); break;
		case 2: delete(boardNo); break;
		}
	}

	private void insert() {
		System.out.println("---------------[ 등록 ]----------------");
		System.out.print("제목>");
		String title = ScanUtil.nextLine();
		System.out.print("내용>");
		String content = ScanUtil.nextLine();
		System.out.print("아이디>");
		String memId = ScanUtil.nextLine();
		
		String sql = "INSERT INTO TB_JDBC_BOARD "
				   + "VALUES ((SELECT NVL(MAX(BOARD_NO), 0) + 1 FROM TB_JDBC_BOARD)"
				   + "     , ?, ?, SYSDATE"
				   + "     , ?)";
		
		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(content);
		param.add(memId);
		
		if(0 < jdbc.update(sql, param)) {
			System.out.println("등록되었습니다.");
		}else {
			System.out.println("등록에 실패하였습니다.");
		}
	}

	private void update(int boardNo) {
		System.out.println("---------------[ 수정 ]----------------");
		System.out.print("제목>");
		String title = ScanUtil.nextLine();
		System.out.print("내용>");
		String content = ScanUtil.nextLine();
		
		String sql = "UPDATE TB_JDBC_BOARD"
				   + "   SET TITLE = ?"
				   + "     , CONTENT = ?"
				   + " WHERE BOARD_NO = ?";
		
		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(content);
		param.add(boardNo);
		
		if(0 < jdbc.update(sql, param)) {
			System.out.println("수정되었습니다.");
		}else {
			System.out.println("수정에 실패하였습니다.");
		}
	}

	private void delete(int boardNo) {
		System.out.println("---------------[ 삭제 ]----------------");
		System.out.print("정말 삭제하시겠습니까?(Y/N)>");
		String yn = ScanUtil.nextLine();
		
		if(yn.equalsIgnoreCase("Y")) {
			String sql = "DELETE "
					   + "  FROM TB_JDBC_BOARD"
					   + " WHERE BOARD_NO = ?";
			
			List<Object> param = new ArrayList<>();
			param.add(boardNo);
			
			if(0 < jdbc.update(sql, param)) {
				System.out.println("삭제되었습니다.");
			}else {
				System.out.println("삭제에 실패하였습니다.");
			}
		}else {
			System.out.println("삭제를 취소하였습니다.");
		}
	}

}











