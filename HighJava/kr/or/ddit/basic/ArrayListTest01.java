package kr.or.ddit.basic;

import java.util.ArrayList;

public class ArrayListTest01 {

	public static void main(String[] args) {
		// ArrayList의 기본적인 사용법은 Vector와 같다.
		ArrayList list1 = new ArrayList();
		
		// add()메서드를 이용하여 데이터를 추가한다.
		list1.add("aaa");
		list1.add("bbb");
		list1.add(123);
		list1.add('k');
		list1.add(true);
		list1.add(123.45);
		
		System.out.println("list => " + list1);
		System.out.println("size => " + list1.size());
		
		// get()메서드로 데이터를 꺼내온다.
		System.out.println("1번째 자료 : " + list1.get(1));
		
		// 데이터 끼워넣기도 같다.
		list1.add(3, "zzz");
		System.out.println("list1 => "+list1);
		
		//데이터 변경하기
		String temp = (String) list1.set(3, "yyy");
		System.out.println("list1 => " + list1);
		System.out.println("temp => " + temp);
		
		//삭제도 같다
		list1.remove(3);
		System.out.println("list1 => " + list1);
		
		list1.remove("bbb");
		System.out.println("list1 => " + list1);
		
		// 제네릭을 사용할 수 있다.
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("AAAAAA");
		list2.add("BBBBBB");
		list2.add("CCCCCC");
		list2.add("DDDDDD");
		list2.add("EEEEEE");
		
		System.out.println("-------------------------------------");
		for(int i = 0; i < list2.size(); i++) {
			System.out.println(i + " ==> " + list2.get(i));
		}
		System.out.println("-------------------------------------");		
		for(String s : list2) {
			System.out.println(s);
		}
		System.out.println("-------------------------------------");
		
		// contains(비교객체)
		// ==> 리스트에 '비교객체'가 있으면 true, 없으면 false를 반환한다.
		System.out.println("ZZZZZZ값 : " + list2.contains("ZZZZZZ"));
		System.out.println("CCCCCC값 : " + list2.contains("CCCCCC"));
		
		// indexOf(비교객체)
		// ==> 리스트에 '비교객체'가 있으면 '비교객체'가 있는 index값을 반환하고,
		//		없으면 '-1'을 반환한다.
		System.out.println("CCCCCC의 위치값 : " + list2.indexOf("CCCCCC"));
		System.out.println("ZZZZZZ의 위치값 : " + list2.indexOf("ZZZZZZ"));
		System.out.println();
		
		// toArray() ==> 리스트 안의 데이터를 배열로 변환하여 반환한다.
		// 			 ==> 반환되는 배열은 기본적으로 Object형 배열이 된다.
		
		// toArray(new 제네릭타입[0] ==> 제네릭 타입의 배열로 반환된다.
		
		Object[] strArr = list2.toArray();
		
		System.out.println("배열의 개수 : " + strArr.length);
		
		String[] mystr = list2.toArray(new String[0]);
		
		for(String str : mystr) {
			System.out.println(str);
		}
		System.out.println("-------------------------------------------");
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
