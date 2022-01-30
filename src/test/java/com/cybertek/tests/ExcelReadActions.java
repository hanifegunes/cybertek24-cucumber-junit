package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.IOException;

public class ExcelReadActions {
    String filePath="Employees.xlsx";

@Test
    public  void  readExcelSheetData() throws IOException {
    //open the Employees.xlsx using apache poi

    XSSFWorkbook workbook = new XSSFWorkbook(filePath);
//go to data sheet , or go to first sheet by index
    XSSFSheet datasheet = workbook.getSheetAt(0);
    System.out.println("Column Names");
    System.out.println(datasheet.getRow(0).getCell(0));

    for (int i = 0; i <3 ; i++) {
        System.out.println(datasheet.getRow(0).getCell(i));

    }
   // find out number f rows in the work sheet

    int rowsCount = datasheet.getPhysicalNumberOfRows();
    System.out.println("rowCount = "+ rowsCount);

    int usedRowCount = datasheet.getLastRowNum();
    System.out.println("used row count = "+ usedRowCount);
    //print all first names using a for loop
    System.out.println("All first names");
    for (int i  = 0;  i<= usedRowCount ; i++) {

        System.out.println(datasheet.getRow(i).getCell(0));

    }
    System.out.println("Fahima Info");
    for (int i = 1; i <=datasheet.getLastRowNum() ; i++) {
        if(datasheet.getRow(i).getCell(0).toString().equals("Fahima"))
        System.out.println(datasheet.getRow(i).getCell(0)+ " | "+
        datasheet.getRow(i).getCell(1)+" | "+
        datasheet.getRow(i).getCell(2));
        break;

    }



}




}
