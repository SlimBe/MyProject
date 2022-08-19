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
import com.MyStore.pageobjects.AdressPage;
import com.MyStore.pageobjects.IndexPage;
import com.MyStore.pageobjects.LoginPage;
import com.MyStore.pageobjects.OrderConfirmationPage;
import com.MyStore.pageobjects.OrderPage;
import com.MyStore.pageobjects.OrderSummaryPAGE;
import com.MyStore.pageobjects.PaymentPage;
import com.MyStore.pageobjects.SearchResultPage;
import com.MyStore.pageobjects.ShipingPage;

public class EndToEndTest extends BaseClass {
	
		IndexPage        indexPage;
		SearchResultPage searchresultpage;
		AddToCartePage   addtocartepage;
		OrderPage		 ordrepage;
		LoginPage        loginPage;
		AdressPage       adresspage;
		ShipingPage      shipingpage;
		PaymentPage      paymentpage;
		OrderSummaryPAGE ordersummarypage;
		OrderConfirmationPage orderconfirmationpage;
		
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
		
		@Test(dataProvider ="getProduct", dataProviderClass = DataProviders.class,groups="Regression")
		public void endToEndTest (String prodName ,String qty, String Size , String usname, String psswd) throws Throwable {
			 Log.startTestCase("endToEndTest");
			 indexPage= new IndexPage();
			 Log.info("User is going to search a product");
			 //searchresultpage=indexPage.searchProduct(prop.getProperty("product"));
			 searchresultpage=indexPage.searchProduct(prodName);
			 Log.info("User is going to select the product");
			 addtocartepage=searchresultpage.ClickonProduct();
			 Log.info("User is going to enter the quantity");
			 //addtocartepage.enterQuantity(prop.getProperty("quantity"));
			 addtocartepage.enterQuantity(qty);
			 Log.info("User is going to enter the size");
			 //addtocartepage.selectSize(prop.getProperty("size"));
			 addtocartepage.selectSize(Size);
			 Log.info("User is going to click on the addtocart btn");
			 addtocartepage.clickOnAddToCartBtn();
			 Log.info("User is going to click checkout btn");
			 ordrepage=addtocartepage.clickOnCheckOut();
			 Log.info("User is going to click checkout btn order page");
			 loginPage=ordrepage.clickonCheckOut();
			 Log.info("User enter username and password");
			 //adresspage=loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
			 adresspage=loginPage.login1(usname,psswd);
			 Log.info("User is going to click checkout adress page btn");
			 shipingpage=adresspage.clickonCheckOut();
			 Log.info("User is going to check the terms");
			 shipingpage.clickonetheTerms();
			 Log.info("User is going to click on checkout");
			 paymentpage=shipingpage.clickonProceedTocheckOut();
			 Log.info("User is going to click on pay by bank wire");
			 ordersummarypage=paymentpage.clickOnPayByBankwire();
			 Log.info("User is going to click on confirm order btn  ");
			 orderconfirmationpage=ordersummarypage.clickonConfirmOrderBtn();
			 Log.info("checking the confirmation of your command ");
			 String result=orderconfirmationpage.ValidateCofirmMessage();
			 String expectedMessage="Your order on My Store is complete.";
			 Assert.assertEquals(result,expectedMessage);
			 Log.info("command confirmed ");
			 Log.endTestCase("endToEndTest");
			
		}
		
		
		
		
		
		
		
		
		
		
}
