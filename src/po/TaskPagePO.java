package po;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import library.BasePage;


public class TaskPagePO extends BasePage{

	public TaskPagePO(WebDriver driver) {
		super(driver);
	}
	
	// For clicking the Task Tab
	@FindBy(xpath="//div[contains(text(),'TASK')]")
	private WebElement taskTab;
	public void clickOpen() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		taskTab.click();
	}

	// For changing the Status 
	@FindBy(xpath="(//div[contains(text(),'Open')])[2]")
	private WebElement taskStatus;
	public void clickStatus() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		taskStatus.click();
	}

	// For changing the Status to completed
	@FindBy(xpath="(//div[contains(text(),'Completed')])[23]")
	private WebElement completed;
	public void taskCompleted(){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		completed.click();
	}
	
}

