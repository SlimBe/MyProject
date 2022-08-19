package com.MyStore.TestCases;






import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyStore.Utility.Log;
import com.MyStore.actiondriver.Action;
import com.MyStore.base.BaseClass;
import com.MyStore.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {
	IndexPage indexPage;
	
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
	
	@Test(groups="Smoke")
	public void VerifyLogo() throws Throwable{
		Log.startTestCase("VerifyLogo");
		indexPage= new IndexPage();
		Log.info("verify the logo existance");
		boolean result=indexPage.ValidateLogo();
		Assert.assertTrue(result);
		Log.info("Logo Is Displayed");
		Log.endTestCase("VerifyLogo");
		}
	@Test(groups="Smoke")
	public void VerifyTitle() throws Throwable{
		Log.startTestCase("VerifyTitle");
		indexPage= new IndexPage();
		Log.info("verify the title of the page");
		String Title=indexPage.getMyStoreTtilte();
		Assert.assertEquals(Title, "My Store1");
		Log.info("Title is checked out");
		Log.endTestCase("VerifyTitle");
		}
	
	
	
	

}
