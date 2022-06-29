package com.dave.pages;

import com.dave.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[text()='Careers'])[3]")
    public WebElement careersLink;

    @FindBy(xpath = "//h4[normalize-space(.)='Sr. QA Engineer, Automation']")
    public WebElement seniorQA_EngineerLink;

    @FindBy(xpath = "(//a[normalize-space(.)='Read more'])[21]")
    public WebElement readMoreLink;
}
