package com.prac.pages;

import com.prac.utilities.GenericMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    WebDriver driver;

    @FindBy(css = ".app_logo")
    public WebElement logo;

    @FindBy(css = ".product_label")
    public WebElement labelProducts;

    public void verifyHomepage(){
        GenericMethods.waitForElementToAppear(driver,logo);
        labelProducts.isDisplayed();
    }

    public ProductsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
