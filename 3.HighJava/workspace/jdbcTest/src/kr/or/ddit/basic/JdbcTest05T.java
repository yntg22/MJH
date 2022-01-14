package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

public class JdbcTest05T {

	public static void main(String[] args) {
		Connection conn = null;
		Scanner scan = new Scanner(System.in);
		
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 현재의 LPROD_ID값들 중에서 제일 큰 값보다 1 크게 한다.
		try {
			
			conn = DBUtil.getConnection();
			
			String sql = "select nvl(max(lprod_id),0) maxnum from lprod";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			int maxnum = 0;
			if(rs.next()) { //select한 결과가 1개의 레코드일 경우에는 if문으로 비교해도 된다.
				maxnum = rs.getInt(1); // 컬럼 번호로 선택
//				maxnum = rs.getInt("nvl(max(lprod_id), 0"); // 컬럼의 alias가 없으면 식이 '컬럼명'역할을 한다.
				maxnum = rs.getInt("maxnum"); //컬럼의 alias를 지정해서 선택
			}
			maxnum++; //SQL 질의에서 +1로 검색해도 가능하다.
			//------------------------------------------
			
			// 입력받은 LPROD_GU가 이미 등록되어 있으면 다시 입력 받아서 처리한다.
			String gu; // 상품 분류 코드(LPROD_GU)가 저장될 변수 선언
			
			int count = 0; //입력한 상품 분류 코드의 개수가 저장될 변수
			do {
				System.out.print("상품 분류 코드 입력 >> ");
				gu = scan.next();
				
				String sql2 = "SELECT COUNT(*) CNT FROM LPROD WHERE LPROD_GU = ? ";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, gu);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt("cnt");
				}
				if(count>0) {
					System.out.println("입력한 상품 분류 코드 " + gu + "는 이미 등록된 코드입니다.");
				}
			} while (count>0);
			//-------------------------------------------------
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {} // 아래 노란줄떄문에 닫아 주었따 ㅎ
			
			System.out.print("상품 분류명 입력>> ");
			String nm = scan.next();
			
			//-------------------------------------------------
			
			String sql3 = "INSERT INTO LPROD (LPROD_ID, LPROD_GU, LPROD_NM) VALUES (?,?,?)";
			
			pstmt = conn.prepareStatement(sql3); //노란줄의 의미 : 오류가 날수도있으니 경고? 위에서 한번 썼는데 또 쓰니까 뜸
			pstmt.setInt(1, maxnum);
			pstmt.setString(2, gu);
			pstmt.setString(3, nm);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
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
