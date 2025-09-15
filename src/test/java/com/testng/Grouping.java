package com.testng;

import org.testng.annotations.Test;

public class Grouping {
	@Test(groups = "subjects")
	private void english() {
		System.out.println("English");

	}

	@Test(groups = "subjects")
	private void tamil() {
		System.out.println("Tamil");

	}

	@Test(groups = "subjects")
	private void malayalam() {
		System.out.println("Malayalam");

	}

	@Test(groups = "ug Degree")
	private void bsc() {
		System.out.println("B.sc");

	}

	@Test(groups = "ug Degree")
	private void bcom() {
		System.out.println("B.com");
	}

	@Test(groups = "ug Degree")
	private void be() {
		System.out.println("B.E");

	}

}
