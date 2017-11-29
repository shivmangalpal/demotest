package script;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import library.BaseTest;
import library.ExelLib;
import po.HomePagePO;
import po.LoginPagePO;



public class LoginLogoutScript extends BaseTest{
	
	// Login with valid Username and Password
	@Test (priority = 1)
	public void validLoginLogout(){

		try {
			driver.get("https://online.actitime.com/student19/");

			LoginPagePO login=new LoginPagePO(driver);
			String un = ExelLib.readExcel(xlPath,"Sheet1",1,0);
			String pwd = ExelLib.readExcel(xlPath,"Sheet1",1,1);
			login.login(un,pwd);
			//login.login("shivmangalpal","India@1234");

			HomePagePO home=new HomePagePO(driver);
			home.verifyTitle("actiTIME - Enter Time-Track");
			home.logout();
			
			String expected = "actiTIME - Login";
			String actual = driver.getTitle();
			
			AssertJUnit.assertEquals(actual, expected);
			Reporter.log("Valid LoginLogout Pass",true);
		} catch (Exception e) {
			Reporter.log("Valid LoginLogout Fail",true);
			Assert.fail();
		}

	}
	
	// Login with invalid Username and Password
	@Test(priority = 2)
	public void invalidLogin(){

		try {
			driver.get("https://online.actitime.com/student19/");

			LoginPagePO login=new LoginPagePO(driver);
			login.login("arjunpputhiyoth","8891");

			Assert.fail();
		} catch (Exception e) {
			Reporter.log("Invalid LoginLogout Fail",true);
			Assert.fail();
		}
	}

//	// Login with blank Username and Password
//	@Test(priority = 3)
//	public void blankLogin(){
//
//		try {
//			driver.get("https://online.actitime.com/aprakash1/user/submit_tt.do");
//
//			LoginPagePO login=new LoginPagePO(driver);
//			login.login("", "");
//
//			String expected = "Username or Password is invalid. Please try again.";
//			String actual = login.verifyErrorMsg();
//
//			Assert.assertEquals(actual, expected);
//			Reporter.log("Invalid LoginLogout Pass",true);
//		} catch (Exception e) {
//			Reporter.log("Invalid LoginLogout Fail",true);
//			Assert.fail();
//		}
//
//	}
	
	
}
