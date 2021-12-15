package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class LostBoardDao {

	private LostBoardDao() {}
	private static LostBoardDao instance;
	public static LostBoardDao getInstance() {
		if (instance == null) {
			instance = new LostBoardDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<Map<String, Object>> selectBoardList(){
		String sql = "SELECT MI_NO"
				   + "	   , MI_TITLE"
				   + "     , MI_CONTENT"
				   + "     , TO_CHAR(MI_START, 'MM-DD') AS MI_START"
				   + "     , MI_BIGO"
				   + "  FROM MISSING "
//				   + "	LEFT OUTER JOIN TB_JDBC_MEMBER B ON A.MEM_ID = B.MEM_ID"
				   + " ORDER BY MI_NO DESC";
		
		return jdbc.selectList(sql);
	}

	
	
}
