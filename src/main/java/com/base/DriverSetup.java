package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup 
{
	protected WebDriver driver;

	public WebDriver setup(String browser) throws Exception //This exception is used to handle browser not found exception
	{

		if(browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//driver//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} 
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//driver//geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else{

			throw new Exception("Browser is not correct");
		}
		return driver;

	}
}
