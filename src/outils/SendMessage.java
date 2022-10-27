/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package outils;

/**
 *
 * @author ahmed
 */
import java.io.IOException;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SendMessage {

     public static final String ACCOUNT_SID = "ACf4766383c3b2f72cfebbb4d17dbd239e";
    public static final String AUTH_TOKEN = "3b6b8c11460b3059d84fb785dfef3a57";
   
    public void apiTwilio(String body, String number) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new PhoneNumber(number),
                new PhoneNumber("+14632384601"),                
                body)
                .create();
        System.out.println("Message sent successfully! "+message.getSid());
    }
}
