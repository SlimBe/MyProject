package com.MyStore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.actiondriver.Action;
import com.MyStore.base.BaseClass;

public class AddToCartePage extends BaseClass {
	@FindBy(id = "quantity_wanted")
	WebElement quantity;
	
	@FindBy(id = "group_1")
	WebElement size;
	
	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement AddToCartBtn;
	
	@FindBy(xpath = "//*[@id=\"layer_cart\"]//h2/i")
	WebElement AddToCartMesage;
	
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	WebElement procedToCheckOutBtn;
	
	
	public AddToCartePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQuantity (String quantity1) throws Throwable {
		Action.type(quantity, quantity1);
		}
	
	public void selectSize (String size1) throws Throwable {
		Action.selectByVisibleText(size1, size); 
	}
	
	public void clickOnAddToCartBtn () throws Throwable  {
		Action.click(getDriver(), AddToCartBtn);
		 Action.fluentWait(getDriver(), AddToCartMesage,15);
	}
	
	public Boolean ValidateAddtoCart () throws Throwable  {
		return Action.isDisplayed(getDriver(), AddToCartMesage); 
	}
	 
	public OrderPage clickOnCheckOut () throws Throwable  {
		 Action.fluentWait(getDriver(), AddToCartMesage,15);
		 Action.JSClick(getDriver(), procedToCheckOutBtn); 
		 return new OrderPage();
		
	}

	

}
