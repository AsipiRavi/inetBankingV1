package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	WebDriver ldriver;
	public EditCustomerPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how=How.XPATH, using="/html/body/div[3]/div/ul/li[3]/a")
	WebElement lEditCustomer;
	
	@FindBy(how=How.NAME, using="cusid")
	WebElement tCustomerId;
	
	@FindBy(how=How.NAME, using="AccSubmit")
	WebElement bSubmit;
	
	@FindBy(how=How.NAME, using="name")
	WebElement tCustomerName;
	
	@FindBy(how=How.NAME, using="city")
	WebElement tCity;
	
	@FindBy(how=How.NAME, using="sub")
	WebElement bSub;
	
	public void clickEditCustomer() {
		lEditCustomer.click();
	}
	
	public void setCustomerId(String customerId) {
		tCustomerId.sendKeys(customerId);
	}
	
	public void clickSubmit() {
		bSubmit.click();
	}
	
	public void setCustomerName() {
		tCustomerName.sendKeys("Test");
	}
	
	public void setCity(String city) {
		tCity.sendKeys("City");
	}
	
	public void clickSub() {
		bSub.click();
	}
}
