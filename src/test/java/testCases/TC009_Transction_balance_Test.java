package testCases;

import org.testng.annotations.Test;

import pageObjects.Home_page;
import pageObjects.Login_page;
import pageObjects.My_Transctions_Page;
import testBase.ReUsed;

public class TC009_Transction_balance_Test extends ReUsed{
	
	@Test(groups= {"Sanity", "Master"})
	public void Transction_balance_Test() {
		       
        Home_page hp = new Home_page(driver);
        
        hp.clickonMyAccount();
        
        hp.ClickOnLogin();
        
        Login_page  loginPage = new Login_page(driver);
        
        loginPage.SetUpEmail(p.getProperty("Login_EMAIL"));
        loginPage.SetUpPassword(p.getProperty("Login_PASSWORD"));
        loginPage.ClickOnLoginBtn();
        
        hp.clickonMyAccount();
        
        My_Transctions_Page TP= new My_Transctions_Page(driver);
        
        TP.Click_on_Transctions();
        
        boolean conformMsg=TP.getConformationTxt();
        
        TP.ClickOnContinue_btn();
        
        logger.info("Done With Login");
        logger.info("Ad CLicked on Transctions");
        logger.info(" And Verifying The Trancstion Ammount That Has Done");
        
        
       }
	

}
