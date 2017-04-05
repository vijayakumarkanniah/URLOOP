package webTestCase;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import excelReadWrite.ExcelRead;
import objectRepositoryReader.ObjectRepositoryStaticReader;
import readingPropertiesFile.ReadConfigProperties;

public class SampleDelete {
	
	static WebDriver driver;
	Properties propertiesConfig;
	
	static String sampleXmlURL;
	static String ExcelURL;
	static String ExcelFileName;
	
	@BeforeTest
	public void basicConfiguration() throws IOException{
		propertiesConfig = ReadConfigProperties.ReadConfigPropertiesFile();
		
		
		
		System.out.println(propertiesConfig.getProperty("URL"));
		
		System.setProperty("webdriver.chrome.driver",propertiesConfig.getProperty("ChromeDriverURL"));
		driver = new ChromeDriver();
		driver.get(propertiesConfig.getProperty("URL"));
		
		sampleXmlURL =	propertiesConfig.getProperty("SampleXmlURL");
		ExcelURL =	propertiesConfig.getProperty("ExcelURL");
		ExcelFileName =	propertiesConfig.getProperty("ExcelFileName");
		
	}
	
	@Test
	public void sample() throws IOException{
	
		
		
		
	String hello =	ObjectRepositoryStaticReader.oBjectXmlReader(sampleXmlURL,"EmailID","Xpath");
		
	
	System.out.println("Valueis"+hello);
	
driver.findElement(By.xpath(ObjectRepositoryStaticReader.oBjectXmlReader(sampleXmlURL,"EmailID","Xpath")))
.sendKeys(ExcelRead.readExcelByKeyWord(ExcelURL,ExcelFileName,"People","Invite_Members_Dynamic","EmailID"));
		
		
		
}
	
	public void emailValidation(){
		
		
	
		
	}

}
