package Game;

public class Item {
	
	String[] itemname = new String[] {"핸드폰","시계","지갑","반지","귀걸이","차키"};
	String name;
	int price;

	
	Item(){
	 name = itemname[(int)(Math.random()*itemname.length)];
	price = (int)(Math.random()*500)+100;
	 
	}
	
	
	public String toString() {
		return name + "(" + price + "원)";
	}

	
}
