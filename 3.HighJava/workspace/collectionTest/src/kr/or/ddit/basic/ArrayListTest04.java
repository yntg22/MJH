package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*문제2) 5명의 별명을 입력받아 ArrayList에 저장하고, 이들 중
별명의 길이가 제일 긴 별명들을 출력하시오
(단, 별명의 길이는 같을 수 있다.
*/
public class ArrayListTest04 {

	public static void main(String[] args) {
		
		ArrayList<String> arr = new ArrayList<>();
		Scanner s = new Scanner(System.in);
		for(int i = 0; i < 5; i++) {
			arr.add(s.nextLine());
		}
		
	
		int result = 0;
		int count = 0;
		for(int i = 0; i < arr.size(); i++) {
			if(result < arr.get(i).length()) {
				result = arr.get(i).length();
				count = i;
			}
		}
		
	
		for(int i = 0; i < arr.size();i++) {
			if(arr.get(count).length() == arr.get(i).length()) {
				System.out.println(arr.get(i));
			}
		}
	}

}
