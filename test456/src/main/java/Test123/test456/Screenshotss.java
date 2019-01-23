package Test123.test456;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshotss {
	public static void takeScreenshot(WebDriver driver)
	{
		Date g=new Date();
		String d=g.toString();
		String date=d.replaceAll(":", "_");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		File destFile = new File("C:/Users/deepa.vadivel/pictures/screnshot/"+date+".png");
		try
		{
		FileUtils.copyFile(src, destFile);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
