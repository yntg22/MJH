package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/*
문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
	컴퓨터의 숫자는 난수를 이용하여 구한다.
	(스트라이크는 S, 볼은 B로 나타낸다.)
	
	예시) 컴퓨터의 난수 ==> 9 5 7
	 
	실행예시)
	숫자입력 ==> 3 5 6
	3 5 6 ==> 1S 0B
	숫자입력 ==> 7 8 9
	7 8 9 ==> 0S 2B
	숫자입력 ==> 9 7 5
	9 7 5 ==> 1S 2B
	숫자입력 ==> 9 5 7
	9 5 7 ==> 3S 0B
	
	축하합니다.
	당신은 4번째 만에 맞췄습니다.
	
	
*/

public class BaseBallTest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); //스캐너 객체 생성
		
		HashSet<Integer> answer = new HashSet<>();  //정답을 저장할 Set 생성
		//정답 생성해서 넣기▼
		while(answer.size() < 3) {
		answer.add((int)(Math.random()*(9-1+1)+1));
		}
		
		//생성한 Set 정답들을 ArrayList에 넣기▼
		ArrayList<Integer> answer2 = new ArrayList<>(answer);
		//리스트 섞어주기▼
		Collections.shuffle(answer2);
		
		//입력받을 리스트 생성▼
		ArrayList<Integer> input = new ArrayList<>();
		//몇번만에 맞췄는지 저장할 count 생성▼
		int count = 1;
		//맞출때까지 돌아가는 while문 ▼
		while(true) {
		System.out.print("숫자 입력 ==> ");
		//생성했던 리스트에 입력받으면서 넣기▼
		for(int i = 0; i < 3; i++) {
		input.add(s.nextInt());
		}
		//3번 다 넣고 입력받은것 보여주기
		System.out.print(input + " ==> ");
		//▼ strike
		int strike = 0;
		//▼ ball
		int ball = 0;
		//▼ 입력받은 값과 정답을 비교
		for(int i = 0; i < answer2.size(); i++) {
			for(int j = 0; j < answer2.size(); j++) {
				//▼같으면
				if(answer2.get(i) == input.get(j)) {
					//▼자리까지 같으면 스트라이크
					if(i == j) {
						strike++;
						//▼자리까지는 안같으면 볼
					}else {
						ball++;
					}
				}
				
			}
		}
		//▼다 비교했으면 입력받을때 저장했던 리스트 초기화
		input.clear();
		//▼비교한 결과 알려주기
		System.out.println(strike + "S " + ball + "B");
		//스트라이크가 3이면되면 종료 ▼
		if(strike == 3) {
			System.out.println("축하합니다.");
			System.out.println("당신은 " + count + "번째 만에 맞췄습니다.");
			break;
		}
		//▼종료하지 않고 또 하게되면 횟수 ++
		count++;
		}
		
	}

}
