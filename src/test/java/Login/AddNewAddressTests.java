package Login;

import Base.BaseTests;
import Pages.AccountPage;
import Pages.AddNewAddressPage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddNewAddressTests extends BaseTests {
    @Description("When I enter a registered user, Then Try to add new address," +
            " I should get an message that the address is added")
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "AddAddressData")
    public void testAddNewAddress(String email,String password,String firstName,String lastName, String addressEmail, String company, String country, String city, String address1, String address2, String zipCode, String phoneNum, String faxNum){
        LoginPage loginPage = homePage.ClickLoginButton();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        AccountPage accountPage = loginPage.clickLoginButton();
        accountPage.clickMyAccountButton();
        accountPage.clickAddresses();
        AddNewAddressPage addNewAddressPage = accountPage.clickAddNewButtonAddressButton();
        addNewAddressPage.setFirstName(firstName);
        addNewAddressPage.setLastName(lastName);
        addNewAddressPage.setEmail(addressEmail);
        addNewAddressPage.setCompany(company);
        addNewAddressPage.selectCountry(country);
        addNewAddressPage.setCity(city);
        addNewAddressPage.setAddress1(address1);
        addNewAddressPage.setAddress2(address2);
        addNewAddressPage.setZip(zipCode);
        addNewAddressPage.setPhoneNumber(phoneNum);
        addNewAddressPage.setFaxNumber(faxNum);
        addNewAddressPage.clickSaveButton();
        assertEquals(addNewAddressPage.getMessageSuccessfully(),"The new address has been added successfully.","Address Cannot be added");
        addNewAddressPage.clickCloseMessage();
        loginPage.clickLogoutButton();
    }
    @Description("When I enter a registered user, Then click to My account in the nav Bar" +
            " I should get the address that was added")
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "LoginData")
    public void testSuccessfullyNewAddressISAdded(String email,String password){
        LoginPage loginPage = homePage.ClickLoginButton();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        AccountPage accountPage = loginPage.clickLoginButton();
        accountPage.clickMyAccountButton();
        accountPage.clickAddresses();
        assertEquals(accountPage.getEditText(),"Edit","Address is not added");
        loginPage.clickLogoutButton();
    }
}
