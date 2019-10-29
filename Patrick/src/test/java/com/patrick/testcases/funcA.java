package com.patrick.testcases;

import com.webdriver.framework.IAction;

public class funcA implements IAction{
	@Override
	public boolean execute(String strParams) {
		 System.out.println(strParams);
		return true;
	}
}
