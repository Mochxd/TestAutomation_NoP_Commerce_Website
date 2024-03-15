package Login;

import Base.BaseTests;
import Pages.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {
    @Description("When I Sign in with an already registered user, Then I should login successfully")
    @Story("Login")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "LoginData", priority = 1)
    public void loginSuccessfully(String email, String password){
        LoginPage loginPage = homePage.ClickLoginButton();
        assertEquals(loginPage.getWelcomeText(),"Welcome, Please Sign In!","Login Page is not loaded!");
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickRememberMe();
        loginPage.clickLoginButton();
        assertEquals(loginPage.getLogOutTextIcon(),"Log out","Unsuccessfully login");
        loginPage.clickLogoutButton();
    }
    @Description("When I enter a not registered user, Then I should get an error message")
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void loginUnSuccessfullyWithInvalidCustomer(){
        LoginPage loginPage = homePage.ClickLoginButton();
        assertEquals(loginPage.getWelcomeText(),"Welcome, Please Sign In!","Login Page is not loaded!");
        loginPage.setEmail("mo@gmail.com");
        loginPage.setPassword("momo58933");
        loginPage.clickLoginButton();
        assertTrue(loginPage.getLoginMessageUnsuccessfully().contains("Login was unsuccessful. Please correct the errors and try again."),"Login Successfully");
    }
}
