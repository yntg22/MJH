package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class LprodIbatisTest {
	// iBatis를 이용하여 DB자료를 처리하는 방법 및 순서
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SqlMapClient smc = null;
		
		// 1. iBatis의 환경설정 파일을 읽어와 실행한다.
		//		(sqlMapConfig.xml문서 읽어와서 처리하기)
		
		try {
			// 1-1. 문자 인코딩 캐릭터셋 설정
			Charset charset = Charset.forName("utf-8");
			Resources.setCharset(charset);
			
			// 1-2. 환경설정파일을 읽어온다.
			Reader rd = Resources.getResourceAsReader("kr/or/ddit/config/sqlMapConfig.xml");
			
			// 1-3. 위에서 읽어온 Reader객체를 이용하여 실제 환경설정을 완성한 후
			//		SQL문을 호출해서 실행할 수 있는 객체를 생성한다.
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//--------------------------------------------------------------------------------
		// 2. 실행한 SQL문에 맞는 쿼리문을 호출해서 원하는 작업을 수행한다.
		
		try {
/*			// 2-1. insert 작업
			System.out.println("insert작업 시작...");
			System.out.print("Lprod_id 입력 : ");
			int lprodId = scan.nextInt();
			
			System.out.print("Lprod_gu 입력 : ");
			String lprodGu = scan.next();
			
			System.out.print("Lprod_nm 입력 : ");
			String lprodNm = scan.next();
			
			// 입력한 데이터를 VO객체에 저장한다.
			LprodVO lprodVo = new LprodVO();
			lprodVo.setLprod_id(lprodId);
			lprodVo.setLprod_gu(lprodGu);
			lprodVo.setLprod_nm(lprodNm);
			
			// 2) 위에서 생성한 SqlMapClinet객체변수를 이용하여 처리할 쿼리문을 호출하여 실행한다.
			// 	형식) smc.insert("namespace값.id값". 파라미터클래스);
			//		반환값: insert성공 : null, insert실패 : 오류객체
			
			Object obj = smc.insert("ibatisTest.insertLprod", lprodVo);
			if(obj==null) {
				System.out.println("insert 성공!!!");
			}else {
				System.out.println("insert 실패ㅠㅠㅠ");
			}
			System.out.println("-----------------------------------------------");
			*/
			
			// 2-2. update작업
			/*System.out.println("update작업 시작...");
			System.out.print("수정할 Lprod_gu 입력 : ");
			String lprodGu2 = scan.next();
			
			System.out.print("새로운 Lprod_id 입력 : ");
			int lprodId2 = scan.nextInt();
			
			System.out.print("새로운 Lprod_nm 입력 : ");
			String lprodNm2 = scan.next();
			
			// 1) 입력한 값을 VO객체에 저장한다
			LprodVO lprodVo2 = new LprodVO();
			lprodVo2.setLprod_id(lprodId2);
			lprodVo2.setLprod_gu((lprodGu2 + "    ").substring(0,4));
			lprodVo2.setLprod_nm(lprodNm2);
			
			// 2) smc.update("namespace값.id값", 파라미터클래스);
			// 반환값 : 작업에 성공한 레코드 수
			int cnt = smc.update("ibatisTest.updateLprod", lprodVo2);
			if(cnt>0) {
				System.out.println("update 작업 성공!!!");
			}else {
				System.out.println("update 작업 실패ㅠㅠㅠ");
			}
			System.out.println("------------------------------------------------");
			*/
			
			/*// 2-3 delete작업
			System.out.println("delete작업 시작...");
			
			System.out.print("삭제할 Lprod_gu 입력 : ");
			String lprodGu3 = scan.next();
			
			lprodGu3 = (lprodGu3 + "     ").substring(0,4);
			
			// 1) 형식) smc.delete("namespace값.id값", 파라미터클래스)
			// 반환값 : 작업에 성공한 레코드 수
			int cnt2 = smc.delete("ibatisTest.deleteLprod",lprodGu3);
			
			if(cnt2>0) {
				System.out.println("delete 작업 성공!!!");
			}else {
				System.out.println("delete 작업 실패 ㅠㅠㅠ");
			}
			System.out.println("------------------------------------------------");
			*/
			
			// 2-4 select 작업
			
			/*// 1) 응답 결과가 여러개인 경우
			System.out.println("select 작업 시작(결과가 여러개인 경우)...");
			
			// 형식) smc.queryForList("namespace값.id값", 파라미터클래스)
			//		==> 응답 결과가 여러개일 경우에 사용하고, 이 메서드는
			//			여러개의 레코드 각각을 VO에 담은 후 이 VO를 List에 추가해 준다.
			List<LprodVO> lprodList = smc.queryForList("ibatisTest.getAllLprod");
			
			for(LprodVO lvo : lprodList) {
				System.out.println("ID : " + lvo.getLprod_id());
				System.out.println("GU : " + lvo.getLprod_gu());
				System.out.println("NM : " + lvo.getLprod_nm());
				System.out.println("----------------------------");
			}
			System.out.println("출력 끝...");*/
			
			// 2) 응답결과가 1개일 경우
			System.out.println("select 시작(결과가 1개일 경우");
			System.out.print("검색할 Lprod_gu 입력 : ");
			String lprodGu4 = scan.next();
			
			// 응답 결과가 1개의 레코드가 확실할 경우에는 queryForObject()메서드를 사용한다.
			// 형식) smc.queryForObject("namespace값.id값", 파라미터클래스)
			// 		반환값 : (1) 처리결과가 여러개일 경우 ==> Exception 반환
			//			   (2) 처리결과가 1개일 경우 ==> 해당 객체 반환 (정상적인 경우)
			//			   (3) 처리결과가 없을 경우 ==> null
			
			LprodVO lvo2 = (LprodVO) smc.queryForObject("ibatisTest.getLprod",lprodGu4);
			
			if(lvo2==null) {
				System.out.println("검색한 데이터가 하나도 없습니다.");
				return;
			}
			System.out.println("   ===  검색 결과  ===   ");
			System.out.println("ID : " + lvo2.getLprod_id());
			System.out.println("GU : " + lvo2.getLprod_gu());
			System.out.println("NM : " + lvo2.getLprod_nm());
			System.out.println("----------------------------");
			System.out.println("출력 끝...");
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
