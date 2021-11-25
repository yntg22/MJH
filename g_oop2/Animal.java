package g_oop2;

public abstract class Animal {

	abstract void sound();
	
}

class Dog extends Animal{

	@Override
	void sound() {
		System.out.println("멍멍!!");
	}
	
}

class cat extends Animal{

	@Override
	void sound() {
		System.out.println("야옹~");
	}
	
}

class cow extends Animal{

	@Override
	void sound() {
		System.out.println("음메~");
	}
	
}