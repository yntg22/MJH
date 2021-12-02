package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtil {
	
	//싱글톤 패턴 : 인스턴스의 생성을 제한하여 하나의 인스턴스만 사용하는 디자인 패턴
	private JDBCUtil(){
		
	}
	
	private static JDBCUtil instance; //객체생성?
	
	public static JDBCUtil getInstance() {
		if(instance == null) { //처음에만 객체생성을하고 그다음부터는 객체생성을안함, 전에만들었던걸 다시 돌려줌
			instance = new JDBCUtil();
		}
		return instance;
	}
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "MJH96";
	String password = "java";
	
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	/*
	 * Map<String, Object> selectOne(String sql)                       		*select의 결과가 한줄일때
	 * Map<String, Object> selectOne(String sql, List<Object> param)		*쿼리에 물음표가있을경우 파라미터list에 담아 보낸다
	 * 
	 * List<Map<String, Object>> selectList(String sql)						*여러줄이 나올경우
	 * List<Map<String, Object>> selectList(String sql, List<Object> param)
	 * 
	 * int update(String sql)												*select를 제외한 나머지 
	 * int update(String sql, List<Object> param)
	*/
	
	public List<Map<String, Object>> selectList(String sql, List<Object> param){
		
		ArrayList<Map<String, Object>> list = new ArrayList<>();
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			ps = con.prepareStatement(sql);
			for(int i = 0; i < param.size(); i++) {
				ps.setObject(i + 1, param.get(i));  //물음표의값 구하기
			}
			
			rs = ps.executeQuery(); //쿼리실행?
			
			ResultSetMetaData metaData = rs.getMetaData();
			
			int coulumnCount = metaData.getColumnCount();
			
			while(rs.next()) {
				HashMap<String,Object> map = new HashMap<>();
				for(int i = 1; i <= coulumnCount; i++) {
					map.put(metaData.getColumnName(i), rs.getObject(i));
					
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { //닫아준다
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		
		return list;
		
	}
	
}
