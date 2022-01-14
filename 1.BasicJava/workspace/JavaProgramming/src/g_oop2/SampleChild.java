package g_oop2;

public class SampleChild extends SampleParent {
	
	void childMethod() {
		//상속받은 변수와 메서드를 사용할 수 있다.
		System.out.println(var); //상속받은 변수
		System.out.println(method(7, 13)); //상속받은 메서드
	}
	
	
	//오버라이딩
	//super, super()           this랑 비슷한애 super()=부모클래스의 생성자 호출
	//다형성	부모클래스 타입의 변수를 사용?
	
	//오버라이딩 : 상속받은 메서드의 내용을 재정의 하는것 선언부가 똑같은상태에서 내용만 변경
	@Override  //어노테이션 : 클래스, 변수, 메서드 등에 표시해 놓는것 (실수방지)
	int method(int a, int b) {
		return a * b;
	}
	
	//super, super()
	int var;
	
	void test(double var) {
		System.out.println(var); //지역변수
		System.out.println(this.var); //전역변수(인스턴스 변수)
		System.out.println(super.var); //부모클래스의 전역변수
	
		System.out.println(this.method(10, 20)); //자식 클래스의 메서드
		System.out.println(super.method(10, 20)); //부모 클래스의 메서드
	}
	
	SampleChild(){
		//this() super() 는 생성자의첫줄에만 사용해야한다
		super(); //부모클래스의 생성자 호출
	}
	
	//다형성 **
	public static void main(String[] args) {
		SampleChild sc = new SampleChild();
		SampleParent sp = (SampleParent)new SampleChild();

//		SampleChild sc2 = (SampleChild)new SampleParent(); 부모클래스 객체를 자식클래스에 저장?은 불가능
		
		SampleChild sc3 = (SampleChild)sp;
	}
}
