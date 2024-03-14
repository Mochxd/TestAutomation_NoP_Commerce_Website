package Base;

import Pages.HomePage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver(getChromeOptions());
        goHome();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://demo.nopcommerce.com/");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        return options;
    }
        @DataProvider
        public static Object[][] RegisterData() throws IOException{
            // Extend the pass for the file
            String excelPath = "C:\\Users\\zas\\ProjectNonCommerceWebsite\\src\\main\\resources\\RegisterData.xlsx";
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
    @DataProvider
    public static Object[][] LoginData() throws IOException{
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
    @DataProvider
    public static Object[][] AddAddressData() throws IOException{
        // Extend the pass for the file
        String excelPath = "C:\\Users\\zas\\ProjectNonCommerceWebsite\\src\\main\\resources\\AddAddressData.xlsx";
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
//    @DataProvider
//    public Object [] [] loginData(){
//        Object [][] data = new Object [2][2];
//        data [0][0] = "menna.257@example.com";
//        data [0][1] = "P@ssword.25";
//
//        data [1][0] = "mochxd32@test.com";
//        data [1][1] = "P@ssword.2";
//        return data;
//    }
}
