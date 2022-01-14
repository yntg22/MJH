package util;

public interface View {
	//값은 중복되지않는값으로 만든다?
	int HOME = 0;
	int LOGIN = 1;
	int JOIN = 2;
	int BOARD_LIST = 3; 
	int BOARD_VIEW = 4;
	int BOARD_INSERT = 5;
	int BOARD_AMEND = 6;
	int BOARD_DELETE = 7;
	int R_TIME = 8;
	
	//관리자
	int BOARD_ADMIN = 100;
	int MOVIE_ADMIN = 101;
	int SCREEN_ADMIN = 102;
	
	
	int SCREEN_SET = 200; //상영관설정
	int SCREEN_PLUS = 201; //상영관추가하기
	int SEAT_SET=202;//좌석설정
	int TIMETABLE_SET = 300; //상영시간설정
	int RTIME_SET = 301; //회차추가
	
	int PRICE_SET = 400;
	int MAINPRICE_SET = 401;
	int SALEPRICE_SET = 402;
	
	int USER_TIKETING = 500;
	int USER_MOVIEINFO = 501;
	int TICKETING = 502;
	
	
	//강정윤
	 //유저
	   int INFO_USER = 90;
	   int USER_VIEW = 91;
	   int USER_MOVIE = 92;
	   int USER_BOOK = 93;
	   
	   //관리자
	   int BOARD_ADMIN = 100;
	   int MOVIE_ADMIN = 110;
	   int MOVIE_VIEW = 111;
	   int MOVIE_INSERT = 112;
	   int MOVIE_UPDATE = 113;
	   int MOVIE_DELETE = 114;
	   int SCREEN_ADMIN = 102;
}
