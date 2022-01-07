package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class SetTest {

	public static void main(String[] args) {
		/*
		 * - List와 Set의 차이점
		 * 1) List
		 * 	  - 데이터의 순서(index)가 있다.
		 *    - 중복되는 데이터를 저장할 수 있다.
		 * 2) Set
		 *    - 데이터의 순서(index)가 없다.
		 *    - 중복되는 데이터를 저장할 수 없다.
		 *    
		 */
		
		HashSet hs1 = new HashSet<>();
		
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);
		
		System.out.println("set 데이터 : " + hs1);
		System.out.println("size : " + hs1.size());
		
		// Set에 중복되는 데이터를 추가하면 false를 반환하고 데이터는 추가되지 않는다.
		boolean isAdd = hs1.add("FF");
		System.out.println("중복되지 않을 때 : "+isAdd);
		System.out.println("set 데이터 : "+ hs1);
		isAdd = hs1.add("CC");
		System.out.println("중복되었을 때 : "+isAdd);
		System.out.println("set 데이터 : "+ hs1);
		
		// Set의 데이터 수정하기
		// ==> 수정하는 명령이 따로 없기 때문에 해당 자료 삭제한 후 다시 추가하는 방법을 사용한다.
		
		// 삭제하는 메서드 : remove(삭제할 자료)
		// 			==> 반환값 : 삭제성공(ture), 삭제실패(false)
		// 삭제하는 메서드 : clear() ==> 전체 삭제
		
		// 'FF' 데이터를 'EE'로 변경하기
		hs1.remove("FF");
		System.out.println("삭제후 Set => "+hs1);
		hs1.add("EE");
		System.out.println("추가후 Set => "+hs1);
		
//		hs1.clear();
//		System.out.println("Set 데이터 =>"+hs1);
		
		/*
		 * Set의 데이터는 순서(index)가 없기 때문에 List처럼 index로 데이터를
		 * 하나씩 불러올 수 없다.
		 * 그래서 데이터를 하나씩 얻기 위해서는 Iterator형 객체로 변환해야 한다.
		 * 
		 * - Set형의 데이터를 Iterator형 객체로 변환하는 메서드 ==> iterator() 메서드
		*/
		
		Iterator it = hs1.iterator(); // Set의 데이터들을 Iterator로 변환하기
		
		// Iterator의 hasNext() 메서드
		//	==> Iterator의 포인터가 가리키는 곳의 다음번째에 데이터가 있는지 검사한다.
		//  	해당 위치에 데이터가 있으면 true, 없으면 false를 반환한다.
		while(it.hasNext()) {
			// Iterator next() 메서드
			// ==> Iterator의 포인터를 다음 데이터 위치로 이동시키고,
			//	      이동한 위치의 데이터를 반환한다.
			System.out.println(it.next());
		}
		//hasNext()와 next()는 세트메뉴
		System.out.println("==========================================");
		
		//향상된 for문
		for(Object obj : hs1) {
			System.out.println(obj);
		}
		System.out.println("==========================================");
		
		// 우리반 학생들 중 번호를 이용하여 추첨하는 프로그램을 작성해보자.
		// 번호는 1번부터 25번까지 있고, 추첨할 인원은 3명이다.
		// 당첨자를 출력해 보시오.
		
		// 최소값 ~ 최대값 사이의 난수값 만들기
		// (int)(Math.random() * (최대값-최소값+1) + 최소값)
		
		HashSet<Integer> testSet = new HashSet<>();
		while(testSet.size()<3) {
			//Math.random() * 25 + 1
			testSet.add((int)(Math.random()*(25-1+1) +1));
		}
		System.out.println("당첨자 번호 : " + testSet);
		System.out.println();
		
		// Set유형의 자료를 List형으로 변환하기
		ArrayList<Integer> testList = new ArrayList<>(testSet);
		
		System.out.println("List데이터 출력하기");
		for(int i = 0; i < testList.size(); i++) {
			System.out.println(i + "번째 자료 : " + testList.get(i));
		}
		
		
		
		
	}

}
