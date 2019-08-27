package com.selenium.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class BaseLibrary {
	
public WebDriver driver;
public WaitStatement wait;
public SoftAssert sassert;
public Screenshot screenshot;
	
@BeforeMethod
@Parameters(value = "browser")
public void preCondition(String browser)
{
	String url ="https://in.hotels.com";
	
	if(browser.equalsIgnoreCase("Firefox"))
	{
		driver = new FirefoxDriver();
		Reporter.log("Firefox driver is launched", true);	
	}
	else if(browser.equalsIgnoreCase("Chrome"))
	{
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
		Reporter.log("Chrome driver is launched", true);	
	}
	driver.manage().window().maximize();
	driver.get(url);
	Reporter.log("Navigating to the url", true);	
	wait.implecitWaitForSeconds(driver, 20);
}

@AfterMethod
public void postCondition(ITestResult result) throws Exception
{
	if(result.isSuccess())
	{
		driver.close();
	}
	
	else
	{
	String fileName = result.getMethod().getMethodName();	
	Screenshot.takeSnapShot(driver,fileName);
	Reporter.log("Screenshot has been taken", true);	
	}
}

/*@Test
public void test()
{
	driver.findElement(By.xpath("//button[@aria-label='Close overlay']")).click();
	driver.findElement(By.id("qf-0q-localised-check-out")).click();
	driver.findElement(By.xpath("//a[text()='31']")).click();
	driver.findElement(By.id("qf-0q-destination")).sendKeys("Bengaluru, India");
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//button[text()=\'close\' and @class = \'cta cta-link\']")).click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	driver.findElement(By.xpath("//label[text() = \" Bengaluru, India\"]")).click();
	driver.findElement(By.xpath("//button[@class = \"cta widget-overlay-ok cta-disabled\"]")).click();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("(//label[text()='Free wifi'])[1]")).click();
	driver.findElement(By.xpath("//a[text()='Price']")).click();
	driver.findElement(By.id("opt_STAR_RATING_HIGHEST_FIRST")).click();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);	
}*/

}
