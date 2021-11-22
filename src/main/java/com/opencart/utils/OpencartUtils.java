package com.opencart.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.opencart.base.BaseClass;

public class OpencartUtils extends BaseClass{
	
	public static void useJavaSrciptExecutor(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click", element);
	}
	
	
	public static void takeScreenShot(String filename) throws IOException
	{
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./screenshots/"+filename+".jpg"));
	}
	
	public static void scrollToElement()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
	}
}
