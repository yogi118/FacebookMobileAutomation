package com.test.webdriver;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.config.properties.LoadProperties;

public class Driver {

	private static WebDriver driver = null;

	private Driver() {

	}

	public static void setDriver(String browserName) {

		switch (browserName) {
		case "chrome_android":
			ChromeOptions android_options = new ChromeOptions();
			android_options.addArguments("disable-notifications");
			DesiredCapabilities android_cap = new DesiredCapabilities();
			android_cap.setCapability("deviceName", "Android_Device");
			android_cap.setCapability("udid", LoadProperties.getProperties().getProperty("udid"));
			android_cap.setCapability("platformName", "Android");
			android_cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
			android_cap.setCapability(CapabilityType.VERSION, LoadProperties.getProperties().getProperty("androidVersion"));
			android_cap.setCapability("noReset", true);
			android_cap.setCapability(ChromeOptions.CAPABILITY, android_options);
			try {
				driver = new RemoteWebDriver(new URL(LoadProperties.getProperties().getProperty("remoteURL")), android_cap);
			} catch (Exception e) {

			}
			break;
		case "safari_ios":
			DesiredCapabilities iOS_cap = new DesiredCapabilities();
			iOS_cap.setCapability("deviceName", "iphone");
			iOS_cap.setCapability("udid", LoadProperties.getProperties().getProperty("udid"));
			iOS_cap.setCapability("platformName", "iOS");
			iOS_cap.setCapability(CapabilityType.BROWSER_NAME, "Safari");
			iOS_cap.setCapability(CapabilityType.VERSION, LoadProperties.getProperties().getProperty("iOSVersion"));
			iOS_cap.setCapability("noReset", true);
			try {
				driver = new RemoteWebDriver(new URL(LoadProperties.getProperties().getProperty("remoteURL")), iOS_cap);
			} catch (Exception e) {

			}
			break;
		default:
			throw new RuntimeException("No supported browser present");
		}

	}

	public static WebDriver getDriver() {
		return driver;
	}
}
