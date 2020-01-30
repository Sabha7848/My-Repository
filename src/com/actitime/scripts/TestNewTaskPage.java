package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.generics.BaseTest;
import com.actitime.generics.FWUtils;
import com.actitime.pages.CreateNewTaskPage;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.Loginpage;
import com.actitime.pages.TasksListPage;

public class TestNewTaskPage extends BaseTest {
	@Test
	public void createNewTasktest() throws InterruptedException
	{
		
	
	Loginpage lp=new Loginpage(driver);
	String un = FWUtils.read_xl_data(XL_DATA_PATH, "validlogin",1, 0);
	String pwd = FWUtils.read_xl_data(XL_DATA_PATH, "validlogin",1, 1);
	String exp_title= FWUtils.read_xl_data(XL_DATA_PATH, "enter time track",1, 0);
	String Op_exp_title = FWUtils.read_xl_data(XL_DATA_PATH,"opentask",1,0);
	String nt_exp_title=FWUtils.read_xl_data(XL_DATA_PATH, "createtaskpage", 1, 1);
	int Rc_newCust = FWUtils.read_Xl_Row("createcustomer");
    int Rc_newproj=FWUtils.read_Xl_Row("createnewproject");
    int Rc_newtask=FWUtils.read_Xl_Row("createtaskpage");


	lp.setusername(un);
   	lp.setpwd(pwd);
   	lp.clicklogin();
   	
   	EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
       FWUtils.verifyPage(driver, exp_title);
   	   ep.clickOnTask();
   	
   	TasksListPage tl=new TasksListPage(driver);
   	FWUtils.verifyPage(driver, Op_exp_title);
   	tl.clickOnCreateTaskBtn();
   	
   	CreateNewTaskPage cntp=new CreateNewTaskPage(driver);
   	FWUtils.verifyPage(driver, nt_exp_title);
   	for (int i = 1; i <=Rc_newCust; i++) {
		
	
   	String cust1 = FWUtils.read_xl_data(XL_DATA_PATH, "createcustomer", i, 0);
   	String project1=FWUtils.read_xl_data(XL_DATA_PATH, "createnewproject", i, 0);
   	String task1 = FWUtils.read_xl_data(XL_DATA_PATH, "createtaskpage",i, 0);
   	cntp.selCust(cust1);
   	cntp.selproject(project1);
   	cntp.taskfield1(task1);
   	cntp.craeteTaskBtn();
   	Thread.sleep(1000);
   	tl.clickOnCreateTaskBtn();
   	}
   	



}
}
