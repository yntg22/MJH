package kr.or.ddit.basic;

public class ArgTest {
	
	/*	가변형 인수 ==> 메서드의 매개변수의 개수가 실행될 때마다 다를 때 사용한다.
					- 가변형 인수는 메서드 안에서는 배열로 처리된다.
					- 가변형 인수는 한가지 자료형만 사용할 수 있다. 
	*/
	//가변형 인수를 이용한 메서드
	public int sumArg(int...data) {
		int sum = 0;
		for(int i = 0; i <data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	// 가변형 인수를 이용한 메서드
	// 가변형 인수와 일반적인 인수를 같이 사용할 경우에는 가변형 인수를
	// 제일 뒤쪽에 배치해야 한다.
	public String sumArg2(String name , int...data) {
		int sum = 0;
		for(int i = 0; i <data.length; i++) {
			sum += data[i];
		}
		return name + "씨의 합계 : " +sum;
	}
	
	public int sumArr(int[] data) {
		int sum = 0;
		for(int i = 0; i <data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		ArgTest test = new ArgTest();
		
		int[] nums = {100, 200, 300};
		
		int[] nums2;
		nums2 = new int[] {100, 200, 300};
		
		int result = test.sumArr(nums);
		System.out.println("result = " + result);
		// new int[]{1,2,3,4,5}
		System.out.println(test.sumArr(new int[]{1,2,3,4,5}));
		System.out.println("--------------------");
		//가변형인수
		System.out.println(test.sumArg(100,200,300));
		System.out.println(test.sumArg(1,2,3,4,5));
		System.out.println("--------------------");
		
		System.out.println(test.sumArg2("홍길동", 10,20,30,40));
		
		
		
		
	}

}
