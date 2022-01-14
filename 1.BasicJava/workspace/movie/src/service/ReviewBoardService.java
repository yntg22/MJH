package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.ReviewBoardDao;
import util.ScanUtil;
import util.View;

public class ReviewBoardService {
	
	private ReviewBoardService() {}
	private static ReviewBoardService instance;
	public static ReviewBoardService getInstance() {
		if (instance == null) {
			instance = new ReviewBoardService();
		}
		return instance;
	}
	
	private ReviewBoardDao reviewBoardDao = ReviewBoardDao.getInstance();
	
	//리뷰 출력
			public int boardList() {
				List<Map<String, Object>> boardList = reviewBoardDao.boardList();
				System.out.println("──────────────────── MOVIE REVIEW ───────────────────────");
				System.out.println("번호\t영화제목\t\t\t작성자\t작성일자\t평점");
				System.out.println("─────────────────────────────────────────────────────────");

				for (int i = 0; i < boardList.size(); i++) {
					Map<String, Object> board = boardList.get(i);
					System.out.print(board.get("REVIEW_NO") + "\t");
					System.out.print(board.get("MOVIE_NAME") + "\t\t");
					System.out.print(board.get("M_NAME") + "\t");
					System.out.print(board.get("REVIEW_DATE") + "\t");
					System.out.println(board.get("REVIEW_SCORE") + " / 5.0\t");

				}
				System.out.println("─────────────────────────────────────────────────────────");

				System.out.println("< 1.조회 2.등록 9.로그아웃 0.목록 >");
				int search = ScanUtil.nextInt();

				switch (search) {
				case 1 :
					return View.BOARD_REVIEWVIEW;
				case 2 :
					return View.BOARD_REVIEWINSERT;
				case 9 :
					Controller.loginMember = null;
					return View.HOME;	
				case 0 :
					return View.WINDOW;
				}
				
				return View.WINDOW;
				
			}
			
			public static int boardNo;
			
			
	//리뷰 조회 
	public int boardView() {
		System.out.println("조회하실 리뷰 번호를 입력해주세요 > ");
		boardNo = ScanUtil.nextInt();
		
		Map<String, Object> view = reviewBoardDao.boardView(boardNo);
		System.out.println("──────────────────────────────────────");
		System.out.println("영화제목  : " + view.get("MOVIE_NAME"));
		System.out.println("후기  : " + view.get("REVIEW_CONTENT"));
		System.out.print("작성자  : " + view.get("M_NAME") + "\t");
		System.out.println("\t작성일 : " + view.get("REVIEW_DATE"));
		System.out.println("──────────────────────────────────────");

		System.out.print("< 1.수정   9.로그아웃 0.목록 >");
		int update = ScanUtil.nextInt();

		switch (update) {
			case 1:
			 return View.BOARD_REVIEWAMEND;
			
			case 9: //로그아웃
			 Controller.loginMember = null;
			 return View.HOME;
			case 0:
			 return View.BOARD_REVIEWLIST;
				}
			return View.BOARD_REVIEWLIST;
			}
			
			
					
	//리뷰 등록
	public int boardUpload() {
		System.out.println("──────────── [ 리뷰 등록하기 ] ────────────");
		System.out.print("영화제목 >> ");
		String title = ScanUtil.nextLine();
		System.out.println("후기 >> ");
		String content = ScanUtil.nextLine();
//		System.out.println("작성자 >> ");
//		String user = ScanUtil.nextLine();
		Object user = Controller.loginMember.get("M_NAME");
		System.out.println("평점 >> ");
		String score = ScanUtil.nextLine();
			
		Map<String, Object> param = new HashMap<>();
		param.put("MOVIE_NAME", title);
		param.put("REVIEW_CONTENT", content);
		param.put("M_NAME", user);
		param.put("REVIEW_SCORE", score);
			
				
		int result = reviewBoardDao.update(param);
		
		if (0 < result) {
			System.out.println("게시물 등록 완료");
		} else {
			System.out.println("게시물 등록 실패");
		}
		return View.BOARD_REVIEWLIST;
		}
			
	
	//리뷰 수정
	
	public int boardInsert() {
		Object name = Controller.loginMember.get("M_NAME");
				
		Map<String, Object> view = reviewBoardDao.boardView(boardNo);
		Object boardName = view.get("M_NAME");
		if(boardName.equals(name)) {
					
				
		System.out.println("후기를 수정해주세요.");
		String content = ScanUtil.nextLine();
		int change = reviewBoardDao.insert(boardNo, content);
		if(0 < change) {
			System.out.println("리뷰 수정 완료");
		}else {
			System.out.println("리뷰 수정 실패");
		}
		}else {
			System.out.println("사용자와 동일인이 아닙니다. 삭제하실 수 업습니다.");
		}
		return View.BOARD_REVIEWLOOK;
		}
	
	//수정후 화면 출력
	public int boardLook() {
		Map<String, Object> view = reviewBoardDao.boardView(boardNo);
		System.out.println("──────────────────────────────────────");
		System.out.println("제목  : " + view.get("MOVIE_NAME"));
		System.out.println("내용  : " + view.get("REVIEW_CONTENT"));
		System.out.print("작성자  : " + view.get("M_NAME") + "\t");
		System.out.println("\t작성일 : " + view.get("REVIEW_DATE"));
		System.out.println("──────────────────────────────────────");
		return View.BOARD_REVIEWLIST;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
