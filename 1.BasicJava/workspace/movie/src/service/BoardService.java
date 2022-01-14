package service;

import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.BoardDao;
import util.ScanUtil;
import util.View;

public class BoardService {

	private BoardService() {}
	private static BoardService instance;
	public static BoardService getInstance() {
		if (instance == null) {
			instance = new BoardService();
		}
		return instance;
	}
	
	private BoardDao boardDao = BoardDao.getInstance();
	
	
	//공지사항목록 출력
	public int boardList() {
		List<Map<String, Object>> boardList = boardDao.selectBoardList();
		System.out.println("─────────────────────── 공지사항 ───────────────────────");
		System.out.println("번호\t제목\t\t\t작성일자");
		System.out.println("─────────────────────────────────────────────────────");

		for (int i = 0; i < boardList.size(); i++) {
			Map<String, Object> board = boardList.get(i);
			System.out.print(board.get("AN_NO") + "\t");
			System.out.print(board.get("AN_TITLE") + "\t\t");
			System.out.println(board.get("AN_DATE") + "\t");

		}
		System.out.println("─────────────────────────────────────────────────────");

		System.out.println("< 1.조회    9.로그아웃 0.목록 >");
		int search = ScanUtil.nextInt();

		switch (search) {
		case 1 :
			return View.BOARD_ANNOUNCEMENTVIEW;
		case 9 :
			Controller.loginMember = null;
			return View.HOME;	
		case 0 :
			return View.WINDOW;
		}
		
		return View.WINDOW;
		
	}
	
	public static int boardNo;
	
	public int boardView() {
		System.out.println("조회하실 공지사항 번호를 입력해주세요 > ");
		boardNo = ScanUtil.nextInt();
		
		Map<String, Object> view = boardDao.selectBoardget(boardNo);
		System.out.println("─────────────────────────────────────");
		System.out.println("번호 : " + view.get("AN_NO"));
		System.out.println("제목  : " + view.get("AN_TITLE"));
		System.out.println("내용  : " + view.get("AN_CONTENT"));
		System.out.print("작성자  : " + view.get("AN_USER") + "\t");
		System.out.println("\t작성일 : " + view.get("AN_DATE"));
		System.out.println("─────────────────────────────────────");

		System.out.print("< 9.로그아웃 0.목록 >");
		int update = ScanUtil.nextInt();

		switch (update) {
		case 9: //로그아웃
			Controller.loginMember = null;
			return View.HOME;
		case 0:
			return View.BOARD_ANNOUNCEMENTLIST;
			}
		return View.BOARD_ANNOUNCEMENTLIST;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
