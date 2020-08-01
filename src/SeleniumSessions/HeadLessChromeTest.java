package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessChromeTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty( "webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91821\\Downloads\\chrome v-83\\chromedriver_win32 (1)\\chromedriver.exe");
	
        
        //mandatory
        //1.chrome version should be greater than 59 for mac and 60 for windows
        //2.window size-1400,800
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1400,800");
        options.addArguments("headless");
        
		
		WebDriver driver = new ChromeDriver(options);// launch chrome
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.crmpro.com/");
		
		System.out.println("Before login, tittle is:==="+ driver.getTitle());
		
		driver.findElement(By.name("username")).sendKeys("girishsb");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(2000);
		
		System.out.println("After login, tittle is:==="+ driver.getTitle());
		
		

	}

}
