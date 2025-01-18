package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriver_Setup {
    public static WebDriver getDriver() {
        // Set the path to the EdgeDriver executable
        System.setProperty("webdriver.edge.driver", "C:\\web-drivers\\edgedriver_win64\\msedgedriver.exe");
        
        // Configure EdgeOptions
        EdgeOptions options = new EdgeOptions();
        options.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
        options.addArguments("--remote-allow-origins=*");
       // options.addArguments("--headless"); // conduct the tests in the background.
        //  options.setAcceptInsecureCerts(true); // accepts the SSL certificates.
        //  options.setExperimentalOption("excludeSwithes", new String[] {"enable-automation"}); // disables the popup like controlled by the automated software
       // options.addArguments("--incognito"); // Opens the page in the incognito mode.
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-web-security");

        // Create and return the WebDriver instance
        return new EdgeDriver(options);
    }
}
