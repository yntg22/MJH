package service;

import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.AdminReviewBoardDao;
import util.ScanUtil;
import util.View;

public class AdminReviewBoardService {

		private AdminReviewBoardService() {}
		private static AdminReviewBoardService instance;
		public static AdminReviewBoardService getInstance() {
			if (instance == null) {
				instance = new AdminReviewBoardService();
			}
			return instance;
		}

		private AdminReviewBoardDao adminreviewboardDao = AdminReviewBoardDao.getInstance();
		
		
		public static int AdminReviewBoardNo;

		public int reviewView() {
			List<Map<String, Object>> boardList = adminreviewboardDao.reviewList();

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

			System.out.println("< 1.조회 	 9.로그아웃 0.목록 >");
			int search = ScanUtil.nextInt();

			switch (search) {
			case 1:
				return View.BOARD_REVIEW;
			
			case 9: //로그아웃
				Controller.loginMember = null;
				return View.HOME;	
			case 0:
				return View.R_TIME;
			}
			return View.BOARD_REVIEWPRINT;
		}
		
		
		
		public int reviewRead(){
			System.out.println("조회할 리뷰 번호를 입력해주세요");
			AdminReviewBoardNo = ScanUtil.nextInt();
			
			Map<String, Object> read = adminreviewboardDao.reviewRead(AdminReviewBoardNo);
			System.out.println("──────────────────────────────────────");
			System.out.println("영화제목 : " + read.get("MOVIE_NAME"));
			System.out.println("후기      : " + read.get("REVIEW_CONTENT"));
			System.out.println("작성자   : " + read.get("M_NAME"));
			System.out.println("평점 : " + read.get("REVIEW_SCORE"));
			System.out.println("──────────────────────────────────────");
			
			System.out.println("──────────────────────────────────────");
			System.out.println("< 1.리뷰강제 삭제  9.로그아웃  0.목록 >");
			int input = ScanUtil.nextInt();
			switch(input) {
			case 1:
				return View.BOARD_REVIEWDELETE;
			case 9: //로그아웃
				Controller.loginMember = null;
				return View.HOME;	
			case 0:
				return View.BOARD_REVIEWPRINT;
			}
			
			return View.BOARD_REVIEWPRINT;
		}
		
		public int reviewDelete() {
			System.out.println("게시물을 삭제 하시겠습니까? Y/N ");
			String s = ScanUtil.nextLine();
			if(s.equals("Y")||s.equals("y")) {
				int change = adminreviewboardDao.delete(AdminReviewBoardNo);
						
				if (0 < change) { 
				System.out.println("게시글 삭제처리 완료");
			}else {
				System.out.println("게시글 삭제처리 실패");
			}
			}
			return View.BOARD_REVIEWPRINT;
		}
		
		
		
		
		
		
		
		
		
}
