package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;


public class SelectCalendarByJs {

	public static void main(String[] args) {
		
		System.setProperty( "webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91821\\Downloads\\chrome v-83\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch chrome
		
		
		driver.manage().window().maximize();// maximize window
		driver.manage().deleteAllCookies();// delete all cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
        driver.get("https://www.spicejet.com/");//enter url
        
        WebElement date = driver.findElement(By.id("ctl00_mainContent_view_date1"));
        String dateVal = "01/05/2020";
        
        SelectDateByJs(driver,date,dateVal);

	}

	public static void SelectDateByJs(WebDriver driver , WebElement element,String dateVal) {
		JavaScriptExecutor js=((JavaScriptExecutor)driver);
		((RemoteWebDriver) js).executeScript("arguments[0].setAttribute('value','"+dateVal+"');",element);
	}
}
