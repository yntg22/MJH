package Game;

import java.util.Scanner;

public class Mak {
Scanner s = new Scanner(System.in);
	Mak(Character m){
		
		mak :while(true) {
			if(m.hp <= 0) {
				System.out.println("체력이 없다");
				break mak;
			}
			System.out.println("----------------------------");
			System.out.println("1.쓰레기 치우기 (+500원 / 체력 -10)");
			System.out.println("2.페인트 칠하기 (+1000원 / 체력 -20)");
			System.out.println("3.벽돌 나르기 ( +2000원 / 체력 -30)");
			System.out.println("4.막노동 그만하기");
			int input = s.nextInt();
			switch(input) {
			case 1: 
				if(m.hp >= 10) {
				m.hp -= 10;
				m.money += 500;
					System.out.println("500원 획득 / 체력 -10\n 현재 돈 : " + m.money + " 체력 : " + m.hp);
				} else {
					System.out.println("체력이 부족하다");
				}
				break;

			case 2: 
				if (m.hp >= 20) {
					m.hp -= 20;
					m.money += 1000;
					System.out.println("1000원 획득 / 체력 -20\n 현재 돈 : " + m.money + " 체력 : " + m.hp);
				} else {
					System.out.println("체력이 부족하다");
				}
				break;
			
			case 3:
				if(m.hp >= 30) {
				m.hp -= 30;
				m.money += 2000;
				System.out.println("2000원 획득 / 체력 -30\n 현재 돈 : " + m.money +" 체력 : " + m.hp );
				}else {
					System.out.println("체력이 부족하다");
				}
				break;
				
			case 4:
				break mak;
			}
		}
		
	}
}
