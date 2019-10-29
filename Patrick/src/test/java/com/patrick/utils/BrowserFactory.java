package com.patrick.utils;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
public class BrowserFactory {
	
	
	public static WebDriver startApplication(WebDriver driver , String browserName , String appUrl)
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
			
			
		}
		else
		{
			System.out.println("We do not support " + browserName);
		}
		driver.get(appUrl);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		return driver;
	}
	
	public static void quitApplication(WebDriver driver)
	{
		driver.close();
	}
	

}
