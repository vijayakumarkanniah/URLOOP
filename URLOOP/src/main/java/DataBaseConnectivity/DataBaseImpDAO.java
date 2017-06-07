package DataBaseConnectivity;

import java.util.ArrayList;

public interface DataBaseImpDAO {
	
	ArrayList<String> getDAO(String DataBaseName,int ColumnNumber,String DBQuery);

}
