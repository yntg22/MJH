package m_jh;

import java.util.Arrays;
import java.util.Scanner;

public class Mp3 {

	public static void main(String[] args) {

		/*
		 * 5-1
		 * 
		 * 
		*/
		//5-3
		/*int[] arr = {10,20,30,40,50};
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("sum="+sum);
		*/
		
		//5-4
		/*int[][] arr= {
				{ 5, 5, 5, 5, 5},
				{10,10,10,10,10},
				{20,20,20,20,20},
				{30,30,30,30,30}
		};
		int total = 0;
		float average = 0;
		for(int i = 0 ; i < arr.length; i++) {
			for(int j = 0 ; j < arr[i].length; j++) {
				total += arr[i][j];
			}
		}
		average = (float)total / (arr.length*arr[0].length);
		
		System.out.println("total = " + total);
		System.out.println("average = " + average);*/
		
		//5-5
		/*int [] ballArr = {1,2,3,4,5,6,7,8,9};
		int [] ball3 = new int[3];
		
		for(int i = 0; i < ballArr.length; i++) {
			int j = (int)(Math.random() * ballArr.length);
					int temp = 0;
					temp = ballArr[i];
					ballArr[i] = ballArr[j];
					ballArr[j] = temp;
		}
		
		for(int i = 0; i < ball3.length; i++) {
			ball3[i] = ballArr[i];
		}
		
		for(int i = 0; i<ball3.length; i++){
			System.out.print(ball3[i]);
		}*/
		
		//5-6
		/*int[] coinUnit = {500, 100, 50, 10};
		
		int money = 2680;
		System.out.println("money=" + money);
		
		for(int i = 0; i < coinUnit.length;i++) {
			int temp = money / coinUnit[i];
			money %= coinUnit[i];
			System.out.println(coinUnit[i] + "원 : " + temp + "개");
		}*/
		
		//5-7
		
		/*if(args.length!=1) {
			System.out.println("USAGE : java Exercise5_7 3120");
			System.exit(0);
		}
		
		int money = Integer.parseInt(args[0]);
		
		System.out.println("money=" + money);
		
		int[] coinUnit = {500, 100, 50, 10};
		int[] coin = {5, 5, 5, 5};
		
		for(int i = 0; i < coinUnit.length; i++) {
			int coinNum = 0;
			coinNum = money / coinUnit[i];
			if (coinNum > 5) {
				coin[i] -= 5;
				coinNum = 5;
			}
			else {coin[i] -= coinNum;}
			
			System.out.println(coinUnit[i]+"원"+coinNum);
			
		}
		
		System.out.println("=남은 동전의 개수=");
		for(int i = 0; i < coin.length; i++) {
			System.out.println(coinUnit[i] +"원 : " + coin[i]);
		}*/
		
		//5-8
		/*int[] answer = { 1,4,4,3,1,4,4,2,1,3,2 };
		int[] counter = new int[4];
		
		for(int i = 0; i < answer.length; i ++) {
			for(int j = 0; j < counter.length; j++) {
			if(answer[i] == j+1) {
				counter[j] ++;
			}
			counter[answer[i]-1]++;
			//}
		}
		
		for(int i = 0; i < counter.length;i++) {
			System.out.print(counter[i]);
			for(int j = 0; j < counter[i]; j++) {
				System.out.print("*");
				
			}
		System.out.println();
		}*/
		
		
		//5-9
		/*char[][] star = {
				{'*','*',' ',' ',' '},
				{'*','*',' ',' ',' '},
				{'*','*','*','*','*'},
				{'*','*','*','*','*'}
		};
		
		char[][] result = new char[star[0].length][star.length];
		
		for(int i = 0; i < star.length; i++) {
			for(int j = 0; j < star[i].length; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
		int temp = 3;
		for(int i = 0; i < star.length; i++) {
	
			for(int j  = 0; j < star[i].length; j++) {
				
				result[j][temp] = star[i][j];
				0.3  0.2  0.1  
				1.3  1.2  1.1
				2.3  2.2  2.1
				3.3  3.2  3.1
				4.3  4.2  4.1
			}
			temp --;
		}
		
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}*/
		
		
		//5-10 ASCII 코드알아야함
		/*char[] abcCode =
			{ '`','~','!','@','#','$','%','^','&','*',
			  '(',')','-','_','+','=','|','[',']','{',
			  '}',';',':',',','.','/'};

			  char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
			  
			  String src = "abc123";
			  String result = "";
			  
			  for(int i = 0; i < src.length(); i++) {
				  char ch = src.charAt(i);
				  System.out.println(ch);
				  
			  }
			  result += abcCode['a'-'a'];
		System.out.println(result);
*/		
		
		//5-11
		/*int[][] score = {
				{100, 100, 100}
			,	{20, 20, 20}
			,   {30, 30, 30}
			,	{40, 40, 40}
			,	{50, 50, 50}
		};
		
		int[][] result = new int[score.length+1][score[0].length+1];
		
		for(int i = 0; i < score.length; i++) {
			for(int j = 0; j < score[i].length; j++) {
				result[i][j] = score[i][j];
				result[i][score[0].length] += result[i][j];
				result[score.length][j] += result[i][j];
				result[score.length][score[0].length] += result[i][j];
			}
		
			
		// 0 1 2 3 
			00  01  02
			10  11  12
			20  21  22
			30  31  32
			40  41  42
		
		}
		
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[i].length;j++) {
				System.out.printf("%4d",result[i][j]);
			}
			System.out.println();
		}*/
		
		//5-13
		/*String[] words = {"television", "computer", "mouse", "phone" };
		
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0; i < words.length; i++) {
			char[] question = words[i].toCharArray();
			int random = (int)(Math.random()*question.length);
			
			char temp =question[i];
			question[i]=question[random];
			question[random] = temp;
			
			System.out.printf("Q%d. %s의 정답을 입력하세요. >", i +1, new String(question));
			String answer = scanner.nextLine();
			
			if(words[i].equals(answer.trim()))
				System.out.printf("맞았습니다.%n%n");
			else
				System.out.printf("틀렸습니다.%n%n");
		}*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
	}

