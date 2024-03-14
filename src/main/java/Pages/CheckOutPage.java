package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class CheckOutPage {
    private WebDriver driver;
//    private By firstNameField = By.id("BillingNewAddress_FirstName");
//    private By lastNameField = By.id("BillingNewAddress_LastName");
//    private By emailField = By.id("BillingNewAddress.Email");
//    private By companyField = By.id("BillingNewAddress_Company");
//    private By countryField = By.id("BillingNewAddress_CountryId");
//    private By stateField = By.id("Address_StateProvinceId");
//    private By cityField = By.id("BillingNewAddress_City");
//    private By address1Field = By.id("BillingNewAddress_Address1");
//    private By address2Field = By.id("BillingNewAddress_Address2");
//    private By zipField = By.id("BillingNewAddress_ZipPostalCode");
//    private By phoneNumberField = By.id("BillingNewAddress_PhoneNumber");
//    private By faxNumberField = By.id("Address_FaxNumber");
    private By addressContinueButton = By.xpath("//button[contains(@onclick,'Billing.save()')]");
    private By addressDeleteButton = By.xpath("//button[contains(@onclick,'Billing.deleteAddress')]");
    private By groundShippingMethod = By.id("shippingoption_0");
    private By nextDayAirShippingMethod = By.id("shippingoption_1");
    private By twoDayAirShippingMethod = By.id("shippingoption_2");
    private By shippingContinueButton = By.xpath("//button[contains(@onclick,'ShippingMethod.save()')]");
    private By paymentMethodMoneyOrder = By.id("paymentmethod_0");
    private By paymentMethodCreditCard = By.id("paymentmethod_1");
    private By paymentMethodContinueButton = By.xpath("//button[contains(@onclick,'PaymentMethod.save()')]");
    private By paymentInformationContinueButton = By.xpath("//button[contains(@onclick,'PaymentInfo.save()')]");
    private By confirmOrderButton = By.xpath("//button[contains(@onclick,'ConfirmOrder.save()')]");


    public CheckOutPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickAddressContinue(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(addressContinueButton));
        driver.findElement(addressContinueButton).click();
    }
    public void clickAddressDelete(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(addressDeleteButton));
        driver.findElement(addressDeleteButton).click();
    }
    public void clickGroundShippingMethod(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(groundShippingMethod));
        driver.findElement(groundShippingMethod).click();
    }
    public void clickNextDayAirShippingMethod(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(nextDayAirShippingMethod));
        driver.findElement(nextDayAirShippingMethod).click();
    }
    public void clickTwoDayAirShippingMethod(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(twoDayAirShippingMethod));
        driver.findElement(twoDayAirShippingMethod).click();
    }
    public void clickShippingContinue(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(shippingContinueButton));
        driver.findElement(shippingContinueButton).click();
    }
    public void clickPaymentMethodMoneyOrder(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(paymentMethodMoneyOrder));
        driver.findElement(paymentMethodMoneyOrder).click();
    }
    public void clickPaymentMethodCreditCard(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(paymentMethodCreditCard));
        driver.findElement(paymentMethodCreditCard).click();
    }
    public void clickPaymentMethodContinueButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(paymentMethodContinueButton));
        driver.findElement(paymentMethodContinueButton).click();
    }
    public void clickPaymentInformationContinueButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(paymentInformationContinueButton));
        driver.findElement(paymentInformationContinueButton).click();
    }
    public CompleteCheckOutPage clickConfirmOrderButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrderButton));
        driver.findElement(confirmOrderButton).click();
        return new CompleteCheckOutPage(driver);
    }

}
