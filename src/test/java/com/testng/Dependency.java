package com.testng;

import org.testng.annotations.Test;

public class Dependency {

	@Test
	private void login() {
		System.out.println("LOGIN");

	}
	
	@Test(dependsOnMethods = {"login"})
	private void search() {
		System.out.println(10/0);
		System.out.println("SEARCH");
	}
	
	@Test(dependsOnMethods = {"login","search"})
	private void payment() {
		System.out.println("PAYMENT");
	}
}


