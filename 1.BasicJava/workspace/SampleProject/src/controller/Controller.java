package controller;

import java.util.Map;

import service.AdminBoardService;
import service.AdminMovieService;
import service.AdminScreenService;
import service.BoardService;
import service.MovieService;
import service.UserService;
import service.UserTicketingService;
import util.ScanUtil;
import util.View;

public class Controller {

	public static void main(String[] args) {
		/*
		 * 발표내용 : 조 소개 > 주제 소개 > 주제 선정 배경 > 메뉴 구조 > 시연 > 프로젝트 후기
		 * 발표인원 : 발표자 1명, ppt 및 시연 도우미 1명
		 * 
		 * Controller : 화면 이동
		 * Service : 화면 기능 /화면출력? 컨트롤러에서 호출
		 * Dao : 쿼리 작성  쿼리중복사용을위해 
		 * 
		*/
		
		new Controller().start();
	}
	
	public static Map<String, Object> loginMember; //로그인한 사람을 저장하기위한 변수
	
	private UserService userService = UserService.getInstance();
	private BoardService boardService = BoardService.getInstance();
	private MovieService movieService = MovieService.getInstance();
	
	private AdminMovieService adminmovieservice = AdminMovieService.getInstance();
	private AdminBoardService adminboardservice = AdminBoardService.getInstance();
	private AdminScreenService adminscreenservice = AdminScreenService.getInstance();
	
	private UserTicketingService userticketingservice = UserTicketingService.getInstance();
	
	private void start() {
		int view = View.HOME;
		
		while(true) {
			switch (view) {
			case View.HOME: 
				view = home();
				break;
			case View.JOIN: //회원가입
				view = userService.join();
				break;
			case View.LOGIN:
				view = userService.login();
				break;
			case View.BOARD_LIST: //게시글 목록
				view = boardService.boardList();
				break;
			case View.BOARD_VIEW: //조회
				view = boardService.boardView();
				break;
			case View.BOARD_INSERT: //등록
				view = boardService.boardInsert();
				break;
				
			case View.R_TIME:  //어드민 로그인 화면으로 이동
				view = movieService.MovieList();
				break;
//			case View.BOARD_ADMIN: //어드민게시판관리화면
//				view = 
//				break;
//			case View.MOVIE_ADMIN: //어드민 영화관리
//				view =
//				break;
			case View.SCREEN_ADMIN: //어드민 상영관리
				view = adminscreenservice.AdminScreen();
				break;
			case View.SCREEN_SET: //상영관관리
				view = adminscreenservice.screenSet();
				break;
			case View.SCREEN_PLUS: //상영관추가하기
				view = adminscreenservice.screenPlus();
				break;
			case View.SEAT_SET: //좌석
				view = adminscreenservice.seatSet();
				break;
			case View.PRICE_SET: //관람료설정
				view = adminscreenservice.priceSet();
				break;
			case View.MAINPRICE_SET:
				view = adminscreenservice.mainPriceSet();
				break;
			case View.SALEPRICE_SET:
				view = adminscreenservice.salePriceSet();
				break;
			case View.TIMETABLE_SET:
				view = adminscreenservice.timetableSet();
				break;
			case View.RTIME_SET:
				view = adminscreenservice.rtimeset();
				break;
			case View.USER_TIKETING:
				view = userticketingservice.userticketing();
				break;
			case View.USER_MOVIEINFO:
				view = userticketingservice.usermovieinfo();
				break;
			case View.TICKETING:
				view = userticketingservice.ticketing();
			}
		}
		
	}

	private int home() {
		System.out.print("1.로그인  2.회원가입 3.무비서비스 4.회원서비스  0.프로그램 종료>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1:
			return View.LOGIN; //메서드 직접호출 X 화면이꼬인다? 리턴만해라
		case 2:
			return View.JOIN;
		case 3:
			return View.R_TIME;
		case 4:
			return View.USER_TIKETING;
		case 0:
			System.out.println("프로그램이 종료되었습니다.");
			System.exit(0);
		}
		return View.HOME;
	}
	
}
