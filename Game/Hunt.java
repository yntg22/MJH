package Game;

import java.util.Scanner;

import e_oop.ScanUtil;

public class Hunt {
	Scanner s = new Scanner(System.in);
	void hunt(Character n, Monster m) {
		
		System.out.println(m.name+"이 보인다.");
		m.showMonster();
		
		
		battle : while(true) {
			System.out.println("1.공격 2.도망");
			int input = s.nextInt();
			switch (input) {
			case 1:
				
				n.attack(m);
				if(n.skill > m.att) {
					System.out.println(m.name + "을 처치하였습니다.");
					n.money += m.getMoney();
					System.out.println("돈 + " +m.getMoney());
					break battle;
				}else {
					System.out.println(m.name + "이 눈치챘다.");
					break battle;
				}
				
			case 2:
				System.out.println(m.name + "을 그냥 지나쳤다.");
				break battle;
			}
		}
	}
}
