package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class RandomStudents {

	public static void main(String[] args) {
		// 25명 숫자입력받음 1~25사이 5라고 입력하면 25명중에서 5명 랜덤으로 뽑음 (뽑힌사람 중복 x)
		String[] human = { "강정윤", "고성식", "김민경", "김민호", "김은혜",
						   "김재웅", "노현정", "민진홍", "박상진", "박상현",
						   "박세준", "손효선", "양동현", "양승혁", "양아연",
						   "이유정", "이응주", "이정수", "정석철", "정지수",
						   "조화랑", "주창규", "한영민", "황선부", "이기석" };
		
		Scanner s = new Scanner(System.in);
		System.out.print("몇명을 뽑을까요? : ");
		int in = Integer.parseInt(s.nextLine());
		String[] result = new String[in]; //입력받은 값 크기만큼 생성

		/*int count1 = 0;
		while (true) {
			int count = 0;
			int random = (int) (Math.random() * 25);//랜덤을 생성하고, 넣을 값과 들어있는 값을 비교함
			for (int i = 0; i < result.length; i++) {
				if (result[i] == human[random]) {
					count++;
				} //count = 0  count = 1(아무것도안함)
			}

			//count 0 이면 중복x 값넣음
				if (count == 0) { //count1 == 값넣을 자리
					result[count1] = human[random];
					count1++;//값을 넣고나면 0+1 = 1인덱스에 넣음 > 2..3.4..5.
					//System.out.println(Arrays.toString(result));
				}

				if (count1 == in) { //값 넣을자리와 사용자가 입력한 사람수가 같아지면 종료
					break;
				}
				
		}
		System.out.println(Arrays.toString(result));*/
		
		
		
	/* 다른생각 int num = Integer.parseInt(s.nextLine());
		String[] qoduf = new String[num];
		for(int i = 0; i < num; i++) {
		int random1 = (int) (Math.random() * 25);
		qoduf[i] = human[random1];
		}
		for(int i = 0; i < qoduf.length; i++) {
			for(int j = 1; j < qoduf.length; j++) {
				if(qoduf[i] == qoduf[j]) {
					int random2 = (int) (Math.random() * 25);
					qoduf[i] = human[random2];
				}
				
				}
			}
		}
		*/

		
		
	int count1 = 0;
		do {
			int count = 0;
			int random = (int) (Math.random() * 25);// 랜덤을 생성하고, 넣을 값과 들어있는 값을 비교함
				for (int i = 0; i < result.length; i++) {
					if (result[i] == human[random]) {
					count++;
				} // count = 0 count = 1(아무것도안함)
			}

			// count 0 이면 중복x 값넣음
			if (count == 0) { // count1 == 값넣을 자리
				result[count1] = human[random];
				count1++;// 값을 넣고나면 0+1 = 1인덱스에 넣음 > 2..3.4..5.
				// System.out.println(Arrays.toString(result));
			}
		} while (count1 != in);
		System.out.println(Arrays.toString(result));
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
				
		
		
		
		
		
		
		
		
		
	}

}
