package com.Tyss.factframework.rough;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Tyss.factframework.lib.BaseLib;

public class Demo extends BaseLib {
  
	 @Test
	 public void tc_roughDemo() throws InterruptedException
	 {
		 WebElement ele = driver.findElement(By.xpath("//a[contains(.,'My Account')]"));
		 WebDriverWait wait=new WebDriverWait(driver,10);
		 wait.until(ExpectedConditions.visibilityOf(ele)).click();
		 Reporter.log(ele+ " ids not displayed");
		 Thread.sleep(3000);
		 
	 }
	
	{
		
		
	}
}
