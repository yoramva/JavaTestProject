package com.webdriver.framework;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;


public class ReadExcelData
{
 private static XSSFSheet ExcelWSheet;
 private static XSSFWorkbook ExcelWBook;
 private static XSSFCell Cell; 
 //This method is to set the File path and to open the Excel file
 //Pass Excel Path and SheetName as Arguments to this method
 public static void setExcelFile(String Path,String SheetName) throws Exception 
 {
	 FileInputStream ExcelFile = new FileInputStream(Path);
	 ExcelWBook = new XSSFWorkbook(ExcelFile);
	 ExcelWSheet = ExcelWBook.getSheet(SheetName);
 }
 //This method is to read the test data from the Excel cell
 //In this we are passing parameters/arguments as Row Num and Col Num
 public static String getCellData(int RowNum, int ColNum) throws Exception
 {
	
	 
		 Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		 if (Cell != null)
			 return Cell.getStringCellValue();
	 	 return "";
 }
 
 public static String getSheetColumns() throws Exception
 {
	 return getRowColumnData(0 , "");
	
 }
 
 public static String getSheetHeaders(int RowNum) throws Exception
 {
	 int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
	 String strRow="";
	 for(int i=2; i<noOfColumns;i++)
	 {
		 String cellData = getCellData(RowNum, i);
		 if (cellData.compareToIgnoreCase("")!=0)
		 {
				strRow = strRow +  cellData + ";";
		 }
		 else
		 {
			 break;
		 }
	 }
	 return strRow;
 }
 public static String getRowColumnData(int RowNum , String columns) throws Exception
 {
	 int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();
	 String strRow = "";
	 String[] arrCols = columns.split(";");
	 int max_cols = arrCols.length + 2;
	 int start_col = 2;
	 int idx = 0;
	 for(int i=start_col; i<max_cols;i++)
	 {
		 strRow = strRow + arrCols[idx++] + "=" +  getCellData(RowNum, i) + ";";
	 }
	 return strRow;
 }
 
 
 
}
