package bdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/feature/multiLogin.feature",
		glue= {"stepdefinition"},
		dryRun = false,
		format = {"pretty","html:test-output","json:json_output/cucumber.json","junit:junit_output/cucumber.xml"},
		monochrome = true
		)
public class TestRun {

	
	
}
