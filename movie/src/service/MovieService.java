package service;

import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.BoardDao;

import util.ScanUtil;
import util.View;

public class MovieService { 

	/*
	 *               어드민으로 로그인하면 나오는 첫 화면 입니다.
	 * 				 
	 * 
	*/
	//싱글톤 패턴
		private MovieService() {}
		private static MovieService instance;
		public static MovieService getInstance() {
			if (instance == null) {
				instance = new MovieService();
			}
			return instance;
		}
		
		private BoardDao boardDao = BoardDao.getInstance();
		public int MovieList() {

			
			
			System.out.println("1.게시판관리 2.영화관리 3.상영관관리");
			
			
			int input = ScanUtil.nextInt();
			
			
			switch(input) {
			case 1:  
				return View.BOARD_ADMIN; //1번 선택시 게시판관리 화면으로 이동합니다.
			case 2: 
				return View.MOVIE_ADMIN; //2번 선택시 영화관리 화면으로 이동합니다.
			case 3:
				return View.SCREEN_ADMIN; //3번 선택시 상영관리 화면으로 이동합니다.
				
			case 0: 
				Controller.loginMember = null;
				return View.HOME;
			}
			
			return View.BOARD_LIST;
		}
}
