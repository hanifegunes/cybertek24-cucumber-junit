package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.IOException;

public class ExcelRead {

    @Test
    public  void  readingFomExcel() throws IOException {

        //Open excel workbook

        XSSFWorkbook workbook = new XSSFWorkbook("Employees.xlsx");
         //Goto work sheet. pass the worksheet name
        XSSFSheet workSheet = workbook.getSheet("data");

        System.out.println(workSheet.getRow(1).getCell(0));

        //print Romanenko
        System.out.println(workSheet.getRow(3).getCell(1));


    }



}
