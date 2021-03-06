package kr.or.ddit.basic;

public class ThreadTest11 {

   /*
    * Thread의 stop()메서드를 호출하면 쓰레드가 바로 멈춘다. 이 때 사용하던 자원을 정리하지 못 하고 프로그램이 종료되어 나중에
    * 실행되는 프로그램에 영향을 줄 수 있다. 그래서 stop()메서드는 비추천으로 되어 있다.
    */

   public static void main(String[] args) {
//   ThreadStopTest1 th1 = new ThreadStopTest1();
//   th1.start();
//   try {
//      Thread.sleep(1000);
//   } catch (InterruptedException e) {
//      
//   }
//   //th1.stop(); //쓰레드 종료하기   stop에는 줄 표시는 비추천하기 때문에.
//   th1.setStop(true);
//   }

      ThreadStopTest2 th2 = new ThreadStopTest2();
      th2.start();
      try {
         Thread.sleep(1000);
      } catch (InterruptedException e) {

      }
      th2.interrupt();// interrupt()메서드 호출
   }
}

//쓰레드를 멈추게 하는 연습용 쓰레드 
class ThreadStopTest1 extends Thread {
   private boolean stop;

   public void setStop(boolean stop) {
      this.stop = stop;
   }

   @Override
   public void run() {
      while (!stop) {
         System.out.println("쓰레드 실행 중...");
      }
      System.out.println("자원 정리 중...");
      System.out.println("쓰레드 종료...");
   }
}

//interrupt() 메서드를 이용하요 쓰레드를 멈추게 하는 연습용 쓰레드
class ThreadStopTest2 extends Thread {
   @Override
   public void run() {
      // 방법 1 ==> interrupt()메서드와 sleep()메서드를 이용하는 방법
//      try {
//         while(true) {
//            System.out.println("쓰레드 실행 중...");
//            Thread.sleep(1);   //일시정지 상태에서 interrupt()메서드가 호출되면
//                           //sleep()메서드는 InterruptedException이 발행한다.
//         }
//      } catch (InterruptedException e) {
//         
//      }

      // 방법2
      while (true) {
         System.out.println("Thread 실행중...");

         // interrupt()메서드가 실행되었는지 여부를 검사한다.
         // 검사방법1 ==> Thread객체의 인스턴스 메서드인 isInterrupted()를 이용하는 방법
         // isInterrupted() 메서드 ==> interrupt()메서드가 호출되면 true를 반환한다.
//         if (this.isInterrupted()) {
//            break;
//         }
         //검사방법2 ==> Thread객체의 정적 메서드인 interrupt()메서드를 이용하는 방법
         //         interrupted()메서드도 interrupt()메서드가 호출되면 true를 반환한ㄷ.
         if(Thread.interrupted());
         break;
      }
      System.out.println("자원 정리 중...");
      System.out.println("쓰레드 종료...");
   }
}