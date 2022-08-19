package com.MyStore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.actiondriver.Action;
import com.MyStore.base.BaseClass;

public class SearchResultPage extends BaseClass {
	@FindBy(xpath ="//div[@class='right-block']/h5/a[contains(text (),'Faded Short Sleeve T-shirts')]")
	WebElement productResult;
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	
	public Boolean isProductAvailable() throws Throwable  {
		return Action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCartePage ClickonProduct() throws Throwable  {
		Action.click(getDriver(), productResult);
		return new AddToCartePage();
	}
}
