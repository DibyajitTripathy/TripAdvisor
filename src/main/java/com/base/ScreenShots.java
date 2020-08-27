package com.base;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots 
{
	WebDriver driver;

	public ScreenShots(WebDriver driver) 
	{
		this.driver=driver;
	} 
	public void takeSnapShot(WebDriver driver,String fileWithPath) throws Exception{

		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
	}
}
