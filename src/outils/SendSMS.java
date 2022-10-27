/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package outils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
/**
 *
 * @author ahmed
 */
public class SendSMS {
    public static final String ACCOUNT_SID = "ACf4766383c3b2f72cfebbb4d17dbd239e";
    public static final String AUTH_TOKEN = "3eea56202231c29faf6f1e0d83d1f70d";

    public SendSMS() {
    }
    
   
    public void apiTwilio(String body) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new PhoneNumber("+21623526238"),
                new PhoneNumber("+14632384601"),                
                body)
                .create();
        System.out.println("Message sent successfully! "+message.getSid());
    }
    
}
