package webTestCase;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
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
	
	@Test(priority = 2)
	public void Login_Success() throws IOException, InterruptedException{
		
		
		/*System.out.println("EmailID"+ExcelRead.readExcelByKeyWord(excelURL,excelFileName,"People","Invite_Members_Dynamic","EmailID")+"Password"+ExcelRead.readExcelByKeyWord(excelURL,excelFileName,"People","Invite_Members_Dynamic","LastName"));*/
		
loginTestScripts.login_Submit(ExcelRead.readExcelByKeyWord(excelURL,excelFileName,"Login","Login_Success","EmailID"), 
ExcelRead.readExcelByKeyWord(excelURL,excelFileName,"Login","Login_Success","Password"));
		}
	
	@Test(priority = 1)
	public void ForgotPassword() throws IOException, InterruptedException{
		
		
		/*System.out.println("EmailID"+ExcelRead.readExcelByKeyWord(excelURL,excelFileName,"People","Invite_Members_Dynamic","EmailID")+"Password"+ExcelRead.readExcelByKeyWord(excelURL,excelFileName,"People","Invite_Members_Dynamic","LastName"));*/
		
loginTestScripts.forgotPassword(ExcelRead.readExcelByKeyWord(excelURL,excelFileName,"Login","ForgotPassword","EmailID"));
		
}
	
	@AfterMethod
	public void afterMethod(ITestResult result)
	{
	    try
	 {
	    if(result.getStatus() == ITestResult.SUCCESS)
	    {

	        //Do something here
	    	System.out.println("method name:" + result.getMethod().getMethodName());
	        System.out.println("passed **********");
	        excelReadWrite.ExcelWrite.ExcelWriteCell(result.getMethod().getMethodName(),"Result","SUCCESS");
	    }

	    else if(result.getStatus() == ITestResult.FAILURE)
	    {
	         //Do something here
	    	System.out.println("method name:" + result.getMethod().getMethodName());
	        System.out.println("Failed ***********");
	        excelReadWrite.ExcelWrite.ExcelWriteCell(result.getMethod().getMethodName(),"Result","FAILURE");

	    }

	     else if(result.getStatus() == ITestResult.SKIP ){
	    	 System.out.println("method name:" + result.getMethod().getMethodName());
	        System.out.println("Skiped***********");
	        excelReadWrite.ExcelWrite.ExcelWriteCell(result.getMethod().getMethodName(),"Result","SKIP");

	    }
	}
	   catch(Exception e)
	   {
	     e.printStackTrace();
	   }

	}
	
	
	
}
