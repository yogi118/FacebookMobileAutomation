package com.test.businesslogic;


import com.config.properties.LoadProperties;
import com.selecnium.actions.SeleniumActions;
import com.test.pageObjects.LoginPageElements;
import com.test.util.WaitTime;
import com.test.webdriver.Driver;

public class LoginPage {

	private LoginPageElements loginPageElements;
	SeleniumActions selActions;
	
	
	public LoginPage() {
		loginPageElements = new LoginPageElements(Driver.getDriver());
		selActions = new SeleniumActions(Driver.getDriver());
	}
	
	public void login(String userName, String password){
		openLoginPage();
		selActions.type(loginPageElements.userNameField(), userName);
		selActions.type(loginPageElements.passwordField(), password);
	}
	
	public void clickOnLoginButton() {
		selActions.click(loginPageElements.loginButton());
		SeleniumActions.pause(WaitTime.MAX_WAIT);
	}
	
	public void clickOnNotNowButton() {
		selActions.click(loginPageElements.notNowButton());
		SeleniumActions.pause(WaitTime.MEDIM_WAIT);
	}
	
	public void openLoginPage() {
		Driver.getDriver().get(LoadProperties.getProperties().getProperty("applicationUrl"));
		SeleniumActions.pause(WaitTime.MAX_WAIT);
	}
}
