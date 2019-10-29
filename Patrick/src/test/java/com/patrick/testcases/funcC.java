package com.patrick.testcases;

import com.webdriver.framework.IAction;

public class funcC implements IAction{
	@Override
	public boolean execute(String strParams) {
		 System.out.println(strParams);
		return true;
	}
}
