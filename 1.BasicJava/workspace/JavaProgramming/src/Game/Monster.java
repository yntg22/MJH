package Game;

public class Monster {
	String[] monsters = new String[] {"평범한 시민","인상이 험악한 시민","거지같이 보이는 시민","돈 많아보이는 시민","바보같은 시민"};
	String name;
	int att;
	int money;
	Item item = new Item();
	
	
	Monster(){
		this.name = monsters[(int)(Math.random()*monsters.length)];
		this.att = (int)(Math.random()*100)+1;
		this.money = (int)(Math.random()*500)+100;
		item = new Item();
		
	}
	
	
	void showMonster(){
		System.out.println("눈치 : " + att);
		System.out.println("가진 돈 : " + money);
		System.out.println("소지품 : " + item);
	}
	
	
	
	int getMoney() {
		return money+item.price;
	}
	
	
}
