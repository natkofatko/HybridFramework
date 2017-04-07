package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Factory.BrowserFactory;
import Factory.DataProviderFactory;
import Pages.HomePage;
import Pages.LoginPage;

public class VerifyLoginPage {
	
	WebDriver driver; 
	
@BeforeMethod
public void SetUp()
{
	driver = BrowserFactory.getBrowser("edge");	
	driver.get(DataProviderFactory.getCOnfig().getApplicationUrl());
}

	
	
	@Test
	public void testLoginPage() throws InterruptedException
	{
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String title = home.GetTitle(); 
		Assert.assertTrue(title.contains ("ABS"), "Test did not pass");
		home.clickOnMyAccountLink();
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		Thread.sleep(2000);
		login.LoginApplication((DataProviderFactory.getExcel().getDataBySheetIndex(0, 0, 0)), DataProviderFactory.getExcel().getDataBySheetIndex(0, 0, 1));
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
	}

}
