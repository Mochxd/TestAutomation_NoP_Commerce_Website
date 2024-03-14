package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By logOutButton = By.className("ico-logout");
    private By welcomeText = By.xpath("//div[@class='page-title']/h1");
    private By emailField = By.className("email");
    private By passwordField = By.className("password");
    private By rememberMeCheckBox = By.id("RememberMe");
    private By forgotPassword = By.className("forgot-password");
    private By LoginButton = By.xpath("//button[contains(@class,'login')]");
    private By loginMessageUnsuccessfully = By.xpath("//div[contains(@class,'message-error')]");
    private By myAccountButton = By.className("ico-account");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    public String getWelcomeText(){
        return driver.findElement(welcomeText).getText();
    }
    public void setEmail(String email){
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }
    public void setPassword(String password){
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickRememberMe(){
        driver.findElement(rememberMeCheckBox).click();
    }
    public ForgotPasswordPage clickForgotPassword(){
        driver.findElement(forgotPassword).click();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        return forgotPasswordPage;
    }
    public String getLoginMessageUnsuccessfully(){
        return driver.findElement(loginMessageUnsuccessfully).getText();
    }
    public AccountPage clickLoginButton(){
        driver.findElement(LoginButton).click();
        AccountPage accountPage = new AccountPage(driver);
        return accountPage;
    }
    public String getLogOutTextIcon(){
        return driver.findElement(logOutButton).getText();
    }
    public void clickLogoutButton(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(logOutButton).click();
    }

}
