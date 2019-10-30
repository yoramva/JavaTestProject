package com.patrick.testcases;
import com.webdriver.framework.*;

public class funcC  implements IAction{
	@Override
	public boolean execute(String strParams) {
		 System.out.println(strParams);
		return true;
	}
}
