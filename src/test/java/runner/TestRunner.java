package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="classpath:Features", // Features tells cucumber options where feature files are stored
		glue = {"stepDefinitions"}, // glue tells cucumber options where all Step Definitions class are stored 
		tags = {""}, // we can run all scenarios or one scenario with help of tags 
		dryRun = false, // dryRun sets false will check if all steps in scenario has step d
		monochrome = true, // if set to true, makes console output readable 
		strict =false, // if set to false will fail the execution if there are any pending or undefined steps
		format = {"pretty", 		        
				"html:target/cucumber-reports/cucumber-pretty",
		        "json:target/cucumber-reports/CucumberTestReport.json",
		        "rerun:target/cucumber-reports/rerun.txt"},
		plugin = "json:target/cucumber-reports/CucumberTestReport.json"
		)
public class TestRunner {

}
