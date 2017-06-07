package androidTestCase;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import readingPropertiesFile.ReadConfigProperties;


public class Connectionintialization {
	
	Properties propertiesConfig;
	private static String buildpath;
	private static String appiumpath;
	
	
	
	

public static AndroidDriver<WebElement> dr;
	
	public void connection() throws InterruptedException, IOException

	{
		
		
		propertiesConfig = ReadConfigProperties.ReadConfigPropertiesFile();
		 buildpath =	propertiesConfig.getProperty("buildpath");
		 appiumpath =	propertiesConfig.getProperty("appiumpath");
		
    	DesiredCapabilities c=new DesiredCapabilities();
		c.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		c.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		c.setCapability(MobileCapabilityType.APP, buildpath);
		dr = new AndroidDriver<WebElement>(new URL(appiumpath),c);
		c.setCapability("waitForAppScript", "$.delay(3000);$.acceptAlert()");
		Thread.sleep(3000);
		
	System.out.println("App launched successfully");
	
	}
	
	}

	
	
	

