package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import util.View;

public class AdminBoardDao {

	private AdminBoardDao() {}
	private static AdminBoardDao instance;
	public static AdminBoardDao getInstance() {
		if (instance == null) {
			instance = new AdminBoardDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	 
	//공지사항 게시판 select 출력
	public List<Map<String, Object>> selectBoardList(){
		String sql = "Select AN_NO, AN_TITLE, AN_USER"
				+ " 	   , TO_CHAR(AN_DATE, 'MM-DD') AS AN_DATE"
				+ " From ANNOUNCEMENT"
//				+ " LEFT OUTER JOIN EMPLOYEES B ON A.EMP_NO=B.EMP_NO"
				+ " ORDER BY AN_NO DESC" ;
		
		return jdbc.selectList(sql);
	}
	
	//조회
	public Map<String, Object> read(int boardNo) {
		String sql = "SELECT AN_NO, AN_TITLE, AN_CONTENT, AN_USER, TO_CHAR(AN_DATE, 'MM-DD') AS AN_DATE"
				+ " FROM ANNOUNCEMENT"
				+ " WHERE AN_NO = ?";
		
		List<Object> param = new ArrayList<>();
		param.add(boardNo);
		
//		Map<String, Object> board = jdbc.selectOne(sql, param);
		
		return jdbc.selectOne(sql, param);
		
	}
	
	
	
	//등록
	public int update (Map<String, Object> param) {
		String sql = "INSERT INTO ANNOUNCEMENT"
	 			+ "   VALUES ("
	 			+ "    (SELECT NVL(MAX(AN_NO), 0) + 1 FROM ANNOUNCEMENT)"
	 			+ "          , ?"
	 			+ "			 , ?"
	 			+ "          , SYSDATE"
	 			+ "          , ?"
	 			+ "          , ?)";
		
		List<Object> m = new ArrayList<>();
		m.add(param.get("AN_TITLE"));
		m.add(param.get("AN_USER"));
		m.add(param.get("EMP_NO"));
		m.add(param.get("AN_CONTENT"));
		
		
		
		return jdbc.update(sql, m);
		
		
		
	}
	
	//수정
	public int insert (int adminBoardNo, Object title) {
				
		String sql = "UPDATE ANNOUNCEMENT"
				+ "    SET AN_TITLE = ?"
				+ " WHERE AN_NO = ?";
		
		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(adminBoardNo);
		
		return jdbc.update(sql, param);
		
	}
	
	public int insert2 (int adminBoardNo, Object content) {
		
		String sql = "UPDATE ANNOUNCEMENT"
				+ "    SET AN_CONTENT = ?"
				+ " WHERE AN_NO = ?";
		
		List<Object> param = new ArrayList<>();
		param.add(content);
		param.add(adminBoardNo);
	
		return jdbc.update(sql, param);
		
	}
	
	
	public int insert3 (int adminBoardNo, Object title, Object content) {
		
		String sql = "UPDATE ANNOUNCEMENT"
				+ "    SET AN_TITLE = ?, AN_CONTENT = ?"
				+ " WHERE AN_NO = ?";
		
		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(content);
		param.add(adminBoardNo);
		
		return jdbc.update(sql, param);
		
	}
	

	
	//삭제
	public int delete (int adminBoardNo) {
		String sql = "DELETE "
				   + "  FROM ANNOUNCEMENT"
				   + " WHERE AN_NO = ?";
		
		List<Object> param = new ArrayList<>();
		param.add(adminBoardNo);
		
		return jdbc.update(sql, param);

	
	}
	
	
}
	
	

