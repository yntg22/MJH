package kr.or.ddit.basic;

import java.util.Arrays;

public class ThreadTest99 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Horse[] horses = new Horse[] {
				new Horse("01번말"),
				new Horse("02번말"),
				new Horse("03번말"),
				new Horse("04번말"),
				new Horse("05번말"),
				new Horse("06번말"),
				new Horse("07번말"),
				new Horse("08번말"),
				new Horse("09번말"),
				new Horse("10번말")
		};
		
		GameState st = new GameState(horses);
		
		for(Horse h : horses) {
			h.start();
		}
		st.start();
		
		//--
		for(Horse h : horses) {
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		try {
			st.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		//----
		System.out.println();
		System.out.println("경기 끝");
		
		// 등수의 오름차순으로 정렬하기
		Arrays.sort(horses); //내부정렬기준
		
		for(Horse h : horses) {
			System.out.println(h);
		}
		
		
	}

}

class Horse extends Thread implements Comparable<Horse>{
	public static int currentRank = 0;
	
	private String horseName; //말이름
	private int rank;	  //등수
	private int position;	  //위치
	
	public Horse(String horseName) {
		super();
		this.horseName = horseName;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "경주마 " + horseName + "은(는) "  + rank + "등 입니다.";
	}
	
	// 등수의 오름차순 정렬 기준 설정하기
	@Override
	public int compareTo(Horse horse) {
		return Integer.compare(this.rank, horse.getRank());
	}
	
	@Override
	public void run() {
		for(int i=1; i<=50; i++) {
			this.position = i;
			
			try {
				Thread.sleep((int)(Math.random()*500));
			} catch (InterruptedException e) {
				
			}
		}
		
		//한 마리의 말이 경주가 끝나면 등수를 구해서 설정한다.
		currentRank++;
		this.rank = currentRank;
	}

}

class GameState extends Thread{
	private Horse[] horses;

	//생성자
	public GameState(Horse[] horses) {
		super();
		this.horses = horses;
	}
	
	@Override
	public void run() {
		while(true) {
			//모든 말들의 경기가 종료되었는지 여부 검사한다.
			if(Horse.currentRank==horses.length) {
				break;
			}
			
			for(int i=1; i<=10; i++) {
				System.out.println();
			}
			
			for(int i=0;i<horses.length;i++) {
				System.out.print(horses[i].getHorseName() + " : ");
				for(int j = 1; j <=50; j++) {
					if(horses[i].getPosition() == j) {
						System.out.print(">");						
					}else {
						System.out.print("-");
					}
				}
				System.out.println(); //줄바꿈
				
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			
			}
			
		}
		
	}

	
}