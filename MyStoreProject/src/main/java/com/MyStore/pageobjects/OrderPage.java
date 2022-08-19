package com.MyStore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.actiondriver.Action;
import com.MyStore.base.BaseClass;

public class OrderPage extends BaseClass {
	@FindBy(xpath = "//td[@class='cart_unit']/span/span")
	WebElement unitPrice; 
	
	@FindBy(xpath= "//span[@id='total_price']")
	WebElement totalPrice; 
	
	@FindBy(xpath= "//span[text()='Proceed to checkout']")
	WebElement ProceedToCheckOut;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitPrice () {
		String unitPrice1=unitPrice.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalunit=Double.parseDouble(unit);
		return finalunit/100;
		
	}
	
	public double gettotalPrice () {
		String totalPrice1=totalPrice.getText();
		String total=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finaltotal=Double.parseDouble(total);
		return finaltotal/100;
		
	}
	
	public LoginPage clickonCheckOut () throws Throwable {
		Action.click(getDriver(), ProceedToCheckOut);
		return new LoginPage();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
