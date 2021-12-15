package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class AdminLostBoardDao {

	private AdminLostBoardDao() {
	}

	private static AdminLostBoardDao instance;

	public static AdminLostBoardDao getInstance() {
		if (instance == null) {
			instance = new AdminLostBoardDao();
		}
		return instance;
	}

	private JDBCUtil jdbc = JDBCUtil.getInstance();

	// 유실물 게시판 출력
	public List<Map<String, Object>> lostBoardList() {
		String sql = "Select MI_NO, MI_TITLE, MI_CONTENT" 
				+ " 	  , TO_CHAR(MI_START, 'YYYY-MM-DD') AS MI_START"
				+ "            , MI_OWNER, MI_HP, MI_BIGO"
				+ " From MISSING"
//				+ " LEFT OUTER JOIN EMPLOYEES B ON A.EMP_NO=B.EMP_NO"
				+ " ORDER BY MI_NO DESC";

		return jdbc.selectList(sql);
	}

	// 유실물 등록
	public int lostupdate(Map<String, Object> param) {
		String sql = "INSERT INTO MISSING" + "   VALUES (" 
				+ "    (SELECT NVL(MAX(MI_NO), 0) + 1 FROM MISSING)"
				+ "          , ?" + "          , ?" 
				+ "			 , SYSDATE" 
				+ "          , SYSDATE+60" 
				+ "          , ?"
				+ "          , ?" 
				+ "          , ?"
				+ "          , ?)";

		List<Object> m = new ArrayList<>();
		m.add(param.get("MI_TITLE"));
		m.add(param.get("MI_CONTENT"));
		m.add(param.get("EMP_NO"));
		m.add(param.get("MI_OWNER"));
		m.add(param.get("MI_HP"));
		m.add(param.get("MI_BIGO"));

		return jdbc.update(sql, m);
	}

	// 유실물 수정
	public int lostInsert(int lostBoardNo, Object title) {

		String sql = "UPDATE MISSING SET MI_TITLE = ? WHERE MI_NO = ?";

		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(lostBoardNo);

		return jdbc.update(sql, param);

	}

	public int lostInsert2(int lostBoardNo, Object content) {

		String sql = "UPDATE MISSING SET MI_CONTENT = ? WHERE MI_NO = ?";

		List<Object> param = new ArrayList<>();
		param.add(content);
		param.add(lostBoardNo);

		return jdbc.update(sql, param);

	}

	public int lostInsert3(int lostBoardNo, Object title, Object content) {

		String sql = "UPDATE MISSING SET MI_TITLE = ?, MI_CONTENT = ? WHERE MI_NO = ?";

		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(content);
		param.add(lostBoardNo);

		return jdbc.update(sql, param);

	}

	public int lostInsert4(int lostBoardNo, Object owner, Object hp, Object bigo) {

		String sql = "UPDATE MISSING SET MI_OWNER = ?" 
				+ "              , MI_HP = ?, MI_BIGO = ?" 
				+ " WHERE MI_NO = ?";

		List<Object> param = new ArrayList<>();
		param.add(owner);
		param.add(hp);
		param.add(bigo);
		param.add(lostBoardNo);

		return jdbc.update(sql, param);

	}

	// 유실물 삭제

	public int delete(int lostBoardNo) {
		String sql = "DELETE " + "  FROM MISSING" 
				+ " WHERE MI_NO = ?";

		List<Object> param = new ArrayList<>();
		param.add(lostBoardNo);

		return jdbc.update(sql, param);

	}

}
