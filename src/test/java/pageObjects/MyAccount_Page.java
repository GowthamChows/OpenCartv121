package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount_Page  extends BasePage {

	public MyAccount_Page(WebDriver driver)
	{
		super(driver);  // Call BasePage constructor
        PageFactory.initElements(driver, this); 
	
	}
	
	
@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement ConformationTxt;
	
@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement Logoutbtn;

@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Newsletter']")
WebElement Newsletter;

@FindBy(xpath="//input[@value='0']")
WebElement Yes_btn;

@FindBy(xpath="//input[@value='Continue']")
WebElement continue_btn;

@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
WebElement GetTextDisplayed;
	public boolean getConformationTxt() {
		try {
			return(ConformationTxt.isDisplayed());
			} catch (Exception e) 
		    {
				return false;
			}
}

		public void ClickOnLogoutbtn()
		{
			Logoutbtn.click();
		}
		
		
	public void clickon_Newsletter() {
		
		Newsletter.click();
		
	}
		
	public void clickon_Yes_btn() {
		Yes_btn.click();
	}
	
	public void clickOn_Continue() {
		continue_btn.click();
	}

	public boolean GetTextDisplayed() {
		try {
			return(GetTextDisplayed.isDisplayed());
		} catch (Exception e)
		{
			return false;
		}
	}


}
