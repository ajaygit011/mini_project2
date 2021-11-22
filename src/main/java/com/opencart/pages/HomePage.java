package com.opencart.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.base.BaseClass;
import static com.opencart.utils.OpencartUtils.scrollToElement;


public class HomePage extends BaseClass{
	
	@FindBy(xpath="//input[@name='search']")
	@CacheLookup
	private WebElement searchbox;
	
	
	@FindBy(xpath="//div[@id='cart']//button")
	@CacheLookup
	private WebElement addtocart;
	
	@FindBy(xpath="//span[@class='input-group-btn']//button")
	@CacheLookup
	private WebElement searchbutton;
	
	@FindBy(xpath="//a[@title='Shopping Cart']")
	@CacheLookup
	private WebElement addtocartlink;
	
	
	@FindBy(xpath="//div[@class='button-group']//button")
	@CacheLookup
	private WebElement addToCartButton;
	// after searching phone this button is visible
	
	@FindBy(xpath="//td//img[@title='MacBook']")
	@CacheLookup
	private WebElement macbookimg;
	
	@FindBy(xpath="//a[contains(.,'Logout')]")
	@CacheLookup
	private WebElement logoutlink;
	
	
	@FindBy(xpath="//a[@title='My Account']")
	@CacheLookup
	private WebElement myaccount;
	
	@FindBy(xpath="//a[text()='Components']")
	@CacheLookup
	private WebElement dropdown;
	
	@FindBy(xpath="//a[@id='wishlist-total']")
	@CacheLookup
	private WebElement wishlistpage;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean searchboxvalidation()
	{
		boolean b =searchbox.isDisplayed();
		return b;
	}
	
	public boolean addtocartvalidation()
	{
		return addtocart.isDisplayed();
	}
	
	public void search(String product)
	{
		searchbox.sendKeys(product);
		searchbutton.click();
		
		scrollToElement();
		
	}
	
	public AddToCartPage  cartpage()
	{
		addtocartlink.click();
		return new AddToCartPage();
	}
	
	public void mouseOver()
	{
		Actions action = new Actions(driver);
		action.moveToElement(dropdown).build().perform();
		
	}
	
	
	public LogOutPage getLogoutPage()
	{
		myaccount.click();
		logoutlink.click();
		
		return new LogOutPage();
	}
	
	public WishListpage getWishlistPage()
	{
		wishlistpage.click();
		return new WishListpage();
	}
	
	
	public AddToCartPage addingItemToCart()
	{
		search("phone");
		addToCartButton.click();
		
		addtocartlink=driver.findElement(By.xpath("//a[@title='Shopping Cart']"));
		//addtocartlink.click();  causing stale element exception
		addtocartlink.click();
		return new AddToCartPage();
		
	}
	
	
}
