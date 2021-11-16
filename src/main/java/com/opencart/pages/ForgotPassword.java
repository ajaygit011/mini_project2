package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.base.BaseClass;

public class ForgotPassword extends BaseClass {
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement inputbox;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath="//div[@class='pull-left']//a")
	WebElement backButton;
	
	@FindBy(xpath="//div[@class='list-group']//a[contains(text(),'Login')]")
	WebElement loginLink;
	
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
