package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private By loginButton = By.className("ico-login");
    private By RegisterButton = By.className("ico-register");
    private By searchItems = By.id("small-searchterms");
    private By searchButton = By.xpath("//button[@type='submit']");
    private By shoppingCart = By.className("ico-cart");
    private By wishlist = By.className("ico-wishlist");
    private By product1 = By.xpath("//div[@data-productid=('1')]");
    private By AddToCartProduct1 = By.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[1]");
    private By AddToCartProduct2 = By.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[2]");
    private By AddToCartProduct3 = By.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[3]");
    private By homePageLogo = By.xpath("//img[contains(@alt, 'demo')]");


    public HomePage(WebDriver driver){
        this.driver= driver;
    }
    public LoginPage ClickLoginButton(){
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }
    public void ClickHomePageLogo(){
        driver.findElement(homePageLogo).click();
    }
    public RegisterPage ClickRegisterButton(){
        driver.findElement(RegisterButton).click();
        return new RegisterPage(driver);
    }
    public void setItemsName(String name){
        driver.findElement(searchItems).sendKeys(name);
    }
    public SearchPage clickSearchButton(){
        driver.findElement(searchButton).click();
        return new SearchPage(driver);
    }
    public ShoppingCartPage clickShoppingCardButton(){
        driver.findElement(shoppingCart).click();
        return new ShoppingCartPage(driver);
    }
    public void scrollToProducts(){
        WebElement productsItem = driver.findElement(product1);
        String script = "arguments[0].scrollIntoView();";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, productsItem);
    }
    public void scrollUpToProducts() {
        WebElement productsItem = driver.findElement(homePageLogo);
        String script = "arguments[0].scrollIntoView(false);";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, productsItem);
    }

    public Product1Page clickAddToCartProduct1(){
        driver.findElement(AddToCartProduct1).click();
        return new Product1Page(driver);
    }
    public Product2Page clickAddToCartProduct2(){
        driver.findElement(AddToCartProduct2).click();
        return new Product2Page(driver);
    }
    public Product3Page clickAddToCartProduct3(){
        driver.findElement(AddToCartProduct3).click();
        return new Product3Page(driver);
    }
    public WishlistPage clickWishlist(){
        driver.findElement(wishlist).click();
        return new WishlistPage(driver);
    }

}
