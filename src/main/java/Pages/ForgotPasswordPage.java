package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;
    private By passwordRecoveryMessage = By.xpath("//div[@class='page-title']//h1");
    private By emailField = By.id("Email");
    private By recoverButton = By.name("send-email");
    private By successfullyMessageAlert = By.xpath("//p[@class= 'content']");
    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }
    public String getPasswordRecoveryMessage(){
        return driver.findElement(passwordRecoveryMessage).getText();
    }
    public String getSuccessfullyMessageAlert(){
        return driver.findElement(successfullyMessageAlert).getText();
    }
    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void clickRecoverButton(){
        driver.findElement(recoverButton).click();
    }
}
