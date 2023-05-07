package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.example.PageObjectFactory.PageObjectManager;
import org.example.constant.MyConstants;
import org.example.context.TestContext;
import org.example.domainObject.BillingDetails;
import org.example.pages.StorePage;
import org.openqa.selenium.WebDriver;

public class CustomerStepDefinition {
    private TestContext context;
    private StorePage storePage;

    public CustomerStepDefinition(TestContext context) {
        this.context = context;
        storePage= PageObjectManager.getStorePage(context.driver);
    }

    @And("my billing details are:")
    public void myBillingDetailsAre(BillingDetails billingDetails) {

        context.billingDetails = billingDetails;
    }
    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {
        storePage.load(MyConstants.STORE);
    }
}
