package com.Tyss.factframework.scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Tyss.factframework.init.IConstants;
import com.Tyss.factframework.lib.BaseLib;
import com.Tyss.factframework.lib.ExcelLib;
import com.Tyss.factframework.pages.HomePage;
import com.Tyss.factframework.pages.MyCartPage;
import com.Tyss.factframework.pages.SignInPage;

public class LoginTest extends BaseLib {
	
	
	

	@Test
	public void tc_02() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		Assert.assertEquals(hp.getHomePage(), ExcelLib.readDataFromExcel("Sheet1", 1, 1, IConstants.expectedexcelPath));
		hp.myAccountBtnClick();
		Thread.sleep(5000);
		SignInPage sip = new SignInPage(driver);
		Assert.assertEquals(sip.getSignInPage(), ExcelLib.readDataFromExcel("Sheet1", 1, 2, IConstants.expectedexcelPath));
	String un = ExcelLib.readDataFromExcel("Sheet1",1,1,IConstants.excelPath);
	String pw = ExcelLib.readDataFromExcel("Sheet1",1,2,IConstants.excelPath);
	sip.doLogin(un, pw);
	MyCartPage mcp = new MyCartPage(driver);
	Assert.assertEquals(mcp.getWelcomeName(), ExcelLib.readDataFromExcel("Sheet1", 1, 3, IConstants.expectedexcelPath));
	Thread.sleep(5000);
	
	}

}
