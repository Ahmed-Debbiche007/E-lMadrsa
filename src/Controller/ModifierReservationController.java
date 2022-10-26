/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Controller.AfficherEvController;
import entitie.CategorieEv;
import entitie.Reservation;
import entitie.User;
import entitie.evenement;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import services.CategorieEvService;
import services.ReservationService;
import services.event_service;

/**
 * FXML Controller class
 *
 * @author lmol
 */
public class ModifierReservationController implements Initializable {

    @FXML
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
                        Reservation rs = new Reservation(ev.getId_reservation(), te, new User(1));
                        ReservationService rss= new ReservationService();
                        rss.update(rs);
                        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setContentText("le evenement est Modifier avec succé");
                        alert.show();
    }

    @FXML
    private void Retour(ActionEvent event) {
         final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/AfficherReservation.fxml"));
        final Node node;
        try {
            node = fxmlLoader.load();
            AnchorPane pane=new AnchorPane(node);
            body.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(AfficherEvController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
     public void SetEv(Reservation e){
        ev.setId_reservation(e.getId_reservation());
        ev.setDateReservation(e.getDateReservation());
        ev.setId_ev(e.getId_ev());
        ev.setId_user(e.getId_user());
        
        
}
    
}
