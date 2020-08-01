package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ModelPopUp {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty( "webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91821\\Downloads\\chrome v-83\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch chrome
		
        driver.get("https://www.crmpro.com/index.html");//enter url
		
		driver.findElement(By.name("username")).sendKeys("girishsb");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		Thread.sleep(2000);
		
		//driver.switchTo().frame("intercom-borderless-frame");
		
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card-author']"))).build().perform();
//		
//		driver.findElement(By.xpath("//div[conatins(@lass,'intercom-borderless-dismiss-button')]//span")).click();
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	    	
	}

}
