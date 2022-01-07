package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBookTest {
	Scanner s = new Scanner(System.in);
	HashMap<String,Phone> ph = new HashMap<>();
	
	public static void main(String[] args) {
		
		/*
		 *  문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고
		 *  	 Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
		 * 		 (Map의 구조 => key값 : 저장할 사람의 '이름', value값 : Phone클래스에 인스턴스)  
		 * 	
		 * 		아래 메뉴의 기능을 구현하시오.
		 * (실행예시)
		 * 		다음 메뉴를 선택하세요.
		 * 		1. 전화번호 등록
		 * 		2. 전화번호 수정
		 * 		3. 전화번호 삭제
		 * 		4. 전화번호 검색
		 * 		5. 전화번호 전체 출력
		 * 		0. 프로그램 종료
		 * --------------------------------
		 * 번호입력 >> 1
		 * 
		 * 새롭게 등록할 전화번호 정보를 입력하세요.
		 * 이 름 > 홍길동
		 * 전화번호 > 010-1111-1111
		 * 주 소 > 대전시 중구 대흥동
		 * 
		 *  '홍길동' 전화번호 등록 완료!!
		 * ----------------------------
		 * 번호입력 >> 5
		 * 
		 * ----------------------------
		 * 번호        이름         전화번호         주소
		 * ----------------------------
		 * 1        홍길동     010-1111-1111	대전시 중구 대흥동
		 * ~~~
		 * ----------------------------
		 * 출력완료...
		 */
		PhoneBookTest start = new PhoneBookTest();
		start.Start();
		
	}
	
	public void Start() {
		while(true) {
		System.out.println("다음 메뉴를 선택하세요.");
		System.out.println("1.전화번호 등록");
		System.out.println("2.전화번호 수정");
		System.out.println("3.전화번호 삭제");
		System.out.println("4.전화번호 검색");
		System.out.println("5.전화번호 전체 출력");
		System.out.println("0.전화번호 등록");
		
		int input = s.nextInt();
		switch(input) {
		case 1:
			plus();
			break;
		case 2:
			fix();
			break;
		case 3:
			delete();
			break;
		case 4:
			search();
			break;
		case 5:
			allprint();
			break;
		case 0:
			System.exit(0);
		}
		}
	}
	
	private void plus() {
		s.nextLine();
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.println("이름> ");
		String name = s.nextLine();
		
		System.out.println("주소> ");
		String addr = s.nextLine();
		
		System.out.println("전화번호> ");
		String phone = s.nextLine();
		
		
		ph.put(name, new Phone(addr,phone));
		System.out.println(name + " 등록 성공!");

	}
	
	public void fix() {
		s.nextLine();
		System.out.println("수정할 사람의 이름 입력> ");
		String name = s.nextLine();
		
		System.out.println("주소> ");
		String addr = s.nextLine();
		
		System.out.println("전화번호> ");
		String phone = s.nextLine();
		
		
		ph.put(name, new Phone(addr,phone));
		System.out.println(name + " 수정 성공!");
	}
	
	public void delete() {
		s.nextLine();
		System.out.println("삭제할 사람의 이름 입력> ");
		String name = s.nextLine();
		ph.remove(name);
		System.out.println(name + "님 삭제 성공");
	}
	
	public void search() {
		s.nextLine();
		System.out.println("검색할 사람의 이름 입력> ");
		String name = s.nextLine();
		System.out.println(ph.get(name).addr);
		System.out.println(ph.get(name).phone);
	}
	
	public void allprint() {
		System.out.println("이름\t주소\t핸드폰번호");
		for(String key : ph.keySet()) {
			Phone value = ph.get(key);
			System.out.println(key + "\t" + value.addr+"\t"+value.phone);
		}
		System.out.println("----------------------------------------");
	}
	
	
}

class Phone {
	//toString 이용해서 출력할수도 있음
	/*@Override
	public String toString() {
		return "Phone [addr=" + addr + ", phone=" + phone + "]";
	}*/
//getter setter를 이용할수도있워
//	public String getAddr() {
//		return addr;
//	}
//
//	public void setAddr(String addr) {
//		this.addr = addr;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}

	String addr = "";
	String phone = "";
	
	Phone(String addr,String phone){
		this.addr = addr;
		this.phone = phone;
	}
	
}


