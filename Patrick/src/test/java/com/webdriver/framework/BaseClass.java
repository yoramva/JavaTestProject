package com.webdriver.framework;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
		Properties p = new Properties();
		try 
		{
			p.load(new FileInputStream(propertyFile));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value =  p.getProperty(byKey);
		
		p=null;
		return value;

	}
	public static void setPropValue(String key , String value)
	{
		Properties p = new Properties();
		try 
		{
			p.load(new FileInputStream(propertyFile));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setProperty(key, value);
		p=null;
	}

   
}
