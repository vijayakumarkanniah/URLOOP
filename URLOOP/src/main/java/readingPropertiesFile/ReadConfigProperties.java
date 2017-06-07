package readingPropertiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigProperties {

	public static Properties obj;
	
	public static Properties DBSQLobj;
	
	public static Properties ReadConfigPropertiesFile() throws IOException {
		
		obj=new Properties();
		FileInputStream file=new FileInputStream("src\\main\\resources\\Config.Properties");
		obj.load(file);
		return obj;
		
	}
	
	
public static Properties ReadDBSQL(String SqlFileName) throws IOException {
		
	DBSQLobj=new Properties();
		FileInputStream file=new FileInputStream("src\\main\\resources\\SQLQuery\\"+SqlFileName);
		DBSQLobj.load(file);
		return DBSQLobj;
		
	}
	
}
