package service;

import controller.Controller;
import util.ScanUtil;
import util.View;

public class UserMainService {

	private UserMainService() {}
	private static UserMainService instance;
	public static UserMainService getInstance() {
		if (instance == null) {
			instance = new UserMainService();
		}
		return instance;
	}
	
	public int userMainList() {
		System.out.println("════════════════ ೋღ 🌸 ღೋ ══════════════");
		System.out.println("　　　　　　　　　　　　"+Controller.loginMember.get("M_NAME")+"님 환영합니다");
		System.out.println("　　　　　　　　　　　　　회원번호 : "+Controller.loginMember.get("M_NO"));
		System.out.println("════════════════ ೋღ 🌸 ღೋ ══════════════");
		System.out.println("1.게시판 2.예매하기 3.예매확인 4.내정보");
		
		
		int input = ScanUtil.nextInt();
		
		
		switch(input) {
		case 1:  
			return View.WINDOW; //1번 선택시 유저 게시판화면으로 이동합니다.
		case 2: 
			return View.USER_TIKETING; //2번 선택시 유저예매 화면으로 이동합니다.
		case 3:
			return View.USER_MOVIE;
		case 4:
			return View.USER_VIEW; //3번 선택시 유저내정보 화면으로 이동합니다.
			
		case 0: 
			Controller.loginMember = null;
			return View.HOME;
		}
		
		return View.BOARD_LIST;
	}
	
}
