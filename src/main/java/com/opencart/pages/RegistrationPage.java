package com.opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.base.BaseClass;

public class RegistrationPage extends BaseClass{
	
	@FindBy(xpath="//title[contains(text(),'Register Account')]") 
	@CacheLookup
	private WebElement title;
	
	@FindBy(xpath="//input[@id='input-firstname']")
	@CacheLookup
	private WebElement username;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	@CacheLookup
	private WebElement lastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	@CacheLookup
	private WebElement email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	@CacheLookup
	private WebElement phonenumber;
	
	@FindBy(xpath="//input[@id='input-password']")
	@CacheLookup
	private WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	@CacheLookup
	private WebElement confpassword;
	
	@FindBy(xpath="//input[@value='Continue']")
	@CacheLookup
	private WebElement button;

	
	@FindBy(xpath="//input[@name='agree']")
	@CacheLookup
	private WebElement checkbox;
	
	
	public RegistrationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean pagefieldvalidation()
	{
		boolean b1 = username.isDisplayed();
		boolean b2 = lastname.isDisplayed();
		boolean b3 = email.isDisplayed();
		boolean b4 = phonenumber.isDisplayed();
		boolean b5 = password.isDisplayed();
		boolean b6 = button.isDisplayed();
		boolean b7 = checkbox.isDisplayed();
	if(b1==b2==b3==b4==b5==b6==b7==true)
	{
		return true;
	}
	else
		return false;
	}
	
	
	public void registrationData(String fname,String lname,String eemail, String telephone,String pass, String pass2) 
	{
		
		username.sendKeys(fname);
		lastname.sendKeys(lname);
		email.sendKeys(eemail);
		phonenumber.sendKeys(telephone);
	
		password.sendKeys(pass);
		confpassword.sendKeys(pass2);
		checkbox.click();
		button.click();
	
		
	
	}
	public String  validatepagetitleValidation()
	{
		return driver.getTitle();
	}

}
