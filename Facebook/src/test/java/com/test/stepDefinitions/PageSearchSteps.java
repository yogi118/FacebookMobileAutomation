package com.test.stepDefinitions;

import org.junit.Assert;

import com.config.properties.LoadProperties;
import com.selecnium.actions.SeleniumActions;
import com.test.businesslogic.LoginPage;
import com.test.businesslogic.PageSearch;

import cucumber.api.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;



public class PageSearchSteps {

	private LoginPage loginPage;
	private PageSearch pageSearch;
	
	public PageSearchSteps() {
		loginPage = new LoginPage();
		pageSearch = new PageSearch();
	}
	
	@Given("I have successfully logged in, into the application")
	public void i_have_successfully_logged_in_into_the_application() {
		String userName = LoadProperties.getProperties().getProperty("emailId");
		String password = LoadProperties.getProperties().getProperty("password");
	    loginPage.openLoginPage();
	    loginPage.login(userName, password);
	    loginPage.clickOnLoginButton();
	    loginPage.clickOnNotNowButton();
	}

	@When("I search for the {string} page")
	public void i_search_for_the_page(String pageName) {
	    pageSearch.searchForPage(pageName);
	}

	@Then("Search result should retun {string} page")
	public void search_result_should_retun_page(String pageName) {
	    Assert.assertTrue(pageName + " is not displayed", pageSearch.verifyPageIsDisplayed());
	}

	@When("I open the {string} page")
	public void i_open_the_page(String pageName) {
	    pageSearch.openPage();
	}

	@When("I Click on the like button for {string} page")
	public void i_Click_on_the_like_button_for_page(String pageName) {
		pageSearch.clickOnLikeButton();
		SeleniumActions.pause(3000);
	}

	@Then("Page with name {string} shpould be liked")
	public void page_with_name_shpould_be_liked(String pageName) {
		Assert.assertTrue(pageName + " page is not liked" , pageSearch.verifyPageIsLiked());
	}
}
