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
			//selectlist라는 메소드를 호출하면
			//어레이리스트에,해쉬맵으로 저장해서 돌려주겠다 / 파라미터로 sql쿼리문과 어레이리스트에 있는 object객체를 받겠다
	public List<Map<String, Object>> selectList(String sql, List<Object> param){
		
		//어레이리스트 list 생성
		ArrayList<Map<String, Object>> list = new ArrayList<>();
		
		try {
			con = DriverManager.getConnection(url, user, password); //db연결
			
			ps = con.prepareStatement(sql); //파라미터로 받은 sql 쿼리문을 preparedstatement 객체로 만듬
			for(int i = 0; i < param.size(); i++) { //어레이리스트 param의 크기만큼 for문을 돌리겠다
				ps.setObject(i + 1, param.get(i));  //물음표의값 구하기
		    	//▲쿼리문의 물음표   1번째물음표에  , param 0번째 값을 넣겠다
			}
			//▼쿼리실행하고 결과를 rs객체에 넣어둠
			rs = ps.executeQuery(); //쿼리실행?
			//▼rs객체의 메타데이터를 metaData에 넣고   
			ResultSetMetaData metaData = rs.getMetaData(); //메타데이터는 그냥 데이터의 속성? 같은거네 
			//▼메타데이터의 컬럼갯수를 저장
			int coulumnCount = metaData.getColumnCount();
			
			while(rs.next()) { //쿼리결과저장한 rs 객체를 next라는 메소드로 한줄씩 불러온다는 느낌?
				HashMap<String,Object> map = new HashMap<>(); //map이라는 해쉬맵을 하나 만듬
				for(int i = 1; i <= coulumnCount; i++) { //위에서구한 rs의 컬럼수만큼 돌릴거다 컬럼은 1부터 시작 가로로
					map.put(metaData.getColumnName(i), rs.getObject(i));
					//rs객체의 메타데이터에서 i번째 컬럼이름과, i번째 컬럼의값?을 오브잭트로꺼내서 위에서 만든
					//map해쉬맵에 string타입 컬럼이름(해쉬맵에서는 key역활이고), object값(데이터값) 넣음
					
				}
				list.add(map); //그렇게 모든 결과값들을 map에 저장하고 나면, 그것들을 list라는 ArrayList에 넣어서 리턴.
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
	
	////////////////// 3번째
	public List<Map<String, Object>> selectList(String sql){
		//list로 돌려주겠다. 파라미터로 sql문을 받겠다
		ArrayList<Map<String, Object>> list = new ArrayList<>(); //돌려줄 list를 만들고
		
		try {
			con = DriverManager.getConnection(url, user, password); //연결
			
			ps = con.prepareStatement(sql); //sql문을 ps객체로 만든다
			
			rs = ps.executeQuery(); //쿼리실행 결과값 rs에 저장
			
			ResultSetMetaData metaData = rs.getMetaData(); //결과rs의 메타데이터 저장
			
			int coulumnCount = metaData.getColumnCount(); //메타데이터의 컬럼수 저장
			
			while(rs.next()) { //쿼리결과출력
				HashMap<String,Object> map = new HashMap<>(); //결과값 넣어줄 해쉬맵?
				for(int i = 1; i <= coulumnCount; i++) { //컬럼수만큼
					map.put(metaData.getColumnName(i), rs.getObject(i)); //컬럼이름(key) 값(object)
					
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
	
	
	////////////////////////2번째 Map<String, Object> selectOne(String sql, List<Object> param)
	public Map<String, Object> selectOne(String sql, List<Object> param) {
		// 돌려줄 해쉬맵 생성
		HashMap<String,Object> map = null; 

		try {
			con = DriverManager.getConnection(url, user, password); // db연결

			ps = con.prepareStatement(sql); // 파라미터로 받은 sql 쿼리문을 preparedstatement 객체로 만듬
			for (int i = 0; i < param.size(); i++) { // 어레이리스트 param의 크기만큼 for문을 돌리겠다
				ps.setObject(i + 1, param.get(i)); // 물음표의값 구하기
				// ▲쿼리문의 물음표 1번째물음표에 , param 0번째 값을 넣겠다
			}
			// ▼쿼리실행하고 결과를 rs객체에 넣어둠
			rs = ps.executeQuery(); // 쿼리실행?
			// ▼rs객체의 메타데이터를 metaData에 넣고
			ResultSetMetaData metaData = rs.getMetaData(); // 메타데이터는 그냥 데이터의 속성? 같은거네
			// ▼메타데이터의 컬럼갯수를 저장
			int coulumnCount = metaData.getColumnCount();

			if(rs.next()) { // 쿼리결과저장한 rs 객체를 next라는 메소드로 한줄씩 불러온다는 느낌?
				map = new HashMap<>(); //왜 또 새로 만듬? 
				for (int i = 1; i <= coulumnCount; i++) { // 위에서구한 rs의 컬럼수만큼 돌릴거다 컬럼은 1부터 시작 가로로
					map.put(metaData.getColumnName(i), rs.getObject(i));
					// rs객체의 메타데이터에서 i번째 컬럼이름과, i번째 컬럼의값?을 오브잭트로꺼내서 위에서 만든
					// map해쉬맵에 string타입 컬럼이름(해쉬맵에서는 key역활이고), object값(데이터값) 넣음
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 닫아준다
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return map;

	}
	
	
	///////////1번쨰 Map<String, Object> selectOne(String sql)
	public Map<String, Object> selectOne(String sql){
		// 돌려줄 해쉬맵 생성
		HashMap<String, Object> map = new HashMap<>();

		try {
			con = DriverManager.getConnection(url, user, password); // db연결

			ps = con.prepareStatement(sql); // 파라미터로 받은 sql 쿼리문을 preparedstatement 객체로 만듬
			// ▼쿼리실행하고 결과를 rs객체에 넣어둠
			rs = ps.executeQuery(); // 쿼리실행?
			// ▼rs객체의 메타데이터를 metaData에 넣고
			ResultSetMetaData metaData = rs.getMetaData(); // 메타데이터는 그냥 데이터의 속성? 같은거네
			// ▼메타데이터의 컬럼갯수를 저장
			int coulumnCount = metaData.getColumnCount();
			//if를 넣는이유 , 결과가 여러줄이면?
			if (rs.next()) { // 쿼리결과저장한 rs 객체를 next라는 메소드로 한줄씩 불러온다는 느낌?
				for (int i = 1; i <= coulumnCount; i++) { // 위에서구한 rs의 컬럼수만큼 돌릴거다 컬럼은 1부터 시작 가로로
					map.put(metaData.getColumnName(i), rs.getObject(i));
					// rs객체의 메타데이터에서 i번째 컬럼이름과, i번째 컬럼의값?을 오브잭트로꺼내서 위에서 만든
					// map해쉬맵에 string타입 컬럼이름(해쉬맵에서는 key역활이고), object값(데이터값) 넣음

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 닫아준다
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return map;

	}

	///////// 5번짼가int update(String sql)
	public int update(String sql) {
		int result = 0; //돌려줄 영향받은 행 개수?
		try {
			con = DriverManager.getConnection(url, user, password); // db연결

			ps = con.prepareStatement(sql); // 파라미터로 받은 sql 쿼리문을 preparedstatement 객체로 만듬
		
			// ▼쿼리실행하고 영향받은 행 수 ? 어쨌거나 저장
			result = ps.executeUpdate();
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 닫아준다
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return result;
	}

	/////////// 마지막 int update(String sql, List<Object> param)
	public int update(String sql, List<Object> param) {
		// 돌려줄 int 생성
		int result = 0;

		try {
			con = DriverManager.getConnection(url, user, password); // db연결

			ps = con.prepareStatement(sql); // 파라미터로 받은 sql 쿼리문을 preparedstatement 객체로 만듬
			for (int i = 0; i < param.size(); i++) { // 어레이리스트 param의 크기만큼 for문을 돌리겠다
				ps.setObject(i + 1, param.get(i)); // 물음표의값 구하기
				// ▲쿼리문의 물음표 1번째물음표에 , param 0번째 값을 넣겠다
			}
			// ▼쿼리실행하고 결과를 rs객체에 넣어둠
			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 닫아준다
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (ps != null)
				try {
					ps.close();
				} catch (Exception e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception e) {
				}
		}

		return result;

	}


}
