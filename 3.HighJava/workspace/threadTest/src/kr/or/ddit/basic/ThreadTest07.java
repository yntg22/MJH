package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest07 {
/*
	컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
	
	컴퓨터의 가위 바위 보는 난수를 이용해서 구하고,
	사용자의 가위 바위 보는 showInputDialog()메서드로 입력 받는다.
	
	입력 시간은 5초로 제한하고 카운트 다운을 진행한다.
	5초 안에 입력이 없으면 게임에 진것으로 처리한 후 프로그램을 종료한다.
	
	5초 안에 입력이 있으면 승패를 구해서 출력한다.
	
	결과 예시)
	1) 5초안에 입력을 못했을 때
			-- 결  과 --
	     시간 초과로 당신이 졌습니다.
	2) 5초 안에 입력했을 때
			-- 결  과 --
	      컴퓨터 : 가위
              사용자 : 바위
          결 과 : 당신이 이겼습니다.
       
*/	
	
	public static void main(String[] args) {
		Thread th1 = new DataInput2();
		Thread th2 = new CountDown2();
		
		th1.start();
		th2.start();
		
		

	}

}


//데이터를 입력 받는 쓰레드
class DataInput2 extends Thread{
	// 입력 여부를 확인하기 위한 변수 선언 ==> 쓰레드에서 공통으로 사용할 변수
	public static boolean inputCheck = false; // 입력이 완료되면 true로 변경된다.
	public static String str = "";
	@Override
	public void run() {
		str = JOptionPane.showInputDialog("아무거나 입력하삼");
		inputCheck = true; //입력이 완료되었으므로 true로 변경한다.
		System.out.println("입력한 값 : " + str);
	}
	
}

//카운트 다운을 진행하는 쓰레드
class CountDown2 extends Thread{
	@Override 
	public void run() {
		for(int i = 5; i >= 1; i--) {
			
			
			// 입력이 완료되었는지 여부를 검사해서 입력이 완료되면 쓰레드를 종료시킨다.
			if(DataInput2.inputCheck == true) {
				
				int ab = (int)(Math.random()*3+1);
				String str2 = "";

				switch(ab) {
				case 1 :
					str2 = "가위";
					break;
				
				case 2 :
					str2 = "바위";
					break;
				case 3 : 
					str2 = "보";
					break;
				}

				System.out.println("컴퓨터 : " + str2);
				System.out.println("사용자 : " + DataInput2.str);
				if(DataInput2.str.equals(str2)) {
					System.out.println("비겼음");
					System.exit(0);
				}
				if(DataInput2.str.equals("가위") && str2.equals("보") 
					|| DataInput2.str.equals("바위") && str2.equals("가위")
					|| DataInput2.str.equals("보") && str2.equals("바위")) {
					System.out.println("당신이 이겼습니다.");
					System.exit(0);
				}else {
					System.out.println("당신이 졌습니다..ㅠ");
					System.exit(0);
				}
				
				
			}
			System.out.println(i);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
	}
		System.out.println("시간초과. 당신이 졌습니다.");
		System.exit(0);
	}
}
