package b_operator;

public class LogicalOperator {

	public static void main(String[] args) {
		/*
		 * 논리 연산자
		 * - 순서대로 우선순위 &&(AND), ||(OR), !(NOT)
		 * - 피연산자로 boolean만 허용한다.
		 * 
		 * 
		 */
		
		int x = 10;
		int y = 20;
		
		boolean b = 0 < x && x < 10 || x < y;
		//산술연산 > 비교연산 > 논리연산 
		
		b = !(x < y);
		System.out.println(b);
		
		//효율적 연산
		b = true && true; //true
		b = true && false; //false
		b = false && true; //false
		b = false && false; //false
				
		b = true || true; //true
		b = true || false; //true
		b = false || true; //true
		b = false || false; //false
		//왼쪽의 피연산자에서 결과가 정해지면 오른쪽은 수행하지 않는다.
		
		int a = 10;
		b = a < 5 && 0 < a++; //a가 증가되지않음*
		System.out.println(a);
	
		//다음의 문장들을 코드로 작성해주세요.
		//x가 y보다 크고 x가 10보다 작다.
		b = x > y && x < 10;
		//x가 짝수이고 y보다 작거나 같다
		b = x % 2 == 0 && x <= y;
		//x가 3의 배수이거나 5의 배수이다.
		b = x % 3 == 0 || x % 5 == 0;
	
	}

}
