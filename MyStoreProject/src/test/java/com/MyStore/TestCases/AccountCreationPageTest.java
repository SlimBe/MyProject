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
import com.MyStore.pageobjects.AccountCreationPage;
import com.MyStore.pageobjects.IndexPage;
import com.MyStore.pageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass {
	IndexPage           indexPage;
	LoginPage           loginPage;
	AccountCreationPage accountcreationpage;
	
	@Parameters("browser")
	@BeforeMethod (groups= {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
		
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void TearDown() {
		//Action.fluentWait(getDriver(),null,1);
		getDriver().quit();
	}
    @Test(dataProvider ="email", dataProviderClass = DataProviders.class, groups="Sanity" )
	public void VerifyCreatAcountPageTest (String mail) throws Throwable {
    	Log.startTestCase("VerifyCreatAcountPageTest");
    	indexPage= new IndexPage();
    	Log.info("User is going to click on signIn");
        loginPage=indexPage.clickOnsignIn();
        Log.info("User is going enter Email");
        //accountcreationpage=loginPage.creatNewAccount(prop.getProperty("email_creation"));
        accountcreationpage=loginPage.creatNewAccount(mail);
        Log.info("verifying if the creation page is open");
        boolean result=accountcreationpage.validateAccountCreatePage();
        Assert.assertTrue(result);
        Log.info("creation account page open succsesfully");
        Log.endTestCase("VerifyCreatAcountPageTest");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
