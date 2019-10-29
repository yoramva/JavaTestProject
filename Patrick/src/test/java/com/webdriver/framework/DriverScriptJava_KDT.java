package com.webdriver.framework;


import java.lang.reflect.Method;






public class DriverScriptJava_KDT
{
 //This is a class object, declared as 'public static'
 //So that it can be used outside the scope of main[] method
 public static Actions actionKeywords;
 public static String sActions;
 //This is reflection class object, declared as 'public static' 
 //So that it can be used outside the scope of main[] method
 public static Method method[];

 public static void main(String[] args) throws Exception 
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
			 execute_Actions(strRowData); 
	 }
	 
	
 }
 
 
//This method contains the code to perform some action 
//As it is completely different set of logic, which revolves around the action only, it makes sense to keep it separate from the main driver script 
//This is to execute test step (Action)
private static void execute_Actions(String strParams) throws Exception 
 {
	String tc =  Utils.getValueBetweenStrings(strParams , "TESTCASE=", ";");
	if (!tc.equalsIgnoreCase("")){
		tc = "com.patrick.testcases." + tc;
		IAction action = (IAction)Class.forName(tc).newInstance();
		boolean flag = action.execute(strParams);	
	}
	
 }
}
