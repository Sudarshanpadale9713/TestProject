package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@name='pwd']")
	private WebElement password;
	
	@FindBy(xpath="//input[@name='remember']")
	private WebElement keepMeLoginCheckBox;
	
	@FindBy(xpath = "//a[@id='loginButton']")
	private WebElement login;
	
	private WebDriver driver;
	
	//private WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
//		wait = new WebDriverWait(driver, 20);
	}
	
	public void sendUserName() {
		
		//wait.until(ExpectedConditions.visibilityOf(userName));
		userName.sendKeys("admin");
	}
	
	public void sendPassword() {
		password.sendKeys("sid1234");
	}
	
	public void clickKeepMeLoginCheckBox() {

		if(!(keepMeLoginCheckBox.isSelected())) {
			keepMeLoginCheckBox.click();
		}
		else {
			System.out.println("keepMeLoginCheckBox is Already checked");
		}
	}
	
	public void login() {
		login.click();
	}

}
