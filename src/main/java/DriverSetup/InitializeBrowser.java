package DriverSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitializeBrowser 
{
	public WebDriver driver;
	
	public WebDriver initializeBrowser()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//driver//chromedriver.exe");
		driver = new ChromeDriver();
		
		return driver;
	}
}
