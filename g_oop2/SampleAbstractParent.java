package g_oop2;

public abstract class SampleAbstractParent {

	void method() {
		
	}
	//추상메소드
	abstract void abstractMethod();
	//[추상메소드를 가진클래스는 추상클래스가 된다.][객체생성못함] [부모클래스의역할]
	
	
}

class SampleAbstractChild extends SampleAbstractParent{

	@Override
	void abstractMethod() {
		
		
	}
	
}