package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class My_Transctions_Page extends BasePage {
		public My_Transctions_Page(WebDriver driver)
		{
			super(driver);  // Call BasePage constructor
	        PageFactory.initElements(driver, this); 
		}
		

		
@FindBy(xpath="//a[normalize-space()='Transactions']")
WebElement Transctions;



@FindBy(xpath="//b[normalize-space()='$0.00']")
WebElement Current_balance;

@FindBy(xpath="//a[normalize-space()='Continue']")
WebElement Continue_btn;



public void Click_on_Transctions() {
	Transctions.click();
}

public boolean getConformationTxt() {
	try {
		return(Current_balance.isDisplayed());
		} catch (Exception e) 
	    {
			return false;
		}
}

	public void ClickOnContinue_btn()
	{
		Continue_btn.click();
	}

}


