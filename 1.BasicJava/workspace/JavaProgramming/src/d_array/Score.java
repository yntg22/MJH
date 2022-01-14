package d_array;

import java.util.Arrays;

public class Score {

	public static void main(String[] args) {
		/*
		 * 우리반 모두의 국어, 영어, 수학, 사회, 과학, Oracle, Java 점수를
		 * 0 ~ 100까지 랜덤으로 생성해주시고, 아래와 같이 출력해주세요
		 * 
		 * 이름             국어             영어               수학            사회            과학           Oracle    Java   합계    평균       석차
		 * 박상진        90        90       90      90      90       90        90   630 90.00   1
		 * 이정수      90        90       90      90      90       90        90   630 90.00   1
		 * 노현정        90        90       90      90      90       90        90   630 90.00   1
		 * 정지수        90        90       90      90      90       90        90   630 90.00   1
		 * 양동현        90        90       90      90      90       90        90   630 90.00   1
		 * 과목합계    450       450     450     450     450     450         450 
		 * 과목평균    90.00		90.00	90.00	90.00	90.00	90.00	   90.00
		 *  
		 * */
		
		// [이름]  [국어][영어][수학][사회][과학]
		//  0 0    01  02  03   04   05
		// [박상진]
		//  10    11   12    13   14  15 
		
		int[][] arr1 = new int[25][7];
		String[] human = { "강정윤", "고성식", "김민경", "김민호", "김은혜",
				   "김재웅", "노현정", "민진홍", "박상진", "박상현",
				   "박세준", "손효선", "양동현", "양승혁", "양아연",
				   "이유정", "이응주", "이정수", "정석철", "정지수",
				   "조화랑", "주창규", "한영민", "황선부", "이기석", };
		String[] arr2 = {"이름","국어", "영어", "수학", "사회", "과학", "Oracle", "Java", "합계", "평균", "석차"};
		
		//랜덤값 넣기
		for(int i = 0; i < arr1.length; i++) { 
			for(int j = 0; j < arr1[i].length; j++) {
				arr1[i][j] = (int)(Math.random()*101);
			}
		}
		
		
		//개인별 합계 평균 구하기
		int[] sum = new int[25];
		double[] avg = new double[25];
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr1[i].length; j++) {
				sum[i] += arr1[i][j];
			}
			avg[i] = Math.round((sum[i] / (double)7)*100) /100.0 ;
			
		}
			
		
		//석차구하기
		int[] level = new int[25];
		for(int i = 0; i <sum.length; i++) {
			level[i]++;
			for(int j = 0; j <sum.length; j++) {
				if(sum[i]<sum[j])
				level[i]++;
			}
		}	
				
		
		//출력
				for(int i = 0; i < arr2.length; i++) {
					System.out.print(arr2[i]+"\t");
				}
				System.out.println();
				for(int i = 0; i < arr1.length; i++) {
					System.out.print(human[i]+"\t"); //사람이름
					for(int j = 0; j < arr1[i].length; j++) {
						System.out.print(arr1[i][j]+"\t"); //점수
					}
					System.out.print(sum[i]+"\t"+avg[i]+"\t"+level[i]);
					System.out.println();
				}
		//과목합계, 과목평균
		String[] hap = {"과목합계" , "과목평균"};
		int[] sum2 = new int[7];
		double[] avg2 = new double[7];
		for(int i=0; i<arr1[i].length;i++) {
			for(int j = 0; j < arr1.length;j++) {
				sum2[i] += arr1[j][i];
			}
			avg2[i] = Math.round((sum2[i] / (double)25)*100) /100.0 ;
		}
		
		System.out.print(hap[0]);
		for(int j = 0; j < sum2.length; j++) {
		System.out.print("\t"+sum2[j]);
		}
		System.out.println();
		
		System.out.print(hap[1]);
		for(int i = 0; i < avg2.length; i++) {
			System.out.print("\t"+avg2[i]);
		}
				
		
		
	}

}
