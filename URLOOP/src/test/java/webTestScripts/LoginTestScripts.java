package webTestScripts;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import objectRepositoryReader.ObjectRepositoryStaticReader;
import readingPropertiesFile.ReadConfigProperties;

public class LoginTestScripts {
	

	static WebDriver driver;
	Properties propertiesConfig;
	
	static String loginXmlURL;
	static String excelURL;
	static String excelFileName;
	
	public void basicConfiguration() throws IOException{
		propertiesConfig = ReadConfigProperties.ReadConfigPropertiesFile();
		
		
		
		System.out.println(propertiesConfig.getProperty("URL"));
		
		System.setProperty("webdriver.chrome.driver",propertiesConfig.getProperty("ChromeDriverURL"));
		driver = new ChromeDriver();
		driver.get(propertiesConfig.getProperty("URL"));
		
		loginXmlURL =	propertiesConfig.getProperty("LoginXmlURL");
		excelURL =	propertiesConfig.getProperty("ExcelURL");
		excelFileName =	propertiesConfig.getProperty("ExcelFileName");
		
	}
	
	public void login_Submit(String userName,String password){
		
	driver.findElement(By.xpath(ObjectRepositoryStaticReader.oBjectXmlReader(loginXmlURL,"EmailIdOrPhone","Xpath")))
	.sendKeys(userName);
	
	driver.findElement(By.xpath(ObjectRepositoryStaticReader.oBjectXmlReader(loginXmlURL,"Password","Xpath")))
	.sendKeys(password);
	
	driver.findElement(By.xpath(ObjectRepositoryStaticReader.oBjectXmlReader(loginXmlURL,"LoginButton","Xpath")))
	.click();
	
		
	}

}
