package com.testng;

import org.testng.annotations.Test;

public class Priority {

	@Test(priority = 1)
	public void login() {
	System.out.println("LOGIN"); 	
	}
	
	@Test(priority = 2)
	public void search() {
		System.out.println("SEARCH"); 	
	}
	@Test(priority = 3)
	public void addToCart() {
		System.out.println("ADD TO CART"); 	
	}

	}
	
	
	
	

