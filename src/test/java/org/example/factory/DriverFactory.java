package org.example.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public static WebDriver initializeDriver(String browser) {
        WebDriver driver;
        switch (browser){
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari" :
                driver = new SafariDriver();
                break;
            default:
                throw  new IllegalStateException("INVALID BROWSER: " + browser);
        }

        driver.manage().window().maximize();
        return driver;
    }

}
