package testCases;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Home_page;
import pageObjects.Login_page;
import pageObjects.MyAccount_Page;
import pageObjects.Products_page;
import pageObjects.WishlistPage;

public class TC008_Add_to_Wishlist_Test  extends ReUsed {

	
	//  @Test(dependsOnMethods = "testCases.LoginTest.loginTest")

		
		@Test(groups = {"Regression", "Master"})
	    public void AddingItems_to_Cart() {
	    	
	        logger.info("TC008_Add_to_Wishlist_Test Started Executing");
	        // Creating object for Home page
	        Home_page HP = new Home_page(driver);
	        Products_page PP=new Products_page(driver);
	        Login_page LP=new Login_page(driver);
	        WishlistPage WP = new WishlistPage(driver);
	        
	        logger.info("Logging into the Account");
	        HP.clickonMyAccount(); 
	        HP.ClickOnLogin(); 

	        LP.SetUpEmail(p.getProperty("Login_EMAIL"));
	        LP.SetUpPassword(p.getProperty("Login_PASSWORD"));
	        LP.ClickOnLoginBtn();
	        
	        logger.info("Removing the Prevous Products from the Wishlist");
	        WP.ClickOn_WishlistBtn();
	        WP.ClickOnRemovebtn();
	        WP.ClickonRemovebtn_2();
	        
	       
	        
	        HP.ClickOnTablets();
	 	    PP.ClickOn_SamSung_Product();
	 	    PP.ClickOnWishListBtn();
	 	   logger.info("Samsung Galaxy Tab 10.1 Added to WishList");
	 	   
	 	   
	        // Click on MacBook link
	 	     HP.ClickOnTablets();
	         HP.ClickOnCameras();
	         HP.ClickOnCanon_Item();
	         PP.ClickOnWishListBtn();
	        logger.info("Cannon Added to the wishlist");
	         
	 	   
		}
	       
		@Test(groups = {"Regression", "Master"})
	    public void Verifying_The_Items_in_the_Wishlist() {  
			
	        WishlistPage WP = new WishlistPage(driver);
	        MyAccount_Page AP=new MyAccount_Page(driver);
	        
	        
	        WP.ClickOn_WishlistBtn();

	        logger.info("On Wishlist Page");
	        // Fetch the actual data from the wishlist table
	        List<Map<String, String>> actualWishlistData = WP.getWishlistData();

	        // Define the expected data
	        String[][] expectedData = {
	            {"Canon EOS 5D", "Product 3", "2-3 Days", "$98.00 $122.00"},
	            {"Samsung Galaxy Tab 10.1", "SAM1", "Pre-Order", "$241.99"}
	        };

	        // Assert the size of the wishlist
	        Assert.assertEquals(actualWishlistData.size(), expectedData.length, "Number of products mismatch!");

	        // Assert each product's details
	        for (int i = 0; i < expectedData.length; i++) {
	            Map<String, String> product = actualWishlistData.get(i);
	            Assert.assertEquals(product.get("Product Name"), expectedData[i][0], "Product name mismatch!");
	            Assert.assertEquals(product.get("Model"), expectedData[i][1], "Model mismatch!");
	            Assert.assertEquals(product.get("Stock"), expectedData[i][2], "Stock status mismatch!");
	            Assert.assertEquals(product.get("Unit Price"), expectedData[i][3], "Unit price mismatch!");
	            
	        }
	        
	        WP.ClickOn_WishlistBtn();
	        WP.ClickOnRemovebtn();
	        WP.ClickonRemovebtn_2();
	        
	        AP.ClickOnLogoutbtn();
	        logger.info("Account Logged Out");
	        logger.info("TC008_Add_to_Wishlist_Test Finished Sucessfully");
	        
	    }
	}