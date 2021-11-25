package m_jh;

import java.util.Scanner;

public class Mp2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(true) {
		System.out.print("숫자입력: ");
		int num3 = Integer.parseInt(s.nextLine());
		if(num3 == 1 || num3 == 3) {
			System.out.println("남자");}
			else if (num3 == 2 || num3 == 4) {
				System.out.println("여자");
			}
			else {
				System.out.println("확인불가");
				break;
			}
		}
	}

}
