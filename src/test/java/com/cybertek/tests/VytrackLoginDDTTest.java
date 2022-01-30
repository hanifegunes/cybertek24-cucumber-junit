package com.cybertek.tests;

import com.cybertek.pages.VyTrackDashboardPage;
import com.cybertek.pages.VyTrackLoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class VytrackLoginDDTTest {


    @Before
    public  void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));

    }

    @After
    public  void  tearDown(){



    }

    VyTrackLoginPage loginPage = new VyTrackLoginPage();
    VyTrackDashboardPage dashboardPage = new VyTrackDashboardPage();

    @Test
    public  void  LoginDDTTest() throws IOException {

        //open excel workbook
        String filePath="VyTrackQa2Users.xlsx";
        FileInputStream in = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(in);

        XSSFSheet workSheet = workbook.getSheetAt(0);


        /*
        String userName = "user1";
        String password = "UserUser123";
        String firstName = "John";
        String lastName = "Doe";



         */
        for(int i = 1; i<=workSheet.getLastRowNum(); i++) {


            String userName = workSheet.getRow(i).getCell(0).toString();
            String password = workSheet.getRow(i).getCell(1).toString();
            String firstName = workSheet.getRow(i).getCell(2).toString();
            String lastName = workSheet.getRow(i).getCell(3).toString();


            loginPage.login(userName, password);


            String fullName = dashboardPage.fullName.getText();
            System.out.println("Full name: " + fullName);

            String actualFullName = dashboardPage.fullName.getText();

            XSSFCell resultCell = workSheet.getRow(i).getCell(4);

            if (actualFullName.contains(firstName) && actualFullName.contains(lastName)) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
                resultCell.setCellValue("Fail");
            }

            //  Assert.assertTrue(actualFullName.contains(firstName) && actualFullName.contains(lastName));


            //open excel file
            //add page object
            //loop and read credentials
            //write the results in excel
            dashboardPage.logout();



        }

        FileOutputStream out = new FileOutputStream(filePath);
        workbook.write(out);

        in.close();
        out.close();
        workbook.close();

      //  dashboardPage.fullName.click();
     // dashboardPage.logOutLink.click();
//
    }


}
