package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.util.SqlMapClientFactory;

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
 
 	- SQL문이 들어있는 xml문서명 : jdbc.xml

*/

public class JdbcToIbatis {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SqlMapClient smc = SqlMapClientFactory.getSqlMapClient();
		
//		try {
//			Charset charset = Charset.forName("utf-8");
//			Resources.setCharset(charset);
//			
//			Reader rd = Resources.getResourceAsReader("kr/or/ddit/config/sqlMapConfig.xml");
//			
//			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
//			
//			rd.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		try {
			String lprodGu = "";
			System.out.println("=== LPROD 입력 시작 ===");
			while(true) {
			System.out.println("Lprod_gu 입력 : ");
			lprodGu = scan.next();
			
			int rs = (int) smc.queryForObject("jdbc.insertLprod1",lprodGu);
			
			if(rs > 0) {
				System.out.println("이미 있는 Lprod_gu임 다시 입력하삼");
				System.out.println("싫으삼");
			}else {
				break;
				}
			}
			
			System.out.println("Lprod_nm 입력 : ");
			String lprodNm = scan.next();
			
			LprodVO lprodVo = new LprodVO();
			lprodVo.setLprod_gu((lprodGu + "     ").substring(0,4));
			lprodVo.setLprod_nm(lprodNm);
			
			Object obj = smc.insert("jdbc.insertLprod2",lprodVo);
			if(obj==null) {
				System.out.println("insert 성공 !!!");
			}else {
				System.out.println("insert 실패ㅠㅠ");
			}
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		

	}

}
