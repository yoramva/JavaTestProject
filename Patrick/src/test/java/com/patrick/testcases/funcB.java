package com.patrick.testcases;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import com.webdriver.framework.*;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.patrick.utils.JSWaiter;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class funcB implements IAction{
	@Override
	public boolean execute(String strParams,ExtentTest test) {
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 
		 driver.get("https://www.waves.com/plugins");
		 JSWaiter.waitUntilJQueryReady();
		  WebElement footer= driver.findElement(By.cssSelector("div.vmenu-list"));  // Get Footer element which contains all footer links
		  System.out.println(footer.findElements(By.tagName("a")).size()) ;
		  List<WebElement> footlinks = footer.findElements(By.tagName("a"));
		  int i = footer.findElements(By.tagName("a")).size(); //Get number of links

		  for(int j = 0;j<i;j++)
		  {
			  //create loop based upon number of links to traverse all links
		  
			  JSWaiter.waitUntilJQueryReady();
			  
			   footer= driver.findElement(By.cssSelector("div.vmenu-list"));    // We are re-creating "footer" webelement as DOM changes after navigate.back()
			   String linkText = footer.findElements(By.tagName("a")).get(j).getText();
			   Utils.scrollToElementByOffset(driver , footer, 0);
			   footer.findElements(By.tagName("a")).get(j).click();
			   JSWaiter.waitUntilJQueryReady();
			   System.out.println(linkText + "=" + driver.getTitle());
		      if(driver.getTitle().contains("404"))
		      {
		       System.out.println("404 Found");
		      }
		      driver.navigate().back();
		  return true;
	}
}
