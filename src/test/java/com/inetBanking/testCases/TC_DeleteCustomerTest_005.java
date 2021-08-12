package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.DeleteCustomerPage;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_DeleteCustomerTest_005 extends BaseClass{

	@Test(dataProvider="CustomerId")
	public void deleteCustomer(String customerId) {
		LoginPage loginPageObj = new LoginPage(driver);
		DeleteCustomerPage deleteCustomerPageObj = new DeleteCustomerPage(driver);
		
		loginPageObj.setUserName(username);
		loginPageObj.setPassword(password);
		loginPageObj.clickLogin();
		logger.info("Login Successful");
		
		deleteCustomerPageObj.clickDeleteCustomerLink();
		logger.info("Click Delete Customer Link Successful");
		
		deleteCustomerPageObj.setCustomerId(customerId);
		logger.info("Set Customer Id Successful");
		
		deleteCustomerPageObj.clickSubmit();
		logger.info("Submit delete Successful");
		
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		
		logger.info("Delete Customer Successful");
	}
	
	@DataProvider(name="CustomerId")
	String[][] getData() throws IOException {
		String Path = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/CustomerID.xlsx";
		String customerData[][] = new String[1][1];
		customerData[0][0] = XLUtils.getCellData(Path, "Sheet1", 0, 0);
		return customerData;
	}
}
