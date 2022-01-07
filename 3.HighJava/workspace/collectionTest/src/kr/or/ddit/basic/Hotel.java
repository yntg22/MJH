package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;

public class Hotel {
	Scanner s = new Scanner(System.in);
	HashMap<Integer,Room> rm = new HashMap<>();
	
	Hotel() {
		
	for(int i = 201; i<210; i++) {
	rm.put(i, new Room("싱글룸","-"));
		}
					
	for(int i = 301; i<310; i++) {
	rm.put(i, new Room("더블룸","-"));
		}
					
	for(int i = 401; i<410; i++) {
	rm.put(i, new Room("스위트룸","-"));
		}
	
	
	}
	
	public static void main(String[] args) {
		
		Hotel hotel = new Hotel();
		System.out.println("*********************************************");
		System.out.println("       호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************");
		
		hotel.start();
		
	}
	
	public void start() {
		
		while(true) {
		System.out.println("-----------------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		System.out.println("-----------------------------------------------------------");
		int input = s.nextInt();
		
		
		switch(input) {
		case 1 :
			checkin();
			break;
		case 2 :
			checkout();
			break;
		case 3 :
			roomstatus();
			break;
		case 4 :
			return;
		}
		}
	}
	
	
	void checkin() { 
		while(true) {
		System.out.println("-----------------------------------------------------------");
		System.out.println("   체크인 작업");
		System.out.println("-----------------------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸\r\n" + 
				" * 301~309 : 더블룸\r\n" + 
				" * 401~409 : 스위트룸");
		System.out.println("-----------------------------------------------------------");
		System.out.println("방 번호 입력 >>");
		int roomnum = s.nextInt();
		if(!rm.containsKey(roomnum)) {
			System.out.println("그런방은 없습니다");
			
		}else {
			if(rm.get(roomnum).getCheck() == "-") {
				System.out.println("누구를 체크인 하시겠습니까?");
				System.out.println("이름 입력>>");
				s.nextLine();
				rm.get(roomnum).setCheck(s.nextLine());	
				System.out.println("예약성공!");
				break;
			}else {
				System.out.println("이미 예약된 방입니다.");
			}
		} 
	}
}
	
	void checkout() {
		System.out.println("----------------------------------------------\r\n" + 
				"   체크아웃 작업\r\n" + 
				"----------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.println("방 번호 입력 : ");
		int roomno = s.nextInt();
		if(!rm.containsKey(roomno)) {
			System.out.println("그런방은 없습니다");
			
		}else {
			System.out.println(roomno+"호 객실의 " +rm.get(roomno).getCheck()+"님 체크아웃을 완료하였습니다.");
			rm.get(roomno).setCheck("-");
			
		}
	}
	
	void roomstatus() {
		for(int key : rm.keySet()) {
			Room value = rm.get(key); 
			System.out.println(key + "\t" + value.getRoomname() + "\t" + value.getCheck());
		}
	}
	
}

class Room{
	private String roomname;
	private String check;
	
	Room(String roomname, String check){
		this.roomname = roomname;
		this.check = check;
	}

	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}
	
}
