package d_array;

public class F_ScoreTest {

	public static void main(String[] args) {
		//1
		String[] names = {"홍길동", "김길동", "이길동", "박길동", "강길동", "권길동"};
		
		//2
		String[] subjects = {"국어", "영어", "수학", "사회", "과학", "Oracle", "Java"};
		
		//3
		int[][] score = new int[names.length][subjects.length];
		
		//4
		for(int i = 0; i < score.length; i++){
			for(int j = 0; j < score[i].length; j++){
				score[i][j] = (int)(Math.random() * 101);
			}
		}
		
		
		//5
		int[] nameSum = new int[score.length];
		
		//6
		for(int i = 0; i < score.length; i++){
			for(int j = 0; j < score[i].length; j++){
				nameSum[i] += score[i][j];
			}
		}
		
		//7
		float[] nameAvg = new float[score.length];
		
		//8
		for(int i = 0; i < score.length; i++){
			nameAvg[i] = Math.round((float)nameSum[i] / subjects.length * 100) / 100f;
		}
		
		//9
		int[] subSum = new int[subjects.length];
		
		//10
		for(int i = 0; i < subjects.length; i++){
			for(int j = 0; j < score.length; j++){
				subSum[i] += score[j][i];
			}
		}
		
		//11
		float[] subAvg = new float[subjects.length];
		
		//12
		for(int i = 0; i < subjects.length; i++){
			subAvg[i] = Math.round((float)subSum[i] / score.length * 100) / 100f;
		}
		
		//13
		int[] rank = new int[score.length];
		
		//14
		for(int i = 0; i < score.length; i++){
			rank[i] = 1;
			for(int j = 0; j < score.length; j++){
				if(nameSum[i] < nameSum[j]){
					rank[i]++;
				}
			}
		}
		
		//15
		System.out.print("이름");
		for(int i = 0; i < subjects.length; i++){
			System.out.print("\t" + subjects[i]);
		}
		System.out.println("\t합계\t평균\t석차");
		for(int i = 0; i < score.length; i++){
			System.out.print(names[i] + "\t");
			for(int j = 0; j < score[i].length; j++){
				System.out.print(score[i][j] + "\t");
			}
			System.out.println(nameSum[i] + "\t" + nameAvg[i] + "\t" + rank[i]);
		}
		
		System.out.print("과목합계\t");
		for(int i = 0; i < subSum.length; i++){
			System.out.print(subSum[i] + "\t");
		}
		System.out.println();
		
		System.out.print("과목평균\t");
		for(int i = 0; i < subAvg.length; i++){
			System.out.print(subAvg[i] + "\t");
		}
	}

}
