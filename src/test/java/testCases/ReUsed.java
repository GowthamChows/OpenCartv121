package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import config.Driver_setup;
import config.EdgeDriver_Setup;


public class ReUsed {
    public static WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass(groups = {"Sanity", "Master", "Regression"})
    @Parameters({"os", "browser"})
    public void SetUp(String os, String br) throws IOException {
        logger = LogManager.getLogger(this.getClass());

        // Load the Properties File
        FileReader file = new FileReader("./src/test/resources/config.properties");
        p = new Properties();
        p.load(file);

        DesiredCapabilities capabilities = new DesiredCapabilities();

        String executionEnv = p.getProperty("execution_env");
        if ("remote".equalsIgnoreCase(executionEnv)) {
            // Set Platform
            switch (os.toLowerCase()) {
                case "windows":
                    capabilities.setPlatform(Platform.WIN11);
                    break;
                case "mac":
                    capabilities.setPlatform(Platform.MAC);
                    break;
                case "linux":
                    capabilities.setPlatform(Platform.LINUX);
                    break;
                default:
                    logger.error("No Matching OS Found");
                    return;
            }

            // Set Browser
            switch (br.toLowerCase()) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;
                case "edge":
                    capabilities.setBrowserName("MicrosoftEdge");
                    break;
                case "firefox":
                    capabilities.setBrowserName("firefox");
                    break;
                default:
                    logger.error("Invalid Browser Name");
                    return;
            }

            // Connect to Selenium Grid
            String gridUrl = p.getProperty("SELENIUM_GRID_URL");
            driver = new RemoteWebDriver(new URL(gridUrl), capabilities);

        } else if ("local".equalsIgnoreCase(executionEnv)) {
            // Execute Locally
            switch (br.toLowerCase()) {
                case "chrome":
                    driver = Driver_setup.getDriver(); // Chrome Driver Setup
                    break;
                case "edge":
                    driver = EdgeDriver_Setup.getDriver(); // Edge Driver Setup
                    break;
                default:
                    logger.error("Invalid Browser Name");
                    return;
            }
        } else {
            logger.error("Invalid execution_env in properties file");
            return;
        }

        // Common Driver Setup
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("BASE_URL"));
        driver.manage().window().maximize();
    }

    @AfterClass(groups = {"Sanity", "Master", "Regression"})
    void TearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Driver closed successfully.");
        }
    }

    // Reusable Random Generated String Values
    public String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String RandomAlphaNumeric() {
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        String generatedNumber = RandomStringUtils.randomNumeric(3);
        return generatedNumber + generatedString;
    }

    public String captureScreen(String tname) throws IOException {
        // Generate a timestamp for unique file naming
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        // Take the screenshot
        TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
        File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);

        // Define the target file path
        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "-" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        // Copy file reliably
        Files.copy(sourceFile.toPath(), targetFile.toPath());

        return targetFilePath;
    }
}








/*package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import config.Driver_setup;
import config.EdgeDriver_Setup;



public class ReUsed {
    public static WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass(groups = {"Sanity", "Master", "Regression",})
    @Parameters({"os", "browser"})
    public void SetUp(String os, String br) throws IOException {
        logger = LogManager.getLogger(this.getClass());

        // Load the Properties File
        FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
            // Set Platform
            if (os.equalsIgnoreCase("windows"))
            {
                capabilities.setPlatform(Platform.WIN11);
            } 
            else if (os.equalsIgnoreCase("mac"))
            {
                capabilities.setPlatform(Platform.MAC);
            } 
            else if (os.equalsIgnoreCase("Linux"))
            {
                capabilities.setPlatform(Platform.LINUX);
            }
            
            else {
                System.out.println("No Matching OS Found");
                return;
            }

            // Set Browser
            switch (br.toLowerCase()) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;
                case "edge":
                    capabilities.setBrowserName("MicrosoftEdge");
                    break;
                    
                case"firefox":
                	capabilities.setBrowserName("firefox");
                    break;
                	
                default:
                    System.out.println("Invalid Browser Name");
                    return;
            }

            // Connect to Selenium Grid
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

        } else if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
            // Execute Locally
            switch (br.toLowerCase()) {
                case "chrome":
                    driver = Driver_setup.getDriver(); // Chrome Driver Setup
                    break;
                case "edge":
                    driver = EdgeDriver_Setup.getDriver(); // Edge Driver Setup
                    break;
                default:
                    System.out.println("Invalid Browser Name");
                    return;
            }
        } else {
            System.out.println("Invalid execution_env in properties file");
            return;
        }

        // Common Driver Setup
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("BASE_URL"));
        driver.manage().window().maximize();
    }

    @AfterClass(groups = {"Sanity", "Master", "Regression"})
    void TearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Reusable Random Generated String Values
    public String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String RandomAlphaNumeric() {
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        String generatedNumber = RandomStringUtils.randomNumeric(3);
        return generatedNumber + generatedString;
    }

    public String captureScreen(String tname) throws IOException {
        // Generate a timestamp for unique file naming
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        // Take the screenshot
        TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
        File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);

        // Define the target file path
        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "-" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }
}



/*package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import config.Driver_setup;
import config.EdgeDriver_Setup;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.TakesScreenshot;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReUsed {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
		
	@BeforeClass(groups= {"Sanity","Master","Regression"})
	@Parameters({"os", "browser"})
	public void SetUp(String os, String br) throws IOException {

	    logger = LogManager.getLogger(this.getClass());
	    
	    
	    DesiredCapabilities capabilities = new DesiredCapabilities();

        if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
            // Set Platform
            if (os.equalsIgnoreCase("windows")) {
                capabilities.setPlatform(Platform.WIN11);
            } else if (os.equalsIgnoreCase("mac")) {
                capabilities.setPlatform(Platform.MAC);
            } else {
                System.out.println("No Matching OS Found");
                return;
            }

            // Set Browser
            switch (br.toLowerCase()) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;
                case "edge":
                    capabilities.setBrowserName("MicrosoftEdge");
                    break;
                default:
                    System.out.println("Invalid Browser Name");
                    return;
            }

            // Connect to Selenium Grid
            driver = new RemoteWebDriver(new URL(p.getProperty("SELENIUM_GRID_URL")), capabilities);
	    
	    if(p.getProperty("exectuion_env").equalsIgnoreCase("remote"))
	    {
	    
	    switch (br.toLowerCase()) {
	        case "chrome":
	            driver = Driver_setup.getDriver(); // Assume this is for Chrome
	            break;
	        case "edge":
	            driver = EdgeDriver_Setup.getDriver();
	            break;
	        default:
	            System.out.println("Invalid Browser Name");
	            return;
	    }
     
		//Loading the Properties File
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		
		//driver = Driver_setup.getDriver();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get(p.getProperty("BASE_URL"));
	    driver.manage().window().maximize();
	}

	@AfterClass (groups= {"Sanity","Master","Regression"})
	void TearDown() {
		driver.quit();
	}
	
	
	
	
	// Reusuable Random Generated String Values Like (random NAme, Random Number, Random Mail, Random Password).
	
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber() {
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	
	public String RandomAlphaNumeric()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		String generatedNumber=RandomStringUtils.randomNumeric(3);
		return generatedNumber+generatedString;
	}
	
	 public String captureScreen(String tname) throws IOException {
	        // Generate a timestamp for unique file naming
	        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

	        // Take the screenshot
	        TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
	        File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);

	        // Define the target file path
	        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "-" + timeStamp + ".png";
	        File targetFile = new File(targetFilePath);
	        
	        sourceFile.renameTo(targetFile);
	        
	        return targetFilePath;
	    }

}
		*/

