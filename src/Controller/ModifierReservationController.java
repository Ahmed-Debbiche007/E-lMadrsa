/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Controller.AfficherEvController;
import entities.CategorieEv;
import entities.Reservation;
import entities.User;
import entities.evenement;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.CategorieEvService;
import services.ReservationService;
import services.event_service;

/**
 * FXML Controller class
 *
 * @author lmol
 */
public class ModifierReservationController implements Initializable {

    private AnchorPane body;
    @FXML
    private ComboBox<evenement> nomevm;
    @FXML
    private TextField tfIDum;
    @FXML
    private Button Update;
    @FXML
    private Button retourmr;
     private static final Reservation ev = new Reservation();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         event_service cs=new event_service();
         cs.read().forEach((e) -> {
             nomevm.getItems().add(e);
             
        });
        // TODO
    }    

    @FXML
    private void UpdateReservation(ActionEvent event) {
                       evenement te=nomevm.getSelectionModel().getSelectedItem();
                        Reservation rs = new Reservation(ev.getId_reservation(), te, new User(1L));
                        ReservationService rss= new ReservationService();
                        rss.update(rs);
                        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setContentText("le evenement est Modifier avec succé");
                        alert.show();
    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
 
        
                Stage stage;
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/AfficherReservation.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
        
        
        
        
    }
     public void SetEv(Reservation e){
        ev.setId_reservation(e.getId_reservation());
        ev.setDateReservation(e.getDateReservation());
        ev.setId_ev(e.getId_ev());
        ev.setId_user(e.getId_user());
        
        
}
    
}
