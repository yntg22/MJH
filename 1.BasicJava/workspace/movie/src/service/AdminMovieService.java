package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.AdminMovieDao;
import dao.BoardDao;
import util.ScanUtil;
import util.View;

public class AdminMovieService {

	private AdminMovieService() {}
	private static AdminMovieService instance;
	public static AdminMovieService getInstance() {
		if (instance == null) {
			instance = new AdminMovieService();
		}
		return instance;
	}
	SimpleDateFormat sDate = new SimpleDateFormat("Y년 M월 d일");
	private AdminMovieDao adminMovieDao = AdminMovieDao.getInstance();
	
	//영화목록 보기
	public int adminMovieList() {
		List<Map<String, Object>> movieList = adminMovieDao.selectMovieList();
		
		System.out.println("─────────────────────────────────────");
		System.out.println("번호\t제목\t감독\t장르\t등급");
		System.out.println("─────────────────────────────────────");
		for (int i = 0; i < movieList.size(); i++) {
			Map<String, Object> board = movieList.get(i);
			System.out.print(board.get("MOVIE_NO") + "\t");
			System.out.print(board.get("MOVIE_NAME") + "\t");
			System.out.print(board.get("MOVIE_PD") + "\t");
			System.out.print(board.get("GENRE_NAME") + "\t");
			System.out.print(board.get("RANK_NAME") + "\n");
		}
		System.out.println("─────────────────────────────────────");
		
		System.out.print("1.조회 2.등록 0.뒤로가기>");
		int input = ScanUtil.nextInt();
		
		switch(input) {
		case 1:
			//조회
			return View.MOVIE_VIEW;
					
		case 2:
			//등록
			return View.MOVIE_INSERT;
			
		case 0:
			//뒤로가기
			return View.R_TIME;
		}
	
		return View.R_TIME;
	}
	
	
	//영화 조회
	public int movieView() {
		System.out.println("조회할 영화 번호>");
		int movieNo = ScanUtil.nextInt();
		
		Map<String, Object> moive = adminMovieDao.selectMovieView(movieNo);
	    System.out.println("───────────────────────────────────");
		System.out.println("영화 번호 : " + moive.get("MOVIE_NO") + "\t");
		System.out.println("영화 제목 : " + moive.get("MOVIE_NAME") + "\t");
		System.out.println("장르 : " + moive.get("GENRE_NAME") + "\t");
		System.out.println("등급 : " + moive.get("RANK_NAME") + "\t");
		System.out.println("감독 : " + moive.get("MOVIE_PD") + "\t");
		System.out.println("출연진 : " + moive.get("MOVIE_ACTER") + "\t");
		System.out.println("줄거리 : " + moive.get("MOVIE_SUMMARY") + "\t"); //gogogogo
		System.out.println("러닝 타임 : " + moive.get("MOVIE_TIME") + "\t");
		System.out.println("상영 시작 : " + sDate.format(moive.get("MOVIE_TERM1")) + "\t");
		System.out.println("상영 종료 : " + sDate.format(moive.get("MOVIE_TERM2")) + "\t");
	    System.out.println("───────────────────────────────────");
		
		System.out.print("1.수정 2.삭제 0.목록>");
		int input = ScanUtil.nextInt();
		
		switch(input){
		case 1:
		    System.out.println("───────────────────────────────────");
			System.out.println("수정할 번호를 눌러주세요");
		    System.out.println("───────────────────────────────────");
			System.out.println("1.제목\t 2.장르\t 3.등급");
			System.out.println("4.감독\t 5.배우\t 6.내용");
			System.out.println("7.시간\t 8.시작\t 9.종료");
		    System.out.println("───────────────────────────────────");
			System.out.println("번호 입력>");
			int num = ScanUtil.nextInt();
			
			if(num == 1) {
				System.out.println("제목 수정>");
				String title = ScanUtil.nextLine();

				int change = adminMovieDao.updateTitle(movieNo, title);
				
				if(0 < change) {
			         System.out.println("수정완료");
			      }else {
			         System.out.println("수정실패ㅠㅠ");   
			      }
			}
			
			if(num == 2) {
				System.out.println("장르 수정>");
				String genre = ScanUtil.nextLine();
				
				int change = adminMovieDao.updateGenre(movieNo, genre);
				
				if(0 < change) {
			         System.out.println("수정완료");
			      }else {
			         System.out.println("수정실패");   
			      }
			}
			
			if(num == 3) {
				System.out.println("등급 수정>");
				String rank = ScanUtil.nextLine();
				
				int change = adminMovieDao.updateRank(movieNo, rank);
				
				if(0 < change) {
			         System.out.println("수정완료");
			      }else {
			         System.out.println("수정실패");   
			      }
			}
			
			if(num == 4) {
				System.out.println("감독 수정>");
				String pd = ScanUtil.nextLine();
				
				int change = adminMovieDao.updatePd(movieNo, pd);
				
				if(0 < change) {
			         System.out.println("수정완료");
			      }else {
			         System.out.println("수정실패");   
			      }
			}
			
			if(num == 5) {
				System.out.println("배우 수정>");
				String acter = ScanUtil.nextLine();
				
				int change = adminMovieDao.updateActer(movieNo, acter);
				
				if(0 < change) {
			         System.out.println("수정완료");
			      }else {
			         System.out.println("수정실패");   
			      }
			}
			
			if(num == 6) {
				System.out.println("내용 수정>");
				String content = ScanUtil.nextLine();
				
				int change = adminMovieDao.updateContent(movieNo, content);
				
				if(0 < change) {
			         System.out.println("수정완료");
			      }else {
			         System.out.println("수정실패");   
			      }
			}
			
			if(num == 7) {
				System.out.println("시간 수정>");
				String time = ScanUtil.nextLine();
				
				int change = adminMovieDao.updateTime(movieNo, time);
				
				if(0 < change) {
			         System.out.println("수정완료");
			      }else {
			         System.out.println("수정실패");   
			      }
			}
			
			if(num == 8) {
				System.out.println("시작 기간 수정>");
				String term1 = ScanUtil.nextLine();
				
				int change = adminMovieDao.updateTerm1(movieNo, term1);
				
				if(0 < change) {
			         System.out.println("수정완료");
			      }else {
			         System.out.println("수정실패");   
			      }
			}
			
			if(num == 9) {
				System.out.println("종료 기간 수정>");
				String term2 = ScanUtil.nextLine();
				
				int change = adminMovieDao.updateTerm2(movieNo, term2);
				
				if(0 < change) {
			         System.out.println("수정완료");
			      }else {
			         System.out.println("수정실패");   
			      }
			}
			return View.MOVIE_ADMIN;
			
			
		case 2:
			System.out.println("정말 삭제하시겠습니까?(Y/N)>");
			String del = ScanUtil.nextLine();
			
			switch(del) {
			case "Y":
				int result = adminMovieDao.deleteMovie(movieNo);
				System.out.println("삭제되었습니다.");
				
			case "N":
				System.out.println("취소되었습니다.");
				return View.MOVIE_ADMIN;
			}
			return View.MOVIE_ADMIN;
		
			
		case 0:
			return View.MOVIE_ADMIN;	
			
		}
		
		return View.R_TIME;
	}
	
	
	//영화 등록
	public int movieInsert() {
		
		System.out.println("제목 입력>");
		String title = ScanUtil.nextLine();
		System.out.println("1.다큐멘터리 2.드라마 3.액션 4.애니메이션 5.스릴러");
		System.out.println("6.코미디 7.느와르 8.로맨틱 코미디 9.판타지 10.공포");
		System.out.println("11.멜로 12.SF 13.뮤지컬 14.미스터리");
		System.out.println("장르 입력>");
		String genre = ScanUtil.nextLine();
		System.out.println("1.전체관람가 2.12세 3.15세 4.19세_청불");
		System.out.println("등급 입력>");
		String rank = ScanUtil.nextLine();
		System.out.println("감독 입력>");
		String pd = ScanUtil.nextLine();
		System.out.println("출연진 입력>");
		String acter = ScanUtil.nextLine();
		System.out.println("줄거리 입력>");
		String content = ScanUtil.nextLine();
		System.out.println("러닝타임 입력>");
		String time = ScanUtil.nextLine();
		System.out.println("상영시작 입력>");
		String term1 = ScanUtil.nextLine();
		System.out.println("상영종료 입력>");
		String term2 = ScanUtil.nextLine();
		
		Map<String, Object> param = new HashMap<>();
		param.put("MOVIE_NAME", title);
		param.put("GENRE_NO", genre);
		param.put("RANK_NO", rank);
		param.put("MOVIE_PD", pd);
		param.put("MOVIE_ACTER", acter);
		param.put("MOVIE_SUMMARY", content);
		param.put("MOVIE_TIME", time);
		param.put("MOVIE_TERM1", term1);
		param.put("MOVIE_TERM2", term2);

		int result = adminMovieDao.insertMovie(param);
		
		return View.MOVIE_ADMIN;
	}

	
	
	
	
	
	
	
	
}
