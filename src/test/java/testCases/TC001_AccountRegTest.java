package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistration_page;
import pageObjects.Home_page;
import testBase.ReUsed;

public class TC001_AccountRegTest extends ReUsed {
	
	 
	@Test(groups= {"Sanity","Master"})
	public void Account_reg() {
		
		logger.info("Starting TC001_AccountRegTest");
		
       try {
        Home_page hp = new Home_page(driver);
        hp.clickonMyAccount(); 
        logger.info("Clicked on My Account");
        
        hp.ClickOnRegister();  
        logger.info("Clicked on Register");

        AccountRegistration_page AregPage = new AccountRegistration_page(driver);
        
        
        logger.info("Providing the customer details");
		AregPage.SetFirstName(randomString().toUpperCase());
		AregPage.SetLastName(randomString().toUpperCase());
		AregPage.Setemail(randomString()+"@gmail.com");
		AregPage.SetTelephone(randomNumber());
		
		String Password=RandomAlphaNumeric();
		AregPage.Setpassword(Password);
		AregPage.SetpasswordConfirm(Password);
		
		AregPage.SetPrivacyPolicy();
		AregPage.ClickContinue();
		
		 logger.info("Verifying the Conformation Message");
		 
		String conformMsg=AregPage.getConformationTxt();
		
		Assert.assertEquals(conformMsg, "Your Account Has Been Created!");
	}
       catch(Exception e)
       {
    	   logger.error("Test Failed");
    	   logger.debug("Debug Logs");
    	   Assert.fail();
       }
       
       logger.info("TC001_AccountRegTest Finished");
	
	}
}
