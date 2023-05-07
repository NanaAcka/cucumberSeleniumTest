package org.example.PageObjectFactory;

import org.example.pages.CartPage;
import org.example.pages.CheckoutPage;
import org.example.pages.StorePage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public static StorePage storePage;
    public static CartPage cartPage;
    public static CheckoutPage checkoutPage;

    public static CartPage getCartPage(WebDriver driver) {
        return cartPage == null ? new CartPage(driver) : cartPage;
    }

    public static StorePage getStorePage(WebDriver driver) {
        return storePage == null ? new StorePage(driver) : storePage;
    }

    public static CheckoutPage getCheckoutPage(WebDriver driver) {
        return checkoutPage == null ? new CheckoutPage(driver) : checkoutPage;
    }
}
