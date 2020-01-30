package com.actitime.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;


public class Loginpage {
	@FindBy(xpath="//input[@name='username']")
	private WebElement untb;
	@FindBy(xpath="//input[@name='pwd']")
	private WebElement pwtb;
	@FindBy(id="loginButton")
	private WebElement lgn;
	@FindBy (xpath="//span[contains(text(),'Username')]")
	private WebElement errmsg;

		public Loginpage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			}
		public void setusername(String usr)
		{
			untb.clear();
			untb.sendKeys(usr);
		}
		public void setpwd(String pw)
		{
			pwtb.sendKeys(pw);
		}
        public void clicklogin()
       {
	    lgn.click();
	    }
        public void clearun()
        {
        	untb.clear();
        }
        public void verifyerrormsg()
    	{
    		Assert.assertTrue(errmsg.isDisplayed());
    		Reporter.log("the error msg is====>"+errmsg.getText(),true);
    	}


}
