package library;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements AutoConst {
	public WebDriver driver;

	@BeforeMethod
	public void openBrowser(){
		System.setProperty(CHROME_KEY,CHROME_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void closeBrowser(ITestResult r) {
		if(r.getStatus() == 2) {
			Photo.getScreenShot(driver, imgPath);
		}
		driver.quit();
	}

}
