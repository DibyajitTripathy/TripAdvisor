package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstPage 
{
	public WebDriver driver;
	
	By HolidayHomes = By.xpath("//span[@class='_1Qo7YQ01' and contains(text(),'Holiday Homes')]");
	By Destination = By.cssSelector("body > div._5_xsoLU2 > div > form > input._3qLQ-U8m");
	By PopUp1 = By.xpath("//span[@class='_2I5NZygS _2HBN-k68 _3LkX-HIr'][1]");
	By PopUp2 = By.xpath("//span[@class='_2I5NZygS _2HBN-k68 _3LkX-HIr']");
	By Calender = By.xpath("//div[@class='lRYY2wxe']");
	By CheckInDate = By.xpath("//div[@class='_3ULdV0X_ ' and @aria-label='Tue Aug 18 2020']");
	By CheckOutDate = By.xpath("//div[@class='_3ULdV0X_ ' and @aria-label='Sun Aug 23 2020']");
	By Guests = By.xpath("//div[@class='_2uJXqhFj']");
	By AddingGuests = By.cssSelector("#BODY_BLOCK_JQUERY_REFLOW > div._1HphCM4i > div > div > div:nth-child(2) > div > div:nth-child(2) > div > div._1h6PBHw9 > span:nth-child(3) > span");
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

	
	public WebElement managePopUp2()
	{
		return driver.findElement(PopUp2);
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
