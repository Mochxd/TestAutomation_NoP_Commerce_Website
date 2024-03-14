package Login;

import Base.BaseTests;
import Pages.AccountPage;
import Pages.LoginPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import io.qameta.allure.*;

public class AccountPageTests extends BaseTests {
    @Description("When I Sign in with an already registered user, Then i should able to see my account information")
    @Story("Login")
    @Severity(SeverityLevel.MINOR)
    @Test(dataProvider = "LoginData")
    public void testAddingAddress(String email, String password){
        LoginPage loginPage = homePage.ClickLoginButton();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        AccountPage accountPage = loginPage.clickLoginButton();
        accountPage.clickMyAccountButton();
        assertEquals(accountPage.getSuccessfullyMessage(),"My account - Customer info","Incorrect Account Page");
        loginPage.clickLogoutButton();
    }

}
