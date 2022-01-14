package g_oop2;

public class Stroe {

	public static void main(String[] args) {
		Desktop d = new Desktop();
		Product p = new AirCon();
		TV tv = new TV();
		
		Customer c = new Customer();
		
		c.buy(d);
		c.buy(p);
		c.buy(tv);
		
	}

}

class Product{
	String name; //상품명
	int price; 	 //가격
	
	Product(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return name + "(" + price + "원)";
	}
}

class Desktop extends Product{
	Desktop(){
		super("삼성 컴퓨터", 1000000);
	}
	
	void programming() {
		System.out.println("프로그램을 만듭니다.");
	}
}

class AirCon extends Product{
	AirCon(){
		super("LG 에어컨",200000);
	}
	
	void setTemperature() {
		System.out.println("온도를 설정합니다");
	}
}

class TV extends Product{
	TV(){
		super("LG TV", 300000);
	}
	
	void setChannel() {
		System.out.println("채널을 변경합니다.");
	}
}

class Customer{
	int money = 1000000000;
	
	Product[] items = new Product[10];
	
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("잔돈이 부족합니다.");
			return; //반환해주는 역할도 있지만 메서드 종료 역할도 있음
		}
		
		money -= p.price;
		
		for(int i = 0; i < items.length; i++) {
			if(items[i] == null) {
				items[i] = p;
				break;
			}
		}
		System.out.println(p + "를 구매했습니다.");
	}
}







