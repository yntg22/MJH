package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.UserMovieDao;
import util.ScanUtil;
import util.View;

public class UserMovieService {
	
	private UserMovieService() {}
	private static UserMovieService instance;
	public static UserMovieService getInstance() {
		if (instance == null) {
			instance = new UserMovieService();
		}
		return instance;
	}
	
	private UserMovieDao userMovieDao = UserMovieDao.getInstance();
	
	
	   //정보 조회
	   public int userView() {
	      System.out.println("회원번호를 입력해주세요>");
	      int userNo = ScanUtil.nextInt();
	      
	      Map<String, Object> user = userMovieDao.userInfoView(userNo);
	      System.out.println("───────────────────────────────────");
	      System.out.println("회원 번호 : " + user.get("M_NO") + "\t");
	      System.out.println("회원 이름 : " + user.get("M_NAME") + "\t");
	      System.out.println("생일 : " + user.get("M_BIR") + "\t");
	      System.out.println("전화번호 : " + user.get("M_HP") + "\t");
	      System.out.println("아이디 : " + user.get("M_ID") + "\t");
	      System.out.println("비밀번호 : " + user.get("M_PASS") + "\t");
	      System.out.println("───────────────────────────────────");
	      
	      System.out.print("1.수정 2.탈퇴 0.돌아가기>");
	      int input = ScanUtil.nextInt();
	   
	      switch(input){
	      case 1:
		      System.out.println("───────────────────────────────────");
	         System.out.println("수정할 번호를 눌러주세요");
		      System.out.println("───────────────────────────────────");
	         System.out.println("1.회원이름\t2.전화번호\t3.비밀번호\t0.취소");
		      System.out.println("───────────────────────────────────");
	         System.out.println("번호 입력>");
	         int num = ScanUtil.nextInt();
	         
	         if(num == 1) {
	            System.out.println("이름 수정>");
	            String name = ScanUtil.nextLine();
	   
	            int change = userMovieDao.updateName(userNo, name);
	            
	            if(0 < change) {
	                  System.out.println("수정완료");
	               }else {
	                  System.out.println("수정실패");   
	               }
	         }
	         
	         if(num == 2) {
	            System.out.println("전화번호 수정>");
	            String hp = ScanUtil.nextLine();
	   
	            int change = userMovieDao.updateHP(userNo, hp);
	            
	            if(0 < change) {
	                  System.out.println("수정완료");
	               }else {
	                  System.out.println("수정실패");   
	               }
	         }
	   
	         
	         if(num == 3) {
	            System.out.println("비밀번호 수정>");
	            String pass = ScanUtil.nextLine();
	   
	            int change = userMovieDao.updatePass(userNo, pass);
	            
	            if(0 < change) {
	                  System.out.println("수정완료");
	               }else {
	                  System.out.println("수정실패");   
	               }
	         }
	         
	         if(num == 0) {
	            System.out.println("취소되었습니다.");
	            
	         }
	         return View.USER_MAIN_SERVICE;
	         
	      case 2:
	         System.out.println("정말 탈퇴하시겠습니까?(Y/N)>");
	         String del = ScanUtil.nextLine();
	         
	         switch(del) {
	         case "Y":
	            int result = userMovieDao.deleteUser(userNo);
	            System.out.println("탈퇴 되었습니다.");
	            break;
	            
	         case "N":
	            System.out.println("취소되었습니다.");
	            return View.USER_MAIN_SERVICE;
	            
	         }
	         return View.USER_MAIN_SERVICE;
	         
	         
	      case 0:
	         return View.USER_MAIN_SERVICE;
	   }
	      return View.USER_MAIN_SERVICE;

	   }
	   
	   
	   //예매내역 목록
	   public int userMovieList() {
	      

	      List<Map<String, Object>> usermovieList = userMovieDao.userMovieList(Controller.loginMember.get("M_NO"));
	      System.out.println("╭─────────────────────────────────╮");
	      System.out.println("|번호　　　　　제목　　　　　날짜　　　　　　　 　  |");
	      System.out.println("╰─────────────────────────────────╯");
	      for (int i = 0; i < usermovieList.size(); i++) {
	         Map<String, Object> board = usermovieList.get(i);
	         System.out.print(board.get("T_NO") + "\t");
	         System.out.print(board.get("MOVIE_NAME") + "\t");
	         System.out.println(board.get("TIME_START"));
	      }
	      System.out.println("───────────────────────────────────");
	      
	      System.out.print("1.조회 0.뒤로가기>");
	      int input = ScanUtil.nextInt();
	      
	      switch(input) {
	      case 1:
	         //조회
	         return View.USER_BOOK;
	         
	      case 0:
	         //뒤로가기
	         return View.USER_MAIN_SERVICE;
	      }
	   
	      return View.USER_MAIN_SERVICE;
	   
	   }
	   
	   
	   //예매내역 조회
	   public int userBookView() {
	      System.out.println("조회할 예매번호를 입력해주세요>");
	      int bookNo = ScanUtil.nextInt();
	      
	      Map<String, Object> booking = userMovieDao.userBookView(bookNo);
	      System.out.println("───────────────────────────────────");
	      System.out.println("티켓 번호 : " + booking.get("T_NO") + "\t");
	      System.out.println("영화 이름 : " + booking.get("MOVIE_NAME") + "\t");
	      System.out.println("극장 : 대전CGV"  + "\t");
	      System.out.println("관람 일시 : " + booking.get("TIME_START") + "\t");
	      System.out.println("상영관 : " + booking.get("SC_NAME") + "\t");
	      System.out.println("좌석 : " + booking.get("SEAT_NAME") + "\t");
	      System.out.println("인원수 : " + booking.get("SEAT_NO") + "명");
	      System.out.println("───────────────────────────────────");
	      
	      System.out.print("1.취소하기 0.돌아가기>");
	      int del = ScanUtil.nextInt();
	      
	      switch(del) {
	      case 1:
	         System.out.println("정말 취소하시겠습니까?(Y/N)>");
	         String c = ScanUtil.nextLine();
	         
	         switch(c) {
	         case "Y":
	            SimpleDateFormat format = new SimpleDateFormat ( "yyyy년 MM월dd일 HH시mm분ss초");
	            Date time = new Date();
	            String time2 = format.format(time);
	            
	            Map<String, Object> cancle = userMovieDao.cancleMovie(bookNo);
	  	      System.out.println("───────────────────────────────────");
	            System.out.println("극장 : 대전CGV"  + "\t");
	            System.out.println("영화 이름 : " + cancle.get("MOVIE_NAME") + "\t");
	            System.out.println("관람 일시 : " + cancle.get("TIME_START") + "\t");
	            System.out.println("좌석 : " + cancle.get("SEAT_NAME") + "\t");
	            System.out.println("인원수 : " + cancle.get("SEAT_NO") + "명" + "\t");
	            System.out.println("환불 금액 : " + cancle.get("TOTAL_COST") + "원" + "\t");
	            System.out.println("환불 일시 : " + time2);
	  	      System.out.println("───────────────────────────────────");
	            
	            int result = userMovieDao.deleteMovie(bookNo);

	            System.out.println("예매가 취소 되었습니다.");
	            break;
	            
	            
	         case "N":
	            System.out.println("취소되었습니다.");
	            return View.USER_MOVIE;
	            
	         }
	         return View.USER_MAIN_SERVICE;
	         
	      case 0:
	         System.out.println("돌아갑니다.");
	         return View.USER_MAIN_SERVICE;
	      }
	         
	      return View.USER_MAIN_SERVICE;
	   }


	   
	   
	}