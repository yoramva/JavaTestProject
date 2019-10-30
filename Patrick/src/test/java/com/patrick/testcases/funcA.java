package com.patrick.testcases;
import com.webdriver.framework.*;

import com.webdriver.framework.BaseClass;

public class funcA implements IAction{
	@Override
	public boolean execute(String strParams) {
		 System.out.println(strParams);
		 System.out.println("x=" + BaseClass.getPropValue("x"));
		 
		return true;
		
	}
	


}
