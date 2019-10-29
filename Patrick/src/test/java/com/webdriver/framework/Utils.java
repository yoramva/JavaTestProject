package com.webdriver.framework;
import org.apache.commons.lang3.StringUtils;
public  class Utils {
	
	public static String getValueBetweenStrings(String mainString , String beforeStr , String afterStr)
	{
		if (mainString !="")
			return StringUtils.substringBetween(mainString.trim(), beforeStr.trim(), afterStr.trim());
		return "";
	}

}
