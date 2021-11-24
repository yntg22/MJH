package Game;



public class Character {
	String name = "마린";
	int skill = 20;
	
	int hp = 100;
	
	int maxHp = 100;
	int money = 1000;
	Character(){
		
	}
	
	void attack(Monster n) {
		if(skill > n.att) {
			System.out.println("소매치기 성공!");
		}
	}
	
	void showStatus() {
		System.out.println("체력 : "+hp+"/"+maxHp);
		System.out.println("손기술 : " + skill);
		System.out.println("돈 : " + money);
		
	}
	
	
	
}
