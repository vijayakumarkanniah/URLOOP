package androidTestCase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Login_page {
	
    public static AndroidDriver<WebElement> dr;
	
	@Test
	public void init() throws InterruptedException, MalformedURLException
	{
    	DesiredCapabilities c=new DesiredCapabilities();
		c.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		c.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		c.setCapability(MobileCapabilityType.APP, "C:/Users/ADMIN/Desktop/UrLoop/app-resident-debug.apk");
		//c.setCapability(MobileCapabilityType.OVERLAPPING_CHECK_DISABLED, "true");
		//c.setCapability("waitForAppScript", "if (target.frontMostApp().alert().name()=='"Appname" Would Like to Send You Notifications') {$.acceptAlert(); true;}");
		dr = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),c);
		c.setCapability("waitForAppScript", "$.delay(3000);$.acceptAlert()");
		Thread.sleep(3000);
		
	System.out.println("App launched successfully");
	
	}
	

}


