package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class RegisterPage {
    private WebDriver driver;
    private By registerMessage = By.xpath("//div[@class='page-title']/h1");
    private By maleCheckBox = By.className("male");
    private By femaleCheckBox = By.className("female");
    private By firstNameField = By.id("FirstName");
    private By firstNameErrorMessage = By.id("FirstName-error");
    private By lastNameField = By.id("LastName");
    private By lastNameErrorMessage = By.id("LastName-error");
    private By dateDay = By.name("DateOfBirthDay");
    private By dateMonth = By.name("DateOfBirthMonth");
    private By dateYear = By.name("DateOfBirthYear");
    private By emailField = By.id("Email");
    private By emailErrorMessage = By.id("Email-error");
    private By companyName = By.id("Company");
    private By newsletterCheckBox = By.id("Newsletter");
    private By passwordField = By.id("Password");
    private By passwordErrorMessage = By.id("Password-error");
    private By confirmPasswordField = By.id("ConfirmPassword");
    private By confirmPasswordErrorMessage = By.id("ConfirmPassword-error");

    private By registerButton = By.id("register-button");
    private By registerCompleteMessage = By.className("result");
    private By continueButton = By.xpath("//a[contains(text(),'Continue')]");

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectGender(String gender){
        if (gender.toLowerCase().equals("m") || gender.toLowerCase().equals("male")){
            driver.findElement(maleCheckBox).click();
        }else if(gender.toLowerCase().equals("f") || gender.toLowerCase().equals("female")) {
            driver.findElement(femaleCheckBox).click();
        }else {
            System.out.println("Input a valid type of gender.");
        }
    }
    public void setFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void setLastName(String LastName){
        driver.findElement(lastNameField).sendKeys(LastName);
    }
    public Select DropDownElements(By option){
        return new Select(driver.findElement(option));
    }
    public void selectDay(String option) {
        DropDownElements(dateDay).selectByVisibleText(option);
    }
    public void selectMonth(String option) {
        DropDownElements(dateMonth).selectByVisibleText(option);
    }
    public void selectYear(String option) {
        DropDownElements(dateYear).selectByVisibleText(option);
    }
    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void setCompanyName(String company){
        driver.findElement(companyName).sendKeys(company);
    }
    public void selectNewsletter(){
        driver.findElement(newsletterCheckBox).click();
    }
    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void setConfirmPassword(String password){
        driver.findElement(confirmPasswordField).sendKeys(password);
    }

    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }
    public String getRegisterSuccessfullyMessage() {
        return driver.findElement(registerCompleteMessage).getText();
    }
    public String getRegisterMessageHeader() {
        return driver.findElement(registerMessage).getText();
    }

    public String getFirstNameMessage() {
        return driver.findElement(firstNameErrorMessage).getText();
    }
    public String getLastNameMessage() {
        return driver.findElement(lastNameErrorMessage).getText();
    }
    public String getEmailMessage() {
        return driver.findElement(emailErrorMessage).getText();
    }
    public String getPasswordMessage() {
        return driver.findElement(confirmPasswordErrorMessage).getText();
    }
    public HomePage clickContinueAfterRegister(){
        driver.findElement(continueButton).click();
        return new HomePage(driver);
    }
    public void storeEmailData(String email,String password) throws IOException {
        String excelPath = "C:\\Users\\zas\\ProjectNonCommerceWebsite\\src\\main\\resources\\EmailStoreData.xlsx";
        FileInputStream fis = new FileInputStream(excelPath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0); // Use getSheetAt(0) to get the first sheet

        int lastRowNum = sheet.getLastRowNum(); // Get the index of the last row
        int newRowNum = lastRowNum + 1; // Determine the index for the new row

        // Create a new row at the next available index (incremented by 1)
        Row row = sheet.createRow(newRowNum);

        // Create a new cell in the row and set the value to the email
        Cell cell = row.createCell(0);
        Cell cell2 = row.createCell(1);
        cell.setCellValue(email);
        cell2.setCellValue(password);

        // Write the changes back to the Excel file
        FileOutputStream fos = new FileOutputStream(excelPath);
        workbook.write(fos);

        // Close the streams
        fos.close();
        fis.close();
    }
    public void storeEmailAddressData(String email, String password) throws IOException {
        String excelPath = "C:\\Users\\zas\\ProjectNonCommerceWebsite\\src\\main\\resources\\AddAddressData.xlsx";
        FileInputStream fis = new FileInputStream(excelPath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0); // Use getSheetAt(0) to get the first sheet

        int lastRowNum = sheet.getLastRowNum(); // Get the index of the last row
        int newRowNum = lastRowNum + 1; // Determine the index for the new row

        // Iterate over existing rows to find the first row with an empty cell
        int existingRowWithEmptyCell = -1;
        for (int i = 0; i <= lastRowNum; i++) {
            Row existingRow = sheet.getRow(i);
            Cell existingCell = existingRow.getCell(0); // Assuming the first column is for email
            if (existingCell == null || existingCell.getCellType() == CellType.BLANK) {
                existingRowWithEmptyCell = i;
                break;
            }
        }

        // If no empty cell found, use the next available row
        if (existingRowWithEmptyCell == -1) {
            existingRowWithEmptyCell = newRowNum;
        }

        // Create a new row at the index found (or newRowNum if no empty cell found)
        Row row = sheet.getRow(existingRowWithEmptyCell);
        if (row == null) {
            row = sheet.createRow(existingRowWithEmptyCell);
        }

        // Set the email and password in the cells
        Cell cell = row.createCell(0);
        Cell cell2 = row.createCell(1);
        cell.setCellValue(email);
        cell2.setCellValue(password);

        // Write the changes back to the Excel file
        FileOutputStream fos = new FileOutputStream(excelPath);
        workbook.write(fos);

        // Close the streams
        fos.close();
        fis.close();
    }
}
