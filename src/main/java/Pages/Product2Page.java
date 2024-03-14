package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Product2Page extends Product1Page{
    private WebDriver driver;
    private By addToCartButton = By.id("add-to-cart-button-4");

    public Product2Page(WebDriver driver){
        super();
        this.driver =driver;
    }
    public void clickAddToCartButton2(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(addToCartButton));
        driver.findElement(addToCartButton).click();
    }
    public void clickCloseNotification(){
        driver.findElement(closeNotification).click();
    }
    public String getMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(message));
        return driver.findElement(message).getText();
    }
}
