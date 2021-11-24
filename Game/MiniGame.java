package Game;

import java.util.Scanner;

import e_oop.ScanUtil;

public class MiniGame {
	Scanner s = new Scanner(System.in);
	String[] card = new String[] {"1", "2", "3", "4", "5", "6","7"};
	int bank;
	void MiniGameStart(Character m){
		String[] dek = new String[2];
		
		for(int i = 0; i < dek.length;i++) {
			dek[i] = card[(int)(Math.random()*card.length)];
			
			System.out.print("[ "+dek[i] + " ] ");
		}
		System.out.println("1.BANKER");
		int result = Integer.parseInt(dek[0])+Integer.parseInt(dek[1]);
		
		for(int i = 0; i < dek.length;i++) {
			dek[0] = card[(int)(Math.random()*card.length)];
			
			
		}
		System.out.print("[ "+dek[0] + " ] ");
		System.out.println("2.PLAYER");
		int result2 = Integer.parseInt(dek[0])+Integer.parseInt(dek[1]);
		
		
		int input = s.nextInt();
		System.out.println("[ "+dek[1] + " ]");
		
		if(result < result2) {
			System.out.println("플레이어 승!");
			if(input == 2) {
				m.money += 500;
				System.out.println("500원 획득! 현재 돈 : "+m.money);
			}else {
				m.money -= 500;
				System.out.println("-500원 현재 돈 : "+m.money);
			}
		}else {
			System.out.println("뱅커 승!");
			if(input == 1) {
				m.money += 500;
				System.out.println("500원 획득! 현재 돈 : " + m.money);
			}else {
				m.money -= 500;
				System.out.println("-500원 현재 돈 : "+m.money);
			}
		}
		
	
		
		
	}
}
