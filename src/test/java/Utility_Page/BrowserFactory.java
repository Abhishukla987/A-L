package Utility_Page;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL)
	{
		
		if (browserName.equals("Chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			
		}
		else if (browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.cherome.driver", "./Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		}
		else if (browserName.equals("IE"))
		{
			System.setProperty("webdriver.cherome.driver", "./Drivers/LICENSE.chromedriver");
			driver=new InternetExplorerDriver();
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		}
		else
		{
			System.out.println("We do not Support this Browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		return driver;
		
		
		
		
	}
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	{
		
	}

}
