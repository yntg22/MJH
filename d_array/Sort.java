package d_array;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		/*
		 * - 석차구하기 : 점수를 비교해 작은 점수의 등수를 증가시키는 방식
		 * - 선택정렬 : 가장 작은 숫자를 찾아서 앞으로 보내는 방식
		 * - 버블정렬 : 바로 뒤의 숫자와 비교해서 큰 수를 뒤로 보내는 방식
		 * - 삽입정렬 : 두번째 숫자부터 앞의 숫자들과 비교해서 큰수는 뒤로밀고 중간에 삽입하는 방식
		 */
		
		int[] arr = new int[10]; //랜덤점수부여
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 100) + 1;
		}
		System.out.println(Arrays.toString(arr));
		
		/* *석차 구하기  
		int[] rank = new int[arr.length];  //석차저장
		for(int i = 0; i < arr.length; i++) {
			rank[i] = 1;
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[i] < arr[j]) {
					rank[i]++;
				}
			}
		}
		System.out.println(Arrays.toString(rank));
		*/
		
		
		/*int temp = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				System.out.println(i + " " + j);// 0 , 0 / 0 , 1 / 0 , 2 ...
				if(arr[i]>arr[j]) {               // 0 , 1 / 0 , 2 / 0 , 3 ...
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					System.out.println(Arrays.toString(arr));
				}
				
			}
		}
		System.out.println(Arrays.toString(arr));
		*/
		
		//최소값을 찾는다. 2.위치를찾는다. 3.기준자리와 위치를바꾼다. my
		/*int a = 0;
		int c = 0;
		int d = 0;
		int temp = 0;
		while(true) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[d] > arr[i]) {
				a = arr[i]; //최소값저장
				c = i; //자리저장
			System.out.println(a + " " + c);
			}
		}
		temp = arr[d]; // d = 0
		arr[d] = a; // d = 0
		System.out.println("xxx"+arr[d]);
		arr[c] = temp;
		d++;
		if(d==9) {
			break;
		}
		}
		System.out.println(Arrays.toString(arr));*/
		
		
		//선택정렬
		/*for(int i=0; i< arr.length; i++) {
		int min = i;
		for(int j = i+1; j < arr.length; j++) {
			if(arr[j] < arr[min]) {
				min = j;
			}
		}
		int temp = arr[i];
		arr[i] = arr[min];
		arr[min] = temp;
		}
		System.out.println(Arrays.toString(arr));
		*/
		
		//버블정렬 - 바로뒤에있는 숫자랑 비교 > 큰 수를 뒤로 보냄
		//1회 수행 후 큰수 맨뒤에 있으니 더이상 비교 x
		//1. 0(i),1 비교  1,2비교 2,3 비교 *둘다 늘어나야함
		//2. 끝까지 한번 가면, 마지막자리 비교 x
		//3. 
	/*	int k = arr.length; // i,j의 최대값
		for (int s = 0; s < arr.length; s++) {
			for (int i = 0; i < k - 1; i++) {
				int j = i + 1;
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			System.out.println(" "+Arrays.toString(arr));
			k--;// 여기까지 하면, 1회수행.. 할떄마다 J최대값 -1
		} // j의 마지막수를 줄인다 j-1
//정렬이 완료되면 더이상 안하게하려면, if문이 한번도 실행되지 않으면 멈추게 한다.
		System.out.println(Arrays.toString(arr));
*/
		
		
		
/*		int k = arr.length; // i,j의 최대값
		while(true) {
			int count = 0;
			for (int i = 0; i < k - 1; i++) {
				int j = i + 1;
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					count++;
				}//한번도 안됐을떄 해야하는데..
			}
			if(count==0) { //정렬이 완료되면 더이상 안하게하려면, if문이 한번도 실행되지 않으면 멈추게 한다.
				break;
			}
			k--;// 여기까지 하면, 1회수행.. 할떄마다 J최대값 -1
		} // j의 마지막수를 줄인다 j-1

		System.out.println(Arrays.toString(arr));
		*/
		
		/*for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				int count = 0;
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
				if(count == 0) {
					break;
				}
			}
		}
		System.out.println(Arrays.toString(arr));*/
		
		/*{2 5 8 6 1 4 8 2 3 5 4 9 8} 
		1. 2번째 자리에서 시작
		2. 맨앞부터 검색하다가..2번째가 더 작으면 위치바꿈
		3. 자리를 바꾸는게 아니라..중간에 넣는것.
		*/
		//[0, (1)] [0, 1, (2)] [0, 1 , 2, (3)]
		//0과 1비교  //0>2 0=2 or 1>2 1=2 //
		/*for(int i=1;i<arr.length;i++) {
			for(int j = 0; j > i; j++) {
				if(arr[i]<arr[j]){
				
				}
				*/
				for(int i=1; i <arr.length;i++){
				int count = 0;
				for(int j=i-1; j>=0;j--){
				 if(arr[i] < arr[j]){
				 count++;
				} 
			} 
				int temp = arr[i-count];
				arr[i-count] = arr[i];
				arr[i] = temp; 
				System.out.println(Arrays.toString(arr));
				
		}
		 System.out.println(Arrays.toString(arr));
		
		//앞에있는 배열은 그대로 냅두고.
		 //넣고싶은 자리의 데이터를 빼놓고?
		//넣고싶은 위치부터 다 한칸씩 뒤로 밀고.
		 // 넣고싶은 자리의 데이터를 넣고
		 // 예를들어.. {0,1,2,3,4}
		 //1자리에있는앨 2로 옮기고 2에있던앨 3에 옮기고 3에있던앨 4에옮기고 4에있던엘 5로 옮긴다
		 /*
		  * 1. 먼저 기준값이 들어갈 자리를 찾는다. (0번자리부터 비교해서 기준값이 더 작으면 OK)
		  * 2. 들어갈 자리에 있는 값부터 한칸씩 뒤로 밀어낸다. (기준값과 자리바꾸는게 아님)
		  * 3. 들어갈 자리에 기준값을 넣는다 > 반복
		  * i = 기준값자리  j = 비교할자리 (0,1,2,..기준값자리 전까지 증가)
		  * for(i = 1; i < arr.length; i++){
		  * 	for(j = 0; j < i; j++{
		  * 		if(arr[i]기준값 < arr[j]비교값){  //기준값보다 비교할 자리가 더 크면? 밀어내야지 밀어내는 방법은.
		  * 									 // 기준값자리 앞과 기준값자리를 바꾼다 치면  {5,3,1,7} 기준값을 temp에 넣고 기준값 -1 자리에 있는걸 기준값자리에 넣는다. 그다음은 -2자리 -3자리 하다가 비교자리를 만나면 거기에
		  *                                      // 저장해놓았던 (temp == 기준값)을 넣는다. 
		  * 			int temp = arr[i] //기준값 저장
		  * 			for(int l = i; l >= j; l--;){
		  * 			for(int k = 1; k >= j; k++){ //비교값자리를 만날떄까지
		  * 			arr[l] = arr[l-k] //기준값위치에  -1자리에있는 값을 넣고  -2, -3 감소하면서
		  * 
		  * }
		  * }
		  * }
		  * }
		  * }
		  * 
		  * for(i=
		  * temp = arr[1];
		  * arr[1] = arr[0];
		  * arr[0] = temp;
		  * 
		  * 
		*/
		
	}
		
}

