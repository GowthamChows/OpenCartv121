package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Checkout_Page;
import pageObjects.Home_page;
import pageObjects.Products_page;

public class TC006_Checkout_Test extends ReUsed {
	
	@Test(groups = {"Sanity", "Master"})
    public void Add_to_Cart_and_Checkout() {
		
		
		logger.info("TC006_Checkout_Test Started Executing");
    	
        logger.info("Navigating to the Home Page");
        // Creating object for Home page
        Home_page HP = new Home_page(driver);
        
        logger.info("TC006_Checkout_Test Execution Started");
        // Click on MacBook link
        HP.ClickOnMacBook();
       
        // Creating object for Products page
        Products_page PP = new Products_page(driver);
        
        logger.info("Clicking on the Add to Cart button");
        // Click Add to Cart button
        PP.AddToCartBtn();
        
        logger.info("Navigating to the Cart page");
        PP.ClickOnFinalCart();
        
        logger.info("Navigating to the Checkout page");
        // Creating object for Checkout page
        Checkout_Page CO = new Checkout_Page(driver);
        
        CO.ClickonCheckOut();
        
        CO.ClickonFinalCheckOut();
        
        logger.info("Verifying the success text");
        // Expected success message
        String ExpectedMessage = "Products marked with *** are not available in the desired quantity or not in stock!";
        
        // Get the actual message text
        String ActualMessage = CO.getOUtOFSTOCKMessageText().trim(); // Remove any extra whitespace

        // Remove the close button (×) from the actual message
        if (ActualMessage.endsWith("×")) {
        	ActualMessage = ActualMessage.substring(0, ActualMessage.length() - 2).trim();
        }

        // Assert the text
        Assert.assertEquals(ActualMessage, ExpectedMessage, "Alert message does not match!");
        
        logger.info("THe Sucess txt is displayed As expected");
  
        logger.info("Checkout test has been completed successfully.");
       
    }
	
}
	
	
	
	
	
	
	
	

