package com.opencart.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.base.BaseClass;
import com.opencart.pages.HomePage;
import com.opencart.pages.IndexPage;
import com.opencart.pages.LogOutPage;
import com.opencart.pages.LoginPage;

public class LogoutPageTest extends BaseClass {
	IndexPage index;
	HomePage home;
	LoginPage login;
	LogOutPage logout;
	
	
	public LogoutPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initalization();
		index= new IndexPage();
		login=index.getLoginPage();
		home=login.loginFunction(prop.getProperty("email"), prop.getProperty("pass"));
		logout=home.getLogoutPage();
		log=Logger.getLogger("LogoutPageTest");
		
		
	}
	
	@Test(priority=1)
	public void titlevalidationTest() 
	{
		String s1=logout.getTitle();
		Assert.assertEquals("Account Logout", s1);
		log.info("logout page title validation");
	}
	
	@Test(priority=2)
	public void buttonvalidationTest()
	{
		Assert.assertTrue(logout.continuebuttonvalidation());
		log.info("validation of button on logout page");
	}
	
	@Test(priority=3)
	public void continuebuttonclickTest()
	{
		Assert.assertTrue(logout.continuebuttonvalidation());
		log.info("validation of action of logout button");
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	

}
