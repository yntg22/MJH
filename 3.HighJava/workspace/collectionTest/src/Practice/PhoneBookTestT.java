package Practice;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookTestT {
   private HashMap<String, Phone> phoneBookMap;
   private Scanner scan;
   
   //생성자
   public PhoneBookTestT() {
      phoneBookMap = new HashMap<>();
         scan = new Scanner(System.in);
}
   public static void main(String[] args) {
      new PhoneBookTestT().phoneBookStart();
   }
   
   //프로그램 시작되는 메서드
   public void phoneBookStart() {
      System.out.println();
      System.out.println("++++++++++++++++++++++++++++++");
      System.out.println("       전 화 번 호 관 리 프 로 그 램");
      System.out.println("++++++++++++++++++++++++++++++");
      System.out.println();
      
      while(true) {
         int choice = displayMenu();
         switch (choice) {
         case 1:    //등록
            insert(); break;
         case 2:    //수정
        	 update();
            break;
         case 3:    //삭제
        	 delete();
            break;
         case 4:    //검색
            break;
         case 5:    //전체 출력
        	allSelect();
            break;
         case 0:    //종료
            System.out.println("프로그램을 종료합니다.");
            return;
         default : 
            System.out.println("작업 번호를 잘못 입력했습니다.");
            System.out.println("다시 선택해 주세요.");
         }
      }
   }
   
   //데이터를 삭제하는 메서드
   private void delete() {
	   scan.nextLine();
	   System.out.println();
	   System.out.println("삭제할 전화번호 정보를 입력하세요.");
	   System.out.println("회원이름>>");
	   String name = scan.nextLine();
	   
	   //해당 사람이 Map에 저장되어 있지 않으면 삭제작업을 수행할 수 없다.
	   if(!phoneBookMap.containsKey(name)) {
		   System.out.println(name + "씨는 등록되지 않은 사람입니다.");
		   return;
	   }
	   
	   phoneBookMap.remove(name);
	   System.out.println(name + "씨의 정보를 삭제했습니다...");
   }
   
   //데이터를 수정하는 메서드
   private void update() {
	   scan.nextLine(); //버퍼 비우기
	   System.out.println();
	   System.out.println("   수정할 전화번호 정보를 입력하세요.");
	   
	   System.out.print("회원이름>>");
	   String name = scan.nextLine();
	   
	   //해당 사람이 Map에 저장되어 있지 않으면 수정작업을 수행할 수 없다.
	   if(!phoneBookMap.containsKey(name)) {
		   System.out.println(name + "씨는 전화번호에 등록되지 않은 사람입니다.");
		   return;
	   }
	   
	   System.out.println("새로운 전화번호 >> ");
	   String newTel = scan.nextLine();
	   
	   System.out.println("새로운 주소 >> ");
	   String newAddr = scan.nextLine();
	   
	   // 같은 key값에 새로운 전화번호 정보를 저장한다. ==> 덮어쓰기가 된다.
	   phoneBookMap.put(name, new Phone(name,newAddr,newTel));
	   
	   System.out.println(name + "씨의 전화번호 정보를 변경했습니다.");
	   
	   
	   
	   
	   
   }
   
   
   //전체 자료를 출력하는 메서드
   private void allSelect() {
	   System.out.println();
	   
	   Set<String> nameSet = phoneBookMap.keySet();
	   
	   System.out.println("----------------------------------");
	   System.out.println("번호     이름        전화번호         주  소");
	   System.out.println("----------------------------------");
	   
	   if(nameSet.size()==0) {
		   System.out.println("  등록된 전화번호 정보가 하나도 없습니다...");
	   }else {
	   
	   int cnt = 0;
	   //Map에서 모든 key값들을 하나씩 가져온다.
	   for(String name : phoneBookMap.keySet()) {
		   cnt++;
		   Phone p = phoneBookMap.get(name);
		   System.out.println(cnt + "\t" + p.getName() + "\t" 
				   			 + p.getPhone() + "\t" + p.getAddr());
	   		}
	   }
	   System.out.println("-----------------------------------");
   }
   
   
   //자료를 등록하는 메서드 ( 이미 등록된 사람은 등록되지 않는다.)
   private void insert() {
      // Scanner객체의  next(), nextInt(), nextDouble()...등 
      // nextLine()이 아닌 입력용 메서드의 특징
      // ==> 사이띄기, Tab키, Enter키를 구분문자로 분리해서 분리된 자료만 읽어간다. 
      //       그래서 입력버퍼에는  구분문자들이 남는다.    
      
      // Scanner객체의 nextLine() ==> 한 줄 단위로 입력받는다. 
      //          즉, 자료를 입력하고 Enter키를 누르면 Enter키까지 읽어간다. 
      
      scan.nextLine();  //입력 버퍼 비우기 
      System.out.println();
      System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
      System.out.println("이 름>> ");
      //String name = scan.next(); //띄어쓰기 안한 이름을 입력받을때 
      String name = scan.nextLine();
      //중복검사
      if(phoneBookMap.containsKey(name)) {
    	  System.out.println(name + "씨는 이미 등록되어 있습니다.");
    	  return;
      }
      
      System.out.println("전화번호 >>");
      String tel = scan.nextLine();
      
      System.out.println("회원주소 >>");
      String addr = scan.nextLine();
      
      Phone p = new Phone(name,addr,tel);
      phoneBookMap.put(name, p);
      
      //Phone p =  new Phone(name, tel, addr);
      //phoneBookMap.put(name, p);
      
      System.out.println(name + "씨 전화번호 등록 완료!!");
   }
   
      
   private int displayMenu() {
      System.out.println();
      System.out.println("다음 메뉴를 선택하세요.");
      System.out.println("----------------------------------------");
      System.out.println("1.전화번호 등록");
      System.out.println("2.전화번호 수정");
      System.out.println("3.전화번호 삭제");      
      System.out.println("4.전화번호 검색");
      System.out.println("5.전화번호 전체출력");
      System.out.println("0.프로그램 종료");
      System.out.println("========================================");
      System.out.println("메뉴선택 : ");
      int num = scan.nextInt();
      
      return num;
      
   }
   
   
   
class Phone {
   private String name;
   private String addr;
   private String phone;
   
   //생성자
   public Phone(String name, String addr, String phone) {
      super();
      this.name = name;
      this.addr = addr;
      this.phone = phone;      
   }
   
   // getter, setter 
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getAddr() {
      return addr;
   }

   public void setAddr(String addr) {
      this.addr = addr;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }
      
}   
}

 





