package com.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.ResultPage;

public class ExcelRead 
{
	private static final String FILE_NAME = System.getProperty("user.dir")+"//Output//Data.xlsx";
	ResultPage resultpage;
	WebDriver driver;

	public void readData() throws IOException, InvalidFormatException 
	{
		resultpage=new ResultPage(driver);
		
		List<WebElement> hotels=resultpage.hotelsName();;
		List<WebElement> prices=resultpage.hotelsPrice();;
		List<WebElement> totalPrices=resultpage.TotalHotelsPrice();
 
		System.out.println(hotels);
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
	}
}
