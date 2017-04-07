package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.steadystate.css.util.Output;

public class Helper {

	public static String CaptureScreenShot(WebDriver driver , String ScreenShotName)
	{

		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 

		String destination = "C:\\Users\\natal\\workspace\\LearnAutomation\\com.learnautomation.hybrid\\Screenshots\\"+ScreenShotName +System.currentTimeMillis()+ ".png"; 

		try{
		
			FileUtils.copyFile(src, new File(destination));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return destination; 

	}
	
}
