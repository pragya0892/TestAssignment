package com.selenium.generic;

import java.io.File;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		fileWithPath ="/Users/pragya.sharma/eclipse-workspace/Selenium/library"+".png";
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        //FileUtils.copyFile(SrcFile, DestFile);
    }
}
