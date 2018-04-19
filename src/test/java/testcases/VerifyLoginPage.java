package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Factory.DataProviderFactory;
import Factory.browserFactory;
import Pages.HomePage;
import Pages.LoginPage;

public class VerifyLoginPage {
	
	 WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		driver=browserFactory.getBrowser("Chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}
	
	@Test	
	public void testHomePage(){	
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);		
		String title = home.getTitle();
		Assert.assertTrue(title.contains("Demo Store"));
		home.clickOnSignInLink();
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		/*login.loginApplication("sathkb@gmail.com", "Test@123");*/
		login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0),DataProviderFactory.getExcel().getData(0, 0, 1));
		login.verifyLogOutLink();
	}
	
	
	@AfterMethod
	public void tearDown(){
		browserFactory.closeBrowser(driver);
	}

}
