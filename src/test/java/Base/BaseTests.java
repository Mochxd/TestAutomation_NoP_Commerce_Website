package Base;

import Pages.HomePage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
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
    //@BeforeMethod
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
    @DataProvider(name = "jsonData")
    public Object[][] jsonData() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("C:\\Users\\zas\\ProjectNonCommerceWebsite\\src\\main\\resources\\JsonData.json");

        // Parse the JSON file into JSONArray
        JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);
        Object[][] arr = new Object[jsonArray.size()][5]; // Change this line

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject user = (JSONObject) jsonArray.get(i);
            arr[i][0] = user.get("First name");
            arr[i][1] = user.get("Last name");
            arr[i][2] = user.get("Email");
            arr[i][3] = user.get("Password");
            arr[i][4] = user.get("Confirm Password");
        }

        return arr;
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
