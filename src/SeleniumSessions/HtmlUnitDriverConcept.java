package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverConcept {

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.chrome.driver","C:\\Users\\91821\\Downloads\\chrome v-83\\chromedriver_win32 (1)\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();// launch chrome
		
		//htmlunitdriver is not available in selenium 3.x version
		//htmlunitdriver ---to use this concept ,we have to download htmlunitdriver JAR file
		
		//advantages
		//1.testing is behind the scence--no browser is launched
		//2.very fast--execution of test case--very fast--performance of the script
		//3.Not suitable for Action class--user actions --mousemovement,doubleclick,drag and drop
		//4.Ghost driver--HeadLess browser:
		   //HtmlUnitDriver---java
		   //phontumJS--JavaScript
		   
		
		WebDriver driver = new HtmlUnitDriver();
		
//		driver.manage().window().maximize();// maximize window
//		driver.manage().deleteAllCookies();// delete all cookies
//		
//		//dynamic wait
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.crmpro.com/");
		
		System.out.println("Before login, tittle is:==="+ driver.getTitle());
		
		driver.findElement(By.name("username")).sendKeys("girishsb");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(2000);
		
		System.out.println("After login, tittle is:==="+ driver.getTitle());
		

	}

}
