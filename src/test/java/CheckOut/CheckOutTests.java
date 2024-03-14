package CheckOut;

import Base.BaseTests;
import Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckOutTests extends BaseTests {
    @Description("Given i use a valid email and password, When I am in Home page page, Then I should able to add a valid product item, and make an order")
    @Story("Checkout")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "LoginData",priority = 1)
    public void testSuccessfullyCheckoutUsingMoneyOrder(String email, String password){
        LoginPage loginPage = homePage.ClickLoginButton();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickRememberMe();
        loginPage.clickLoginButton();
        homePage.scrollToProducts();
        Product1Page Product1ShoppingCartPage = homePage.clickAddToCartProduct1();
        Product1ShoppingCartPage.selectProcessor("2.2 GHz Intel Pentium Dual-Core E2200");
        Product1ShoppingCartPage.selectRam("8GB [+$60.00]");
        Product1ShoppingCartPage.clickHdd();
        Product1ShoppingCartPage.clickSoftware();
        Product1ShoppingCartPage.clickAddToCartButton();
        Product1ShoppingCartPage.clickCloseNotification();
        ShoppingCartPage shoppingCartPage = Product1ShoppingCartPage.clickGoToCart();
        shoppingCartPage.scrollToTerms();
        shoppingCartPage.clickTermsAcceptClick();
        CheckOutPage checkOutPage = shoppingCartPage.clickCheckOut();
        checkOutPage.clickAddressContinue();
        checkOutPage.clickGroundShippingMethod();
        checkOutPage.clickShippingContinue();
        checkOutPage.clickPaymentMethodMoneyOrder();
        checkOutPage.clickPaymentMethodContinueButton();
        checkOutPage.clickPaymentInformationContinueButton();
        CompleteCheckOutPage completeCheckOutPage= checkOutPage.clickConfirmOrderButton();
        assertEquals(completeCheckOutPage.getSuccessfullyMessage(),"Your order has been successfully processed!","Invalid Checkout");
        completeCheckOutPage.clickContinueButton();
        loginPage.clickLogoutButton();
    }
    @Description("Given i use a valid email and password, When I am in Home page page, Then I should able to see the order number after i make the checkout")
    @Story("Checkout")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "LoginData",priority = 2)
    public void testAddingOrders(String email, String password){
        LoginPage loginPage = homePage.ClickLoginButton();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        AccountPage accountPage = loginPage.clickLoginButton();
        accountPage.clickMyAccountButton();
        accountPage.clickOrders();
        assertTrue(accountPage.getOrderNumber().contains("Order Number: "),"Incorrect Account Page");
        System.out.println(accountPage.getOrderNumber());
        loginPage.clickLogoutButton();
    }
}
