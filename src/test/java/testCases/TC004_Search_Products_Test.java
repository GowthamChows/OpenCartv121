package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Home_page;
import pageObjects.Products_page;
import testBase.ReUsed;

public class TC004_Search_Products_Test extends ReUsed {


    @Test(groups= {"Sanity", "Master"})
    public void SearchTest() {
        // Creating object for Home page
    	
    	logger.info("TC004_Search_Products_test Started execution");
    	
        Home_page HP = new Home_page(driver);
        
        // Setting up the search box with the search string from the properties file
        HP.SetUpSearchBox(p.getProperty("Search_String"));
        
        // Clicking the search button
        HP.ClickSearchBtn();
        
        logger.info("Given The Search string item and verifying it ");
        // Creating object for Products page
        Products_page PP = new Products_page(driver);
        
        // Verifying if the product image is displayed
        boolean Search_Criteria_txt = PP.Verifying_Criteria_Txt();
        Assert.assertTrue(Search_Criteria_txt, "The Search_Criteria_txt is not displayed!");
        
        logger.info("TC004_Search_Products_test execution Completed");
    }
}
