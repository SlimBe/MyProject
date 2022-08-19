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

public class LoginPageTest extends BaseClass {
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
		//Action.fluentWait(getDriver(),null,2);
		getDriver().quit();
		
	
	}
	
	@Test(dataProvider ="credentials", dataProviderClass = DataProviders.class, groups= {"Smoke","Sanity"})   
	public void LoginTest (String uname, String pwd) throws Throwable {
		Log.startTestCase("LoginTest");
        indexPage= new IndexPage();
        Log.info("User is going to click on signIn");
        loginPage=indexPage.clickOnsignIn();
        Log.info("User enter username and password");
        //homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        homepage=loginPage.login(uname,pwd);
        String Actualurl=homepage.GetCurrentUrl();
        String ExpectedUrl="http://automationpractice.com/index.php?controller=my-account";
        Log.info("Verfiying if user is able to login");
        Assert.assertEquals(Actualurl,ExpectedUrl);
        Log.info("Login is sucess");
        Log.endTestCase("LoginTest");
	}
}


