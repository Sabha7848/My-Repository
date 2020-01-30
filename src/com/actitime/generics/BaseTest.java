package com.actitime.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

abstract public class BaseTest implements IAUTOConstant {
	static {
		System.setProperty(chrome_key,chrome_value);
		System.setProperty(gecko_key,gecko_value);
	}
	public static int passCount=0,failCount=0;
	public WebDriver driver;
	@BeforeClass
	@Parameters("browser")
	public void openBrowser(String browser)
	{
		if (browser.equals("chrome")) {
			driver=new ChromeDriver();
			
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
			
			driver=new InternetExplorerDriver();
	}
 @BeforeMethod
 public void openApplication()
 {
	 driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
	 driver.manage().timeouts().pageLoadTimeout(PLTO,TimeUnit.SECONDS);
	 driver.get(URL);
 }
/* @AfterMethod
 public void close(ITestResult res)
 {
	 String testCName=res.getName();
	 int status=res.getStatus();
	 if(status==1)
	 {
		 passCount++;
		 System.out.println("passcount is====>"+passCount);
	 }
	 else
	 {
		 failCount++;
		 String ftName_path = photo_path+testCName+".png";
		 FWUtils.takesScreenShot(driver,ftName_path);
	 }
	driver.close();
 }*/
}
