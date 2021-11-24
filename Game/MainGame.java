package Game;

import java.util.Arrays;
import java.util.Scanner;

import e_oop.ScanUtil;



public class MainGame {

	public static void main(String[] args) {
		Scanner q = new Scanner(System.in);
		Character marin = new Character();
		Hunt hunt = new Hunt();
		

		
		marin.showStatus();
		
		while(true) {
			if(marin.money < 0) {
				System.out.println("=======파산=======");
				System.exit(0);
			}
			System.out.println("1.소매치기 | 2.종료 | 3.상태 | 4.돈쓰기 | 5.막노동하기 | 6.도박하기");
			int input = q.nextInt();
			switch(input) {
			case 1:
				Monster m = new Monster();
				hunt.hunt(marin,m);
				break;
			case 2:
			System.out.println("프로그램이 종료되었습니다.");
			System.exit(0);
			break;
			
			case 3:
				marin.showStatus();
				break;
			case 4:
				System.out.println("| 1.손기술+10 | 2.체력+30 | 3.집사기(3,000,000원) | 4.체력 회복(1000원) | 나의 돈 "
						+ ": " + marin.money);
				input = q.nextInt();
				switch(input) {
				case 1: 
					if(marin.money >= 100) {
					marin.skill += 10;
					marin.money -=100;
					System.out.println("손기술+10 : "+marin.skill);
					}else {
						System.out.println("돈이 부족하다");
					}
					break;
				case 2:
					if(marin.money >= 100) {
					marin.maxHp += 30;
					marin.money -=100;
					System.out.println("체력+30 : "+marin.maxHp);
					}else {
						System.out.println("돈이 부족하다");
					}
					break;
				case 3:
					if(marin.money >= 3000000) {
						System.out.println("집을 샀다!! 게임끝!!");
					}else {
						System.out.println("집을 사기엔 돈이 부족하다");
					}
					break;
				case 4:
					if(marin.money >= 1000) {
						marin.money -= 1000;
						marin.hp = marin.maxHp;
						System.out.println("회복 후 체력 : " + marin.hp);
					}else {
						System.out.println("돈이 부족하다");
					}
				}
				break;
			case 5 : 
				Mak mak = new Mak(marin);
				break;
			case 6 :
				MiniGame mini = new MiniGame();
				mini.MiniGameStart(marin);
				break;
				
		}
			
			
		}
		

		
		
	}
	
	
}