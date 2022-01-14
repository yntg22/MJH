package service;

import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.BoardDao;
import util.ScanUtil;
import util.View;

public class BoardService {

	// 싱글톤 패턴
	private BoardService() {}
	private static BoardService instance;
	public static BoardService getInstance() {
		if (instance == null) {
			instance = new BoardService();
		}
		return instance;
	}

	private BoardDao boardDao = BoardDao.getInstance();
	
	public int boardList() {
		List<Map<String,Object>> boardList = boardDao.selectBoardList();
		
		System.out.println("====================================");
		System.out.println("번호\t제목\t작성자\t작성일");
		System.out.println("------------------------------------");
		for (int i = 0; i < boardList.size(); i++) {
			Map<String, Object> board = boardList.get(i);
			System.out.print(board.get("BOARD_NO") + "\t");
			System.out.print(board.get("TITLE") + "\t");
			System.out.print(board.get("MEM_NAME") + "\t");
			System.out.print(board.get("REG_DATE") + "\n");
		}
		System.out.println("=====================================");
		
		System.out.print("1.조회	2.등록  0.로그아웃>");
		int input = ScanUtil.nextInt();
		
		switch(input) {
		case 1: //조회 조회할수있게 리턴해주고 controller에서 case 추가후 
			return View.BOARD_VIEW;
		case 2: //등록
			return View.BOARD_INSERT;
		case 0: //로그아웃
			Controller.loginMember = null;
			return View.HOME;
		}
		
		return View.BOARD_LIST;
	}

	public int boardView() {
		System.out.println("조회할 게시글 번호>");
		int num = ScanUtil.nextInt();
		Map<String, Object> selectBoardget = boardDao.selectBoardget(num);
		
		System.out.print("번호 : " + selectBoardget.get("BOARD_NO")+ "\t");
		System.out.print("제목 : " + selectBoardget.get("TITLE")+ "\t");
		System.out.print("날짜 : " + selectBoardget.get("REG_DATE")+ "\t");
		System.out.println("작성자 : " + selectBoardget.get("MEM_ID"));
		System.out.println("----------------------------------------------");
		System.out.print("내용 : " + selectBoardget.get("CONTENT") + "\n");
		
		System.out.println("-----------------------------------");
		System.out.println("1.무비서비스 2.삭제 3.목록");
		int input = ScanUtil.nextInt();
		
		switch(input) {
		case 1: //수정
			return View.R_TIME;
		case 2: //삭제
			return View.BOARD_DELETE;
		case 0: //목록
			return View.BOARD_LIST;
		}
		
		return View.BOARD_LIST;
	}

	public int boardInsert() { //등록
		System.out.println("제목 : ");
		String title = ScanUtil.nextLine();
		System.out.println("내용 : ");
		String content = ScanUtil.nextLine();
		
		
		int result = boardDao.boardinsert(title,content);
		if(result > 0) {
			System.out.println(result +"개의 게시글이 등록되었습니다");
		}else {
			System.out.println("등록 실패");
			return View.BOARD_INSERT; //실패하면 다시등록
		}
		return View.BOARD_LIST; //성공하면 게시글 리스트로
	}
	
	
}
