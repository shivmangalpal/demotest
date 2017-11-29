package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class BasePage {
	public WebDriver driver;
	public WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver,this);
	}

	public void verifyTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
			Reporter.log("Title is Matching",true);
		} catch (Exception e) {
			Reporter.log("Title is not Maching", true);
			Assert.fail();
		}

	}

	public void verifyElement(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element found",true);
		} catch (Exception e) {
			Reporter.log("Element not found", true);
			Assert.fail();
		}

	}
}
