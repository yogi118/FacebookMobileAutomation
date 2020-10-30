package com.test.businesslogic;

import com.selecnium.actions.SeleniumActions;
import com.test.pageObjects.PageSearchElements;
import com.test.util.WaitTime;
import com.test.webdriver.Driver;

public class PageSearch {

	private PageSearchElements pageSearchElements;
	private SeleniumActions selActions;

	public PageSearch() {
		pageSearchElements = new PageSearchElements(Driver.getDriver());
		selActions = new SeleniumActions(Driver.getDriver());
	}

	public boolean verifyUserNameDisplayed(String userName) {
		return selActions.isDisplayed(pageSearchElements.loggedInUserName(userName));
	}

	public void searchForPage(String pageName) {
		selActions.click(pageSearchElements.searchIcon());
		SeleniumActions.pause(WaitTime.SMALL_WAIT);
		selActions.type(pageSearchElements.searchBox(), pageName);
		SeleniumActions.pause(WaitTime.SMALL_WAIT);
		selActions.click(pageSearchElements.seeMoreResultsLink());
		SeleniumActions.pause(WaitTime.MAX_WAIT);
	}

	public boolean verifyPageIsDisplayed() {
		return selActions.isDisplayed(pageSearchElements.fetchRewardsPageLink());
	}

	public void openPage() {
		selActions.click(pageSearchElements.fetchRewardsPageLink());
		SeleniumActions.pause(WaitTime.MAX_WAIT);
	}
	
	public void clickOnLikeButton() {
		selActions.click(pageSearchElements.likeButton());
		SeleniumActions.pause(WaitTime.SMALL_WAIT);
	}
	
	public boolean verifyPageIsLiked() {
		return selActions.isDisplayed(pageSearchElements.likedButton());
	}
}
