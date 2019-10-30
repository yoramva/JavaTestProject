package com.webdriver.framework;
import org.testng.annotations.Test;

public class TestRunner {

	@Test
	public void TestRunner() throws Exception 
	{
		 String strRowData  = "";
		 String strCols="";
		 int iRow = 0;
		 String strSkip="";
		 String strID="";
		 String strHeaders="";
		 boolean rc=false;
		 //Declaring the path of the Excel file with the name of the Excel file
		 String sPath = ".\\TestData\\dataEngine.xlsx";
		 //BaseClass bc = new BaseClass("dataEngine.properties");
		 new BaseClass("dataEngine.properties");
		 //Here we are passing the Excel path and SheetName to connect with the Excel file     
		 //This method was created previously
		 ReadExcelData.setExcelFile(sPath, "Sheet1");
		 //Hard coded values are used for Excel row & columns for now     
		 //Later on, we will use these hard coded value much more efficiently    
		 //This is the loop for reading the values of the column (Action Keyword) row by row 
		 //It means this loop will execute all the steps mentioned for the test case in Test Steps sheet

		 while(strSkip.compareToIgnoreCase("eof") != 0)
		 {
			 iRow++;
			 strID = ReadExcelData.getCellData(iRow, 0);
			 strSkip = ReadExcelData.getCellData(iRow, 1);
			 strHeaders = ReadExcelData.getCellData(iRow, 2);
			 if (strHeaders.trim().toLowerCase().equalsIgnoreCase("header"))
			 {
				 strCols = ReadExcelData.getSheetHeaders(iRow);
				 continue;
			 }
			 else
			 {
				 strRowData = ReadExcelData.getRowColumnData(iRow , strCols);
			 }
			 strRowData = "ID=" + strID + ";SKIP=" + strSkip + ";" + strRowData;
			 if (!strSkip.equalsIgnoreCase("x"))
				 rc = execute_Actions(strRowData); 
		 }
	}
	//This method contains the code to perform some action 
	//As it is completely different set of logic, which revolves around the action only, it makes sense to keep it separate from the main driver script 
	//This is to execute test step (Action)
	private static boolean execute_Actions(String strParams) throws Exception 
	 {
		String tc =  Utils.getValueBetweenStrings(strParams , "TESTCASE=", ";");
		if (!tc.equalsIgnoreCase("")){
			tc = "com.patrick.testcases." + tc;
			IAction action = (IAction)Class.forName(tc).newInstance();
			return action.execute(strParams);	
		}
		return true;
		
	 }	
}
