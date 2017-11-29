package po;
// second commit
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import library.BasePage;
import library.JavascriptLibrary;

public class HomePagePO extends BasePage{

	public HomePagePO(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="logoutLink")
	private WebElement logoutBtn;
	public void logout(){
		JavascriptLibrary.javascriptClickElement(driver, logoutBtn);
		logoutBtn.click();
	}

}
