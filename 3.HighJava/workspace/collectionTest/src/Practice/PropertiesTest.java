package Practice;

import java.util.Properties;

/*
	Properties객체는 Map보다 축소된 기능의 객체라고 할 수 있다.
	
	- Map은 Key값과 value값에 모든 형태의 객체를 사용할 수 있다.
	- Properties는 key값과 value값에 String만 사용할 수 있다.
	
	- Map은 put(), get()메서드를 이용해서 데이터를 입출력하고,
	  Properties는 setProperty(), getProperty() 메서드를
	  통해서 데이터를 입출력한다.
	  
	- Properties는 데이터를 파일로 입출력하는 기능이 있다.
*/
public class PropertiesTest {

	public static void main(String[] args) {
		Properties prop = new Properties();
		
		int age = 30;
		prop.setProperty("name", "홍길동");
		prop.setProperty("age1", "" + age);
		prop.setProperty("age2", String.valueOf(age));
		prop.setProperty("tel", "010-1234-5678");
		prop.setProperty("addr", "대전시 중구 대흥동");
		
		String name = prop.getProperty("name");
		int age1 = Integer.parseInt(prop.getProperty("age1"));
		int age2 = Integer.parseInt(prop.getProperty("age2"));
		String tel = prop.getProperty("tel");
		String addr = prop.getProperty("addr");
		
		System.out.println("이름 : " + name);
		System.out.println("나이1 : " + age1);
		System.out.println("나이2 : " + age2);
		System.out.println("전화 : " + tel);
		System.out.println("주소 : " + addr);
		
	}

}
