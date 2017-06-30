package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Chrome {

	static WebDriver driver;
	
	public static void main(String args[]) throws InterruptedException{
		/*//System.setProperty("webdriver.gecko.driver", "C:\\Users\\VIJAY KUMAR\\git\\URLOOP\\URLOOP\\src\\main\\resources\\Browser\\geckodriver.exe");
		
		System.setProperty("webdriver.firefox.marionette","C:\\Users\\VIJAY KUMAR\\git\\URLOOP\\URLOOP\\src\\main\\resources\\Browser\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		DesiredCapabilities capabilities=DesiredCapabilities.firefox();
	    capabilities.setCapability("marionette", true);
	    WebDriver driver = new FirefoxDriver(capabilities);
		
		driver.get("http://www.google.com");*/
		

		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\VIJAY KUMAR\\git\\URLOOP\\URLOOP\\src\\main\\resources\\Browser\\chromedriver.exe");
		driver = new ChromeDriver();
		/*driver.manage().window().maximize();*/
		
		driver.get("https://www.google.co.in/webhp?hl=en&sa=X&ved=0ahUKEwjBguqo0eDUAhUBvY8KHY0NBB4QPAgD");
		Thread.sleep(2000);
		driver.findElement(By.id("lst-ib")).sendKeys("Google");
	}
	
	
}
