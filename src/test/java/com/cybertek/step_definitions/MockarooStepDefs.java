package com.cybertek.step_definitions;

import com.cybertek.pages.MockarooPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.ExcelUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MockarooStepDefs {

    MockarooPage mockarooPage = new MockarooPage();



    @Given("User is on mockaroo homepage")
    public void user_is_on_mockaroo_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("mockaroo.url"));


    }

    @Given("Number of rows is {int}")
    public void number_of_rows_is(int rowsCount) {

        mockarooPage.numOfRowsField.sendKeys(Keys.DELETE);
        mockarooPage.numOfRowsField.sendKeys(rowsCount+"");

    }

    @Given("Format is Excel")
    public void format_is_excel() {
      //  mockarooPage.formatField.click(); have method for these in the page
      //  mockarooPage.excelField.click();
        mockarooPage.selectExcelFormal();

    }

    @When("User clicks on preview")
    public void user_clicks_on_preview() {
        mockarooPage.clickPreview.click();

    }

    @Then("following columns should be displayed:")
    public void following_columns_should_be_displayed(List<String> expectedColumns) {

        System.out.println("Expected Columns= "+ expectedColumns);
       // List<WebElement> => getText() => List<String> actualColumns =. compare with expectedColumns
        List<String> actualColumns = new ArrayList<>();
        // read text of each tableHeader and store into actualColumns list
        for(WebElement headerName: mockarooPage.tableHeaders){
            actualColumns.add(headerName.getText());

        }
        BrowserUtils.sleep(2);
        Assert.assertEquals(expectedColumns,actualColumns);


      //  List<String> actualColumnsHeader = BrowserUtils.getElementsText(mockarooPage.tableHeaders);
       // from browser utils
       // Assert.assertEquals(expectedColumns ,actualColumnsHeader);

    }

    @Then("{int} rows of data should be displayed")
    public void rows_of_data_should_be_displayed(int expectedRowsCount) {
        Assert.assertEquals(expectedRowsCount,mockarooPage.tableRows.size());

      BrowserUtils.sleep(2);

    }


    @When("User clicks on download")
    public void userClicksOnDownload() {
     mockarooPage.downloadBtn.click();

    }
    int excelFileRowsCount;


    @Then("following columns should be displayed in excel file:")
    public void followingColumnsShouldBeDisplayedInExcelFile(List <String> expectedColumns) throws IOException {
        String filePath = System.getProperty("user.home") + "/Downloads/MOCK_DATA.xlsx";

        ExcelUtil excel = new ExcelUtil(filePath,"data");
        Assert.assertEquals(expectedColumns,excel.getColumnsNames());
        FileInputStream in = new FileInputStream(filePath);

      //  XSSFWorkbook workbook = new XSSFWorkbook(in);
      //  XSSFSheet worksheet = workbook.getSheetAt(0);

     //   int excelHeaderCount = worksheet.getRow(0).getPhysicalNumberOfCells();
     //      excelFileRowsCount = worksheet.getLastRowNum();
      //  List<String>actualColumns = new ArrayList<>();

    //    for(int i = 0; i<excelHeaderCount; i++){

      //      actualColumns.add(worksheet.getRow(0).getCell(i).toString());
    //    }

     //   Assert.assertEquals(expectedColumns,actualColumns);


    }

    String filePath = System.getProperty("user,home")+"/Downloads/MOCK_DATA.xlsx";
    @And("{int} rows of data should be displayed in excel file")
    public void rowsOfDataShouldBeDisplayedInExcelFile(int numberOfRows) {
       String filePath = System.getProperty("user,home")+"/Downloads/MOCK_DATA.xlsx";
        ExcelUtil excel = new ExcelUtil(filePath,"data");
       int excelFilesRowCount = excel.rowCount();

        Assert.assertEquals(numberOfRows , excelFileRowsCount);


    }

    @And("data should be present in excel file")
    public void dataShouldBePresentInExcelFile() {
        //open excel file,read the data and print values
        ExcelUtil excel = new ExcelUtil(filePath,"data");
        System.out.println("Excel file data"+excel.getDataList() );

    }
}
