package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.EditCustomerPage;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_EditCustomerTest_004 extends BaseClass{

	
	@Test(dataProvider="CustomerID")
	public void editCustomerTest(String customerId) {
		LoginPage loginPageObj = new LoginPage(driver); 
		EditCustomerPage editCustomerPageObj = new EditCustomerPage(driver);
		
		loginPageObj.setUserName(username);
		loginPageObj.setPassword(password);
		
		loginPageObj.clickLogin();
		logger.info("click login successful");
		
		editCustomerPageObj.clickEditCustomer();
		logger.info("click Edit Customer successful");
		
		editCustomerPageObj.setCustomerId(customerId);
		logger.info("set Customer ID successful");
		
		editCustomerPageObj.clickSubmit();
		logger.info("click Submit successful");

		if(driver.getTitle().contains("Guru99 Bank Edit Customer Entry Page")) {
			editCustomerPageObj.setCity("City");
			logger.info("Update City Name successful");
			
			editCustomerPageObj.clickSub();
			logger.info("Click Submit Successful");
			
			if(driver.getPageSource().contains("Customer details updated Successfully!!!")) {
				logger.info("Edit Form Successful");
				logger.info("Test Successful");
				Assert.assertTrue(true);
			}
			else {
				logger.info("Edit Form Unsuccessful");
				logger.info("Test Failed");
				Assert.assertTrue(true);
			}

		}
		else {
			logger.info("Test Failed");
			Assert.assertTrue(false);
		}
	}
	
	@DataProvider(name="CustomerID")
	String[][] getData() throws IOException {
		String Path = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/CustomerID.xlsx";
		String customerData[][] = new String[1][1];
		customerData[0][0] = XLUtils.getCellData(Path, "Sheet1", 0, 0);
		return customerData;
	}
}
