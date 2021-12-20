package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
문제 ) 5명의 사람 이름을 입력받아 ArrayList에 저장한 후에 
	이들 중 '김'씨 성을 가진 사람을 모두 출력하시오.
	(입력은 Scanner객체를 이용한다.)
*/
public class ArrayListTest02 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<>();
		for(int i = 0; i < 5; i ++) {
		
		arr.add(s.nextLine());
		}
		
		
		for(int i = 0; i <arr.size();i++) {
			if(arr.get(i).charAt(0) == '김') {
				System.out.println(arr.get(i));
			}
			}
		
		
		
		if(arr.get(0).startsWith("김")) {
			System.out.println(arr.get(0));
		}
		/*
		for(int i = 0; i <arr.size();i++) {
		Character j = arr.get(i).charAt(0);
		if(j == '김') {
			System.out.println(arr.get(i));
		}
		}*/
		
		/*
		for(int w = 0; w < arr.size(); w++) {
		boolean asd = arr.get(w).substring(0, 1).equals("김");
		if(asd ==true) {
			System.out.println(arr.get(w));
		}
		}*/
		
		/*
		for(int w = 0; w < arr.size(); w++) {
		boolean asd = arr.get(w).substring(0, 1).contains("김");
		if(asd ==true) {
			System.out.println(arr.get(w));
		}
		}*/
		
		
		
		
		
		
		
		
		
	}

}
