package Register;

import Base.BaseTests;
import Pages.RegisterPage;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import io.qameta.allure.*;

import static org.testng.Assert.assertEquals;

public class RegisterTests extends BaseTests {
    @Description("Given i try to redirect to the register page, When I am in home page, Then I should redirect successfully")
    @Story("Register")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testRedirectSuccessfullyToRegisterPage(){
        RegisterPage registerPage = homePage.ClickRegisterButton();
        assertEquals(registerPage.getRegisterMessageHeader(),"Register","Register Page is incorrect");
    }
    @Description("When I enter valid data in the sign up form And click the signup button," +
            " Then I should be registered successfully And I can see message" +
            " that Your registration completed")
    @Story("Register")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "RegisterData", priority = 1)
    public void testSuccessfullyRegisterWithExternalData(String firstName,String lastName, String gender, String email, String password, String day, String month, String year, String companyName){
        RegisterPage registerPage = homePage.ClickRegisterButton();
        registerPage.selectGender(gender);
        registerPage.setFirstName(firstName);
        registerPage.setLastName(lastName);
        registerPage.selectDay(day);
        registerPage.selectMonth(month);
        registerPage.selectYear(year);
        String currentTime = new SimpleDateFormat("ddMyyyyhhmmss").format(new Date());
        String email2 = email+currentTime+"@test.com";
        registerPage.setEmail(email2);
        try {
            registerPage.storeEmailData(email2,password);
            registerPage.storeEmailAddressData(email2,password);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        registerPage.setCompanyName(companyName);
        registerPage.selectNewsletter();
        registerPage.setPassword(password);
        registerPage.setConfirmPassword(password);
        registerPage.clickRegisterButton();
        assertEquals(registerPage.getRegisterSuccessfullyMessage(),"Your registration completed","Register message is incorrect");
        registerPage.clickContinueAfterRegister();
    }
    SoftAssert softAssert = new SoftAssert();
    @Description("Given i don't enter any information, When I am in register page, Then I should get an error message")
    @Story("Register")
    @Severity(SeverityLevel.CRITICAL)
    @Test()
    public void testInvalidRegister(){
        RegisterPage registerPage = homePage.ClickRegisterButton();
        registerPage.clickRegisterButton();
        softAssert.assertEquals(registerPage.getFirstNameMessage(), "First name is required.",  "First Name Error message is incorrect");
        softAssert.assertEquals(registerPage.getLastNameMessage(), "Last name is required.", "Last Name Error message is incorrect");
        softAssert.assertEquals(registerPage.getEmailMessage(),"Email is required.","Email Error message is incorrect");
        softAssert.assertAll();
    }
    @Description("Given i don't enter email, When I am in register page, Then I should get an error message")
    @Story("Register")
    @Severity(SeverityLevel.CRITICAL)
    @Test()
    public void testEmptyEmail(){
        RegisterPage registerPage = homePage.ClickRegisterButton();
        registerPage.selectGender("M");
        registerPage.setFirstName("Mohamed");
        registerPage.setLastName("Mostafa");
        registerPage.selectDay("25");
        registerPage.selectMonth("April");
        registerPage.selectYear("1998");
        registerPage.setEmail("");
        registerPage.setCompanyName("ITI");
        registerPage.selectNewsletter();
        registerPage.setPassword("test25498");
        registerPage.setConfirmPassword("test25498");
        registerPage.clickRegisterButton();
        assertEquals(registerPage.getEmailMessage(),"Email is required.","Email Error message is incorrect");
    }
    @Description("Given i enter 2 different passwords, When I am in register page, Then I should get an error message")
    @Story("Register")
    @Severity(SeverityLevel.CRITICAL)
    @Test()
    public void testPasswordAndConfirmPasswordMismatch(){
        RegisterPage registerPage = homePage.ClickRegisterButton();
        registerPage.selectGender("M");
        registerPage.setFirstName("Mohamed");
        registerPage.setLastName("Mostafa");
        registerPage.selectDay("25");
        registerPage.selectMonth("April");
        registerPage.selectYear("1998");
        registerPage.setEmail("momo25@ex.com");
        registerPage.setCompanyName("ITI");
        registerPage.selectNewsletter();
        registerPage.setPassword("test25498");
        registerPage.setConfirmPassword("test25");
        registerPage.clickRegisterButton();
        assertEquals(registerPage.getPasswordMessage(),"The password and confirmation password do not match.","Email Error message is incorrect");
    }
}
