package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.PageObjectFactory.PageObjectManager;
import org.example.context.TestContext;
import org.example.pages.CheckoutPage;
import org.testng.Assert;

public class CheckoutStepDefinitions {

    private CheckoutPage checkoutPage;
    private TestContext context;

    public CheckoutStepDefinitions(TestContext context) {
        this.context = context;
        checkoutPage = PageObjectManager.getCheckoutPage(context.driver);

    }

    @When("I provide billing details")
    public void iProvideBillingDetails() {
        checkoutPage.setBillingDetails(context.billingDetails);

    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        checkoutPage.selectPlaceOrderBtn();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() throws InterruptedException {
        Assert.assertEquals("Thank you. Your order has been received.", checkoutPage.getNoticeTxt());

    }
}
