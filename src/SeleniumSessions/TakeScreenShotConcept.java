package SeleniumSessions;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class TakeScreenShotConcept {



	public static void main(String[] args) throws IOException {


		System.setProperty("webdriver.chrome.driver","C:\\Users\\91821\\Downloads\\chrome v-83\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch chrome
		
		driver.manage().window().maximize();// maximize window
		driver.manage().deleteAllCookies();// delete all cookies
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.google.co.in/");
		driver.navigate().refresh();
		
		//take screesnshot and store as a file format
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//now copy the file to desired location using copyFile// method
		FileUtils.copyFile(src,new File("D:\\HSSCM21\\Automation\\src\\SeleniumSessions\\google.png"));
	}

}
