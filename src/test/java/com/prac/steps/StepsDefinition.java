package com.prac.steps;

import com.prac.pages.LoginPage;
import com.prac.pages.ProductsPage;
import com.prac.utilities.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class StepsDefinition {
    WebDriver driver;
    LoginPage login;
    ProductsPage products;

    private static final String DRIVER_PATH = "chromedriver";

    @Given("^I am on the login page$")
    public void user_is_on_login_page() {
        ClassLoader classLoader = getClass().getClassLoader();
        String driverPath = classLoader.getResource(DRIVER_PATH).getPath();
        driver = DriverFactory.open("chrome", driverPath);
        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(1400, 1000));
        driver.get("https://www.saucedemo.com/");
    }

    @When("^I type \"(.*)\" in the email field$")
    public void user_enters_username(String userName) {
        login = new LoginPage(driver);
        login.enterUsername(userName);
    }

    @And("^I type \"(.*)\" in the password field$")
    public void user_enters_password(String password) {
        login.enterPassword(password);
    }

    @And("I click on the Login button")
    public void user_clicks_login() {
        login.clickLogin();
    }

    @Then("^I see the SWAG logo on the home page$")
    public void confirm_landing_page() {
        products = new ProductsPage(driver);
        products.verifyHomepage();
    }

    @Then("^I see an error message$")
    public void login_error(){
        login.verifyLoginError();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
