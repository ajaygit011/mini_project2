package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.base.BaseClass;

public class LogOutPage extends BaseClass {
	
	
	//Account Logout
	
	@FindBy(xpath="//a[contains(.,'Continue')]")
	@CacheLookup
	private WebElement logoutbutton;
	
	public LogOutPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean continuebuttonvalidation()
	{
		return logoutbutton.isDisplayed();
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage homepagevalidation()
	{
		logoutbutton.click();
		return new HomePage();
	}
}
