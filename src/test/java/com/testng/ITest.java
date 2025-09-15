package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ITest {

	
	WebDriver driver;
	
	@BeforeTest
	private void beforeTest() {
		
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}
	@AfterTest
	private void afterTest() {
		driver.quit();
	}
	@Test(retryAnalyzer = ReTest.class)
	
	private void testMethod() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "google");

	}
}
