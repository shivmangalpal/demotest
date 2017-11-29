package script;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import library.BaseTest;
import po.HomePagePO;
import po.LoginPagePO;

public class Tested extends BaseTest {
	
	@Test(priority=1)
	public void validLoginLogout() {
		try {
			driver.get("https://online.actitime.com/student19/");
			LoginPagePO login=new LoginPagePO(driver);
			login.login("shivmangalpal","India@1234");

			HomePagePO home=new HomePagePO(driver);
			home.verifyTitle("actiTIME - Enter Time-Track");
			home.logout();

			String excepted = "actiTIME - Login";
			String actual = driver.getTitle();
			AssertJUnit.assertEquals(actual, excepted);
			Reporter.log("passed", true);
		} catch (Exception e) {
			Reporter.log("failed", true);
			AssertJUnit.fail();
		}
		
	}
	
	@Test(priority = 2)
	public void invalidLogin() {
		try {
	
		driver.get("https://online.actitime.com/student19/");
		LoginPagePO login=new LoginPagePO(driver);
		login.login("shivmangalpal","India@1234");

		HomePagePO home=new HomePagePO(driver);
		home.verifyTitle("actiTIME - Enter Time-Track");
		home.logout();
		String excepted = "actiTIME - Login";
		String actual = driver.getTitle();
		AssertJUnit.assertEquals(actual, excepted);
		Reporter.log("passed", true);
	
		} catch (Exception e) {
			Reporter.log("failed", true);
			AssertJUnit.fail();
		}
		}
		
	


}
