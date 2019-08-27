package com.selenium.generic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.selenium.utility.Xls_Reader;

public class ExcelLiberary {

	
		public void writeExcel() {
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://in.hotels.com");
		
		String beforeXpath_hotelName = "/html/body/div[2]/main/div[2]/div[2]/div/section[2]/div/ol/li[";
		String afterXpath_hotelName = "]/article/section/div/h3/a";
		
		String beforeXpath_prices = "/html/body/div[2]/main/div[2]/div[2]/div/section[2]/div/ol/li[";
		String afterXpath_prices = "]/article/section/aside/div[2]/p/strong";
		
		List<WebElement> rows = driver.findElements(By.xpath("//ol[@role='status']"));
		System.out.println("Total number of hotels = " + (rows.size()-1));
		
		Xls_Reader reader = new Xls_Reader("/Users/pragya.sharma/eclipse-workspace/Selenium/src/com/datadriven/test/TestData.xlsx");
		
		if(!reader.isSheetExist("ExcelData"))
		{
		reader.addSheet("ExcelData");
		reader.addColumn("ExcelData", "HotelName");
		reader.addColumn("ExcelData", "Price");
		}
		
		for(int i=1; i<=10; i++)
		{
			String actualXpath_hotelName = beforeXpath_hotelName+i+afterXpath_hotelName ;
			String hotelName = driver.findElement(By.xpath(actualXpath_hotelName)).getText();
			System.out.println(hotelName);
			reader.setCellData("ExcelData", "HotelName", i, hotelName);
			
			String actualXpath_prices = beforeXpath_prices+i+afterXpath_prices ;
			String prices = driver.findElement(By.xpath(actualXpath_prices)).getText();
			System.out.println(prices);
			reader.setCellData("ExcelData", "Price", i, prices);
			
		}
		
	}
		
}

