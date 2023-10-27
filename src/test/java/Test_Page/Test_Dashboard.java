package Test_Page;




import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import ALIS_Page.BaseClass;
import ALIS_Page.Login_Admin;
import Utility_Page.ConfingLoginData;


public class Test_Dashboard extends BaseClass{
	@Test
	
	public void loginApp() throws InterruptedException {
		logger=report.createTest("Login_A&I");
		ConfingLoginData ConfigLogin = new ConfingLoginData();
		logger.info("Starting Applicaton");
		Login_Admin Loging_page= PageFactory.initElements(driver, Login_Admin.class);
		Loging_page.loginAdmin_ALIS(ConfigLogin.getUsername(), ConfigLogin.getPassword());
		logger.pass("The TL Loging shows Success");
		
	}
	@Test(dependsOnMethods= {"loginApp"})
	
	public void Case_Managements() throws InterruptedException {
		logger=report.createTest("Case Management Page");
		logger.info("Login ALIS");
		Login_Admin Case_ManagementPage=PageFactory.initElements(driver, Login_Admin.class);
		Case_ManagementPage.Case_Management();
		logger.pass("Login Admin Page");
		
		
		
	}
	
//	
//	@Test(dependsOnMethods = {"loginApp",})
//	public void My_Info_page() throws InterruptedException, AWTException {
//		logger=report.createTest("Login ALIS Page");
//		logger.info("Login ALIS");
//		Login_Admin LogingTL_page= PageFactory.initElements(driver, Login_Admin.class);
//		LogingTL_page.My_Info();
//		logger.pass("Login by Admin");
//		
//	}

}
