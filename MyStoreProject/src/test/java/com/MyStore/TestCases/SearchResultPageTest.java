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
import com.MyStore.pageobjects.IndexPage;
import com.MyStore.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchresultpage;
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
	@Test(dataProvider ="searchProduct", dataProviderClass = DataProviders.class, groups="Smoke" )
	public void VerifyProduct (String prod) throws Throwable {
		 indexPage= new IndexPage();
		 Log.startTestCase("VerifyProduct");
		 Log.info("User is going to search a product ");
		 searchresultpage=indexPage.searchProduct(prod);
		 //searchresultpage=indexPage.searchProduct(prop.getProperty("product"));
		 Log.info("checking the availability of the product");
		 boolean result=searchresultpage.isProductAvailable();
		 Assert.assertTrue(result);
		 Log.info("Product is available");
		 Log.endTestCase("VerifyProduct");
	}
	
	
	
	
	
	
	
	

}
