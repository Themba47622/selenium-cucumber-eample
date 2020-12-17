package com.prac.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

    public static WebDriver open(String browserType, String driverPath) {
        if (browserType.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", driverPath);
            return new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", driverPath);
            return new ChromeDriver();
        }
    }
}
