package com.actitime.scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generics.BaseTest;
import com.actitime.generics.FWUtils;
import com.actitime.pages.CreateNewCustomePage;
import com.actitime.pages.CreateProjectPage;
import com.actitime.pages.CustomerandrojectsPage;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.Loginpage;
import com.actitime.pages.TasksListPage;

public class TestCreateNewProject extends BaseTest {
	@Test
	public void createProjectest()
	{
		
	
	Loginpage lp=new Loginpage(driver);
	String un = FWUtils.read_xl_data(XL_DATA_PATH, "validlogin",1, 0);
	String pwd = FWUtils.read_xl_data(XL_DATA_PATH, "validlogin",1, 1);
	String exp_title= FWUtils.read_xl_data(XL_DATA_PATH, "enter time track",1, 0);
	String Op_exp_title = FWUtils.read_xl_data(XL_DATA_PATH,"opentask",1,0);
    String custandPro_exp_title = FWUtils.read_xl_data(XL_DATA_PATH,"activeprojectandcustomer",1,0);
    String newcust_exp_title = FWUtils.read_xl_data(XL_DATA_PATH,"createcustomer",1,1);
    String newproj_exp_title=FWUtils.read_xl_data(XL_DATA_PATH,"createnewproject",1, 1);
    Reporter.log(newproj_exp_title,true);
    int Rc_newCust = FWUtils.read_Xl_Row("createcustomer");
    int Rc_newproj=FWUtils.read_Xl_Row("createnewproject");


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
    cp.projectbtn();
    
    
       
    CreateProjectPage cnpp=new CreateProjectPage(driver);
	FWUtils.verifyPage(driver,newproj_exp_title );
		
		for(int j=1; j<=Rc_newproj;j++)
		{
			String cn = FWUtils.read_xl_data(XL_DATA_PATH,"CreateCustomer",j,0);
			cnpp.selectCustId(cn);
			String pn = FWUtils.read_xl_data(XL_DATA_PATH,"createnewproject",j,0);
			cnpp.projectNameField(pn);
			cnpp.createProjBtn();
			cp.projectbtn();
			
		}
	
    
	}
 

}
