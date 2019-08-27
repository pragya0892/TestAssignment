package com.selenium.scripts;

import org.testng.annotations.Test;

import com.selenium.generic.BaseLibrary;
import com.selenium.generic.ExcelLiberary;
import com.selenium.pom.HotelsList;

public class TestHotels extends BaseLibrary{
	
	private String passDestination = "Bengaluru, India";

	@Test
	public void searchHotelsTest()
	{
		HotelsList hotelList = new HotelsList(driver);
		ExcelLiberary excelLibrary = new ExcelLiberary();
		hotelList.search(passDestination );
		excelLibrary.writeExcel();			
	}

}
