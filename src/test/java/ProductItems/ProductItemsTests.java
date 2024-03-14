package ProductItems;

import Base.BaseTests;
import Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductItemsTests extends BaseTests {
    @Description("Given i try to add one product in my cart, When I am in home page, Then I should get a message that the product is added successfully")
    @Story("Product Items")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "LoginData")
    public void testSuccessfullyAddProductToCartProduct1(String email, String password){
        LoginPage loginPage = homePage.ClickLoginButton();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickRememberMe();
        loginPage.clickLoginButton();
        homePage.scrollToProducts();
        Product1Page shoppingCartPage = homePage.clickAddToCartProduct1();
        shoppingCartPage.selectProcessor("2.2 GHz Intel Pentium Dual-Core E2200");
        shoppingCartPage.selectRam("8GB [+$60.00]");
        shoppingCartPage.clickHdd();
        shoppingCartPage.clickSoftware();
        shoppingCartPage.clickAddToCartButton();
        assertEquals(shoppingCartPage.getMessage(),"The product has been added to your shopping cart","incorrect Added to Cart");
        shoppingCartPage.clickCloseNotification();
        loginPage.clickLogoutButton();
    }
    @Description("Given i try to add another product in my cart, When I am in home page, Then I should get a message that the product is added successfully")
    @Story("Product Items")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "LoginData")
    public void testSuccessfullyAddProductToCartProduct2(String email, String password){
        LoginPage loginPage = homePage.ClickLoginButton();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickRememberMe();
        loginPage.clickLoginButton();
        homePage.scrollToProducts();
        Product2Page shoppingCartPage2 = homePage.clickAddToCartProduct2();
        shoppingCartPage2.clickAddToCartButton2();
        assertEquals(shoppingCartPage2.getMessage(),"The product has been added to your shopping cart","incorrect Added to Cart");
        shoppingCartPage2.clickCloseNotification();
        loginPage.clickLogoutButton();
    }
    @Description("Given i try to add another product in my cart, When I am in home page, Then I should get a message that the product is added successfully")
    @Story("Product Items")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "LoginData")
    public void testSuccessfullyAddProductToCartProduct3(String email, String password){
        LoginPage loginPage = homePage.ClickLoginButton();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickRememberMe();
        loginPage.clickLoginButton();
        homePage.scrollToProducts();
        Product3Page shoppingCartPage3 = homePage.clickAddToCartProduct3();
        assertEquals(shoppingCartPage3.getMessage(),"The product has been added to your shopping cart","incorrect Added to Cart");
        shoppingCartPage3.clickCloseNotification();
        loginPage.clickLogoutButton();
    }
    @Description("Given i try to add product in my wishlist cart, When I am in home page, Then I should get a message that the product is added successfully")
    @Story("Product Items")
    @Severity(SeverityLevel.MINOR)
    @Test(dataProvider = "LoginData")
    public void testSuccessfullyAddProductToWishlistProduct1(String email, String password){
        LoginPage loginPage = homePage.ClickLoginButton();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickRememberMe();
        loginPage.clickLoginButton();
        homePage.scrollToProducts();
        Product1Page shoppingCartPage = homePage.clickAddToCartProduct1();
        shoppingCartPage.selectProcessor("2.2 GHz Intel Pentium Dual-Core E2200");
        shoppingCartPage.selectRam("8GB [+$60.00]");
        shoppingCartPage.clickHdd();
        shoppingCartPage.clickSoftware();
        shoppingCartPage.clickAddToWishlist();
        assertEquals(shoppingCartPage.getMessage(),"The product has been added to your wishlist","incorrect Added to wishlist");
        shoppingCartPage.clickCloseNotification();
        WishlistPage wishlistPage = homePage.clickWishlist();
        assertTrue(wishlistPage.cardTableIsDisplayed(),"Incorrect Wishlist Page");
        assertEquals(wishlistPage.getSkuNumber(),"COMP_CUST","Incorrect Product Item");
        System.out.println(wishlistPage.getSkuNumber());
        loginPage.clickLogoutButton();
    }
    @Description("Given i try to go to my shopping cart without adding any products, When I am in home page, Then I should get a message that my shopping cart is empty")
    @Story("Product Items")
    @Severity(SeverityLevel.MINOR)
    @Test()
    public void testEmptyShoppingCart(){
        homePage.scrollToProducts();
        ShoppingCartPage shoppingCartPage = homePage.clickShoppingCardButton();
        assertEquals(shoppingCartPage.getShoppingCardEmptyMessage(),"Your Shopping Cart is empty!","Shopping Cart is not Empty");
    }
    @Description("Given i try to go to my Wishlist cart without adding any products, When I am in home page, Then I should get a message that my wishlist cart is empty")
    @Story("Product Items")
    @Severity(SeverityLevel.MINOR)
    @Test()
    public void testEmptyWishlist(){
        homePage.scrollToProducts();
        WishlistPage wishlistPage = homePage.clickWishlist();
        assertEquals(wishlistPage.getWishlistEmptyMessage(),"The wishlist is empty!","Wishlist is not Empty");
    }
}
