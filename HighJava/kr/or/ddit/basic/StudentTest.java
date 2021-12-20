package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 문제) 학번(int), 이름(String), 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.
 *       이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서 초기화 처리를 한다.
 * 
 *       이  Student 객체는 List에 저장하여 관리한다.
 * 
 *       List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고, 
 *       총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부 정렬 기준 클래스를 작성하여 
 *       각각의 방식으로 정렬한 결과를 출력하시오.
 * 
 *       (단, 등수는 List에 전체 데이터가 추가된 후에 저장되도록 한다.)
 */

public class StudentTest {

   public static void main(String[] args) {
      ArrayList<Student> studentList = new ArrayList<>();
      
      studentList.add(new Student(1, "고성식", 58, 66, 95));
      studentList.add(new Student(4, "민진홍", 85, 45, 13));
      studentList.add(new Student(6, "바보탱", 22, 45, 15));
      studentList.add(new Student(3, "멍충탱", 86, 54, 79));
      studentList.add(new Student(5, "자우림", 86, 80, 70));
      studentList.add(new Student(2, "이유정", 100, 86, 97));
      
      System.out.println("<정렬>");
      System.out.println("학번\t이름\t국어\t영어\t수학\t총점");
      for(Student s : studentList) {
         System.out.println(s);
      }
      System.out.println("-----------------");

      
      Collections.sort(studentList);      
      System.out.println("<학번 오름차순 정렬>");
      System.out.println("학번\t이름\t국어\t영어\t수학\t총점");
      for(Student s : studentList) {
         System.out.println(s);
      }
      System.out.println("------------------");
      
      
      Collections.sort(studentList, new score());   
      System.out.println("<총점 내림차순 정렬 후 이름 오름차순 정렬>");
      System.out.println("학번\t이름\t국어\t영어\t수학\t총점");
      for(Student s : studentList) {
         System.out.println(s);
      }
      System.out.println("------------------");
   }

}


class Student implements Comparable<Student>{
   
   private int num;
   private String name;
   private int kor;
   private int eng;
   private int math;
   private int sum;
   

   public Student(int num, String name, int kor, int eng, int math) {
      super();
      this.num = num;
      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.math = math;
      
      this.sum = kor + eng + math;
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


   public int getMath() {
      return math;
   }
   public void setMath(int math) {
      this.math = math;
   }
   
   
   public int getSum() {
      return sum;
   }
   public void setSum(int sum) {
      this.sum = sum;
   }
   


   @Override
   public String toString() {
      return num + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + sum;
   }

   @Override
   public int compareTo(Student s) {
      //학번 오름차순
      return Integer.compare(this.num, s.getNum());
   }
   
}

class score implements Comparator<Student>{

   @Override
   public int compare(Student s1, Student s2) {
      //총점 내림차순 후 이름 오름차순
      if(s1.getSum() == s2.getSum()) {
         return s1.getName().compareTo(s2.getName());
      }
      
         return Integer.compare(s1.getSum(), s2.getSum()) * -1;
   
   }
}
