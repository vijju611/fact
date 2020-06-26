package com.Tyss.factframework.lib;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.Tyss.factframework.init.IConstants;


public class ExcelLib {
	
public static String readDataFromExcel(String sheet, int row, int cell,String filePath) {
	String val= " "	;
	try
		{
		FileInputStream fis=new FileInputStream(filePath);
		Workbook wb=WorkbookFactory.create(fis);//create java object file
	     Cell c =  wb.getSheet(sheet).getRow(row).getCell(cell);
	     val = c.getStringCellValue();
}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return val;
}
	}
