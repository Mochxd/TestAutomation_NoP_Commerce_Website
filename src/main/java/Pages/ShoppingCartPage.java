package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage {
    private WebDriver driver;
    private By shoppingCardHeader = By.xpath("//div[@class='page-title']//h1");
    private By shoppingCardEmptyMessage = By.className("no-data");
    private By termsAcceptClick = By.id("termsofservice");
    private By checkOutButton = By.id("checkout");
    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
    }
    public String getShoppingCardEmptyMessage(){
        return driver.findElement(shoppingCardEmptyMessage).getText();
    }
    public void clickTermsAcceptClick(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(termsAcceptClick));
        driver.findElement(termsAcceptClick).click();
    }
    public void scrollToTerms(){
        WebElement terms = driver.findElement(termsAcceptClick);
        String script = "arguments[0].scrollIntoView();";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, terms);
    }
    public CheckOutPage clickCheckOut(){
        driver.findElement(checkOutButton).click();
        return new CheckOutPage(driver);
    }
}
