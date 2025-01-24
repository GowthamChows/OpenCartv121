package testCases;

import org.testng.annotations.Test;
import pageObjects.Home_page;
import pageObjects.Login_page;
import pageObjects.MyAccount_Page;

public class TC002_Login_Test extends ReUsed {
	
	@Test(groups= {"Sanity", "Master"})
	public void Verifying_PageTitle_test() {
		       
        Home_page hp = new Home_page(driver);
        
        logger.info("TC002_Login_test Started execution");
        
        logger.info("***************Verifying the  Page Name ****************");
        boolean conformMsg=hp.Page_Name();
        
        logger.info("Page Tittle Verification Sucessfull");
        
	}
        
        
        @Test(groups= {"Regression", "Master"})
        public void Login_test() { 
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
		
	   // MyAcPage.ClickOnLogoutbtn();
	   
	   logger.info("Login Sucessfull And Test Has Finished");
	}
	
}
