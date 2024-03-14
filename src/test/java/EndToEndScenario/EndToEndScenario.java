package EndToEndScenario;

import Base.BaseTests;
import Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EndToEndScenario extends BaseTests {
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private  Product1Page shoppingCartPage;
    private ShoppingCartPage shoppingCartPageFinal;
    private CheckOutPage checkOutPage;
    private CompleteCheckOutPage completeCheckOutPage;
    private String firstName = "Mohamed";
    private String lastName = "Mostafa";
    private String email = "mohamedMostfa@gmail.com";
    private String password = "25498123";
    @Description("Given i use a valid email and password, When I am in the login page, Then I should able to add a valid product item, and make an order")
    @Story("End To End Scenario")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void fullUserPurchaseScenario(){
        SuccessfullyRegister(firstName,lastName,email,password);
        loginPage = homePage.ClickLoginButton();
        loginSuccessfully(email,password);
        assertEquals(loginPage.getLogOutTextIcon(),"Log out","Unsuccessfully login");
        testAddNewAddress();
        homePage.ClickHomePageLogo();
        AddProductToCartProduct1Successfully();
        assertEquals(shoppingCartPage.getMessage(),"The product has been added to your shopping cart","incorrect Added to Cart");
        shoppingCartPage.clickCloseNotification();
        CheckoutUsingMoneyOrderSuccessfully();
        assertEquals(completeCheckOutPage.getSuccessfullyMessage(),"Your order has been successfully processed!","Invalid Checkout");
        completeCheckOutPage.clickContinueButton();
        loginPage.clickLogoutButton();
    }
    public void SuccessfullyRegister(String firstName,String lastName, String email, String password){
        registerPage = homePage.ClickRegisterButton();
        registerPage.selectGender("m");
        registerPage.setFirstName(firstName);
        registerPage.setLastName(lastName);
        registerPage.selectDay("28");
        registerPage.selectMonth("January");
        registerPage.selectYear("1998");
        registerPage.setEmail(email);
        registerPage.setCompanyName("ITI");
        registerPage.selectNewsletter();
        registerPage.setPassword(password);
        registerPage.setConfirmPassword(password);
        registerPage.clickRegisterButton();
        assertEquals(registerPage.getRegisterSuccessfullyMessage(),"Your registration completed","Register message is incorrect");
        registerPage.clickContinueAfterRegister();
    }
    public void loginSuccessfully(String email, String password){
        loginPage = homePage.ClickLoginButton();
        assertEquals(loginPage.getWelcomeText(),"Welcome, Please Sign In!","Login Page is not loaded!");
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickRememberMe();
        accountPage = loginPage.clickLoginButton();
    }
    public void testAddNewAddress(){
        accountPage.clickMyAccountButton();
        accountPage.clickAddresses();
        AddNewAddressPage addNewAddressPage = accountPage.clickAddNewButtonAddressButton();
        addNewAddressPage.setFirstName("Mohamed");
        addNewAddressPage.setLastName("Mostafa");
        addNewAddressPage.setEmail("mochxd@gmail.com");
        addNewAddressPage.setCompany("Valeo");
        addNewAddressPage.selectCountry("Egypt");
        addNewAddressPage.setCity("Fayoum");
        addNewAddressPage.setAddress1("Taawnyat street");
        addNewAddressPage.setAddress2("El Mesla");
        addNewAddressPage.setZip("35640");
        addNewAddressPage.setPhoneNumber("01011818952");
        addNewAddressPage.setFaxNumber("02587");
        addNewAddressPage.clickSaveButton();
        assertEquals(addNewAddressPage.getMessageSuccessfully(),"The new address has been added successfully.","Address Cannot be added");
        addNewAddressPage.clickCloseMessage();
    }
    public void AddProductToCartProduct1Successfully(){
        homePage.scrollToProducts();
        shoppingCartPage = homePage.clickAddToCartProduct1();
        shoppingCartPage.selectProcessor("2.2 GHz Intel Pentium Dual-Core E2200");
        shoppingCartPage.selectRam("8GB [+$60.00]");
        shoppingCartPage.clickHdd();
        shoppingCartPage.clickSoftware();
        shoppingCartPage.clickAddToCartButton();
    }
    public void CheckoutUsingMoneyOrderSuccessfully(){
        shoppingCartPageFinal = shoppingCartPage.clickGoToCart();
        shoppingCartPageFinal.scrollToTerms();
        shoppingCartPageFinal.clickTermsAcceptClick();
        checkOutPage = shoppingCartPageFinal.clickCheckOut();
        checkOutPage.clickAddressContinue();
        checkOutPage.clickGroundShippingMethod();
        checkOutPage.clickShippingContinue();
        checkOutPage.clickPaymentMethodMoneyOrder();
        checkOutPage.clickPaymentMethodContinueButton();
        checkOutPage.clickPaymentInformationContinueButton();
        completeCheckOutPage = checkOutPage.clickConfirmOrderButton();
    }
}
