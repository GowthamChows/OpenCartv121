package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistration_page extends BasePage {
	


	public AccountRegistration_page(WebDriver driver)
	{
		super(driver);  // Call BasePage constructor
        PageFactory.initElements(driver, this); 
	}

	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement EMail;
	
	@FindBy(xpath="//input[@id='input-telephone']") 
	WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']") 
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']") 
	WebElement passwordConfirm;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement agree;
	
	@FindBy(xpath="//input[@value='Continue']") 
	WebElement btncontinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement ConformationTxt;
	
	public void SetFirstName(String FrstName)
	{
		FirstName.sendKeys(FrstName);
	}
	
	public void SetLastName(String LastName)
	{
		lastName.sendKeys(LastName);
	}
	
	public void Setemail(String  email)
	{
		EMail.sendKeys(email);	
	}
	
	public void SetTelephone(String tele) 
	{
		telephone.sendKeys(tele);
	}
	
	public void Setpassword(String  Password)
	{
		password.sendKeys(Password);	
	}
	
	public void SetpasswordConfirm(String  PasswordConfirm)
	{
		passwordConfirm.sendKeys(PasswordConfirm);	
	}
	
	public void SetPrivacyPolicy()
	{
		agree.click();
	}
	
	public void ClickContinue ()
	{
		btncontinue.click();
	}
	
	
	public String getConformationTxt() {
		try {
			return(ConformationTxt.getText());
		} catch (Exception e) {
			return(e.getMessage());
		}
	}
		
}
