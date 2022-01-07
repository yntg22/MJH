//package kr.or.ddit.basic;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//public class JackSon01{
//    public static void main(String[] args) throws InterruptedException{
//    	Student student0 = new Student("민진홍","대전시 동구 삼성동", "010-7710-0749");
//    	Student student1 = new Student("고성식","서구 갈마동", "010-9999-3333");
//    	
//    	Map<String,Student> student = new HashMap<>();
//    	student.put("민진홍", student0);
//    	student.put("고성식", student1);
//    	
//    	ObjectMapper mapper = new ObjectMapper();
//    	
//    	try {
//			mapper.writeValue(new File("result.json"), student);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	
//    }
//    
//}
//
//class Student{
//    public String name;
//    public String address;
//	public String phone;
//	
//    public Student(String name, String address, String phone) {
//		super();
//		this.name = name;
//		this.address = address;
//		this.phone = phone;
//	}
//	
//    public Student() {
//    	
//    }
//  
//}