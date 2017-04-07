package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	
	WebDriver driver ; 
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver ; 
	}
	
	@FindBy(xpath = "//a[text()='My Account']") WebElement MyAccountLInk; 
	@FindBy(xpath = "//a[text()='Shop']") WebElement ShopLInk; 
	@FindBy(xpath = "//a[text()='Cart']") WebElement CartLInk; 
	@FindBy(xpath = "//a[text()='Test Pages']") WebElement TestPagesLInk; 
	

	public void clickOnMyAccountLink()
	{
		MyAccountLInk.click();
	}
	public void clickShopLink()
	{
		ShopLInk.click();
	}

	public void ClickOnCartLink()
	{
		CartLInk.click();
	}
	public void clickOnTestPAgesLink()
	{
		TestPagesLInk.click();
	}
	
	public String GetTitle()
	{
		return driver.getTitle(); 
	}
}
