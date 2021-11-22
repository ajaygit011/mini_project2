package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.base.BaseClass;

public class AddToCartPage extends BaseClass{
	
	@FindBy(xpath="//title")//Shopping Cart
	@CacheLookup
	private WebElement title;
	
	@FindBy(xpath="//a[contains(text(),'Continue')]")
	@CacheLookup
	private WebElement continuebutton;	
	
	@FindBy(xpath="//form//table[@class='table table-bordered']")
	@CacheLookup
	private WebElement itembutton;	
	
	
	
	@FindBy(xpath="//a[contains(text(),'Checkout')]")
	@CacheLookup
	private WebElement checkoutlink;//not displayed if there is no item in cart
	
	
	public AddToCartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String titleOfAddtoCart()
	{
		return driver.getTitle();
	}
	
	public boolean continuebutton()
	{
		return continuebutton.isDisplayed();
	}
	
	public boolean itemTableDisplayed()
	{
		if(itembutton.isDisplayed())
			return true;
		else
			return false;
	}
	
	public  CheckoutPage checkoutTheCart()
	{
		checkoutlink.click();
		return new CheckoutPage();
	}
}	
