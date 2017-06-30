package dependency;

import java.io.IOException;

import androidTestCase.Android_Login_page;
import androidTestScripts.Android_LoginTestScripts;
import webTestCase.LoginTestCases;

public class Login_Web_Android {
	
	public static void main(String args[]) throws IOException, InterruptedException{
		
		/*Web*/
		
		LoginTestCases logintestcases = new LoginTestCases();
		logintestcases.basicConfiguration();
		logintestcases.ForgotPassword();
		
		
		/*Android*/
		
		Android_Login_page android_login_page = new Android_Login_page();
		android_login_page.basicConfiguration();
		Android_Login_page.Invalidlogin();
		
		
		logintestcases.Login_Success();
		
		
		
	}

}
