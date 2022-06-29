package com.dave.step_definitions;

import com.dave.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before(value = "@login", order = 0)
    public void setupScenario_ForLogins() {
        System.out.println("=========== This will apply to scenarios with @login tag=============");
    }

    @Before("@db")
    public void setupDataBaseScenarios() {
        System.out.println("__________ This will apply to scenarios wit @db tag__________");
    }

    @After
    public void tearDownScenario(Scenario scenario) {

        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();
    }

//    @BeforeStep
//    public void setupStep() {
//        System.out.println("-------------------> take a screenshot-----@BeforeStep");
//    }
//
//    @AfterStep
//    public void afterStep() {
//        System.out.println("-------------------> take a screenshot------@AfterStep");
//    }
}
