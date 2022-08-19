package com.MyStore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.actiondriver.Action;
import com.MyStore.base.BaseClass;

public class AdressPage  extends BaseClass {
	
	@FindBy(xpath = "//button//span[contains(text(),'Proceed to checkout')]")
	WebElement procedToCheckOut;
	public AdressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public ShipingPage clickonCheckOut () {
	Action.click(getDriver(), procedToCheckOut);
	return new ShipingPage();
	}
}
