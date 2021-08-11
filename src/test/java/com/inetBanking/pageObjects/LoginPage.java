package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this); //  page factory model initilisation
	}

	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(xpath="/html/body/form/table/tbody/tr[2]/td[2]/input")
	WebElement txtPassword;
	
	@FindBy(xpath="/html/body/form/table/tbody/tr[3]/td[2]/input[1]")
	WebElement btnLogin;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement btnLogOut;
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogOut() {
		btnLogOut.click();
	}
}
