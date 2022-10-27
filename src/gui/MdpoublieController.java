/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Recup;
import entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import outils.MailValidator;
import outils.SendMail;
import services.RecupService;
import services.UtilisateurService;
import static gui.AuthController.connectedUser;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class MdpoublieController implements Initializable {

    @FXML
    private TextField tftxt;
    @FXML
    private Button btnenvoyer;
    @FXML
    private Button btnannuler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void sendMail(ActionEvent event) throws IOException {
        String mail = tftxt.getText();
        UtilisateurService us = new UtilisateurService();
        User u = us.getByMail(mail);
        MailValidator m = new MailValidator();
        if (!m.validationEmail(mail)) {

            tftxt.setText("");
        } else if (u == null) {
            JOptionPane.showMessageDialog(null, "Email does not exist");
            tftxt.setText("");
        } else {
            connectedUser =u;
            Recup recup = new Recup(u.getId());
            System.out.println(recup.getCode());
            RecupService ur = new RecupService();
            SendMail x = new SendMail();
            String subject = "Reset Password";
            String body = "Votre code de réinstallation de mot de passe est: " +recup.getCode() ;
            x.send(subject, body, mail);
            ur.ajouter(recup);
            Stage stage;
            Parent root = FXMLLoader.load(getClass().getResource("code.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);

            stage.setScene(scene);

            stage.show();
        }
    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getResource("auth.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.show();

    }

}
