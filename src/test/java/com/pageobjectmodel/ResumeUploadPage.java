package com.pageobjectmodel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.interfaceelements.ResumeUploadInterfaceElements;
import com.reusables.Base_Class;

public class ResumeUploadPage extends Base_Class implements ResumeUploadInterfaceElements {

	@FindBy(xpath = createProfile_xpath)
	private WebElement createProfile;
	
	@FindBy(xpath = resumeUploads_xpath)
	private WebElement resumeUploads;
	
	public ResumeUploadPage() {
		PageFactory.initElements(driver, this);
	}
		public void resumeUpload() {
			scrollToElement(resumeUploads,"click");
			elementClick(createProfile);
			elementClick(resumeUploads);
			
		}
		
	}
	


	

