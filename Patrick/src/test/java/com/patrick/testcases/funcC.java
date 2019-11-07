package com.patrick.testcases;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.webdriver.framework.*;


public class funcC  implements IAction{
	@Override
	public boolean execute(String strParams,ExtentTest test) 
	{
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		 
		  driver.get("https://www.waves.com/plugins");
		  Actions action = new Actions(driver);
		  WebElement products = driver.findElement(By.id("top-menu-nav")).findElement(By.cssSelector("li[data-id='products']"));
		  action.moveToElement(products).perform();
		  WebElement e = driver.findElement(By.cssSelector("div[class='tab box']"));
		  List<WebElement> footlinks = e.findElements(By.tagName("a"));
		 
		  int i = footlinks.size(); //Get number of links
		  
		  for(int j = 0;j<i;j++)
		  {    //create loop based upon number of links to traverse all links
			  action.moveToElement(footlinks.get(j)).click().perform(); 
				   
		  }
		return true;
	}
}
