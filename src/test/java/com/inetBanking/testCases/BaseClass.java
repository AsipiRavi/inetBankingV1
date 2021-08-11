package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	
	public String baseURL = readConfig.getBaseUrl();
	public String username = readConfig.getUsername();
	public String password = readConfig.getPassword();
	public static WebDriver driver;
	
	Logger logger;
	
	@Parameters("browser") // parameters are being from TestNG.xml to choose different drivers
	@BeforeClass // this annotation resembles before class execution
	public void setup(String br) {
//		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver","E:\\JavaTestAutomation\\inetBankingV1\\Drivers\\chromedriver.exe");
		

		logger = Logger.getLogger("inetBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",readConfig.getChromeDriverPath());
			driver = new ChromeDriver();
			
		}
		else if (br.equals("edge")) {
			System.setProperty("webdriver.edge.driver",readConfig.getEdgeDriverPath());
			driver = new EdgeDriver();
		}
		else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxDriverPath());
			driver = new FirefoxDriver();
		}
		
		logger.info("implicit wait : 10secs");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	
	@AfterClass  // this annotation resembles after class execution
	public void teardown() {
		driver.quit();
	}
	
	//method for capturing screenshot
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public boolean isAlertPresent() // method to check alert is present or not
	{ 
		
		try {
			driver.switchTo().alert();
			return  true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	public String randomString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

}
