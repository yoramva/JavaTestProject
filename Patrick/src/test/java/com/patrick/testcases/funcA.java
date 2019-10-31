package com.patrick.testcases;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.webdriver.framework.*;


public class funcA implements IAction{


	@Override
	public boolean execute(String strParams,ExtentTest test) {
	
	
		 System.out.println(strParams);
		 System.out.println("x=" + BaseClass.getPropValue("x"));
		 BaseClass.setPropValue("x", "1000000");
		 test.log(LogStatus.PASS, "Update to config file done");
		 
		 System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.get("http://www.google.com");
		 driver.findElement(By.name("q")).sendKeys("trading");
		 driver.findElement(By.name("q")).sendKeys(Keys.TAB);
		 driver.close();
		return true;	
	}
}
