package com.webdriver.framework;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestRunner {

	//@Parameters({ "environmentId" , "testsetName" })
	@Test
	//public void TestRunner(String environmentId , String testsetName) throws Exception 
	public void TestRunner()
	{
		String testsetName="Sanity";
		String environmentId="11";
		 String strRowData  = "";
		 String strCols="";
		 String strSkip="";
		 String strID="";
		 String strHeaders="";
		 boolean rc=false;
		 String curr_date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		 ExtentReports report = new ExtentReports("c:\\" + testsetName + "_" + curr_date + ".html");
		//Declaring the path of the Excel file with the name of the Excel file
		 String sPath = ".\\TestData\\"+testsetName+".xlsx";
		 new BaseClass(testsetName + ".properties");
		 //Here we are passing the Excel path and SheetName to connect with the Excel file     
		 //This method was created previously
		 ReadExcelData.setExcelFile(sPath, "Sheet1");
		 
		 int rows = ReadExcelData.getSheetRowCount();
		 
		 for(int iRow=1;iRow<rows;iRow++)
		 {
			 strSkip = ReadExcelData.getCellData(iRow, 1);
			 if (strSkip.compareToIgnoreCase("eof")==0)
				 break;
			 strID = ReadExcelData.getCellData(iRow, 0);
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
			 {
				 ExtentTest test = report.startTest(Utils.getValueBetweenStrings(strRowData , "TESTCASE=", ";"));
				 rc = execute_Actions(strRowData,test);
				 if(rc)
				 {
					 test.log(LogStatus.PASS, "pass");
				 }
				 else
				 {
					 test.log(LogStatus.FAIL, "fail");
				 }
				 report.endTest(test);
	
			 }

		 }

		 report.flush();
	}
	//This method contains the code to perform some action 
	//As it is completely different set of logic, which revolves around the action only, it makes sense to keep it separate from the main driver script 
	//This is to execute test step (Action)
	private static boolean execute_Actions(String strParams,ExtentTest test) throws Exception 
	 {
		
		
		String tc =  Utils.getValueBetweenStrings(strParams , "TESTCASE=", ";");
		
		
		if (!tc.equalsIgnoreCase("")){
			tc = "com.patrick.testcases." + tc;
			IAction action = (IAction)Class.forName(tc).newInstance();
			return (action.execute(strParams,test));	 
		}
		return true;
		
	 }	
}
