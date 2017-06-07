package DataBaseConnectivity;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test; 

public class DataBaseConnection implements DataBaseImpDAO {
	
/*public static void main(String args[])*/
	
	private static Connection con;
	private static Statement stmt;
	private static ResultSet rs;
	private  ArrayList<String> al = new ArrayList();
	
	
	private void DataBaseConnectivity(String DataBaseName){  
	try{  
	Class.forName("com.mysql.jdbc.Driver");  
	con=DriverManager.getConnection(  
	/*"jdbc:mysql://localhost:3306/test","root","");  */
	"jdbc:mysql://104.154.183.18:3306/"+DataBaseName,"root","urloopdevadmin");  
	//here sonoo is database name, root is username and password  
	stmt=con.createStatement();  
	}catch(Exception e){ System.out.println("(DataBaseConnection)DataBaseConnectivity"+e);}  
	}
	
	private ArrayList<String> queryExecution(String DBQuery,int ColumnNumber){
		try{
	rs=stmt.executeQuery(DBQuery);  
	
	while(rs.next()){  
		al.add(rs.getString(ColumnNumber));
		System.out.println("Got"+al);
		}
	
	System.out.println("al Values"+al.size());
	
	
	 Iterator<String> itr = al.iterator();
	    while (itr.hasNext()) {
	      String element = itr.next();
	      System.out.print(element + "ZZZZZZ");
	    }

  }
		catch(Exception e){ System.out.println("(DataBaseConnection)queryExecution"+e);}
		return al;
	}
	
	
	private void ConnectionClose(){
		
		try{
		con.close();
		stmt.close();
		rs.close();
		}
		catch(Exception e){ System.out.println("(DataBaseConnection)ConnectionClose"+e);}  
		
		
	}
	
	/*@org.testng.annotations.Test
	public void run(){
		System.out.println("Run");
		DataBaseConnectivity();
		queryExecution();
	}*/
	
	
	public ArrayList<String> getDAO(String DataBaseName,int ColumnNumber,String DBQuery){
		
		ArrayList<String> DAOvalue = new ArrayList();
		
		DataBaseConnectivity(DataBaseName);
		DAOvalue = queryExecution(DBQuery,ColumnNumber);
		
		System.out.println("Doa Value"+DAOvalue);
	return DAOvalue;
	}
	
	
	
	
	}  
	 


