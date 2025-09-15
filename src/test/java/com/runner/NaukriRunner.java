package com.runner;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentReporter;
import com.listner.ITestListnerClass;
import com.pageobjectmanager.PageObjectManager;
import com.reusableMethods.BaseClass;

@Listeners(ITestListnerClass.class)

public class NaukriRunner extends BaseClass {


	@BeforeClass
	public  void  propertySetup() throws Throwable{	
		browserLaunch(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("browser"));
		urlLaunch(PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("url"));		
	}

	@Test(priority=1)
	public void naukriLogin() throws Throwable{
		//ExtentReportTest.extentTest = extentReports.createTest("Login Test" + ":" + Thread.currentThread().getStackTrace()[1].getMethodName().toString()).info("Naukri Application Test");
		PageObjectManager.getPageObjectManager().getLoginPage().validLogin();
	}
	
	@Test(priority=2)
		public void resumeUpload() throws Throwable{
		PageObjectManager.getPageObjectManager().getResumeUploadPage().resumeUpload();
	}
	
	
}
