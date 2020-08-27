package com.waiting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class threadWait 
{
	WebDriver driver;
	
	public threadWait(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void waits() throws InterruptedException
	{
		Thread.sleep(4000);
	}
	
	public void ImpliWait()
	{
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
}
