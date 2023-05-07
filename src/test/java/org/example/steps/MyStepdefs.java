package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.constant.Endpoint;
import org.example.constant.MyConstants;
import org.example.context.TestContext;
import org.example.domainObject.BillingDetails;
import org.example.domainObject.Product;
import org.example.factory.DriverFactory;
import org.example.pages.CartPage;
import org.example.pages.CheckoutPage;
import org.example.pages.StorePage;
import org.example.utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyStepdefs {
    private final WebDriver driver ;
    private BillingDetails billingDetails;
    StorePage storePage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    public MyStepdefs(TestContext context) {
        driver = context.driver;
    }




}
