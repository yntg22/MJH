package c_statement;

import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		//랜덤 3개 1~9뽑기
		int random1 = (int)(Math.random() * 9 + 1);
		int random2 = (int)(Math.random() * 9 + 1);
		int random3 = (int)(Math.random() * 9 + 1);
		
		
		while(random1 == random2 || random1 == random3 || random2 == random3) {
			random1 = (int)(Math.random() * 9 + 1);
			random2 = (int)(Math.random() * 9 + 1);
			random3 = (int)(Math.random() * 9 + 1);
			}
		
		

		
		//System.out.println(random1 + " " + random2 + " " + random3);
		//입력받기
		Scanner s = new Scanner(System.in);
		
		
		int strike = 0;
		while(strike != 3) {
			
			System.out.println("숫자 입력 1 > ");
			int a = Integer.parseInt(s.nextLine());
			System.out.println("숫자 입력 2 > ");
			int b = Integer.parseInt(s.nextLine());
			System.out.println("숫자 입력 3 > ");
			int c = Integer.parseInt(s.nextLine());
			
			
		strike = 0;
		int ball = 0;
		int out = 0;
		
		if(a == random1) {
			strike += 1;
		}else if(a == random2) {
			ball += 1;
		}else if(a == random3) {
			ball += 1;
		}else {
			out += 1;
		}
		
		if(b == random1) {
			ball += 1;
		}else if(b == random2) {
			strike += 1;
		}else if(b == random3) {
			ball += 1;
		}else {
			out += 1;
		}
		
		if(c == random1) {
			ball += 1;
		}else if(c == random2) {
			ball += 1;
		}else if(c == random3) {
			strike += 1;
		}else {
			out += 1;
		}
		
		String result = strike+"S"+ " " + ball+"B"+ " " + out+"O";
		System.out.println(result);
	}
		
		System.out.println("정답! 축하합니다");
	}

}

	








