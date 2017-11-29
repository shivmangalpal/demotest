package script;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import library.BaseTest;
import po.HomePagePO;
import po.LoginPagePO;
import po.TaskPagePO;

public class TaskStatusChange extends BaseTest {

	@Test 
	public void taskStatusChange(){

		try {
			driver.get("https://online.actitime.com/student19/");

			LoginPagePO login=new LoginPagePO(driver);
			login.login("shivmangalpal", "India@1234");

			
			TaskPagePO task = new TaskPagePO(driver);
			task.clickOpen();      // Clicking Task Tab
			task.clickStatus();	   // Clicking on Status
			task.taskCompleted();  // Changing Status to Completed
			
			String expected = "actiTIME - Task List";
			String actual = driver.getTitle();
			
			HomePagePO home=new HomePagePO(driver);
			home.verifyTitle("actiTIME - Task List");
			home.logout();
			
			AssertJUnit.assertEquals(actual, expected);
			Reporter.log("Status Completed",true);
		} catch (Exception e) {
			Reporter.log("Status Open",true);
			AssertJUnit.fail();
		}

	}
	
	
		
	


}
