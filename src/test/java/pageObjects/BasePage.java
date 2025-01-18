package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    // Constructor to initialize WebDriver and PageFactory
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize PageFactory elements
    }
}
