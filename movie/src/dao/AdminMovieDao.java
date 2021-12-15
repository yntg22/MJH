package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class AdminMovieDao {

	private AdminMovieDao() {}
	private static AdminMovieDao instance;
	public static AdminMovieDao getInstance() {
		if (instance == null) {
			instance = new AdminMovieDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	
	//영화 목록
	public List<Map<String, Object>> selectMovieList(){
		String sql = "SELECT A.MOVIE_NO, A.MOVIE_NAME, A.MOVIE_PD, B.GENRE_NAME, C.RANK_NAME"
					+ " FROM MOVIE A"
					+ " LEFT OUTER JOIN GENRE B ON A.GENRE_NO = B.GENRE_NO"
					+ " LEFT OUTER JOIN RANK C ON A.RANK_NO = C.RANK_NO"
					+ " ORDER BY MOVIE_NO DESC";
		
		return jdbc.selectList(sql);
	}
	
	
	//영화 조회
	public Map<String, Object> selectMovieView(int movieNo){
		String sql = "SELECT A.MOVIE_NO, A.MOVIE_NAME, A.MOVIE_PD, A.MOVIE_ACTER, A.MOVIE_SUMMARY,"
				+ " A.MOVIE_TIME, A.MOVIE_TERM1,  A.MOVIE_TERM2,"
				+ " B.GENRE_NAME, C.RANK_NAME"
				+ " FROM MOVIE A"
				+ " LEFT OUTER JOIN GENRE B ON A.GENRE_NO = B.GENRE_NO"
				+ " LEFT OUTER JOIN RANK C ON A.RANK_NO = C.RANK_NO"
				+ " WHERE MOVIE_NO = ?";
		
		List<Object> m = new ArrayList<>();
		m.add(movieNo);
		
		return jdbc.selectOne(sql, m);
	}
	
	//영화 등록
	public int insertMovie(Map<String, Object> param) {
		String sql = "INSERT INTO MOVIE(MOVIE_NO, MOVIE_NAME, GENRE_NO, "
									+ "RANK_NO, MOVIE_PD, MOVIE_ACTER, "
									+ "MOVIE_SUMMARY, MOVIE_TIME, MOVIE_TERM1,"
									+ "MOVIE_TERM2)"
					+ " VALUES("
					+ " (SELECT NVL(MAX(MOVIE_NO) , 0) + 1 FROM MOVIE)"
					+ " ,? ,? ,? ,? ,? ,? ,? ,?, ?)";
		
		List<Object> m = new ArrayList<>();
		m.add(param.get("MOVIE_NAME"));
		m.add(param.get("GENRE_NO"));
		m.add(param.get("RANK_NO"));
		m.add(param.get("MOVIE_PD"));
		m.add(param.get("MOVIE_ACTER"));
		m.add(param.get("MOVIE_SUMMARY"));
		m.add(param.get("MOVIE_TIME"));
		m.add(param.get("MOVIE_TERM1"));
		m.add(param.get("MOVIE_TERM2"));

		return jdbc.update(sql, m);
	}
	
	//영화제목 수정
	public int updateTitle (int movieNo, Object title) {
        
	      String sql = "UPDATE MOVIE"
	    		  	+ " SET MOVIE_NAME = ?"
	    		  	+ " WHERE MOVIE_NO = ?";
	      
	      List<Object> param = new ArrayList<>();
	      param.add(title);
	      param.add(movieNo);

	      return jdbc.update(sql, param);
	      
	   }
	
	//영화장르 수정
	public int updateGenre (int movieNo, Object genre) {
        
	      String sql = "UPDATE MOVIE"
	    		  	+ " SET GENRE_NO = ?"
	    		  	+ " WHERE MOVIE_NO = ?";
	      
	      List<Object> param = new ArrayList<>();
	      param.add(genre);
	      param.add(movieNo);

	      return jdbc.update(sql, param);
	      
	   }
	
	//영화등급 수정
	public int updateRank (int movieNo, Object rank) {
        
	      String sql = "UPDATE MOVIE"
	    		  	+ " SET RANK_NO = ?"
	    		  	+ " WHERE MOVIE_NO = ?";
	      
	      List<Object> param = new ArrayList<>();
	      param.add(rank);
	      param.add(movieNo);

	      return jdbc.update(sql, param);
	      
	   }
	
	//영화감독 수정
	public int updatePd (int movieNo, Object pd) {
        
	      String sql = "UPDATE MOVIE"
	    		  	+ " SET MOVIE_PD = ?"
	    		  	+ " WHERE MOVIE_NO = ?";
	      
	      List<Object> param = new ArrayList<>();
	      param.add(pd);
	      param.add(movieNo);

	      return jdbc.update(sql, param);
	      
	   }
	
	//영화배우 수정
	public int updateActer (int movieNo, Object acter) {
        
	      String sql = "UPDATE MOVIE"
	    		  	+ " SET MOVIE_ACTER = ?"
	    		  	+ " WHERE MOVIE_NO = ?";
	      
	      List<Object> param = new ArrayList<>();
	      param.add(acter);
	      param.add(movieNo);

	      return jdbc.update(sql, param);
	      
	   }
	
	//영화 줄거리 수정
	public int updateContent (int movieNo, Object content) {
        
	      String sql = "UPDATE MOVIE"
	    		  	+ " SET MOVIE_SUMMARY = ?"
	    		  	+ " WHERE MOVIE_NO = ?";
	      
	      List<Object> param = new ArrayList<>();
	      param.add(content);
	      param.add(movieNo);

	      return jdbc.update(sql, param);
	      
	   }
	
	//영화 러닝타임 수정
	public int updateTime (int movieNo, Object time) {
        
	      String sql = "UPDATE MOVIE"
	    		  	+ " SET MOVIE_TIME = ?"
	    		  	+ " WHERE MOVIE_NO = ?";
	      
	      List<Object> param = new ArrayList<>();
	      param.add(time);
	      param.add(movieNo);
	      
	      return jdbc.update(sql, param);
	      
	   }
	
	//영화 시작기간 수정
	public int updateTerm1 (int movieNo, Object term1) {
        
	      String sql = "UPDATE MOVIE"
	    		  	+ " SET MOVIE_TERM1 = ?"
	    		  	+ " WHERE MOVIE_NO = ?";
	      
	      List<Object> param = new ArrayList<>();
	      param.add(term1);
	      param.add(movieNo);

	      return jdbc.update(sql, param);
	      
	   }
	
	//영화 종료기간 수정
	public int updateTerm2 (int movieNo, Object term2) {
        
	      String sql = "UPDATE MOVIE"
	    		  	+ " SET MOVIE_TERM2 = ?"
	    		  	+ " WHERE MOVIE_NO = ?";
	      
	      List<Object> param = new ArrayList<>();
	      param.add(term2);
	      param.add(movieNo);
	         
	      return jdbc.update(sql, param);
	      
	   }
	
	
	

	//영화 삭제
	public int deleteMovie(int movieNo){
		String sql = "DELETE FROM MOVIE WHERE MOVIE_NO = ?";
		
		List<Object> m = new ArrayList<>();
		m.add(movieNo);
		
		return jdbc.update(sql, m);
	}
	
}



