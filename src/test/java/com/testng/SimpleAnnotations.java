package com.testng;

import java.io.Closeable;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleAnnotations {
      @BeforeSuite
  private void propertySetting() {
    	  System.out.println("PROPERTY SETTINGS");

}
      @BeforeTest
      private void launchBrowser() {
		System.out.println("BROWSERLAUNCH");
	}
      @BeforeClass
      private void launchUrl() {
		System.out.println("URL LAUNCH");

	}
      @BeforeMethod
      private void login() {
		System.out.println("LOGIN");
	}
    	 @Test
    	 private void men() {
			System.out.println("WOMEN");
		}
    	 @Test
    	 private void women() {
			System.out.println("MEN");
		}
    	 @Test
    	 private void kids() {
			System.out.println("KIDS");

		}
    	 @AfterMethod
    	 private void logout() {
			System.out.println("LOGOUT");

		}
    	 @AfterClass
    	 private void screenshot() {
			System.out.println("SCREENSHOT");
		}
    	 @AfterTest
    	 private void Close() {
	System.out.println("CLOSE"); 
		}
    	 @AfterSuite
    	 private void termination() {
			System.out.println("TERMINATION");

		} 
}
