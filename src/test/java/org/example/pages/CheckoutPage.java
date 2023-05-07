package org.example.pages;

import org.example.domainObject.BillingDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {
    @FindBy(id = "billing_first_name")
    private WebElement billingFirstNameFld;
    @FindBy(id = "billing_last_name")
    private WebElement billingLastNameFld;
    @FindBy(id = "billing_address_1")
    private WebElement billingAddressOneFld;
    @FindBy(id = "billing_city")
    private WebElement billingCityFld;
    @FindBy(id = "billing_state")
    private WebElement billingStateDropdown;
    @FindBy(id = "select2-billing_state-container") private WebElement alternateBillingStateDropDown;

    @FindBy(id = "billing_postcode")
    private WebElement billingPostCodeFld;
    @FindBy(id = "billing_email")
    private WebElement billingEmailFld;
    @FindBy(id = "place_order")
    private WebElement placeOrderBtn;
    @FindBy(css = ".woocommerce-notice")
    private WebElement noticeTxt;
    private final By overlay = By.cssSelector(".blockUI.blockOverlay");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterBillingFirstName(String billingFirstName) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingFirstNameFld));
        e.clear();
        e.sendKeys(billingFirstName);
        return this;
    }

    public CheckoutPage enterBillingLastName(String billingLastName) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingLastNameFld));
        e.clear();
        e.sendKeys(billingLastName);
        return this;
    }

    public CheckoutPage enterBillingAddressOne(String billingAddressOne) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingAddressOneFld));
        e.clear();
        e.sendKeys(billingAddressOne);
        return this;
    }

    public CheckoutPage enterBillingCity(String billingCity) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingCityFld));
        e.clear();
        e.sendKeys(billingCity);
        return this;
    }

    public CheckoutPage enterBillingPostCode(String billingPostCode) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingPostCodeFld));
        e.clear();
        e.sendKeys(billingPostCode);
        return this;
    }

    public CheckoutPage enterBillingEmail(String billingEmail) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingEmailFld));
        e.clear();
        e.sendKeys(billingEmail);
        return this;
    }

    public CheckoutPage selectBillingState(String billingStateName) {
        wait.until(ExpectedConditions.elementToBeClickable(alternateBillingStateDropDown)).click();
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[text()='" + billingStateName + "']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        /*Select select = new Select(wait.until(ExpectedConditions.visibilityOf(billingStateDropdown)));
        select.selectByVisibleText(billingStateName);*/
        return this;
    }

    public CheckoutPage setBillingDetails(BillingDetails billingDetails) {
        return enterBillingFirstName(billingDetails.getBillingFirstName()).
                enterBillingLastName(billingDetails.getBillingLastName()).
                enterBillingAddressOne(billingDetails.getBillingAddressOne()).
                enterBillingCity(billingDetails.getBillingCity()).
                selectBillingState(billingDetails.getBillingStateName()).
                enterBillingPostCode(billingDetails.getBillingZip()).
                enterBillingEmail(billingDetails.getBillingEmail());
    }
    public void selectPlaceOrderBtn(){
        waitForOverlaysToDisappear(overlay);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
        }
        catch (org.openqa.selenium.StaleElementReferenceException ex){
            wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
        }

    }
    public String getNoticeTxt(){
        return wait.until(ExpectedConditions.visibilityOf(noticeTxt)).getText();
    }
}
