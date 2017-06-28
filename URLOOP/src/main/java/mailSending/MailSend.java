package mailSending;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.mail.Multipart;

public class MailSend {
	
	
	
	  
	
	 public static void main(String[] args) {  
	  
	  String host="smtp.gmail.com";  
	  final String user="udemolishing@gmail.com";//change accordingly  
	  final String password="vijayakumar";//change accordingly  
	    
	  String to="vijaykumar.k@tringapps.com";//change accordingly  
	  
	   //Get the session object  
	   Properties props = new Properties();  
	   props.put("mail.smtp.host",host);  
	   props.put("mail.smtp.auth", "true");
	   props.put("mail.smtp.port", "465");
	   props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	   props.put("mail.smtp.socketFactory.port", "465");
	   props.put("mail.smtp.socketFactory.fallback", "false");
	     
	   Session session = Session.getDefaultInstance(props,  
	    new javax.mail.Authenticator() {  
	      protected PasswordAuthentication getPasswordAuthentication() {  
	    return new PasswordAuthentication(user,password);  
	      }  
	    });  
	  
	   //Compose the message  
	    try {  
	     MimeMessage message = new MimeMessage(session);  
	     message.setFrom(new InternetAddress(user));  
	     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
	     /*message.addRecipient(Message.RecipientType.CC, new InternetAddress("syed.r@tringapps.com"));
	     message.addRecipient(Message.RecipientType.BCC, new InternetAddress("syed.r@tringapps.com"));*/
	     message.setSubject("javatpoint");  
	     message.setText("This is simple program of sending email using JavaMail API");  
	     
	     Multipart multipart = new MimeMultipart();
	     
	     /*String filename = "C:\\Users\\VIJAY KUMAR\\git\\URLOOP\\URLOOP\\test-output";
         DataSource source = new FileDataSource(filename);
         message.setDataHandler(new DataHandler(source));
         message.setFileName(filename);*/
          
	       
         BodyPart messageBodyPart = new MimeBodyPart();
         messageBodyPart.setText(
 "<table style='width:100%'><tr><th bgcolor='#bfff00'><img src='https://media.licdn.com/mpr/mpr/shrink_200_200/AAEAAQAAAAAAAAr3AAAAJGUyNWQzYTdmLThmYmEtNGJhOC1hNmEyLWQxNGQ0OGU3Zjk2ZQ.png' alt='Smiley face' height='150' width='150'></th> </tr><tr><td><br><B>Hi,</B></br></tr></td> <tr><td><br><B>Kindly find the attachment of the Excel Data Sheet and the Report of the Numer of Passed and Failed TestCases</B></br></tr></td></tr></table>");
         messageBodyPart.setHeader("content-type", "text/html");
         multipart.addBodyPart(messageBodyPart);
         
         
         messageBodyPart = new MimeBodyPart();
         String filename = "C:\\Users\\VIJAY KUMAR\\git\\URLOOP\\URLOOP\\test-output\\index.html";
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
        
         
         multipart.addBodyPart(messageBodyPart);
         
         
         
         message.setContent(multipart);
	    //send the message  
	     Transport.send(message);  
	  
	     System.out.println("message sent successfully...");  
	   
	     } catch (MessagingException e) {e.printStackTrace();}  
	 }  
	}  


