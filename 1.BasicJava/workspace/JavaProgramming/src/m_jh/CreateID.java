package m_jh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import e_oop.ScanUtil;

public class CreateID {
	void CreateID() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "MJH96";
		String password = "java";
		
		//try catch사용하기위해 만듬
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {//DriverManager클래스를 이용하여 서로다른것들간에 상호작용을 하게해 주는 다리역활
			con = DriverManager.getConnection(url, user, password); //오라클에 연결
			
			System.out.print("ID >");
			String id = ScanUtil.nextLine();
			System.out.print("PASSWORD >");
			String pass = ScanUtil.nextLine();
			System.out.print("NAME >");
			String name = ScanUtil.nextLine();
			System.out.print("REGNO1 >");
			String regno1 = ScanUtil.nextLine();
			System.out.print("REGONO2 >");
			String regno2 = ScanUtil.nextLine();
			System.out.print("ZIP >");
			String zip = ScanUtil.nextLine();
			System.out.print("ADD1 >");
			String add1 = ScanUtil.nextLine();
			System.out.print("ADD2 >");
			String add2 = ScanUtil.nextLine();
			System.out.print("HOMETEL >");
			String hometel = ScanUtil.nextLine();
			System.out.print("COMTEL >");
			String comtel = ScanUtil.nextLine();
			System.out.print("MAIL >");
			String mail = ScanUtil.nextLine();
			
			String sql = "insert into member (mem_id,mem_pass,mem_name,mem_regno1,mem_regno2,mem_zip,mem_add1,mem_add2,"
					+ "mem_hometel,mem_comtel,mem_mail) "
					+ "values ('"+id+"','"+pass+"','"+name+"','"+regno1+"','"+regno2+"','"+zip+"','"+add1+"','"+add2+"','"+hometel+"','"+comtel+"','"
					+ mail+"')";
					
			ps = con.prepareStatement(sql);
			
			//select
			
			//insert, update, delete
			int result = ps.executeUpdate(); //리턴타입 int
			System.out.println(result+"회원가입 완료");
					//▽*next를 호출해야 결과의 첫번째 줄을 바라보고, 첫번째줄에서 결과를 추출할수있게된다 다음 또 next를 호출하면 그 다음줄로 간다 다음줄이 있으면 true 없으면 false
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { //닫아준다
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(con != null) try { con.close(); } catch(Exception e) {}
		}
	}
}
