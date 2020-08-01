package SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBootStrapDropBox {

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty( "webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91821\\Downloads\\chrome v-83\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch chrome
		
		driver.manage().window().maximize();// maximize window
		driver.manage().deleteAllCookies();// delete all cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
        driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");//enter url
        Thread.sleep(2000);
        
        driver.findElement(By.id("dropdownMenuButton")).click();
        
        List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class,'dropdown-menu')]//a"));
        System.out.println(list.size());
        
        for(int i=0; i<list.size(); i++) {
        	System.out.println(list.get(i).getText());
        	if(list.get(i).getText().equals("Another action")) {
        		list.get(i).click();
        		break;
        	}
        }
        
	}

}
