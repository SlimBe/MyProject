package com.MyStore.TestCases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyStore.DataProvider.DataProviders;
import com.MyStore.Utility.Log;
import com.MyStore.actiondriver.Action;
import com.MyStore.base.BaseClass;
import com.MyStore.pageobjects.AddToCartePage;
import com.MyStore.pageobjects.IndexPage;
import com.MyStore.pageobjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass {
	IndexPage        indexPage;
	SearchResultPage searchresultpage;
	AddToCartePage   addtocartepage;
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
		
	}
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void TearDown() {
		//Action.fluentWait(getDriver(),null,1);
		getDriver().quit();
	}
	@Test(dataProvider ="addtocart", dataProviderClass = DataProviders.class,groups= {"Regression","Sanity"})
	public void addToCartTest (String prod ,String quant, String sii) throws Throwable {
		 Log.startTestCase("addToCartTest");
		 indexPage= new IndexPage();
		 Log.info("User is going to search a product");
		 //searchresultpage=indexPage.searchProduct(prop.getProperty("product"));
		 searchresultpage=indexPage.searchProduct(prod);
		 Log.info("User is going to select the product");
		 addtocartepage=searchresultpage.ClickonProduct();
		 Log.info("User is going to enter the quantity");
		 //addtocartepage.enterQuantity(prop.getProperty("quantity"));
		 addtocartepage.enterQuantity(quant);
		 Log.info("User is going to enter the size");
		 //addtocartepage.selectSize(prop.getProperty("size"));
		 addtocartepage.selectSize(sii);
		 Log.info("User is going to click on the addtocart btn");
		 addtocartepage.clickOnAddToCartBtn();
		 Log.info("cheking the adding of the product");
		 boolean result=addtocartepage.ValidateAddtoCart();
		 Assert.assertTrue(result);
		 Log.info("product added to the user cart");
		 Log.endTestCase("addToCartTest");
		
		
		
	}
	
	
	
	
	
	
	
	

}
