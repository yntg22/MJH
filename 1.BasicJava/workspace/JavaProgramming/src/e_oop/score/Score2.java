package e_oop.score;

import java.util.Scanner;

public class Score2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		Student[] students = new Student[2];
		
		for(int i = 0; i < students.length; i++) {
		students[i] = new Student();
		System.out.print("이름 입력 > ");		
		students[i].name = scanner.nextLine();
		System.out.print("국어 점수 > ");
		students[i].kor = Integer.parseInt(scanner.nextLine());
		System.out.print("영어 점수 > ");
		students[i].eng = Integer.parseInt(scanner.nextLine());
		System.out.print("수학 점수 > ");
		students[i].math = Integer.parseInt(scanner.nextLine());
		System.out.println();
		students[i].sum = students[i].kor + students[i].eng + students[i].math;
		students[i].avg = Math.round(students[i].sum / 3 * 100) / 100.0;
		}
		

		
		
		
		System.out.println("이름\t국어\t영어\t수학\t합계\t평균");
		for(int i = 0; i < students.length; i++) {
		System.out.print(students[i].name + "\t" + students[i].kor + "\t" + students[i].eng + "\t" + students[i].math + "\t" +
						 students[i].sum + "\t" + students[i].avg+ "\n");
		}
		
		
		
		
		
	}
	

}
