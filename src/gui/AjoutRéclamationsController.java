/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Examen;
import entities.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.security.Security;
 import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.controlsfx.control.Notifications;
import outils.SendSMS;
import services.ExamenService;
import services.ReclamationServices;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author Msi
 */
public class AjoutRéclamationsController implements Initializable {

    @FXML
    private TextArea tfDescription;
    @FXML
    private TextField tfSujet;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void EnvoyerReclamation(ActionEvent event) {
        
        
        
        
        
        ReclamationServices RS = new ReclamationServices() ;
        RS.ajouter(new Reclamation(tfSujet.getText(),tfDescription.getText() , new Date()));
                                        Notifications.create()
                    .darkStyle()
                    .position(Pos.CENTER)
                    .text("reclamation ajouté avec succée")
                    .title("reclamation Title").showInformation();
                                        
     // send mail about réclamation : made by aymen 
     
     
                                String username = "contact.springfever@gmail.com";
                                String password = "pbxdvrioecrocjyv";
                                Properties props = new Properties();
                                Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                                props.put("mail.smtp.port", "465");
                                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                                props.put("mail.smtp.ssl.enable", true); 
                                props.put("mail.smtp.ssl.protocols", "TLSv1.2");
                                props.put("mail.smtp.socketFactory.port", "465");
                                props.put("mail.smtp.socketFactory.fallback", "false");
                                props.put("mail.smtp.host", "smtp.gmail.com");
                                props.put("mail.smtp.auth", "true");
                                props.setProperty("mail.debug", "true");
                                props.setProperty("mail.transport.protocol", "smtp");
                                props.put("mail.smtp.starttls.enable", "true"); 
                                Session session = Session.getInstance(props, new javax.mail.Authenticator() {

                                    protected PasswordAuthentication getPasswordAuthentication() {
                                        return new PasswordAuthentication(username, password);
                                    }
                                });

                                try {
                                    Address a = new InternetAddress("contact.springfever@gmail.com");
      
                                    Message message = new MimeMessage(session);
                                    message.setFrom(new InternetAddress("contact.springfever@gmail.com"));
        
                                     
                                    
                                    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("springforfever@gmail.com") );
                                    message.setSubject(tfSujet.getText());
                                    message.setText(tfDescription.getText() );
                                    Transport.send(message);
                                    SendSMS m = new SendSMS();
                                    m.apiTwilio(tfSujet.getText()+": "+tfDescription.getText());

                                } catch (MessagingException mex) {
                                    System.out.println("send failed, exception: " + mex.getMessage());
                                }

     
                                        
                                        
                                        
    }

    @FXML
    private void backToMainon(ActionEvent event) throws IOException {
                    Stage stage ;
    Parent root = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    Scene scene=new Scene(root);
    stage.setScene(scene);
    stage.show();
 

    }
    
}
