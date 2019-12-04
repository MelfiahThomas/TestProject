package com.actiTime.test_Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(
		features= {"ActiTime_Feature"},
		glue= {"com.actiTime.step_defs"},
		plugin= {"pretty","html:Reports2"},
		monochrome = true,
		dryRun=false,
		strict = false,
		tags = { "@bp"}
		
		)

@RunWith(Cucumber.class)
public class Acti_TestRunner {

}
