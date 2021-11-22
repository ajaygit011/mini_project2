package com.opencart.testcases;

import static com.opencart.utils.OpencartUtils.takeScreenShot;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opencart.base.BaseClass;
import com.opencart.pages.AddToCartPage;
import com.opencart.pages.HomePage;
import com.opencart.pages.IndexPage;
import com.opencart.pages.LoginPage;

public class AddToCartTest  extends BaseClass {
	IndexPage index;
	LoginPage login;
	HomePage home;
	AddToCartPage cart;
	AddToCartPage cart_2;
	
	public AddToCartTest()
	{
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp()
	{
		initalization();
		index = new IndexPage();
		login = index.getLoginPage();
		home=login.loginFunction(prop.getProperty("email"), prop.getProperty("pass"));
		cart=home.cartpage();
		log=Logger.getLogger("AddToCartTest");
	}
	
	
	@Test(priority=1)
	public void CartPageTitle()
	{
		String s1 =cart.titleOfAddtoCart();
		
		Assert.assertEquals("Shopping Cart", s1);
		
		log.info("test case to validate Title of Shopping Cart Page");
	}
	
	@Test(priority=2)
	public void continuebutton()
	{
		Assert.assertTrue(cart.continuebutton());
		
		log.info("test case to validate continue button in cart page");
	}
	
	
	@Test(priority=3)
	public void productInCart()
	{
		Assert.assertTrue(cart.itemTableDisplayed());
		
		log.info("test case to check the item in cart");
		
	}
	
	
	@Test
	public void endToEnd()
	{
		cart_2=home.addingItemToCart();
		cart_2.checkoutTheCart();
	try
	{
		takeScreenShot("checkoutpage");
	}
	catch(Exception e)
	{
		log.info("exception caught");
	}
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
