package kr.or.ddit.basic;
// JavaDoc문서 파일 만들기 예제

/**
 *
 * @author PC-01
 * @version 1.0
 *  
 * <p>
 * 파일명 : JavaDocTest.java <br>
 * 설 명 : JavaDoc문서 작성을 위한 연습용 Interface<br><br>
 * 
 * 수정 이력<br>
 * ----------------------------------------------<br>
 * 수정일자 : 2020-01-11<br>
 * 작업자 : 민진홍<br>
 * 수정내용 : 최초 생성<br>
 * 
 * </p>
 */

public interface javaDocTest {
	/**
	 * 메서드명 : methodTest<br>
	 * 설 명 : 반환값이 없는 메서드<br>
	 * 
	 * @param a 첫번째 매개변수(정수형)<br>
	 * @param b 두번째 매개변수(정수형)<br>
	 */
	public void methodTest(int a, int b);
	
	/**
	 * 메서드명 : methodAdd
	 * 설 명 : 반환값이 있는 메서드
	 * 
	 * @param x 정수형 매개변수(첫번째)
	 * @param y 정수형 매개변수(두번째)
	 * @return 처리된 결과를 정수형으로 반환한다.
	 */
	public int methodAdd(int x, int y);
	
	/**
	 * 메서드명 : methodSub<br>
	 * 설 명 : 매개변수가 없는 메서드<br>
	 * 
	 * @return 정수형으로 반환한다.
	 */
	public int methodSub();
}
