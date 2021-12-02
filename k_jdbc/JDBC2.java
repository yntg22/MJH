package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC2 {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "MJH96";
		String password = "java";
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password); //연결
			
			String sql = "select * from cart"
					+ " where cart_member = ?"
					+ " and cart_qty > ?"; // ? <= 넣고싶은[값]만 대신할수있음
			ps = con.prepareStatement(sql);
			ps.setString(1, "a001"); // ps.setString(1<=물음표의 인덱스 , 넣을값)
			ps.setInt(2, 5);
			
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData(); //메타데이터 : 데이터에 대한 데이터
			
			int columnCount = metaData.getColumnCount(); //컬럼의 수 
			
			while(rs.next()) {
				for(int i = 1; i <= columnCount; i++) {
					Object value = rs.getObject(i); //타입을 그냥 object로
					System.out.print(value + "\t");
				}
				System.out.println();
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
