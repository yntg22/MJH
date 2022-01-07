package kr.or.ddit.basic;

//yield()메서드 연습  // 양보
public class ThreadTest10 {

   public static void main(String[] args) {
      YieldThread th1 = new YieldThread("1번 쓰레드");
      YieldThread th2 = new YieldThread("2번 쓰레드");
   
      th1.start();
      th2.start();
    try {
      Thread.sleep(5);
   } catch (InterruptedException e) {
      // TODO: handle exception
   }
   System.out.println("11111111111111111------------------------------------");
      
   th1.work = false;
      
      try {
            Thread.sleep(5);
         } catch (InterruptedException e) {
            // TODO: handle exception
         }
      System.out.println("222222222222222222222------------------------------------");
      
      th1.work = true;
      
      try {
            Thread.sleep(5);
         } catch (InterruptedException e) {
            // TODO: handle exception
         }
      System.out.println("3333333333333333-----------------------------------");   
      th1.stop = true;
      th2.stop = true;
   
   
   }
   
}

//yield()메서드 연습용 쓰레드
class YieldThread extends Thread {
   public boolean stop = false;
   public boolean work = true;

   // 생성자
   public YieldThread(String name) {
      // super ==> 부모의 참조값이 저장되어 있는 참조 변수
      // super(값들...); ==> 부모의 생성자를 호출한다.
      super(name); // ==> 쓰레드의 이름을 설정한다.
   }

   @Override
   public void run() {
      while(!stop) {   //stop이면 
         if(work) {
            //getName()메서드 ==> 쓰레드의 이름을 반환하는 메서드
            System.out.println(getName() + "작업 중...");
         }else {
            System.out.println(getName() + "양보...");
            Thread.yield();
         }
      }
      
   }

}