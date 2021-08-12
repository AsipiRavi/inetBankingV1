package com.inetBanking.testCases;

import java.io.IOException;

//import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="LoginData") // mention dataprovide name
	public void LoginDDT(String username, String password) throws InterruptedException// pass data provider column as parameters
	{ 
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.setUserName(username);
		logger.info("set username successful");
		
		loginPage.setPassword(password);
		logger.info("set password successful");
		
		loginPage.clickLogin();
		logger.info("click login ");
		
		logger.info("sleep : 3secs");
		Thread.sleep(3000);
		
		if(isAlertPresent() == true) {
			logger.info("login test failed");
			driver.switchTo().alert().accept();// accept alert
			Assert.assertTrue(false);
//			driver.switchTo().defaultContent();// switch to default content
		}
		else {
			logger.info("login test successful");
			loginPage.clickLogOut();
			logger.info("sleep : 3secs");
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			Assert.assertTrue(true);
//			driver.switchTo().defaultContent();// switch to default content
		}
	}
	
//	public boolean isAlertPresent() // method to check alert is present or not
//	{ 
//		try {
//			driver.switchTo().alert();
//			return  true;
//		}
//		catch(NoAlertPresentException e) {
//			return false;
//		}
//	}
	
	@DataProvider(name="LoginData") // must specify name as this will be required in test method where you want to use data
	String [][] getData() throws IOException // to get excel data 
	{
		String Path = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";

		int rownum = XLUtils.getRowCount(Path, "Sheet1");
		int colcount = XLUtils.getCellCount(Path, "Sheet1", 1);
		String logindata[][] = new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for (int j=0;j<colcount;j++) {
				logindata[i-1][j]=XLUtils.getCellData(Path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
	
}