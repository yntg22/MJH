package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class AdminDao {

	private AdminDao() {}
	private static AdminDao instance;
	public static AdminDao getInstance() {
		if (instance == null) {
			instance = new AdminDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public Map<String, Object> selectMember(String empId, String password) {
		String sql = "SELECT EMP_ID, EMP_PASS, EMP_NAME, EMP_NO"
				   + " FROM EMPLOYEES"
				   + " WHERE EMP_ID = ?"
				   + " 	 AND EMP_PASS = ?";
		List<Object> param = new ArrayList<>();
		param.add(empId);
		param.add(password);
		
		return jdbc.selectOne(sql, param);
	}
	
	
	
	
	
	
}
