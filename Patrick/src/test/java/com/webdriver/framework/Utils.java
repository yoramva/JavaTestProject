package com.webdriver.framework;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;

public  class Utils {
	
	public static String getValueBetweenStrings(String mainString , String beforeStr , String afterStr)
	{
		if (mainString !="")
			return StringUtils.substringBetween(mainString.trim(), beforeStr.trim(), afterStr.trim());
		return "";
	}

	
	//This method is to capture the screenshot and return the path of the screenshot.
	 public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException
	 {
		 String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		 TakesScreenshot ts = (TakesScreenshot) driver;
		 File source = ts.getScreenshotAs(OutputType.FILE);
		 // after execution, you could see a folder "FailedTestsScreenshots" under src folder
		 String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		 File finalDestination = new File(destination);
		 FileUtils.copyFile(source, finalDestination);
		 return destination;
	 }
}
