package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver ;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver; 
		
	}
	//<input class="input-text" name="username" id="username" value="" type="text">

	@FindBy(xpath="//input[@id='username']") WebElement Login; 
	@FindBy(xpath="//input[@id='password']") WebElement password; 
	@FindBy(xpath="//input[@name='login']") WebElement SignInButton; 
	@FindBy(xpath ="//p[@id='user_info']") WebElement Tex; 
	
	
	public void LoginApplication(String User, String Pass)
	{
		
		Login.sendKeys("testuser1");
		password.sendKeys("testpwd1");
		SignInButton.click();
		
	}
	
	public void verifyLoginPage()
	{
		 
		WebDriverWait wb = new WebDriverWait(driver, 20); 
		wb.until(ExpectedConditions.presenceOfElementLocated((By)Tex));
		
		
				
	}
}
