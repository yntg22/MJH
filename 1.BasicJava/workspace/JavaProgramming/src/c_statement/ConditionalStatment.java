package c_statement;

import java.util.Scanner;

public class ConditionalStatment {

	public static void main(String[] args) {
		/*
		 * 조건문 - if문 - switch문
		 * 
		 * if문 -if(조건식){} : 조건식의 결과가 true이면 블럭 안의 문장을 수행한다 - else if(조건식){} : 다수의 조건이
		 * 필요할때 if 뒤에 추가한다. - else{} : 조건식 이외의 경우를 위해 추가한다.
		 * 
		 */

		int a = 2;

		if (a == 1) {
			System.out.println("조건식의 연산결과가 true이면 수행된다.");
		}

		if (a == 1) {
			System.out.println("a == 1");
		} else if (a == 2) {
			System.out.println("a == 2");
		} else if (a == 3) {
			System.out.println("a == 3");
		} else {
			System.out.println("else");
		}

		if (a < 10) {
			System.out.println("a가 10보다 작다.");
		} else if (a < 20) {
			System.out.println("a가 20보다 작다.");
		}

		// 점수가 60점 이상이면 합격 그렇지 않으면 불합격
		int score = 70;

		if (60 <= score) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}

		// 점수에 등급을 부여
		score = 80;
		String grade = null; // null : 참조형 타입의 기본값
		// 기본값 : 내가 저장하지 않았을때 자동으로 저장되는 값
		// 기본형 타입은 기본값이 0
		// boolean : false 기본값

		if (90 <= score && score <= 100) {
			grade = "A";
		} else if (80 <= score) {
			grade = "B";
		} else if (70 <= score) {
			grade = "C";
		} else if (60 <= score) {
			grade = "D";
		} else if (0 <= score && 60 > score) {
			grade = "F";
		}
		System.out.println(score + " : " + grade);
		// 오류있음

		score = 90;
		grade = null;

		// Ctrl + Shift + F 자동정렬
		if (90 <= score && score <= 100) {
			grade = "A";
			if (97 <= score) {
				grade += "+";
			} else if (score <= 93) {
				grade += "-";
			}
		} else if (80 <= score) {
			grade = "B";
			if (87 <= score) {
				grade += "+";
			} else if (score <= 83) {
				grade += "-";
			}
		} else if (70 <= score) {
			grade = "C";
			if (77 <= score) {
				grade += "+";
			} else if (score <= 73) {
				grade += "-";
			}
		} else if (60 <= score) {
			grade = "D";
			if (67 <= score) {
				grade += "+";
			} else if (score <= 63) {
				grade += "-";
			}
		} else {
			grade = "F";
		}
		System.out.println(score + " : " + grade);

		/*
		 * switch문 - switch(int/String){case 1: break;} - 조건식의 결과는 정수와 문자열만(JDK1.7부터 문자열
		 * 허용) 허용한다. - 조건식과 일치하는 case문 이후의 문장을 수행한다.
		 */

		a = 10;

		switch (a) {
		case 10:
			System.out.println("a == 10");
			break;
		case 20:
			System.out.println("a == 20");
			break;
		default: // else
			System.out.println("default");
		}

		// 월에 해당하는 계절을 출력
		int month = 1;
		String season = null;

		switch (month) {
		case 3:
		case 4:
		case 5:
			season = "봄";
			break;
		case 6:
		case 7:
		case 8:
			season = "여름";
			break;
		case 9:
		case 10:
		case 11:
			season = "가을";
			break;
		case 12:
		case 1:
		case 2:
			season = "겨울";
			break;
		default:
			System.out.println("default");
		}
		System.out.println(season);

		switch (score / 10) {
		default:
			grade = "F";

		case 6:
			grade = "D";
			break;
		case 7:
			grade = "C";
			break;
		case 8:
			grade = "B";
			break;
		case 9:
		case 10:
			grade = "A";
			break;
		}
		System.out.println(score + " : " + grade);

		// 숫자를 입력받아 그 숫자가 0인지 0이 아닌지를 출력해주세요
//		Scanner s = new Scanner(System.in);
//		
//		System.out.print("숫자입력 : ");
//		int num = Integer.parseInt(s.nextLine());

//		if(num == 0) {
//			System.out.println("0 입니다");
//		}else {
//			System.out.println("0이 아닙니다");
//		}

//		switch(num) {
//		case 0:
//			System.out.println("0 입니다");
//			break;
//		default :
//			System.out.println("0이 아닙니다");	
//		}

		// 숫자를 입력받아 그 숫자가 홀수인지 짝수인지 출력해주세요.
//		if(num % 2 == 0) {
//			System.out.println("짝수입니다.");
//		}else {
//			System.out.println("홀수입니다.");
//		}
//		
//		switch(num % 2) {
//		case 0: 
//			System.out.println("짝수입니다.");
//			break;
//		case 1:
//			System.out.println("홀수입니다.");
//			break;
//		}

		// 점수 3개를 입력받아 합계, 평균 등급을 출력해주세요
//		Scanner s = new Scanner(System.in);
//		System.out.print("점수 입력 : ");
//		int num1 = Integer.parseInt(s.nextLine());
//		System.out.print("점수 입력 : ");
//		int num2 = Integer.parseInt(s.nextLine());
//		System.out.print("점수 입력 : ");
//		int num3 = Integer.parseInt(s.nextLine());
//		
//		int hap = num1 + num2 + num3;
//		double p1 = Math.round(hap / 3.0 * 10) / 10.0;
//		String grade1 = null;
//		
//		if(100 >= p1 && 90 <= p1) {
//			grade1 = "A";
//		}else if(80 <= p1) {
//			grade1 = "B";
//		}else if(70 <= p1) {
//			grade1 = "C";
//		}else if(60 <= p1) {
//			grade1 = "D";
//		}else {
//			grade1 = "F";
//		}
//		System.out.println("합계: " + hap + " 평균: " + p1 + " 등급: " + grade1);
//		
		// 1~100 사이의 랜덤한 수를 3개 발생시키고 오름차순으로 출력해주세요.

		int random1 = (int) (Math.random() * 10) + 1;
		int random2 = (int) (Math.random() * 10) + 1;
		int random3 = (int) (Math.random() * 10) + 1;
		int as = 0;

		System.out.print(random1 + " ");
		System.out.print(random2 + " ");
		System.out.println(random3);

		if (random1 > random2) {
			as = random1;
			random1 = random2;
			random2 = as;}
		if (random1 > random3) {
				as = random1;
				random1 = random3;
				random3 = as;}
		if(random2 > random3) {
					as = random2;
					random2 = random3;
					random3 = as;
				}
		
		System.out.print(random1 + " " + random2 + " " + random3);

		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
