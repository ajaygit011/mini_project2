package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.base.BaseClass;

public class WishListpage extends BaseClass{
	
	@FindBy(xpath="//a[contains(text(),'Continue')]")
	@CacheLookup
	private WebElement continuebutto;
	
	
	@FindBy(xpath="//p[contains(text(),'Your wish list is empty.')]")
	@CacheLookup
	private WebElement 	emptytitle;
	
	@FindBy(xpath="//a[contains(text(),'Continue')]")
	@CacheLookup
	private WebElement continuebutton;	
	
	public WishListpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//My Wish List
	
	public boolean continuebuttonValidation()
	{
		return continuebutton.isDisplayed();
	}
	
	public String titleValidation()
	{
		return driver.getTitle();
	}

	public boolean emptyWishListValidation()
	{
		return emptytitle.isDisplayed();
	}
}
