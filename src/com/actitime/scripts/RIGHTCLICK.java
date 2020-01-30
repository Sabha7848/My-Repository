package com.actitime.scripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RIGHTCLICK {
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException, AWTException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost/login.do");
		
		WebElement linkText = driver.findElement(By.xpath("//a[text()='Actimind Inc.']"));
		linkText.click();
		Thread.sleep(1000);
		
		Actions act=new Actions(driver);
		
		Set<String> w = driver.getWindowHandles();
		System.out.println(w);
		WebElement tg = driver.findElement(By.xpath("//a[@class='//a/']"));
		driver.switchTo().frame("w[1]");
		act.moveToElement(tg).perform();
		WebElement twb = driver.findElement(By.linkText("Web Browser Plug-ins"));
	twb.click();
		//Robot r=new Robot();
		//r.keyPress(KeyEvent.VK_T);
		
	}

}