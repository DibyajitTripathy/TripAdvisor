package Testing;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DriverSetup.InitializeBrowser;
import pages.FilterPage;
import pages.FirstPage;
import pages.ResultsPage;

public class Tests extends InitializeBrowser
{
	public WebDriver driver;
	
	@BeforeTest
	public void initialSetup()
	{
		driver = initializeBrowser();
	}
	
	@Test (priority = 0)
	public void getUrl() throws InterruptedException
	{
		driver.get("https://www.tripadvisor.in/");	
		driver.manage().window().maximize();
		waiting();
	}
	
	@Test (priority = 1)
	public void landingPage() throws InterruptedException
	{
		FirstPage lp=new FirstPage(driver);
		
		lp.findingHolidayHomes().click();
		waiting();
		
		WebElement place = lp.getDestination();
		place.sendKeys("Nairobi");
		waiting();
		place.sendKeys(Keys.ENTER);
		waiting();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		lp.managePopUp1();
		waiting();
		
		lp.managePopUp2();
		waiting();
		
		lp.clickCalender().click();;
		waiting();
		
		lp.checkIn().click();
		waiting();
		
		lp.checkOut().click();
		waiting();

		lp.selectingGuests().click();
		waiting();

		lp.addGuests().click();
		waiting();

		lp.addGuests().click();
		waiting();

		lp.applySearch().click();
		waiting();

	}
	
	@Test (priority = 2)
	public void filterPage() throws InterruptedException
	{
		FilterPage fp=new FilterPage(driver);
		
		fp.selectRatings().click();
		waiting();
		
		fp.selectingAmneties().click();
		waiting();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-1000)");
		waiting();
	}
	
	
	@Test (priority = 3)
	public void resultsPage()
	{
		ResultsPage rp=new ResultsPage(driver);
		
		List<WebElement> hotels=rp.hotelsName();
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		List<WebElement> prices=rp.hotelsPrice();
		
		System.out.println(hotels);
		System.out.println(prices);
	}
	
	@AfterTest
	public void closebrowser()
	{
		driver.quit();
	}
}
	
