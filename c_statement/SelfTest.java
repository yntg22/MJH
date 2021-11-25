package c_statement;

import java.util.Scanner;

public class SelfTest {

	public static void main(String[] args) {
		// 3개 : 주의! 위험한 수준은 아니지만 관리가 필요함
		// 4~6개 : 위험! 탄수화물 섭취를 줄이기 위한 식습관 개선이 필요함
		// 7개 이상 : 중독! 전문의 상담이 필요함.
		Scanner s = new Scanner(System.in);
		int sum = 0;
		
		System.out.print("아침을 배불리 먹은 후 점심시간 전에 배가 고프다.(O,X)");
		String num = s.nextLine();
		if(num.equals("O")) {
			sum = sum + 1;
		}
		System.out.print("밥,빵,과자 등의음식을 먹기 시작하면 끝이 없다.");
		num = s.nextLine();
		if(num.equals("O")) {
			sum = sum + 1;
		}
		System.out.print("음식을 금방 먹은 후에도 만족스럽지 못하고 더 먹는다.");
		num = s.nextLine();
		if(num.equals("O")) {
			sum = sum + 1;
		}
		System.out.print("정말 배가 고프지 않더라도 먹을 때가 있다.");
		num = s.nextLine();
		if(num.equals("O")) {
			sum = sum + 1;
		}
		System.out.print("저녁을 먹고 간식을 먹지 않으면 잠이 오지 않는다.");
		num = s.nextLine();
		if(num.equals("O")) {
			sum = sum + 1;
		}
		System.out.print("스트레스를 받으면 자꾸 먹고 싶어진다.");
		num = s.nextLine();
		if(num.equals("O")) {
			sum = sum + 1;
		}
		System.out.print("책상이나 식탁 위에 항상 과자, 초콜릿 등이 놓여있다.");
		num = s.nextLine();
		if(num.equals("O")) {
			sum = sum + 1;
		}
		System.out.print("오후 5시가 되면 피곤함과 배고픔을 느끼고 일이 손에 안 잡힌다.");
		num = s.nextLine();
		if(num.equals("O")) {
			sum = sum + 1;
		}
		System.out.print("과자, 초콜릿 등의 단 음식은 상상만 해도 먹고 싶어진다.");
		num = s.nextLine();
		if(num.equals("O")) {
			sum = sum + 1;
		}
		System.out.print("다이어트를 위해 식이조절을 하는데 3일도 못 간다.");
		num = s.nextLine();
		if(num.equals("O")) {
			sum = sum + 1;
		}
		if(sum <= 3) {
		System.out.println(sum+"개: 주의! 위험한 수준은 아니지만 관리가 필요함" );
		}else if (sum <= 6) {
			System.out.println(sum+"개: 위험! 탄수화물 섭취를 줄이기 위한 식습관 개선이 필요함." );
		}else if (sum >= 7) {
			System.out.println(sum+"개: 중독! 전문의 상담이 필요함" );
	}

	
		
		
		
		
		
		
	}
}
