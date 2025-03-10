package testCases;

import org.testng.annotations.Test;

import pageObjects.Home_page;
import pageObjects.Login_page;
import pageObjects.MyAccount_Page;
import testBase.ReUsed;

public class TC0010_Newsletter_SUbscription_Test extends ReUsed {
	
	@Test(groups= {"Sanity", "Master"})
	 public void Newsletter_SUbscription_Test() { 
	        logger.info("Executing the Login");

	        Home_page hp = new Home_page(driver);
	        
	        hp.clickonMyAccount(); 
	        hp.ClickOnLogin(); 

	       Login_page  loginPage = new Login_page(driver);
	       
	       loginPage.SetUpEmail(p.getProperty("Login_EMAIL"));
	       loginPage.SetUpPassword(p.getProperty("Login_PASSWORD"));
	       loginPage.ClickOnLoginBtn();
	       
	       logger.info("Clicked on the Login Button");
	       
	       MyAccount_Page MyAcPage= new MyAccount_Page(driver);
	       boolean conformMsg=MyAcPage.getConformationTxt();
	  
	       MyAcPage.clickon_Newsletter();
	       
	       MyAcPage.clickon_Yes_btn();
	       
	       logger.info("Clicked on Yes Btn");
	       
	       MyAcPage.clickOn_Continue();
	       
	     boolean GetTextDisplayed = MyAcPage.GetTextDisplayed();
	     
	     logger.info("Verifying the Sucess Text");
	 }

}
