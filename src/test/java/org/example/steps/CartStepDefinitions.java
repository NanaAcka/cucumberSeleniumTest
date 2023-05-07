package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.PageObjectFactory.PageObjectManager;
import org.example.context.TestContext;
import org.example.domainObject.Product;
import org.example.pages.CartPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartStepDefinitions {
    private CartPage cartPage;
    public CartStepDefinitions(TestContext context) {
        cartPage = PageObjectManager.getCartPage(context.driver);
    }
    @And("I'm on the Checkout page")
    public void iMOnTheCheckoutPage() {
        cartPage.checkout();
    }

    @Then("I should see {int} {product} in the cart")
    public void iShouldSeeInTheCart(int quantity, Product product) {
        Assert.assertEquals(product.getName(), cartPage.getProductName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());
    }

}
