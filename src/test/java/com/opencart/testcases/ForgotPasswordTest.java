package com.opencart.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.base.BaseClass;
import com.opencart.pages.ForgotPassword;
import com.opencart.pages.IndexPage;
import com.opencart.pages.LoginPage;

public class ForgotPasswordTest extends BaseClass{
	IndexPage index;
	LoginPage login;
	ForgotPassword fpass;
	ForgotPasswordTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		initalization();
		index = new IndexPage();
		login = index.getLoginPage();
		fpass= login.forgotPasswordLink();
	
		log=Logger.getLogger("ForgotPasswordTest");
		
	}
	
	@Test(priority=1)
	public void validateTitle()
	{
		String title = "Account Login";
		Assert.assertEquals(title, fpass.getPageTitle(),"not matched");
		log.info("title validation ");
		
	}
	
	@Test(priority=2)
	public void validateInputBox()
	{
		Assert.assertTrue(fpass.inputBoxDisplayed());
		log.info("input box validation");
	}
	
	@Test(priority=3)
	public void validateSubmitButton()
	{
		Assert.assertTrue(fpass.sumbitButtonDisplayed());
		log.info("submit button validation");
	}
	
	@Test(priority=4)
	public void validateBackButtonOpration()
	{
		LoginPage loginpage = fpass.backButtonOpration();
		log.info(loginpage);
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}
