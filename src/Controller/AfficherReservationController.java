/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Controller.AfficherEvController;
import Controller.QRcodeController;
import entities.Reservation;
import entities.User;
import entities.evenement;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import services.ReservationService;
import services.UtilisateurService;
import services.event_service;

/**
 * FXML Controller class
 *
 * @author lmol
 */
public class AfficherReservationController implements Initializable {

    @FXML
    private AnchorPane body;
    @FXML
    private TableView<Reservation> table;
    @FXML
    private Button addEV;
    @FXML
    private Button updateEV;
    @FXML
    private Button deleteEv;
    @FXML
    private TextField recherche;
    @FXML
    private Button retourc;
    @FXML
    private TableColumn<Reservation, ImageView> iduser;
    @FXML
    private TableColumn<Reservation, Integer> idev;
    @FXML
    private TableColumn<Reservation, Date> datereser;
    @FXML
    private Button qr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        RefrecheTable();
        // TODO
    }

    @FXML
    private void OpenAddEV(ActionEvent event) {
        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/AjouterReservation.fxml"));
        final Node node;
        try {
            node = fxmlLoader.load();
            AnchorPane pane = new AnchorPane(node);
            body.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(AfficherEvController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void OpenUpdateEv(ActionEvent event) {
        ModifierReservationController mr = new ModifierReservationController();
        Reservation c = new Reservation();
        c = table.getSelectionModel().getSelectedItem();
//        System.out.println(c.toString());
        mr.SetEv(c);

        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../GUI/ModifierReservation.fxml"));
        final Node node;
        try {
            node = fxmlLoader.load();
            AnchorPane pane = new AnchorPane(node);
            body.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(AfficherEvController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void DeleteEv(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppresssion");
        alert.setContentText("Voulez-vous vraiment supprimer cette Reservation ?");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            ReservationService es = new ReservationService();
            es.delete(table.getSelectionModel().getSelectedItem().getId_reservation());
            RefrecheTable();

        }
    }

    @FXML
    private void rechercheev(KeyEvent event) {
        ReservationService ev = new ReservationService();
        ObservableList<Reservation> list = FXCollections.observableArrayList();
        list.addAll(ev.readByName(recherche.getText()));

        datereser.setCellValueFactory(new PropertyValueFactory("dateReservation"));
        idev.setCellValueFactory(new PropertyValueFactory("id_ev"));
        iduser.setCellValueFactory(new PropertyValueFactory("id_user"));
        table.setItems(list);
    }

    @FXML
    private void Retour(ActionEvent event) {
    }

    private void RefrecheTable() {

        ReservationService ev = new ReservationService();
        ObservableList<Reservation> list = FXCollections.observableArrayList();
        list.addAll(ev.read());
        UtilisateurService us = new UtilisateurService();
        datereser.setCellValueFactory(new PropertyValueFactory("dateReservation"));
        idev.setCellValueFactory(new PropertyValueFactory("id_ev"));
        iduser.setCellValueFactory(new PropertyValueFactory<Reservation, ImageView>("img"));
        list.forEach(item -> {
            User u = us.getByUserId((int)(long)item.getId_user().getId());
            String path = "/home/ahmed/PiDev/E-lMadrsa-Web/public/uploads/images/" + u.getImage();
            File image = new File(path);
            Image imgg = new Image (image.toURI().toString());
            ImageView img = new ImageView(imgg);
            img.setFitHeight(50);
            img.setFitWidth(50);
            item.setImg(img);
        }
        );
        table.setItems(list);
    }

    @FXML
    private void AfficheQR(ActionEvent event) throws InterruptedException {
        Reservation c = new Reservation();
        ReservationService rs = new ReservationService();
        c = table.getSelectionModel().getSelectedItem();
        rs.readQR(c.getId_reservation());
        
        QRcodeController qrc = new QRcodeController();
        qrc.setQR(c.getId_reservation());

        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../GUI/QrCode.fxml"));
        final Node node;
        try {
            node = fxmlLoader.load();
            AnchorPane pane = new AnchorPane(node);
            body.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(AfficherEvController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
