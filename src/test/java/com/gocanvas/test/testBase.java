package com.gocanvas.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.gocanvas.utils.BrowserUtils;
import com.gocanvas.utils.ConfigurationReader;
import com.gocanvas.utils.Driver;

public class testBase {
	protected WebDriver driver;
	protected Actions actions;
	protected static ExtentReports report;
	protected static ExtentHtmlReporter htmlReport;
	protected static ExtentTest extentLogger;
	
	@BeforeTest
	public void setUpTest() {
		// actual report
		report=new ExtentReports();
		String filePath=System.getProperty("usr.dir")+"/test-output/report.html";
		htmlReport = new ExtentHtmlReporter(filePath);
		report.attachReporter(htmlReport);
		
		report.setSystemInfo("ENV", "staging");
		report.setSystemInfo("browser", ConfigurationReader.getProperty("browser"));
		report.setSystemInfo("OS", System.getProperty("os.name"));
		
		htmlReport.config().setReportName("Web Order Automated Test Report");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		driver= Driver.getDriver();
		actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //driver.manage().window().fullscreen();
		
		driver.get(ConfigurationReader.getProperty("url"));
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			String screenshotLocation = BrowserUtils.getScreenShot(result.getName());
			
			extentLogger.fail(result.getName());
			extentLogger.fail(result.getThrowable());
			extentLogger.addScreenCaptureFromPath(screenshotLocation);
			
		}else if(result.getStatus() == ITestResult.SKIP) {
			extentLogger.skip("Test Case Skipped is "+ result.getName());
		}
		Driver.closeDriver();	
	}
	
	@AfterTest
	public void tearDownTest() {
		report.flush();
	}
	
}
