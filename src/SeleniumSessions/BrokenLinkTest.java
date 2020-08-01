package SeleniumSessions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		
		System.setProperty( "webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91821\\Downloads\\chrome v-83\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch chrome
		
		driver.manage().window().maximize();// maximize window
		driver.manage().deleteAllCookies();// delete all cookies
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.crmpro.com/index.html");//enter url
		
		driver.findElement(By.name("username")).sendKeys("girishsb");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.switchTo().frame("mainpanel");
		
		//links --//a href<http://www.google.com>
		//images--//img href<http://www.test.com>
		
		//1.get the list of all the links and images:500
		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		linkslist.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("size of full links and images---->" +linkslist.size());
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();//450
		
		//2. iterate linklist: exculde all the links and images doesn't have href attribute
		
		for(int i=0 ; i<linkslist.size() ;i++) {
			System.out.println(linkslist.get(i).getAttribute("href"));
			if(linkslist.get(i).getAttribute("href")!=null && (!linkslist.get(i).getAttribute("href").contains("javascript"))) {
				activeLinks.add(linkslist.get(i));
			}
		}
		
		//get the size of links and images:
		System.out.println("size of active links and images---->" +activeLinks.size());
		
		//3.check the href url : with httpconnection api:
		//200 ok
		//404 not found
		//400 bad request
		//500 internal request
		for(int j=0; j<activeLinks.size() ; j++) {
			
	    HttpURLConnection connection = (HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
	    
	    connection.connect();
	    String response = connection.getResponseMessage();//ok
	    connection.disconnect();
	    System.out.println(activeLinks.get(j).getAttribute("href") +"----->"+response);
	    
		}
	}

}
