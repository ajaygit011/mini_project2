package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.base.BaseClass;

public class LoginPage extends BaseClass {
	
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailField;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//img[@title='Your Store']")
	WebElement logo;
	
	@FindBy(xpath="//a[text()='Forgotten Password']//preceding-sibling::input")
	WebElement forgotPassword;
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public HomePage loginFunction(String username,String Password)
	{
		
		emailField.sendKeys(username);
		passwordField.sendKeys(Password);
		
		loginButton.click();
		logo.click();
		return new HomePage();
		
	}
	
	
	public ForgotPassword forgotPasswordLink()
	{
		forgotPassword.click();
		return new ForgotPassword();
	}
	
	
		
	
	
}
