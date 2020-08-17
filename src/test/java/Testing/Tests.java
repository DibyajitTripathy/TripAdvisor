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
		Thread.sleep(1000);
	}
	
	@Test (priority = 1)
	public void landingPage() throws InterruptedException
	{
		FirstPage lp=new FirstPage(driver);
		
		lp.findingHolidayHomes().click();
		Thread.sleep(3000);
		
		WebElement place = lp.getDestination();
		place.sendKeys("Nairobi");
		Thread.sleep(3000);
		place.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		lp.managePopUp1();
		Thread.sleep(2000);
		
		lp.managePopUp2();
		Thread.sleep(1000);
		
		lp.clickCalender().click();;
		Thread.sleep(2000);
		
		lp.checkIn().click();
		Thread.sleep(2000);

		lp.checkOut().click();
		Thread.sleep(2000);

		lp.selectingGuests().click();
		Thread.sleep(2000);

		lp.addGuests().click();
		Thread.sleep(1000);

		lp.addGuests().click();
		Thread.sleep(1000);

		lp.applySearch().click();
		Thread.sleep(2000);

	}
	
	@Test (priority = 2)
	public void filterPage() throws InterruptedException
	{
		FilterPage fp=new FilterPage(driver);
		
		fp.selectRatings().click();
		Thread.sleep(2000);
		
		fp.selectingAmneties().click();
		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(2000);
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
	
