package driverConnectivityGlobally;

import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import readingPropertiesFile.ReadConfigProperties;

public class LocalWebDriver {
	
	public static ChromeDriver driver;
	public static WebDriverWait wait;
	static Properties propertiesConfig;
	
	@Test
	public static void chrome() throws IOException{
		
propertiesConfig = ReadConfigProperties.ReadConfigPropertiesFile();
		
		
		
		System.out.println(propertiesConfig.getProperty("URL"));
		
		System.setProperty("webdriver.chrome.driver",propertiesConfig.getProperty("ChromeDriverURL"));
		driver = new ChromeDriver();
		/*driver.manage().window().maximize();*/
		
		driver.get(propertiesConfig.getProperty("URL"));
	}

}
