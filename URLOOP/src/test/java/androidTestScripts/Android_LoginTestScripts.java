package androidTestScripts;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import androidTestCase.Connectionintialization;
import io.appium.java_client.android.AndroidDriver;
import objectRepositoryReader.ObjectRepositoryStaticReader;
import readingPropertiesFile.ReadConfigProperties;

public class Android_LoginTestScripts {
	
	Properties propertiesConfig;
	
	static String AndroidloginXmlURL;
	static String excelURL;
	static String excelFileName;
	
	
	/*public static AndroidDriver<WebElement> dr;*/
	public static Connectionintialization conn = new Connectionintialization();
	
	public void basicConfiguration() throws IOException, InterruptedException{
		propertiesConfig = ReadConfigProperties.ReadConfigPropertiesFile();
				
		AndroidloginXmlURL =	propertiesConfig.getProperty("AndroidLoginXmlURL");
		excelURL =	propertiesConfig.getProperty("ExcelURL");
		excelFileName =	propertiesConfig.getProperty("ExcelFileName");
			
		conn.connection();
		
	}
	
public void Invalidlogin(String userName,String password) throws InterruptedException{
	
	conn.dr.findElement(By.id(ObjectRepositoryStaticReader.oBjectXmlReader(AndroidloginXmlURL,"Username","Id")))
	.sendKeys(userName);
	conn.dr.findElement(By.id(ObjectRepositoryStaticReader.oBjectXmlReader(AndroidloginXmlURL,"Password","Id")))
	.sendKeys(password);
	conn.dr.hideKeyboard();
	conn.dr.findElement(By.name(ObjectRepositoryStaticReader.oBjectXmlReader(AndroidloginXmlURL,"SignIn","Text")))
	.click();
	Thread.sleep(2000);
	if(conn.dr.findElement(By.id(ObjectRepositoryStaticReader.oBjectXmlReader(AndroidloginXmlURL,"Errormessage","Id"))).isDisplayed()==true)
	{
	
		System.out.println("Alert message displayed");
		
		String Text = conn.dr.findElement(By.id(ObjectRepositoryStaticReader.oBjectXmlReader(AndroidloginXmlURL,"Errormessage","Id"))).getText();
		
		System.out.println("Text IS :"+Text);
		
		if(Text.trim().equals("Please enter a valid credentials and try again")
				){
			System.out.println("Text are same");
			}
		else
		{
			System.out.println("Text are not same");
		}
	}
	
	else
	{
		
		System.out.println("Alert message not displayed");
		
	}
		
	}
	

}
