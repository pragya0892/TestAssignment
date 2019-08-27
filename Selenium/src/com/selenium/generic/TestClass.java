package com.selenium.generic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.selenium.utility.Xls_Reader;




public class TestClass {
	
	@SuppressWarnings("unused")
	public static void main(String args[])
	
	{
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://in.hotels.com/");
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");
		Date date = new Date();
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		cl.add(Calendar.DAY_OF_YEAR, 0);
		date=cl.getTime();
		String str = df.format(date);
		System.out.println("the date today is " + str);
		WebElement el = driver.findElement(By.id("qf-0q-localised-check-in"));
		el.clear();
		el.sendKeys(str);
		
		cl.add(Calendar.DAY_OF_YEAR, 3);
		date=cl.getTime();
		String str1 = df.format(date);
		System.out.println("the date today is " + str1);
		WebElement el1 = driver.findElement(By.id("qf-0q-localised-check-out"));
		el1.clear();
		el1.sendKeys(str1);
		
	//	driver.navigate().refresh();
		
		driver.findElement(By.id("qf-0q-destination")).sendKeys("Bengaluru, India");
		
	//	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody[@class='autosuggest-city']//descendant::tr//child::td//child::div[contains(text(),'Bangalore City Center, ')]")));
		driver.findElement(By.xpath("//tbody[@class='autosuggest-city']//descendant::tr//child::td//child::div[contains(text(),'Bangalore City Center, ')]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']")));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Deals']")));
		WebElement wb1 = driver.findElement(By.xpath("//a[text()='Deals']"));
		String text = wb1.getText();
		Assert.assertEquals(text, "Deals");
		System.out.println("Pass");
		driver.findElement(By.xpath("//a[text()='Price']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Price (high to low)']")));
		driver.findElement(By.xpath("//a[text()='Price (high to low)']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("f-label-popular-527")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,1000)");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ol[@role='status']")));
		
	//	ExcelLiberary excelLibrary = new ExcelLiberary(); 
	//	excelLibrary.writeExcel();
		
		//*[@id="listings"]/ol/li[2]/article/section/div/h3/a
		//*[@id="listings"]/ol/li[3]/article/section/div/h3/a
		//*[@id="listings"]/ol/li[5]/article/section/div/h3/a
		
		//*[@id="listings"]/ol/li[2]/article/section/aside/div[1]/a/ins
		//*[@id="listings"]/ol/li[1]/article/section/aside/div[1]/a/ins
		//*[@id="listings"]/ol/li[3]/article/section/aside/div[1]/a/ins
		
		
		//*[@id="listings"]/ol/li[2]/article/section/aside/div[2]/p/strong
		//*[@id="listings"]/ol/li[2]/article/section/aside/div[2]/p/strong
		//*[@id="listings"]/ol/li[1]/article/section/aside/div[2]/p/strong
		
		
		String beforeXpath_hotelName = "//*[@id=\"listings\"]/ol/li[";
		String afterXpath_hotelName = "]/article/section/div/h3/a";
		
		String beforeXpath_prices = "//*[@id=\"listings\"]/ol/li[";
		String afterXpath_prices = "]/article/section/aside/div[2]/p/strong";
		String no_prices = "//p[contains(text(), 'Fully booked! We’re sold out for your travel dates.')]";
//		WebElement wb = driver.findElement(By.xpath("//p[contains(text(), 'Fully booked! We’re sold out for your travel dates.')]"));
		
		List<WebElement> rows = driver.findElements(By.xpath("//ol[@role='status']"));
		System.out.println("Total number of hotels = " + (rows.size()-1));
		
		Xls_Reader reader = new Xls_Reader("/Users/pragya.sharma/git/TestAssignment/Selenium/src/com/datadriven/test/TestData.xlsx");
		
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
			
			if(driver.findElement(By.xpath(actualXpath_prices)).isDisplayed())
			{

				String price_value = driver.findElement(By.xpath(actualXpath_prices)).getText();
				System.out.println(price_value);
			}
			else
			{
				System.out.println("not present");
			} 
		} 
		
		
		
		
		
/*
	List<WebElement> list = driver.findElements(By.id("sort-submenu-price"));
		
		System.out.println("Auto Suggest List ::" + list.size());
		
		for(int i = 0 ;i< list.size();i++)
		{
			System.out.println(list.get(i).getText());
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Price (high to low)']")));
			  if(list.get(i).getText().equals("Price (high to low)")) 
			  {
			  list.get(i).click(); 
			  
			  }
			 
		}
	
	*/
}
	
}

