package com.test.stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.test.webdriver.Driver;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseTest {

	@Before
	public  void setDriverInstance(){
		String browser = System.getProperty("browser");
		if(browser == null) {
			browser = "chrome_android";
		}
		Driver.setDriver(browser);
	}
	
	@After
	public void closeDriverInstance(Scenario scenario) {
		WebDriver driver = Driver.getDriver();
		if(driver != null) {
			if(scenario.isFailed()) {
				final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}
			driver.quit();
		}
	}	
}
