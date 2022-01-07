package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		
		//PreparedStatement
		PreparedStatement pstmt= null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "MJH96", "java");
			
			System.out.println("계좌 번호 정보 추가하기");
			System.out.println();
			System.out.print("계좌번호 >> ");
			String bankNo = scan.next();
		
			System.out.print("은행이름 >> ");
			String bankName = scan.next();

			System.out.print("예금주 이름 >> ");
			String bankUserName = scan.next();
			
/*			// Statement객체를 이용한 데이터 추가 작업
			String sql = "insert into bankinfo (bank_no, bank_name,bank_user_name,bank_date) "
					   + "values ('"+ bankNo +"','"+ bankName +"','"+bankUserName+"',sysdate)";
//			System.out.println(sql);
			
			stmt = conn.createStatement();
			
			// SQL문 실행하기
			// SELECT문을 실행할 때는 executeQuery()메서드를 사용하고,
			// INSERT, UPDATE, DELETE 등과 같이 SELECT문이 아닌 SQL문을 실행할 때는
			// executeUpdate()메서드를 사용한다.
			
			// executeUpdate()메서드의 반환값 ==> 작업에 성공한 레코드 수를 반환한다.
			int cnt = stmt.executeUpdate(sql);*/
			
			// ★★ PreparedStatement 객체를 이용하여 처리하기 ★★
			
			// SQL문장 중에서 데이터가 들어갈 자리를 물음표(?)로 표시하여 작성한다.
			String sql = "insert into bankinfo (bank_no, bank_name,bank_user_name,bank_date)"
					+ " values (?,?,?,sysdate)";
			
			// PreparedStatement 객체를 생성한다
			//		==> 이 때 처리할 SQL문장을 인수값으로 넣어준다.
			pstmt = conn.prepareStatement(sql);
			
			// SQL문장의 물음표(?)자리에 들어갈 데이터를 셋팅한다.
			// 형식) pstmt.set자료형이름(물음표번호, 데이터값)
			pstmt.setString(1, bankNo);
			pstmt.setString(2, bankName);
			pstmt.setString(3, bankUserName);
			
			// 데이터의 셋팅이 완료되면 쿼리문을 실행한다.
			// 실행할 SQL문이 SELECT문이면 executeQuery()메서드를 사용하고
			// SELECT문 이외의 문자이면 executeUpdate()메서드를 사용한다.
			int cnt = pstmt.executeUpdate();
			
			System.out.println("반환값 : " + cnt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(stmt!=null)try {stmt.close();}catch(SQLException e) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
			
		}

	}

}
