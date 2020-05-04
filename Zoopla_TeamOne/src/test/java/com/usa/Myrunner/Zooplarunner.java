package com.usa.Myrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features= {"src/main/resources/FindProperty.feature"},
		glue = {"com.usa.stepdefination"},
	    plugin = {"pretty", "html:target/cucumber-reports/cucumber.json",
		"json:target/cucumber.json"}

		)
public class Zooplarunner extends AbstractTestNGCucumberTests {

}
 