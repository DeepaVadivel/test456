package Test123.test456;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Reports implements ITestListener {
	public static WebDriver driver;
	 protected static ExtentReports reports;
	 protected static ExtentTest test;
	 Screenshotss st=new Screenshotss();
	 public void onTestStart(ITestResult result) {
	  System.out.println("on test start");
	  test = reports.startTest(result.getMethod().getMethodName());
	  test.log(LogStatus.INFO, result.getMethod().getMethodName() + "test is started");
	 }
	 public void onTestSuccess(ITestResult result) {
	  System.out.println("on test success");
	  test.log(LogStatus.PASS, result.getMethod().getMethodName() + "test is passed");
	  st.takeScreenshot(driver);
	  
	 }
	 public void onTestFailure(ITestResult result) {
	  System.out.println("on test failure");
	  test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed");
	  TakesScreenshot ts = (TakesScreenshot) driver;
	  File src = ts.getScreenshotAs(OutputType.FILE);
	  try {
	   FileUtils.copyFile(src, new File("C:\\images\\" + result.getMethod().getMethodName() + ".png"));
	   String file = test.addScreenCapture("C:\\images\\" + result.getMethod().getMethodName() + ".png");
	   test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", file);
	   test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", result.getThrowable().getMessage());
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	 }
	 public void onTestSkipped(ITestResult result) {
	  System.out.println("on test skipped");
	  test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "test is skipped");
	 }
	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	  System.out.println("on test sucess within percentage");
	 }
	 public void onStart(ITestContext context) {
	  System.out.println("on start");
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepa.vadivel\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver(); // Set the drivers path in environment variables to avoid code(System.setProperty())
	  reports = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
	 }
	 public void onFinish(ITestContext context) {
	  System.out.println("on finish");
	  driver.close();
	  reports.endTest(test);
	  reports.flush();
	 }
	 


}
