package e_oop;

public class TV {
	// 키고끄고 채널올리고내리고 입력하고(파라미터) 음량 올리고 내리고
	boolean power = false;
	int channel = 1;
	int volume = 5;

	final int MIN_CHANNEL = 1;
	final int MAX_CHANNEL = 100; // final = 상수 = 상수는 대문자로 이름을 만든다
	final int MIN_VOLUME = 0;
	final int MAX_VOLUME = 10;

	void power() {
		power = !power;
		System.out.println("TV " + (power ? "ON" : "OFF"));
	}

	void changeChannel(int channel) {
		if (power) {
			if (MIN_CHANNEL <= channel && channel <= MAX_CHANNEL) {
				this.channel = channel;
			}
			System.out.println("채널. " + this.channel);
		}

	}

	void channelUp() {
		int ch = 0;
		if (channel == MAX_CHANNEL) {
			ch = MIN_CHANNEL;
		} else {
			ch = channel + 1;
		}
		changeChannel(ch);
	}

	void channleDown() {
		changeChannel(channel - 1);
	}

	void volumeUp() {
		if (power) {
			if (volume < MAX_VOLUME) {
				volume++;
			}
			showVolume();
		}
	}

	void volumeDown() {
		if (power) {
			if (MIN_VOLUME < volume) {
				volume--;
			}
			showVolume();
		}
	}

	void showVolume() {
		System.out.println("음량. ");
		for (int i = MIN_VOLUME + 1; i <= MAX_VOLUME; i++) {
			if (i <= volume) {
				System.out.print("●");
			} else {
				System.out.print("○");
			}
		}
		System.out.println();
	}


	public static void main(String[] args) {
		TV tv = new TV();
		
		while(true) {
			System.out.println("1.전원 2.채널변경 3.채널+ 4.채널-");
			System.out.print("5.볼륨+ 6.볼륨- 0.종료>");
			int input = ScanUtil.nextInt();
			switch(input) {
			case 1: tv.power(); break;
			case 2:
				System.out.print("변경할 채널(1~100)>");
				int ch = ScanUtil.nextInt();
				tv.changeChannel(ch);
				break;
			case 3: tv.channelUp(); break;
			case 4: tv.channleDown(); break;
			case 5: tv.volumeUp(); break;
			case 6: tv.volumeDown(); break;
			case 0:
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
			}
		}
		
	/*void channel(int channel) {
		if(power == false || channel > 100 || channel < 0) {
			System.out.println("작동안함");
		}else {
			this.channel = channel;
			System.out.println("채널 : " + channel);
		}
	}
	
	void channelUp() {
		if(power == true && channel < 100) {
		channel++;
		System.out.println("채널 : " + channel);
		}else {
			
			System.out.println("동작안함");
		}
	}
	
	void channelDown() {
		if(power == true && channel > 0) {
		channel--;
		System.out.println("채널 : " + channel);
		}else {
			System.out.println("동작안함");
		}
	}
	
	void soundUp() {
		if(power == true && volume < 100) {
		volume++;
		System.out.println("음량 : " + volume);
		}else {
		System.out.println("작동안함");
		}
	}
	
	void soundDown() {
		if(power == true && volume > 0) {
		volume--;
		System.out.println("음량 : " + volume);
		}else {
			System.out.println("작동안함");
			}
	}
	
	public static void main(String[] args) {
		TV remote = new TV();
		
		
		
		while(true) {
		System.out.print("버튼 ? ");
		int nextInt = ScanUtil.nextInt();

		switch(nextInt) {
		case 1: remote.switch1();
			break;
		case 2: remote.channalUp();
			break;
		case 3: remote.channalDown();
			break;
		case 4: remote.soundUp();
			break;
		case 5: remote.soundDown();
			break;
		case 6: System.out.println("옮길 채널 입력>");
			int channal = ScanUtil.nextInt();
			remote.channal(channal);
		}
		}

		
	}
*/
	}
	}
