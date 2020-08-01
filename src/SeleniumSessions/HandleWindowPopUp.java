package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopUp {
	
	//1.alert --Javascript Popup--Alert API(accept.dismiss)
	//2.File Upload Popup --browse buttuon(type = file ,sendkeys(path)
	//3.Browser window popup--Advertisment popup(WindowHandler API-getwindowHandles() ) 

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91821\\Downloads\\chrome v-83\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch chrome
		driver.get("http://popuptest.com/goodpopups.html");
		
		driver.findElement(By.xpath("//a[@class='black']")).click();
		
		Set<String> handler = driver.getWindowHandles();
		
		Iterator<String> it = handler.iterator();
		
		String parentWindowid = it.next();
		System.out.println("parent window id: "+ parentWindowid);
		
		String childWindowid = it.next();
		System.out.println("child window id: "+ childWindowid);
		
		driver.switchTo().window(childWindowid);
		
		Thread.sleep(2000);
		
		System.out.println("child window popup title"+driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(parentWindowid);
		
		Thread.sleep(2000);
		
		System.out.println("parent window title"+driver.getTitle());
		
		driver.close();
		
		

	}

}
