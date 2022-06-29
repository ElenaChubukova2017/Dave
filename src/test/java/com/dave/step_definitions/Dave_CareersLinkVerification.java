package com.dave.step_definitions;

import com.dave.pages.HomePage;
import com.dave.utilities.ConfigurationReader;
import com.dave.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Dave_CareersLinkVerification {

    HomePage homePage = new HomePage();

    @Given("user is on Dave homepage")
    public void user_is_on_dave_homepage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("daveURL"));
        String expectedURL = "https://dave.com/";
        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals("FAIL - HomePage URL does not contain Dave", expectedURL, actualURL);

    }

    @When("user navigates to Careers page by clicking on the Careers link")
    public void user_navigates_to_careers_page_by_clicking_on_the_careers_link() {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        for (int i = 0; i < 7; i++) {
            js.executeScript("window.scrollBy(0,750)");
        }
        System.out.println("Navigation to Careers link in the footer is done");
        homePage.careersLink.click();
    }

    @When("user should see Senior QA Engineer job opening")
    public void user_should_see_senior_qa_engineer_job_opening() {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", homePage.seniorQA_EngineerLink);
        System.out.println("Navigation to Senior QA Engineer is done");

        String expectedJobOpeningPosition = "Sr. QA Engineer, Automation";
        String actualJobOpeningPosition = homePage.seniorQA_EngineerLink.getText();
        System.out.println("actualJobOpeningPosition = " + actualJobOpeningPosition);
        Assert.assertEquals("FAIL - Carrers Tab does not contain 'Sr. QA Engineer'", expectedJobOpeningPosition, actualJobOpeningPosition);
    }

    @Then("user should see Read More link exists")
    public void user_should_see_read_more_link_exists() {

        String expectedText = "Read more";
        String actualText = homePage.readMoreLink.getText();
        System.out.println("actualText = " + actualText);
        Assert.assertEquals("FAIL - 'Read more' link under Sr. QA Engineer does not exists", expectedText, actualText);
    }

}
