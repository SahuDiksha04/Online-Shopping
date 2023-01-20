package com.crm.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility extends JavaUtility{

	

	public String readDataFromExcel(String SheetName, int RowNo, int ColumnNo) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet( SheetName);
		Row ro = sh.getRow(RowNo);
		Cell cel = ro.getCell(ColumnNo);
		String value = cel.getStringCellValue();
		return value;

	}
	
	public void writeDataIntoExcel(String SheetName, int RowNo,int ColumnNo, String data) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
	     Sheet sh= wb.getSheet(SheetName);
	     Row ro = sh.createRow(RowNo);
	     Cell cel = ro.createCell(ColumnNo);
	     cel.setCellValue(data);
	     FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
	     wb.write(fos);
	     
	}
	
	public int getLastRowNo(String Sheetname) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		int count = wb.getSheet(Sheetname).getLastRowNum();
		return count;
	}
	
	public HashMap<String,String>getList(String Sheetname,int keyCell,int valueCell) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		int count = sh.getLastRowNum();
		HashMap<String,String>map=new HashMap<String,String>();
		for(int i=0;i<=count;i++)
		{
			 String key = sh.getRow(i).getCell(keyCell).getStringCellValue();
			 String value = sh.getRow(i).getCell(valueCell).toString();
			 map.put(key, value);
			 
		}
		return map;
		
	}
	
	
	public Object[][] readFromExcelSetOfData(String Sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		int lastRow = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();
		
		
		Object[][] obj = new Object[lastRow][lastCell];
		for(int i = 0;i<lastRow;i++)
		{
			for(int j = 0;j<lastCell;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).toString();
			}
			
	    }
		return obj;

    }

}
