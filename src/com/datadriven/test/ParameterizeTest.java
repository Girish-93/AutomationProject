package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class ParameterizeTest {

	public static void main(String[] args) {
		
		//webdriver code		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91821\\Downloads\\chrome v-83\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch chrome
		driver.get("https://reg.ebay.in/reg/PartialReg?siteid=203&co_partnerId=0&UsingSSL=1&rv4=1&signInUrl=https%3A%2F%2Fwww.ebay.in%2Fsignin%3Fsgn%3Dreg%26siteid%3D203%26co_partnerId%3D0%26UsingSSL%3D1%26rv4%3D1");// enter Url
		
		driver.manage().window().maximize();// maximize window
	    driver.manage().deleteAllCookies();// delete all cookies
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		//Data Driven Approch: used to create data driven framework:
		
		
		//get test data from excel
        Xls_Reader reader = new Xls_Reader("D:\\HSSCM21\\Automation\\src\\com\\qa\\testdata\\HalfEbayTestData.xlsx");
        int rowCount = reader.getRowCount("RegTestData");
        
        reader.addColumn("RegTestData", "Status");
        
        //parameterization:
        for(int rowNum=2; rowNum<=rowCount ; rowNum++) {
        	System.out.println("******");
        	String firstname = reader.getCellData("RegTestData", "firstname", rowNum);
        	System.out.println(firstname);
        	
        	String lastname = reader.getCellData("RegTestData","lastname",rowNum);
    		System.out.println(lastname);
    		
    		String email = reader.getCellData("RegTestData","email",rowNum);
    		System.out.println(email);
    		
    		String password = reader.getCellData("RegTestData","password" ,rowNum);
    		System.out.println(password);
    		
    		//enter data
    		driver.findElement(By.xpath("//input[@id='firstname']")).clear();
    		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstname);
    		

    		driver.findElement(By.xpath("//input[@id='lastname']")).clear();
    		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastname);
    		
    		driver.findElement(By.xpath("//input[@id='email']")).clear();
    		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
    		
    		driver.findElement(By.xpath("//input[@id='PASSWORD']")).clear();
    		driver.findElement(By.xpath("//input[@id='PASSWORD']")).sendKeys(password);
    		
    		reader.setCellData("RegTestData", "status", rowNum, "Pass");//write date into excel
    			
    		
        }

	}

}
