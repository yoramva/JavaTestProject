package com.patrick.testcases;
import com.webdriver.framework.*;

public class funcB implements IAction{
	@Override
	public boolean execute(String strParams) {
		 System.out.println(strParams);
		return true;
	}
}
