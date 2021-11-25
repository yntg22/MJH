package e_oop.score2;

import java.util.Arrays;


public class Score {

	public static void main(String[] args) {
		String[] studentNames = { "강정윤", "고성식", "김민경", "김민호", "김은혜",
				   "김재웅", "노현정", "민진홍", "박상진", "박상현",
				   "박세준", "손효선", "양동현", "양승혁", "양아연",
				   "이유정", "이응주", "이정수", "정석철", "정지수",
				   "조화랑", "주창규", "한영민", "황선부", "이기석" };
		Student[] students = new Student[studentNames.length];
		
		for(int i = 0; i < students.length; i++) {
			students[i] = new Student();
			students[i].name = studentNames[i];
			students[i].randomScore();
			students[i].getSum();
			students[i].getAvg();
		}
		
		//석차구하기
		for(int i = 0; i < students.length; i++) {
			students[i].getRank(students);
		}
		
		//석차순 정렬
		for(int i = 0; i < students.length; i++) {
			int max = i;
			for(int j = i + 1; j < students.length; j++) {
				if(students[j].getSum() > students[max].getSum()) {
					max = j;
				}
			}
			Student temp = students[i];
			students[i] = students[max];
			students[max] = temp;
		}
		
		//과목별 합계
		int[] subSum = new int[3];
		for(int i = 0; i < students.length; i++){
			subSum[0] += students[i].kor;
			subSum[1] += students[i].eng;
			subSum[2] += students[i].math;
		}
		
		//과목별 평균
		double[] subAvg = new double[3];
		for(int i = 0; i < subAvg.length; i++) {
			subAvg[i] = Math.round((double)subSum[i] / students.length * 100) / 100.0;
		}
		
		//출력
		System.out.println("이름\t국어\t영어\t수학\t합계\t평균\t석차");
		for(int i = 0; i < students.length; i++) {
			System.out.println(students[i].getInfo());
		}
		System.out.print("과목합계");
		for(int i = 0; i < subSum.length; i++) {
			System.out.print("\t" + subSum[i]);
		}
		System.out.print("\n과목평균");
		for(int i = 0; i < subAvg.length; i++) {
			System.out.print("\t" + subAvg[i]);
		}
		//
		/*String[] studentNames = {"민진홍", "노현정", "박상진", "이정수"};
		
		Student[] students = new Student[studentNames.length];
		
		for(int i = 0; i < students.length; i++) {
			students[i] = new Student();
			students[i].name = studentNames[i];
			
		}
		
		//등수
	
		Student sc = new Student();
		sc.rank(students);
		
		
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
		
		}*/
		
		
		
	
		
		}

	}


