package com.opencart.base;



import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log;
	
	
	public BaseClass()
	{
		PropertyConfigurator.configure("Log4j.properties");
		try
		{
			prop = new Properties();
		//	String path = "C:\\Users\\ajay_bhave\\eclipse-workspace\\OpenCart\\src\\main\\java\\com\\opencart\\config\\config.properties";
			FileInputStream fis = new FileInputStream("C:\\Users\\ajay_bhave\\eclipse-workspace\\OpenCart\\src\\main\\java\\com\\opencart\\config\\config.properties");
			prop.load(fis);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}	
		
	
		public static void initalization()
		{
		
		String browser_name=prop.getProperty("web_browser");
	
		
		if(browser_name.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./exe_file/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			
		}
}




