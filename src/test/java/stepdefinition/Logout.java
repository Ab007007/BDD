package stepdefinition;

import cucumber.api.java.en.Then;

public class Logout {

	
	@Then("^I logout from the applicaiton$")
	public void i_logout_from_the_applicaiton() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		LoginTest.driver.close();
	    
	}
	
	@Then("^Logout from  application$")
	public void logout_from_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LoginTest.driver.close();
	}

}
