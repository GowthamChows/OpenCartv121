package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_Page  extends BasePage {
		
		
		public Checkout_Page(WebDriver driver) {
	        super(driver);  // Call BasePage constructor
	        PageFactory.initElements(driver, this);  // Initialize Page Elements
	    }
		
@FindBy(xpath="//strong[normalize-space()='Checkout']")
WebElement CheckOutBtn;

@FindBy(xpath="//a[@class='btn btn-primary']")
WebElement CheckoutBtn;

@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
WebElement OutOfMessageTxt;

@FindBy(xpath="//input[contains(@name, 'quantity')]")
WebElement InputBox;

@FindBy(xpath="//i[@class='fa fa-refresh']")
WebElement Refreshtoggle;

@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
WebElement ModifiedCartTxt;

public void ClickonCheckOut() {
	CheckOutBtn.click();
}

public void ClickonFinalCheckOut() {
	CheckoutBtn.click();
}

public String getOUtOFSTOCKMessageText() {
    return OutOfMessageTxt.getText();
}

public void SetUpInputbox(String Value)
{
	InputBox.sendKeys(Value);
}
		

public void SetUpRefreshToggle()
{
	Refreshtoggle.click();
}

public String getMOdifiedCartMessageText() {
    return ModifiedCartTxt.getText();
}

	}

