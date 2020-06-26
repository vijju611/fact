package com.Tyss.factframework.lib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseLib {
	
	
	static
	{
		
			System.setProperty(GenericLib.getPropData("browserKey"), GenericLib.getPropData("browserValue"));
		}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void  setUp() throws IOException
	{
		if(GenericLib.getPropData("browserName").equalsIgnoreCase("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			options.addArguments("---disable--notification");
			driver=new ChromeDriver(options);
		}
		else if(GenericLib.getPropData("browserName").equalsIgnoreCase("firefox"))
			
		{
			FirefoxOptions options=new FirefoxOptions();
			options.addPreference("dom.webnotification.enabled", false);
			driver= new FirefoxDriver(options);
		}
		else
		{
			Assert.fail("Browser name not found");
		}
	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(GenericLib.getPropData("url"));
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
