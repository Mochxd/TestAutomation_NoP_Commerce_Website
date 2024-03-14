package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    private WebDriver driver;
    private By productName = By.xpath("//h2[@class='product-title']");
    private By orderBy = By.id("products-orderby");
    private By itemsPieces =  By.xpath("//div[@class='add-info']//span[@class=('price actual-price')]");
    private By noResultMessage = By.ByClassName.className("no-result");
    public SearchPage(WebDriver driver){
        this.driver = driver;
    }
    public String getProductName(){
       return driver.findElement(productName).getText();
    }
    public String getAlertEmptySearchMessage(){
        return driver.switchTo().alert().getText();
    }
    public void closeAlert(){
        driver.switchTo().alert().accept();
    }
    public String getNoResultMessage(){
        return driver.findElement(noResultMessage).getText();
    }
    public Select DropDownElements(By option){
        return new Select(driver.findElement(option));
    }
    public void selectSortBy(String option) {
        DropDownElements(orderBy).selectByVisibleText(option);
    }
    public void scrollToProducts(){
        WebElement productsItem = driver.findElement(productName);
        String script = "arguments[0].scrollIntoView();";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, productsItem);
    }
    public List<String> getAllItemsNames(){
        List<WebElement> itemElements = driver.findElements(productName);
        List<String> itemNames = new ArrayList<>();
        for (WebElement element : itemElements) {
            itemNames.add(element.getText());
        }
        return itemNames;
    }
    public List<Double> getAllItemsPrices() {
        List<WebElement> itemElements = driver.findElements(itemsPieces);
        List<Double> itemPrices = new ArrayList<>();
        for (WebElement element : itemElements) {
            String priceString = element.getText();
            double price = parsePrice(priceString);
            itemPrices.add(price);
        }
        return itemPrices;
    }
    private double parsePrice(String priceString) {
        String numericalPart = priceString.replaceAll("[^\\d.]", "");
        return Double.parseDouble(numericalPart);
    }
    public boolean isSortedHighToLow(List<Double> items) {
        for (int i = 0; i < items.size() - 1; i++) {
            if (items.get(i) < items.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
    public boolean isSortedLowToHigh(List<Double> items) {
        for (int i = 0; i < items.size() - 1; i++) {
            if (items.get(i) < items.get(i + 1)) {
                return true;
            }
        }
        return false;
    }
    public boolean isSortedAlphabetically(List<String> items) {
        for (int i = 0; i < items.size() - 1; i++) {
            if (items.get(i).compareTo(items.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }
}
