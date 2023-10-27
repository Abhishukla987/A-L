package ALIS_Page;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Login_Admin {
	WebDriver driver;
	public Login_Admin(WebDriver ldriver) 
	{
		this.driver =ldriver;
		
	}
	//@FindBy
	
	@FindBy(xpath="//select[@id='ddlBusinessUnits2']") WebElement xchoose;
	@FindBy(xpath="//a[@id='btnOk']") WebElement Ok;
	
	
//	
//	@FindBy(xpath="//input[@id='m_LoginControl_UserName']") WebElement Uname;
//	@FindBy(xpath="//input[@id='m_LoginControl_Password']") WebElement Password;
//	@FindBy(xpath="//a[@id='m_LoginControl_lnkTest']") WebElement Login;
//	
//	
	
	@FindBy(xpath="//input[@name='m_LoginControl$UserName']") WebElement Uname;
	@FindBy(xpath="//input[@name='m_LoginControl$Password']") WebElement Password;
	@FindBy(xpath="//a[@id='m_LoginControl_lnkTest']") WebElement Login;
	
	
	
	@FindBy(xpath="(//a[@class='ctl00_InternalMenu_ucMenu_1 InternalStaticMenuItem ctl00_InternalMenu_ucMenu_3'])[5]") WebElement Select_Case_Management;
	@FindBy(xpath="(//a[@class='ctl00_InternalMenu_ucMenu_1 InternalDynamicMenuItem ctl00_InternalMenu_ucMenu_5'])[50]") WebElement Select_Complaint;
	@FindBy(xpath="//*[@id=\"ctl00_InternalMenu_ucMenun64\"]/td/table/tbody/tr/td/a") WebElement Click_new;
	@FindBy(xpath="//select[@name='ctl00$ContentPlaceHolder1$ucInternalBusinessUnitProgram$ddlIntakeType']") WebElement Intake_Type;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ucComplainantInformation_ddlPrefferedLanguage\"]") WebElement Preferred_Language;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$ucComplainantInformation$txtLastName']") WebElement Lname;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$ucComplainantInformation$txtFirstName']") WebElement Fname;
	@FindBy(xpath="//a[@class='ClassHyperLink']") WebElement Add_Complainant;
	

//Additional Complainant information
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$ucComplainantInformation$txtLastName']") WebElement Complainant_Lname;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$ucComplainantInformation$txtFirstName']") WebElement Complainant_Fname;	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_btnSave\"]") WebElement Complainant_Submit;
	
	
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ucComplaintInformation_ddlReceivedBy\"]") WebElement Received_By;
	@FindBy(xpath="//textarea[@name='ctl00$ContentPlaceHolder1$ucComplaintInformation$txtComplaintDescription']") WebElement Complaint_desc;
	@FindBy(xpath="//input[@type='button']") WebElement Click_Save;
	
	//@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6") WebElement Dashbord;
	//@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[1]/a/div[2]/img") WebElement Orange_Icon;
	
	
// Complaint Search
	@FindBy(xpath="//*[@id=\"ctl00_InternalMenu_ucMenun65\"]/td/table/tbody/tr/td/a") WebElement Modify;
	@FindBy(xpath="//select[@name='ctl00$ContentPlaceHolder1$ucComplaintSearch$ddlAssignedStaff']") WebElement Assigned_Staff;
	@FindBy(xpath="//input[@name='ctl00_ContentPlaceHolder1_ucComplaintSearch_dtOpenDate_txtFromDate']") WebElement Open_Date;
	@FindBy(xpath="//input[@name='ctl00$ContentPlaceHolder1$ucComplaintSearch$dtOpenDate$txtFromDate']") WebElement Opens_Date;
	@FindBy(xpath="//*[@id=\"ctl00_ContentPlaceHolder1_ucSearchButtonPanel_btnSearchButton\"]/span") WebElement Complaint_Search;
	@FindBy(xpath="//input[@type='submit']") WebElement Current_Date;
	@FindBy(xpath="//span[@id='ctl00_ContentPlaceHolder1_ucComplaintSearchResult_lblSectionHeader']") WebElement Search_Result;
	@FindBy(xpath="//img[@border='0']") WebElement Complaint_Filter;
	@FindBy(xpath="(//td[@class='tdClass'])[1]") List<WebElement> Choose_Complaint;
	@FindBy(xpath="//a[@id='ctl00_ContentPlaceHolder1_ucComplaintSearchResult_ResultsGrid_ctl02_lnkComplaintId']") WebElement Select_First;
	@FindBy(xpath="//span[@id='ctl00_lblPageTitle']") WebElement Modify_Complaint;
	
	
	
	
//Modify Complaint Page
	
	@FindBy(xpath="//a[@id='ctl00_ContentPlaceHolder1_ucPrimaryComplainantAdditionalDetails_grdOwnersInfo_linkAddNewRecord']") WebElement Complainant_Add;
	
	
	
	
	
	
//Complainant Additional Contact Information
	@FindBy(xpath="//span[@id='ctl00_lblPageTitle']") WebElement Complainant_Page;
	
	
	
//@My_Info_Page
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a/span") WebElement info;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[1]/h6") WebElement Profile_name;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input") WebElement First_name;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input") WebElement first;
	
	public void Time_sleep() {
		try {
			Thread.sleep(5000);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void loginAdmin_ALIS(String usernameApplication, String passwordApplication) throws InterruptedException
	{
		//xchoose.click();
		//Select Health=new Select(xchoose);
		//Health.selectByVisibleText("Health Care Quality & Compliance");
		//Ok.click();
		
	//	driver.switchTo().alert().getText();
	//	driver.switchTo().alert().dismiss();
		Uname.sendKeys(usernameApplication);
		Password.sendKeys(passwordApplication);
		Login.click();
		driver.getTitle();
		//System.out.println(Dashbord.getText());

		//System.out.println(Orange_Icon.getText());
		//Orange_Icon.click();
		
		
	}
	public void My_Info() throws InterruptedException {
		info.click();
		
		//System.out.println(Profile_name.getText());
		
		Thread.sleep(5000);
		Actions action=new Actions(driver);
		action.click();
		
		First_name.clear();
		Thread.sleep(10000);
		First_name.sendKeys("Abhishek");
		
		
	}
	
	public void Case_Management() throws InterruptedException {
		Time_sleep();
		//Select select=new Select(Select_Case_Management);
		//select.deselectByVisibleText("Select_Complaint");
		Actions action=new Actions(driver);
		
		//action.moveToElement(Select_Case_Management).perform();
		action.moveToElement(Select_Case_Management).moveToElement(Select_Complaint).perform();
		Click_new.click();
		
		Select select=new Select(Intake_Type);
		select.selectByVisibleText("Paper");
		Thread.sleep(10000);
		
		Preferred_Language.click();
		Select Select_Lan=new Select(Preferred_Language);
		Select_Lan.selectByValue("en");
	//	Select_Lan.selectByVisibleText("English");
		Lname.sendKeys("Mark");
		Fname.sendKeys("William");
		Add_Complainant.click();
		Complaint_desc.sendKeys("Testing");
		Received_By.click();
		Select Select_rec=new Select(Received_By);
		Select_rec.selectByValue("1");
		
		
//Additional Complainant information
		Thread.sleep(10000);
		//driver.switchTo().window();
		
		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
		    driver.switchTo().window(windowHandle);
		}
	//	WebElement newWindowElement = driver.findElement(By.id("element-on-new-window"));
		WebElement newWindowElement = Complainant_Lname;
		newWindowElement.sendKeys("Jack");
		Complainant_Fname.sendKeys("Karl");
		Complainant_Submit.click();
		//driver.switchTo().window(originalWindowHandle);
		//driver.switchTo().defaultContent();
	//	driver.navigate().forward();
	//	driver.navigate().back();
		//driver.navigate().refresh();
		driver.getWindowHandle();
		
//		
//		String originalWindowHandle = driver.getWindowHandle();  // Store the original window handle
////
////		// ... Perform actions on the new window ...
////
////		// Switch back to the original window
//		driver.switchTo().window(originalWindowHandle);
//		driver.switchTo().defaultContent();
			
		
//		String originalWindowHandle = driver.getWindowHandle();
//		driver.switchTo().window(originalWindowHandle);
		
		

		Click_Save.click();
			
		
	}

	public void Complaint_Search() {
		Time_sleep();
		Actions action=new Actions(driver);
		action.moveToElement(Select_Case_Management).moveToElement(Select_Complaint).perform();
		Modify.click();
		Select Assigned=new Select(Assigned_Staff);
		Assigned.selectByVisibleText("All");
		
		
//		Open_Date.click();
//		Date currentDate = new Date();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		String formattedDate = dateFormat.format(currentDate);
//		System.out.println(formattedDate);
//		Set<String> windowHandles = driver.getWindowHandles();
//		for (String windowHandle : windowHandles) {
//		    driver.switchTo().window(windowHandle);
//		}
//		Current_Date.click();
//		
		

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String yesterdayDate = dateFormat.format(calendar.getTime());
		System.out.println(yesterdayDate);
		Opens_Date.sendKeys(yesterdayDate);
		Complaint_Search.click();
		Time_sleep();
		String actual=Search_Result.getText();
		String expected="Search Result";
		if(expected.equals(actual))
		{
			System.out.println("Text matches the expected text.");
		}
		else
		{
			System.out.println("Text does not match the expected text.");
		}
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Scroll down by a specified number of pixels
	        int scrollPixels = 500; // Adjust the value as needed
	        js.executeScript("window.scrollBy(0, " + scrollPixels + ");");
		Time_sleep();
		
//		  double maxNumber = Double.NEGATIVE_INFINITY; 
//	        WebElement elementWithMaxNumber = null;
//	        for (WebElement element :Choose_Complaint ) {
//	            String text = element.getText();
//	            try {
//	                double number = Double.parseDouble(text);  // Assuming the numbers are in decimal format
//	                if (number > maxNumber) {
//	                    maxNumber = number;
//	                    elementWithMaxNumber = element;
//	                }
//	            } catch (NumberFormatException e) {
//	                // Handle non-numeric values or errors
//	            }
//	            	            
//	        }
//	        
//	        if (elementWithMaxNumber != null) {
//	            // For example, click the element or perform some action
//	            elementWithMaxNumber.click();
//	            System.out.println("Clicked the element with the maximum number: " + maxNumber);
//	        } else {
//	            System.out.println("No valid numbers found");
//	        }
//
//	        elementWithMaxNumber.click();
//	        
	       
		
//		 List<String> all_elements_text=new ArrayList<>();
//		    //If you want to get all elements text into array list
//
//		    for(int i=0; i<Choose_Complaint.size(); i++){
//
//		        all_elements_text.add(Choose_Complaint.get(i).getText());
//		        //loading text of each element in to array all_elements_text
//		       // System.out.println(Choose_Complaint.get(i).getText());
//		        
//		    }
//		    
//		    Object obj = Collections.max(all_elements_text);
//
//		    System.out.println(obj);
//		    
		
		
		
		
		
		
		
		
//		
//	    CharSequence option="Highest to lowest";
//	    for(int i=0; i<Choose_Complaint.size(); i++)
//	    {
//	    	if(Choose_Complaint.get(i).getText().contains(option))
//	    	{
//	    		Choose_Complaint.get(i).click();
//	    		System.out.println("Highest no.");
//	    	}
//	    }
	    
	    
		Complaint_Filter.click();
		//Select_First.click();
		Select_First.click();
		
		Time_sleep();
		
	        String newactual=Modify_Complaint.getText();
	        System.out.println(Modify_Complaint.getText());
	        String newexpected="Modify Complaint";
	        
	        if(newactual.equals(newexpected)) {
	        	System.out.println("This text is matches");
	        
	        }
	        else {
	        	System.out.println("Text does not match");
	        	
	        	
	        }
	        Time_sleep();
	       // System.out.println(newexpected.getText());
	        
		
	        
	        Complainant_Add.click();
	        
	        
	        String newactual2=Complainant_Page.getText();
	        System.out.println(Complainant_Page.getText());
	        String newexpected2="Complainant Additional Contact Information";
	        
	        if(newactual2.equals(newexpected2)) {
	        	System.out.println("This text is matches");
	        
	        }
	        else {
	        	System.out.println("Text does not match");
	        	
	        	
	        }
		
		
	}
}
