package e_oop;

public class AirCon {
	
	//온도,풍량,난방냉방	
	boolean power = false;
	boolean ab = false;
	int ondo = 20;
	int dan = 1;
	
	final int MIN_ONDO = 18;
	final int MAX_ONDO = 30;
	
	void power() {
		power = !power;
		if(power) {
		print();
		}
		else {
			System.out.println("전원 :OFF");
		}
	}
	
	void print() {
		System.out.print("| 전원:" + (power?"ON |":"OFF |") + " 냉/난방 :"+(ab?"냉방 |":"난방 |")+" 온도:"+ondo);
		System.out.print(" | 세기 :");
		for(int i = 0; i < dan; i++) {
			System.out.print("▶");
		}
		System.out.println(" |");
	}
	
	void ondoUp() {
		if(power) {
			if(ondo < MAX_ONDO) {
			ondo++;
			}
			print();
		}
	}
	
	void ondoDown() {
		if(power) {
			if(ondo > MIN_ONDO) {
				ondo--;
			}
			print();
		}
	}
	
	
	void danUp() {
		if(power) {
			if(dan < 3) {
				dan++;
			}
			print();
		}
	}
	
	void danDown() {
		if(power) {
			if(dan > 1){
				dan--;
			}
			print();
		}
	}
	
	void ab() {
		if(power) {
		ab = !ab;
		print();
		}
	}
	
	public static void main(String[] args) {
		AirCon aircon = new AirCon();
		

		while(true) {
			System.out.println(" 1:전원  2:난/냉방   3:온도+  4:온도-");
			System.out.println(" 5:세기+ 6:세기- 0:종료");
			int a = ScanUtil.nextInt();
			switch(a) {
			case 1: aircon.power(); break;
			case 2: aircon.ab(); break;
			case 3: aircon.ondoUp(); break;
			case 4: aircon.ondoDown(); break;
			case 5: aircon.danUp(); break;
			case 6: aircon.danDown(); break;
			case 0: 
				System.out.println("프로그램 종료");
				System.exit(0);
			}
			
		}
	}

}


	