package com.test;

import org.testng.annotations.Test;

public class TestNGFeatures {
	
	@Test
	public void loginTest() {
		System.out.println("loginTest");
		//int i=4/0;
	}
	
	@Test(dependsOnMethods="loginTest")
	public void HomePageTest() {
		System.out.println("HomePageTest");
	}
	
	@Test(dependsOnMethods="loginTest")
	public void searchPageTest() {
		System.out.println("searchPageTest");
	}
	
	@Test(dependsOnMethods="loginTest")
	public void RegPageTest() {
		System.out.println("RegPageTest");
	}
	

}
