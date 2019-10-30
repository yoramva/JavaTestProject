package com.webdriver.framework;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public interface IAction{
	 boolean execute(String strParams , ExtentTest test);
}
