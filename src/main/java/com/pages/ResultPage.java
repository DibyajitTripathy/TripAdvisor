package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage 
{
	public static WebDriver driver;

	By Hotels = By.className("_2K0y-IXo");
	By Prices = By.className("_33TIi_t4");
	By TotalPrice = By.className("_3f9mHAKH");

	public ResultPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public List<WebElement> hotelsName()
	{
		return  driver.findElements(Hotels);
	}

	public List<WebElement> hotelsPrice()
	{
		return driver.findElements(Prices);
	}

	public List<WebElement> TotalHotelsPrice()
	{
		return driver.findElements(TotalPrice);
	}
}
