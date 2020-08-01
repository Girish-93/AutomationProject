package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		//1.FF browser
		//geckodriver
		//  \\c:users\\download\\geckodriver.exe--for windows
		System.setProperty("webdriver.gecko.driver","D:\\HSSCM21\\Automation\\Drivers\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");		
		WebDriver driver = new FirefoxDriver();
		
		
		// 2.Chrome Broswer
		
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\91821\\Downloads\\chrome v-83\\chromedriver_win32 (1)\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();// launch chrome
		driver.get("https://www.google.com");// enter Url
		
		driver.manage().window().maximize();// maximize window
		driver.manage().deleteAllCookies();// delete all cookies
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String title = driver.getTitle();// get title
		System.out.println(title);
		
		//validation point
		if(title.equals("Google")) {
			System.out.println("correct title");
		}else {
			System.out.println("Incorrect title");
		}
		
		System.out.println(driver.getCurrentUrl());
		
		//System.out.println(driver.getPageSource());
		
		driver.close();

	}

}
