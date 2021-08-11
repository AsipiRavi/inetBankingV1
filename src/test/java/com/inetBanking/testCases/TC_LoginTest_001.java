package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass {
	
	@Test  // this annotation resembles test case
	public void loginTest() throws IOException {
		
		logger.info("url open successful");
		
		LoginPage loginPageObj = new LoginPage(driver);
		
		loginPageObj.setUserName(username);
		logger.info("set username successful");
		
		loginPageObj.setPassword(password);
		logger.info("set password successful");
		
		loginPageObj.clickLogin();
		logger.info("click login successful");

		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("login successful");
		}
		else {
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("login not successful");
		}
		
		loginPageObj.clickLogOut();
		logger.info("close browser successful");
		
	}

}
