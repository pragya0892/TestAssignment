package com.selenium.generic;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatement {
	
	public void implecitWaitForSeconds(WebDriver driver, int time)
	
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);	
	}
	
	public void implecitWaitForMinutes(WebDriver driver, int time)
	
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.MINUTES);	
	}
	
	public void explicitWait(WebDriver driver, int time, WebElement element)
	
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	@SuppressWarnings("deprecation")
	public void fluentWait(WebDriver driver, int totalTime, int pollingTime, WebElement element)
	
	{
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		fluentWait.withTimeout(totalTime, TimeUnit.SECONDS);
		fluentWait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		fluentWait.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
