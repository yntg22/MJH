package a_variable;

import java.util.Scanner;

public class Join {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 아래와 같은 프로그램을 만들어주세요.
		 * 
		 * ========== 회원가입 =========
		 * 아이디>admin
		 * 비밀번호(4자리숫자)>1234
		 * 이름>홍길동
		 * 나이>99
		 * 키>185.5
		 * ==========================
		 * 회원가입 완료
		 * =========내 정보=============
		 * 아이디 : admin
		 * 비밀번호 : 1234
		 * 이름 : 홍길동
		 * 나이 : 99세
		 * 키 : 185.5cm
		 * ==========================
		*/

		Scanner s = new Scanner(System.in);
		System.out.println("======= 회원가입 ========");
		System.out.print("아이디 > ");
		String id = s.nextLine();
		
		System.out.print("비밀번호(4자리숫자) > ");
		int pw = Integer.parseInt(s.nextLine());
		
		System.out.print("나이 > ");
		int age = Integer.parseInt(s.nextLine());
		
		System.out.print("키 > ");
		double key = Double.parseDouble(s.nextLine());
		
		System.out.println("===================== \n 회원가입 완료 \n========내 정보==========");
		System.out.println("아이디 : " + id );
		System.out.println("비밀번호 : " + pw );
		System.out.println("나이 : " + age );
		System.out.println("키 : " + key);
		System.out.println("=======================");
		
		
		
		
	}

}
