package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CustomerandrojectsPage {
	@FindBy (xpath="//input[@value='Create New Customer']")
	private WebElement newcustbtn;
	
	@FindBy (xpath="//input[@value='Create New Project']")
	private WebElement newprojectbtn;
	//@FindBy (id="ext-gen23")
	//private WebElement importprojectdropdown;
	//@FindBy (xpath="//span[text()='Create Customer']")

	public CustomerandrojectsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		}
	public void custbtn()
	{
		newcustbtn.click();
	}
	public void projectbtn()
	{
	    newprojectbtn.click();
	}
	/*public void dropDownImport()
	{
		importprojectdropdown.click();
	}
	public void createCust()
	{
		Createcust.click();;
	}
	public void cancel()
	{
		cancelbtn.click();;
	}*/
	
	
}
