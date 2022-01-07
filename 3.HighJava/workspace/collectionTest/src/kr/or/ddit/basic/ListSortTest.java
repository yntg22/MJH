package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 정렬과 관련된 interface는 Comparable, Comparator 이렇게 2가지가 있다.
 * 
 * Comparable은 Collection에 추가되는 데이터 자체의 정렬 기준을 넣고 싶을 때
 * 구현하는 인터페이스이고, (내부정렬기준)
 * Comparator는 외부에 별도로 정렬 기준을 구현하고 싶을 때 구현하는 인터페이스이다.
 * (외부정렬 기준)
 * 
 * Comparable에서는 compareTo()메서드를 재정의 해야하고,
 * Comparator에서는 compare()메서드를 재정의 해야한다.
 * 
 * String클래스, Wrapper클래스들, Date클래스, File클래스에는
 * 내부 정렬 기준이 구현되어 있다.
 */
public class ListSortTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		
		System.out.println("정렬전 : " + list);
		
		// 정렬은 Collections.sort()메서드를 이용하여 정렬한다.
		// Collection.sort()메서드는 기본적으로 Collection에 포함된
		// 데이터의 내부 정렬 기준으로 정렬한다.
		// (기본적인 데이터들의 내부정렬기준은 오름차순이 되도록 구현되어 있다.)
		
		Collections.sort(list);
		System.out.println("정렬후 : " + list);
		
		Collections.shuffle(list); // 데이터 섞기
		System.out.println("자료 섞기 후 : " + list);
		
		// 외부 정렬 기준을 적용해서 정렬하기
		// 형식) Collections.sort(리스트객체, 외부정렬기준객체)
		Collections.sort(list, new Desc());
		System.out.println("내림차순 정렬 후 : " + list);
	}

}


// 외부 정렬 방식을 정해주는 Class를 만든다.(외부 정렬 기준 클래스라고 한다.)
// Comparator인터페이스를 구현한다.
class Desc implements Comparator<String>{

	// compare()메서드를 이용해서 정렬하고자 하는 기준을 정해준다.
	
	// compare()메서드의 반환값의 역할
	// 반환값이 0일 때 ==> 두 값이 같다. (두 값의 순서는 변하지 않는다.)
	// 반환값이 양수일 때 ==> 두 값의 순서가 바뀐다.
	// 반환값이 음수일 때 ==> 두 값의 순서가 바뀌지 않는다.
	
	// 예) 오름차순의 경우 ==> 앞의 값이 크면 양수를 반환시키고,
	//					    같으면 0을...
	//					    앞의 값이 작으면 음수를 반환시키면 된다.
	@Override
	public int compare(String str1, String str2) {
		// 내림차순으로 정렬되도록 구현하려고 한다.
		
		if(str1.compareTo(str2)<0) {
			return 1;
		}else if(str1.compareTo(str2)>0) {
			return -1;
		}else {
			return 0;
		}
	}
	
}
