package com.actitime.scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class TestExl {
	@Test
	static void test1()
	{
		
			try {
			 Workbook wb=WorkbookFactory.create(new FileInputStream("./report/results.xlsx"));
			 wb.getSheet("Sheet1").createRow(1).createCell(0).setCellValue(4);
			wb.write(new FileOutputStream("./report/results.xlsx")) ;
			wb.getSheet("Sheet1").createRow(1).createCell(1).setCellValue(5);
			wb.write(new FileOutputStream("./report/results.xlsx")) ;
				
			}
				
			 catch(Exception e)
			{
				 e.printStackTrace();
			}
		
		}
	

}
