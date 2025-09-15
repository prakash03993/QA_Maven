package com.testng;

import org.testng.annotations.Test;

import com.reusableMethods.BaseClass;

public class InvocationClass extends BaseClass {
     @Test(invocationCount = 2)
	private void login() {
		browserLaunch("Chrome");
		urlLaunch("https://www.facebook.com/");
		sessionTerminate("quit");
		

	}
	
}
