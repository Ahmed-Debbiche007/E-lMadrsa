/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Reclamation;
import java.io.IOException;
import java.net.URL;
 import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import services.ReclamationServices;

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
