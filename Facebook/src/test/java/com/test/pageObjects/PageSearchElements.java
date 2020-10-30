package com.test.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageSearchElements {

	WebDriver driver;

	@FindBy(id = "search_jewel")
	private WebElement searchIcon;

	@FindBy(id = "main-search-input")
	private WebElement searchInputBox;

	@FindBy(xpath = "//span[text()='See more results for \"Fetch Rewards\"']/parent::div")
	private WebElement seeMoreResultLink;

	@FindBy(xpath = "//span[text()='Fetch Rewards']/ancestor::div[contains(@aria-label,'Verified')]/parent::div")
	private WebElement fetchRewardsPageLink;

	@FindBy(xpath = "//div[text()='Like']/parent::div")
	private WebElement likeButton;

	@FindBy(xpath = "//div[text()='Liked']/parent::div")
	private WebElement likedButton;

	@FindBy(xpath = "//span[text()='Unlike']/parent::a")
	private WebElement unlikeLink;

	public PageSearchElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement loggedInUserName(String userName) {
		String locator = String.format("//div[text()='%s']", userName);
		return driver.findElement(By.xpath(locator));
	}

	public WebElement searchIcon() {
		return searchIcon;
	}

	public WebElement searchBox() {
		return searchInputBox;
	}

	public WebElement seeMoreResultsLink() {
		return seeMoreResultLink;
	}

	public WebElement fetchRewardsPageLink() {
		return fetchRewardsPageLink;
	}

	public WebElement likeButton() {
		return likeButton;
	}

	public WebElement likedButton() {
		return likedButton;
	}

	public WebElement unlikeLink() {
		return unlikeLink;
	}
}
