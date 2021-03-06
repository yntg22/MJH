package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
	문제) Lprod_id값을 2개 입력받아서 두 값 중 작은값부터 큰값 사이의 자료를 출력하시오
*/

public class JdbcTest03 {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB연결
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"MJH96",
					"java");
			
			int num1 = 0;
			int num2 = 0;
			
			Scanner s = new Scanner(System.in);
			System.out.println("LPROD_ID 입력1 : ");
			num1 = s.nextInt();
			System.out.println("LPROD_ID 입력2 : ");
			num2 = s.nextInt();
			
			//가장 큰값과 작은값을 찾아주는 메서드를 이용하기
			int max;
			int min;
			max = Math.max(num1, num2);
			min = Math.min(num1, num2);
			
//			if(num2 < num1) {
//				int temp;
//				temp = num1;
//				num1 = num2;
//				num2 = temp;
//			}
			
			// 3. 쿼리문 작성
//			String sql = "SELECT * FROM LPROD WHERE LPROD_ID>="+min+" AND LPROD_ID<="+max;
			String sql = "SELECT * FROM LPROD WHERE LPROD_ID BETWEEN "+min+ " AND " + max;
			
					
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
		}finally {
			if(rs!=null) try {rs.close();}catch(SQLException e) {}
			if(stmt!=null) try {stmt.close();}catch(SQLException e) {}
			if(conn!=null) try {conn.close();}catch(SQLException e) {}
			
		}

	}

}
