package com.selecnium.actions;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumActions {
	WebDriver driver;

	public SeleniumActions(WebDriver driver) {
		this.driver = driver;
	}

	public void click(WebElement element) {
		try {
			element.click();
		}catch (ElementClickInterceptedException e) {
			executeScript("arguments[0].click();", element);
		}
	}
	
	public void executeScript(String script, Object... args) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript(script, args);
	}

	public void scrollToElemetAndClick(WebElement element) {
		scrollToElemet(element);
		element.click();
	}

	public void scrollToElemet(WebElement element) {
		executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
	}
	
	public void type(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	public boolean isDisplayed(WebElement element) {
		try {
			boolean displayed = element.isDisplayed();
			return displayed;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void pause(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {

		}
	}
}
