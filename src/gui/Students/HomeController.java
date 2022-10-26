/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui.Students;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class HomeController implements Initializable {

    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void add(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddTutorshipRequest.fxml"));
            Parent root ; 
        
            root = loader.load();
            label.getScene().setRoot(root);
    }

    @FXML
    private void show(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentTutorshipRequests.fxml"));
            Parent root ; 
        
            root = loader.load();
            label.getScene().setRoot(root);
    }

    @FXML
    private void showsession(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StudentTutorshipSessions.fxml"));
            Parent root ; 
        
            root = loader.load();
            label.getScene().setRoot(root);
    }
    
}
