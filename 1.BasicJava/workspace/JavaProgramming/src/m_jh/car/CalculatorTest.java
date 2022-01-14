package m_jh.car;

import java.util.Scanner;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator sc = new Calculator();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("숫자 1 >");
		int x = Integer.parseInt(s.nextLine());
		System.out.println("연산자");
		String y = s.nextLine();
		System.out.println("숫자 2 >");
		int z = Integer.parseInt(s.nextLine());
		
		if(y == "+") {
			int result = sc.plus(x, z);
			System.out.println(result);
		}
		

	}

}
