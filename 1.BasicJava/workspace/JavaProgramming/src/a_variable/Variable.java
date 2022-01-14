package a_variable;

import java.util.Scanner;
//Ctrl + Shift + o

public class Variable {

	public static void main(String[] args) {
		
	//한줄주석 Ctrl + Shift + c
	/*범위주석 Ctrl + Shift + / */
		
		//자료형
	//byte(1) short(2) *int(4) long(8)
	//float(4) *double(8)
	//char(2)
	//boolean(1)
		

	int int1 = 1;
	short short1 = 2;
	byte byte1 = 3;
	long long1 = 100L;
	float float1 = 3.14f;
	double double1 = 5.5;
	char char1 = '차';
	boolean boolean1 = true;
	
	
	//형변환
	float1 = (float)byte1;
	short1 = (short)int1;
		
	String str = "문자열";
	System.out.println(str);
	System.out.println(str + int1 + double1);
	System.out.println(int1 + double1 + str);
	
	System.out.println("탭은\t4칸에 맞춰 띄워줍니다");
	System.out.println("줄바꿈을\n해줍니다");
	System.out.println("\"쌍따옴표를 넣어줍니다.\"");
	System.out.println("\\역슬래시를 넣어줍니다.");
		
	//입력
	Scanner s = new Scanner(System.in);
	
//	System.out.print("아무거나 입력해주세요>");
//	String str2 = s.nextLine(); //괄호 = 메서드
//	System.out.println("입력받은 내용: " + str2);
	
//	System.out.print("숫자 입력>");
//	int num = s.nextInt();
//	System.out.println("입력받은 숫자 : " + num); // 숫자입력받으면 버그생김 = 문자열로 받고 형변환
//	System.out.print("문자열 입력>");
//	String str3 = s.nextLine();
//	System.out.println("입력받은 문자열 : " + str3);
//	System.out.println("입력 끝!");
	
//	System.out.print("숫자입력>");//변환입력받기
//	int num = Integer.parseInt(s.nextLine()); //정수
//	double num2 = Double.parseDouble(s.nextLine()); //실수
//	System.out.println(num);
	
	//자신의 이름을 저장할 변수를 선언하고 Scanner를 사용해 이름을 저장해주세요.
	System.out.print("이름을 적어주세요 = ");
	String name = s.nextLine();
	
	//자신의 나이를 저장할 변수를 선언하고 Scanner를 사용해 나이를 저장해주세요
	System.out.print("나이 입력 = ");
	int age = Integer.parseInt(s.nextLine());
	
	//이름과 나이를 출력해주세요
	System.out.println("이름 : " + name + "\n나이 : "+ age);
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
}
