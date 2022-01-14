package e_oop.score;

public class Score {

	public static void main(String[] args) {
		/*
		 * 
		 */
		String[] studentNames = {"민진홍", "노현정", "박상진", "이정수"};
		Student[] students = new Student[studentNames.length];
		
		for(int i = 0; i < students.length; i++) {
			students[i] = new Student();
			
			students[i].name =studentNames[i];
			students[i].kor = (int)(Math.random()*101);
			students[i].eng = (int)(Math.random()*101);
			students[i].math = (int)(Math.random()*101);
			students[i].sum = students[i].kor + students[i].eng + students[i].math;
			students[i].avg = Math.round((double)students[i].sum / 3 * 100) / 100.0;
			students[i].rank = 1;
		}
		
		//등수
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students.length; j++) {
				if (students[i].sum < students[j].sum) {
					students[i].rank++;
				}

			}
		}
		
		//등수 오름차순
		for(int i = 0; i < students.length; i++) {
			for(int j = 0; j < students.length; j++) {
		if(students[i].rank < students[j].rank) {
		Student temp = students[i];
		students[i] = students[j];
		students[j] = temp;
				}
			}
		}
		
		
		
		//합계평균선언
		int[] sum2 = new int[3];
		double[] avg2 = new double[3];
		//과목합계
		for(int i = 0; i < 4; i++) {
				sum2[0] += students[i].kor;
				sum2[1] += students[i].eng;
				sum2[2] += students[i].math;
		}
		
		//과목평균
		for(int i = 0; i < sum2.length; i++) {
		avg2[i] = Math.round((double)sum2[i] / 4 *100)/100.0;
		}
		
		
		//출력
		System.out.println("이름\t국어\t영어\t수학\t합계\t평균\t등수");
		for(int i = 0; i < students.length; i++) {
		System.out.print(students[i].name + "\t" + students[i].kor + "\t" + students[i].eng + "\t" + students[i].math +
						 "\t" + students[i].sum + "\t" + students[i].avg + "\t" + students[i].rank +"\n");
		}
		
		System.out.print("과목합계");
		for(int i = 0; i < sum2.length; i++) {
		System.out.print("\t"+sum2[i]);
		}
		
		System.out.print("\n과목평균");
		for(int i = 0; i < avg2.length; i++) {
			System.out.print("\t"+avg2[i]);
		}
		
		}
		

}
