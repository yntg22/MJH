package poiTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class poiTestRead {

   public static void main(String[] args) {
      // excel 파일 읽기
      try {
         FileInputStream file = new FileInputStream(new File("D:/야식.xlsx"));

         // 엑셀 파일로 Workbook instance를 생성한다.
         XSSFWorkbook workbook = new XSSFWorkbook(file);

         /*
          * - 시트로 찾기 1. 시트명으로 찾기 workbook.getSheet("찾는 시트의 이름");
          * 
          * 2. 모든 시트 순회 방법1) for(Integer sheetNum : workbook.getNumberOfSheets()) {
          * XSSFSheet sheet = workbook.getSheetAt(i); } 방법2)
          */
         Iterator<Sheet> sheetIterator = workbook.iterator();
         while (sheetIterator.hasNext()) {
            Sheet sheet1 = sheetIterator.next();
            System.out.println("["+sheet1.getSheetName()+"]================");
            // workbook의 첫번째 sheet를 가저온다.
//            XSSFSheet sheet1 = workbook.getSheetAt(0);

            // 모든 행(row)들을 조회한다.
            Iterator<Row> rowIterator = sheet1.iterator();
            while (rowIterator.hasNext()) {
               Row row1 = rowIterator.next();

               // 각각의 행에 존재하는 모든 열(cell)을 순회한다.
               Iterator<Cell> cellIterator = row1.cellIterator();
               while (cellIterator.hasNext()) {
                  Cell cell = cellIterator.next();

                  // cell의 타입을 하고, 값을 가져온다.
                  switch (cell.getCellType()) {
                  case NUMERIC:
                     // getNumericCellValue 메서드는 기본으로 double형 반환
                     System.out.print((int) cell.getNumericCellValue() + "\t");
                     break;

                  case STRING:
                     System.out.print(cell.getStringCellValue() + "\t");
                     break;

                  case FORMULA:
                     System.out.println(cell.getCellFormula() + "\t");
                     break;

                  case BLANK:
                     System.out.println(cell.getBooleanCellValue() + "\t");

                     break;

                  case ERROR:
                     System.out.println(cell.getErrorCellValue() + "\t");
                     break;
                  }
               }
               System.out.println();
            }
            
         }
         file.close();

      } catch (IOException e) {
         e.printStackTrace();
      }

   }
}