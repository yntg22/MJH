package f_game;

import e_oop.ScanUtil;

public class MyGame {

	Character c;
	Item[] items;
	
	MyGame(){
		c = new Character("가렌", 5, 50, 20, 10);
	
		items = new Item[10];
		items[0] = new Item("무한의대검",0,0,10,0);
		items[1] = new Item("가시갑옷",0,0,0,10);
	}
	
	public static void main(String[] args) {
		new MyGame().start(); //메인에는 static이 붙어있어서 변수사용시에 객체생성해야함, 그래서 
	}
	
	void start() {
		while(true) {
			String input = ScanUtil.nextLine();
			switch(input) {
			case "시작":
				c.showStatus();
				break;
			case "사냥":
				hunt();
				break;
			case "w" :
				c.w(input);
				break;
			case "종료":
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
			}
		}
	}
	
	void hunt() {
		Monster m = new Monster("고블린", 20, 10, 15, 10, 1, 150, new Item[] {items[0], items[1]});
		System.out.println(m.name + "를 만났습니다. 전투를 시작합니다.");
		
		int input = 0;
		battle : while(true) {
			System.out.println("1.공격 2.도망>");
			input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				while(true) {
				c.attack(m);
				if(m.hp <= 0) {
					System.out.println(m.name + "을 처치하였습니다.");
					c.getExp(m.exp);
					c.getItem(m.dropItem());
					break battle;
				}
				m.attack(c);
				if(c.hp <= 0) {
					System.out.println("사망");
					
					break battle;
				}
				}
			case 2:
				System.out.println(m.name + "으로부터 도망쳤습니다.");
				break battle;
			}
		}
	}

	
   
	
}
