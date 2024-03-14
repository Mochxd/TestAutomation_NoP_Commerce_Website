package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Product3Page extends Product1Page{
    private WebDriver driver;
    private By addToCartButton = By.id("add-to-cart-button-18");

    public Product3Page(WebDriver driver){
        super();
        this.driver =driver;
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
