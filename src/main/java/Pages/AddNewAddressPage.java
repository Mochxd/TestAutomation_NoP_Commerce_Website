package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddNewAddressPage{
    private WebDriver driver;
    private By firstNameField = By.id("Address_FirstName");
    private By lastNameField = By.id("Address_LastName");
    private By emailField = By.id("Address_Email");
    private By companyField = By.id("Address_Company");
    private By countryField = By.id("Address_CountryId");
    private By stateField = By.xpath("By.xpath(//select[@id='BillingNewAddress_StateProvinceId']//option[@value='0'])");
    private By cityField = By.id("Address_City");
    private By address1Field = By.id("Address_Address1");
    private By address2Field = By.id("Address_Address2");
    private By zipField = By.id("Address_ZipPostalCode");
    private By phoneNumberField = By.id("Address_PhoneNumber");
    private By faxNumberField = By.id("Address_FaxNumber");
    private By saveButton = By.xpath("//button[contains(@class,'save')]");
    private By messageSuccessfully = By.xpath("//div[@class='bar-notification success']//p");
    private By closeMessage = By.xpath("//div[@class='bar-notification success']//span");
    private By logOutButton = By.className("ico-logout");

    public AddNewAddressPage(WebDriver driver){
        this.driver = driver;
    }
    public void setFirstName(String fName){
        driver.findElement(firstNameField).sendKeys(fName);
    }
    public void setLastName(String lName){
        driver.findElement(lastNameField).sendKeys(lName);
    }
    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void setCompany(String company){
        driver.findElement(companyField).sendKeys(company);
    }
    public void setState(String state){
        driver.findElement(stateField).sendKeys(state);
    }

    public void setCity(String city){
        driver.findElement(cityField).sendKeys(city);
    }
    public void setAddress1(String address1){
        driver.findElement(address1Field).sendKeys(address1);
    }
    public void setAddress2(String address2){
        driver.findElement(address2Field).sendKeys(address2);
    }
    public void setZip(String zip){
        driver.findElement(zipField).sendKeys(zip);
    }
    public void setPhoneNumber(String phoneNum){
        driver.findElement(phoneNumberField).sendKeys(phoneNum);
    }
    public void setFaxNumber(String faxNum){
        driver.findElement(faxNumberField).sendKeys(faxNum);
    }
    public void clickSaveButton(){
        driver.findElement(saveButton).click();
    }

    public Select DropDownElements(By option){
        return new Select(driver.findElement(option));
    }
    public void selectCountry(String option) {
        DropDownElements(countryField).selectByVisibleText(option);
    }
    public String getMessageSuccessfully(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(closeMessage));
        return driver.findElement(messageSuccessfully).getText();
    }
    public void clickCloseMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(closeMessage));
        driver.findElement(closeMessage).click();
    }

}
