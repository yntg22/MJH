package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/*로또를 구매하는 프로그램 작성하기

사용자는 로또를 구매할 때 구매할 금액을 입력하고
입력한 금액에 맞게 로또번호를 출력한다.
(단, 로또 한장의 금액은 1000원이며 최대 100장까지만 구입할 수 있고,
     거스름돈도 계산하여 출력한다.)
*/

public class Lotto {
		
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(true) {
		System.out.println("============================");
		System.out.println("Lotto 프로그램");
		System.out.println("============================");
		System.out.println("1.Lotto 구입 \t 2.프로그램 종료");
		int input = s.nextInt();
		
		switch(input){
			case 1: 
				System.out.println("Lotto 구입 시작");
				System.out.println("(1000원에 로또번호 하나입니다.)");
				System.out.println("금액 입력 : ");
				int money = s.nextInt();
				int count = money / 1000;
				int change = money % 1000;
				if(count > 100) {
					System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패 !!!");
					break;
				}
				if(count == 0) {
					System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!");
					break;
				}
			
				for(int i = 0; i < count; i++) {
				HashSet<Integer> lotto = new HashSet<>();
				while(lotto.size()<6) {
				lotto.add((int)(Math.random()*(45-1+1) +1));
				}
				//리스트 안만들고 그냥 출력/ 노정렬
//				System.out.println(lotto.toString());
				
				ArrayList<Integer> lotto2 = new ArrayList<>(lotto);
				Collections.sort(lotto2);
				System.out.print("로또번호"+(i+1) +" : " + lotto2.get(0));
				
				for(int j = 1; j <lotto2.size();j++) {
				System.out.print(","+lotto2.get(j));
				}
				
				System.out.println();
				
				}
				System.out.println("받은 금액은 " + money + "이고 거스름돈은 "+ change +"원입니다.");
				break;
			case 2:
				System.exit(0);
			}
		}
		
	}
	

}
