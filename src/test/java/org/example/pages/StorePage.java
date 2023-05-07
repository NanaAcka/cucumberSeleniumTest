package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage{
    @FindBy(css = "a[title='View cart']") private WebElement viewCartLink;
    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(String productName) {

        By addToCartBtn = By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");
        //WebElement element = driver.findElement(addToCartBtn);
        //((JavascriptExecutor) driver).executeScript("(\"arguments[0].scrollIntoView();\"", element);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();


    }

}
