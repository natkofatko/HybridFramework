package Factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import DataProvider.ConfigDataProvider;

public class BrowserFactory {
	
	static WebDriver driver ; 
	
	
	public static WebDriver getBrowser(String browserName)
	{
		
		
		if (browserName.equalsIgnoreCase("firefox"))
		{
			ConfigDataProvider config = new ConfigDataProvider (); 
			System.setProperty("webdriver.gecko.driver", config.getFireForxProperty()); 
			driver = new FirefoxDriver(); 
//			webdriver.gecko.driver",
//			"C:\\Users\\natal\\Downloads\\geckodriver-v0.14.0-win64\\geckodriver.exe");
			
		}
		else if (browserName.equalsIgnoreCase("chrome"))
		{
			 
			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getCOnfig().getChromeProperty()); 
			driver = new ChromeDriver(); 
		
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			ConfigDataProvider config = new ConfigDataProvider (); 
			System.setProperty("webdriver.edge.driver", config.getEdgeProperty()); 
			driver = new EdgeDriver(); 
			
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		
		return driver; 
	}
	
	
	public static void closeBrowser(WebDriver LDriver)
	{
		LDriver.quit();
	}

}
