package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddSpartanPage extends  BasePage {

    @FindBy(id = "name")
    public WebElement name;

    @FindBy(name= "gender")
    public WebElement genderElem;

    //option[@value='Male']

    @FindBy(xpath = "//input[@id='phone']")
    public WebElement phone;
    // id = "phone"

    @FindBy(id = "submit_btn")
    public WebElement submitBtn;

    public void selectGender(String gender) {

        Select  select = new Select(genderElem);
        select.selectByVisibleText(gender);
      //  new Select(genderElem).selectByVisibleText(gender);



        //  Select  select1 =   new Select(Driver.getDriver().findElement(By.id("genderSelect")));

        // select.selectByVisibleText(gender);
    }

}




