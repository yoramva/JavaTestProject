package com.patrick.testcases;
import com.webdriver.framework.IAction;
import com.webdriver.framework.BasicClass;

public class funcA implements IAction{
	@Override
	public boolean execute(String strParams) {
		 System.out.println(strParams);
		 System.out.println(BasicClass.getPropFile().toString());
		return true;
		
	}
	


}
