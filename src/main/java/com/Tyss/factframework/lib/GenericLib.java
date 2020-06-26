package com.Tyss.factframework.lib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.Tyss.factframework.init.IConstants;

public class GenericLib {
	
	public static String getPropData(String Key) {
		String data = "";
		try {
		FileInputStream finn = new FileInputStream(IConstants.propFilePath);
		Properties prop= new Properties();
		prop.load(finn);
		data = prop.getProperty(Key);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	public static void clickElement(WebElement ele,WebDriver driver,String eleName)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
	
	try
	{
		
		wait.until(ExpectedConditions.visibilityOf(ele)).click();
		Reporter.log("Clicked on" + eleName);
	}
	catch(TimeoutException e)
	
	{
		Reporter.log(eleName+ "Is not displayed");
		Assert.fail();
	}
	
}
	public static void enterText(WebDriver driver,WebElement ele, String text,String eleName)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
	
	try
	{
		
		wait.until(ExpectedConditions.visibilityOf(ele)).sendKeys(text);;
		Reporter.log("Entered text \" "+text+ " \"In the "+eleName);
	}
	catch(TimeoutException e)
	
	{
		Reporter.log(eleName+ "Is not displayed");
		Assert.fail();
	}
	
}
	
}


