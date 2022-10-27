/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.User;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.UtilisateurService;
import com.google.common.hash.Hashing;
import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import outils.MailValidator;

/**
 * FXML Controller class
 *
 * @author Nour
 */
public class InscriptionController implements Initializable {

    @FXML
    private TextField tfNomm;
    @FXML
    private TextField tfPrenomm;
    @FXML
    private TextField tfNomUtilisateurr;
    @FXML
    private TextField tftlf;
    @FXML
    private TextField tfemaill;
    @FXML
    private TextField tfmotdepassee;
    
    @FXML
    private DatePicker tfdatenaissancee;
    @FXML
    private Button btninscription;
    @FXML
    private Button btnretour;

    private ResultSet result;

    @FXML
    private ComboBox<String> tfrolee;

    ObservableList typeChoices = FXCollections.observableArrayList("Student", "Tutor");
    String img;

    @FXML
    public void signup(ActionEvent event) throws SQLException, ParseException, IOException {
        MailValidator m = new MailValidator();
        UtilisateurService us = new UtilisateurService();
        

        if (tfNomm.getText().isEmpty() | tfPrenomm.getText().isEmpty() | tfNomUtilisateurr.getText().isEmpty() | tfrolee.getValue().isEmpty() | tftlf.getText().isEmpty() | tfemaill.getText().isEmpty() | tfmotdepassee.getText().isEmpty()) {
            Alert alertt = new Alert(AlertType.ERROR);
            alertt.setTitle("Error Message");
            alertt.setHeaderText(null);
            alertt.setContentText("Enter all your informations!");
        } else if (tfmotdepassee.getText().length() < 8) {
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("Error Message");
            alerta.setHeaderText(null);
            alerta.setContentText("Invalid Password!");
            alerta.showAndWait();

        } else if (!m.validationEmail(tfemaill.getText())) {
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setTitle("Error Message");
            alerta.setHeaderText(null);
            alerta.setContentText("Invalid Email!");
            alerta.showAndWait();
        } else if (us.usernameExists(tfNomUtilisateurr.getText())) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error Message");
            alerta.setHeaderText(null);
            alerta.setContentText("Username Exists!");
            alerta.showAndWait();
        } else if (us.getByMail(tfemaill.getText()) != null) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error Message");
            alerta.setHeaderText(null);
            alerta.setContentText("Email Exists!");
            alerta.showAndWait();
        } else {

            String hashPass = Hashing.sha256().hashString(tfmotdepassee.getText(), StandardCharsets.UTF_8).toString();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dateStr = df.parse(tfdatenaissancee.getValue().toString());
            java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());

            User u = new User(tfNomm.getText(), tfPrenomm.getText(), tfNomUtilisateurr.getText(), tftlf.getText(), tfemaill.getText(), hashPass, (Date) dateDB, img, tfrolee.getValue(), false);

            us.ajouter(u);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sign up Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully create new account!");
            alert.showAndWait();

            Stage stage;
            Parent root = FXMLLoader.load(getClass().getResource("auth.fxml"));
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tfrolee.getItems().setAll(typeChoices);
    }

    @FXML
    private void ajouterimage(ActionEvent event) throws IOException {
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Choose image");
        Window ownerWindow = null;
        File file = filechooser.showOpenDialog(ownerWindow);
        String command = "cp "+file.getAbsolutePath()+" "+System.getProperty("user.dir")+"/src/images/"+file.getName();
        Process process = Runtime.getRuntime().exec(command);
        
        img= file.getName();
    }

}
