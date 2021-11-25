package b_operator;

public class ComparingOperator {

	public static void main(String[] args) {
		
		/*
		 * 비교 연산자
		 * - <, >, <=, >=, ==, !=
		 * - 문자열 비교 : equals()
		*/
		
		int x = 10;
		int y = 20;
		
		boolean b = x < y;
		System.out.println(b);
		
		b = x <= y - 15; //산술연산이 비교연산보다 우선순위가 높다.*
		
		String str1 = "abc";
		String str2 = "ABC";
		b = str1 != str2; //주소비교
		System.out.println(b);
		
		//데이터
		//기본형, 참조형(배열, 클래스)
		//문자열1.equals(문자열2) !문자열1.equals(문자열2)
		b = !str1.equals(str2);
		System.out.println(b);
		
		//다음의 문장들을 코드로 작성해주세요.
		//x는 y보다 작거나 같다.
		boolean c = x <= y;
		//x+5와 y는 같다.
		c = x + 5 == y;
		//y는 홀수이다.
		c = y % 2 == 1;
		//"기본형"과 참조형"은 다르다
		c = !"기본형".equals("참조형");
		
		
		
		
		
				
		
		
		
		
		
		
		
		
	}

}
