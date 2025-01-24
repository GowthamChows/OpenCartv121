package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishlistPage extends BasePage {

    public WishlistPage(WebDriver driver) {
        super(driver); // Call BasePage constructor
        PageFactory.initElements(driver, this); // Initialize Page Elements
    }

    // Wishlist button
    @FindBy(xpath = "//a[@id='wishlist-total']")
    WebElement Wishlistbtn;
    
    @FindBy(xpath="(//a[@class='btn btn-danger'])[1]")
    WebElement RemoveBtnForItem_1;
    
    @FindBy(xpath="(//a[@class='btn btn-danger'])[2]")
    WebElement RemoveBtnForItem_2;
    
    // Table rows in the wishlist (adjusted the xpath)
    @FindBy(xpath = "//div[@class='table-responsive']//table/tbody/tr")
    List<WebElement> wishlistTableRows;

    // Locator for table columns (relative to the row)
    By productName = By.xpath(".//td[2]/a");
    By model = By.xpath(".//td[3]");
    By stock = By.xpath(".//td[4]");
    By unitPrice = By.xpath(".//td[5]");

    // Click on Wishlist button
    public void ClickOn_WishlistBtn() {
        Wishlistbtn.click();
    }
    
    public void ClickOnRemovebtn()
    {
    	RemoveBtnForItem_1.click();
    }
    
    public void ClickonRemovebtn_2() {
    	
    	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           
           // Wait for the table to be visible first
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-danger']"))).click();
    }
    
    
    // Method to retrieve wishlist data
    public List<Map<String, String>> getWishlistData() {
        List<Map<String, String>> wishlistData = new ArrayList<>();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Wait for the table to be visible first
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='table-responsive']//table/tbody/tr")));
        
        // Wait for the rows to be loaded in the table
        wait.until(driver -> driver.findElements(By.xpath("//div[@class='table-responsive']//table/tbody/tr")).size() > 0);

        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='table-responsive']//table/tbody/tr"));

        // Iterate through each row in the table
        for (WebElement row : rows) {
            Map<String, String> productDetails = new HashMap<>();
            productDetails.put("Product Name", row.findElement(productName).getText());
            productDetails.put("Model", row.findElement(model).getText());
            productDetails.put("Stock", row.findElement(stock).getText());
            productDetails.put("Unit Price", row.findElement(unitPrice).getText());
            wishlistData.add(productDetails);
        }
        return wishlistData;
    }
}





/*package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishlistPage extends BasePage {

    public WishlistPage(WebDriver driver) {
        super(driver); // Call BasePage constructor
        PageFactory.initElements(driver, this); // Initialize Page Elements
    }

    // Wishlist button
    @FindBy(xpath = "//span[normalize-space()='Wish List (2)']")
    WebElement Wishlistbtn;
    
    // Table rows in the wishlist
    @FindBy(xpath = "//div[@class='table-responsive']")
    List<WebElement> wishlistTableRows;

    // Locator for table columns (relative to the row)
    By productName = By.xpath(".//td[2]/a");
    By model = By.xpath(".//td[3]");
    By stock = By.xpath(".//td[4]");
    By unitPrice = By.xpath(".//td[5]");

    // Click on Wishlist button
    public void ClickOn_WishlistBtn() {
        Wishlistbtn.click();
    }

    // Method to retrieve wishlist data
    public List<Map<String, String>> getWishlistData() {
        List<Map<String, String>> wishlistData = new ArrayList<>();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(wishlistTableRows));

        List<WebElement> rows = driver.findElements(wishlistTableRows);


        // Iterate through each row in the table
        for (WebElement row : rows) {
            Map<String, String> productDetails = new HashMap<>();
            productDetails.put("Product Name", row.findElement(productName).getText());
            productDetails.put("Model", row.findElement(model).getText());
            productDetails.put("Stock", row.findElement(stock).getText());
            productDetails.put("Unit Price", row.findElement(unitPrice).getText());
            wishlistData.add(productDetails);
        }
        return wishlistData;
    }
}
*/
