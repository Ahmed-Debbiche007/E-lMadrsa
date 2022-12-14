/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import com.google.common.hash.Hashing;
import entities.User;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author Nour
 */
public class AuthController implements Initializable {

    @FXML
    private Button btnconnecter;
    @FXML
    private Button btnnvcpt;
    @FXML
    private Button btnmdp;
    @FXML
    private TextField tfusername;
    @FXML
    private PasswordField jpswd;
    @FXML
    private CheckBox jcheckb;

    private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;
    @FXML
    private Button btnexit;
    @FXML
    private TextField tjswd;

    Connection cnx;
    PreparedStatement pst;
    ResultSet rs;

    public static User connectedUser;

    @FXML
    public void show(ActionEvent event) {

        if (jcheckb.isSelected()) {
            tjswd.setText(jpswd.getText());
            tjswd.setVisible(true);
            jpswd.setVisible(false);
            return;
        } else {
            jpswd.setText(tjswd.getText());
            jpswd.setVisible(true);
            tjswd.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")

    @FXML
    public void exit() {
        System.exit(0);
    }

    @FXML
    public void logine(ActionEvent event) throws IOException {
        login();

    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void mdp(ActionEvent event) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getResource("mdpoublie.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void log(KeyEvent event) throws IOException {
        if (event.getCode().toString().equals("ENTER")) {
            login();
        }
    }

    private void login() throws IOException {
        String nomUtilisateur = tfusername.getText();
        String motDePasse = jpswd.getText();
        String hashPass = Hashing.sha256().hashString(motDePasse, StandardCharsets.UTF_8).toString();

        if (nomUtilisateur.equals("") && motDePasse.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter your Username and Password ");
        } else {
            UtilisateurService su = new UtilisateurService();
            User u = su.getByUserName(nomUtilisateur);
            if (!hashPass.equals(u.getMotDePasse())) {
                JOptionPane.showMessageDialog(null, "Wrong Username/Password! ");
                tfusername.setText("");
                jpswd.setText("");
                tfusername.requestFocus();
            }
            if (!u.isApproved()) {
                JOptionPane.showMessageDialog(null, "Why Rushing, boiii?");
                tfusername.setText("");
                jpswd.setText("");
                tfusername.requestFocus();
            } else {
                connectedUser = u;
                JOptionPane.showMessageDialog(null, "Successfully Login!");
                System.out.println(u.getRole().name());
                Stage stage;
                Parent root;
                if (u.getRole().name().equals("Admin")) {
                    root = FXMLLoader.load(getClass().getResource("nexte.fxml"));
                } else if (u.getRole().name().equals("Tutor")) {
                    root = FXMLLoader.load(getClass().getResource("../GUI/mainuiiistudent.fxml"));
                } else {
                    root = FXMLLoader.load(getClass().getResource("../GUI/mainuiiistudent.fxml"));
                }

                stage = (Stage) tfusername.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
    }

}
