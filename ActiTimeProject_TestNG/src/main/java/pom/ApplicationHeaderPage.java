package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationHeaderPage {
	
	@FindBy(xpath="//div[text()='Time-Track']")
	private WebElement time_Track;
	
	@FindBy(xpath="//div[text()='Tasks']")
	private WebElement tasks;
	
	@FindBy(xpath="//div[text()='Reports']")
	private WebElement reports;
	
	@FindBy(xpath="//div[text()='Users']")
	private WebElement users;
	
	@FindBy(xpath="//div[text()='Work Schedule']")
	private WebElement workShedule;
	
	@FindBy(xpath="//a[@id='logoutLink']")
	private WebElement logout;
	
	public ApplicationHeaderPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void openTimeTrackPage() {
		time_Track.click();
	}

	public void openTasksPage() {
		tasks.click();
	}
	
	public void openReportsPage() {
		reports.click();
	}
	
	public void openUsersPage() {
		users.click();
	}
	
	public void openWorkShedulePage() {
		workShedule.click();
	}
	
	public void userLogout() {
		logout.click();
	}
	
}
