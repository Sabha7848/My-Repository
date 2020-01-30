package com.actitime.scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generics.BaseTest;
import com.actitime.generics.FWUtils;
import com.actitime.pages.Loginpage;

public class Testinvalidlogin extends BaseTest {
	@Test
	public void test1() throws InterruptedException
	{
         int rc = FWUtils.read_Xl_Row("invalid");
		Reporter.log("the row count is "+rc,true);
		Loginpage lp=new Loginpage(driver);
		for (int i = 1; i <=rc; i++) {
			String un = FWUtils.read_xl_data(XL_DATA_PATH, "invalid",i, 0);
			String pwd = FWUtils.read_xl_data(XL_DATA_PATH, "invalid",i, 1);
			lp.setusername(un);
			lp.setpwd(pwd);
			lp.clicklogin();
			
			Thread.sleep(1000);
			lp.verifyerrormsg();
		
			driver.navigate().refresh();

		}
		
	}

}
