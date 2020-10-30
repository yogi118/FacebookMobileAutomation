package com.test.runner;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.config.properties.LoadProperties;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FeatureFiles", glue = { "com.test.stepDefinitions",
		"com.test.runner" }, plugin = { "pretty", "html:target/simpleHtmlReport", "json:target/cucumber.json",
				"junit:target/cucumber.xml" }, tags = { "@regression" }, dryRun = false)

public class TestRunner {

	@BeforeClass
	public static void loadProperties() {
		try {
			LoadProperties.setProperties();
		} catch (IOException exception) {
			System.out.println(exception.getMessage());
		}
	}

}
