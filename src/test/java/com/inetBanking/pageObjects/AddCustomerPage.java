package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this); // page factory model initilisation
	}
	
	@FindBy(how=How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	WebElement lAddNewCustomer;
	
	@FindBy(how=How.NAME, using="name")
	WebElement tCustomerName;
	
	@FindBy(how=How.NAME, using="rad1")
	WebElement rGender;
	
	@FindBy(how=How.ID, using="dob")
	WebElement dDOB;
	
	@FindBy(how=How.NAME, using="addr")
	WebElement tAddress;
	
	@FindBy(how=How.NAME, using="city")
	WebElement tCity;
	
	@FindBy(how=How.NAME, using="state")
	WebElement tState;
	
	@FindBy(how=How.NAME, using="pinno")
	WebElement tPinNumber;
	
	@FindBy(how=How.NAME, using="telephoneno")
	WebElement tTelephoneno;
	
	@FindBy(how=How.NAME, using="emailid")
	WebElement tEmailid;
	
	@FindBy(how=How.NAME, using="password")
	WebElement tPassword;
	
	@FindBy(how=How.NAME, using="sub")
	WebElement bSubmit;
	
	public void clickAddNewCustomer() {
		lAddNewCustomer.click();
	}
	
	public void setCustomerName(String name) {
		tCustomerName.sendKeys(name);
	}
	
	public void setGender(String cgender) {
		rGender.click();
	}
	
	public void setDOB(String mm,String dd,String yy) {
		dDOB.sendKeys(mm+'/'+dd+'/'+yy);
//		dDOB.sendKeys(dd);
//		dDOB.sendKeys(yy);
	}
	
	public void setAddress(String address) {
		tAddress.sendKeys(address);
	}
	
	public void setCity(String city) {
		tCity.sendKeys(city);
	}
	
	public void setState(String state) {
		tState.sendKeys(state);
	}
	
	public void setPinNo(String pinno) {
		tPinNumber.sendKeys(pinno);
	}
	
	public void setTelephoneno(String telephone) {
		tTelephoneno.sendKeys(telephone);
	}
	
	public void setEmailid(String email) {
		tEmailid.sendKeys(email);
	}
	
	public void setPassword(String password) {
		tPassword.sendKeys(password);
	}

	public void clickSubmit() {
		bSubmit.click();
	}

}