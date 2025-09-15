package com.listner;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.reusables.Base_Class;

public class ExtentReport_Test {

	public static ExtentTest extenttest;
	
	@BeforeSuite
	public void extentTestReportStartup() throws IOException {
		Base_Class base = new Base_Class() {

			
			protected void extentReportStart(Object location) {
				
			}
			};
		base.extentReportStart(null);
			}
	
	@AfterSuite
	public void extentReportEnd() throws IOException {
		Base_Class base = new Base_Class() {

			
			protected void extentReportStart(Object location) {
				
			}
			
		};
		
		base.extentReportTearDown(null);

	}
	
	
}
