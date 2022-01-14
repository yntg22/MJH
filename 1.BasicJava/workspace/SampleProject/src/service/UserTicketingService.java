package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.AdminScreenDao;
import dao.UserTicketingDao;
import util.ScanUtil;
import util.View;

public class UserTicketingService {
	
	private UserTicketingService() {}
	private static UserTicketingService instance;
	public static UserTicketingService getInstance() {
		if (instance == null) {
			instance = new UserTicketingService();
		}
		return instance;
	}
	
	private UserTicketingDao userticketingdao = UserTicketingDao.getInstance(); //screendao 연결
	/*
	 * 1.상영중인 영화
	 * 2.예매하기
	 * 
	 * 1. 상영중인 영화
	 * 	영화 1 ~
	 *  영화 2 ~
	 *  영화 3 ~
	 *  영화 4 ~
	 *  
	 *  조회할 영화 이름 :
	 *  영화 1
	 *  감독
	 *  출연진
	 *  줄거리
	 *  리뷰
	 *  1.리뷰보기 2.예매하러가기
	 *  
	 * 2.예매하기
	 * 	영화선택 :
	 *  
	 *  상영스케줄 출력
	 *  R_TIME ~  WHERE MOVIE_NAME = ? 
	*/
		
	public int userticketing() {
		System.out.println("1.상영중인 영화 2.예매하기");
		int input = ScanUtil.nextInt();
		switch(input) {
		case 1:
			return View.USER_MOVIEINFO;
		case 2:
			return View.TICKETING;
		}
		
		return View.USER_TIKETING;
		
	}
	
	public int usermovieinfo() { //상영중인 영화
		System.out.println("현재 상영중인 영화");
		
		List<Map<String,Object>> movieselect = userticketingdao.movieinfo();
		
		for(int i = 0; i < movieselect.size(); i++) {
			Map<String,Object> movielist = movieselect.get(i);
			System.out.print("영화번호: "+movielist.get("MOVIE_NO")+"\t");
			System.out.print("영화제목: "+movielist.get("MOVIE_NAME")+"\t");
			System.out.print("러닝타임: "+movielist.get("MOVIE_TIME")+"\t");
			System.out.print("영화감독: "+movielist.get("MOVIE_PD")+"\n");
		}
		System.out.println("자세히보고 싶은 영화번호 : ");
		int input = ScanUtil.nextInt();
		Map<String,Object> details = userticketingdao.moviedetails(input);
		
		System.out.print("영화번호: "+details.get("MOVIE_NO")+"\t");
		System.out.print("영화제목: "+details.get("MOVIE_NAME")+"\t");
		System.out.print("러닝타임: "+details.get("MOVIE_TIME")+"\t");
		System.out.print("영화감독: "+details.get("MOVIE_PD")+"\n");
		System.out.print("상영기간: "+details.get("MOVIE_TERM")+"\t");
		System.out.print("출연진: "+details.get("MOVIE_ACTER")+"\n");
		System.out.print("줄거리: "+details.get("MOVIE_SUMMARY")+"\n");
		
		System.out.println("1.리뷰보기 2.예매하러가기");
		ScanUtil.nextInt();

		
		return View.USER_TIKETING;
	}
	
	
	public int ticketing() {
		List<Map<String,Object>> movielist = userticketingdao.selectMovieList2();
		
		if(movielist.size() != 0) {
			for(int i = 0; i < movielist.size(); i++) {
			Map<String,Object> mmap = movielist.get(i);
			System.out.print(mmap.get("MOVIE_NO")+"\t");	
			System.out.print(mmap.get("MOVIE_NAME")+"\n");
			}
			}else {
				System.out.println("없음");
			}
			System.out.println("영화 번호 선택 : ");
			int movieno = ScanUtil.nextInt();
			List<Map<String,Object>> rtimelist = userticketingdao.rtimeselect(movieno);
			
			for(int i = 0; i < rtimelist.size(); i++) {
				Map<String,Object> timelist = rtimelist.get(i);
				System.out.print("상영번호: "+timelist.get("TIME_NO")+"\t");
				System.out.print("시작시간: "+timelist.get("TIME_START")+"\t");
				System.out.print("종료시간: "+timelist.get("TIME_END")+"\t");
				System.out.print("영화제목: "+timelist.get("MOVIE_NAME")+"\t");
				System.out.print("상영관번호: "+timelist.get("SC_NO")+"\n");
			}
			
			System.out.println("예약할 상영번호 : ");
			int timeno = ScanUtil.nextInt();
			int re = ticketinfo(timeno);
			
			/*
			 * 상영번호 선택하면 
			 * 상영번호에 있는 상영관 > 상영관 좌석출력하는데,
			 * 예약좌석 테이블에 티켓번호,좌석번호로
			 * 
			 * 좌석상태가 없는데 좌석이 예약이 가능한지 여부
			 * 티켓번호+좌석번호 
			 * 상영번호4번에서 상영관번호를 찾아서(4)
			 * 좌석번호에서 상영관번호가 4인 좌석번호들을 찾고,
			 * 
			 * 티켓번호1의 상영번호로 들어가서 상영관 번호3으로 들어가서  좌석번호A1 
			 * 예약좌석에서
			 * 티켓번호 1과 티켓좌석번호A1
			 * 
			 * 
			 * 
			 * 예약할 상영번호 입력받아서
			 * 티켓정보창으로 넘어가야함
			 * 그런데 예약할 상영번호도 같이 가져가야함
			*/
		return re;
	}
	
	
	public int ticketinfo(int timeno) {
		/*
		 * 
		 * 예약할 상영번호를 파라미터로 받았다.
		 * 그러면 좌석선택을 하고,
		 * 최종결제금액을 보여주고,
		 * 최종결정이 끝나면
		 * 티켓에 정보가 입력되고 끝?
		 * 티켓창
		 *    영화 입장권 구매
		 * ------------------------
		 * 티켓번호 : 1 
		 * 영화정보 : 아바타 
		 * 2021-12-10(금)
		 * 14:00 - 16:00
		 * 1.좌석선택			
		 * 
		 * 좌석 선택까지 하고나면
		 * 다시한번 좌석까지 추가된 화면을 보여주면서,
		 * 결제가격, 사용마일리지, 발행일까지
		 * 모든정보가 나오고,
		 * 1.예약완료하기 2.첫화면으로 돌아가기
		 */
		
		System.out.println(":::::::영화 입장권 구매:::::::::");
		System.out.println("--------------------------");
		/*DB에서 상영정보를 가져와야한다.
		  
		*/
		Map<String,Object> info = userticketingdao.rtimeinfo(timeno);
		System.out.println("영화이름: " + info.get("MOVIE_NAME"));
		System.out.println("상영시간 : " + info.get("TIME_START") + " ~ " + info.get("TIME_END"));
		
		System.out.println("1.좌석선택 2.돌아가기");
		int input = ScanUtil.nextInt();
		switch(input) {
		case 1:
			//리턴받을 어레이리스트 생성
			List<String> seat = new ArrayList<>();
			
			seat = seatselect(timeno);
			System.out.print("선택한 좌석 : ");
			for(int i = 0; i < seat.size(); i++) {
				System.out.print(seat.get(i)+"\t");
			}
			System.out.println();
			//결제가격 가져와야함
			//나이계산해서 참이면 맞는값 가져오고
			//좌석 요금 가져오고
			
			Map<String,Object> dcost = userticketingdao.defaultcost(); //기준가격
			int result = Integer.parseInt(String.valueOf(dcost.get("P_COST")));
			
			//나이할인
			Map<String,Object>userage = userticketingdao.userage(Controller.loginMember.get("M_ID"));
			int age = Integer.parseInt(String.valueOf(userage.get("AGE")));

			String pname = "";
			Map<String,Object> agesale = new HashMap<>();
			if(age<19) {
				pname = "청소년할인";
				agesale = userticketingdao.agesale(pname);
			}
			else if(age > 60) {
				pname = "노인할인";
				agesale = userticketingdao.agesale(pname);
			}
			
			if(agesale.size() != 0) {
				result -= Integer.parseInt(String.valueOf(agesale.get("P_COST")));
			}
			
			//좌석요금
			Map<String,Object> seatsale = new HashMap<>();
			seatsale = userticketingdao.seatsale(seat.get(0),timeno);
			if(seatsale != null) {
				result -= Integer.parseInt(String.valueOf(seatsale.get("SEAT_CHARGE")));	
			}
			
			System.out.println("결제 가격 : " + result);
			System.out.println("결제 방법 : 현금");
			System.out.println("1.예약완료하기 2.첫화면으로 돌아가기");
			//예약완료 누르면 끝 DB에 저장....
			
			int last = ScanUtil.nextInt();
			switch(last) {
		case 1:
			int mno =Integer.parseInt(String.valueOf(Controller.loginMember.get("M_NO")));
			System.out.println(mno);
			int ticket = userticketingdao.laststep(timeno, mno, result,seat);
			System.out.println(ticket + "::::::::::::예매완료::::::::::");
			return View.USER_TIKETING;
		case 2:
			}
		
			
		
			
		}
		
		return View.USER_TIKETING;
	}
	
	//영화 예매, 선택 후 좌석선택 화면
	public List<String> seatselect(int timeno) {
		List<Map<String, Object>> seatList = userticketingdao.seatselect(timeno);
		System.out.println("□ : 선택가능 좌석 \n■ : 이미 예약된 좌석");
		for (int i = 0; i < seatList.size(); i++) {
			Map<String, Object> seat = seatList.get(i);
			System.out.print(seat.get("SEAT_NAME")+"\t");
			
			String str = (String)seat.get("SEAT_NAME"); //보여준 좌석번호를  저장
			
			if(i+1 < seatList.size()) {
			Map<String, Object> seat2 = seatList.get(i+1); //
			String str2 = (String)seat2.get("SEAT_NAME"); //다음에 보여줄 좌석번호를 저장
			if(str.substring(0,1).equals(str2.substring(0,1))) {
				
			}else{
				System.out.print("("+seat.get("SEAT_CHARGE")+"원)");
				System.out.println();
			//A
			}
			}
		}
		System.out.print("("+seatList.get(seatList.size()-1).get("SEAT_CHARGE")+"원)"); //마지막줄 가격
		
		System.out.println();
		System.out.println("인원 입력 : ");
		int count = ScanUtil.nextInt();
		
		List<String> seat = new ArrayList<>();
		//입력받은 인원만큼 for문이 돌아서 seat리스트에 저장 후 리턴한다
		for(int i = 0 ; i < count; i ++) {
			System.out.println();
			System.out.println("선택할 좌석 이름 : ");
			String seatone = ScanUtil.nextLine();
			seat.add(seatone);
		}
		return seat;
		
		
		//모든 좌석을 보여주되,
		//예약된좌석은 ■ 을 붙여서 보여주고싶다.
	}
	
	
	

	
}
		