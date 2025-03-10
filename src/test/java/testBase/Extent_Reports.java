package testBase;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent_Reports implements ITestListener {

    public ExtentSparkReporter sparkReporter; // Used for configuring and creating the HTML report
    public ExtentReports extent; // Main class for generating the ExtentReports
    public ExtentTest test; // Represents individual test case logs in the report
    public String repName; // To store the name of the report

    // Called when the TestNG suite starts
    @Override
    public void onStart(ITestContext testContext) {
        // Configuring the path for the report
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName = "Test-Report-" + timeStamp + ".html";
        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);

        // Configuring the title, name, and theme of the report
        sparkReporter.config().setDocumentTitle("Opencart Automation Report"); // Title of the HTML report
        sparkReporter.config().setReportName("Opencart Functional Testing"); // Name of the test suite
        sparkReporter.config().setTheme(Theme.DARK); // Report theme (DARK or STANDARD)

        // Initializing the ExtentReports object
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "Opencart");
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customers");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");

        String os = testContext.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System", os);

        String browser = testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser", browser);

        List<String> includeGroups = testContext.getCurrentXmlTest().getIncludedGroups();
        if (!includeGroups.isEmpty()) {
            extent.setSystemInfo("Groups", includeGroups.toString());
        }
    }

    // Called when a test case passes
    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName()); // Create a new test entry in the report
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS, result.getName() + " Test Case Passed "); // Log the success message
    }

    // Called when a test case fails
    @Override
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName()); // Create a new test entry in the report
        test.assignCategory(result.getMethod().getGroups());

        test.log(Status.FAIL, result.getName() + " Test Case Failed"); // Log the failure message
        test.log(Status.INFO, result.getThrowable().getMessage()); // Log the exception/stack trace

        try {
            String imgPath = new ReUsed().captureScreen(result.getName());
            test.addScreenCaptureFromPath(imgPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Called when a test case is skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName()); // Create a new test entry in the report
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, result.getName() + " Test Case Skipped "); // Log the skip message
        test.log(Status.INFO, result.getThrowable().getMessage());
    }

    // Called when the TestNG suite finishes
    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // Write all logs to the report and finalize it

        String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
        File extentReport = new File(pathOfExtentReport);

        try {
            Desktop.getDesktop().browse(extentReport.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
