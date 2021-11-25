package i.api;

public class StringSpeedTest {

	public static void main(String[] args) {
//		String str = "a";
//		
//		long start = System.currentTimeMillis();
//		
//		for(int i = 0; i < 200000; i++) {
//			str += "a";
//		}
//		long end = System.currentTimeMillis();
//		System.out.println(end - start + "ms");
		
		//스트링은 문자열이 변경되면 새로운객체를 만든다.
		 
		//스트링버퍼를 이용하자
		StringBuffer sb = new StringBuffer("a");
		long start = System.currentTimeMillis();
		for(int i = 0; i < 200000; i++) {
			sb.append("a");
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start + "ms");
		
	}

}
