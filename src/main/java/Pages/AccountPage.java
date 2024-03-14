package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage{
    private WebDriver driver;
    private By myAccountButton = By.xpath("//a[contains(@class,'ico-account')]");
    private By successfullyMessage = By.xpath("//div[@class='page-title']//h1");
    private By customerInfo = By.xpath("//li[contains(@class,'customer-info')]//a");
    private By addresses = By.xpath("//li[contains(@class,'customer-addresses')]//a");
    private By orders = By.xpath("//li[contains(@class,'customer-orders')]//a");
    private By editAddressButton = By.xpath("//button[contains(@class,'button-2 edit-address-button')]");
    private By orderNumber = By.xpath("(//div[@class='title']//strong)[2]");
    private By addNewButtonAddress = By.className("add-button");
    public AccountPage(WebDriver driver){
        this.driver =driver;
    }
    public void clickAddresses(){
        driver.findElement(addresses).click();
    }
    public void clickMyAccountButton(){
        driver.findElement(myAccountButton).click();
    }
    public AddNewAddressPage clickAddNewButtonAddressButton(){
        driver.findElement(addNewButtonAddress).click();
        return new AddNewAddressPage(driver);
    }
    public String getOrderNumber(){
        return driver.findElement(orderNumber).getText();
    }
    public void clickOrders(){
        driver.findElement(orders).click();
    }
    public String getSuccessfullyMessage(){
        return driver.findElement(successfullyMessage).getText();
    }
    public String getEditText(){
        return driver.findElement(editAddressButton).getText();
    }
}