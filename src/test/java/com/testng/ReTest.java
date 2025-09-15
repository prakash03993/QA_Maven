package com.testng;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReTest implements IRetryAnalyzer {

	private int retryCount = 0;
	private static final int maxcount = 10;
	
	@Override
	public boolean retry(ITestResult result) {
		if(retryCount < maxcount) {
			retryCount++;
			return true;
			
		}
		return false;
	}

}
