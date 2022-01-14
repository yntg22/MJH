package service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.AdminScreenDao;
import dao.BoardDao;
import util.ScanUtil;
import util.View;
/*
 *  		상영관리
 *  
 * 
*/


public class AdminScreenService {

	private AdminScreenService() {}
	private static AdminScreenService instance;
	public static AdminScreenService getInstance() {
		if (instance == null) {
			instance = new AdminScreenService();
		}
		return instance;
	}
	
	private AdminScreenDao adminscreendao = AdminScreenDao.getInstance(); //screendao 연결
	
	public int AdminScreen() {
		
		System.out.print("1.상영관설정  2.관람료설정  3.상영스케줄설정  0.로그아웃>");
		
		int input = ScanUtil.nextInt();
		
		switch(input) {
		case 1:  
			return View.SCREEN_SET;
		case 2: 
			return View.PRICE_SET;
		case 3:
			return View.TIMETABLE_SET;
		case 0: 
			Controller.loginMember = null;
			return View.HOME;
		}
		
		return View.BOARD_LIST;
	}

	
	
	public int screenSet() {
		/*상영관 설정에 들어오면 
		 * CGV 대전점
		 *      
		 * 상영관이름     1상영관         2상영관        3상영관      4상영관
		 * 총좌석수	 50        50       45     30
		 * 
		 * 1.상영관 추가하기
		 * 2
		 * 
		 *    1
		 *    	상영관 이름 : 1
		 *    	한줄당 좌석 수 : 7
		 *    	몇줄 : 5
		 *    	
		 *    	상영관 이름 : 1  한줄당 좌석수 :7  총좌석수 45 맞습니까?Y/N
		 *    	insert into seat values(a[i],0);
		 *    
		 *    2.좌석별 요금설정하기
		 *      상영관 이름 : 1상영관
		 *      1상영관
		 *      	a1(0원) a2(0원) a3(0원) a4(0원) a5(0원) a6(0원) a7(0원)
		 *      	b1(0원) b2(0원) b3(0원) b4(0원) b5(0원) b6(0원) b7(0원)
		 *      	c1(0원) c2(0원) c3(0원) c4(0원) c5(0원) c6(0원) c7(0원)
		 *      요금 설정할 라인 선택 : a
		 *      a좌석의 요금 : 500
		 *     	
		 *     설정완료
		 *       1상영관
		 *      	a1(500원) a2(500원) a3(500원) a4(500원) a5(500원) a6(500원) a7(500원)
		 *      	b1(0원) b2(0원) b3(0원) b4(0원) b5(0원) b6(0원) b7(0원)
		 *      	c1(0원) c2(0원) c3(0원) c4(0원) c5(0원) c6(0원) c7(0원)
		 *    	
		 *     
		 *     
		*/


		//시작
		System.out.println("CGV 대전점\n");
		List<Map<String,Object>> screenlist = adminscreendao.selectScreenList();
		
		for (int i = 0; i < screenlist.size(); i++) {
			Map<String, Object> screen = screenlist.get(i);
			System.out.print(screen.get("SC_NAME") + "\t");
			System.out.print(screen.get("SEAT_ALL") + "\n");
		}
		
		System.out.println();
		System.out.println("1.상영관 추가하기  2.상영관 좌석요금 설정  3.돌아가기");
		int input = ScanUtil.nextInt();
		
		switch(input) {
		case 1: //상영관 추가하기
			return View.SCREEN_PLUS;
		case 2:
			return View.SEAT_SET;
		case 3:
			return View.SCREEN_ADMIN;
		}
		
		
		return View.R_TIME;
	}
	
	
	public int screenPlus() { //상영관추가하기
		System.out.println("추가할 상영관 이름 : ");
		String scname = ScanUtil.nextLine();
		System.out.println("한줄 당 좌석수 : ");
		int scseat1 = ScanUtil.nextInt();
		System.out.println("몇줄 : ");
		int scseat2 = ScanUtil.nextInt();
		int scseat = scseat1*scseat2;
		
		int result =adminscreendao.screeninsert(scname, scseat1, scseat2, scseat);
		System.out.println(result + "등록완료");
		
		return View.SCREEN_SET;
	}
	
	
	/* 2.좌석별 요금설정하기
	 *      상영관 이름 : 1상영관
	 *      1상영관
	 *      	a1(0원) a2(0원) a3(0원) a4(0원) a5(0원) a6(0원) a7(0원)
	 *      	b1(0원) b2(0원) b3(0원) b4(0원) b5(0원) b6(0원) b7(0원)
	 *      	c1(0원) c2(0원) c3(0원) c4(0원) c5(0원) c6(0원) c7(0원)
	 *      요금 설정할 라인 선택 : a
	 *      a좌석의 요금 : 500
	 */
	public int seatSet() { //좌석
		System.out.print("상영관 이름 : ");
		String scname = ScanUtil.nextLine();
		List<Map<String, Object>> seatList = adminscreendao.seatList(scname);
	
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
		System.out.println("요금 설정할 라인 입력 : ");
		String seatname = ScanUtil.nextLine();
		System.out.println(seatname+"좌석의 요금 : ");
		int money = ScanUtil.nextInt();
		
		int result = adminscreendao.seatchargeSet(scname,money,seatname);
		System.out.println(result + " 등록완료");
		
		return View.SCREEN_SET;
		
	}
	
	/*
	 * 영화요금 설정
	 * 
	 *   기준 금액 :
	 *   대상별 요금 현황
	 *   청소년할인 : 500원
	 *  1. 노인할인 : 1000원
	 *  2. 조조할인 : 500원
	 *  3. 심야할인 : 700원
	 *   
	 *   1. 기준금액변경 2.대상별 할인액 변경
	 *   
	 *   1. 변경할 기준금액 입력 : 500
	 *   2. 변경할 대상별 할인액 번호 입력 :2
	 *   	변경할 조조할인 금액 : 
	 *   
	 *   ::변경완료::
	*/
	public int priceSet() {
		System.out.println("영화요금 설정\n");
		
		Map<String, Object> mprice = adminscreendao.selectmainPrice();
		System.out.println("    기준 금액 : " + mprice.get("P_COST"));
		System.out.println("	::대상별 요금 현황::");
		List<Map<String,Object>> sprice = adminscreendao.selectsalePrice();
		for(int i = 0; i < sprice.size(); i++) {
			Map<String, Object> salep = sprice.get(i);
			System.out.println("    "+salep.get("P_NAME") + " :    \t" + salep.get("P_COST"));
		}
		System.out.println("\n1.기준금액 변경  2.대상별 할인액 변경 3.상영관관리로 돌아가기");
		int input = ScanUtil.nextInt();
		switch(input) {
		case 1 : 
			return View.MAINPRICE_SET;
		case 2 :
			return View.SALEPRICE_SET;
		case 3 :
			return View.SCREEN_ADMIN;
		}
		return View.PRICE_SET;
	}
	
	//기준금액변경
	public int mainPriceSet() {
		System.out.println("변경할 기준금액 :");
		int input = ScanUtil.nextInt();
		int result = adminscreendao.mainPirceSet(input);
		if(result > 0) {
			System.out.println("::변경완료::");
		}else {
			System.out.println("::변경실패::");
			return View.MAINPRICE_SET;
		}
		return View.PRICE_SET;
	}
	
	public int salePriceSet() {
		System.out.println("변경할 할인 이름 :");
		String sname = ScanUtil.nextLine();
		System.out.println(sname +"의 할인 금액:");
		int price = ScanUtil.nextInt();
		int result = adminscreendao.salePriceSet(sname, price);
		if(result > 0) {
			System.out.println("::변경완료::");
		}else {
			System.out.println("::변경실패::");
			return View.MAINPRICE_SET;
		}
		return View.PRICE_SET;
	}
	
	/*
	 * 상영스케줄 설정
	 * 	 
	 *   상영관 선택
	 *   1상영관 2상영관 3상영관 4상영관
	 * 	 
	 * 	 1상영관
	 *    상영번호  7  	1회차	상영시간 : 09:00 ~ 11:00 / 영화이름
	 *    상영번호 12  2회차 	상영시간 : 12:10 ~ 14:00 / 영화이름
	 *    상영번호 41  3회차 	상영시간 : 15:02 ~ 17:04 / 영화이름
	 *   
	 *   //회차 삭제 할떄 어떻게 삭제할건지만 생각해봐
	 *   
	 *   1.회차추가하기 2.회차삭제하기 3.상영영화변경
	 *   변경할 상영번호 :
	 *   상영시간 : 09:00 ~ 11:00
	 *   1.영화선택  2.상영시간 변경
	 *   
	 *   영화목록 
	 *   	1. 영화1
	 *      2. 영화2
	 *      3. 영화3
	 *      4. 영화4
	 *      
	 *   1회차 상영시간 : 09:00 ~ 11:00 / 영화1 상영
	 *   맞습니까 ? Y/N
	 *   
	 *   1회차 상영시간 : 09:00 ~ 11:00 / 영화1
	 *   2회차 상영시간 : 12:10 ~ 14:00 / 영화이름
	 *   3회차 상영시간 : 15:02 ~ 17:04 / 영화이름
	*/
	
	public int timetableSet() {
		System.out.println("상영스케줄 설정\n");
		System.out.println("상영관 선택 :");
		
		List<Map<String,Object>> screenlist = adminscreendao.selectScreenList();
		
		for (int i = 0; i < screenlist.size(); i++) {
			Map<String, Object> screen = screenlist.get(i);
			System.out.print(screen.get("SC_NAME") + "\t");
		}
		
		System.out.println("\n설정할 상영관 이름 : ");
		String scname = ScanUtil.nextLine();
		
		List<Map<String, Object>> rtimelist = adminscreendao.selectrtime(scname);
		//상영관번호저장
		
		for(int i = 0; i < rtimelist.size(); i++) {
			Map<String,Object> list = rtimelist.get(i);
			System.out.print("상영번호 " +list.get("TIME_NO")+"\t");
			System.out.print("상영시간 : "+list.get("TIME_START")+" ~ " + list.get("TIME_END") +" 영화이름 : " + list.get("MOVIE_NO")+"\n");
		}
		
		System.out.println("1.회차추가하기 2.회차삭제하기");
		int input = ScanUtil.nextInt();
		switch(input) {
		case 1 : //회차추가하기 누르면..
			System.out.println("상영시작 시간 입력  ex)2005-04-01-12:00");
			int start = ScanUtil.nextInt();
			System.out.println("상영종료 시간 입력 ex)2005-04-01-12:00");
			int end = ScanUtil.nextInt();
			//영화목록
			List<Map<String, Object>> mlist =adminscreendao.selectMovieList();
			if(mlist.size() != 0) {
			for(int i = 0; i < mlist.size(); i++) {
			Map<String,Object> mmap = mlist.get(i);
			System.out.print(mmap.get("MOVIE_NO")+"\t");	
			System.out.print(mmap.get("MOVIE_NAME")+"\n");
			}
			}else {
				System.out.println("없음");
			}
			System.out.println("영화 번호 선택 : ");
			input = ScanUtil.nextInt();
			
			int result = adminscreendao.inserttimetable(scname, start, end, input);
			if(result > 0) {
				System.out.println("::::::등록성공:::::::");
			}else {
				System.out.println("::::::등록실패:::::::");
			}
			
			return View.TIMETABLE_SET;
		case 2 : //회차삭제
			System.out.println("삭제할 상영번호 : ");
			input = ScanUtil.nextInt();
			result =adminscreendao.deletetimetable(input);
			if(result > 0) {
				System.out.println(":::::삭제성공:::::");
			}else {
				System.out.println(":::::삭제실패:::::");
			}
			
			return View.TIMETABLE_SET;
		}
		
		return View.SCREEN_ADMIN;
	}
	
	public int rtimeset() {
		System.out.println("");
		return 0;
	}
	
	
	
	
}
