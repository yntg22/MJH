package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class MovieDao {

	private MovieDao() {}
	private static MovieDao instance;
	public static MovieDao getInstance() {
		if (instance == null) {
			instance = new MovieDao();
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
}
