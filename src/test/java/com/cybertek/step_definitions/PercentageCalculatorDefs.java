package com.cybertek.step_definitions;

import com.cybertek.pages.PercentageCalculatorPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.Map;

public class PercentageCalculatorDefs {

    @Given("User is on percentage calculator page")
    public void user_is_on_percentage_calculator_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("percentage.url"));
    }
    @Then("User should see following calculations:")
    public void user_should_see_following_calculations(Map<Integer, Integer> valuesMap) {
        System.out.println("valuesMap = " + valuesMap);
        PercentageCalculatorPage calculatorPage = new PercentageCalculatorPage();
        calculatorPage.percent.sendKeys("5");

        //loop through keys in the map:
        for (Integer inputKey : valuesMap.keySet()) {
            calculatorPage.input.clear();
            calculatorPage.input.sendKeys(inputKey + "" + Keys.ENTER);
            BrowserUtils.sleep(2);

            System.out.println("input value= "+ inputKey);
            System.out.println("expected %5 value = "+valuesMap.get(inputKey));
            System.out.println("actual %5 value  "+calculatorPage.result.getAttribute("value"));
            System.out.println("====================");
            Assert.assertEquals(valuesMap.get(inputKey), Integer.valueOf(calculatorPage.result.getAttribute("value")));
         //   Assert.assertEquals(valuesMap.get(inputKey),""+ Integer.valueOf(calculatorPage.result.getAttribute("value")));

        }
    }









}
