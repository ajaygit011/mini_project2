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
			public void LogoTest() {
			
		
				Assert.assertTrue(index.indexPageTitleDisplayed());
				log.info("test case-2");
			}
			
			@Test(priority=2)
			public void titleTest()
			{
				Assert.assertEquals("Your Store", index.indexPageTitleName());
				
			log.info("test case -3");
			}
			
			@Test(priority=3)
			public void currencyDropDown()
			{
				
				Assert.assertEquals(index.currencyDropDownisDisplayed(), true);
				
				log.info("test case -4");
			}
			
			@Test(priority=4)
			public void doller()
			{
				
				log.info("test case -5");
			}
			@Test(priority=5)
			
			public void dropDownLinkValidation()
			{
				
				Assert.assertTrue(index.currencyDropDownisDisplayed());
				log.info("test case -6");
			}
			
			@Test(priority=6)
			public void loginPageNavigation()
			{
				
				log.info("test case -7");
			}
			
		@AfterMethod
		public void teardown()
		{
			driver.quit();
		}
			
			
			
			
			
			
}
