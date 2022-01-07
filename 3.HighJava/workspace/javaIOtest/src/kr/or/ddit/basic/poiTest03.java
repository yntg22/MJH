package poiTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class poiTest03 {
   public static String filePath = "D:/";
   public static String fileNm = "야식.xlsx";

   
   // 1. 워크북 생성
   public static XSSFWorkbook xlsWb = new XSSFWorkbook(); // xlsx
//     HSSFxlsWb xlsWb = new HSSFxlsWb(); //xls

   // 2. 시트생성
   public static Sheet sheet = xlsWb.createSheet("야식"); // 시트명 설정
   
   public static void main(String[] args) {

      String[] foods = { "족발", "콘옥수수", "햄버거", "닭발", "치킨" };
      Integer[] price = {50000,3000,5000,15000,20000};

      // 3. 시트 열, 너비 설정
         sheet.setColumnWidth(0,(20 * 256)); // 5글자 입력가능한 크기 
        
      /* setColumnWidth(Column Index, width size)의 순서입니다.
       * n * 256의 형태로 한 이유는 1글자가 256의
       * 크기를 갖기 때문에 13글자가 들어갈 만큼의 공간을 갖기 위해서 13 * 256 과 같은 형태를 사용했습니다.*/
       
      
      // 4. 스타일 지정 =======================================
      // 스타일 객체생성
      CellStyle style = xlsWb.createCellStyle();
      Font font = xlsWb.createFont();

      // 셀 색
      style.setFillForegroundColor(IndexedColors.BLUE.getIndex()); // 색깔선택
      style.setFillPattern(FillPatternType.SOLID_FOREGROUND);// 어떻게 색칠하는지 !

      // 글자색
      font.setColor(IndexedColors.WHITE.getIndex());
      font.setFontHeightInPoints((short) 14);
      font.setBold(true);
      
      // 위에 설정한 폰트 스타일에 적용
      style.setFont(font);

      //=============================================================
      
      // 5. row(행) cell(셀) 생성 및 값 입력
      
      // 타이틀 생성 및 스타일 적용
      Row row  =sheet.createRow(0);
      
      Cell cell1 = row.createCell(0);
      cell1.setCellValue("메뉴");
      cell1.setCellStyle(style);
      
      Cell cell2 = row.createCell(1);
      cell2.setCellValue("가격");
      cell2.setCellStyle(style);
      
      
      // 내용 입력
      Cell menuCell;
      Cell priceCell;
      
      for (int i = 0; i < foods.length; i++) {
         row = sheet.createRow(i+1);
         menuCell = row.createCell(0);
         menuCell.setCellValue(foods[i]);
         priceCell = row.createCell(1);
         priceCell.setCellValue(price[i]);
      }
      
      // excel 파일 저장
      try {
         String path = "D:/"; // 경로
         String fileName = "야식.xlsx"; // 파일명
         File xlsFile = new File(path + fileName); // 저장경로 설정
         FileOutputStream fileOut = new FileOutputStream(xlsFile);
         xlsWb.write(fileOut);
         System.out.println("파일저장완료");
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
}