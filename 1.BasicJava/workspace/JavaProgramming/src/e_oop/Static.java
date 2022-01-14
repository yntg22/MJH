package e_oop;

public class Static {
	/*
	 * - static을 붙이면 프로그램 실행 시 메모리에 올라간다.
	 * - 객체생성을 하지 않아도 사용할 수 있다.
	 * - static을 붙인 변수는 객체간에 변수의 값을 공유한다.
	 * - static이 붙은 멤버의 명칭 : 클래스 변수, 클래스 메서드
	 * - static이 붙지 않은 멤버의 명칭 : 인스턴스 변수, 인스턴스 메서드
	 * 
	 * JVM 메모리 구조
	 * - Method Area(메서드 영역) : 클래스 멤버가 저장된다
	 * - Heap : 객체가 저장된다.
	 * - Call Stack(호출 스택) : 현재 호출되어 있는 메서드가 저장된다.
	 * */
	
	//값을 공유하기 위해 static을 붙인다.
	static int var;
	
	
	public static void main(String[] args) {
		Marine m1 = new Marine();
		Marine m2 = new Marine();
		
		System.out.println(m1.hp);
		System.out.println(m2.hp);
		
		m1.hp--;
		
		System.out.println(m1.hp);
		System.out.println(m2.hp);
		
		System.out.println(m1.att);
		System.out.println(m2.att);
		
		m1.att++;
		
		System.out.println(m1.att);
		System.out.println(m2.att);
		
		
		System.out.print("문자열 입력>");
		String nextLine = ScanUtil.nextLine(); //클래스 이름으로 사용?
		System.out.println("입력받은 문자열: " + nextLine);
		
		System.out.print("숫자 입력>");
		int nextInt = ScanUtil.nextInt();
		System.out.println("입력받은 숫자 : " + nextInt);
		
	}

}

class Marine {
	int hp = 40;  // 체력
	static int att = 5; // 공격력
	static int def = 0; // 방어력
}






