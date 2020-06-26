package com.Tyss.factframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Tyss.factframework.lib.GenericLib;

public class SignInPage {
	 WebDriver driver;
	 @FindBy(id= "exampleInputEmail1")
	 private WebElement unTxtBox;
	 
	 @FindBy(id= "exampleInputPassword1")
	 private WebElement pwdTxtBox;
	 
	 @FindBy(name="login")
	 private WebElement loginBtn;
	 
	 public SignInPage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	 }
	 public void doLogin(String username,String password)
	 {
		 GenericLib.enterText(driver, unTxtBox, username, "Userame Textbox");
		 GenericLib.enterText(driver, pwdTxtBox, password, "Password Textbox");
		 GenericLib.clickElement(loginBtn, driver,"LoginBtn");
	 }

	 public String getSignInPage()
		{
			return driver.getTitle();
		}
}
