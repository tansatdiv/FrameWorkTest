package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Factory.DataProviderFactory;
import Factory.browserFactory;
import Pages.HomePage;
import Pages.LoginPage;

public class VerifyHomePage{
	
	 WebDriver driver;
	 ExtentReports reports;
	 ExtentTest  logger;
	
	@BeforeMethod
	public void setUp(){
		
		reports = new ExtentReports(".\\Reports\\LoginPageReport.html",true);
		logger = reports.startTest("Verify Login page");			
		driver=browserFactory.getBrowser("Chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		logger.log(LogStatus.INFO, "Application is up and Running");
	}
	
	@Test	
	public void testHomePage(){	
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);		
		String title = home.getTitle();
		Assert.assertTrue(title.contains("Demo Store"));
		logger.log(LogStatus.PASS, "Home page is loaded and Verified");
		home.clickOnSignInLink();
		logger.log(LogStatus.INFO,"Click on signin Link");
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		/*login.loginApplication("sathkb@gmail.com", "Test@123");*/
		login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0),DataProviderFactory.getExcel().getData(0, 0, 1));
		logger.log(LogStatus.INFO, "Login to Application");
		login.verifyLogOutLink();
		logger.log(LogStatus.PASS, "SignOut link is present");
	}
	
	
	@AfterMethod
	public void tearDown(){
		browserFactory.closeBrowser(driver);
		reports.endTest(logger);
		reports.flush();
		
	}

}
