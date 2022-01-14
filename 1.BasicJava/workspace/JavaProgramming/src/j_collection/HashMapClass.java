package j_collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import e_oop.ScanUtil;

public class HashMapClass {

	public static void main(String[] args) {
		/*
		 * Object put(Object key, Object value) : 지정된 키와 값을 저장한다.
		 * Object remove(Object key) : 지정된 키로 저장된 값을 제거한다.
		 * Object get(Object key) : 지정된 키의 값(없으면 null)을 반환한다.
		 * Set keySet() : 저장된 모든 키를 Set으로 반환한다.
		 */
		        //키타입  //값타입
		HashMap<String,Object> map = new HashMap<>(); //해쉬맵은 값타입을 object로도 사용한다...키타입에 따라 값타입도 유추할수있기 때문?
		
		map.put("age", 10);
		map.put("name", "홍길동");
		map.put("date", new Date());
		
		System.out.println(map);
		//수정하는법 = 같은키로 한번 더 저장
		map.put("name", "이순신");
		System.out.println(map);
		
		Object value = map.get("name");
		System.out.println(value);
		//형변환
		((String)value).substring(1,2);
		String val = (String)map.get("name");
		
			//key타입에 맞춘다
		Set<String> keys = map.keySet();
		System.out.println(keys);
		
		for(String key : keys) { //향상된 for문  (:)을 기준으로 뒤에 여러개의 데이터를 담고있는 배열이나,어레이리스트 등이 올수있고 왼쪽에 있는 변수는 오른쪽에있는 값을 하나 꺼내오면 저장될 변수이다 /모든걸 다 꺼내서 한번씩 수행해줌
			System.out.println(key + " : " + map.get(key));
		}
		
		//테이블구조를 표현할때 HashMap 사용
		ArrayList<HashMap<String, Object>> lprodTable = new ArrayList<>();
		
		HashMap<String, Object> lprod = new HashMap<>();
		//1  p101 	컴퓨터제품
		lprod.put("LPROD_ID", 1);
		lprod.put("LPROD_GU", "P101");
		lprod.put("LPROD_NM", "컴퓨터제품");
		
		lprodTable.add(lprod);
		System.out.println(lprodTable);
		
		lprod = new HashMap<>();
		lprod.put("LPROD_ID", 2);
		lprod.put("LPROD_GU", "P102");
		lprod.put("LPROD_NM", "전자제품");
		
		lprodTable.add(lprod);
		
		
		lprod = new HashMap<>();
		lprod.put("LPROD_ID", 3);
		lprod.put("LPROD_GU", "P201");
		lprod.put("LPROD_NM", "여성캐주얼");
		
		lprodTable.add(lprod);
		
		lprod = new HashMap<>();
		lprod.put("LPROD_ID", 4);
		lprod.put("LPROD_GU", "P202");
		lprod.put("LPROD_NM", "남성캐주얼");
		
		lprodTable.add(lprod);
		
		lprod = new HashMap<>();
		lprod.put("LPROD_ID", 5);
		lprod.put("LPROD_GU", "P301");
		lprod.put("LPROD_NM", "피혁잡화");
		
		lprodTable.add(lprod);
		
		
		System.out.println(lprodTable);
		
		ScanUtil s = new ScanUtil();
		System.out.println("입력 > ");
		int input = s.nextInt();
		
		//사용자가 lprod 아이디를 입력하면 비교해서 찾아내라? 1을 입력받으면, 해쉬맵 lprod_id키에있는 값 1,2,3,4,5와 비교해서 맞는걸 찾으면?		
		for(int i = 0; i < lprodTable.size(); i++) {
			if(input == (int)lprodTable.get(i).get("LPROD_ID")){
				System.out.println(lprodTable.get(i));
			}
		}
//		System.out.println(lprodTable.get((int)lprod.get("LPROD_ID")));
	
		
		
		
		
	}

}
