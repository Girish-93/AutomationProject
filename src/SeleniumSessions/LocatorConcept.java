package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91821\\Downloads\\chrome v-83\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch chrome
		
		driver.get("https://www.facebook.com");
		
		//1.By.xpath
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("8892454158");
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("mithun");
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
//	    
	    
//		
//		driver.navigate().to("https://www.healthcaremagic.com/");
//		driver.navigate().back();
//		driver.navigate().forward();
//		
		driver.close();
	
	}

}
