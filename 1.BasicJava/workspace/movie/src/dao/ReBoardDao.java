package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import controller.Controller;
import util.JDBCUtil;

public class ReBoardDao {

	// 싱글톤 패턴
	private ReBoardDao() {}
	private static ReBoardDao instance;
	public static ReBoardDao getInstance() {
		if (instance == null) {
			instance = new ReBoardDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	//문의게시판 목록 출력
	public List<Map<String, Object>> boardList(){
		String sql = "Select A.BOARD_NO, A.BOARD_TITLE, B.M_NAME"
				+ " 	   , TO_CHAR(A.BOARD_DATE, 'MM-DD') AS BOARD_DATE"
				+ "        , A.BOARD_RE"
				+ " From BOARD A"
				+ " LEFT OUTER JOIN MEMBER B ON A.M_NO=B.M_NO"
				+ " ORDER BY BOARD_NO DESC" ;
		
		return jdbc.selectList(sql);
	}
	
	
	//문의게시판 조회
	public Map<String, Object> boardView(int boardNo){
		String sql = "SELECT A.BOARD_TITLE, A.BOARD_CONTENT, B.M_NAME, TO_CHAR(A.BOARD_DATE,'MM-DD') AS BOARD_DATE"
				+ "     FROM BOARD A"
				+ "     LEFT OUTER JOIN MEMBER B ON A.M_NO=B.M_NO"
				+ "    WHERE A.BOARD_NO = ?";
			
		List<Object> p = new ArrayList<>();
		p.add(boardNo);
				
		return jdbc.selectOne(sql, p);
	}
	
	
	//문의게시판 등록
	public int update (Map<String, Object> param) {
		String sql = "INSERT INTO BOARD" 
				+ "   VALUES((SELECT NVL(MAX(BOARD_NO),0)+1 FROM BOARD)," 
				+ "   ?,"
				+ "  SYSDATE,"
				+ " (SELECT M_NO FROM MEMBER WHERE M_NAME= ?),"
				+ " ?,"
				+ " '미등록')";
		
		List<Object> m = new ArrayList<>();
		m.add(param.get("BOARD_TITLE"));
		m.add(param.get("M_NAME"));
		m.add(param.get("BOARD_CONTENT"));
		
		
		
		return jdbc.update(sql, m);
		
		
		
	}
	
	
	//문의게시판 수정 > 수정은 아이디 이름과 작성자 이름이 동일할때 가능
	
		public int insert (int boardNo, Object title) {
						
			String sql = "UPDATE BOARD"
						+ "    SET BOARD_TITLE = ?"
						+ " WHERE BOARD_NO = ?";
				
			List<Object> param = new ArrayList<>();
			param.add(title);
			param.add(boardNo);
				
			return jdbc.update(sql, param);
				
			}
			
		public int insert2 (int boardNo, Object content) {
				
			String sql = "UPDATE BOARD"
						+ "    SET BOARD_CONTENT = ?"
						+ " WHERE BOARD_NO = ?";
				
			List<Object> param = new ArrayList<>();
			param.add(content);
			param.add(boardNo);
		
			return jdbc.update(sql, param);
			
		}
		
		
		public int insert3 (int boardNo, Object title, Object content) {
			
			String sql = "UPDATE BOARD"
					+ "    SET BOARD_TITLE = ?, BOARD_CONTENT = ?"
					+ " WHERE BOARD_NO = ?";
			
			List<Object> param = new ArrayList<>();
			param.add(title);
			param.add(content);
			param.add(boardNo);
			
			return jdbc.update(sql, param);
			
		}
		
		
		//조회
		public Map<String, Object> read(int boardNo) {
			String sql = "SELECT A.BOARD_NO, A.BOARD_TITLE, A.BOARD_CONTENT, B.M_NAME, TO_CHAR(A.BOARD_DATE,'MM-DD') AS BOARD_DATE"
					+ " FROM BOARD A"
					+ " LEFT OUTER JOIN MEMBER B ON A.M_NO=B.M_NO"
					+ " WHERE BOARD_NO = ?";
			
			List<Object> param = new ArrayList<>();
			param.add(boardNo);
			
//			Map<String, Object> board = jdbc.selectOne(sql, param);
				
			return jdbc.selectOne(sql, param);
				
			}	
		

	//문의게시판 삭제 > 삭제는 아이디 이름과 작성자 이름이 동일할때 가능
		public int delete (int boardNo) {
			String sql = "DELETE "
					   + "  FROM BOARD"
					   + " WHERE BOARD_NO = ?";
			
			List<Object> param = new ArrayList<>();
			param.add(boardNo);
			
			return jdbc.update(sql, param);

		
		}	
			
	//문의게시판과 아이디 동일인 확인
//		public Map<String, Object> user(int boardNo, String userName) {
//			String sql = "SELECT B.M_NAME "
//					+ "     FROM BOARD A"
//					+ "    LEFT OUTER JOIN MEMBER B ON A.M_NO=B.M_NO"
//					+ "   WHERE M_NAME = ?";
//			
//			List<Object> param = new ArrayList<>();
//			param.add(userName);
//			
//			return jdbc.selectOne(sql, param);
//		}
//	


}
