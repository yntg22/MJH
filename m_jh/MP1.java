package m_jh;

import java.util.Scanner;

public class MP1 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("=======회원가입=======");
		System.out.print("아이디>");
		String id = s.nextLine();
		System.out.print("비밀번호>");
		int password = Integer.parseInt(s.nextLine());
		System.out.print("이름>");
		String name = s.nextLine();
		System.out.print("나이>");
		int age = Integer.parseInt(s.nextLine());
		System.out.print("키>");
		double height = Double.parseDouble(s.nextLine());
		System.out.println("=================");
		System.out.println("회원가입 완료");
		System.out.println("======내정보========");
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + password);
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age + "세");
		System.out.println("키 : " + height + "cm");
		System.out.println("==================");		
		
		
		long res = 123456 + 654321;
		res = res * 123456;
		res /= 123456;
		res -= 654321;
		res %= 123456;
		System.out.println(res);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
