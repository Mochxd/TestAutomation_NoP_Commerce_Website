package ForgotPassword;

import Base.BaseTests;
import Pages.ForgotPasswordPage;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class ForgotPasswordTests extends BaseTests {
    @Description("Given i click on the forgot Password, When I am in login page, Then I should redirect Successfully to forgot Password Page")
    @Story("Forgot Password")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void testRedirectSuccessfullyToForgotPasswordPage(){
        LoginPage loginPage = homePage.ClickLoginButton();
        ForgotPasswordPage forgotPasswordPage = loginPage.clickForgotPassword();
        assertEquals(forgotPasswordPage.getPasswordRecoveryMessage(),"Password recovery","Forgot Password Page is incorrect");
    }
    @Description("Given i input a valid email, When I am in forgot Password page, Then I should see a valid message that mail is sent to this mail")
    @Story("Forgot Password")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "ForgotPasswordEmails")
    public void testSendEmail(String email,String password){
        LoginPage loginPage = homePage.ClickLoginButton();
        ForgotPasswordPage forgotPasswordPage = loginPage.clickForgotPassword();
        forgotPasswordPage.setEmail(email);
        forgotPasswordPage.clickRecoverButton();
        assertEquals(forgotPasswordPage.getSuccessfullyMessageAlert(),"Email with instructions has been sent to you.","Incorrect Email");

    }
    @DataProvider
    public static Object[][] ForgotPasswordEmails() throws IOException {
        // Extend the pass for the file
        String excelPath = "C:\\Users\\zas\\ProjectNonCommerceWebsite\\src\\main\\resources\\EmailStoreData.xlsx";
        // Make a constuctor for Data formatter
        DataFormatter formatter = new DataFormatter();
        FileInputStream fileInputStream= new FileInputStream(excelPath);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet worksheet = workbook.getSheetAt(0);
        XSSFRow Row = worksheet.getRow(0);
        // count my number of Rows
        int RowNum = worksheet.getPhysicalNumberOfRows();
        // get last column
        int ColNum = Row.getLastCellNum();
        // Store My data in the Array
        Object Data[][]= new Object[RowNum-1][ColNum];

        //Loop to get Rows
        for(int i=0; i<RowNum-1; i++)
        {
            XSSFRow row= worksheet.getRow(i+1);
            //Loop to get columns
            for (int j=0; j<ColNum; j++)
            {
                if(row==null)
                    Data[i][j]= "";
                else
                {
                    XSSFCell cell= row.getCell(j);
                    //When trying to get data if there is any data null it will pass empty data
                    if(cell==null)
                        Data[i][j]= "";
                    else
                    {
                        String value = formatter.formatCellValue(cell);
                        Data[i][j]=value;
                    }
                }
            }
        }
        return Data;
    }
}
