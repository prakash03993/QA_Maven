package com.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.reusables.Base_Class;

public abstract class ParameterizationClass extends Base_Class {
	@Parameters({ "username", "password" })
	@Test()

	private void testMethod(String username, String password) {
		browserLaunch("Chrome");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		urlLaunch("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	
	
}
