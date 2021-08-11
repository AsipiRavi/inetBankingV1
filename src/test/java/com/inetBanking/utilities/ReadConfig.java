package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties configProperties;
	
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			configProperties = new Properties();
			configProperties.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception is :" + e.getMessage());
		}
	}
	
	public String getBaseUrl() {
		return configProperties.getProperty("baseURL");
	}
	
	public String getUsername() {
		return configProperties.getProperty("username");
	}
	
	public String getPassword() {
		return configProperties.getProperty("password");
	}
	
	public String getChromeDriverPath() {
		return configProperties.getProperty("chromeDriverPath");
	}
	
	public String getEdgeDriverPath() {
		return configProperties.getProperty("edgeDriverPath");
	}
	
	public String getFirefoxDriverPath() {
		return configProperties.getProperty("firefoxDriverPath");
	}
}
