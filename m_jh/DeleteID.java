package m_jh;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.ResultSetMetaData;
	import java.sql.SQLException;

	public class DeleteID {

		public static void main(String[] args) {
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "MJH96";
			String password = "java";
			
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				con = DriverManager.getConnection(url, user, password); //연결
				
				String sql = "delete from member where mem_id='skek'"; // ? <= 넣고싶은[값]만 대신할수있음
				ps = con.prepareStatement(sql);
				int result = ps.executeUpdate(); //리턴타입 int
				System.out.println(result+"회원가입 완료");
				
			
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally { //닫아준다
				if(rs != null) try { rs.close(); } catch(Exception e) {}
				if(ps != null) try { ps.close(); } catch(Exception e) {}
				if(con != null) try { con.close(); } catch(Exception e) {}
			}
			
			
			
			
			

		}

	}

