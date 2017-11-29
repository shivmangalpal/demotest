package script;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import library.BaseTest;
import po.LoginPagePO;

public class TestLogin extends BaseTest{

		
		@Test
		public void invalidLogin(){

			try {
				driver.get("https://online.actitime.com/student19/");

				LoginPagePO login=new LoginPagePO(driver);
				login.login("arjunpputhiyoth","8891");

				AssertJUnit.fail();
			} catch (Exception e) {
				Reporter.log("Invalid LoginLogout Fail",true);
			}

}
}
