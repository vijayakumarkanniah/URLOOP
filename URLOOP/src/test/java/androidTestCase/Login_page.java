package androidTestCase;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeTest;


public class Login_page {
	
public static AndroidDriver<WebElement> dr;
public static Connectionintialization conn = new Connectionintialization();

@BeforeTest
public static void connection() throws InterruptedException, IOException
    	
{
	conn.connection();
}

@Test(priority=1)
public static void correctlogin() throws MalformedURLException, InterruptedException
{
	
	dr.findElement(By.id(""));
	
	
}


}




