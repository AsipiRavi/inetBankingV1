package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws IOException, InterruptedException {

		LoginPage loginPageObj = new LoginPage(driver);
		AddCustomerPage addCustomerPageObj = new AddCustomerPage(driver);
		
		loginPageObj.setUserName(username);
		loginPageObj.setPassword(password);
		logger.info("set credentials successful");
		
		loginPageObj.clickLogin();
		logger.info("click login successful");
		
		
		addCustomerPageObj.clickAddNewCustomer();
		addCustomerPageObj.setCustomerName("Test User");
		addCustomerPageObj.setGender("male");
		addCustomerPageObj.setDOB("01", "15", "1990");
		addCustomerPageObj.setAddress("Barrackpore");
		addCustomerPageObj.setCity("Kolkata");
		addCustomerPageObj.setState("WB");
		addCustomerPageObj.setPinNo("700001");
		addCustomerPageObj.setTelephoneno("9000000001");
		addCustomerPageObj.setEmailid(randomString()+"@gmail.com");
		addCustomerPageObj.setPassword("password");
		logger.info("set customer info successful");
		
		addCustomerPageObj.clickSubmit();
		logger.info("click submit successful");
		
		Thread.sleep(3000);
		
		if(isAlertPresent() == true) { // calling base function to check alert is present or not
			driver.switchTo().alert().accept();
			captureScreen(driver, "addNewCustomer" );
			logger.warn("customer addition Failed");
			logger.warn("Test Failed");
			Assert.assertTrue(false);
		}
		else {
			logger.info("customer addition successful");
			String customerId = addCustomerPageObj.getCustomerID();
			logger.info("Customer Id : "+customerId);
			try {
				String Path = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/CustomerID.xlsx";
//				XLUtils.setCellData(Path,"Sheet1",2,1,customerId);
				XLUtils.setCellData(Path, "Sheet1", 0, 0, customerId);
				logger.info("Customer Id Saved");
			}
			catch(Exception e) {
				logger.info("Customer Id not Saved :"+e.getMessage());
			}
			
			logger.info("Test successful");
			Assert.assertTrue(true);
		}
		
	}
	
}
