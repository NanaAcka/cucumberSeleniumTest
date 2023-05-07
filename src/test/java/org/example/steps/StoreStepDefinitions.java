package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.PageObjectFactory.PageObjectManager;
import org.example.constant.Endpoint;
import org.example.context.TestContext;
import org.example.domainObject.Product;
import org.example.pages.StorePage;
import org.openqa.selenium.WebDriver;

public class StoreStepDefinitions {
    private StorePage storePage;

    public StoreStepDefinitions(TestContext context) {
        storePage = PageObjectManager.getStorePage(context.driver);
    }

    @Given("I'm on the store page")
    public void iMOnTheStorePage() {
        storePage.load(Endpoint.STORE.url);
    }

    @When("I add a {product} to the cart")
    public void iAddAToTheCart(Product product) {
        storePage.addToCart(product.getName());
    }
    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() {
        storePage.addToCart("Blue Shoes");
    }
}
