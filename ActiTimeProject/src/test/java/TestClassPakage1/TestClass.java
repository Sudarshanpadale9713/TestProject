package TestClassPakage1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.ApplicationHeaderPage;
import pom.LoginPage;

public class TestClass {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VIKAS\\Desktop\\Selenium Soft\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost/login.do");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.sendUserName();
		loginPage.sendPassword();
		loginPage.clickKeepMeLoginCheckBox();
		loginPage.login();
		
		ApplicationHeaderPage applicationHeaderPage = new ApplicationHeaderPage(driver);
		applicationHeaderPage.openTimeTrackPage();
		String currentUrl = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		if(currentUrl.equals("http://localhost/user/submit_tt.do")) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
		

	}

}
