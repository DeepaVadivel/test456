package Test123.test456;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Base extends Reports{
	 
@Test 
public void testing() throws InterruptedException
{
	//WebDriver driver=Reports.driver;
	test.log(LogStatus.INFO, "test started");
	driver.manage().window().maximize();
	
	Thread.sleep(5000);
	driver.get("https://www.amazon.in");
	
	
	test.log(LogStatus.PASS, "Passed");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//div[@class='nav-search-field ']/input[@id='twotabsearchtextbox']")).sendKeys("fashion");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']/input[@class='nav-input']")).click();
	test.log(LogStatus.PASS, "Passed");
	Thread.sleep(5000);
	
	//driver.close();
}
}
