package com.patrick.testcases;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.webdriver.framework.*;


public class funcC  implements IAction{
	@Override
	public boolean execute(String strParams,ExtentTest test) {
		 System.out.println(strParams);
		 boolean rc=true;

		return true;
	}
}
