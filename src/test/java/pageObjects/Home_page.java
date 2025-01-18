package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Home_page  extends BasePage {
	
	
	public Home_page(WebDriver driver) {
        super(driver);  // Call BasePage constructor
        PageFactory.initElements(driver, this);  // Initialize Page Elements
    }
	
	@FindBy(xpath="//a[normalize-space()='Qafox.com']")
	WebElement  Name;
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement MyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement Register;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement Login;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement Searchbox;
	
	@FindBy(xpath="//i[@class='fa fa-search']")
	WebElement Search_btn;
	
	
	
	 public boolean Page_Name() {
	        try {
	            return Name.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }
	 
	public void clickonMyAccount()
	{
		MyAccount.click();
	}
	
	public void ClickOnRegister()
	{
		Register.click();
	}
	
	public void ClickOnLogin()
	{
		Login.click();
	}
	
	public void SetUpSearchBox(String value)
	{
		Searchbox.sendKeys(value);
	}
	
	public void ClickSearchBtn()
	{
		Search_btn.click();
	}
	
}
