package com.Tyss.factframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Tyss.factframework.lib.GenericLib;

public class HomePage {
	 WebDriver driver;
	 @FindBy(xpath="//a[contains(.,'My Account')]")
	 private WebElement myAccountBtn;
	 
	 @FindBy(name= "product")
	 private WebElement searchBox;
	 
	 @FindBy(xpath="//button[@name='search']")
	 private WebElement searchBtn;
	 
	 public HomePage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	 }
	 public void myAccountBtnClick()
	 {
		 GenericLib.clickElement(myAccountBtn, driver,"Account Button");
	 }
	 public void searchBoxEnterTextAndClick(String searchText) throws InterruptedException

	 {
		 searchBox.sendKeys(searchText);
		 Thread.sleep(3000);
		 GenericLib.clickElement(searchBtn, driver, "Search Btn");
	 }
	 
	public String getHomePage() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

}
