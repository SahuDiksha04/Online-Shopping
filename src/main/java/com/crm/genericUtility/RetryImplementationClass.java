package com.crm.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementationClass implements IRetryAnalyzer {
	
	int count=0;
	int retries=3;
	public boolean retry(ITestResult result)
	{
		if(count<retries) {
			count++;
			return true;
       
			}
	
	 return false;
	}
}
