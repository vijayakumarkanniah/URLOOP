package androidTestCase;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import androidTestScripts.Android_LoginTestScripts;
import excelReadWrite.ExcelRead;
import io.appium.java_client.android.AndroidDriver;
import readingPropertiesFile.ReadConfigProperties;
import webTestScripts.LoginTestScripts;

import org.testng.annotations.BeforeTest;


public class Android_Login_page {
	
public static AndroidDriver<WebElement> dr;
public static Connectionintialization conn = new Connectionintialization();




Properties propertiesConfig;
static String excelURL;
static String androidexcelFileName;
static Android_LoginTestScripts android_LoginTestScripts;


public Android_Login_page() throws IOException{
	
 android_LoginTestScripts = new Android_LoginTestScripts();
	
	
	propertiesConfig = ReadConfigProperties.ReadConfigPropertiesFile();
	excelURL =	propertiesConfig.getProperty("ExcelURL");
	androidexcelFileName =	propertiesConfig.getProperty("AndroidExcelFileName");
	
}



@BeforeTest
public void basicConfiguration() throws IOException, InterruptedException{
	
	android_LoginTestScripts.basicConfiguration();
	
}


@Test(priority=1)
public static void Invalidlogin() throws InterruptedException, IOException
{
	Thread.sleep(2000);
	android_LoginTestScripts.Invalidlogin(ExcelRead.readExcelByKeyWord(excelURL,androidexcelFileName,"Login","No userpwd","EmailID"), 
			ExcelRead.readExcelByKeyWord(excelURL,androidexcelFileName,"Login","No userpwd","Password"));
	
	
	
}

public static void onlyusername() throws InterruptedException, IOException
{
	
}










}




