package com.prac.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class LoginPage {
    WebDriver driver;
    private By usernameField = By.cssSelector("input#user-name");
    private By passwordField = By.cssSelector("[name='password']");
    private By loginButton = By.cssSelector("input#login-button");
    private By loginErrorMessage = By.cssSelector("h3");

    public void enterUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

    public void verifyLoginError(){
        driver.findElement(loginErrorMessage).isDisplayed();
        String errorText = driver.findElement(loginErrorMessage).getText();
        assertThat(errorText, containsString("Epic sadface: Username and password"));
    }

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
}
