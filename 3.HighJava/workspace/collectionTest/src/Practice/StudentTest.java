package Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentTest {
	// 등수를 구하는 메서드
	public void setRanking(List<Student> stdList) {
		for(Student std : stdList) { //기준 데이터를 구하는 반복문
			int rank = 1; // 기준 데이터의 등수는 처음에 1등으로 선택해 놓고 시작한다.
			for(Student std2 : stdList) { //비교할 대상을 나타내는 반복문
				
				// 기준보다 큰 값을 만나면 rank값을 증가시킨다.
				if(std.getTot() < std2.getTot()) {
					rank ++;
				}
			}
			std.setRank(rank); //구해진 등수를 Student 객체의 rank 변수에 저장한다.
		}
	}
	
	public static void main(String[] args) {
		
	
	List<Student> stdList = new ArrayList<Student>();
	
	stdList.add(new Student(1, "홍길동", 90, 95, 80));
	stdList.add(new Student(3, "성춘향", 93, 82, 60));
	stdList.add(new Student(7, "강감찬", 86, 45, 20));
	stdList.add(new Student(5, "변학도", 95, 55, 30));
	stdList.add(new Student(2, "일지매", 76, 45, 60));
	stdList.add(new Student(4, "이순신", 14, 34, 70));
	stdList.add(new Student(6, "이몽룡", 26, 35, 90));
	
	StudentTest test = new StudentTest();
	test.setRanking(stdList); // 등수 구하기
	
	
	
	System.out.println("정렬전...");
	for(Student std : stdList) {
		System.out.println(std);
	}
	System.out.println("--------------------------------------");
	
	Collections.sort(stdList);
	
	System.out.println("정렬후...");
	for(Student std : stdList) {
		System.out.println(std);
	}
	System.out.println("--------------------------------------");
	
	Collections.sort(stdList, new SortByTotal());
	
	System.out.println("이름순 정렬후...");
	for(Student std : stdList) {
		System.out.println(std);
	}
	System.out.println("--------------------------------------");
	
	}
}

class SortByTotal implements Comparator<Student>{
	//총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부 정렬기준
	@Override
	public int compare(Student std1, Student std2) {
		if(std1.getTot() == std2.getTot()) {
			return std1.getName().compareTo(std2.getName());
		}else {
			return Integer.compare(std1.getTot(), std2.getTot()) * -1;
		}
	}
	
}



class Student implements Comparable<Student>{
	private int num;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private int rank;
	
	//생성자
	public Student(int num, String name, int kor, int eng, int mat) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = kor + eng + mat;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "student [num=" + num + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", tot="
				+ tot + ", rank=" + rank + "]";
	}
//클래스에 있는 값이 뭐고 매개변수 값이 뭐냐??
	//학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현
	@Override
	public int compareTo(Student std) {
		return Integer.compare(this.getNum(), std.getNum());
	}
	
	
	
	
	
}