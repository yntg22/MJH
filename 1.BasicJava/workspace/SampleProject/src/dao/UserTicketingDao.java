package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class UserTicketingDao {

	private UserTicketingDao() {}
	private static UserTicketingDao instance;
	public static UserTicketingDao getInstance() {
		if (instance == null) {
			instance = new UserTicketingDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance(); //db연결

	public List<Map<String,Object>> movieinfo(){ //상영중인 영화
		String sql = "SELECT * FROM MOVIE";
		
		
		return jdbc.selectList(sql);
	}
	
	//영화 상세보기
	public Map<String,Object> moviedetails(int input){
		String sql = "SELECT * FROM MOVIE WHERE MOVIE_NO = ?";
		
		List<Object> p = new ArrayList<>();
		p.add(input);
		return jdbc.selectOne(sql, p);
	}
	
	//영화리스트 불러오기 인데.. adminscreendao에도 있음 일단  써보자
	 public List<Map<String, Object>> selectMovieList2(){
	      String sql = "SELECT A.MOVIE_NO, A.MOVIE_NAME, A.MOVIE_PD, B.GENRE_NAME "
	               + " FROM MOVIE A"
	               + " LEFT OUTER JOIN GENRE B ON A.GENRE_NO = B.GENRE_NO"
	               + " ORDER BY MOVIE_NO DESC";
	      
	      return jdbc.selectList(sql);
	   }	
	
	 public List<Map<String, Object>> rtimeselect(int movieno){
		 String sql = "SELECT A.TIME_NO,A.TIME_START,A.TIME_END,A.SC_NO,B.MOVIE_NAME FROM R_TIME A, MOVIE B WHERE A.MOVIE_NO = ?"
		 		+ "     AND A.MOVIE_NO=B.MOVIE_NO";
		 List<Object> p = new ArrayList<>();
		 p.add(movieno);
		 return jdbc.selectList(sql, p);
	 }

	 
	 //티켓창 상영정보 가져오기
	 public Map<String,Object> rtimeinfo(int timeno){
		 String sql = "SELECT B.MOVIE_NAME, "
		 		+ "           A.TIME_START, "
		 		+ "			  A.TIME_END "
		 		+ "	     FROM R_TIME A, MOVIE B, SCREEN C "
		 		+ "     WHERE A.TIME_NO = ?"
		 		+ "		  AND A.SC_NO = C.SC_NO"
		 		+ "       AND A.MOVIE_NO = B.MOVIE_NO ";
		 List<Object> p = new ArrayList<>();
		 p.add(timeno);
		 return jdbc.selectOne(sql, p);
	 }
	/* SELECT C.SEAT_NO,C.SEAT_NAME
	    FROM R_TIME A,SCREEN B, SEAT C
	    WHERE A.TIME_NO = 4
	      AND A.SC_NO = B.SC_NO
	      AND B.SC_NO = C.SC_NO
	      AND C.SEAT_NO != (SELECT F.SEAT_NO
	          FROM RESERVATION A
	          LEFT OUTER JOIN R_TIME B ON A.TIME_NO=B.TIME_NO
	          LEFT OUTER JOIN SCREEN C ON B.SC_NO=C.SC_NO
	          LEFT OUTER JOIN SEAT D ON C.SC_NO=D.SC_NO
	          LEFT OUTER JOIN BOOKING F ON A.T_NO=F.T_NO
	          GROUP BY F.SEAT_NO);*/
	 
	 //어떻게 만들었는지는 모르겠는데
	 //하다보니까 됨
	 //영화 예매 , 선택 후 좌석선택하면 보여줄 쿼리
	 public List<Map<String,Object>> seatselect(int timeno){
		 String sql =
				 " SELECT A.SEAT_NO, " + 
				 "                            CASE WHEN A.SEAT_NO = ANY (SELECT A.SEAT_NO " + 
				 "                                                               FROM BOOKING A, RESERVATION B, R_TIME C, SCREEN D WHERE A.T_NO=B.T_NO "
				 + "																							  AND C.TIME_NO = ?"
				 + "																							  AND B.TIME_NO = C.TIME_NO "
				 + "																							  AND C.SC_NO = D.SC_NO ) " + 
				 "		 		                               THEN A.SEAT_NAME||'■' " + 
				 "		 		                                ELSE A.SEAT_NAME||'□' " + 
				 "                                            END AS SEAT_NAME, " + 
				 "                                            A.SEAT_CHARGE " + 
				 "                                            FROM SEAT A, R_TIME B, SCREEN C " + 
				 "                                            WHERE B.TIME_NO = ? " + 
				 "                                            AND B.SC_NO = C.SC_NO " + 
				 "                                            AND A.SC_NO = C.SC_NO " + 
				 "                                            GROUP BY A.SEAT_NO,SEAT_NAME,A.SEAT_CHARGE " + 
				 "                                            ORDER BY A.SEAT_NAME";
		 
		 List<Object> p = new ArrayList<>();
		 p.add(timeno);
		 p.add(timeno);
		 
		 return jdbc.selectList(sql, p);
	 }

	 //결제가격가져오기
	 /*
	  * 결제가격을 가져오려면 필요한 정보들
	  * 상영정보,고객번호와 생년월일,마일리지, 선택한좌석번호,  
	  * 좌석요금과,회원의나이와,조조와 심야할인 ? 마일리지사용
	 */
	 //기준가격리턴
	 public Map<String,Object> defaultcost() {
		 String sql = "SELECT P_COST FROM T_PRICE WHERE P_NAME ='기준금액'";
		 
		 return jdbc.selectOne(sql);
		 
	 }
	 //회원나이 리턴
	 public Map<String,Object> userage(Object mno){
		 String sql = "SELECT TRUNC(ROUND(MONTHS_BETWEEN(SYSDATE,M_BIR)/12)) AS AGE"
		 		+ "    FROM MEMBER"
		 		+ "    WHERE M_ID = ?";
		 
		 List<Object> p = new ArrayList<>();
		 p.add(mno);
		 
		 return jdbc.selectOne(sql, p);
	 }
	 
	 public Map<String,Object> agesale(String pname){
		 String sql = "SELECT P_COST FROM T_PRICE WHERE P_NAME = ? ";
		 
		 List<Object> p = new ArrayList<>();
		 p.add(pname);
		 
		 return jdbc.selectOne(sql, p);
	 }
	 
	 public Map<String,Object> seatsale(String seat,int timeno){
		 String sql = "SELECT D.SEAT_CHARGE" + 
		 		"    FROM RESERVATION A, R_TIME B, SCREEN C , SEAT D" + 
		 		"    WHERE B.TIME_NO = ?" + 
		 		"      AND A.TIME_NO = B.TIME_NO" + 
		 		"      AND B.SC_NO = C.SC_NO" + 
		 		"      AND C.SC_NO = D.SC_NO" + 
		 		"      AND D.SEAT_NAME = ? "
		 		+ "   GROUP BY D.SEAT_CHARGE";
		 
		 List<Object> p = new ArrayList<>();
		 p.add(timeno);
		 p.add(seat);
		 
		 return jdbc.selectOne(sql, p);
	 }
	 
	 
	 public int laststep(int rtimeno, int mno, int money, List seat) {
		 int ret = 0;
		 String sql = "INSERT INTO PAYMENT VALUES((SELECT NVL(MAX(PAY_NO), 0) + 1 FROM PAYMENT),'현금')";
		 ret += jdbc.update(sql);
		 sql = "INSERT INTO RESERVATION VALUES((SELECT NVL(MAX(T_NO), 0) + 1 FROM RESERVATION),"
		 		+ "    ?,?,(SELECT MAX(PAY_NO) FROM PAYMENT),0,?,SYSDATE)";
		 List<Object> p = new ArrayList<>();
		 p.add(rtimeno);
		 p.add(mno);
		 p.add(money);
		 ret += jdbc.update(sql, p);
		 for(int i = 0; i < seat.size(); i++) {
			  		sql = "SELECT D.SEAT_NO" + 
				 		"    FROM RESERVATION A, R_TIME B, SCREEN C , SEAT D" + 
				 		"    WHERE B.TIME_NO = ?" + 
				 		"      AND A.TIME_NO = B.TIME_NO" + 
				 		"      AND B.SC_NO = C.SC_NO" + 
				 		"      AND C.SC_NO = D.SC_NO" + 
				 		"      AND D.SEAT_NAME = ? "
				 		+ "   GROUP BY D.SEAT_NO";
			 
			  		List<Object> s = new ArrayList<>();
			  		s.add(rtimeno);
			  		s.add(seat.get(i));
			  		
			  		Map<String,Object> seatno = jdbc.selectOne(sql, s);
			  		System.out.println(seatno.get("SEAT_NO"));
			  		
		 sql = "INSERT INTO BOOKING VALUES((SELECT MAX(T_NO) FROM RESERVATION),?,?)";
		 
		 String seno = seatno.get("SEAT_NO").toString();
		 
		 List<Object> seatno2 = new ArrayList<>();
			 seatno2.add(seno); 
			 seatno2.add(money);
	 
			 ret += jdbc.update(sql,seatno2);
			 
		 }
		 return ret;
		 
				
	 }


}
