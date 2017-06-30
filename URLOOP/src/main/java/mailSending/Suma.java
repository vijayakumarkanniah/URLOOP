package mailSending;
import com.way2sms.SMS;

public class Suma {
	public static void main(String[] args) {

		SMS smsClient=new SMS();
		smsClient.send( "VIJAYAKUMAR", "8807803285", "8807803285", "Message","");
		}
}
