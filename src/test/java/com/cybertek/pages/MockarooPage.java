package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class MockarooPage extends BasePage{
  //  BrowserUtils browserUtils = new BrowserUtils();

    @FindBy(name = "num_rows")
    public WebElement numOfRowsField;

    @FindBy(id="mui-component-select-file_format")
    public  WebElement formatField;

    @FindBy(xpath = "//li[.='Excel']")
    public  WebElement excelField;

    @FindBy(xpath = "(//*[.='Preview']/../span)[1]")
    public WebElement clickPreview;

    @FindBy(xpath = "//table//th")
    public List<WebElement> tableHeaders;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> tableRows;


    @FindBy(xpath = "//span[.='Download Data']")
    public WebElement downloadBtn;



    public void selectExcelFormal() {
        formatField.click();
       excelField.click();
        BrowserUtils.scrollDown(500);
        formatField.click();
        BrowserUtils.sleep(1);
        excelField.click();

    }



}
