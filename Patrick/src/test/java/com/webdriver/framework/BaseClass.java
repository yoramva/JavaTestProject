package com.webdriver.framework;
import java.io.File;
import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
public class BaseClass {
	
	private static String propertyFile;
	
	public BaseClass(String propFile)
	{
		propertyFile = ".\\PropertiesData\\" + propFile;
		File file = new File(propertyFile);
		try
	    {
			 if (file.createNewFile()) 
			 {
	                System.out.println("New Text File is created!");
	         } 
			 else 
			 {
	                System.out.println("File already exists.");
	         }
	    	
	      
	    } 
	    catch (IOException io)
	    {
	        io.printStackTrace();
	    } 
		
	}
	
	public static String getPropFile()
	{
		return(propertyFile);
		
	}
	public static String getPropValue(String byKey)
	{
		PropertiesConfiguration conf = null;
		try {
			conf = new PropertiesConfiguration(propertyFile);
		} catch (ConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		 String x = conf.getString(byKey);
		 return x;
	}
	public static void setPropValue(String key , String value)
	{

		PropertiesConfiguration conf = null;
		try {
			conf = new PropertiesConfiguration(propertyFile);
		} catch (ConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		conf.setProperty(key, value);
		try {
			conf.save();
		} catch (ConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}    
	}

   
}
