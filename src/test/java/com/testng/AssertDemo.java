package com.testng;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertDemo {
	
	@Test

	private void hardAssertDemo() {
		String word1 = "login";
		String word2 = "Login";
		
		Assert.assertEquals(word1, word2);
		System.out.println("VALIDATION DONE");
	}
}
