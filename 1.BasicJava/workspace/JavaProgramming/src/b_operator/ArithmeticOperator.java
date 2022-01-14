package b_operator;

import java.util.Scanner;

public class ArithmeticOperator {

	public static void main(String[] args) {
		/*
		 * 
		 * 산술 연산자
		 * - 사칙연산자 : +, -, *, /, %(나머지)
		 * - 복합연산자 : +=, -=, *=, /=, %=
		 * - 증감연산자 : ++, --
		 */
		
		int result = 10 + 20 - 30 * 40 / 50 % 60;
		
		//나머지 연산
		result = 10 / 3; //몫
		System.out.println(result);
		result = 10 % 3; //나머지
		System.out.println(result);
		
		//5개의 산술연산자를 사용해 5개의 연산을 수행 후 결과를 출력해주세요.

		result = 10 + 3; 
		System.out.println("10 + 3 = " + result);

		result = 10 - 3; 
		System.out.println("10 - 3 = " + result);

		result = 10 * 3; 
		System.out.println("10 * 3 = " + result);

		result = 10 / 3; 
		System.out.println("10 / 3 = " + result);

		result = 10 % 3; 
		System.out.println("10 % 3 = " + result);
	
		//복합연산자
		result = result + 3;
		result += 3;
		
		result -= 5;
		
		//아래의 문장을 복합연산자를 사용한 문장으로 만들어주세요.
		//result = result + 10;
		
		//result = result % 5;
		
		//result = result - 2 * 3;
		
		result += 10;
		result %= 5;
		result -= 2 * 3;
		
		//증감연산자
		//증감연산자(++) : 변수의 값을 1 증가시킨다
		//감소연산자(--) : 변수의 값을 1 감소시킨다.
		int i = 0;
		
		++i; //전위형 : 변수의 값을 읽어오기 전에 1 증가된다.
		i++; //후위형 : 변수의 값을 읽어온 후에 1 증가된다.
		--i;
		i--;
		
		i = 0;
		System.out.println("++i = " + ++i);
		i = 0;
		System.out.println("i++ = " + i++);
		System.out.println(i);
		
		//피연산자의 타입이 서로 같아야만 연산이 가능하다.
		int _int = 10;
		double _double = 3.14;
		double result2 = _int + _double; //표현범위가 더 큰 타입으로 형변환 된다.
		
		int result3 = _int + (int)_double;
		
		byte _byte = 5;
		short _short = 10;
		_int = _byte + _short; //int(4byte)보다 작은 타입은 int(4byte)로 형변환 된다.
		
		char _char = 'a';
		char _char2 = 'b';
		_int = _char + _char2;
		System.out.println(_int);
		
		
		//오버플로우, 언더플로우
		//표현범위를 벗어나는 값을 표현할 때 발생하는 현상
		byte b = 127;
		b++;
		System.out.println(b);
		b--;
		System.out.println(b);
		
		
		//다음을 한줄씩 계산해서 최종 결과값을 출력해주세요
		long result5 = 123456 + 654321;
		System.out.println(result5);
		System.out.println(result5*=123456);
		System.out.println(result5/=123456);
		System.out.println(result5-=654321);
		System.out.println(result5%=123456);
		
		//3개의 int타입 변수를 선언 및 초기화 후 합계와 평균을 구해주세요.
		int p1 = 10, p2 = 20, p3 = 50;
		int result6 = p1 + p2 + p3;
		double result7 = result6 / 3.0; //소수점이 안나옴
		System.out.println("합계 : " +result6 + "\n평균 : " + result7);
		
		//반올림
		result7 = Math.round(result7*10) / 10.0; //소수점 첫째자리에서 반올림해준다.
		System.out.println(result7);
		
		//랜덤*
		//Math.random() : 0.0 ~ 1.0미만 
		int random = (int)(Math.random() * 10) + 1; //1~100사이
		System.out.println(random);
		
		
		
		
		
		
		
		
	}

}
