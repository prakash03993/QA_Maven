package com.testng;


import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.reusableMethods.BaseClass;

public class CrossBrowser extends BaseClass {
@Test(enabled=false)
	private void firefox() {
	browserLaunch("firefox");
	urlLaunch("https://www.google.com/");
	System.out.println("BROWSER ID : " + Thread.currentThread().getId());
}
@Ignore
@Test
	private void edge() {
	browserLaunch("edge");
	urlLaunch("https://www.google.com/");
	System.out.println("BROWSER ID : " + Thread.currentThread().getId());
		
	}
@Test	
	private void chrome() {
	browserLaunch("Chrome");
	urlLaunch("https://www.google.com/");
	System.out.println("BROWSER ID : " + Thread.currentThread().getId());
		
	}
	
	
}
