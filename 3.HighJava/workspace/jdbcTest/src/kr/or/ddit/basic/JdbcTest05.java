package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
	Lprod테이블에 새로운 데이터를 추가해보자.
	
	Lprod_Gu와 lprod_Nm은 사용자로부터 직접 입력 받아서 처리하고,
	Lprod_Id는 현재의 Lprod_Id값 중에서 제일 큰 값보다 1크게 지정한다.
	
	입력 받은 Lprod_Gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다.
	
	쿼리문3개 제일큰값보다1큰값 찾기 max씀
	select nvl(max(lprod_id),0) from lprod;
	select count(*) from lprod where lprod_gu ='p202';
	
	* Statement와 PreparedStatement의 차이점 *
	Statement를 사용하면 매번 쿼리를 수행할 때마다 4단계를 거치게 되고(계속적으로 단계를 거치면서 수행)

	PreparedStatement는 처음 한 번만 세 단계를 거친 후 캐시에 담아 재사용을 한다는 것이다.
	 만약 동일한 쿼리를 반복적으로 수행한다면 PreparedStatment가 DB에 훨씬 적은 부하를 주며, 성능도 좋다.
	
*/

public class JdbcTest05 {

	public static void main(String[] args) {
		//Connection 선언
		Connection conn = null;

		
		//Statement 선언 => 물음표(?)가 없는 쿼리를 수행하기 위해서 사용하였음
		Statement stmt = null;
	
		//SELECT문을 실행한 결과를 담기위해 ResultSet 선언
		ResultSet rs = null;
		
		//PreparedStatement 선언 => 물음표(?)가 있는 쿼리를 편하게? 사용하기 위해
		PreparedStatement pstmt = null;

		//입력받을 스캐너 선언
		Scanner s = new Scanner(System.in);
		
		try {
			//오라클 드라이버를 불러오기 위함?
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//DB연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MJH96", "java");
			
			//LPROD_GU를 입력받기위해 선언
			String gu = "";
			
			//while문을 사용하여 LPROD_GU가 중복이 아닐떄까지 수행하기 위함
			while(true) {
				
			System.out.println("LPROD_GU 입력 : ");
			
			//입력받은 값을 gu변수에 저장
			gu = s.next();
			
			//sql문 작성 => LPROD_GU가 중복인지 검사하기 위함
			String sql = "select count(*) from lprod where lprod_gu ='"+gu+"'";
			
			//Statement를 생성하고
			stmt = conn.createStatement();
			
			//Statement에 sql문을 넣어서 실행하고 ResultSet에 저장한다
			rs = stmt.executeQuery(sql);
			
			//rs.next()로 포인터를 옮겨서 값이 있는지 확인? 어쨋든
			rs.next();
			//rs.next()로 확인한 row?에 1번index에 값이 1이면 이미 존재하는 LPORD_GU이다.
			//원래는 rs.getInt(1) > 1 로 표현할 수 있지만 primary key 이기 때문에 어차피 한개밖에 안나온다?
			if(rs.getInt(1)==1) {
				System.out.println("GU 중복 다시입력");
			}else {
				//중복이 아니면 while문을 빠져나간다.
				break;
			}
			}
			
			//LPROD_NM 입력받기
			System.out.println("LPORD_NM 입력 : ");
			String nm = s.next();
			
			// 1. select nvl(max(lprod_id),0) from lprod; 을 이용해서 DB에 있는 LPROD_ID의 가장 큰 값을 먼저 구하고. 
			String sql = "select nvl(max(lprod_id),0) from lprod";
			stmt = conn.createStatement();
			
			// 2. 1번의 결과를 rs에 저장
			rs = stmt.executeQuery(sql);
			
			rs.next();
			// 3. 구한 값에 +1을 하여 id에 저장
			int id = rs.getInt(1)+1;
			
			//마지막 저장단계 sql문 작성 => 물음표(?)를 사용하기 위해서 PrepareStatement를 사용했다
			sql = "INSERT INTO LPROD VALUES(?,?,?)";
			
			//작성한 sql문을 넣어서 저장?
			pstmt = conn.prepareStatement(sql);
			
			//위에서 받은 정보들로 물음표의 값을 세팅해준다.
			pstmt.setInt(1, id);
			pstmt.setString(2, gu);
			pstmt.setString(3, nm);
			
			//실행 후 반환값(작업성공 레코드 수)을 result에 저장
			int result = pstmt.executeUpdate();
			
			//결과 출력
			System.out.println("반환값 : " + result);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
