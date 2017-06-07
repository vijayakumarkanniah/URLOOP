package webTestScripts;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepositoryReader.ObjectRepositoryStaticReader;
import readingPropertiesFile.ReadConfigProperties;

public class ServiceTestScripts {
	

	static WebDriver driver;
	static WebDriverWait wait;
	Properties propertiesConfig;
	
	static String loginXmlURL;
	static String excelURL;
	static String excelFileName;
	
	
	public void basicConfiguration() throws IOException,InterruptedException{
		propertiesConfig = ReadConfigProperties.ReadConfigPropertiesFile();
		
		
		
		System.out.println(propertiesConfig.getProperty("URL"));
		
		System.setProperty("webdriver.chrome.driver",propertiesConfig.getProperty("ChromeDriverURL"));
		driver = new ChromeDriver();
		/*driver.manage().window().maximize();*/
		 
		driver.get(propertiesConfig.getProperty("URL"));
		
		loginXmlURL =	propertiesConfig.getProperty("LoginXmlURL");
		excelURL =	propertiesConfig.getProperty("ExcelURL");
		excelFileName =	propertiesConfig.getProperty("ExcelFileName");
		
	}
	
	
	
	
	
	
	
	
	public  void login_Submit(String userName,String password) throws InterruptedException{
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath(ObjectRepositoryStaticReader.oBjectXmlReader(loginXmlURL,"EmailIdOrPhone","Xpath")))
	.sendKeys(userName);
		
	Thread.sleep(2000);
		
		driver.findElement(By.xpath(ObjectRepositoryStaticReader.oBjectXmlReader(loginXmlURL,"Password","Xpath")))
	.sendKeys(password);
		
	Thread.sleep(2000);
	
		driver.findElement(By.xpath(ObjectRepositoryStaticReader.oBjectXmlReader(loginXmlURL,"Submit","Xpath")))
	.click();
		
		Thread.sleep(2000);
	try{	
		
		if(driver.findElement(By.xpath(".//*[@class='spinner-icon']")).isEnabled()){
			/*.//*[@id='loading-bar-spinner']
*/			
			while(driver.findElement(By.xpath(".//*[@class='spinner-icon']")).isEnabled()){
				Thread.sleep(2000);
				System.out.println("Inside");
			}
			
		}
		
		else{
			System.out.println("else");
			
		} }
	catch(NoSuchElementException e) {
		System.out.println("NoSuchElementException"+e);
		
	}
		
		
		
		
		/*Thread.sleep(10000);*/
	driver.findElement(By.xpath(".//*[@id='side-menu']/li[4]/a/span[text()='Services']")).click();
		
	/*	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(".//*[@id='side-menu']/li[4]/a/span[text()='Services']")))).click();*/
		Thread.sleep(5000);
		
		Actions actions = new Actions(driver);
		
		WebElement subMenu = driver.findElement(By.xpath(".//*[@id='services']/div[2]/div/div/div[2]/div/div[1]/a/div/img"));
		actions.moveToElement(subMenu).build().perform();
		
		driver.findElement(By.xpath(".//*[@id='services']/div[2]/div/div/div[2]/div/div[1]/a/div/div")).click();
		
		
	//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='side-menu']/li[4]/a/span[text()='Services']"))).click();
	}
	
	/*public void  delete () throws InterruptedException{
		
		if((driver.findElement(By.xpath(".//*[@id='side-menu']/li[4]/a/span[text()='Services']")).isEnabled())){
			Thread.sleep(2000);}else{delete();}}*/

}
