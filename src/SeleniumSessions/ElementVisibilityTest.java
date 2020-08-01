package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver","C:\\Users\\91821\\Downloads\\chrome v-83\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch chrome
		
		driver.manage().window().maximize();// maximize window
		driver.manage().deleteAllCookies();// delete all cookies
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.crmpro.com/register/");//enter url
		
		//1.isDisplay() method:applicable for all the elements
		boolean b1 = driver.findElement(By.id("submitButton")).isDisplayed();
		System.out.println(b1);//true
		
		//2.isEnabled() method:
		boolean b2 = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(b2);//false
		
		//select I Agree chekbox
		driver.findElement(By.name("agreeTerms")).click();//submit button is enabled now
		boolean b3 = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(b3);//true
		
		//3.isselected() method: is applicable for checkbox,dropdown,radio button,
		boolean b4 = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println(b4);//true
		
		//4.deselect the checkbox
		driver.findElement(By.name("agreeTerms")).click();
		boolean b5 = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println(b5);//false

	}

}
