package kr.or.ddit.basic;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class GsonTest {

	public static void main(String[] args) throws IOException {	
		
//		Map<String, String> inputMap = new HashMap<String, String>();//Map 객체생성
//		inputMap.put("이름", "홍길동");
//		inputMap.put("주소", "대전 중구 계룡로 846 3층");
//		inputMap.put("직업", "웹개발자");
//		        
//		// MAP -> JSON 예제
//		System.out.println("<Gson이용>");
//		String jsonStr = gson.toJson(inputMap);
//		System.out.println("MAP -> JSON : " + jsonStr);
//		//Map에서 JSON은 Gson객체 선언후 toJson으로.. 
//		
//		System.out.println("-----------------------------------------------");
//		// JSON -> MAP 예제
//		//JSON에서 Map은 객체 선언 후 fromJson입니다.
//		//단 fromJson은 변환 할 타입(Class)을 확실히 잡아주어야 합니다. 
//		Map map = gson.fromJson(jsonStr, Map.class);
//		System.out.println("JSON -> MAP : " + map.toString());
//		System.out.println("----------------------------------------------");
		//json파일 -> 출력
//		FileReader reader = new FileReader("d:/d_other/peo.json");
//		//json 파일 읽어서, Map으로 변환
//		Map<String,String> map2 = new HashMap();
//		map2 = gson.fromJson(reader, Map.class);
//		System.out.println(map2);	
		//-----------------------------------------------------------------------
		Gson gson = new Gson();
		System.out.println("-------------------------------------------------");
		Map<String,People> peo00 = new HashMap();
		FileWriter fw = new FileWriter("d:/d_other/peo.json");
		peo00.put("kim", new People("kim", "청주시", 20));
		peo00.put("지농", new People("지농", "디비시", 20));
		peo00.put("성쉭", new People("성쉭", "대전시", 20));
		peo00.put("바보", new People("바보", "청주시", 20));
		
		gson.toJson(peo00, fw);
		
		fw.flush();
		fw.close();
	}

}

class People{
	private String name;
	private String addr;
	private int age;
	public	People(String name, String addr, int age) {
		this.name = name;
		this.addr = addr;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", addr=" + addr + ", age=" + age + "]";
	}
	
}
