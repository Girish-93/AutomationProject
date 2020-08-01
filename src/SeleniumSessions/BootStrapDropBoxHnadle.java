package SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropBoxHnadle {

	public static void main(String[] args) {
		
		System.setProperty( "webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91821\\Downloads\\chrome v-83\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch chrome
		
		
		driver.manage().window().maximize();// maximize window
		driver.manage().deleteAllCookies();// delete all cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");//enter url
        
        driver.findElement(By.xpath("//button[@type='button']")).click();
        
        List<WebElement> list =driver.findElements(By.xpath("//ul[contains(@class='multiselect-container dropdown-menu')]//li//a//label"));
        
        System.out.println(list.size());
        
        //selecting all checkboxes/options
        for(int i=0 ; i<list.size() ; i++) {
        	System.out.println(list.get(i).getText());
        	list.get(i).click();
        }
     //Selecting angular options
//        for(int i=0 ; i<list.size() ; i++) {
//        	System.out.println(list.get(i).getText());
//        	if(list.get(i).getText().contains("Angular")){
//        		list.get(i).click();
//        		break;
//        	}
//        }
        

	}

}
