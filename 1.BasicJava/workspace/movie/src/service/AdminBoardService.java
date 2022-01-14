package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.AdminBoardDao;
import util.ScanUtil;
import util.View;

public class AdminBoardService {

	private AdminBoardService() {
	}

	private static AdminBoardService instance;

	public static AdminBoardService getInstance() {
		if (instance == null) {
			instance = new AdminBoardService();
		}
		return instance;
	}
	// 공지사항 조회 및 등록/추가/삭제, 유실물조회 및 등록/추가/삭제, 문의게시판 조회 및 답글과 삭제, 리뷰게시판 조회 및 삭제

	
	private AdminBoardDao adminboardDao = AdminBoardDao.getInstance();

	// 게시판 4종류가 출력

	public int boardList() {
		System.out.println("=================================");
		System.out.println("== 1.공지사항            2.유실물관리               ==");
		System.out.println("== 3.문의게시판 관리   4.영화리뷰게시판 관리  ==");
		System.out.println("== 9.로그아웃            0.관리자모드 첫화면     ==");
		System.out.println("=================================");
		int input = ScanUtil.nextInt();

		switch (input) {
		case 1:
			return View.BOARD_ADMINVIEW;
		case 2 : 
			return View.BOARD_LOSTVIEW;
		case 3 :
			return View.BOARD_BOARDPRINT;	
		case 4 :
			return View.BOARD_REVIEWPRINT;
		case 9 : 
			Controller.loginMember = null;
			return View.HOME;
		case 0 : 
			return View.R_TIME;
		}
		return View.R_TIME;
	}

	// 공지사항 목록 조회

	public int boardView() {

		List<Map<String, Object>> boardList = adminboardDao.selectBoardList();

		System.out.println("─────────────────────── 공지사항 ───────────────────────");
		System.out.println("번호\t제목\t\t\t작성자\t작성일자");
		System.out.println("─────────────────────────────────────────────────────");

		for (int i = 0; i < boardList.size(); i++) {
			Map<String, Object> board = boardList.get(i);
			System.out.print(board.get("AN_NO") + "\t");
			System.out.print(board.get("AN_TITLE") + " \t\t ");
			System.out.print(board.get("AN_USER") + "\t");
			System.out.println(board.get("AN_DATE") + "\t");

		}
		System.out.println("─────────────────────────────────────────────────────");

		System.out.println("< 1.조회  2.등록  9.로그아웃 0.목록 >");
		int search = ScanUtil.nextInt();

		switch (search) {
		case 1:
			return View.BOARD_ADMINLOOK;
		case 2:
			return View.BOARD_ADMINUPDATE;
		case 9: //로그아웃
			Controller.loginMember = null;
			return View.HOME;	
		case 0:
			return View.BOARD_ANNOUNCEMENT;
		}

		return View.BOARD_ANNOUNCEMENT;
	}

	// 공지사항 목록 중 게시글 조회
	public static int adminBoardNo;

	public int boardLook() {
		System.out.println("조회할 목록 번호를 입력해주세요 >");
			// 게시물 100개 이상이면 switch-case썼을때 100개 만들어 줘야 해
			adminBoardNo = ScanUtil.nextInt();
			Map<String, Object> board = adminboardDao.read(adminBoardNo);
			System.out.println("─────────────────────────────────────");
			System.out.println("번호 : " + board.get("AN_NO"));
			System.out.println("제목  : " + board.get("AN_TITLE"));
			System.out.println("내용  : " + board.get("AN_CONTENT"));
			System.out.print("작성자  : " + board.get("AN_USER") + "\t");
			System.out.println("\t작성일 : " + board.get("AN_DATE"));
			System.out.println("─────────────────────────────────────");

			System.out.print("< 1.수정  2.삭제  9.로그아웃 0.목록 >");
			int update = ScanUtil.nextInt();

			switch (update) {
			case 1:
				return View.BOARD_ADMININSERT;
			case 2:
				return View.BOARD_ADMINDELETE;
			case 9: //로그아웃
				Controller.loginMember = null;
				return View.HOME;
			case 0:
				return View.BOARD_ADMINVIEW;
		}
		return View.BOARD_ADMINVIEW;
	}

	// 게시글 조회 후 수정
	public int boardInsert() {
		System.out.println("수정할 항목을 입력해주세요.");
		System.out.println("1.제목\t2.내용\t3.제목과 내용");
		int insert = ScanUtil.nextInt();
		if (insert == 1) {
			System.out.println("────────────── [ 수정 해주세요 ] ──────────────");
			System.out.print("제목>");
			String title = ScanUtil.nextLine();

			int change = adminboardDao.insert(adminBoardNo, title);
			
			if(0 < change) {
				System.out.println("수정완료");
			}else {
				System.out.println("수정실패ㅠㅠ");
				
			}
			
	
		} else if (insert == 2) {
			System.out.println("────────────── [ 수정 해주세요 ] ──────────────");
			System.out.print("내용>");
			String content = ScanUtil.nextLine();

			int change = adminboardDao.insert2(adminBoardNo, content);
			
			if(0 < change) {
				System.out.println("수정완료");
			}else {
				System.out.println("수정실패ㅠㅠ");
				
			}

		} else if (insert == 3) {
			System.out.println("────────────── [ 수정 해주세요 ] ──────────────");
			System.out.print("제목>");
			String title = ScanUtil.nextLine();
			System.out.print("내용>");
			String content = ScanUtil.nextLine();

			int change = adminboardDao.insert3(adminBoardNo, title, content);
			
			if(0 < change) {
				System.out.println("수정완료");
			}else {
				System.out.println("수정실패ㅠㅠ");
				
			}
		}
		return View.BOARD_CHECK;
	}
	
	

	// 게시글 조회 후 삭제
	public int boardDelete() {				
		System.out.println("────────────── [ 삭제 ] ──────────────");
		System.out.print("정말 삭제하시겠습니까?(Y/N)>");
		String delete = ScanUtil.nextLine();
		
		if(delete.equals("Y")|| delete.equals("y")) {
		int delete2 = adminboardDao.delete(adminBoardNo);
						
		if(0 < delete2 ) {
			System.out.println("삭제되었습니다.");
		}else {
			System.out.println("삭제에 실패하였습니다.");
			}			
		}
		return View.BOARD_ADMINVIEW;
	}

	//게시글 등록
	public int boardUpdate() {
		System.out.println("────────────── [ 새로운 글 등록하기 ] ──────────────");
		System.out.print("제목 >> ");
		String title = ScanUtil.nextLine();
		System.out.println("내용 >> ");
		String content = ScanUtil.nextLine();
		System.out.println("작성자 >> ");
		String user = ScanUtil.nextLine();
		System.out.println("직원번호 >> ");
		int empNo = ScanUtil.nextInt();
		
		Map<String, Object> param = new HashMap<>();
		param.put("AN_TITLE", title);
		param.put("AN_CONTENT", content);
		param.put("AN_USER", user);
		param.put("EMP_NO", empNo);
		
		int result = adminboardDao.update(param);
		
		if (0 < result) {
			System.out.println("게시물 등록 완료");
		} else {
			System.out.println("게시물 등록 실패");
		}

		
		
		return View.BOARD_ADMINVIEW;
	}
	
	
	
	
	// 수정 후 공지사항 확인
	public int boardCheck() {
		
		Map<String, Object> board = adminboardDao.read(adminBoardNo);
		System.out.println("─────────────────────────────────────");
		System.out.println("번호 : " + board.get("AN_NO"));
		System.out.println("제목  : " + board.get("AN_TITLE"));
		System.out.println("내용  : " + board.get("AN_CONTENT"));
		System.out.print("작성자  : " + board.get("AN_USER") + "\t");
		System.out.println("\t작성일 : " + board.get("AN_DATE"));
		System.out.println("─────────────────────────────────────");

		
		return View.BOARD_ADMINVIEW;
	}
	
}


