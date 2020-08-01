package SeleniumSessions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropFile {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("D:\\HSSCM21\\Automation\\src\\SeleniumSessions\\config.properties");
		
		prop.load(ip);
		
		System.out.println(prop.getProperty("name"));
		
		System.out.println(prop.getProperty("age"));
		
		String url = prop.getProperty("URL");
		
		System.out.println(url);
		
		String browsername = prop.getProperty("browser");
		
		System.out.println(browsername);
		

		if(browsername.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\91821\\Downloads\\chrome v-83\\chromedriver_win32 (1)\\chromedriver.exe");
		    driver = new ChromeDriver();// launch chrome
		}
		else if(browsername.equals("FF")){
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
			 driver = new FirefoxDriver();
		}

		driver.get(url);
		
		driver.findElement(By.xpath(prop.getProperty("firstname_xpath"))).sendKeys(prop.getProperty("firstname"));
		
		driver.findElement(By.xpath(prop.getProperty("surename_xpath"))).sendKeys(prop.getProperty("surename"));
		
		driver.findElement(By.xpath(prop.getProperty("mobilenum_xpath"))).sendKeys(prop.getProperty("mobilenum"));
		
		
		
	}

}
