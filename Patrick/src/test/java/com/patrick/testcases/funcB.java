package com.patrick.testcases;

import com.webdriver.framework.*;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class funcB implements IAction{
	@Override
	public boolean execute(String strParams,ExtentTest test) {
		 System.out.println(strParams);
		return true;
	}
}
