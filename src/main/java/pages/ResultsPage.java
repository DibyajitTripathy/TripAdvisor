package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPage 
{
	public WebDriver driver;
	
	By Hotels = By.className("_2K0y-IXo");
	By Prices = By.className("_1dDsF38n");
	
	public ResultsPage(WebDriver driver)
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
}
