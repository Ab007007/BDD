package stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LoginTest {
	static WebDriver driver = null;

	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
//	@Before
//	public void enterURLAndLogin() throws InterruptedException {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("http://localhost/login.do");
//		Assert.assertEquals("actiTIME - Login", driver.getTitle());
//		driver.findElement(By.id("username")).sendKeys("admin");
//		driver.findElement(By.name("pwd")).sendKeys("manager");
//		driver.findElement(By.id("loginButton")).click();
//		Thread.sleep(5000);
//	}
//
//	@After
//	public void logoutAndClose() {
//		driver.findElement(By.linkText("Logout")).click();
//		driver.close();
//	}

	@Given("^User is on a Login Page$")
	public void user_is_on_a_Login_Page() throws Throwable {

		driver.get("http://localhost/login.do");
	}

	@Given("^Title is matched$")
	public void title_is_matched() throws Throwable {
		Assert.assertEquals("actiTIME - Login", driver.getTitle());
	}

	// @When("^valid \"(.*)\" and \"(.*)\" is entered$")
	@When("^I enter a valid \"(.*)\" and \"(.*)\"$")
	public void i_enter_a_valid_username_and_password(String un, String pwd) throws Throwable {
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(5000);
	}

	@Then("^I can see the Home page$")
	public void i_can_see_the_Home_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("actiTIME - Enter Time-Track", driver.getTitle());
	}

	@When("^I enter a invalid username and password$")
	public void i_enter_a_invalid_username_and_password() throws Throwable {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("managerqq");
		driver.findElement(By.id("loginButton")).click();
	}

	@Then("^I can see the Login page$")
	public void i_can_see_the_Login_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals("actiTIME - Login", driver.getTitle());
	}

	/*
	 * @When("^I enter a valid username and password$") public void
	 * i_enter_a_valid_username_and_password(DataTable userDetails) throws Throwable
	 * { List<List<String>> creds = userDetails.raw(); for (List<String> list :
	 * creds) { for (int i = 0; i < list.size(); i++) {
	 * System.out.println("************************" + list.get(0) + "***" +
	 * list.get(1)); driver.findElement(By.id("username")).sendKeys(list.get(0));
	 * driver.findElement(By.name("pwd")).sendKeys(list.get(1));
	 * driver.findElement(By.id("loginButton")).click(); Thread.sleep(2000);
	 * 
	 * } }
	 * 
	 * }
	 */

	@When("^I enter a valid username and password$")
	public void i_enter_a_valid_username_and_password(DataTable userDetails) throws Throwable {
		List<Map<String, String>> creds = userDetails.asMaps(String.class, String.class);
		for (Map<String, String> map : creds) {
			driver.findElement(By.id("username")).sendKeys(map.get("username"));
			driver.findElement(By.name("pwd")).sendKeys(map.get("password"));
			driver.findElement(By.id("loginButton")).click();
			Thread.sleep(2000);

		}
	}

	@Then("^Logout of the application$")
	public void logout_of_the_application() throws Throwable {
		driver.findElement(By.linkText("Logout")).click();
		driver.close();
	}

//	@When("^i enter a customer \"(.*)\" and \"(.*)\"$")
//	public void i_enter_a_customer_namd_and_description(String un , String pwd) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//		driver.findElement(By.id("customerLightBox_nameField")).sendKeys(un);
//		driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys(pwd);
//			
//	}

//	@When("^I enter a valid Credentials$")
//	public void i_enter_a_valid_Credentials(DataTable userCredentials) throws Throwable {
//		// Write code here that turns the phrase above into concrete actions
//		// For automatic transformation, change DataTable to one of
//		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
//		// E,K,V must be a scalar (String, Integer, Date, enum etc)
//
//		List<List<String>> data = userCredentials.raw();
//		String un = data.get(0).get(0);
//		String pwd = data.get(0).get(1);
//		driver.findElement(By.id("username")).sendKeys(un);
//		driver.findElement(By.name("pwd")).sendKeys(p);
//		driver.findElement(By.id("loginButton")).click();
//		Thread.sleep(2000);
//	}
	
	
	@When("^I enter a valid Credentials$")
	public void i_enter_a_valid_Credentials(DataTable userCredentials) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)

		 List<Map<String, String>> data = userCredentials.asMaps(String.class, String.class);
		 for (Map<String, String> map : data) {
			 	String un = map.get("Username");
				String pwd = map.get("Password");
				driver.findElement(By.id("username")).sendKeys(un);
				driver.findElement(By.name("pwd")).sendKeys(pwd);
				driver.findElement(By.id("loginButton")).click();
				Thread.sleep(2000);
				driver.findElement(By.linkText("Logout")).click();
		}
		
		
	}
	@Then("^I can see the Home page and logout$")
	public void i_can_see_the_Home_page_and_logout() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.linkText("Logout")).click();
		//driver.close();
	}

}
