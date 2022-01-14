package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class UserMovieDao {
   
   private UserMovieDao() {}
   private static UserMovieDao instance;
   public static UserMovieDao getInstance() {
      if (instance == null) {
         instance = new UserMovieDao();
      }
      return instance;
   }
   
   private JDBCUtil jdbc = JDBCUtil.getInstance();
   
   
   //회원정보 조회
   public Map<String, Object> userInfoView(int userNo){
      String sql = "SELECT M_NO"
               + "     , M_NAME"
               + "     , TO_CHAR(M_BIR, 'YYYY-MM-DD') AS M_BIR"
               + "     , M_HP"
               + "      , M_ID"
               + "      , M_PASS"
               + "  FROM MEMBER"
               + " WHERE M_NO = ?";
      
      List<Object> m = new ArrayList<>();
      m.add(userNo);
      
      return jdbc.selectOne(sql, m);
   }
   
   //회원이름 수정
   public int updateName (int userNo, Object name) {
        
         String sql = "UPDATE MEMBER"
                  + " SET M_NAME = ?"
                  + " WHERE M_NO = ?";
         
         List<Object> param = new ArrayList<>();
         param.add(name);
         param.add(userNo);

         return jdbc.update(sql, param);
         
      }
   
   //회원 전화번호 수정
   public int updateHP (int userNo, Object hp) {
        
         String sql = "UPDATE MEMBER"
                  + " SET M_HP = ?"
                  + " WHERE M_NO = ?";
         
         List<Object> param = new ArrayList<>();
         param.add(hp);
         param.add(userNo);

         return jdbc.update(sql, param);
         
      }
   
   
   //회원 비밀번호 수정
   public int updatePass (int userNo, Object pass) {
        
         String sql = "UPDATE MEMBER"
                  + " SET M_PASS = ?"
                  + " WHERE M_NO = ?";
         
         List<Object> param = new ArrayList<>();
         param.add(pass);
         param.add(userNo);

         return jdbc.update(sql, param);
         
      }
   
   
   //예매내역 목록
   public List<Map<String, Object>> userMovieList(Object userNo){
	      System.out.println(userNo);
	      String sql = "SELECT A.T_NO,"
	                    + "C.MOVIE_NAME,"
	                    + "TO_CHAR(B.TIME_START, 'YY-MM-DD(dy)') AS TIME_START"
	               + " FROM RESERVATION A"
	               + " LEFT OUTER JOIN R_TIME B ON A.TIME_NO = B.TIME_NO"
	               + " LEFT OUTER JOIN MOVIE C ON B.MOVIE_NO = C.MOVIE_NO"
	               + " WHERE A.M_NO = ?"
	               + " ORDER BY T_NO DESC";
	      
	      List<Object> p = new ArrayList<>();
	      p.add(userNo);
	      return jdbc.selectList(sql,p);
	   }
      
      
//      String sql = "SELECT A.MOVIE_NO, A.MOVIE_NAME, A.MOVIE_PD, "
//                    + "B.GENRE_NAME, "
//                    + "C.RANK_NAME,"
//                    + "(SELECT TO_CHAR(TIME_START, 'YY-MM-DD') FROM R_TIME) AS TIME_START"
//               + " FROM MOVIE A"
//               + " LEFT OUTER JOIN GENRE B ON A.GENRE_NO = B.GENRE_NO"
//               + " LEFT OUTER JOIN RANK C ON A.RANK_NO = C.RANK_NO"
//               + " ORDER BY MOVIE_NO DESC";

   
   
   //예매내역 조회
   public Map<String, Object> userBookView(int bookNo){
      String sql = "SELECT A.T_NO,"
                        + "C.MOVIE_NAME,"
                        + "TO_CHAR(B.TIME_START, 'YYYY-MM-DD dy HH24:MM') AS TIME_START,"
                        + "D.SC_NAME,"
                        + "(SELECT COUNT(T_NO) FROM BOOKING WHERE T_NO = ?) AS SEAT_NO,"
                        + "LISTAGG(F.SEAT_NAME , ' , ') WITHIN GROUP(ORDER BY E.T_NO) AS SEAT_NAME"
                    + " FROM RESERVATION A"
                    + " LEFT OUTER JOIN R_TIME B ON A.TIME_NO = B.TIME_NO"
                    + " LEFT OUTER JOIN MOVIE C ON B.MOVIE_NO = C.MOVIE_NO"
                    + " LEFT OUTER JOIN SCREEN D ON B.SC_NO = D.SC_NO"
                    + " LEFT OUTER JOIN BOOKING E ON A.T_NO = E.T_NO"
                    + " LEFT OUTER JOIN SEAT F ON E.SEAT_NO = F.SEAT_NO"
                + " WHERE A.T_NO = ?"
                + " GROUP BY A.T_NO, C.MOVIE_NAME, TIME_START, D.SC_NAME";
      
      List<Object> m = new ArrayList<>();
      m.add(bookNo);
      m.add(bookNo);
      
      return jdbc.selectOne(sql, m);
      
   }
   
   
   //예매내역 취소
   public Map<String, Object> cancleMovie(int bookNo){
      String sql = "SELECT A.T_NO,"
                    + "C.MOVIE_NAME,"
                    + "TO_CHAR(B.TIME_START, 'YYYY-MM-DD (dy) HH24:MM') AS TIME_START,"
                    + "(SELECT COUNT(T_NO) FROM BOOKING WHERE T_NO = ?) AS SEAT_NO,"
                    + "LISTAGG(F.SEAT_NAME , ' , ') WITHIN GROUP(ORDER BY E.T_NO) AS SEAT_NAME,"
                    + "A.TOTAL_COST"
                + " FROM RESERVATION A"
                + " LEFT OUTER JOIN R_TIME B ON A.TIME_NO = B.TIME_NO"
                + " LEFT OUTER JOIN MOVIE C ON B.MOVIE_NO = C.MOVIE_NO"
                + " LEFT OUTER JOIN BOOKING E ON A.T_NO = E.T_NO"
                + " LEFT OUTER JOIN SEAT F ON E.SEAT_NO = F.SEAT_NO"
                + " WHERE A.T_NO = ?"
                + " GROUP BY A.T_NO, C.MOVIE_NAME, TIME_START, A.TOTAL_COST";
      
      List<Object> m = new ArrayList<>();
      m.add(bookNo);
      m.add(bookNo);
      
      return jdbc.selectOne(sql, m);
      
   }
   
   public int deleteMovie(int bookNo){
      String sql = "DELETE FROM RESERVATION WHERE T_NO = ?";
      
      List<Object> m = new ArrayList<>();
      m.add(bookNo);
      
      return jdbc.update(sql, m);
   }
   
   //회원 탈퇴
   public int deleteUser(int userNo){
      String sql = "DELETE FROM MEMBER WHERE M_NO = ?";
      
      List<Object> m = new ArrayList<>();
      m.add(userNo);
      
      return jdbc.update(sql, m);
   }
}