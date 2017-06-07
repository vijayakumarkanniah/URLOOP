package webTestCase;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import excelReadWrite.ExcelRead;
import readingPropertiesFile.ReadConfigProperties;
import webTestScripts.LoginTestScripts;
import webTestScripts.ServiceTestScripts;

public class ServiceTestCase {
	
	
	Properties propertiesConfig;
	static String excelURL;
	static String excelFileName;
	
	ServiceTestScripts serviceTestScripts;
	
	public ServiceTestCase() throws IOException{
		
		serviceTestScripts = new ServiceTestScripts();
		
		
		propertiesConfig = ReadConfigProperties.ReadConfigPropertiesFile();
		excelURL =	propertiesConfig.getProperty("ExcelURL");
		excelFileName =	propertiesConfig.getProperty("ExcelFileName");
	}
	
	@BeforeTest
	public void basicConfiguration() throws IOException, InterruptedException{
	
		serviceTestScripts.basicConfiguration();
		
	}
	
	@Test(priority = 1)
	public void login() throws InterruptedException, IOException{
		
		serviceTestScripts.login_Submit(ExcelRead.readExcelByKeyWord(excelURL,excelFileName,"Login","Login_Success","EmailID"), 
				ExcelRead.readExcelByKeyWord(excelURL,excelFileName,"Login","Login_Success","Password"));
		
		
		
	}

}
