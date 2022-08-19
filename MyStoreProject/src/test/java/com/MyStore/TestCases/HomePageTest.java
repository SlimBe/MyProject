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
import com.MyStore.pageobjects.HomePage;
import com.MyStore.pageobjects.IndexPage;
import com.MyStore.pageobjects.LoginPage;

public class HomePageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage  homepage;

	
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
	
	@Test(dataProvider ="credentials", dataProviderClass = DataProviders.class,groups="Smoke" )
	public void WishListTest (String uname, String pwd) throws Throwable {
		Log.startTestCase("WishListTest");
		indexPage= new IndexPage();
		Log.info("User is going to click on signIn btn");
        loginPage=indexPage.clickOnsignIn();
        Log.info("Enter the username and the passeword");
        homepage=loginPage.login(uname,pwd);
        //homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Log.info("checking Validate WishList");
        boolean result=homepage.ValidateMyWishList();
        Assert.assertTrue(result);
        Log.info("Validate WishList checked");
        Log.endTestCase("WishListTest");
		
	}
	
	@Test(dataProvider ="credentials", dataProviderClass = DataProviders.class, groups="Smoke" )
	public void OrderHistoryTest (String uname, String pwd) throws Throwable {
		Log.startTestCase("OrderHistoryTest");
		indexPage= new IndexPage();
		Log.info("User is going to click on signIn btn");
        loginPage=indexPage.clickOnsignIn();
        Log.info("Enter the username and the passeword");
        homepage=loginPage.login(uname,pwd);
        //homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Log.info("checking Validate Order history");
        boolean result=homepage.ValidateOrderHistory();
        Assert.assertTrue(false);
        Log.info("Validate Order history checked");
        Log.endTestCase("OrderHistoryTest");
	}
	
	
	
	

}
