package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Home_page;
import pageObjects.Products_page;

public class TC005_Add_to_Cart_Test extends ReUsed {
	 
    @Test(groups = {"Regression", "Master"})
    public void Add_to_Cart() {

        logger.info("TC005_Add_to_Cart_Test Started Executing");
    	
        logger.info("Navigating to the Home Page");
        // Creating object for Home page
        Home_page HP = new Home_page(driver);
        
        logger.info("Clicking on the MacBook");
        // Click on MacBook link
        HP.ClickOnMacBook();
       
        // Creating object for Products page
        Products_page PP = new Products_page(driver);
        
        logger.info("Clicking on the Add to Cart button");
        // Click Add to Cart button
        PP.AddToCartBtn();
        
        logger.info("Verifying the success text");
        // Expected success message
        String expectedMessage = "Success: You have added MacBook to your shopping cart!";
        
        // Get the actual message text
        String actualMessage = PP.getAlertMessageText().trim(); // Remove any extra whitespace

        // Remove the close button (×) from the actual message
        if (actualMessage.endsWith("×")) {
            actualMessage = actualMessage.substring(0, actualMessage.length() - 2).trim();
        }

        // Assert the text
        Assert.assertEquals(actualMessage, expectedMessage, "Alert message does not match!");
        logger.info("Sucess Text is As Expected");
        
        logger.info("Add to Cart test has been completed");
    }
}
