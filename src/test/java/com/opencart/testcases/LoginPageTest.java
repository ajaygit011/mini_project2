package com.opencart.testcases;

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
	}
	
	@Test(priority=1)
	public void loginTest() throws InterruptedException
	{
		String s1= property.getProperty("email");
		String s2=property.getProperty("pass");
		homepage=login.loginFunction(s1, s2);
		Thread.sleep(3000);
		
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
