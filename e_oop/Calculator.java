package e_oop;

public class Calculator {

	// +, -, *, /, % 다섯개의 연산을 수행할 수 있는 계산기 클래스를 만들어주세요
	//%mod -substract +add *multiply /divide 
	double plus(double x, double y) {
		return x+y;
	}
	
	double minus(double x, double y) {
		return x-y;
	}
	
	double rhqgkrl(double x, double y) {
		return x*y;
	}
	
	double sksnrl(double x, double y) {
		return x / y;
	}
	
	double skajwl(double x, double y) {
		return x % y;
	}
	
	public static void main(String[] args) {
		//Calculator 클래스를 사용해 다음을 계산해주세요.
		//다음을 한줄씩 계싼해서 최종 결과값을 출력해주세요.
		//1. 123456 + 654321
		//2. 1번의 결과값 * 123456
		//3. 2번의 결과값 / 123456
		//4. 3번의 결과값 - 654321
		//5. 4번의 결과값 % 123456
		Calculator sc = new Calculator();
		
		double result = sc.plus(123456,654321);
		result = sc.rhqgkrl(result,123456);
		result = sc.sksnrl(result,123456);
		result = sc.minus(result,654321);
		result = sc.skajwl(result,123456);
		
		System.out.println(result);
		
	}
	
}
