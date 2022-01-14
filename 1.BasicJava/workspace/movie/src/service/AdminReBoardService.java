package service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.w3c.dom.css.ViewCSS;

import controller.Controller;
import dao.AdminReBoardDao;
import util.ScanUtil;
import util.View;

public class AdminReBoardService {
	private AdminReBoardService() {}
	private static AdminReBoardService instance;
	public static AdminReBoardService getInstance() {
		if (instance == null) {
			instance = new AdminReBoardService();
		}
		return instance;
	}

	private AdminReBoardDao adminreboardDao = AdminReBoardDao.getInstance();
	
	
	public static int adminReBoardNo;
	
	//문의 게시판 조회
	public int reboardView() {
		
	List<Map<String,Object>> reBoardList = adminreboardDao.selectReBoardList();
	System.out.println("──────────────────────── Q & A ────────────────────────");
	System.out.println("번호\t제목\t\t\t작성자\t작성일자\t답변등록상태");
	System.out.println("───────────────────────────────────────────────────────");

		for (int i = 0; i < reBoardList.size(); i++) {
			Map<String, Object> board = reBoardList.get(i);
			System.out.print(board.get("BOARD_NO") + "\t");
			System.out.print(board.get("BOARD_TITLE") + "\t\t");
			System.out.print(board.get("M_NAME") + "\t");
			System.out.print(board.get("BOARD_DATE") + "\t");
			System.out.println(board.get("BOARD_RE"));
	}
		System.out.println("───────────────────────────────────────────────────────");
	
		System.out.print("1.조회  9.로그아웃 0.게시판 관리 첫화면>");
		int input = ScanUtil.nextInt();
		switch(input) {
		case 1:
			return View.BOARD_BOARDVIEW;
			
		case 9:
			Controller.loginMember = null;
			return View.HOME;
		case 0:
			return View.BOARD_ADMIN;	
		}
	return View.BOARD_BOARDPRINT;
}
	
	
	public int re() {
		System.out.println("조회 할 문의 번호를 입력해주세요 >");
		adminReBoardNo = ScanUtil.nextInt();
		Map<String, Object> print = adminreboardDao.reBoard(adminReBoardNo);
		System.out.println("─────────────────────────────────────");
			System.out.println("번호 : " + print.get("BOARD_NO"));
			System.out.println("제목  : " + print.get("BOARD_TITLE"));
			System.out.println("내용  : " + print.get("BOARD_CONTENT"));
			System.out.print("작성자  : " + print.get("M_NAME") + "\t");
			System.out.println("\t작성일 : " + print.get("BOARD_DATE"));
			System.out.println("─────────────────────────────────────");
			System.out.print("1.답변등록 2.강제삭제  9.로그아웃 0.목록 ");
			int input = ScanUtil.nextInt();
			
		switch(input) {
		case 1: //조회문의 답변 등록
			return View.BOARD_BOARDRE;
		case 2: //조회 문의 삭제
			return View.BOARD_BOARDDELETE;
		case 9: //로그아웃
			Controller.loginMember = null;
			return View.HOME;
		case 0 :
			return View.BOARD_BOARDPRINT;
	}
		return View.BOARD_BOARDPRINT;
	}

	
	//답변 등록
	public int reUpdate() {
		System.out.println("답변 입력 > ");
		String typing = ScanUtil.nextLine();
		String ok = "답변등록";
		int result = adminreboardDao.reupdate(typing, ok, adminReBoardNo);
		
		if(0 < result) {
			System.out.println("답변등록완료");
		}else {
			System.out.println("답변 다시 등록해주세요");
		}
		
		Map<String, Object> print = adminreboardDao.reBoard(adminReBoardNo);
		System.out.println("─────────────────────────────────────");
		System.out.println("제목  : " + print.get("BOARD_TITLE"));
		System.out.println("내용  : " + print.get("BOARD_CONTENT"))  ; 
		System.out.print("작성자  : " + print.get("M_NAME") + "\t");
		System.out.println("\t작성일 : " + print.get("BOARD_DATE"));
		System.out.println("─────────────────────────────────────");

		
		return View.BOARD_BOARDPRINT;
	}
	
	
	//게시글 강제 삭제
	public int reboardDelete () {
		System.out.println("게시글을 삭제 하시겠습니까? Y/N >");
		String s = ScanUtil.nextLine();
		if(s.equals("Y")||s.equals("y")) {
			int change = adminreboardDao.delete(adminReBoardNo);
			if(change > 0) {
				System.out.println("게시글 삭제 완료");
			}else {
				System.out.println("게시글 삭제 실패");
			}
		}
		return View.BOARD_BOARDPRINT;
		
	}
	
	
	
	
	
	
	
	
	
	
}
