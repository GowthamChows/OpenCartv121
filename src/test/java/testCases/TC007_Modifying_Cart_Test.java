package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Checkout_Page;
import pageObjects.Home_page;
import pageObjects.Products_page;

public class TC007_Modifying_Cart_Test extends ReUsed {
	
	@Test(groups = {"Regression", "Master"})
    public void Modifying_Cart_Test() {
    	
        logger.info("TC007_Modifying_Cart_Test Started Executing");
        // Creating object for Home page
        Home_page HP = new Home_page(driver);
        
       
        // Click on MacBook link
        HP.ClickOnMacBook();
       
        // Creating object for Products page
        Products_page PP = new Products_page(driver);
        
       
        // Click Add to Cart button
        PP.AddToCartBtn();
        
        
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
        logger.info("Sucessfully Item is added to the cart");
       
        PP.ClickOnFinalCart();
        
        logger.info("Navigating to the Checkout page");
        // Creating object for Checkout page
        Checkout_Page CO = new Checkout_Page(driver);
        
        CO.ClickonCheckOut();
 
        logger.info("Giving the input Value");
        CO.SetUpInputbox("2");
        
        CO.SetUpRefreshToggle();
        
        String ExpectedMessage3 = "Success: You have modified your shopping cart!";
        
        // Get the actual message text
        String ActualMessage3 = CO.getMOdifiedCartMessageText().trim(); // Remove any extra whitespace

        // Remove the close button (×) from the actual message
        if (ActualMessage3.endsWith("×")) {
        	ActualMessage3 = ActualMessage3.substring(0, ActualMessage3.length() - 2).trim();
        }
     // Assert the text
        Assert.assertEquals(ActualMessage3, ExpectedMessage3, "Alert message does not match!");
  
        logger.info("The Message Which is Expected is sucessfully displayed");
        
        logger.info("TC007_Modifying_Cart_Test has been completed successfully.");
       
    }
	

}
