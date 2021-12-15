package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class AdminReviewBoardDao {

	private AdminReviewBoardDao() {
	}

	private static AdminReviewBoardDao instance;

	public static AdminReviewBoardDao getInstance() {
		if (instance == null) {
			instance = new AdminReviewBoardDao();
		}
		return instance;
	}

	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	
	//리뷰게시판 목록조회
	public List<Map<String, Object>> reviewList() {
		String sql = "Select A.REVIEW_NO"
				+ "   , TO_CHAR(A.REVIEW_DATE, 'MM-DD') AS REVIEW_DATE"
				+ "   , C.M_NAME, B.MOVIE_NAME, A.REVIEW_SCORE"
				+ " FROM REVIEW A"
				+ " LEFT OUTER JOIN MOVIE B ON A.MOVIE_NO=B.MOVIE_NO"
				+ " LEFT OUTER JOIN MEMBER C ON A.M_NAME=C.M_NAME"
				+ " ORDER BY A.REVIEW_NO DESC";
		
		return jdbc.selectList(sql);

	}
	//리뷰 조회
	public Map<String, Object> reviewRead(int AdminReviewBoardNo){
		String sql = "SELECT B.MOVIE_NAME, A.REVIEW_CONTENT, C.M_NAME, A.REVIEW_SCORE"
				+ " FROM REVIEW A"
				+ " LEFT OUTER JOIN MOVIE B ON A.MOVIE_NO=B.MOVIE_NO"
				+ " LEFT OUTER JOIN MEMBER C ON A.M_NAME=C.M_NAME"
				+ " WHERE REVIEW_NO = ? "
				+ " ORDER BY A.REVIEW_NO DESC";
		
		List<Object> param = new ArrayList<>();
		param.add(AdminReviewBoardNo);
		
		return jdbc.selectOne(sql,param);
	}
	
	//리뷰게시판 강제 삭제(제목과 내용 변경)
	
	public int delete (int AdminReviewBoardNo) {
		String sql = "DELETE FROM REVIEW WHERE REVIEW_NO = ?";
		
			List<Object> p = new ArrayList<>();
			p.add(AdminReviewBoardNo);
			
		return jdbc.update(sql, p);
	}
	
	
	
	
	
	
}
