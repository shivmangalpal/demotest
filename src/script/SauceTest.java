package script;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import library.BaseTest;
import po.HomePagePO;
import po.LoginPagePO;

public class SauceTest extends BaseTest {
	public static final String USERNAME ="shivmangalpal";
	public static final String ACCESS_KEY = "a502ef59-d009-4c85-bb87-9a1761f613bb";
	public static final String URL = "http://"+USERNAME+":"+ACCESS_KEY+"@ondemand.saucelabs.com:80/wd/hub";
	
	@Test
	public void validLoginLogout() throws MalformedURLException {
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability("platform","Windows 10");
		cap.setCapability("version", "33.0.1750");
		WebDriver driver = new RemoteWebDriver(new URL(URL),cap);
		try {
			driver.get("https://online.actitime.com/self3/user/submit_tt.do");
			LoginPagePO login=new LoginPagePO(driver);
			login.login("testingworks.arjun","A7u8yhUV");

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
