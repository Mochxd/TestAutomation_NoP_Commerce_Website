package Search;

import Base.BaseTests;
import Pages.SearchPage;
import java.text.ParseException;
import java.util.List;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchTests extends BaseTests {

    @Description("Given i search for valid item, When I am in Home page, Then I should get this item")
    @Story("Search")
    @Severity(SeverityLevel.MINOR)
    @Test(dataProvider = "productItems")
    public void testValidSearch(String productItem){
        homePage.setItemsName(productItem);
        SearchPage searchPage = homePage.clickSearchButton();
        searchPage.scrollToProducts();
        assertEquals(searchPage.getProductName(),productItem,"Product is not found");
    }

    @Description("Given i search for invalid item, When I am in Home page, Then I should get error message")
    @Story("Search")
    @Severity(SeverityLevel.MINOR)
    @Test(dataProvider = "InvalidProductItems")
    public void testInValidSearch(String InvalidProductItems){
        homePage.setItemsName(InvalidProductItems);
        SearchPage searchPage = homePage.clickSearchButton();
        assertEquals(searchPage.getNoResultMessage(),"No products were found that matched your criteria.","Product is not found");
    }

    @Description("Given i don't search for any item, When I am in Home page, Then I should get error message")
    @Story("Search")
    @Severity(SeverityLevel.MINOR)
    @Test()
    public void testEmptySearch(){
        homePage.setItemsName("");
        SearchPage searchPage = homePage.clickSearchButton();
        assertEquals(searchPage.getAlertEmptySearchMessage(),"Please enter some search keyword","Product is not found");
        searchPage.closeAlert();
    }

    @Description("Given i want to sort the items that i searched for, When I am in Search page, Then the items should be sorted by lowest Price")
    @Story("Search")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testSortByLowestPrice() throws ParseException {
        homePage.setItemsName("book");
        SearchPage searchPage = homePage.clickSearchButton();
        searchPage.selectSortBy("Price: Low to High");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Double> itemPrices = searchPage.getAllItemsPrices();
        System.out.println(itemPrices);
        boolean isSorted = searchPage.isSortedLowToHigh(itemPrices);
        assertTrue(isSorted, "Items are not Sorted By Price: Low to High ");
    }

    @Description("Given i want to sort the items that i searched for, When I am in Search page, Then the items should be sorted by highest Price")
    @Story("Search")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testSortByHighestPrice() throws ParseException {
        homePage.setItemsName("book");
        SearchPage searchPage = homePage.clickSearchButton();
        searchPage.selectSortBy("Price: High to Low");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Double> itemPrices = searchPage.getAllItemsPrices();
        System.out.println(itemPrices);
        boolean isSorted = searchPage.isSortedHighToLow(itemPrices);
        assertTrue(isSorted, "Items are not Sorted By Price: High to Low");
    }

    @Description("Given i want to sort the items that i searched for, When I am in Search page, Then the items should be sorted by alphabetical")
    @Story("Search")
    @Severity(SeverityLevel.MINOR)
    @Test
    public void testSortByAlphabetical(){
        homePage.setItemsName("book");
        SearchPage searchPage = homePage.clickSearchButton();
        searchPage.selectSortBy("Name: A to Z");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<String> itemNames = searchPage.getAllItemsNames();
        boolean result = searchPage.isSortedAlphabetically(itemNames);
        assertTrue(result, "Items are not Sorted By A to Z");
    }

    @DataProvider
    public Object [] productItems () {
        Object [] data = new Object [6];
        data [0]= "Apple MacBook Pro 13-inch";
        data [1]= "Build your own computer";
        data [2]= "HTC One M8 Android L 5.0 Lollipop";
        data [3]= "Samsung Series 9 NP900X4C Premium Ultrabook";
        data [4]= "HP Spectre XT Pro UltraBook";
        data [5]= "Flower Girl Bracelet";
        return data;
    }
    @DataProvider
    public Object [] InvalidProductItems () {
        Object [] data = new Object [6];
        data [0]= "alaa";
        data [1]= "<html>";
        data [2]= "25noaa";
        data [3]= "soso";
        data [4]= "koko";
        data [5]= "nias";
        return data;
    }
}
