package com.opencart.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.base.BaseClass;
import com.opencart.pages.HomePage;
import com.opencart.pages.IndexPage;
import com.opencart.pages.RegistrationPage;
import com.opencart.utils.ReadExcelFile;

public class RegistrationPageTest extends BaseClass {
	
	HomePage home;
	IndexPage index;
	RegistrationPage registration;
	
	
	public RegistrationPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initalization();
		index=new IndexPage();
		registration=index.getRegistrationPage();
		log=Logger.getLogger("RegistrationPageTest");
		
	}
	
	
	@Test(priority=2)
	public void validateinputfields()
	{
		boolean b1 =registration.pagefieldvalidation();
		Assert.assertTrue(b1);
		log.info("Registration page input fileds  validation");

		
	}
	
	
	@Test(priority=1)
	public void validatePageTitle()
	{
		String expected =registration.validatepagetitleValidation();
	
		Assert.assertEquals(expected, "Register Account");
		log.info("Registration page title validation");
	}
	
	
	
	@Test(priority=3,dataProvider="data") 
	public void registeruservalidation(String fname,String lname,String email, String telephone,String pass, String pass2) throws IOException
	{
		
		
		registration.registrationData(fname, lname, email, telephone, pass, pass2);
	
	
	}
	@DataProvider(name="data")
	public Iterator<Object[]> getDataFromExcel() throws Exception 
	{
		
		ArrayList<Object[]> data = ReadExcelFile.getExcelData();
		return data.iterator();
	}
	
	
	
	
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
