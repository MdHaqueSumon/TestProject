package com.usa.Zooplapagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MasterPagefactory {
	@FindBy(xpath="//*[@class='ui-button-primary ui-cookie-accept-all-medium-large']")
	private WebElement cookie;
    public WebElement getCookie() {
		return cookie;
	} 
    @FindBy(xpath="//*[@class='button button--tertiary-dark account-link__text']")
    private WebElement singIn;
	public WebElement getSingIn() {
		return singIn;
	}
	@FindBy(xpath="//*[@id='signin_email']")
	private WebElement userName;
	public WebElement getUserName() {
		return userName;
	}
	@FindBy(xpath="//*[@id='signin_password']") 
	private WebElement userPassword;
	public WebElement getUserPassword() {
		return userPassword;
	}
	@FindBy(xpath="//*[@id='signin_submit']")
	private WebElement submit;
	public WebElement getSubmit() {
		return submit;
	}
	@FindBy(xpath="//*[@id='search-input-location']")
	private WebElement locationBox;
	public WebElement getLocationBox() {
		return locationBox;
	}
	@FindBy(xpath="//*[@id='search-submit']")
	private WebElement searchButton;
	public WebElement getSearchButton() {
		return searchButton;
	}
	@FindBy(xpath="//a[@class='listing-results-price text-price']")
	private List<WebElement> allPrice;
	public List<WebElement> getAllPrice() {
		return allPrice;
	}
	@FindBy(xpath="//div[@class='ui-agent']")
	private WebElement agentInfo;
	public WebElement getAgentInfo() {
		return agentInfo;
	}
	@FindBy(xpath="//*[@class='ui-header-account-panel']")
	private WebElement myzoopla;
	
	public WebElement getMyzoopla() {
		return myzoopla;
	}
	@FindBy(xpath="//*[contains(text(),'Sign out')]")
	private WebElement sinOut;
	public WebElement getSinOut() {
		return sinOut;
	}
	

}
