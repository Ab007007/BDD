package pom.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class DashboardPage {

	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logoutLink;
	
	@FindBy(linkText = "TASKS")
	WebElement tasksLink;
	
	@FindBy(xpath = "//div[@class='addNewContainer']")
	WebElement addNewCustomerButton;

	@FindBy(xpath = "//div[contains(text(),'New Customer')]")
	WebElement newCustomerButton;

	
	public void clickonNewCustomerButton()
	{
		addNewCustomerButton.click();
		newCustomerButton.click();
	}
	public void clickOnTasksLink()
	{
		tasksLink.click();
	}
	
	public void logout()
	{
		logoutLink.click();
	}

	
	public DashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	

}
