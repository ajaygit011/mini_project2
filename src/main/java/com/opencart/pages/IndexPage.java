package com.opencart.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.base.*;
public class IndexPage extends BaseClass {
	
	@FindBy(xpath="//img[@title='Your Store']")
	
	WebElement titleimg;
	
	@FindBy(xpath="//button[@class='btn btn-link dropdown-toggle']")
	WebElement currencyElement;
	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement dropdownLInk;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Login']")
	WebElement loginLink;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Register']")
	WebElement Register;
	
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
	
	public LoginPage getLoginPage()
	{
		dropdownLInk.click();
		loginLink.click();
		return new LoginPage();

	}
}
