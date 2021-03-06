package kr.or.ddit.basic;
/*

메뉴예시)
=== 작업 선택 ===
  1. 자료 추가 
  2. 자료 삭제
  3. 자료 수정
  4. 전체 자료 출력
  0. 작업 끝.
---------------------------

처리조건)
1) 자료 추가에서 '회원ID'는 중복되지 않는다. (중복되면 다시 입력 받는다.)
2) 자료 삭제는 '회원ID'를 입력 받아서 처리한다.
3) 자료 수정에서 '회원ID'는 변경되지 않는다.
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

// Connection을 메서드마다 새로 쓰고 닫고 해야하는데
// 그러지못했음
// 제대로 한다면 수정해야함/ JdbcTest06T참고
public class JdbcTest06 {
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Scanner scan = new Scanner(System.in);
	

	
	public static void main(String[] args) {
		
		new JdbcTest06().start();
		
	
	
	}
	
	private void start() {
		while(true) {
		conn = DBUtil.getConnection();
		System.out.println("=== 작업 선택 ===");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 자료 수정");
		System.out.println("4. 전체 자료 출력");
		System.out.println("0. 작업 끝.");
		int result = scan.nextInt();
		switch(result) {
		case 1:
			insertDB();
			break;
		case 2:
			deleteDB();
			break;
			
		case 3:
			amendDB();
			break;
		case 4:
			allselect();
			break;
		case 0:
			System.exit(0);
			break;
		}
		}
	}
	
	private void insertDB() {	
		System.out.println("== 회원 정보 입력 ==");
		
		boolean flag = true;
		while(flag) {
		System.out.println("아이디 : ");
		String id = scan.next();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT MEM_ID FROM MYMEMBER WHERE MEM_ID = '"+id+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				System.out.println("입력한 "+id+"는 이미 있는 아이디입니다");
			}else {
				flag = false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("패스워드 : ");
		String pass = scan.next();
		System.out.println("회원이름 : ");
		String name = scan.next();
		System.out.println("회원전화번호 : ");
		String phone = scan.next();
		System.out.println("회원주소 : ");
		String addr = scan.next();
		
		String sql = "INSERT INTO MYMEMBER VALUES(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			pstmt.setString(3, name);
			pstmt.setString(4, phone);
			pstmt.setString(5, addr);
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("등록 성공!!!");
			}else {
				System.out.println("등록 실패ㅠㅠㅠ");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(stmt!=null) try {stmt.close();} catch(SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	}
	}
	
	private void deleteDB() {
		System.out.println("== 회원 정보 입력 ==");
		
		boolean flag = true;
		while(flag) {
		System.out.println("삭제할 아이디 : ");
		String id = scan.next();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT MEM_ID FROM MYMEMBER WHERE MEM_ID = '"+id+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				sql = "DELETE FROM MYMEMBER WHERE MEM_ID='" + id + "'";
				int result = stmt.executeUpdate(sql);
				if(result>0) {
				System.out.println("삭제 성공!!!");
				flag = false;
				}else {
					System.out.println("삭제 실패ㅠㅠ");
					flag = false;
				}
			}else {
				System.out.println("그런아이디는 없어용");
				flag = false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	
	private void amendDB() {
		System.out.println("== 자료 수정 ==");
		boolean flag = true;
		while(flag) {
		System.out.println("수정할 아이디 : ");
		String id = scan.next();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT MEM_ID FROM MYMEMBER WHERE MEM_ID = '"+id+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				System.out.println("수정할 항목은 뭔가용?~");
				System.out.println("1.비밀번호 2.이름 3.전화번호 4.주소");
				int result = scan.nextInt();
				switch(result) {
				case 1:
					System.out.println("새로운 비밀번호 입력 : ");
					String pass = scan.next();
					sql = "UPDATE MYMEMBER SET MEM_PASS = '"+pass+"' WHERE MEM_ID = '"+id+"'";
					result = stmt.executeUpdate(sql);
					if(result>0) {
					System.out.println("수정 성공!!!");
					}else {
						System.out.println("수정 실패 ㅠㅠ");
					}
					break;
				case 2:
					System.out.println("새로운 이름 입력 : ");
					String name = scan.next();
					sql = "UPDATE MYMEMBER SET MEM_NAME = '"+name+"' WHERE MEM_ID = '"+id+"'";
					result = stmt.executeUpdate(sql);
					if(result>0) {
					System.out.println("수정 성공!!!");
					}else {
						System.out.println("수정 실패 ㅠㅠ");
					}
					break;
				case 3:
					System.out.println("새로운 전화번호 입력 : ");
					String phone = scan.next();
					sql = "UPDATE MYMEMBER SET MEM_TEL = '"+phone+"' WHERE MEM_ID = '"+id+"'";
					result = stmt.executeUpdate(sql);
					if(result>0) {
					System.out.println("수정 성공!!!");
					}else {
						System.out.println("수정 실패 ㅠㅠ");
					}
					break;
				case 4:
					System.out.println("새로운 주소 입력 : ");
					String addr = scan.next();
					sql = "UPDATE MYMEMBER SET MEM_ADDR = '"+addr+"' WHERE MEM_ID = '"+id+"'";
					result = stmt.executeUpdate(sql);
					if(result>0) {
					System.out.println("수정 성공!!!");
					}else {
						System.out.println("수정 실패 ㅠㅠ");
					}
					break;
				}
				
			}else {
				System.out.println("그런아이디는 없어용");
				flag = false;
			}
			flag = false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}
	
	private void allselect() {
		
		String sql = "SELECT * FROM MYMEMBER";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("아이디\t비밀번호\t이름\t전화번호\t주소");
			while(rs.next()) {
			System.out.print(rs.getString(1));
			System.out.print("\t"+rs.getString(2));
			System.out.print("\t"+rs.getString(3));
			System.out.print("\t"+rs.getString(4));
			System.out.print("\t"+rs.getString(5)+"\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}

 
