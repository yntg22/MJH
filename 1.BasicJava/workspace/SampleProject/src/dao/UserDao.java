package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import util.JDBCUtil;

public class UserDao {
	
	// 싱글톤 패턴
	private UserDao() {}
	private static UserDao instance;
	public static UserDao getInstance() {
		if (instance == null) {
			instance = new UserDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public int insertMember(Map<String, Object> param) { //맵으로 받거나 아래처럼 따로따로 String으로 받아도 상관없으나 파라미터가 많으면 Map으로 받는게 편하다
		String sql = "INSERT INTO MEMBER(M_NO,M_NAME,M_BIR,M_HP,M_ID,M_PASS) VALUES (?,?,SYSDATE,?,?)";
		
		List<Object> p = new ArrayList<>();
		p.add(param.get("M_NO"));
		p.add(param.get("M_NAME"));
		p.add(param.get("M_HP"));
		p.add(param.get("M_ID"));
		p.add(param.get("M_PASS"));
		
		return jdbc.update(sql, p);
	}

	public Map<String, Object> selectMember(String memId, String password) {
		String sql = "SELECT M_ID, M_PASS, M_NAME,M_NO"
				   + " FROM MEMBER"
				   + " WHERE M_ID = ?"
				   + " 	 AND M_PASS = ?";
		List<Object> param = new ArrayList<>();
		param.add(memId);
		param.add(password);
		
		return jdbc.selectOne(sql, param);
	}
}










