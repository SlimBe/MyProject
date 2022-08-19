package com.MyStore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.actiondriver.Action;
import com.MyStore.base.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(id = "email")
	WebElement userName; 
	
	@FindBy(id = "passwd")
	WebElement password; 
	
	@FindBy(id = "SubmitLogin")
	WebElement SignInbtn; 
	
	@FindBy(id = "email_create")
	WebElement EmailFornewAccount; 
	
	@FindBy(id = "SubmitCreate")
	WebElement CreatNewAccountBtn; 
	
public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

public HomePage login(String uname,String pswd) throws Throwable {
	 Action.type(userName, uname);
	 Action.type(password, pswd);
	 Action.click(getDriver(), SignInbtn);
	 return new HomePage();
}

public AdressPage login1(String uname,String pswd) throws Throwable {
	 Action.type(userName, uname);
	 Action.type(password, pswd);
	 Action.click(getDriver(), SignInbtn);
	 return new AdressPage();
}
public AccountCreationPage creatNewAccount(String newEmail) throws Throwable {
	Action.type(EmailFornewAccount, newEmail);
	Action.click(getDriver(), CreatNewAccountBtn);
	return new AccountCreationPage();	
}
















}
