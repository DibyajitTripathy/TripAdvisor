package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstPage 
{
	public WebDriver driver;


	By HolidayHomes = By.xpath("//span[@class='_1Qo7YQ01' and contains(text(),'Holiday Homes')]");
	By Destination = By.cssSelector("body > div._5_xsoLU2 > div > form > input._3qLQ-U8m");
	By PopUp1 = By.xpath("//button[@class='Z5j0Wsic']/span");
	By Calender = By.xpath("//div[@class='lRYY2wxe']");
	By CheckInDate = By.xpath("//div[@class='_2DSA78he']/div[1]/div[3]/div[5]/div[5]");
	By CheckOutDate = By.xpath("//div[@class='_2DSA78he']/div[1]/div[3]/div[6]/div[2]");
	By Guests = By.xpath("//div[@class='_2uJXqhFj']");
	By AddingGuests = By.xpath("//*[@id=\"BODY_BLOCK_JQUERY_REFLOW\"]/div[14]/div/div/div[2]/div/div[2]/div/div[2]/span[2]/span");
	By Search = By.xpath("//button[contains(text(),'Apply')]");

	public FirstPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public WebElement findingHolidayHomes()
	{
		return driver.findElement(HolidayHomes);
	}

	public WebElement getDestination()
	{
		return driver.findElement(Destination);
	}

	public WebElement managePopUp1()
	{
		return driver.findElement(PopUp1);
	}

	public WebElement clickCalender()
	{
		return driver.findElement(Calender);
	}


	public WebElement checkIn()
	{
		return driver.findElement(CheckInDate);
	}


	public WebElement checkOut()
	{
		return driver.findElement(CheckOutDate);
	}

	public WebElement selectingGuests()
	{
		return driver.findElement(Guests);
	}

	public WebElement addGuests()
	{
		return driver.findElement(AddingGuests);
	}

	public WebElement applySearch()
	{
		return driver.findElement(Search);
	}
}


