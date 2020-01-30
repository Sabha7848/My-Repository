package com.actitime.scripts;


import org.testng.annotations.Test;

import com.actitime.generics.BaseTest;
import com.actitime.generics.FWUtils;
import com.actitime.pages.CreateNewCustomePage;
import com.actitime.pages.CustomerandrojectsPage;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.Loginpage;

import com.actitime.pages.TasksListPage;

public class TestLogin extends BaseTest {
	@Test
	public void test1() throws InterruptedException 
	{
		Loginpage lp=new Loginpage(driver);
		String un = FWUtils.read_xl_data(XL_DATA_PATH, "validlogin",1, 0);
		String pwd = FWUtils.read_xl_data(XL_DATA_PATH, "validlogin",1, 1);
		String exp_title= FWUtils.read_xl_data(XL_DATA_PATH, "enter time track",1, 0);

		lp.setusername(un);
		lp.setpwd(pwd);
		lp.clicklogin();
		Thread.sleep(1000);
		FWUtils.verifyPage(driver, exp_title);
		EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
		
		
		
		
		
		
		
		
		ep.clickOnTask();
		TasksListPage te=new TasksListPage(driver);
		te.clickOnCust_project();
		CustomerandrojectsPage pe=new CustomerandrojectsPage(driver);
		pe.custbtn();
		CreateNewCustomePage ce=new CreateNewCustomePage(driver);
		ce.CustField("xyz");
		ce.custDescption("hgtftfg");
		ce.custCreateBtn();
		
		
		
	}

}
