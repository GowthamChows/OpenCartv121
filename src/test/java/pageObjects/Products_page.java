package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Products_page  extends BasePage {
	
	
	public Products_page(WebDriver driver) {
        super(driver);  // Call BasePage constructor
        PageFactory.initElements(driver, this);  // Initialize Page Elements
    }
	
	
	@FindBy(xpath="//h2[normalize-space()='Products meeting the search criteria']")
	WebElement Search_Criteria_txt;
	
	@FindBy(xpath="//a[normalize-space()='iPhone']")
	WebElement Iphone;
	
	@FindBy(xpath="//h2[normalize-space()='$123.20']")
	WebElement Product_Price;
	
	@FindBy(xpath="//h1[normalize-space()='iPhone']")
	WebElement ProductName;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement addtocartbtn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement successMessage;
	
	@FindBy(xpath="//span[@id='cart-total']")
	WebElement TotalCartBtn;
	
	public void  Verifying_Product()
	{
		Iphone.click();
	}
	
	public boolean Verifying_Criteria_Txt() {
	try {
		return(Search_Criteria_txt.isDisplayed());
		} catch (Exception e) 
	    {
			return false;
		}
	}
	
	public boolean getProductName() {
		try {
			return(ProductName.isDisplayed());
			} catch (Exception e) 
		    {
				return false;
			}
	}
	
	public void AddToCartBtn()
	{
		addtocartbtn.click();
	}
	
	public String getAlertMessageText() {
        return successMessage.getText();
    }

	public void ClickOnFinalCart()
	{
		TotalCartBtn.click();
	}
}
