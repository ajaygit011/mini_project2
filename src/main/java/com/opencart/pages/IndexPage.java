package com.opencart.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.base.BaseClass;
public class IndexPage extends BaseClass {
	
	@FindBy(xpath="//img[@title='Your Store']")
	@CacheLookup
	private WebElement titleimg;
	
	@FindBy(xpath="//button[@class='btn btn-link dropdown-toggle']")
	@CacheLookup
	private WebElement currencyElement;
	
	@FindBy(xpath="//a[@title='My Account']")
	@CacheLookup
	private WebElement dropdownLInk;
	
	@FindBy(xpath="//a[text()='Login']")
	@CacheLookup
	private WebElement loginLink;
	
	@FindBy(xpath="//a[text()='Register']")
	@CacheLookup
	private WebElement Register;
	
	@FindBy(xpath="//input[@name='search']")
	@CacheLookup
	private WebElement searchbutton;
	
	public IndexPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean indexPageTitleDisplayed()
	{
		boolean b =titleimg.isDisplayed();
		return b;
	}
	
	public String indexPageTitleName()
	{
		return driver.getTitle();
	}
	
	
	public boolean currencyDropDownisDisplayed()
	{
		currencyElement.click();
		driver.findElement(By.xpath("//button[@name='EUR']")).getText();
		
		return currencyElement.isDisplayed();
	}
	
	public String currncyDoller()
	{
		currencyElement.click();
		 return driver.findElement(By.xpath("//button[@name='EUR']")).getText();
	}
	
	public boolean dropdown()
	{
		
	
	boolean b1=loginLink.isDisplayed();
	boolean b2=Register.isDisplayed();
	
	if(b1==b2)
		return true;
	else
		return false;
		
	}

	public boolean searchbar()
	{
		return searchbutton.isDisplayed();
	}
	public LoginPage getLoginPage()
	{
		dropdownLInk.click();
		loginLink.click();
		return new LoginPage();

	}
	
	public RegistrationPage getRegistrationPage()
	{
		dropdownLInk.click();
		Register.click();
		return new RegistrationPage();
	}
}
