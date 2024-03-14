package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Product1Page {
    private WebDriver driver;
    private By processor = By.id("product_attribute_1");
    private By ram = By.id("product_attribute_2");
    private By hdd = By.id("product_attribute_3_6");
    private By os = By.id("product_attribute_4_9");
    private By software = By.id("product_attribute_5_11");
    private By addToCartButton = By.id("add-to-cart-button-1");
    protected By message = By.xpath("//div[@class='bar-notification success']//p");
    protected By closeNotification = By.className("close");
    protected By goToCart = By.xpath("//span[@class='cart-label']");
    private By addToWishlist = By.id("add-to-wishlist-button-1");
    public Product1Page(WebDriver driver){
        this.driver = driver;
    }

    public Product1Page() {
    }

    public Select DropDownElements(By option){
        return new Select(driver.findElement(option));
    }
    public void selectProcessor(String option) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(processor));
        DropDownElements(processor).selectByVisibleText(option);
    }
    public void selectRam(String option) {
        DropDownElements(ram).selectByVisibleText(option);
    }
    public void clickHdd(){
        driver.findElement(hdd).click();
    }
    public void clickSoftware(){
        driver.findElement(software).click();
    }
    public void clickCloseNotification(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(message));
        driver.findElement(closeNotification).click();
    }
    public String getMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(message));
        return driver.findElement(message).getText();
    }
    public void clickAddToCartButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(goToCart));
        driver.findElement(addToCartButton).click();
    }
    public ShoppingCartPage clickGoToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(goToCart));
        driver.findElement(goToCart).click();
        return new ShoppingCartPage(driver);
    }
    public void clickAddToWishlist(){
        driver.findElement(addToWishlist).click();
    }

}
