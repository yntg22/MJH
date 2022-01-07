package kr.or.ddit.basic;

import java.util.HashSet;

public class EqualsHashCodeTest {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setId(1);
		p1.setName("홍길동");
		
		Person p2 = new Person();
		p2.setId(1);
		p2.setName("홍길동");
		
		System.out.println(p1 == p2);

		
		System.out.println(p1.equals(p2));
		
		System.out.println("p1 => " + p1);
		System.out.println("p2 => " + p2);
		
		System.out.println("-------------------------------");
		HashSet<Person> testSet = new HashSet<>();
		
		testSet.add(p1);
		testSet.add(p2);
		
		System.out.println("set의 개수 : " + testSet.size());
		
		System.out.println("p1 hashCode : " + p1.hashCode());
		System.out.println("p2 hashCode : " + p2.hashCode());
		
		System.out.println(p1.getClass().getName() + "@" + Integer.toHexString(p1.hashCode()));
		System.out.println(Integer.toHexString(p2.hashCode()));
		
		
		System.out.println(System.identityHashCode(p1));
		System.out.println(System.identityHashCode(p2));
		
		String name1 = "민진홍";
		String name2 = "민진홍";
		System.out.println(name1.equals(name2));
		System.out.println(name1 == name2);
		
	}

}

/*
	- equals() 메서드 ==> 두 객체의 내용이 같은지 비교하는 메서드
	- hashCode() 메서드 ==> 두 객체의 동일성을 검사하는 메서드
	
	- HashSet, Hashtable, HashMap와 같이 Hash로 시작하는 컬렉션 객체들은
	    객체의 의미상 동일성을 비교하기 위해서 hashCode()메서드를 호출해서 비교한다.
	    그래서, 객체가 같은지 여부를 결정하려면 hashCode()메서드를 재정의 해야한다.
*/

class Person{
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		if(obj==null) return false;
//		// getClass() ==> 클래스 정보 가져오는 메서드
//		// 같은 유형의 클래스인지 검사
//		if(this.getClass() != obj.getClass()) 
//			return false;
//		
//		// 참조값(주소값)이 같은지 검사
//		if(this == obj)
//			return true;
//		
//		Person temp = (Person)obj;
//		
//		if(this.name==null && temp.name!=null) 
//			return false;
//		
//		if(this.id==temp.id && this.name==temp.name) {
//			return true;
//		}
//		
//		if(this.id==temp.id && this.name.equals(temp.name)) {
//			return true;
//		}
//		
//		return false;
//		
//	}
	
}