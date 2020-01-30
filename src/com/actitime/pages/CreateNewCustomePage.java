package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CreateNewCustomePage {
	@FindBy (xpath="//input[@name='name']")
	private WebElement newcustfield;
	@FindBy (xpath="//textarea[@name='description']")
	private WebElement custdescriptionfield;
	@FindBy (xpath="//input[@type='submit']")
	private WebElement createcustbtn;
	@FindBy (xpath="//input[@onclick='cancelCustomerCreation();']")
	private WebElement cancelbtn;
	public CreateNewCustomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void CustField(String custname)
	{
		newcustfield.sendKeys(custname);
	}
	public void custDescption(String description)
	{
		custdescriptionfield.sendKeys(description);
	}public void custCreateBtn()
	{
		createcustbtn.click();
	}public void cancelBtn()
	{
		cancelbtn.click();
	}
	


}
