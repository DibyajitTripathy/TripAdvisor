package com.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.DriverSetup;
import com.base.ScreenShots;
import com.data.ExcelRead;
import com.data.PropertiesRead;
import com.pages.FilterPage;
import com.pages.FirstPage;
import com.pages.ResultPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.waiting.threadWait;

import com.Test.TripAdvisor;

public class TripAdvisor extends DriverSetup
{
	WebDriver driver;
	PropertiesRead data;
	FirstPage firstpage;
	FilterPage filterpage;
	threadWait waiting;
	ExcelRead read;
	Properties values;
	ResultPage resultpage;
	ScreenShots pic;
	
	static ExtentTest test;
	static ExtentReports report;
	int count = 0 ;
	
	private static final String FILE_NAME = System.getProperty("user.dir")+"//Output//Data.xlsx";
	
	Logger Log = Logger.getLogger(TripAdvisor.class.getName()); 
	
	@BeforeTest(groups= {"smoke","regression"})
    @Parameters("browser")
	public void Set(String browser) throws Exception 
    {  
		
    	driver = setup(browser);
    	data = new PropertiesRead();
    	firstpage = new FirstPage(driver);
    	filterpage = new FilterPage(driver);
    	resultpage = new ResultPage(driver);
    	values = data.RequiredData();
    	waiting = new threadWait(driver);
    	read = new ExcelRead();
    	pic = new ScreenShots(driver);
    	
    	count ++ ;
    	
    	report = new ExtentReports(System.getProperty("user.dir")+"//Output//ExtentReportResults.html");		
		test = report.startTest("ExtentReport");
		
		if(count==1)
		{
			test.log(LogStatus.PASS, "Driver is initialized");
			Log.info("Driver is initialized");
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed");
			Log.info("Initialization Failed");
		}
    	
		
    }
	
	
	
	@Test(priority=1,groups= {"smoke","regression"})
	void firstPage() throws InterruptedException
	{
		
		driver.get(values.getProperty("url"));
		waiting.waits();
		count++;
		if(count==2)
		{
			test.log(LogStatus.PASS, "Url Reached");
			Log.info("Navigated to URL");
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed");
			Log.info("Navigation Failed");
		}
		firstpage.findingHolidayHomes().click();
		waiting.waits();
		WebElement place = firstpage.getDestination();
		place.sendKeys(values.getProperty("destination"));
		waiting.waits();
		place.sendKeys(Keys.ENTER);
		waiting.waits();
		firstpage.managePopUp1().click();
		waiting.waits();
		firstpage.clickCalender().click();
		waiting.waits();
		firstpage.checkIn().click();
		waiting.waits();
		firstpage.checkOut().click();
		waiting.waits();
		Log.info("Check In and Check Out date selected");
		firstpage.selectingGuests().click();
		waiting.waits();
		firstpage.addGuests().click();
		waiting.waits();
		firstpage.addGuests().click();
		waiting.waits();
		firstpage.applySearch().click();
		waiting.waits();
		Log.info("Guest added");
		count++;
		if(count==3)
		{
			test.log(LogStatus.PASS, "Calender and Guests Selected");
			Log.info("Calender and Guests Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed");
			Log.info("Test Failed");
		}
		
	}
	
	
	@Test(priority=2,groups= "regression")
	void filterPage() throws InterruptedException
	{
		waiting.waits();
		filterpage.selectRatings().click();
		waiting.waits();
		Log.info("Ratings Selected");
		filterpage.selectingAmneties().click();
		waiting.waits();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-1000)");
		waiting.waits();
		Log.info("Amenities Selected");
		count++;
		if(count==4)
		{
			test.log(LogStatus.PASS, "Filters Selected");
			Log.info("Filters Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed");
			Log.info("Test Failed");
		}


	}
	
	
	@Test(priority=3,groups= "regression")
	void resultPage() throws Exception
	{
		pic.takeSnapShot(driver,values.getProperty("Hotels"));
		List<WebElement> hotels=resultpage.hotelsName();
		Log.info("Hotels Retrieved");
		List<WebElement> prices=resultpage.hotelsPrice();
		Log.info("Prices Retrieved");
		List<WebElement> totalPrices=resultpage.TotalHotelsPrice();
		
		InputStream inp = new FileInputStream(FILE_NAME); 
	    Workbook wb = WorkbookFactory.create(inp); 
		Sheet sheet = wb.getSheetAt(0);
		Row row2 = sheet.createRow(1);
		Row row4 = sheet.createRow(3);
		Row row6 = sheet.createRow(5);
		
		for(int i=0;i<3;i++) 
		{

			row2.createCell(i).setCellValue(hotels.get(i).getText());
			row4.createCell(i).setCellValue("RS."+prices.get(i).getText().replaceAll("[^0-9]", "")+" per night ");
			row6.createCell(i).setCellValue("RS."+totalPrices.get(i).getText().replaceAll("[^0-9]", "")+" per 4 night ");

		}
		
		FileOutputStream fileOut = new FileOutputStream(FILE_NAME); 
	    wb.write(fileOut); 
	    fileOut.close();
	    count++;
		if(count==5)
		{
			test.log(LogStatus.PASS, "Hotels and Prices Retrieved");
			Log.info("Hotels and Prices Retrieved");
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed");
			Log.info("Test Failed");
		}

	}
	
	@AfterTest(groups= {"smoke","regression"})
	void closeAll()
	{
		driver.quit();
		count++;
		if(count==6||count==4)
		{
			test.log(LogStatus.PASS, "Successfully completed");
			Log.info("Successfully completed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed");
			Log.info("Test Failed");
		}
		report.endTest(test);
		report.flush();
	}
}
