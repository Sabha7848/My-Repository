package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EnterTimeTrackPage {
	@FindBy (xpath="//div[text()='Tasks']/..")
	private WebElement task;
	@FindBy (xpath="//div[text()='Users']/..")
	private WebElement users;
	@FindBy (xpath="//div[text()='Reports']/..")
	private WebElement reports;
	@FindBy (xpath="//div[text()='Time-Track']/..")
	private WebElement timetrack;
	@FindBy (xpath="//div[text()='Work Schedule']/..")
	private WebElement work_schedule;
	@FindBy (xpath="//div[text()='Settings']/..")
	private WebElement setting;

	public EnterTimeTrackPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnTimetrack()
	{
		timetrack.click();
	}
	public void clickOnTask()
	{
		task.click();
	}
	public void clickOnUsers()
	{
		users.click();
	}
	public void clickOnReports()
	{
		reports.click();
	}
	public void clickOnSetting()
	{
		setting.click();
	}
	public void clickOnWorkScedule()
	{
	      work_schedule.click();
	}
	
	
}
