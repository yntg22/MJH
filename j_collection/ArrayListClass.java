package j_collection;

import java.util.ArrayList;


public class ArrayListClass {

	public static void main(String[] args) {
		/*
		 *  Collection Framework
		 *  - List  //배열상위호환  
		 *  - Map   //값을 키로 저장
		 *  - Set   //중복값 저장 X
		 * 
		 *  ArrayList의 주요 메서드       *ArrayList 장점 : 값을 읽어오는 속도가빠름  단점 : 값 저장속도가 느림
		 *  - boolean add(Object obj) : 마지막 위치에 객체를 추가 후 성공여부를 반환한다.
		 *  - void add(int index, Object obj) : 지정된 위치에 객체를 추가한다. (지정한위치에 값이 있으면 뒤로 한칸 밀림 나머지 뒤에 애들도 ...)
		 *  - Object set(int index, object obj) : 지정된 위치에 객체를 저장 후 기존 객체를 반환한다. (덮어쓰기)(기존값 리턴)
		 *  - Object get(int index) : 지정된 위치의 객체를 반환한다.
		 *  - int size() : 저장된 객체의 수를 반환한다.
		 *  - Object remove(int index) : 저장된 위치의 객체를 제거한다. (제거 후  뒤 값들이 앞으로 한칸씩 끌어옴)
		 */
		
		ArrayList sample = new ArrayList();
		
		sample.add("abc");
		sample.add(100);
		//장점 : 타입상관없음  | 단점 : 꺼낼때 무슨타입인지 모르기 때문에 | 타입통일해서 사용하기로 한다
		
		//타입지정해서 어레이리스트 만들기 |  제네릭? 이라고함 | 클래스만 저장할수 있다. 기본형 데이터는 불가
		ArrayList<Integer> list = new ArrayList<>();
		
		/*
		 * WrapperClass //기본형타입을 저장할수있게 해주는 클래스?
		 * 
		 * byte 	: Byte
		 * short	: Short
		 * int		: Integer
		 * long 	: Long
		 * float	: Float
		 * double	: Double
		 * boolean	: Boolean
		 * char		: Character
		*/
		
		list.add(10); //WrapperClass는 자동으로 형변환을 해준다?
//		list.add("abc"); //문자열은 저장이 불가능한것을 볼 수 있다.
		list.add(new Integer(20));
		System.out.println(list.add(30));
		System.out.println(list); //주소출력이 아니라 값이 출력된다.
		
		list.add(1, 40);
		System.out.println(list);
		
//		list.add(5, 50); //저장된 값의 범위를 벗어나면 안된다 바로뒤 +1부터 X
		
		
		//수정
		Integer before = list.set(2, 50);
		System.out.println("befroe : " + before);
		System.out.println(list);
		
		
		//읽기
		int get = list.get(2);
		System.out.println(get);
		
//		for(int i = 0; i < list.size(); i++) { //사이즈가 줄어들기 때문에 // 앞으로 땡겨져 오기 때문에 // for문을 거꾸로 돌리면 된다
//			System.out.println(i + " : " + list.remove(i));
//		}
//		System.out.println(list);
		
		for(int i = list.size() - 1; i >= 0; i--) {
			System.out.println(i + " : " + list.remove(i));
		}
		System.out.println(list);
		
		//list에 1~100사이의 랜덤값을 10개 저장해주세요.
		for(int i = 0; i < 10; i++) {
		list.add((int)(Math.random()*100)+1);
		}
		
		System.out.println(list);
		
		//list에 저장된 값의 합계와 평균을 구해주세요.
		Integer sum = 0;
		for(int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		Double avg = (Math.round((double)sum / list.size()*100)/100.0);
		System.out.println("합계 : " + sum + " / 평균 : " + avg);
		
		//list에서 최소값과 최대값을 구해주세요.
		Integer min = list.get(0);
		Integer max = list.get(0);
		for(int i = 0; i < list.size(); i++) {
			min = min > list.get(i) ? list.get(i) : min;
			max = max < list.get(i) ? list.get(i) : max;			
			
			/*if(min > list.get(i)) {
				min = list.get(i);
			}
			if(max < list.get(i)) {
				max = list.get(i);
			}*/
		}
		System.out.println("최소값 : " + min + " / 최대값 : " + max);
		
		//list를 오름차순으로 정렬해주세요
		for(int i = 0; i < list.size(); i++) {
			for(int j = 0; j < list.size(); j++) {
				if(list.get(i) < list.get(j)) {
					Integer temp = list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
		System.out.println(list);
		
		//선택정렬
		for(int i = 0; i < list.size(); i++) {
			min = i;
			for(int j = i + 1; j < list.size(); j++) {
				if(list.get(i) < list.get(min)) {
					min = j;
				}
			}
//			int temp = list.get(i);
//			list.set(i,list.get(min));
//			list.set(min,  temp);
		
			list.set(min, list.set(i, list.get(min)));
		}
		System.out.println(list);
		
	
		//2차원 arraylist 안에 arraylist안에 integer
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
		
		list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		
		list2.add(list);
		
		list = new ArrayList<>();
		list.add(40);
		list.add(50);
		
		list2.add(list);
		
		System.out.println(list2);
		
		for(int i = 0; i < list2.size(); i++) {
			ArrayList<Integer> temp = list2.get(i);
			for(int j = 0; j < temp.size(); j++) {
				System.out.println(temp.get(j));
			}
		}
		
		//2차원 인덱스 [0.1]번 
		System.out.println(list2.get(0).get(1));
		
		//학생 3명의 5과목에 대한 점수를 0~100사이의 점수로 발생시켜서 2차원 ArrayList에 저장해주세요.	
		ArrayList<ArrayList<Integer>> scores = new ArrayList<>();
		for(int i = 0; i < 3; i++) {
			ArrayList<Integer> score = new ArrayList<>();
			for(int j = 0; j < 5; j++) {
				score.add((int)(Math.random()*101));
			}
			scores.add(score);
			System.out.println(score);
		}

		//각 학생별 합계와 평균을 구해주세요.
		/*//나
		ArrayList<Integer> sum2 = new ArrayList<>();
		ArrayList<Double> avg2 = new ArrayList<>();
		
		for(int i = 0; i < scores.size(); i++) {
			int temp = 0;
			for(int j = 0; j < scores.get(i).size(); j++) {
				temp += scores.get(i).get(j);
			}
			sum2.add(temp);
			avg2.add((double)temp/scores.get(i).size());
		}
		System.out.println("합계 : " + sum2 + " 평균 : " + avg2);*/
		
		//선생님
		ArrayList<Integer> sums = new ArrayList<>();
		ArrayList<Double> avgs = new ArrayList<>();
		
		for(int i = 0; i < scores.size(); i++) {
			sum = 0;
			ArrayList<Integer> score = scores.get(i);
			for(int j = 0; j < score.size(); j++) {
				sum+= score.get(j);
			}
			sums.add(sum);
			avgs.add((double)sum / score.size());
		}
		System.out.println(sums);
		System.out.println(avgs);
		
		
		//등수구하기
//		ArrayList<Integer> rank = new ArrayList<>();
//		int count = 0;
//		if(sum2.get(i)<sum2.get(j)) {
//			count++;
//		}rank.add(count);
//		System.out.println(scores.get(0).get(0));
		
		//과목평균
		ArrayList<Integer> sum3 = new ArrayList<>();
		ArrayList<Double> avg3 = new ArrayList<>();
		for(int i = 0; i < scores.get(0).size(); i++) {
			int temp = 0;
			for(int j = 0; j < scores.size(); j++) {
				temp += scores.get(j).get(i);
			}
			sum3.add(temp);
			avg3.add((double)temp/scores.get(0).size());
		}
		System.out.println("과목 합계 : " + sum3 + " 과목 평균 : " + avg3);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
