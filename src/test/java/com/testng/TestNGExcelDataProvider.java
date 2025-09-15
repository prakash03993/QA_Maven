package com.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.reusables.Base_Class;

public class TestNGExcelDataProvider extends Base_Class {
	@DataProvider(name = "excelDataProvider")
	public Object[][] dataProviderMethod() {
	String filePath = System.getProperty("user.dir") + "\\Excel\\Book1.xlsx";
	String sheetName = "Sheet1";
	return ExcelReader.getExcelData(filePath, sheetName);
	}
	
	@Test(dataProvider = "excelDataProvider")

	private void testMethod(String username, String password) {
		browserLaunch("Chrome");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		urlLaunch("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("userName : " + username + "| password :"+ password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		sessionTerminate("close");
	}

	

	
}
