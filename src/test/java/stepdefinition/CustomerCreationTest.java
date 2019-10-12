package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pom.page.CustomerCreationPage;
import pom.page.DashboardPage;
import pom.page.LoginPage;

public class CustomerCreationTest {

	WebDriver driver = LoginTest.driver;
	LoginPage lp = null;
	DashboardPage dp = null;
	CustomerCreationPage cp = null;

	@When("^i enter a customer \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_a_customer_and(String arg1, String arg2) throws Throwable {
		driver.findElement(By.id("customerLightBox_nameField")).sendKeys(arg1);
		driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys(arg2);
	}

	@Then("^I should be able to create customer$")
	public void i_should_be_able_to_create_customer() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("customerLightBox_commitBtn")).click();

	}

	@Then("^validate custmer creation success message$")
	public void validate_custmer_creation_success_message() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		System.out.println("Waiting for toast message to appear");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));

		System.out.println("Waiting for the toast message to disappaer");

		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));

	}

	@When("^User is on customer creation page$")
	public void user_is_on_customer_creation_page() throws Throwable {

		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//a[div[text()='TASKS']]")).click();
		driver.findElement(By.xpath("//div[@class='addNewContainer']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'New Customer')]")).click();

	}

	// ***********************************************POM
	// *********************************************************************************************
	@When("^he enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void he_enter_and(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		cp = new CustomerCreationPage(driver);
		cp.enterCustomerName(arg1);
		cp.enterCustomerDesc(arg2);

	}

	@Then("^he will create customer$")
	public void he_will_create_customer() throws Throwable {

		// Write code here that turns the phrase above into concrete actions
		cp.clickOnCC();
	}

	@Then("^validate custmer creation message$")
	public void validate_custmer_creation_message() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(cp.getToastEle()));

		System.out.println("Waiting for the toast message to disappaer");

		wait.until(ExpectedConditions.invisibilityOf(cp.getToastEle()));
	}

	@Given("^User is on a POM Login Page$")
	public void user_is_on_a_POM_Login_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		lp = new LoginPage(driver);
		driver.get("http://localhost/login.do");
		
	}

	@Then("^User is on CC page$")
	public void user_is_on_CC_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		dp = new DashboardPage(driver);
		dp.clickOnTasksLink();
		dp.clickonNewCustomerButton();
	}

}
