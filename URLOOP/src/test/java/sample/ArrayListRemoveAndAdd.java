package sample;

import java.util.*;

public class ArrayListRemoveAndAdd {
	public static void main(String args[]){  
		  ArrayList<String> al=new ArrayList<String>();  
		  al.add("Ravi");  
		  al.add("Vijay");  
		  al.add("Ajay");  
		  ArrayList<String> al2=new ArrayList<String>();  
		  al2.add("Ravi");  
		  al2.add("Hanumat");  
		  al.addAll(al2); 
		  al.remove(1);/*We Can use emove All*/
		  al.add(1, "HI");
		  System.out.println("iterating the elements after removing the elements of al2...");  
		  Iterator<String> itr=al.iterator();  
		  while(itr.hasNext()){  
		   System.out.println(itr.next());  
		   
		   
}AddCollection();}
	
	
	public static void AddCollection(){
		
		System.out.println("Welcome To AddCollection");
		
		 ArrayList<String> al=new ArrayList<String>();  
		  al.add("Ravi");  
		  al.add("Vijay");  
		  al.add("Ajay");  
		  ArrayList<String> al2=new ArrayList<String>();  
		  al2.add("Sonoo");  
		  al2.add("Hanumat");  
		  al.addAll(al2);//adding second list in first list  
		  Iterator<String> itr=al.iterator();  
		  while(itr.hasNext()){  
		   System.out.println(itr.next());
	}RetainArrayList();
		  }
	
	public static void RetainArrayList(){
		
		System.out.println("Welcome To RetainArrayList");
		
		 ArrayList<String> al=new ArrayList<String>();  
		  al.add("Ravi");  
		  al.add("Vijay");  
		  al.add("Ajay");  
		  ArrayList<String> al2=new ArrayList<String>();  
		  al2.add("Ravi");  
		  al2.add("Hanumat");  
		  al.retainAll(al2);  
		  System.out.println("iterating the elements after retaining the elements of al2...");  
		  Iterator<String> itr=al.iterator();  
		  while(itr.hasNext()){  
		   System.out.println(itr.next());  
		  }  
	}
	
}


