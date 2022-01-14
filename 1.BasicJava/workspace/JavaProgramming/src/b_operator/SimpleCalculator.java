package b_operator;

import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		//두개의 숫자와 연산자를 입력받아 연산결과를 알려주는 프로그램을 만들어주세요
		Scanner s = new Scanner(System.in);
		
		System.out.print("숫자1 입력 : ");
		int num1 = Integer.parseInt(s.nextLine());
		
		System.out.print("연산자 입력 : ");
		String cal = s.nextLine();

		System.out.print("숫자2 입력 : ");
		int num2 = Integer.parseInt(s.nextLine());

		
		System.out.println(cal.equals("+") ? num1 + num2 : 
			(cal.equals("-") ? num1 - num2 :
			(cal.equals("*") ? num1 * num2 :
			(cal.equals("/") ? num1 / num2 :
			(cal.equals("%") ? num1 % num2 : "연산자오류"))
				)));
		
		/* int result = cal.equals("+") ? num1 + num2
				: cal.equals("-") ? num1 - num2
				: num1 % num2;
		*/
		
		
		
		
		
		
		
		
		
	}

}
