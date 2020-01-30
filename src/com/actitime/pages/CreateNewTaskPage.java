package com.actitime.pages;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewTaskPage {
	@FindBy (xpath="//select[@name='customerId']")
	private WebElement select_cust;
	@FindBy (xpath="//select[@name='projectId']")
	private WebElement select_proj;
	@FindBy (xpath="//input[@name='task[0].name']")
	private WebElement task_name1;
	@FindBy (xpath="//input[@value='Create Tasks']")
    private WebElement createtaskbtn;

	//input[@value='Create Tasks']
	public CreateNewTaskPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void selCust(String custname)
	{
		Select sel=new Select(select_cust);
		sel.selectByVisibleText(custname);
	}
	public void selproject(String projectname)
	{
		Select sel=new Select(select_proj);
		sel.selectByVisibleText(projectname);
	}
	public void taskfield1(String tskname)
	{
		task_name1.sendKeys(tskname);
	}
	public void craeteTaskBtn()
	{
		createtaskbtn.click();
	}

}
