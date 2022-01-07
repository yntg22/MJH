package kr.or.ddit.basic;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		
		// 객체 생성
		Vector v1 = new Vector();
		
		System.out.println("크기 : " + v1.size());
		
		// 데이터 추가하기 : add
		// 반환값 : 추가성공(true), 실패(false)
		
		v1.add("aaaa");
		v1.add(new Integer(111)); //객체만 저장할 수 있기때문에 wrapper 클래스로 만들어 저장 char는 character라고 써야함
		v1.add(123); //그런데 이제 진화해서 안해도됨 내부에서 자동으로 객체화시켜줌 ==> 오토박싱 ==> 오토언박싱
		v1.add('a');
		v1.add(true);
		v1.add(3.14);
		System.out.println("크기 : " + v1.size());

		v1.addElement("CCC");
		System.out.println("v1 => " + v1);
		
		// 데이터 추가 : add(index, 데이터)
		// ==> index번째에 '데이터'를 끼워넣는다.
		// ==> 반환값은 없다.
		v1.add(1,"KKK");
		System.out.println("v1 => " + v1);
		
		// 데이터 수정 : set(index, 새로운데이터)
		// ==> index번째에 데이터를 '새로운데이터'로 덮어쓴다.
		// ==> 반환값 : 원래의 데이터
		String temp = (String) v1.set(1, "ZZZ");
		System.out.println("v1 => " + v1);
		System.out.println("temp => " + temp);
		
		// 데이터 삭제 : remove(index)
		// ==> index번째 데이터를 삭제한다.
		// ==> 반환값 : 삭제된 데이터
		String temp2 = (String) v1.remove(0);
		System.out.println("삭제 후 v1 => " + v1);
		System.out.println("삭제된 데이터 == > " + temp2);
		
		// 데이터 삭제 : remove(삭제할데이터)
		// ==> '삭제할 데이터'를 찾아서 삭제한다.
		// ==> '삭제할 데이터'가 여러개 존재하면 앞에서부터 삭제된다.
		// ==> 반환값 : 삭제성공(true), 삭제실패(false)
		// ==> '삭제할 데이터'가 '정수형' 종류이거나 'char형'일 경우에는
		//     반드시 객체로 변환해서 사용해야 한다.
		v1.remove("CCC");
		System.out.println("삭제 후 v1 = > " + v1);
		
		v1.remove(new Integer(123)); //정수타입의 데이터를 지우고싶으면 wrapper 클래스를 이용해야한다.
		System.out.println("삭제 후 v1 => " + v1);
		
		v1.remove(new Character('a'));
		System.out.println("삭제 후 v1 => " + v1);
		
		v1.remove(true);
		v1.remove(3.14);
		System.out.println("삭제 후 v1 => " + v1);
		
		//데이터 꺼내오기 : get(index)
		// ==> 'index번째'의 데이터를 꺼내서 반환한다.
		int data = (int) v1.get(1);
		System.out.println("1번째index 자료"+data);
		
		// --------------------------------------------
		/*
		 * 제네릭 타입(Generic Type) ==> 클래스 내부에서 사용할 데이터 타입을
		 * 							    외부에서 지정하는 기법
		 * 						  ==> 객체를 선언할 때 <  > 안에 그 객체가 사용할 데이터의
		 * 							    타입을 정해주는 것을 말한다.
		 * 						  ==> 이렇게 선언하면 다른 종류의 데이터를 저장할 수 없다.
		 * 						  ==> 이 때 <  >안에 지정하는 데이터 타입은 클래스형이어야 한다. ex)Integer, Double, String, Boolean, Character
		 * 						  ==> 데이터를 꺼내올 때 별도의 형변환이 필요없다.
		*/
		Vector<String> v2 = new Vector<String>(); //String만 저장
		Vector<Integer> v3 = new Vector<Integer>(); //int형만 저장
		
		v2.add("안녕하세요");
//		v2.add(123); //오류 : 다른 종류의 데이터를 저장할 수 없다.
		String temp3 = v2.get(0);
		System.out.println("temp3 = " + temp3);
		
		Vector<Vector> vv = new Vector<>();
		Vector<Vector<Vector>> vvv = new Vector<>();
		
		//--------------------------------------------------------
		v2.clear(); //전체 데이터 삭제
		System.out.println("v2의 크기 : " + v2.size());
		
		v2.add("AAAA");
		v2.add("BBBB");
		v2.add("CCCC");
		v2.add("DDDD");
		v2.add("EEEE");
		
		Vector<String> v4 = new Vector<>();
		v4.add("BBBB");
		v4.add("DDDD");
		
		System.out.println("v2 => " + v2);
		System.out.println("v4 => " + v4);
		
		// 데이터 삭제 : removeAll(Collection객체)
		// ==> 'Collection객체'가 가지고 있는 데이터를 모두 삭제한다.
		v2.removeAll(v4); //v2가 가지고있는것들중에 v4가 가지고 있는 데이터들을 모두 삭제해라
		System.out.println("삭제 후 v2 => " + v2);
		
		//--------------------------------------------------------
		v2.clear();
		v2.add("AAAA");
		v2.add("BBBB");
		v2.add("CCCC");
		v2.add("DDDD");
		v2.add("EEEE");
		
		// 벡터의 전체의 데이터를 차례로 가져와 처리할 때는 반복문을 사용하면 된다.
		for(int i = 0; i < v2.size(); i++) {
			System.out.println(i + "번째 자료 : " + v2.get(i));
		}
		
		// 향상된 for문
		for(String s : v2) {
			System.out.println(s);
		}
		
		
		
		
		
		
	}

}
