package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import library.BasePage;
import library.JavascriptLibrary;

public class LoginPagePO extends BasePage {

	public LoginPagePO(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="username")
	private WebElement unTxtBx;
	
	@FindBy(name="pwd")
	private WebElement pwTxtBx;
	
	@FindBy(xpath="//div[contains(text(),'Login')]")
	private WebElement loginBtn;
	
	public void login(String un, String pw){
		JavascriptLibrary.javascriptType(driver, unTxtBx, un);
		JavascriptLibrary.javascriptType(driver, pwTxtBx, pw);
		JavascriptLibrary.javascriptClickElement(driver, loginBtn);
//		unTxtBx.sendKeys(un);
//		pwTxtBx.sendKeys(pw);
//		loginBtn.click();
		
	}
	@FindBy(xpath="//span[contains(text(),'Username or Password is invalid. Please try again.')]")
	private WebElement errorMsg;
	public String verifyErrorMsg() {
		return errorMsg.getText();
	}
	

}
