package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro; 
	
	public ConfigDataProvider()
	{ 
		File src = new File("C:\\Users\\natal\\workspace\\LearnAutomation\\com.learnautomation.hybrid\\Configuration\\config.properties");
	
	try 
	{
	FileInputStream fis = new FileInputStream(src); 
	pro = new Properties(); 
	pro.load(fis);
	
	}
	catch (Exception e )
	{
		System.out.println("exception is "  + e.getMessage());
	}
	
	}
	
	public String getApplicationUrl()
	{	
	String urlAdress = pro.getProperty("url"); 
		return urlAdress; 
	}

	public String getChromeProperty()
	{
		String chrome = pro.getProperty("chrome");
		return chrome; 
	}
	public String getFireForxProperty()
	{
		String fireFox = pro.getProperty("firefox"); 
		return fireFox; 
	}
	
	public String getEdgeProperty()
	{
		String edge = pro.getProperty("edge");
		return edge; 
	}
	
	}


