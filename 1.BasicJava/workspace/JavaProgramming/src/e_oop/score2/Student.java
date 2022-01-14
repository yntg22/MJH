package e_oop.score2;

import java.util.Arrays;

public class Student {
	/*String name;
	int kor = (int) (Math.random() * 101);
	int eng = (int) (Math.random() * 101);
	int math = (int) (Math.random() * 101);
	int sum = kor + eng + math;
	double avg = Math.round((double) sum / 3 * 100) / 100.0;
	int rank = 1;*/
	String name;
	int kor;
	int eng;
	int math;
	int sum;
	double avg;
	int rank;

//자신의 합계나 평균은 메서드에 있어야함
//학생 해야할것
//등수
	/*void rank(Student[] b) {
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b.length; j ++) {
				if(b[i].sum <b[j].sum) {
					b[i].rank ++;
				}
			}
		}
	}*/

	//점수를 랜덤으로 발생시키는 메서드
	void randomScore() {
		kor = (int)(Math.random()*101);
		eng = (int)(Math.random()*101);
		math = (int)(Math.random()*101);
	}
	
	//합계를 구하는 메서드
	int getSum() {
		sum = kor + eng + math;
		return sum;
	}
	
	//평균을 구하는 메서드
	double getAvg() {
		return avg = Math.round(getSum() / 3.0 * 100) / 100.0;
	}
	
	//석차를 구하는 메서드
	int getRank(Student[] students) {
		rank = 1;
		for(int i = 0; i < students.length; i++) {
			if(getSum() < students[i].getSum()) {
				rank++;
			}
		}
		return rank;
	}
	
	//정보를 제공하는 메서드
	String getInfo() {
		return name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + sum + "\t" + avg + "\t" + rank;
	}
	


	
	
}
