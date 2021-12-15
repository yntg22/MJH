package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class ReviewBoardDao {

	private ReviewBoardDao() {}
	private static ReviewBoardDao instance;
	public static ReviewBoardDao getInstance() {
		if (instance == null) {
			instance = new ReviewBoardDao();
		}
		return instance;
	}
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	//문의게시판 목록 출력
		public List<Map<String, Object>> boardList(){
			String sql = "Select A.REVIEW_NO, B.MOVIE_NAME"
					+ " 	   , TO_CHAR(A.REVIEW_DATE, 'MM-DD') AS REVIEW_DATE"
					+ "        , C.M_NAME, A.REVIEW_SCORE"
					+ " From REVIEW A"
					+ " LEFT OUTER JOIN MOVIE B ON A.MOVIE_NO=B.MOVIE_NO"
					+ " LEFT OUTER JOIN MEMBER C ON A.M_NAME=C.M_NAME"
					+ " ORDER BY REVIEW_NO DESC" ;
			
			return jdbc.selectList(sql);
		}
		
		
		//문의게시판 조회
		public Map<String, Object> boardView(int boardNo){
			String sql = "SELECT B.MOVIE_NAME, A.REVIEW_SCORE, A.REVIEW_CONTENT, C.M_NAME, TO_CHAR(A.REVIEW_DATE,'MM-DD') AS REVIEW_DATE"
					+ "     FROM REVIEW A"
					+ "     LEFT OUTER JOIN MOVIE B ON A.MOVIE_NO=B.MOVIE_NO"
					+ " 	LEFT OUTER JOIN MEMBER C ON A.M_NAME=C.M_NAME"
					+ "    WHERE A.REVIEW_NO = ?";
				
			List<Object> p = new ArrayList<>();
			p.add(boardNo);
					
			return jdbc.selectOne(sql, p);
		}
		
		
		//리뷰게시판 등록
		public int update (Map<String, Object> param) {
			String sql = "INSERT INTO REVIEW" 
					+ "   VALUES((SELECT NVL(MAX(REVIEW_NO),0)+1 FROM REVIEW)," 
					+ "  SYSDATE,"
					+ " (SELECT M_NAME FROM MEMBER WHERE M_NAME= ?),"
					+ " (SELECT MOVIE_NO FROM MOVIE WHERE MOVIE_NAME= ?),"
					+ " ?,"
					+ " ?)";
			
			List<Object> m = new ArrayList<>();
			m.add(param.get("M_NAME"));
			m.add(param.get("MOVIE_NAME"));
			m.add(param.get("REVIEW_CONTENT"));
			m.add(param.get("REVIEW_SCORE"));
			
			return jdbc.update(sql, m);
		}
		
		// 리뷰 수정
		
		public int insert (int boardNo, Object content) {
			
			String sql = "UPDATE REVIEW"
						+ "    SET REVIEW_CONTENT = ?"
						+ " WHERE REVIEW_NO = ?";
				
			List<Object> param = new ArrayList<>();
			param.add(content);
			param.add(boardNo);
				
			return jdbc.update(sql, param);
				
			}
	
		//리뷰게시판과 아이디 동일인 확인
		public Map<String, Object> user(String userName) {
		    	String sql = "SELECT M_ID FROM MEMBER WHERE M_name = ?";
					
				List<Object> param = new ArrayList<>();
				param.add(userName);
				
				return jdbc.selectOne(sql, param);
			}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
