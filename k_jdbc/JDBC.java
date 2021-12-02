package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {

	public static void main(String[] args) {
		/*
		 * JDBC(Java Database Connectivity)
		 * - 자바와 데이터베이스를 연결해주는 라이브러리
		 * - ojdbc : 오라클 JDBC
		 * 
		 * JDBC 작성 단계
		 * 1. Connection 생성(DB 연결)
		 * 2. Statement 생성(쿼리 작성)
		 * 3. Query 실행
		 * 4. ResultSet에서 결과 추출(select인 경우)
		 * 5. ResultSet, Statement, Connection 닫기
		 */
		
		//데이터베이스 접속 정보   //▽드라이버정보            //▽주소
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "MJH96";
		String password = "java";
		
		//try catch사용하기위해 만듬
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {//DriverManager클래스를 이용하여 서로다른것들간에 상호작용을 하게해 주는 다리역활
			con = DriverManager.getConnection(url, user, password); //오라클에 연결
			
			String sql = "select * from member"; 
			ps = con.prepareStatement(sql); //sql내용을 객체로 만듬
			
			//select
			rs = ps.executeQuery(); //sql실행결과를 rs객체로 만듬
			
			//insert, update, delete
//			int result = ps.executeUpdate(); //리턴타입 int
					//▽*next를 호출해야 결과의 첫번째 줄을 바라보고, 첫번째줄에서 결과를 추출할수있게된다 다음 또 next를 호출하면 그 다음줄로 간다 다음줄이 있으면 true 없으면 false
			while(rs.next()) {
				String memId = rs.getString(1); //타입이 VARCHAR2이기때문에 getString을 쓰고 String변수에 저장한다  | 컬럼인덱스와 컬럼명을 넘겨주는방법이 있다.
				String memPass = rs.getString("MEM_PASS"); //꺼낼데이터의 타입에 맞춰서 메소드가 달라짐
				System.out.println("MEM_ID : " + memId + " / MEM_PASS : " + memPass);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { //닫아준다
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
		
		
	}

}




	