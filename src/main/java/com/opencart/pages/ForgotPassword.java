package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.base.BaseClass;

public class ForgotPassword extends BaseClass {
	
	@FindBy(xpath="//input[@id='input-email']")
	@CacheLookup
	private WebElement inputbox;
	
	@FindBy(xpath="//input[@type='submit']")
	@CacheLookup
	private WebElement submitButton;
	
	@FindBy(xpath="//div[@class='pull-left']//a")
	@CacheLookup
	private WebElement backButton;
	
	@FindBy(xpath="//div[@class='list-group']//a[contains(text(),'Login')]")
	@CacheLookup
	private WebElement loginLink;
	
	public  ForgotPassword() {
	PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean inputBoxDisplayed()
	{
		return inputbox.isDisplayed();
	}
	
	public boolean sumbitButtonDisplayed()
	{
		return submitButton.isDisplayed();
	}
	
	public  void forgotPassword(String email)
	{
		inputbox.sendKeys(email);
		submitButton.click();
		//screen shot
	}
	
	public LoginPage backButtonOpration()
	{
		loginLink.click();
		return new LoginPage();
	}
}
