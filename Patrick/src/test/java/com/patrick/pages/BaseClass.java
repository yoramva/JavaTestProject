package com.patrick.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.patrick.utils.BrowserFactory;

public class BaseClass {
	
	public WebDriver driver;
	@BeforeClass
	public void setup()
	{
		driver = BrowserFactory.startApplication(driver, "Chrome", "http://vTest/dev/login");
	}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitApplication(driver);
	}
	

}
