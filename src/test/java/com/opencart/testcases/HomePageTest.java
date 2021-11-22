package com.opencart.testcases;

import static com.opencart.utils.OpencartUtils.takeScreenShot;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.base.BaseClass;
import com.opencart.pages.HomePage;
import com.opencart.pages.IndexPage;
import com.opencart.pages.LoginPage;
import com.opencart.utils.OpencartUtils;

public class HomePageTest extends BaseClass{
	IndexPage index;
	LoginPage login;
	HomePage home;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initalization();
		index = new IndexPage();
		login=index.getLoginPage();
		String s1= prop.getProperty("email");
		String s2=prop.getProperty("pass");
		home=login.loginFunction(s1, s2);
		log=Logger.getLogger("HomePageTest");
	
	}
	
	@Test(priority=1)
	public void searchfieldTest()
	{
		boolean b =home.searchboxvalidation();
		Assert.assertTrue(b);
		log.info("search box validation");
		
	}
	
	@Test(priority=2)
	public void addtocartvalidation()
	{
		boolean b =home.addtocartvalidation();
		Assert.assertTrue(b);
		log.info("addtocart validation");
		
	}
	
	@Test(priority=3)
	public void searchOpration()
	{
	
		home.search("phone");
		
	try {
			takeScreenShot("phone_ss");
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		log.info("taking screen shot of searched item");
		//Assert.assertTrue(b);
		
	}
	
	
	@Test(priority=4)
	public void mouseovervalidation() throws IOException
	{
		home.mouseOver();
		OpencartUtils.takeScreenShot("mouse_over");
		log.info("mouse over opration validation");
		
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	

}
