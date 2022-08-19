package com.MyStore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.actiondriver.Action;
import com.MyStore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	@FindBy(xpath = "//a[@class='login']")
	WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement myStoreLogo;
	
	@FindBy(id = "search_query_top")
	WebElement searchProductBox;
	
	@FindBy(name = "submit_search")
	WebElement searchBtn;

public IndexPage() {
	PageFactory.initElements(getDriver(), this);
}


public LoginPage clickOnsignIn () throws Throwable {
	Action.click(getDriver(), signInBtn);
	return new LoginPage();
}
		
	
public boolean ValidateLogo() throws Throwable {
	return Action.isDisplayed(getDriver(), myStoreLogo);
}


public String getMyStoreTtilte () throws Throwable  {
	String myStoreTitel=getDriver().getTitle();
	return myStoreTitel;
}


public SearchResultPage searchProduct(String productName) throws Throwable {
	Action.type(searchProductBox, productName);
	Action.click(getDriver(), searchBtn);
	return new SearchResultPage();

}




























}
