package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest02 {

	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<>();
		
		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "이순신", "010-2222-1111"));
		memList.add(new Member(9, "성춘향", "010-3333-1111"));
		memList.add(new Member(3, "강감찬", "010-4444-1111"));
		memList.add(new Member(6, "일지매", "010-5555-1111"));
		memList.add(new Member(2, "변학도", "010-6666-1111"));
		
		System.out.println("정렬전...");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("------------------------------------------------");
		
		Collections.sort(memList);//내부정렬기준을 만들어주거나 외부정렬기준을 만들어서 넣어줘야함
		
		System.out.println("정렬후...");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("------------------------------------------------");

		// Member클래스의 회원번호의 내림차순으로 정렬하는 외부 정렬 기준 클래스를
		// 이용하여 정렬하시오. (외부정렬기준 클래스명 : SortNumDesc )
//		Collections.sort(memList, new Desc());
		System.out.println("내림차순 정렬 후 : " + memList);
		
		Collections.sort(memList, new SortNumDesc());
		System.out.println("번호의 내림차순 정렬후...");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("------------------------------------------------");
	}

}

class SortNumDesc implements Comparator<Member>{
	@Override
	public int compare(Member mem1, Member mem2) {
//		if(mem1.getNum() < mem2.getNum()) {
//			return 1;
//		}else if(mem1.getNum() > mem2.getNum()) {
//			return -1;
//		}else {
//			return 0;
//		}
		//Wrapper클래스를 이용하는 방법1         	원래 오름차순인데 -1을 곱해줌으로써 음수로 만들어주면 내림차순이 된다.
//		return new Integer(mem1.getNum()).compareTo(mem2.getNum()) * -1;
		
		//Wrapper클래스를 이용하는 방법1         	원래 오름차순인데 -1을 곱해줌으로써 음수로 만들어주면 내림차순이 된다.
		return Integer.compare(mem1.getNum(), mem2.getNum()) * -1;
		
	}
}

// Member클래스의 회원이름을 기준으로 오름차순이 되도록 내부 정렬 기준을 추가하기 
// ==> Comparable인터페이스를 구현한다. 
class Member implements Comparable<Member>{
	private int num;		// 회원번호
	private String name;	// 회원이름
	private String tel;		// 전화번호
	
	// 생성자...
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}


	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}


	@Override
	public int compareTo(Member mem) {
		// this.getName()--> 앞쪽데이터	,	mem.getName()--> 뒤쪽데이터
		return this.getName().compareTo(mem.getName()); // 오름차순 일 때
//		return this.getName().compareTo(mem.getName()) * -1; // 내림차순 일 때
	}
}

//
//class SortNumDesc implements Comparator<Integer> {
//	
//	@Override
//	public int compare(Integer str1, Integer str2) {
//		if(str1.compareTo(str2)<0) {
//			return 1;
//		}else if(str1.compareTo(str2)>0) {
//			return -1;
//		}else {
//			return 0;
//		}
//	}


