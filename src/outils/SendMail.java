/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package outils;

import java.security.Security;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ahmed
 */
public class SendMail {

    public SendMail() {
    }
    
    public void send (String subject, String body, String mail){
        String username = "springforfever@gmail.com";
        String password = "kmcovmkdwmxwscsz";
        Properties props = new Properties();
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

//props.put("mail.smtp.starttls.enable", true); 
        props.put("mail.smtp.ssl.enable", true);
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        //props.put("mail.smtp.starttls.required", true);

        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");

        //props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.setProperty("mail.debug", "true");

        props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.starttls.enable", "true");
        /*
		props.setProperty("mail.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
		"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.quitwait", "false");
         */
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Address a = new InternetAddress("springforfever@gmail.com");

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("springforfever@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
            //transport.send(message);transport.connect(mailServer, port, username, password);
            // transport.sendMessage(message, message.getAllRecipients());

        } catch (MessagingException mex) {
            System.out.println("send failed, exception: " + mex.getMessage());
        }
    };
    
}
