package com.webdriver.framework;
import java.lang.reflect.Method;
import org.testng.annotations.Test;

public class TestDriver {
	 //This is a class object, declared as 'public static'
	 //So that it can be used outside the scope of main[] method
	 public static Actions actionKeywords;
	 public static String sActions;
	 //This is reflection class object, declared as 'public static' 
	 //So that it can be used outside the scope of main[] method
	 public static Method method[];
	 @Test
	 public void TC_Driver() throws Exception 
	 {
		 //Declaring the path of the Excel file with the name of the Excel file
		 String sPath = ".\\TestData\\dataEngine.xlsx";
		 //Here we are passing the Excel path and SheetName to connect with the Excel file     
		 //This method was created previously
		 ReadExcelData.setExcelFile(sPath, "Sheet1");
		 //Hard coded values are used for Excel row & columns for now     
		 //Later on, we will use these hard coded value much more efficiently    
		 //This is the loop for reading the values of the column (Action Keyword) row by row 
		 //It means this loop will execute all the steps mentioned for the test case in Test Steps sheet
		 String strRowData  = "";
		 String strCols="";
		 boolean headerInd=false;
		 int iRow = 0;
		 String strSkip="";
		 String strID="";
		 String strHeaders="";
		 
		 while(strSkip.compareToIgnoreCase("eof") != 0)
		 {
			 iRow++;
			 strID = ReadExcelData.getCellData(iRow, 0);
			 strSkip = ReadExcelData.getCellData(iRow, 1);
			 strHeaders = ReadExcelData.getCellData(iRow, 2);
			 if (strHeaders.trim().toLowerCase().equalsIgnoreCase("header"))
			 {
				 headerInd = true;
				 strCols = ReadExcelData.getSheetHeaders(iRow);
				 continue;
			 }
			 else
			 {
				 headerInd = false;

				 strRowData = ReadExcelData.getRowColumnData(iRow , strCols);
			 }
			 
			 strRowData = "ID=" + strID + ";SKIP=" + strSkip + ";" + strRowData;
			
			 if (!strSkip.equalsIgnoreCase("x"))
			 //A new separate method is created with the name 'execute_Actions'
			 //You will find this method below of the this test 
			 //So this statement is doing nothing but calling that piece of code to execute
				 execute_Actions(strRowData); 
		 }
		 
		
	 }
	//This method contains the code to perform some action 
	//As it is completely different set of logic, which revolves around the action only, it makes sense to keep it separate from the main driver script 
	//This is to execute test step (Action)
	private static void execute_Actions(String strParams) throws Exception 
	 {
		String tc = Utils.getValueBetweenStrings(strParams , "TESTCASE=", ";");
		
		 //Here we are instantiating a new object of class 'Actions'
		 Actions actionKeywords = new Actions();
		 //This will load all the methods of the class 'Actions' in it. 
		 //It will be like array of method, use the break point here and do the watch 
		 method = actionKeywords.getClass().getMethods();
		 //This is a loop which will run for the number of actions in the Action Keyword class 
		 //method variable contain all the method and method.length returns the total number of methods
		 for(int i = 0;i<method.length;i++)
		 {
			  //This is now comparing the method name with the ActionKeyword value received from the excel
			  if(method[i].getName().equals(tc))
			  { //In case of match found, it will execute the matched method 
				  method[i].invoke(actionKeywords,strParams);
				  //Once any method is executed, this break statement will take the flow outside of for loop
			  		break;
			  }
		 }
	 }
}
