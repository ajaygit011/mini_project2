package com.opencart.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.base.BaseClass;
import com.opencart.pages.IndexPage;

public class IndexPageTest	extends BaseClass {
	IndexPage index;
	
	IndexPageTest()
	{
	
		super();
		
	}
	@BeforeMethod
	public void setUp()
	{
		initalization();
		index=new IndexPage();
		log=Logger.getLogger("IndexPageTest");
	}
	
	
	@Test(priority=1)
	public void LogoTextTest() 
	{
		Assert.assertTrue(index.indexPageTitleDisplayed());
		log.info("index page validation test case");
	}
			
	@Test(priority=2)
	public void titleTest()
	{
		Assert.assertEquals("Your Store", index.indexPageTitleName());
		log.info("index page title validation ");
	}
			
	@Test(priority=3)
	public void currencyDropDownTest()
	{
				
		Assert.assertEquals(index.currencyDropDownisDisplayed(), true);
		log.info("index page dropdown validation");
	}
			
	@Test(priority=4)
	public void dollerSymbolTest()
	{
		String s1=index.currncyDoller();
		Assert.assertEquals("€ Euro", s1);
		log.info("index page currency dropdown validation");
	}
			
	@Test(priority=5)
	public void dropDownLinkValidationTest()
	{
				
		Assert.assertTrue(index.currencyDropDownisDisplayed());
		log.info("index page currency dropdown validation ");
	}
			
	@Test(priority=6)
	public void loginPageNavigationTest()
	{	
		Assert.assertTrue(index.dropdown());
		log.info("index page navigation to login page validation");
	}
			
	@Test(priority=7)
	public void searchbarValidationTest()
	{
		Assert.assertTrue(index.searchbar());
		log.info("search - bar validation ");
	}
			
			
			
		@AfterMethod
		public void teardown()
		{
			driver.quit();
		}
			
			
			
			
			
			
}
