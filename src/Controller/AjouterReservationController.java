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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
public class AjouterReservationController implements Initializable {

    @FXML
    private AnchorPane body;
    @FXML
    private ComboBox<evenement> nomev;
    @FXML
    private TextField tfIDu;
    @FXML
    private Button addres;
    @FXML
    private Button retourres;
         private static final evenement ev = new evenement();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       event_service es=new event_service();
         es.read().forEach((e) -> {
             nomev.getItems().add(e);
        });
    }    

    @FXML
    private void AjouterReservation(ActionEvent event) {
        
       
            
   Reservation res=new Reservation(nomev.getSelectionModel().getSelectedItem(),new User(1L));
   ReservationService rs=new ReservationService();
   rs.insert(res);
   
         
    }

    @FXML
    private void Retour(ActionEvent event) {
         final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../GUI/AfficherReservation.fxml"));
        final Node node;
        try {
            node = fxmlLoader.load();
            AnchorPane pane=new AnchorPane(node);
            body.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(AfficherEvController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public void SetEv(evenement e){
        ev.setId_ev(e.getId_ev());
        ev.setNom_ev(e.getNom_ev());
        ev.setId_categorie(e.getId_categorie());
        ev.setDate(e.getDate());
        ev.setDesc_ev(e.getDesc_ev());
        ev.setImage_ev(e.getImage_ev());
        ev.setId_user(e.getId_user());
       
        
}
    
}
