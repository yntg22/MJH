package service;

import controller.Controller;
import dao.MainWindowDao;
import util.ScanUtil;
import util.View;

public class MainWindowService {

	//싱글톤 패턴
			private MainWindowService() {}
			private static MainWindowService instance;
			public static MainWindowService getInstance() {
				if (instance == null) {
					instance = new MainWindowService();
				}
				return instance;
			}
			
			private MainWindowDao main = MainWindowDao.getInstance();
			
			public int mainList() {
				System.out.println("╭────────────────────────────────────────────────╮");
				System.out.println("|1.문의게시판 2.리뷰게시판 3.공지사항 4.유실물조회 9.로그아웃 0.목록 |");
				System.out.println("╰────────────────────────────────────────────────╯");
				
				int input = ScanUtil.nextInt();
				
				
				switch(input) {
				case 1:  
					return View.BOARD_LIST; //1번 선택시 문의게시판 화면으로 이동합니다.
				case 2: 
					return View.BOARD_REVIEWLIST; //2번 선택시 리뷰게시판 화면으로 이동합니다.
				case 3:
					return View.BOARD_ANNOUNCEMENTLIST; //3번 선택시 공지사항 화면으로 이동합니다.
				case 4:
					return View.BOARD_LOSTLIST; //4번 선택시 유실물 조회화면으로 이동합니다.
				case 9: 
					Controller.loginMember = null;
					return View.HOME;
				case 0:
					return View.USER_MAIN_SERVICE;
				}
				
				return View.WINDOW;
			}
}
