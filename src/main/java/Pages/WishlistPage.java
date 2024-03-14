package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage {
    private WebDriver driver;
    private By cardTable = By.className("cart");
    private By skuNumber = By.className("sku-number");
    protected By wishlistEmptyMessage = By.className("no-data");
    public WishlistPage(WebDriver driver){
        this.driver = driver;
    }
    public boolean cardTableIsDisplayed(){
        driver.findElement(cardTable).isDisplayed();
        return true;
    }
    public String getSkuNumber(){
        return driver.findElement(skuNumber).getText();
    }
    public String getWishlistEmptyMessage(){
        return driver.findElement(wishlistEmptyMessage).getText();
    }
}
