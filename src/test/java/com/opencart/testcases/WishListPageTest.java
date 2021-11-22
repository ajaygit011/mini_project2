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
import com.opencart.pages.WishListpage;

public class WishListPageTest extends BaseClass{
	IndexPage index;
	LoginPage login;
	HomePage home;
	WishListpage wish;
	
	public WishListPageTest()
	{
		super();
		
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initalization();
		index= new IndexPage();
		login = index.getLoginPage();
		home=login.loginFunction(prop.getProperty("email"), prop.getProperty("pass"));
		wish = home.getWishlistPage();
		log=Logger.getLogger("WishListPageTest");
	}
	
	@Test(priority=1)
	public void wishlistPageTitleTest()
	{
		String s1 =wish.titleValidation();
		Assert.assertEquals(s1, "My Wish List");
		log.info("wish list page title validation");
		
	}
	
	
	@Test(priority=2)
	public void emptyHeadingValidationTest()
	{
		boolean b1 =wish.emptyWishListValidation();
		Assert.assertTrue(b1);
		
		log.info("wishlist content validation");
	}
	
	
	@Test(priority=3)
	public void continueButtonDisplayTest()
	{
		boolean b1 = wish.continuebuttonValidation();
		Assert.assertTrue(b1);
		log.info("continue button validation");
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	

}
