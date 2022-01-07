package Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BaseBallTest {
	ArrayList<Integer> numList;
	ArrayList<Integer> userList;
	private int strike;
	private int ball;
	
	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		BaseBallTest test = new BaseBallTest();
		test.gameStart();
	}
	
	// 게임이 시작되는 메서드
	public void gameStart() {
		// 난수를 만드는 메서드 호출
		getNum();
		
		// 확인용으로 만들어진 난수를 출력한다.
		System.out.println("컴퓨터 난수 : " + numList);
		
		int cnt = 0;
		do {
			cnt++;
			
			// 입력용 메서드 호출
			inputNum();
			
			// 볼카운트 구하기
			ballCount();
			
		}while(strike != 3);
		
		System.out.println();
		System.out.println("축하합니다...");
		System.out.println("당신은" + cnt + "번째만에 맞췄습니다.");
		
		
	}
	
	// 1~9사이의 서로 다른 난수 3개를 만들어서 List에 저장하는 메서드(Set이용)
	private void getNum() {
		Set<Integer> numSet = new HashSet<>();
		
		//1~9사이의 난수 3개 만들기
		while(numSet.size()<3) {
			numSet.add((int)(Math.random()* 9 + 1));
		}
		
		// 만들어진 난수를 List에 저장하기
		numList = new ArrayList<>(numSet);
		
		// List의 데이터를 섞어준다.
		Collections.shuffle(numList);
	}
	
	// 사용자로부터 3개의 정수 입력받아 List에 저장하는 메서드
	private void inputNum() {
		int n1, n2, n3;
		
		do {
			System.out.println("숫자입력==> ");
			n1 = scan.nextInt();
			n2 = scan.nextInt();
			n3 = scan.nextInt();
			if(n1==n2 || n1==n3 || n2==n3) {
				System.out.println("중복되는 숫자는 입력할 수 없습니다.");
				System.out.println("다시 입력하세요.");
			}
		}while(n1==n2 || n1==n3 || n2==n3);
		
		//입력한 값을 List에 저장한다.
		userList = new ArrayList<>();
		userList.add(n1);
		userList.add(n2);
		userList.add(n3);
	}
	
	//스트라이크와 볼의 개수를 구하고 이 값을 출력하는 메서드
	private void ballCount() {
		strike = 0;
		ball = 0;
		
		for(int i = 0; i<userList.size();i++) {
			for(int j = 0; j<numList.size(); j++) {
				if(userList.get(i) == numList.get(j)) {
					if(i==j) {
						strike++;;
					}else {
						ball++;
					}
				}
			}
		}
		
		System.out.println(userList.get(0) + ", " + userList.get(1)
        + ", " + userList.get(2) + " ==> "
        + strike + "S "+ ball+ "B");
	}
	
	
	
	
	
}
