package sample;

import java.util.*;



import sample.Student;

public class ClassArrayList {

	
	public static void main(String args[]){  
		  //Creating user-defined class objects  
		  Student s1=new Student(101,"Sonoo",23);  
		  Student s2=new Student(102,"Ravi",21);  
		  Student s3=new Student(103,"Hanumat",25);  
		  //creating arraylist  
		  
		  ArrayList<Student> al=new ArrayList<Student>();  
		  
		  System.out.println("Reached");  
		  
		  al.add(s1);//adding Student class object  
		  al.add(s2);  
		  al.add(s3);  
		  //Getting Iterator  
		  
		  System.out.println("Completed");  
		  
		  Iterator<Student> itr=al.iterator();  
		  //traversing elements of ArrayList object  
		  while(itr.hasNext()){  
		    Student st=itr.next(); 
		    
		        System.out.println(st.rollno+" "+st.name+" "+st.age);  
		  }  
}
}