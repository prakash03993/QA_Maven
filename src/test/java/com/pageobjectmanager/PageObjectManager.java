package com.pageobjectmanager;

import com.pageobjectmodel.LoginPage;
import com.pageobjectmodel.ResumeUploadPage;
import com.runner.NaukriRunner;
import com.utility.FileReaderManager;

public class PageObjectManager {

	private LoginPage loginPage;
	private FileReaderManager fileReader;
	private static PageObjectManager pageObjectManager;
	private static ResumeUploadPage resumeUploadPage;
	
	
	public LoginPage getLoginPage() {
		if(loginPage == null) {
			loginPage = new LoginPage();	
		}
		
		return loginPage;
	}
	
	public FileReaderManager getFileReader() {
		if(fileReader== null) {		
			fileReader = new FileReaderManager();
		}
		return fileReader;			
	}

	public static PageObjectManager getPageObjectManager() {
		if(pageObjectManager == null) {
			pageObjectManager = new PageObjectManager();	
		}
			
		return pageObjectManager;
	}

	public ResumeUploadPage getResumeUploadPage() {
		if(resumeUploadPage == null) {
			resumeUploadPage = new ResumeUploadPage();	
		}
		return resumeUploadPage;
	}

	

}
