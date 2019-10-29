package com.webdriver.framework;

import java.io.FileOutputStream;
import java.io.IOException;

public class BasicClass {
	
	private static String propertyFile;

	public BasicClass(String propFile)
	{
		propertyFile = ".\\PropertiesData\\" + propFile;
		try
	    {
	    	new FileOutputStream(propertyFile, true).close();
	    	//output = new FileOutputStream(".\\PropertiesData\\" + this.propertyFile, true);
	      
	    } 
	    catch (IOException io)
	    {
	        io.printStackTrace();
	    } 
		
	}
	public static void setPropFile(String propFile)
	{
		propertyFile = propFile;
		
	}
	public static String getPropFile()
	{
		return(propertyFile);
		
	}
   
}
