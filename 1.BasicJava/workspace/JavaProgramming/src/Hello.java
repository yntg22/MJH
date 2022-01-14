//클래스모음 = 패키지
public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char aString = 65;

		while(true)
		{

			// 특수문자 시작시 알파벳 소문자로 고정
			if (aString == 91)
				aString = 97;

			// 아스키 코드를 문자형으로 변환
			String str = String.valueOf(aString);

			System.out.println(str);

			// 아스키값 증가
			aString++;

			// 알파벳 소문자 z가 끝날시 종료 처리
			if (aString > 75) 
				break;
		}

		
	}

}
