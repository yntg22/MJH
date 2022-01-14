package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import controller.Controller;
import util.JDBCUtil;

public class BoardDao {

	// 싱글톤 패턴
	private BoardDao() {}
	private static BoardDao instance;
	public static BoardDao getInstance() {
		if (instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<Map<String, Object>> selectBoardList(){
		String sql = "SELECT A.BOARD_NO"
				   + "	   , A.TITLE"
				   + "     , B.MEM_NAME"
				   + "     , TO_CHAR(A.REG_DATE, 'MM-DD') AS REG_DATE"
				   + "  FROM TB_JDBC_BOARD A"
				   + "	LEFT OUTER JOIN TB_JDBC_MEMBER B ON A.MEM_ID = B.MEM_ID"
				   + " ORDER BY A.BOARD_NO DESC";
		
		return jdbc.selectList(sql);
	}

	public Map<String, Object> selectBoardget(int num) { //게시글 조회
		String sql = "SELECT BOARD_NO"
				   + "	   , TITLE"
				   + "	   , CONTENT"
				   + "     , TO_CHAR(REG_DATE, 'MM-DD') AS REG_DATE"
				   + "     , MEM_ID"
				   + " FROM TB_JDBC_BOARD"
				   + " WHERE BOARD_NO = ?";
		
		List<Object> p = new ArrayList<>();
		p.add(num);
		
		return jdbc.selectOne(sql, p);
		
	}

	public int boardinsert(String title, String content) { //등록
		String sql = "INSERT INTO TB_JDBC_BOARD(BOARD_NO,TITLE,CONTENT,REG_DATE,MEM_ID)"
				+ " 					 VALUES ((SELECT NVL(MAX(BOARD_NO), 0) + 1 FROM TB_JDBC_BOARD)"
				+ "								 , ?,?, SYSDATE,?)";
		
		List<Object> p = new ArrayList<>();
		p.add(title);
		p.add(content);
		p.add(Controller.loginMember.get("MEM_ID"));
		
		return jdbc.update(sql, p);
	}
	
}
