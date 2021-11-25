package j_collection;

import java.util.ArrayList;

public class Score {

	public static void main(String[] args) {
		/*
		 * 우리반 모두의 국어, 영어, 수학, 사회, 과학, Oracle, Java 점수를
		 * 0 ~ 100까지 랜덤으로 생성해주시고, 아래와 같이 출력해주세요.
		 * 
		 * 이름		국어		영어		수학		사회		과학		Oracle	Java	합계		평균		석차
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1
		 * 과목합계	450		450		450		450		450		450		450
		 * 과목평균	90.00	90.00	90.00	90.00	90.00	90.00	90.00
		 */

		ArrayList<String> human = new ArrayList<>();
		human.add("강정윤");
		human.add("고성식");
		human.add("김민경");
		human.add("김민호");
		human.add("김은혜");
		human.add("김재웅");
		human.add("노현정");
		human.add("민진홍");
		human.add("박상진");
		human.add("박상현");
		human.add("박세준");
		human.add("손효선");
		human.add("양동현");
		human.add("양승혁");
		human.add("양아연");
		human.add("이유정");
		human.add("이응주");
		human.add("이정수");
		human.add("정석철");
		human.add("정지수");
		human.add("조화랑");
		human.add("주창규");
		human.add("한영민");
		human.add("황선부");
		human.add("이기석");

		ArrayList<String> mainname = new ArrayList<>();
		mainname.add("이름");
		mainname.add("국어");
		mainname.add("영어");
		mainname.add("수학");
		mainname.add("사회");
		mainname.add("과학");
		mainname.add("Oracle");
		mainname.add("Java");
		mainname.add("합계");
		mainname.add("평균");
		mainname.add("석차");
	
		//랜덤점수부여
		ArrayList<ArrayList<Integer>> scores = new ArrayList<>();
		for(int i = 0; i < 25; i++) {
			ArrayList<Integer> score = new ArrayList<>();
			for(int j = 0; j < 7; j++) {
				score.add((int)(Math.random()*101));
			}
			scores.add(score);
			System.out.println(score);
		}
		
		//합계
		ArrayList<Integer> sums = new ArrayList<>();
		ArrayList<Double> avgs = new ArrayList<>();
		int sum;
		for(int i = 0; i < scores.size(); i++) {
			sum = 0;
			ArrayList<Integer> score = scores.get(i);
			for(int j = 0; j < score.size(); j++) {
				sum+= score.get(j);
			}
			sums.add(sum);
			avgs.add((Math.round((double)sum / score.size()*100)/100.0));
		}
		System.out.println(sums);
		System.out.println(avgs);
		
		//과목평균
		ArrayList<Integer> sum3 = new ArrayList<>();
		ArrayList<Double> avg3 = new ArrayList<>();
		for(int i = 0; i < scores.get(0).size(); i++) {
			int temp = 0;
			for(int j = 0; j < scores.size(); j++) {
				temp += scores.get(j).get(i);
			}
			sum3.add(temp);
			avg3.add((Math.round((double)temp/scores.get(0).size()*100)/100.0));
		}
		System.out.println("과목 합계 : " + sum3);
		System.out.println(" 과목 평균 : " + avg3);
		
		//석차 구하기
		ArrayList<Integer> rank = new ArrayList<>();
		
		for(int i = 0; i < sums.size(); i++) {
			int count = 1;
			for(int j = 0; j < sums.size(); j++){
				if(sums.get(i) < sums.get(j)) {
					count++;
				}
			}
			rank.add(count);
		}
		System.out.println("석차 : "+rank);
	
		
		//첫번째 줄 출력
		for(int i = 0; i < mainname.size(); i++) {
		System.out.print(mainname.get(i)+"\t");
		}
		System.out.println();
		//두번째 줄 출력
		for(int i = 0; i <human.size(); i++) {
		System.out.print(human.get(i));
		for(int j = 0; j < scores.get(i).size(); j++) {
		System.out.print("\t" + scores.get(i).get(j)); //j = 1234567
		}
		System.out.print("\t" + sum);
		System.out.println();
		}
		
		
		
	}

}
