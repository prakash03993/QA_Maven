package com.testng;

import org.testng.annotations.Test;

public class ExpectedExceptions {

	@Test(expectedExceptions = ArithmeticException.class)
	
	private void method1() {
		System.out.println(10/0);
		System.out.println("Method 1");
	}
	
	@Test
	private void method2() {
System.out.println("Method 2");
	}

	@Test
	private void method3() {
		System.out.println("Method 3");

	}
}

