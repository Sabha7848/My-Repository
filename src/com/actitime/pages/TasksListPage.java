package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TasksListPage {
	@FindBy(xpath="//a[text()='Completed Tasks']")
    private WebElement completed_task;
	@FindBy(xpath="//a[text()='Open Tasks']")
	private WebElement opentask;
	@FindBy (xpath="//a[text()='Projects & Customers']")
	private WebElement project_customer;
	@FindBy (xpath="//a[text()='Archives']")
	private WebElement archives;
	@FindBy (xpath="//input[@value='Create New Tasks']")
     private WebElement createnewtaskbtn;
	public TasksListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOncompletedtask()
	{
		completed_task.click();
	}
	public void clickOnopentask()
	{
		opentask.click();
	}
	public void clickOnCust_project()
	{
		project_customer.click();
	}
	public void clickOnArchives()
	{
		archives.click();
	}
	public void clickOnCreateTaskBtn()
	{
		createnewtaskbtn.click();
	}
	
	
	
}
