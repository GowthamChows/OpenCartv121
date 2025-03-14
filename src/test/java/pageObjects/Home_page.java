package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(xpath="//div[@class='caption']//a[contains(text(),'MacBook')]")
	WebElement MacBook;
	
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']//a[contains(text(),'Tablets')]")
	WebElement Tablets;
	
	@FindBy(xpath="//a[normalize-space()='Cameras (2)']")
	WebElement Cameras;	
	
	@FindBy(xpath="//a[normalize-space()='Canon EOS 5D']")
	WebElement Canon_Item;
	
	
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
	
	public void ClickOnMacBook()
	{
		MacBook.click();
	}
	
	public void ClickOnTablets() {
		Tablets.click();
	}
	
	public void ClickOnCameras() {
		Cameras.click();
	}
	
	public void ClickOnCanon_Item()
	{
		Canon_Item.click();
	}
	
}
