package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import util.JDBCUtil;

public class AdminScreenDao {

	private AdminScreenDao() {}
	private static AdminScreenDao instance;
	public static AdminScreenDao getInstance() {
		if (instance == null) {
			instance = new AdminScreenDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance(); //db연결
	
	
	public List<Map<String, Object>> selectScreenList(){ //상영관관리 첫화면?
		String sql = "SELECT SC_NAME,"
				   + "	     SEAT_ALL"
				   + "  FROM SCREEN ORDER BY SC_NAME";
	
		return jdbc.selectList(sql);
	}
	
	public int screeninsert(String scname, int scseat1, int scseat2, int scseat) { //상영관 추가하기
		String sql = "INSERT INTO SCREEN(SC_NO,SC_NAME,SEAT_ALL)"
				   + " 					 VALUES ((SELECT NVL(MAX(SC_NO), 0) + 1 FROM SCREEN),?,?)";
		
		List<Object> p = new ArrayList<>();
		p.add(scname);
		p.add(scseat);
		
		int result =  jdbc.update(sql, p);
		char aString = 65;
		for(int j = 1; j <= scseat2; j++) {
			
			String str = String.valueOf(aString);
		for(int i = 1; i <= scseat1; i++) {
		sql = "INSERT INTO SEAT "
				+ " 	 VALUES((SELECT NVL(MAX(SEAT_NO), 0) + 1 FROM SEAT),?,(SELECT SC_NO FROM (SELECT * FROM SCREEN ORDER BY SC_NO DESC)"
				+ " WHERE ROWNUM = 1),?)";
		p = new ArrayList<>(); 
		p.add(0);
		p.add(str+i);
		jdbc.update(sql, p);
			}
		aString++;
		}
		
		return result;
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
	public List<Map<String, Object>> seatList(String scname) {
		String sql = " SELECT A.SEAT_NAME,"
				+ "			  A.SEAT_CHARGE " + 
				"   FROM SEAT A,(SELECT SC_NO FROM SCREEN WHERE SC_NAME = ?)B " + 
				"  WHERE A.SC_NO=B.SC_NO " + 
				"  ORDER BY A.SEAT_NAME";
		List<Object> p = new ArrayList<>();
		p.add(scname);
		
		
		return jdbc.selectList(sql, p);
	}
	//좌석요금설정
	public int seatchargeSet(String scname, int money, String seatname) {
		String sql = "UPDATE SEAT SET SEAT_CHARGE = ? WHERE SEAT_NAME LIKE ?"
				+ "	  AND SC_NO = (SELECT SC_NO FROM SCREEN WHERE SC_NAME = ?)";
		
		List<Object> p = new ArrayList<>();
		p.add(money);
		p.add(seatname+"%");
		p.add(scname);
		
		
		return jdbc.update(sql, p);
	}
	
	//기준금액 검색
	public Map<String, Object> selectmainPrice(){
		String sql = "SELECT NVL(P_COST,0) AS P_COST FROM T_PRICE WHERE P_NAME = '기준금액'";
		return jdbc.selectOne(sql);
		
	}
	
	//대상금액 검색
	public List<Map<String, Object>> selectsalePrice(){
		String sql = "SELECT P_NO, P_NAME, NVL(P_COST,0) AS P_COST "
				   + "  FROM T_PRICE "
				   + " WHERE P_NAME != '기준금액' 	";
		return jdbc.selectList(sql);
	}
	
	//기준금액 변경
	public int mainPirceSet(int money) {
		String sql = "UPDATE T_PRICE SET P_COST = ? "
				+ "	   WHERE P_NAME = '기준금액'";
		
		List<Object> p = new ArrayList<>();
		p.add(money);

		return jdbc.update(sql, p); 
	}
	
	//대상요금 변경
	public int salePriceSet(String sname, int money) {
		String sql = "UPDATE T_PRICE SET P_COST = ? "
				   + " WHERE P_NAME = ? ";
		
		List<Object> p = new ArrayList<>();
		p.add(money);
		p.add(sname);
		
		return jdbc.update(sql,p);
	}
	
	
	public List<Map<String, Object>> selectrtime(String scname){
		String sql = "SELECT A.TIME_NO, A.TIME_START, A.TIME_END,"
				   + "       A.MOVIE_NO, B.SC_NAME, C.MOVIE_NAME "
				   + "  FROM R_TIME A, SCREEN B, MOVIE C "
				   + " WHERE A.SC_NO = B.SC_NO"
				   + "   AND B.SC_NAME = ?"
				   + "   AND A.MOVIE_NO = C.MOVIE_NO";
		List<Object> p = new ArrayList<>();
		p.add(scname);
		
		return jdbc.selectList(sql, p);
	}
	//영화리스트 검색 ------ㅁㄴㅇㄴㅁㅇ--------
	 public List<Map<String, Object>> selectMovieList(){
	      String sql = "SELECT A.MOVIE_NO, A.MOVIE_NAME, A.MOVIE_PD, B.GENRE_NAME, A.MOVIE_TIME  "
	               + " FROM MOVIE A"
	               + " LEFT OUTER JOIN GENRE B ON A.GENRE_NO = B.GENRE_NO"
	               + " ORDER BY MOVIE_NO DESC";
	      
	      return jdbc.selectList(sql);
	   }	
	 
	 public int inserttimetable(String scnom, String start, String end, int input) {
		 String sql = "INSERT INTO R_TIME VALUES((SELECT NVL(MAX(TIME_NO), 0) + 1 FROM R_TIME), "
		 		    + "                          TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS'),TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS'),?,(SELECT SC_NO FROM SCREEN WHERE SC_NAME = ?))";
		 List<Object> p = new ArrayList<>();
		 p.add(start);
		 p.add(end);
		 p.add(input);
		 p.add(scnom);
		 
		 return jdbc.update(sql, p);
	 }
	 
	 public int deletetimetable(int input) {
		 String sql = "DELETE FROM R_TIME WHERE TIME_NO = ?";
		 
		 List<Object> p = new ArrayList<>();
		 p.add(input);
		 
		 return jdbc.update(sql, p);
	 }
	 
	 
	 
	 
	 
	 
	
}
