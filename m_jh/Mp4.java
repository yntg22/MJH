package m_jh;

import java.util.Arrays;

public class Mp4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[][] st = new String[10][30];
		
		for(int i = 0; i < st[0].length; i++) {
			st[9][i]="■";
		}
			
		while(true) {
		st[8][3] = "□";
		st[7][3] = "□";
		st[7][4] = "□";
		st[6][3] = "□";
		st[5][3] = "□";
		st[5][4] = "□";
		for(int i = 0; i < st.length; i++) {
			for(int j = 0; j < st[i].length; j++) {
				if(st[i][j] == null) {
					System.out.print("　");
				}
				else{System.out.print(st[i][j]);
				
				}
				
			}
			System.out.println();
			
		}
		stop();
	}
		
		
		
		
	}
	private static void stop() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
