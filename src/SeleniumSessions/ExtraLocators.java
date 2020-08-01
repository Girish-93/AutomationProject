package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;

public class ExtraLocators {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91821\\Downloads\\chrome v-83\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch chrome
		
		driver.get("https://www.facebook.com");
//		
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		
//		driver.findElement(new ByAll(By.name("firstname12"),By.id("u_0_m12"),By.xpath("//input[@id='u_0_m']"))).sendKeys("girish");
//		driver.findElement(new ByIdOrName("firstname")).sendKeys("girish");
		
		driver.findElement(new ByChained(By.id("u_0_l"),By.xpath("//div[@class='uiStickyPlaceholderInput uiStickyPlaceholderEmptyInput']"),
				By.name("firstname"))).sendKeys("girish");

	}

}
