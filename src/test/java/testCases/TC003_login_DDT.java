package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Home_page;
import pageObjects.Login_page;
import pageObjects.MyAccount_Page;
import testBase.ReUsed;
import utilities.DataProviders;

public class TC003_login_DDT extends ReUsed {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups = {"DDT"})
	public void Verify_Login_DDT(String email, String pwd, String exp) {
		
	/*	
		
		Data Is Vaild   - Login Scucess - Test Pass - Logout
		                - Login Failed  - Test Fail 
		                
		Data Is Invalid  - Login Sucess -test Fail - logout
		                 - Login Fail   - test Pass 
		*/
		
		logger.info("Test With using Data Provider Has Been Started");

	      //HomePage
        Home_page hp = new Home_page(driver);
        hp.clickonMyAccount();
        hp.ClickOnLogin(); 

        //LoginPage
       Login_page  loginPage = new Login_page(driver);
       loginPage.SetUpEmail(email);
       loginPage.SetUpPassword(pwd);
       loginPage.ClickOnLoginBtn();
       
       //My Account Page
       MyAccount_Page MyAcPage= new MyAccount_Page(driver);
	   boolean conformMsg=MyAcPage.getConformationTxt();	   
	   
	   if(exp.equalsIgnoreCase("Valid"))
	   {
		   if(conformMsg==true)
		   {
			   MyAcPage.ClickOnLogoutbtn();
			   Assert.assertTrue(true);
		   }
		   else
		   {
			   Assert.assertTrue(false);
		   }
	   }
	   
	   if(exp.equalsIgnoreCase("Invalid"))
	   {
		   MyAcPage.ClickOnLogoutbtn();
		   Assert.assertTrue(false);
	   }
	   else
	   {
		   Assert.assertTrue(true);
	   }
		logger.info("Test With using Data Provider Has Been executed Sucessfully");

	}
}