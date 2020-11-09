package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UT04_DataDriven {

	public int getRowCount(String sheetname) throws IOException {
		FileInputStream file = new FileInputStream("../com.1kosmos/testdata/Testdata.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		return sheet.getLastRowNum();

	}

	public int getColCount(String sheetname) throws IOException {
		FileInputStream file = new FileInputStream("../com.1kosmos/testdata/Testdata.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		XSSFRow row = sheet.getRow(0);
		return row.getLastCellNum();
	}
	
	public String getValue(String sheetname, int rownum, int celnum) throws IOException
	{
		FileInputStream file = new FileInputStream("../com.1kosmos/testdata/Testdata.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		return sheet.getRow(rownum).getCell(celnum).getStringCellValue();
		
	}
	
}


