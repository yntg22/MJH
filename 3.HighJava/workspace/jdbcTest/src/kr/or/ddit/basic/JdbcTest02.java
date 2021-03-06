package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
	문제) 사용자로부터 Lprod_id값을 입력받아 입력한 값보다 Lprod_id가 큰 자료를 출력하시오.
	
*/

public class JdbcTest02 {
	public static void main(String[] args) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"MJH96",
						"java");
				
				String sql = "SELECT * FROM LPROD WHERE LPROD_ID > ";
				
				System.out.println("LPORD_ID 입력 : ");
//				System.out.println("LPORD_NM 입력 : ");
				
				Scanner s = new Scanner(System.in);
				
				sql += s.nextLine();
				
				stmt = conn.createStatement();
				
				rs = stmt.executeQuery(sql);
				System.out.println("쿼리결과");
				while(rs.next()) {
					
					System.out.println("Lprod_id : " + rs.getInt("lprod_id"));
					System.out.println("Lprod_gu : " + rs.getString(2));
					System.out.println("Lprod_nm : " + rs.getString("LPROD_NM"));
					System.out.println("---------------------------------------");
				}
				
			} catch (SQLException e) {
				// TODO: handle exception
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
