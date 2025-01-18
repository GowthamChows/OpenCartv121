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



}
