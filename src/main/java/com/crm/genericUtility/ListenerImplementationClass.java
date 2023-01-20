package com.crm.genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ListenerImplementationClass implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		test=report.createTest(methodName);
		Reporter.log("");
	}

	public void onTestFailure(ITestResult result) {
		String FS="Failescript"+new JavaUtility().getSystemDate();
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.edriver);
	    File src = edriver.getScreenshotAs(OutputType.FILE);
	    File path = new File("./Screenshot/"+FS+".png");
	    try {
			FileUtils.copyFile(src, path);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	    
		
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP ,MethodName+"---Skipped");
		Reporter.log("---TestScript Execution Skipped---");
		
		
	}

	public void onStart(ITestContext context) {
		//configure the report
	    ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report.html");
	     htmlreport.config().setDocumentTitle("");
	    
		
		
	}

	private Object ExtentSparkReporter(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public void onFinish(ITestContext context) {
		
	}

}
