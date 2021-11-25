package e_oop;

import java.util.Arrays;

public class UserDefinedDataType {

	public static void main(String[] args) {
		/*
		 * 사용자 정의 데이터 타입
		 * - 데이터의 최종 진화 형태이다.(기본형 -> 배열 -> 클래스)
		 * - 서로 다른 타입의 데이터를 묶어서 사용하는 것이다.
		 * - 변수와 메서드로 구성할 수 있다.
		 * */
		
		//변수
		int kor;
		int eng;
		int math;
		int sum;
		double avg;
		
		//배열
		int[][] scores;
		int[] sum2;
		double[] avg2;
		
		//클래스
		//int[] arr =new int[3];
		Student student = new Student(); //객체 생성(인스턴스화) Student타입에 student라는 이름으로
		
		student.kor = 80;
		student.eng = 90;
		student.math = 75;
		student.sum = student.kor + student.eng + student.math;
		student.avg = Math.round(student.sum / 3.0 *100)/100.0;
		
		System.out.println("합계 : " + student.sum + " / 평균  : " + student.avg);
		
		
		Student[] students = new Student[5];
		students[0] = new Student();
		students[1] = new Student();
		students[2] = new Student();
		students[3] = new Student();
		students[4] = new Student();
		
		students[0].kor = 90;
		
	}

}


class Student{
	int kor;
	int eng;
	int math;
	int sum;
	double avg;

	

}


