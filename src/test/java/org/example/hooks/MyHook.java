package org.example.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.context.TestContext;
import org.example.factory.DriverFactory;
import org.openqa.selenium.WebDriver;

public class MyHook {
    private WebDriver driver;
    private final TestContext context;

    public MyHook(TestContext context) {
        this.context=context;
    }

    @Before
    public void before(Scenario scenario){
        driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));
        //driver = DriverFactory.initializeDriver(System.getProperty("browser", "firefox"));
        context.driver = driver;
        System.out.println(context.driver);


    }

    @After
    public void after(){
        driver.quit();
    }
}
