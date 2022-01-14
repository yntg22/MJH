package d_array;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		/*
		 * 배열 - 여러개의 값을 하나의 변수에 저장해서 사용하는 것이다. - 참조형 타입이다. - 인덱스로 값을 구분한다. - 길이를 변경 할 수
		 * 없다.
		 */

		int[] array;
		array = new int[5];

		/*
		 * array(변수) = 100번지(주소)
		 * 
		 * 100번지 {0, 0, 0, 0, 0}
		 */

		array = new int[] { 1, 2, 3, 4, 5 };

//			array = {1, 2, 3, 4, 5};
		int[] array2 = { 1, 2, 3, 4, 5 }; /* 변수 선언과 초기화를 같이 해야함 */

		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		System.out.println(array[3]);
		System.out.println(array[4]);

		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		array[3] = 40;
		array[4] = 50;

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

		for (int i = 0; i < array.length; i++) {
			array[i] = (i + 1) * 10;
		}

		System.out.println(Arrays.toString(array)); // 한번에 출력

		// 10개의 정수를 저장할 수 있는 배열을 선언 및 초기화 해주세요.
		int[] arr = new int[10];

		// 배열의 모든 인덱스에 1~100사이의 랜덤한 값을 저장해주세요.
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100) + 1;
		}
		System.out.println(Arrays.toString(arr));

		// 배열에 저장된 모든 값의 합계와 평균을 출력해주세요
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		double avg = (double) sum / arr.length;
		System.out.println("합계 : " + sum + " / 평균 : " + avg);

		// 배열에 저장된 값들 중 최소값과 최대값을 출력해주세요.
		int a = arr[0];
		int b = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (a > arr[i]) {
				a = arr[i];
			}
			if (b < arr[i]) {
				b = arr[i];
			}
		}
		System.out.println("최소값 : " + a + " / 최대값 : " + b);

		int[] shuffle = new int[10];
		for (int i = 0; i < shuffle.length; i++) {
			shuffle[i] = i + 1;
		}
		System.out.println(Arrays.toString(shuffle));
		// 배열의 값을 섞어주세요
		int c = 0;
		for (int i = 0; i < shuffle.length; i++) {
			int j = (int) (Math.random() * 9);
			c = shuffle[i];
			shuffle[i] = shuffle[j];
			shuffle[j] = c;
		}
		
		System.out.println(Arrays.toString(shuffle));
		
		/* 선생님버전
 		for(int i = 0; i < shuffle.length *10; i++) {
		int random = (int)(Math.random() * shuffle.length);
		int temp = shuffle[0];
		shuffle[0] = shuffle[random];
		shuffle[random] = temp;
		}
		System.out.println(Arrays.toString(shuffle));
		*/
		
		
		//1~10 사이의 랜덤값을 500번 생성하고, 각 숫자가 생성된 횟수를 출력해주세요.
		int[] counts = new int[10];
		
		for(int i = 0; i < 500; i++) {
			int random = (int)(Math.random()* 10) + 1;
			counts[random -1]++;
			}
		System.out.println(Arrays.toString(counts));
			/*if(random == 1) counts[0]++;
			if(random == 2) counts[1]++;
			if(random == 3) counts[2]++;
			if(random == 4) counts[3]++;
*/		}
		/*int[] arr4 = new int[500];
		for(int i = 0; i < arr4.length; i++) {
		arr4[i] = (int)(Math.random()*9)+1;
		}
		
		int[] sum1 = new int[9];
		outer:for(int i = 0; i < arr4.length; i++) {
			for(int j = 1; j <= 9; j++) {
				if(arr4[i] == j) {
					sum1[i]+=1;
				}else { 
					continue outer;
			}
		}
		}
*/
	/*	int[] arr4 = new int[500];
		for(int i = 0; i < arr4.length; i++) {
		arr4[i] = (int)(Math.random()*9)+1;
		}
		System.out.println(Arrays.toString(arr4));
		
		int[] sum1 = new int[9];
		for(int i = 0; i < arr4.length; i++) {
			for(int j = 0; j <= 9; j++) {
				if(arr4[i] == 1) {
					sum1[j-1]++;
				}
				}
			
		}
		System.out.println(Arrays.toString(sum1));*/
		
		
		/*
		int f = 0;
		for(int i = 0; i < shuffle.length; i++) {
			for(int j = 0; j < shuffle.length; j++) {
				if(shuffle[i]<shuffle[j]) {
				f = shuffle[i];
				shuffle[i] = shuffle[j];
				shuffle[j] = f;
				}
			}
		}
		System.out.println(Arrays.toString(shuffle));
		*/
		/*int ds = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					ds = arr[i];
					arr[i] = arr[j];
					arr[j] = ds;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		 	*/
		/*
		int[][] arr3 = new int[10][10];
		for(int i = 0; i < arr3.length; i++) {
			for(int j = 0; j < arr3.length; j++) {
				arr3[i][j] = (int)(Math.random()*10)+1;
			}
		}
		
		System.out.println(Arrays.toString(arr3));*/
	
	
	}


