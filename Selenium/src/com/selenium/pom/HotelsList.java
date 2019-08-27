package com.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.selenium.generic.WaitStatement;

public class HotelsList {

	public WaitStatement wait;
	public WebDriver driver;
	
//	@FindBy(xpath = "//button[@aria-label='Close overlay']")
//	private WebElement closePopUp;
	
	@FindBy(id = "qf-0q-localised-check-out")
	private WebElement checkout;
	
	@FindBy(xpath = "//td[contains(@date-date='2019-7-31')]")
	private WebElement selectDate;
	
	@FindBy(id = "qf-0q-destination")
	private WebElement destination;
	
	@FindBy(xpath = "//button[text()='close' and @class = 'cta cta-link']")
	private WebElement closeDestination;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;
	
	@FindBy(xpath = "//label[text() = ' Bengaluru, India']")
	private WebElement radioButton;
	
	@FindBy(xpath = "//button[@class = 'cta widget-overlay-ok']")
	private WebElement searchButton;
	
	@FindBy(xpath = "(//label[text()='Free wifi'])[1]")
	private WebElement freeWifi;
	
	@FindBy(xpath = "//a[text()='Price']")
	private WebElement priceButton;
	
	@FindBy(id = "opt_STAR_RATING_HIGHEST_FIRST")
	private WebElement highToLow;
	
	public HotelsList(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@Test
	public void search(String passDestination)
	{
	//	closePopUp.click();
		checkout.click();
		selectDate.click();
		destination.sendKeys(passDestination);
		wait.implecitWaitForSeconds(driver, 5);
		closeDestination.click();
		submitButton.click();
		radioButton.click();
		searchButton.click();
		wait.explicitWait(driver, 10, freeWifi);
		freeWifi.click();
		priceButton.click();
		highToLow.click();		
	}
	
	public void errorMessage()
	{
//	Here you can pass some assertion or error messages	
	}
	
	public void verifyHomePage()
	{
//	Here you can verify home page using getTi
	}
	
}
