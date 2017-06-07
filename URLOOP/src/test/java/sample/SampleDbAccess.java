package sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.testng.annotations.Test;

import DataBaseConnectivity.DataBase_DOA_Controller;
import readingPropertiesFile.ReadConfigProperties;

public class SampleDbAccess {

	static Properties propertiesSqlQuery;
	
	static String DataBaseName ="urloop-default";
	static int ColumnNumber=1;
	static String DBQuery="SELECT * FROM `urloop-default`.urloop_usermail_verification";
	static String excelURL;
	
	
	@Test
	public static void hello() throws IOException{
	/*public static void main (String args[])*/
		
		propertiesSqlQuery = ReadConfigProperties.ReadDBSQL("ServicesQuery");
		 excelURL =	propertiesSqlQuery.getProperty("ExcelURL");
		
		
		ArrayList<String> Delete = DataBase_DOA_Controller.DataBase_DOA(DataBaseName,ColumnNumber,excelURL);
	
	System.out.println("Main Got Value"+Delete.get(2));
	}
	
}
