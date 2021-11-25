package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class Quiz {

	public static void main(String[] args) {
		int money = (int)(Math.random()*500) * 10;
		int[] coin = {500, 100, 50, 10};
		
		System.out.println("거스름돈 : " + money);
		
		/*
		 *거스름돈에 동전의 단위마다 몇개의 동전이필요한지 출력해주세요
		 *
		 * 거스름돈 : 2860원
		 * 500원 : 5개
		 * 100원 : 3개
		 * 50원 : 1개
		 * 10원 : 1개
		*/
		
		//  /500 =  /100  = /50  = /10

		for(int i = 0; i < coin.length; i++) {
			int temp = money / coin[i];
			money %= coin[i];
			System.out.println(coin[i] + "원 : " + temp + "개");
		}
		 
		
		int[] arr = new int[20];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 5) + 1;
		}
		System.out.println(Arrays.toString(arr));
		/*
		 * 1~5의 숫자가 발생된 횟수 만큼 *을 사용해 그래프를 그려주세요.
		 * 
		 * 1 : *** 3
		 * 2 : **** 4
		 * 3 : ** 2
		 * 4 : ***** 5
		 * 5 : ****** 6
		*/

		for (int i = 1; i <= 5; i++) {
			String count = "";
			int num = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == i) {
					count += "*";
					num++;
				}

			}
			System.out.println(i + " : " + count + " " + num);
		}
		
		//값이 몇개 있는지 세서 출력하라고?
		
		/*for (int i = 1; i <= 5; i++) {
			int num= 0;
			for(int j = 0; j < arr.length; j++) {
				if (arr[j] == i) {
					num++;
				}
			}
			String star = "";
			for (int k = 0; k <= num; k++) {
			star += "*";
			}
			System.out.println(i + " " +star+" "+num);
		}
		*/
		//선생님v
		/*int[] counts = new int[5];
		for (int i = 0; i < arr.length; i++) {
			counts[arr[i] - 1]++;
		}
		
		for (int i = 0; i < counts.length; i++) {
			System.out.println(i + 1 + " : ");
			for (int j = 0; j < counts[i]; j++) {
				System.out.println("*");
			}
			System.out.println(" " + counts[i]);
		}
		*/
		
		arr = new int[10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 5) + 1;
		}
		System.out.println(Arrays.toString(arr));
		/*
		 * 1~5의 랜덤한 값이 1개 저장된 배열에서 중복된 값이 제거된 배열을 만들어주세요
		 * [2, 5, 4, 5, 4, 4, 4, 3, 2, 5]
		 * [2, 5, 4, 3]
		 * 1. 첫번쨰 숫자는 고정 / 두번째 값과 첫번째 값이 같으면 패스 다르면 저장/ 세번째값과 1,2번째값이 같으면 패스 /다르면 저장 / 네번째 값과 1,2,3번째 값이 같으면 패스 / 다르면 저장
		 * 2. 달라서 저장할때 해야할것. 인덱스 0127인덱스면 count=4배열만들어서 
		 * 3. count 수에 따라 배열칸수 만들고 인덱스 0127을 저장
		 * 4. 인덱스를 어디에 저장?
		 * 개수에 따라, 몇칸을 만들지가 정해진다음 들어가야함
		*/
			/*int[] temp = new int[5];
			int count = 0;
			for(int i = 0; i < arr.length; i++) {
				boolean flag = true;
				for(int j = 0; j < temp.length; j++) {
					if(arr[i] == temp[j]) {
						flag = false;
					}
				}
				if(flag) {
					temp[count++] = arr[i];
					
				}
				
			}
			int[] result = new int[count];
			for(int i = 0; i < result.length; i++) {
				result[i] = temp[i];
			}
			System.out.println(Arrays.toString(result));
		*/
		
		boolean flag = true;
		int count = 0;
		int[] temp = new int[5];
		for (int i = 0; i < arr.length; i++) {
			flag = true;
			for (int k = i - 1; k >= 0; k--) {
				
				if (arr[i /*늘어나는값*/ ] == arr[k /*감소하는값 혹은 늘어나다가 재랑ㅁ만나면 끝나는값*/ ]) {
					flag = false;
				}
			}

			if (flag == true) {
				temp[count] = arr[i];		//배열값도 넣어야지 그런데..어디에?
				count++; // 카운트 1 올라감
				
			}
		}
			
			System.out.println(count);
			int[] arr2 = new int[count];
			for(int j = 0; j < arr2.length;j++) {
				
					arr2[j] = arr[j];
			
			System.out.println(Arrays.toString(arr2));
		}

		
		
		
		
		
		
		
		
		
		
		
	}
}
		
	
		
		
		
		
		