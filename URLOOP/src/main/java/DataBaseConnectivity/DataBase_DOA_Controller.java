package DataBaseConnectivity;

import java.util.ArrayList;

public class DataBase_DOA_Controller  {

	/*@org.testng.annotations.Test*/
	
	
/*	static String DataBaseName ="urloop-default";
	static int ColumnNumber=1;
	static String DBQuery="SELECT * FROM `urloop-default`.urloop_usermail_verification";
	
	
	public static void main (String args[]){
		ArrayList<String> Delete = DataBase_DOA(DataBaseName,ColumnNumber,DBQuery);
	
	System.out.println("Main Got Value"+Delete.get(2));
	}*/
	
	public static ArrayList<String> DataBase_DOA(String DataBaseName,int ColumnNumber,String DBQuery){
	DataBaseImpDAO d=new DataBaseConnection();
	ArrayList<String> DatabaseObject = d.getDAO(DataBaseName,ColumnNumber,DBQuery);
	return DatabaseObject;
	}
	
}
