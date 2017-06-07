package sample;
import java.util.*;  

public class Map {

	
	
	 
	public static void main(String[] args) {  
	    HashMap map=new HashMap();  
	    //Adding elements to map  
	    map.put(1,"Amit");  
	    map.put(5,"Rahul");  
	    map.put(2,"Jai");  
	    map.put(6,"Amit");  
	    //Traversing Map  
	    Set set=map.entrySet();//Converting to Set so that we can traverse  
	    Iterator itr=set.iterator();  
	    while(itr.hasNext()){  
	        //Converting to Map.Entry so that we can get key and value separately  
	        /*Object entry=map.entrySet().itr.next();  
	        System.out.println(entry.getKey()+" "+entry.getValue());  */
	    }  
	}  
	 
	
	
	
}
