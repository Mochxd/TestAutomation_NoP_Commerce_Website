package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompleteCheckOutPage {
    private WebDriver driver;
    private By successfullyMessage = By.xpath("(//div[@class='title']//strong)[1]");
    private By continueButton = By.xpath("//button[contains(@class,'button-1 order-completed-continue-button')]");
    private By orderNumber = By.className("order-number");
    public CompleteCheckOutPage(WebDriver driver){
        this.driver = driver;
    }
    public String getSuccessfullyMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderNumber));
        return driver.findElement(successfullyMessage).getText();
    }
    public void clickContinueButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderNumber));
        driver.findElement(continueButton).click();
    }
}
