package kr.or.ddit.basic;



import javax.swing.JOptionPane;

public class TreadTest0701 {
   public static boolean inputCheck = false;
   
   public static void main(String[] args) {
      GameTimer gt = new GameTimer();
      
      // 난수를 이용해서 컴퓨터의 가위 바위 보를 정한다.
      String[] data = {"가위", "바위", "보"};
      int index = (int)(Math.random()*3);   // 0~2사이의 난수 만들기
      String com = data[index];
      
      // 사용자의 가위 바위 보 입력 받기
      gt.start();
      String man = null;
      do {
         man = JOptionPane.showInputDialog("가위 바위 보를 입력하세요");
         
//      }while(!("가위".equals(man) || "바위".equals(man) || "보".equals(man)));
      }while(!"가위".equals(man) && !"바위".equals(man) && !"보".equals(man));
      
      inputCheck = true; //입력 완료됨을 설정한다.
      
      // 결과 판정하기
      String result = "";
      
      String temp = man + com;
      switch(temp) {
      case "가위바위" :
      case "바위바위" :
      case "보보" : result = "비겼습니다."; break;
      case "가위보" :
      case "바위가위" :
      case "보바위" : result = "당신이 이겼습니다."; break;
      default : result = "당신이 졌습니다.";
      }
      /*if(com.equals(man)) {
         result = "비겼습니다.";
      }else if( ("가위".equals(man) && "보".equals(com))  ||
              ("바위".equals(man) && "가위".equals(com)) ||
              ( "보".equals(man) && "바위".equals(com)) ){
         result = "당신이 이겼습니다.";
      }else {
         result = "당신이 졌습니다.";
      }*/
      
      // 결과 출력
      System.out.println("     -- 결과 --  ");
      System.out.println("컴퓨터 : " + com);
      System.out.println("사용자 : " + man);
      System.out.println("결 과 : " + result);
   }

}

class GameTimer extends Thread{
   @Override
   public void run() {
      System.out.println("카운트 다운 시작...");
      for(int i=5; i>=1; i--) {
   
         if(TreadTest0701.inputCheck==true) {
            return;
         }
         System.out.println(i);
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            // TODO: handle exception
         }
      }
      System.out.println("     --결  과 --");
      System.out.println("시간 초과로 당신이 졌습니다.");
      System.exit(0);
   }
}