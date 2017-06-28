package webTestScripts;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverConnectivityGlobally.LocalWebDriver;
import objectRepositoryReader.ObjectRepositoryStaticReader;
import readingPropertiesFile.ReadConfigProperties;

public class LoginTestScripts {
	

	/*static WebDriver driver;
	static WebDriverWait wait;*/
	Properties propertiesConfig;
	
	static String loginXmlURL;
	static String excelURL;
	static String excelFileName;
	
	public void basicConfiguration() throws IOException{
		propertiesConfig = ReadConfigProperties.ReadConfigPropertiesFile();
		
		
		
		/*System.out.println(propertiesConfig.getProperty("URL"));*/
		
		/*System.setProperty("webdriver.chrome.driver",propertiesConfig.getProperty("ChromeDriverURL"));
		driver = new ChromeDriver();*/
		/*driver.manage().window().maximize();*/
		
		/*driver.get(propertiesConfig.getProperty("URL"));*/
		
		LocalWebDriver.chrome();
		
		loginXmlURL =	propertiesConfig.getProperty("LoginXmlURL");
		excelURL =	propertiesConfig.getProperty("ExcelURL");
		excelFileName =	propertiesConfig.getProperty("ExcelFileName");
		
	}
	
	public void login_Submit(String userName,String password) throws InterruptedException{
		
		Thread.sleep(10000);
		
		LocalWebDriver.driver.findElement(By.xpath(ObjectRepositoryStaticReader.oBjectXmlReader(loginXmlURL,"EmailIdOrPhone","Xpath")))
	.sendKeys(userName);
		
	Thread.sleep(2000);
		
	LocalWebDriver.driver.findElement(By.xpath(ObjectRepositoryStaticReader.oBjectXmlReader(loginXmlURL,"Password","Xpath")))
	.sendKeys(password);
		
	Thread.sleep(2000);
	
	/*LocalWebDriver.driver.findElement(By.xpath(ObjectRepositoryStaticReader.oBjectXmlReader(loginXmlURL,"Submit","Xpath")))
	.click();*/
	LocalWebDriver.driver.findElement(By.xpath("dcrcrcrcrc")).click();
	
	}
	
	public void forgotPassword(String eMailID) throws InterruptedException{
		
		Thread.sleep(2000);
		
		LocalWebDriver.driver.findElement(By.xpath(ObjectRepositoryStaticReader.oBjectXmlReader(loginXmlURL,"ForgotPassword","Xpath")))
		.click();
		
		Thread.sleep(2000);
		
		LocalWebDriver.driver.findElement(By.xpath(ObjectRepositoryStaticReader.oBjectXmlReader(loginXmlURL,"ForgotPasswordEmailID","Xpath")))
		.sendKeys(eMailID);
		
		Thread.sleep(2000);
		
		LocalWebDriver.driver.findElement(By.xpath(ObjectRepositoryStaticReader.oBjectXmlReader(loginXmlURL,"Submit","Xpath")))
		.click();
		}


}
