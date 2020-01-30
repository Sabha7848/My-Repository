package com.actitime.generics;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FWUtils extends BaseTest implements IAUTOConstant {
	/**
	 * this method is used to verify the page
	 * @param driver
	 * @param expectedtitle
	 */
	public static void verifyPage(WebDriver driver,String expectedtitle )
	{
		WebDriverWait wait=new WebDriverWait(driver,ETO);
		wait.until(ExpectedConditions.titleIs(expectedtitle));
		String actualtitle=driver.getTitle();
		Assert.assertEquals(actualtitle, expectedtitle);
		System.out.println("the expected totle is"+expectedtitle);
		
	}
	/**
	 * This method is used to read the data from the excel.
	 * @param patht
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 */
	public static String read_xl_data(String path,String sheet,int row,int cell)
	{
		String data="";
		try {
		 Workbook wb=WorkbookFactory.create(new FileInputStream(path));
		 data=wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		}
		 catch(Exception e)
		{
			 e.printStackTrace();
		}
		return data;
	}
	/**
	 * This method is used to write Reportdata into excel. 
	 * @param path
	 * @param sheet
	 * @param row
	 * @param cell
	 * @param v
	 * @return
	 */
	public static int write_xl_data(String path,String sheet,int row,int cell,int v) 
	{
		
		try {
		 Workbook wb=WorkbookFactory.create(new FileInputStream(path));
		 wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(v);
		wb.write(new FileOutputStream(path));
			
		}
			
		 catch(Exception e)
		{
			 e.printStackTrace();
		}
	return v;
	}
	/**
	 * this method used to Read the no of rows
	 * @param sheet
	 * @return
	 */
 public static int read_Xl_Row(String sheet)
 {
	 int rc=0;
	 try
	 {
		 Workbook wb=WorkbookFactory.create(new FileInputStream("./data/input.xlsx"));
         rc= wb.getSheet(sheet).getLastRowNum();
		 
	 }
	 catch(Exception e)
		{
			 e.printStackTrace();
		}
	return rc;
	 
 }
 /**
  * This method is used to TakesScreenShot
  * @param driver
  * @param path
  */
 public static void takesScreenShot(WebDriver driver,String path) 
 
 {
	 try {
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File des=new File(path);
	FileUtils.copyFile(src, des);}
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
 }
 public static Actions action(WebDriver driver)
 {
	 return new Actions(driver);
 }
 public static Select select(WebElement ele)
 {
	 return select(ele);
 }
 public static Robot robot()
 {
	 Robot r=null;
	 try {
		 r=new Robot();
	 }
	 catch(Exception e)
	 {
		e.printStackTrace(); 
	 }
	 return r;
 }
 public static WebDriverWait expwait(WebDriver driver)
 {
	 return new WebDriverWait(driver, ETO);
 }
}
