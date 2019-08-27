package com.selenium.pragya;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo {
	
	public static void main(String args[])
	{
		//System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/geckodriver");
		//System.setProperty("webdriver.gecko.driver", "/Users/pragya.sharma/eclipse-workspace/Selenium/library/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://in.hotels.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	driver.findElement(By.xpath("//button[@aria-label='Close overlay']")).click();
		driver.findElement(By.id("qf-0q-localised-check-out")).click();
	//	driver.findElement(By.xpath("//td[contains(@date-date='2019-7-31')]")).click();
		driver.findElement(By.xpath("//a[text()='31']")).click();
		driver.findElement(By.id("qf-0q-destination")).sendKeys("Bengaluru, India");
	//	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	//	driver.findElement(By.xpath("//div[@class='secret-prices']")).click();
		driver.findElement(By.xpath("//button[text()=\'close\' and @class = \'cta cta-link\']")).click();
	//	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//label[text() = \" Bengaluru, India\"]")).click();
		driver.findElement(By.xpath("//button[@class = \"cta widget-overlay-ok cta-disabled\"]")).click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//label[text()='Free wifi'])[1]")).click();
		driver.findElement(By.xpath("//a[text()='Price']")).click();
		driver.findElement(By.id("opt_STAR_RATING_HIGHEST_FIRST")).click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		
	}

}
