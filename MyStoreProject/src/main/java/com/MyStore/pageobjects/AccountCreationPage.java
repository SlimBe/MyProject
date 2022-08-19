package com.MyStore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.actiondriver.Action;
import com.MyStore.base.BaseClass;

public class AccountCreationPage extends BaseClass {
	@FindBy(xpath = "//h1[text()='Create an account']")  
	WebElement formTitle;
	
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean validateAccountCreatePage() {
		Action.fluentWait(getDriver(), formTitle, 3);
	return Action.isDisplayed(getDriver(), formTitle);	
		
	}




}
