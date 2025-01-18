package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver_setup {
    public static WebDriver getDriver() {
        // Set the path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\web-drivers\\chromedriver.exe");

        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();

        // Set the path to Chrome binary (optional if Chrome is installed in the default location)
        options.setBinary("C:\\web-drivers\\chrome-win64\\chrome-win64\\chrome.exe");

        // Chrome options to customize the browser behavior
        options.addArguments("--remote-allow-origins=*"); // Allow cross-origin requests
       // options.addArguments("--headless=new"); // Uncomment to run tests in headless mode
        // options.setAcceptInsecureCerts(true); // Uncomment to accept insecure SSL certificates
        // options.addArguments("--incognito"); // Uncomment to launch in incognito mode
        options.addArguments("--disable-gpu"); // Disable GPU rendering (recommended for headless mode)
        options.addArguments("--disable-extensions"); // Disable extensions
        options.addArguments("--disable-web-security"); // Disable web security (use cautiously)

        // Return the WebDriver instance
        return new ChromeDriver(options);
    }
}
