package SeleniumSessions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class JavaScriptExeConcept {


	public static void main(String[] args) throws IOException {
		
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
		driver.findElement(By.name("password")).sendKeys("Test@1234");
		//driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
		

		//executescript-- to execute JavaScript code 
		
		WebElement loginBtn = driver.findElement(By.xpath("//input[contains(@type,'submit')]"));//login button
			
		flash(loginBtn, driver);//highlight the element
		
		drawBorder(loginBtn,driver);//draw border
		
		//Takescreenshot and store it as file formate
		//File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//now copy the file to desired location using copyFile// method
	    //FileUtils.copyFile(src,new File("D:\\HSSCM21\\Automation\\src\\SeleniumSessions\\element.png"));
	    
	  //generateAlert		
	  //generateAlert(driver, "There is an issue with loginbtn in login page");
		
		//click on any element using JavascriptExecutor
		clickElementByJS(loginBtn , driver);
		
		//refresh the page:
		//1.using selenium
		driver.navigate().refresh();
				
		//2.By using JS Executor
		refreshBrowserByJS(driver);
		
		//3.Get the title of the page by JS
        System.out.println(getTitleByJS(driver));
        
        //4.get the page inner text by JS
      	//System.out.println(getPageInnerText(driver));
      	
        //5.scrollpage down
      	//scrollPageDown(driver);
        
        WebElement forgotPwdlink = driver.findElement(By.xpath("//a[contains(text(),'Forgot Password?')]"));
		scrollIntoView(forgotPwdlink , driver);
		
	}
	

		public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String bgcolor = element.getCssValue("backgroundcolor");
		for(int i=0 ; i<10 ; i++) {
			changeColor("rgb(0,200,0)",element,driver);
			changeColor(bgcolor,element,driver);
		}
	}

	    private static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
		
		try {
			Thread.sleep(20);
		}catch(InterruptedException e) {
		}
		
	    }	
		public static void drawBorder(WebElement element, WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].style.border='3px solid red'", element);
		}
		
		public static void generateAlert(WebDriver driver, String message) {
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("alert('"+message+"')");
		}
		
		public static void clickElementByJS(WebElement element,WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].click();", element);
		}
		
		public static void refreshBrowserByJS(WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("history.go(0)");
	    }
		
		public static String getTitleByJS(WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			String title = js.executeScript("return document.title;").toString();
			return title;
	    }
		
		public static String getPageInnerText(WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			String pageText = js.executeScript("return document.documentElement.innerText;").toString();
			return pageText;
	    }
		
		public static void scrollPageDown(WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("window.scrollTo(0,document.body.scrollHieght)");
		}
		
		public static void scrollIntoView(WebElement element, WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].scrollIntoView(true);",element);
	    }
		
	}
