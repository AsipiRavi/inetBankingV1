package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {
	WebDriver ldriver;
	public DeleteCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(how= How.XPATH, using="/html/body/div[3]/div/ul/li[4]/a")
	WebElement lDeleteCustomer;
	
	@FindBy(how= How.NAME, using="cusid")
	WebElement tCustomerID;
	
	@FindBy(how= How.NAME, using="AccSubmit")
	WebElement bAccSubmit;
	
	public void clickDeleteCustomerLink() {
		lDeleteCustomer.click();
	}
	
	public void setCustomerId(String customerId) {
		tCustomerID.sendKeys(customerId);
	}
	
	public void clickSubmit() {
		bAccSubmit.click();
	}

}
