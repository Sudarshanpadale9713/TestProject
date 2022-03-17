package TestClassPakage1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.ApplicationHeaderPage;
import pom.LoginPage;

public class VerifyApplicationHeader {
		
		
		private WebDriver driver;
		private LoginPage loginPage;
		private ApplicationHeaderPage applicationHeaderPage;
		
		@BeforeClass
		public void launchBrowser() throws InterruptedException {
			Reporter.log(" --- Browser is launch --- ");
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\VIKAS\\Desktop\\Selenium Soft\\chromedriver_win32\\chromedriver.exe");
			
			driver = new ChromeDriver();
			
			driver.get("http://localhost/login.do");
			//Thread.sleep(2000);
			
		}
		
		@BeforeMethod
		public void loginToApplication() throws InterruptedException {
			
			Reporter.log(" --- login to application  --- ",true);
			
			loginPage = new LoginPage(driver);
			loginPage.sendUserName();
			loginPage.sendPassword();
			loginPage.clickKeepMeLoginCheckBox();
			loginPage.login();
			applicationHeaderPage = new ApplicationHeaderPage(driver);
			Thread.sleep(3000);
		}
		
		@Test(priority = 1)
		public void verifyUserTimeTrackTab() {
			
			Reporter.log(" --- Time Track  --- ");
			
			
			applicationHeaderPage.openTimeTrackPage();
			String currentUrl = driver.getCurrentUrl();
			String title = driver.getTitle();
			System.out.println(title);
			
			if(currentUrl.equals("http://localhost/user/submit_tt.do")) {
				System.out.println("Time-Track Url : Pass ");
			}
			else {
				System.out.println("Time-Track Url : Fail");
			}	
			
		}
		
		
		@Test(priority = 2)
		public void verifyUserTasks() {
			
			Reporter.log(" --- Task --- ");
			
			applicationHeaderPage.openTasksPage();
			String currentUrl = driver.getCurrentUrl();
			String title = driver.getTitle();
			
			if(currentUrl.equals("http://localhost/administration/userlist.do")) {
				System.out.println("Pass");
			}
			else {
				System.out.println("Fail");
			}
			
		}
		
		@AfterMethod
		public void logoutUser() {
			applicationHeaderPage.userLogout();
		}

		@AfterClass
		public void closeBrowser() {
			driver.quit();
		}
}


