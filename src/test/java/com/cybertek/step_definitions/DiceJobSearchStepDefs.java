package com.cybertek.step_definitions;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class DiceJobSearchStepDefs {

    @Given("User is on dice homepage")
    public void user_is_on_dice_homepage() {
        System.out.println("user is on dice homePage....");
        Driver.getDriver().get(ConfigurationReader.getProperty("dice.url"));
    }




    @When("User enters keyword and zipcode")
    public void user_enters_keyword_and_zipcode() throws InterruptedException {
        System.out.println("user enters java and 22102...");
        WebElement keyWord = Driver.getDriver().findElement(By.id("typeaheadInput"));
        keyWord.sendKeys("java");
         Thread.sleep(3000);
        WebElement zipcode = Driver.getDriver().findElement(By.id("google-location-search"));
        zipcode.sendKeys(("22102")+ Keys.ENTER);


    }


    @Then("User should see search results")
    public void user_should_see_search_results() {
        System.out.println("user should see search results....");
        WebElement jobcount = Driver.getDriver().findElement(By.id("totalJobCount"));
        System.out.println("job count get text"+jobcount.getText());
      // Driver.closeDriver();
    }

}
