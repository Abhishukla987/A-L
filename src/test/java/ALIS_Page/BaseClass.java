package ALIS_Page;

import java.io.File;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utility_Page.BrowserFactory;
import Utility_Page.ConfingDataProvider;
import Utility_Page.ConfingLoginData;
import Utility_Page.ExcelDataProvider;
import Utility_Page.Helper;

public class BaseClass {
	
		public WebDriver driver;
		public ExcelDataProvider excel;
		public ConfingDataProvider Config;
		public ConfingLoginData ConfigLogin;
		public ExtentReports report;
		public ExtentTest logger;
		
		
		
		@BeforeSuite
		public void setUpSuite()
		{
			excel = new ExcelDataProvider();
			Config= new ConfingDataProvider();
			ConfigLogin = new ConfingLoginData();
			
			Reporter.log("setting up reports and test is getting ready", true);	
			ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+  "/Reports/ALIS" + Helper.getCurrentDataTime()+" +.html"));
			report =new ExtentReports();
			report.attachReporter(extent);
			Reporter.log("setting done test can be started", true);
			

		
	    }
		
		
		@BeforeClass
		public void setup()
		{
			Reporter.log("Trying to start Browser and getting application ready", true);
	        driver=BrowserFactory.startApplication(driver, Config.getBrowser(), Config.getStagingURL());
			//driver=BrowserFactory.startApplication(driver, browser, url);
			Reporter.log("Browser and application is up and running", true);
		}
		
		
		@AfterMethod
		public void tearDownMethod(ITestResult result) throws IOException
		{
		    System.out.println(Helper.getCurrentDataTime());
			Reporter.log("Test is about to end", true);
			 if (result.getStatus()==ITestResult.FAILURE) 
			 {
				 Helper.captureScreensho(driver);
				 logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreensho(driver)).build());
			 }
			 else if(result.getStatus()==ITestResult.SUCCESS)
			 {
				 Helper.captureScreensho(driver);
				 logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreensho(driver)).build());
				 
			 }
			 report.flush();
				Reporter.log("Test Completed >>> Reports Generated", true);
					 
				 }
		@AfterClass
		public void tearDown()
		{
			BrowserFactory.quitBrowser(driver);	
		}
		

}
