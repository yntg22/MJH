package Practice;

import java.util.Scanner;

import javax.swing.SwingUtilities;

public class moonsin {

	public static void main(String[] args) {
		System.out.println("========================");
		System.out.println("진홍이가~~~ 좋아하는!!! 문신찾기~~~ 게임!!게에에에에임이이이임start!!");
		System.out.println("========================");
		
		
//		System.out.println("당신은 문신을 좋아하십니까?");
//		System.out.println("YSE(1) OR NO(2) ");
		Scanner s = new Scanner(System.in);
		
		int i = s.nextInt();
		switch (i) {
		case 1:
			System.out.println("나비 보러 갈래?");
			i = s.nextInt();
			switch (i) {
			case 1:
				System.out.println("웅 좋아");
				break;
			case 2:
					
			default:
				break;
			}
			System.out.println("크리스마스에 스파이더맨 보러 갈래?");
			i = s.nextInt();
			break;
		case 2:
			System.out.println("삐삑 당신은 거짓말을 했습니다 .");
		default:
			break;
		}
		
		
	}

	
	}

