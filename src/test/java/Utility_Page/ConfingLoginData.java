package Utility_Page;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfingLoginData {

	Properties pro;
	public ConfingLoginData() {
		File src=new File(".\\Config\\Login.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro =new Properties();
			pro.load(fis);
		
		}
		catch (Exception e) 
		{
			System.out.println("Not able to load config file>>"+e.getMessage());
		}
		
		
	}
	
	
	public String getDataFromLogin(String KeyTosearch)
	{
		return pro.getProperty(KeyTosearch);
		
	}
		
	public String getUsername()
	{
		return pro.getProperty("Username");
	}
	public String getPassword()
	{
		return pro.getProperty("Password");
	}



	

}
