package util;

public interface View {
	//값은 중복되지않는값으로 만든다?
	int HOME = 0;
	int LOGIN = 1;
	int JOIN = 2;
//	int BOARD_LIST = 3; 
//	int BOARD_VIEW = 4;
//	int BOARD_INSERT = 5;
//	int BOARD_AMEND = 6;
//	int BOARD_DELETE = 7;
	int R_TIME = 3; //관리자첫화면
	
	//관리자
	int BOARD_ADMIN2 = 4; //admin 1번게시판
	int MOVIE_ADMIN = 5; //admin 2번영화관리
	int SCREEN_ADMIN = 6;//admin 3번상영관관리
	
	//1.게시판관리 2.영화관리 3.상영관관리

	
	int SCREEN_SET = 7; //상영관설정
	int SCREEN_PLUS = 8; //상영관추가하기
	int SEAT_SET=9;//좌석설정
	int TIMETABLE_SET = 10; //상영시간설정
	int RTIME_SET = 11; //회차추가
	
	int PRICE_SET = 12;
	int MAINPRICE_SET = 13;
	int SALEPRICE_SET = 14;
	
	int USER_TIKETING = 15;
	int USER_MOVIEINFO = 16;
	int TICKETING = 17;
	
	
	//강정윤
	 //유저
	   int INFO_USER = 18;
	   int USER_VIEW = 19;
	   int USER_MOVIE = 20;
	   int USER_BOOK = 21;
	   
	   //관리자
	  
	   int MOVIE_VIEW = 22;
	   int MOVIE_INSERT = 23;
	   int MOVIE_UPDATE = 24;
	   int MOVIE_DELETE = 25;
	 
	   
	   //노현정
	  
	   //문의게시판
	   int BOARD_LIST = 26; //문의 게시글 목록 출력
	   int BOARD_VIEW = 27; //문의게시글 조회 
	   int BOARD_INSERT = 28; //문의게시글 등록
	   int BOARD_AMEND = 29; //문의게시슬 수정
	   int BOARD_DELETE = 30; //문의게시글 삭제
	   int BOARD_LOOK = 31; //문의글 수정본 조회
	   
	   //리뷰게시판
	   int BOARD_REVIEWLIST = 32;   //리뷰 전체 출력
	   int BOARD_REVIEWVIEW = 33; //리뷰 조회
	   int BOARD_REVIEWINSERT = 34; // 리뷰 등록
	   int BOARD_REVIEWAMEND = 35; // 리뷰  수정
	   int BOARD_REVIEWLOOK = 36; //리뷰내용 수정 조회
	   
	   //공지사항 게시판 조회
	   int BOARD_ANNOUNCEMENTLIST = 37; //공지게시판 출력
	   int BOARD_ANNOUNCEMENTVIEW = 38; //공지게시판 조회
	   
	   //유실물 게시판 조회
	   int BOARD_LOSTLIST = 39; //분실물게시판 출력
	   
	   
	   
	   //관리자 로그인과 초기화면
	   int ADMINBOARD = 40; //관리자 로그인 누르면 나온는 창
	   
	   int BOARD_ADMIN = 41;
	   // 1.게시판관리 2.영화관리 3.상영관관리 4.직원관리
	   
	   int BOARD_ANNOUNCEMENT = 42; 
	   
	   int WINDOW = 43;
	   
	   
	   //관리자
	   
	 
	   
	   int BOARD_ADMINVIEW = 44; //공지사항 목록 조회 
	   int BOARD_ADMINLOOK = 45; // 공지사항 조회
	    int BOARD_ADMININSERT = 46; // 공지사항 조회 -> 수정
	    int BOARD_ADMINDELETE = 47; // 공지사항 조회 -> 삭제
	    int BOARD_ADMINUPDATE = 48; // 공지사항 등록
	    int BOARD_CHECK = 49; //공지사항 수정후 화면 출력
	   
	   int BOARD_LOSTVIEW = 50; // 유실물 목록조회
	   int BOARD_LOSTINSERT = 51; // 유실물 조회 -> 수정
	   int BOARD_LOSTDELETE = 52; // 유실물 조회 -> 삭제
	   int BOARD_LOSTUPDATE = 53; // 유실물 등록
	   
	   
	   int BOARD_BOARDPRINT = 54; //문의 게시판 출력
	   int BOARD_BOARDVIEW = 55; //문의게시판 조회
	   int BOARD_BOARDRE = 56; //문의게시판 조회 -> 답변등록
	   int BOARD_BOARDDELETE = 57; //문의게시판 조회 -> 삭제
	   
	   int BOARD_REVIEWPRINT = 58; //문의 게시판 출력
	   int BOARD_REVIEW = 59; //리뷰게시판 조회
	   int BOARD_REVIEWDELETE = 60; //리뷰게시판 조회 -> 삭제
	  int EMPLOYEES_SYSTEM = 61;
	   int EMPLOYEES_NEW = 62;
	   int EMPLOYEES_PAY = 63;
	   int EMPLOYEES_LOOK = 64;
	   int EMPLOYEES_ONE = 65;
	   int EMPLOYEES_INSERT = 66;
	   int EMPLOYEES_DELETE = 67;   
		int USER_MAIN_SERVICE = 68;
		int ADMIN_LOGIN = 69;
		
}
