package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class RandomStudentsTeacher {

	public static void main(String[] args) {
		String[] students = {"노현정", "정지수", "양동현", "조화랑", "박상진"};
		
		Scanner s = new Scanner(System.in);
		System.out.print("몇명 뽑을까요?");
		int count = Integer.parseInt(s.nextLine());

		String[] pick = new String[count];
		int pickCount = 0;
		do {
			int random = (int)(Math.random() * students.length);
			
			boolean flag = true;
			for(int i = 0; i < pick.length; i++) {
				if(students[random].equals(pick[i])){
					flag = false;
				}
			}
			
			if(flag) {
				pick[pickCount++] = students[random];
			}
		}while(pickCount < count);
		
		System.out.println(Arrays.toString(pick));
	}

}
