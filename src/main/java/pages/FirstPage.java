package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstPage 
{
	public WebDriver driver;
	
	public FirstPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement findingHolidayHomes()
	{
		return driver.findElement(By.xpath("//span[@class='_1Qo7YQ01' and contains(text(),'Holiday Homes')]"));
	}
	
	public WebElement getDestination()
	{
		return driver.findElement(By.cssSelector("body > div._5_xsoLU2 > div > form > input._3qLQ-U8m"));
	}
	
	public WebElement managePopUp1()
	{
		return driver.findElement(By.xpath("//span[@class='_2I5NZygS _2HBN-k68 _3LkX-HIr'][1]"));
	}

	
	public WebElement managePopUp2()
	{
		return driver.findElement(By.xpath("//span[@class='_2I5NZygS _2HBN-k68 _3LkX-HIr']"));
	}

	
	public WebElement clickCalender()
	{
		return driver.findElement(By.xpath("//div[@class='lRYY2wxe']"));
	}

	
	public WebElement checkIn()
	{
		return driver.findElement(By.xpath("//div[@class='_3ULdV0X_ ' and @aria-label='Tue Aug 18 2020']"));
	}

	
	public WebElement checkOut()
	{
		return driver.findElement(By.xpath("//div[@class='_3ULdV0X_ ' and @aria-label='Sun Aug 23 2020']"));
	}
	
	public WebElement selectingGuests()
	{
		return driver.findElement(By.xpath("//div[@class='_2uJXqhFj']"));
	}
	
	public WebElement addGuests()
	{
		return driver.findElement(By.cssSelector("#BODY_BLOCK_JQUERY_REFLOW > div._1HphCM4i > div > div > div:nth-child(2) > div > div:nth-child(2) > div > div._1h6PBHw9 > span:nth-child(3) > span"));
	}
	
	public WebElement applySearch()
	{
		return driver.findElement(By.xpath("//button[contains(text(),'Apply')]"));
	}


}
