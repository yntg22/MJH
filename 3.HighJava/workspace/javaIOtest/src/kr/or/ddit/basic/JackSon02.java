package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JackSon02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		
		
		Student student = new Student();
		
		//Map으로 불러오기
		Map<String, Object> jsonMap = null;
		try {
			jsonMap = mapper.readValue(new File("result.json"), new TypeReference<Map<String, Object>>() {});
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Student 객체 출력
		System.out.println(jsonMap);
		System.out.println(jsonMap);
		System.out.println(jsonMap.get("name"));
		System.out.println(jsonMap.keySet());
		Map<String,String> student2 = (Map<String, String>) jsonMap.get("민진홍");
		
		System.out.println(student2);
		student2.put("name", "김재웅");
		System.out.println(student2);
		jsonMap.get("민진홍").
		System.out.println(jsonMap);
		

		
	
	

		//이건 클래스로 불러오기?
//			try {
//				student = mapper.readValue(new File("result.json"), Student.class);
//				
//			} catch (StreamReadException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (DatabindException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
//		System.out.println(student);
	
	}
}

class Student{
  public String name;
  public String address;
	public String phone;
	
  public Student(String name, String address, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
  public Student() {
  	
  }

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

@Override
public String toString() {
	return "Student [name=" + name + ", address=" + address + ", phone=" + phone + "]";
}
  

}