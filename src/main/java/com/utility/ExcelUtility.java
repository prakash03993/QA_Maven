package com.utility;

import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	static FileReaderManager fileReader;
	 
	public static String readParticularCellData(int rowValue, int columnValue) {
	
		String data =  null;

	  try {
		  File file = new File(fileReader.getDataProperty("excelpath"));
		  
		  
		   Workbook book = new XSSFWorkbook(file);
		   Sheet sheet = book.getSheet("Data");
		   Row row = sheet.getRow(rowValue);
		   Cell cell = row.getCell(columnValue);
		   
		   DataFormatter dataFormat = new DataFormatter();
		   String data1 = dataFormat.formatCellValue(cell);
		   System.out.println(data1);
	  }catch (Exception e) {
		  e.printStackTrace();
	  }
	  return data;
}	
}
