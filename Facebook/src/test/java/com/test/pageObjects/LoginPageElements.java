package com.test.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements {

	WebDriver driver;

	@FindBy(id = "m_login_email")
	private WebElement emailID;

	@FindBy(id = "m_login_password")
	private WebElement password;

	@FindBy(xpath = "//button[@name='login']")
	private WebElement login;

	@FindBy(xpath = "//span[text()='Not Now']/parent::a/parent::div")
	private WebElement notNowButton;

	public LoginPageElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement userNameField() {
		return emailID;
	}

	public WebElement passwordField() {
		return password;
	}

	public WebElement loginButton() {
		return login;
	}

	public WebElement notNowButton() {
		return notNowButton;
	}
}
