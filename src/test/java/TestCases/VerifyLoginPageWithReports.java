package TestCases;

import javax.naming.spi.DirStateFactory.Result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Pages.HomePage;
import Pages.LoginPage;
import Utility.Helper;

public class VerifyLoginPageWithReports {
	
	WebDriver driver; 
	ExtentReports report; 
	ExtentTest logger; 
	
@BeforeMethod
public void SetUp()
{
	report = new ExtentReports("C:\\Users\\natal\\workspace\\LearnAutomation\\com.learnautomation.hybrid\\Reports\\loginPageReport.html", true); 
	logger = report.startTest("VerifyTestLogin"); 
	driver = BrowserFactory.getBrowser("firefox");	
	driver.get(DataProviderFactory.getCOnfig().getApplicationUrl());
logger.log(LogStatus.INFO, "Application is Up to running");
}

	
	
	@Test
	public void testLoginPage() throws InterruptedException
	{
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String title = home.GetTitle(); 
		Assert.assertTrue(title.contains ("ABS"), "Test did not pass");
		logger.log(LogStatus.PASS, "Home page is loaded and verified");
		Helper.CaptureScreenShot(driver, "FIRST PICTURE"); 
		
		
		home.clickOnMyAccountLink();
		logger.log(LogStatus.INFO, "Click on MyAccouny Link");
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		logger.log(LogStatus.INFO, "login to my accouny page");
		Thread.sleep(2000);
		login.LoginApplication((DataProviderFactory.getExcel().getDataBySheetIndex(0, 0, 0)), DataProviderFactory.getExcel().getDataBySheetIndex(0, 0, 1));
		logger.log(LogStatus.PASS, "login to my account page is succesful");
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult reslut)
	{
		if(reslut.getStatus()==ITestResult.FAILURE)
		{
			Helper.CaptureScreenShot(driver, reslut.getName()); 
		}
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}

}
