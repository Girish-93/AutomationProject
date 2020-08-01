package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalenderSelectTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty( "webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\91821\\Downloads\\chrome v-83\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// launch chrome
		
		
		driver.manage().window().maximize();// maximize window
		driver.manage().deleteAllCookies();// delete all cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
        driver.get("https://www.crmpro.com");//enter url
		
		driver.findElement(By.name("username")).sendKeys("girishsb");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();//login button
		
		driver.switchTo().frame("mainpanel");
		
		String date = "18-September-2017";
		String dateArr[] = date.split("-");//(18-September-2017)
		String day = dateArr[0]; 
		String month = dateArr[1]; 
		String year = dateArr[2];
		
		Select select = new Select(driver.findElement(By.name("slctMonth")));
		select.selectByVisibleText(month);
		
		Select select1 = new Select(driver.findElement(By.name("slctYear")));
		select.selectByVisibleText(year);
		
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
		//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[6]
		
		String beforexpath = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterxpath = "]/td[";
		
		final int totalWeekDays = 7;
		
		//2-1 2-2 2-3 2-4 2-5 2-6 2-7
		//3-1 3-2 3-3 3-4 3-5 3-6 3-7
		boolean flag = false;
		String dayval = null;
		for(int rowNum=2; rowNum<=7; rowNum++){
			
			for(int colNum=1 ; colNum<=totalWeekDays; colNum++) {
			try {	
			String dayval1 = driver.findElement(By.xpath(beforexpath+rowNum+afterxpath+colNum+"]")).getText();
			}catch(NoSuchElementException e) {
				System.out.println("please enter correct data value");
				flag = false;
				break;
			}
			
			
			System.out.println(dayval);
			if(dayval.equals(day)) {
				driver.findElement(By.xpath(beforexpath+rowNum+afterxpath+colNum+"]")).click();
				flag = true;
				break;
			}
				
			}
			
			if(flag) {
				break;
			}
		}
		    
	}

}
