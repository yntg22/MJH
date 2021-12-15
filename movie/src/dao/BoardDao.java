package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import controller.Controller;
import util.JDBCUtil;

public class BoardDao {

	private BoardDao() {}
	private static BoardDao instance;
	public static BoardDao getInstance() {
		if (instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	//공지사항 목록 출력
	public List<Map<String, Object>> selectBoardList(){
		String sql = "SELECT AN_NO"
				   + "	   , AN_TITLE"
				   + "     , TO_CHAR(AN_DATE, 'MM-DD') AS AN_DATE"
				   + "  FROM ANNOUNCEMENT "
//				   + "	LEFT OUTER JOIN TB_JDBC_MEMBER B ON A.MEM_ID = B.MEM_ID"
				   + " ORDER BY AN_NO DESC";
		
		return jdbc.selectList(sql);
	}

	public Map<String, Object> selectBoardget(int boardNo) { //게시글 조회
		String sql = "SELECT AN_NO"
				   + "	   , AN_TITLE"
				   + "	   , AN_CONTENT"
				   + "     , TO_CHAR(AN_DATE, 'MM-DD') AS AN_DATE"
				   + "     , AN_USER"
				   + " FROM ANNOUNCEMENT"
				   + " WHERE AN_NO = ?";
		
		List<Object> p = new ArrayList<>();
		p.add(boardNo);
		
		return jdbc.selectOne(sql, p);
		
	}
	
//	//등록
//	public int boardinsert(String title, String content) { 
//		String sql = "INSERT INTO TB_JDBC_BOARD(BOARD_NO,TITLE,CONTENT,REG_DATE,MEM_ID)"
//				+ " 					 VALUES ((SELECT NVL(MAX(BOARD_NO), 0) + 1 FROM TB_JDBC_BOARD)"
//				+ "								 , ?,?, SYSDATE,?)";
//		
//		List<Object> p = new ArrayList<>();
//		p.add(title);
//		p.add(content);
//		p.add(Controller.loginMember.get("MEM_ID"));
//		
//		return jdbc.update(sql, p);
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public List<Map<String, Object>> boardList(){
//		String sql = "Select A.BOARD_NO, A.BOARD_TITLE, B.M_NAME"
//				+ " 	   , TO_CHAR(A.BOARD_DATE, 'MM-DD') AS BOARD_DATE"
//				+ "        , A.BOARD_RE"
//				+ " From BOARD A"
//				+ " LEFT OUTER JOIN MEMBER B ON A.M_NO=B.M_NO"
//				+ " ORDER BY BOARD_NO DESC" ;
//		
//		return jdbc.selectList(sql);
//	}
//	
//	public Map<String, Object> boardView(int boardNo){
//		String sql = "SELECT A.BOARD_TITLE, A.BOARD_CONTENT, B.M_NAME"
//				+ "     FROM BOARD A"
//				+ "     LEFT OUTER JOIN MEMBER B ON A.M_NO=B.M_NO"
//				+ "    WHERE A.BOARD_NO = ?";
//			
//		List<Object> p = new ArrayList<>();
//		p.add(boardNo);
//				
//		return jdbc.selectOne(sql, p);
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
