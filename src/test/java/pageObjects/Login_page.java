package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page  extends BasePage {

		public Login_page(WebDriver driver)
		{
			super(driver);  // Call BasePage constructor
	        PageFactory.initElements(driver, this); 
		}

		@FindBy(xpath="//input[@id='input-email']")
		WebElement email;
		
		@FindBy(xpath="//input[@id='input-password']")
		WebElement Password;
		
		@FindBy(xpath="//input[@value='Login']")
		WebElement loginbtn;
		
		
		public void SetUpEmail(String mail)
		{
			email.sendKeys(mail);
		}
		
		public void SetUpPassword(String password)
		{
			Password.sendKeys(password);
		}
		
		public void ClickOnLoginBtn()
		{
			loginbtn.click();
		}
		
		
}
		
		
		

