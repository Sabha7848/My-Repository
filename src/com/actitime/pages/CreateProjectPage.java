package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class CreateProjectPage {
	@FindBy (xpath="//select[@name='customerId']")
	private WebElement selectcustid;
	@FindBy (xpath="//input[@type='text']")
	private WebElement projectname;
	@FindBy (xpath="//input[@name='createProjectSubmit']")
	private WebElement createprojectbtn;
	public CreateProjectPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void selectCustId(String custId)
	{
		Select se=new Select(selectcustid);
		se.selectByVisibleText(custId);
	}
	public void projectNameField(String name)
	{
		projectname.sendKeys(name);
	}
	public void createProjBtn()
	{
		createprojectbtn.click();
	}


}
