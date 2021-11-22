package com.opencart.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.base.BaseClass;
import com.opencart.pages.HomePage;
import com.opencart.pages.IndexPage;
import com.opencart.pages.LoginPage;

public class LoginPageTest extends BaseClass{
		
	public IndexPage index;
	public LoginPage login;
	public HomePage homepage;
	
	public LoginPageTest()
	{
		super();
		
	}
	@BeforeMethod
	public void setUp()
	{
		initalization();
		index=new IndexPage();
		login=index.getLoginPage();
		log=Logger.getLogger("LoginPageTest");

	}
	
	@Test(priority=1)
	public void loginTestTest() 
	{
		String s1= prop.getProperty("email");
		String s2=prop.getProperty("pass");
		homepage=login.loginFunction(s1, s2);
		
		log=Logger.getLogger("Login functionality of login page");
		
	}
	
	@Test(priority=3,dependsOnMethods= {"linkTextValidationTest"})
	public void cssPropertyTestTest()
	{
		String cssval = login.placeHolderValidation();
		Assert.assertEquals("E-Mail Address", cssval);
		
		
		log.info("validation of placeholder property in login page");
		
		//testcase skipped 
	}
	
	
	@Test(priority=2)
	public void linkTextValidationTest()
	{
		Assert.assertEquals("Forgotten Password", login.linkTextValidatiion());
		//test case fail
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
