package exerciseJava;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;


import java.io.*;
import java.util.Iterator;

public class ExcellReadingByApachePoi {

    public  static void main(String[]args) throws Exception {

        File file=new File("C:\\Excel1\\Testing.xlsx");
        FileInputStream fis=new FileInputStream(file);//it will read the date from the file as bytes
        //create workbook
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        //create sheet
        XSSFSheet sheet=workbook.getSheetAt(0);

       // String cellValue=sheet.getRow(0).getCell(0).getStringCellValue();//This two lines for static column and row
       // System.out.println(cellValue);

        //for dynamic row and column
        int rowCount=sheet.getPhysicalNumberOfRows();
        for(int i=0;i<rowCount;i++){
            XSSFRow row=sheet.getRow(i);

            int cellCount=row.getPhysicalNumberOfCells();
            for(int j=0;j<cellCount;j++){
                XSSFCell cell=row.getCell(j);
                System.out.print("||" +getCellValue(cell));
            }
         System.out.println();
        }




        //release memory
        workbook.close();
        fis.close();

    }
    public static String getCellValue(XSSFCell cell){
       switch (cell.getCellType()){
           case NUMERIC:
               return String.valueOf(cell.getNumericCellValue());//if it is numeric it need to convert
           case BOOLEAN:
               return String.valueOf(cell.getBooleanCellValue());//boolean also need to convert

           case STRING:
               return cell.getStringCellValue();//String do not need to convert
           default:
               return cell.getStringCellValue();
       }
    }



}