package g_oop2;

public class Time {
	
	private int hour;
	private int minute;
	private int second;
	// source + generate toString
	@Override
	public String toString() {
		return hour + ":" + minute + ":" + second;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		if(hour < 0) {
			this.hour = 0;
		}else if(23 < hour) {
//			this.hour = 23;
			this.hour = hour % 24;
		}else {
			this.hour = hour;
		}
		/*this.hour = hour;
		if(hour >= 24) {
			this.hour = 0;
		}*/
	}
		
	
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		if(minute < 0) {
			this.minute = 0;
		}else if(59 < minute) {
//			this.minute = 59;
			this.minute = second % 60;
			setHour(this.hour + minute / 60);
		}else {
			this.minute = minute;
		}
	}
		/*this.minute = minute;
		if(minute >= 60) {
			setHour(hour+1);
			this.minute = 0;
		}
	}*/
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		if(second < 0) {
			this.second = 0;
		}else if(59 < second) {
//			this.second = 59;
			this.second = second % 60;
			setMinute(this.minute + second / 60);
		}else {
			this.second = second;
		}
		/*this.second = second;
		if(second >= 60) {
			setMinute(minute+1);
			this.second = 0;
		}*/
	}
	
	void clock() {
		while(true) {
			System.out.println(toString());
			stop();
			setSecond(second + 1);
		}
	}
	
	private void stop() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
