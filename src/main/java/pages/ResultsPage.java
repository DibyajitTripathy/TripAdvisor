package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultsPage 
{
	public WebDriver driver;
	
	public ResultsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public List<WebElement> hotelsName()
	{
		return  driver.findElements(By.className("_2K0y-IXo"));
	}
	
	public List<WebElement> hotelsPrice()
	{
		return driver.findElements(By.className("_1dDsF38n"));
	}
}
