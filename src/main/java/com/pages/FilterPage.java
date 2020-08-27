package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FilterPage
{
	public WebDriver driver;

	By Sorting = By.xpath("//span[contains(text(),'Tripadvisor Sort')]");
	By Rating = By.xpath("//span[contains(text(),'Traveller Rating')]");
	By ShowMore = By.xpath("//div[@class='_3x5FiS7r' ]/div[12]/div[6]/span[contains(text(),'Show more')]");
	By Amenities = By.xpath("//div[@class='_2PiY6cu3' and contains(text(),'Amenities')]/following::div[21]");

	public FilterPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public WebElement selectRatings() throws InterruptedException
	{
		driver.findElement(Sorting).click();
		Thread.sleep(1000);
		return driver.findElement(Rating);
	}

	public WebElement selectingAmneties() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		driver.findElement(ShowMore).click();
		Thread.sleep(2000);

		return driver.findElement(Amenities);
	}
}
