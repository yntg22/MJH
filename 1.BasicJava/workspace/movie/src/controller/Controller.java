package controller;

import java.util.Map;

import service.AdminBoardService;
import service.AdminLostBoardService;
import service.AdminMovieService;
import service.AdminReBoardService;
import service.AdminReviewBoardService;
import service.AdminScreenService;
import service.BoardService;
import service.EmployeesService;
import service.LostBoardService;
import service.MainWindowService;
import service.MovieService;
import service.ReBoardService;
import service.ReviewBoardService;
import service.UserMainService;
import service.UserMovieService;
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
	
	
	
	//강정윤

	   
	   private UserMovieService usermovieservice = UserMovieService.getInstance();
	   
	
	//노현정

	   private AdminLostBoardService lostboardservice = AdminLostBoardService.getInstance();
	   private AdminReBoardService reboardservice = AdminReBoardService.getInstance();
	   private AdminReviewBoardService reviewboardservice = AdminReviewBoardService.getInstance();
	   
	   private MainWindowService startmain = MainWindowService.getInstance();
	   private ReBoardService reboardService = ReBoardService.getInstance();
	    private ReviewBoardService reviewboardService = ReviewBoardService.getInstance();
	    private LostBoardService lostboardService = LostBoardService.getInstance();
	    private EmployeesService employeesservice = EmployeesService.getInstance();
	    private UserMainService usermainservice = UserMainService.getInstance();
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
//			case View.BOARD_LIST: //게시글 목록
//				view = boardService.boardList();
//				break;
//			case View.BOARD_VIEW: //조회
//				view = boardService.boardView();
//				break;
//			case View.BOARD_INSERT: //등록
//				view = boardService.boardInsert();
//				break;
				
			case View.R_TIME:  //어드민 로그인 화면으로 이동
				view = movieService.MovieList();
				break;
				
			case View.ADMINBOARD: //어드민 로그인 > 게시판관리?
				view = adminboardservice.boardList();
				break;
				
			case View.SCREEN_ADMIN: //민진홍 화면으로 
				view = adminscreenservice.AdminScreen(); 
				break;
			case View.ADMIN_LOGIN:
				view = userService.adminlogin();
				break;
//			case View.BOARD_ADMIN: //어드민게시판관리화면
//				view = 
//				break;
//			case View.MOVIE_ADMIN: //어드민 영화관리
//				view =
//				break;
			
	
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
				break;
				//강정윤
			 case View.USER_VIEW: //회원정보 조회
		            view = usermovieservice.userView();
		            break;
		         case View.USER_MOVIE: //예매목록
		            view = usermovieservice.userMovieList();
		            break;
		         case View.USER_BOOK:
		            view = usermovieservice.userBookView();
		            break;
		         case View.USER_MAIN_SERVICE:
		        	 view = usermainservice.userMainList();
		            break;
		         case View.MOVIE_ADMIN: //어드민 영화관리
		            view = adminmovieservice.adminMovieList();
		            break;
		         case View.MOVIE_VIEW:   //영화 조회
		            view = adminmovieservice.movieView();
		            break;
		         case View.MOVIE_INSERT:   //영화 등록
		            view = adminmovieservice.movieInsert();
		            break;
		            
		       
		         
		         case View.WINDOW:   // 로그인 후 첫 화면
		            view = startmain.mainList();
		            break;
		            
		         //문의게시판 조회 및 등록   
		         case View.BOARD_LIST: // 문의 게시판 목록 출력
		            view = reboardService.boardList();
		            break;
		         case View.BOARD_VIEW: // 조회
		            view = reboardService.boardView();
		            break;
		         case View.BOARD_INSERT: // 등록
		            view = reboardService.boardUpload();
		            break;
		         case View.BOARD_AMEND: // 수정
		            view = reboardService.boardInsert();
		            break;
		         case View.BOARD_DELETE: // 삭제
		            view = reboardService.boardDelete();
		            break;   
		         case View.BOARD_LOOK: // 문의글 수정화면
		            view = reboardService.boardLook();
		            break;   
		            
		            
		            
		            
		         //리뷰게시판 조회 및 등록   
		         case View.BOARD_REVIEWLIST: // 문의 게시판 목록 출력
		            view = reviewboardService.boardList();
		            break;
		         case View.BOARD_REVIEWVIEW: // 조회
		            view = reviewboardService.boardView();
		            break;
		         case View.BOARD_REVIEWINSERT: // 등록
		            view = reviewboardService.boardUpload();
		            break;
		         case View.BOARD_REVIEWAMEND: // 수정
		            view = reviewboardService.boardInsert();
		            break;
		         case View.BOARD_REVIEWLOOK:
		            view = reviewboardService.boardLook();
		            break;
		            
		         //공지사항게시판 조회
		         case View.BOARD_ANNOUNCEMENTLIST:
		            view = boardService.boardList();
		            break;
		         case View.BOARD_ANNOUNCEMENTVIEW:
		            view = boardService.boardView();
		            break;
		            
		              
		         //분실물 게시판 조회   
		         case View.BOARD_LOSTLIST:
		            view = lostboardService.boardList();
		            break;
		            
		            
		            
		            
		         //관리자   
		         

		         case View.BOARD_ADMIN: // 어드민게시판관리화면
		            view = adminboardservice.boardList();
		            break;
		         case View.BOARD_ANNOUNCEMENT: // 공지 목록 게시판관리화면
		            view = adminboardservice.boardList();
		            break;
		         case View.BOARD_ADMINVIEW: // 공지사항 목록 조회
		            view = adminboardservice.boardView();
		            break;
		         case View.BOARD_ADMINLOOK: // 공지사항 목록 중 선택항목 조회
		            view = adminboardservice.boardLook();
		            break;
		         case View.BOARD_ADMINUPDATE: // 공지사항 등록
		            view = adminboardservice.boardUpdate();
		            break;
		         case View.BOARD_ADMININSERT: // 공지사항 수정
		            view = adminboardservice.boardInsert();
		            break;
		         case View.BOARD_ADMINDELETE: // 공지사항 삭제
		            view = adminboardservice.boardDelete();
		            break;
		         case View.BOARD_CHECK: // 공지사항 수정화면
		            view = adminboardservice.boardCheck();
		            break;

		         // 유실물 조회
		         case View.BOARD_LOSTVIEW: // 유실물 목록 조회
		            view = lostboardservice.lostList();
		            break;

		         case View.BOARD_LOSTUPDATE: // 유실물 등록
		            view = lostboardservice.lostUpdate();
		            break;
		         case View.BOARD_LOSTINSERT: // 유실물 수정
		            view = lostboardservice.lostInsert();
		            break;
		         case View.BOARD_LOSTDELETE: // 유실물 삭제
		            view = lostboardservice.lostDelete();
		            break;

		         // 문의조회 및 답변 등록
		         case View.BOARD_BOARDPRINT:   //문의 게시판 목록 출력
		            view = reboardservice.reboardView();
		            break;
		         case View.BOARD_BOARDVIEW: // 문의게시판 조회
		            view = reboardservice.re();
		            break;
		         case View.BOARD_BOARDRE: //조회 게시물 답변 등록
		            view = reboardservice.reUpdate();
		            break;
		         case View.BOARD_BOARDDELETE: //조회 게시물 삭제
		            view = reboardservice.reboardDelete();
		            break;
		            
		   
		         // 리뷰 조회 및 삭제
		         case View.BOARD_REVIEWPRINT: //리뷰게시판 목록 출력
		            view = reviewboardservice.reviewView();
		            break;
		         case View.BOARD_REVIEW: //리뷰게시판 조회
		            view = reviewboardservice.reviewRead();
		            break;
		         case View.BOARD_REVIEWDELETE: //조회 게시물삭제
		            view = reviewboardservice.reviewDelete();
		            break;   
		            
		            
		            

//		         case View.MOVIE_ADMIN: //어드민 영화관리
//		            view =
//		            break;
//		         case View.SCREEN_ADMIN: // 어드민 상영관리
//		            view = adminscreenservice.AdminScreen();
//		            break;
		         case View.SCREEN_SET:
		            view = adminscreenservice.screenSet();
		            break;

		         //직원관리
//		         case View.EMPLOYEES_SYSTEM:
//		            view = employeesservice.employees();
//		            break;
		         case View.EMPLOYEES_NEW:
		            view = employeesservice.boardUpdate();
		            break;
		         case View.EMPLOYEES_PAY:
		            view = employeesservice.pay();
		            break;
		         case View.EMPLOYEES_LOOK:
		            view = employeesservice.look();
		            break;
		         case View.EMPLOYEES_ONE:
		            view = employeesservice.boardLook();
		            break;
		         case View.EMPLOYEES_INSERT:
		            view = employeesservice.insert();
		            break;   
		         case View.EMPLOYEES_DELETE :
		            view = employeesservice.delete();
		            break;   
		            
		     
			}
		}
		
	}

	private int home() {
		System.out.println("════════════════ ೋღ 🌸 ღೋ ══════════════");
		System.out.println();
		System.out.println("　　　■■■■■■　　　　■■■■■■　　 　  ■　　　　       ■　　");
		System.out.println("　　■　　　　　　　　■　　　　　　　 　  ■　　　　   ■　　");
		System.out.println("　　■　　　　　　　　■　　■■■■　　　　 ■　　　   ■　　");
		System.out.println("　　■　　　　　　　　■　　　　■　　　　　■　　  ■　　　");
		System.out.println("　　　■■■■■■　　　　■■■■■■　　　　　  　■■　　　");
		System.out.println("　　　　　　　　　　　　　　　　　　　　　　　　　　　");
		System.out.println("　　　　　　　　　　　　　　　　　　　　　　🎞️🎥📸📷📺📽️");
		System.out.println("════════════════ ೋღ 🌸 ღೋ ══════════════");
		
		
		System.out.print("1.로그인  2.회원가입 9.관리자로그인   0.프로그램 종료>");
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1:
			return View.LOGIN; //메서드 직접호출 X 화면이꼬인다? 리턴만해라
		case 2:
			return View.JOIN;
		case 9:
			return View.ADMIN_LOGIN;
		case 0:
			System.out.println("프로그램이 종료되었습니다.");
			System.exit(0);
		}
		return View.HOME;
	}
	
}
