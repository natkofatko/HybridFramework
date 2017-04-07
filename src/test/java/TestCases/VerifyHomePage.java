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

public class VerifyHomePage {
	
	WebDriver driver; 
	
@BeforeMethod
public void SetUp()
{
	driver = BrowserFactory.getBrowser("firefox");	
	driver.get(DataProviderFactory.getCOnfig().getApplicationUrl());
}

	
	
	@Test
	public void testHomePage()
	{
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		String title = home.GetTitle(); 
		Assert.assertTrue(title.contains ("ABS"), "Test did not pass");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
	}

}
