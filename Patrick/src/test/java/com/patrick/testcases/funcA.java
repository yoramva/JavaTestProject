package com.patrick.testcases;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.patrick.utils.JSWaiter;
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
		 
		 JSWaiter.setDriver(driver);
		 
				 
		 //driver.get("http://www.google.com");
		 driver.get("https://www.waves.com/plugins");
		 JSWaiter.waitUntilJQueryReady();
		 driver.manage().window().maximize();
		 //List<WebElement> listOfElements = driver.findElements(By.xpath("//article[@data-type='jplist-item']"));
		 List<WebElement> listOfElements = driver.findElements(By.cssSelector("article[data-type='jplist-item']"));
		 for(int i=0 ; i<listOfElements.size();i++)
		 {
			 //WebElement rect = listOfElements.get(i).findElement(By.cssSelector("div[class='jplist-item-target']"));
			 WebElement rect = listOfElements.get(i);
			 String link = rect.findElement(By.cssSelector(".title > a")).getText();
			 System.out.println(link);
			 Utils.scrollToElementByOffset(driver , rect, 0);
			 
			 WebElement addToCartRect = rect.findElement(By.cssSelector("div[class='add-to-cart-flex relative']"));

			 WebElement webElement = rect.findElement(By.linkText("ADD TO CART"));

			 
			 
			 Utils.scrollToElementByOffset(driver , webElement, -200).click();
			 
			 //rect.findElement(By.linkText("ADD TO CART")).click();
			 
			 driver.findElement(By.id("cboxClose")).click();

		 }
		 driver.close();
		return true;	
	}
}
