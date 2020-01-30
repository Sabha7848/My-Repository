package com.actitime.scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generics.BaseTest;
import com.actitime.generics.FWUtils;
import com.actitime.pages.CreateNewCustomePage;
import com.actitime.pages.CustomerandrojectsPage;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.Loginpage;
import com.actitime.pages.TasksListPage;

public class TestCreateCustomerPage extends BaseTest {
	@Test
	public void createCustomerTest()
	{
		
	
	Loginpage lp=new Loginpage(driver);
	String un = FWUtils.read_xl_data(XL_DATA_PATH, "validlogin",1, 0);
	String pwd = FWUtils.read_xl_data(XL_DATA_PATH, "validlogin",1, 1);
	String exp_title= FWUtils.read_xl_data(XL_DATA_PATH, "enter time track",1, 0);
	String Op_exp_title = FWUtils.read_xl_data(XL_DATA_PATH,"opentask",1,0);
    String custandPro_exp_title = FWUtils.read_xl_data(XL_DATA_PATH,"activeprojectandcustomer",1,0);
    String newcust_exp_title = FWUtils.read_xl_data(XL_DATA_PATH,"createcustomer",1,1);
 
    int Rc_newCust = FWUtils.read_Xl_Row("createcustomer");


	lp.setusername(un);
	lp.setpwd(pwd);
	lp.clicklogin();
	
	EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
    FWUtils.verifyPage(driver, exp_title);
	ep.clickOnTask();
	
	TasksListPage tl=new TasksListPage(driver);
	
	 FWUtils.verifyPage(driver, Op_exp_title);
   tl.clickOnCust_project();
   
   CustomerandrojectsPage cp=new CustomerandrojectsPage(driver);
   FWUtils.verifyPage(driver, custandPro_exp_title);
   cp.custbtn();
   
   
   CreateNewCustomePage nc = new CreateNewCustomePage(driver);
   FWUtils.verifyPage(driver, newcust_exp_title);
   for (int i = 1; i <=Rc_newCust; i++) {
	   String custname= FWUtils.read_xl_data(XL_DATA_PATH,"createcustomer",i,0);
	   nc.CustField(custname);
	   nc.custCreateBtn();
	   cp.custbtn();
	
}

   
	
	

	
	}

}
