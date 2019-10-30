package com.patrick.testcases;
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
		return true;	
	}
}
