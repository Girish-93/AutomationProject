package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNGBasics {
	
//	@BeforeSuite--setup system property for chrome-1
//	@BeforeTest--launch chrome browser-2
//	@BeforeClass--login to app-3
	
//	@Test--googleLogoTest--enter url-4
//	@AfterMethod--logout from app
//	
	
//	@Test--Google Title test--enter url
//	@AfterMethod--logout from app

//	@Test--searchTest--enter url
//	@AfterMethod--logout from app
	
//	@AfterClass--close browser
//	@AfterTest--deletAllCookies

	
	
	
	//pre-condition annotations - starting with @Before
	@BeforeSuite//1
	public void setUp() {
		System.out.println("@BeforeSuite--setup system property for chrome");
	}
	
	@BeforeTest//2
	public void launchBrowser() {
		System.out.println("@BeforeTest--launch chrome browser");
	}
	
	@BeforeClass//3
	public void login() {
		System.out.println("@BeforeClass--login to app");
	}
	
	/*@BeforeMethod
	 *@Test - 1
	 *@AfterMethod
	 *
	 *@BeforeMethod
	 *@Test - 2
	 *@AfterMethod
	 * 
	 *@BeforeMethod
	 *@Test - 3
	 *@AfterMethod
	 *  
	 */
	
	@BeforeMethod//4
	public void enterUrl() {
		System.out.println("enter url");
	}
	
	//testcases -- starting with @Test
	
	@Test//5
	public void googlePageTitle() {
		System.out.println("@Test--Google Title test");
	}
	
	@Test
	public void searchTest() {
		System.out.println("@Test--searchTest");
	}
	
	@Test
	public void googleLogoTest() {
		System.out.println("@Test--googleLogoTest");
	}
	
	//post conditions - starting with @After
	@AfterMethod//6
	public void logOut() {
		System.out.println("@AfterMethod--logout from app");
	}
	
	@AfterClass//7
	public void closeBrowser() {
		System.out.println("@AfterClass--close browser");
	}
	
	@AfterTest//8
	public void deletAllCookies() {
		System.out.println("@AfterTest--deletAllCookies");
	}
	
//	@AfterSuite//9
//	public void generateTestReport() {
//		System.out.println("generateTestReport");
//	}

}
