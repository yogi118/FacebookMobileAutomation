package com.test.stepDefinitions;

import org.junit.Assert;

import com.config.properties.LoadProperties;
import com.test.businesslogic.LoginPage;
import com.test.businesslogic.PageSearch;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;





public class LoginPageSteps {

	private LoginPage loginPage;
	private PageSearch pageSearch;
	
	public LoginPageSteps() {
		loginPage = new LoginPage();
		pageSearch = new PageSearch();
	}
	
	@Given("I have launched the application")
	public void i_have_lanched_the_application() {
		loginPage.openLoginPage();
	}

	@When("I enter {string} as user name and {string} as password")
	public void i_enter_as_user_name_and_as_password(String userName, String password) {
		loginPage.login(userName, password);
	}

	@When("I click on the Log In button")
	public void i_click_on_the_Log_In_button() {
		loginPage.clickOnLoginButton();
	}

	@Then("I should be successfully logged into the application")
	public void i_should_be_successfully_logged_into_the_application() {
		String userName = LoadProperties.getProperties().getProperty("username");
		Assert.assertTrue("Logged in userName is not displayed", pageSearch.verifyUserNameDisplayed(userName));
	}
}
