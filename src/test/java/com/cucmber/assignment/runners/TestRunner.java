package com.cucmber.assignment.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		glue ="com.cucmber.assignment.stepdefs",
		 tags="@searchProductDesc", // to tell which tagged feature file to execute, keep empty if executing from cmd.
	        plugin = {"pretty", // to generate reports 
	            "html:target/html/testreport.html",
	            "json:target/json/file.json",
	            },
	        monochrome = true,
	        publish=true,
	        dryRun=false
		
		)
public class TestRunner {

}
