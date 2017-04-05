package webTestCase;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import excelReadWrite.ExcelRead;
import readingPropertiesFile.ReadConfigProperties;
import webTestScripts.LoginTestScripts;

public class LoginTestCases {
	
	Properties propertiesConfig;
	static String excelURL;
	static String excelFileName;
	
	
	LoginTestScripts loginTestScripts;
	
	public LoginTestCases() throws IOException{
		
		loginTestScripts = new LoginTestScripts();
		
		
		propertiesConfig = ReadConfigProperties.ReadConfigPropertiesFile();
		excelURL =	propertiesConfig.getProperty("ExcelURL");
		excelFileName =	propertiesConfig.getProperty("ExcelFileName");
		
	}

	
	@BeforeTest
	public void basicConfiguration() throws IOException{
	
		loginTestScripts.basicConfiguration();
		
	}
	
	@Test
	public void login_Success() throws IOException{
		
		
		System.out.println("EmailID"+ExcelRead.readExcelByKeyWord(excelURL,excelFileName,"People","Invite_Members_Dynamic","EmailID")+"Password"+ExcelRead.readExcelByKeyWord(excelURL,excelFileName,"People","Invite_Members_Dynamic","LastName"));
		
loginTestScripts.login_Submit(ExcelRead.readExcelByKeyWord(excelURL,excelFileName,"People","Invite_Members_Dynamic","EmailID"), 
ExcelRead.readExcelByKeyWord(excelURL,excelFileName,"People","Invite_Members_Dynamic","LastName"));
		
		
	}
	
	
	
	
}
