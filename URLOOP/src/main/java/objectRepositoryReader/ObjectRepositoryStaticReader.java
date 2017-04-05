package objectRepositoryReader;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;



import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class ObjectRepositoryStaticReader {

/*	static String ByAttributrName = "studentr";
	static String ByTagName = "marks";*/
	static String returnFromXml;
	
	/*@Test(priority=1)*/
	public static String  oBjectXmlReader(String Filepath,String ByAttributrName,String ByTagName){
	
/*	public static void main(String[] args){*/

		
	      try {	
	         File inputFile = new File(Filepath);
	         DocumentBuilderFactory dbFactory 
	            = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         System.out.println("Root element :" 
	            + doc.getDocumentElement().getNodeName());
	         NodeList nList = doc.getElementsByTagName(ByAttributrName);
	         System.out.println("----------------------------");
	         
	         
	         
	         
	         
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	            Node nNode = nList.item(temp);
	            System.out.println(nList.getLength());
	            /*System.out.println("\nCurrent Element :" 
	               + nNode.getNodeName());*/
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element eElement = (Element) nNode;
	              /* System.out.println("Student roll no : " 
	                  + eElement.getstatic String ByTagName = "studentw";("rollno"));*/
	               System.out.println("First Name : " 
	                  + eElement
	                  .getElementsByTagName(ByTagName)
	                  .item(0)
	                  .getTextContent());
	               
	            returnFromXml =  eElement
	                  .getElementsByTagName(ByTagName)
	                  .item(0)
	                  .getTextContent().toString();
	               
	            System.out.println("NonStatic"+returnFromXml);
	            
	            
	            
	               
	              /* System.out.println("Last Name : " 
	               + eElement
	                  .getElementsByTagName("lastname")
	                  .item(0)
	                  .getTextContent());
	               System.out.println("Nick Name : " 
	               + eElement
	                  .getElementsByTagName("nickname")
	                  .item(0)
	                  .getTextContent());
	               System.out.println("Marks : " 
	               + eElement
	                  .getElementsByTagName("marks")
	                  .item(0)
	                  .getTextContent());*/
	            }
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.out.println("NonStatic");
	      }
	      return returnFromXml;
	   }
	
}
