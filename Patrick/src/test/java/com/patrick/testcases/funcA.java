package com.patrick.testcases;
import com.webdriver.framework.*;


public class funcA implements IAction{
	@Override
	public boolean execute(String strParams) {
		 System.out.println(strParams);
		 System.out.println("x=" + BaseClass.getPropValue("x"));
		 BaseClass.setPropValue("x", "1000000");
		return true;
		
	}
	


}
