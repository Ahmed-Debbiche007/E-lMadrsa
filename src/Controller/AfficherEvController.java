/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import controller.QRcodeController;
import entitie.Reservation;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import entitie.User;
import entitie.evenement;
import services.event_service;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import services.ReservationService;

/**
 * FXML Controller class
 *
 * @author lmol
 */
public class AfficherEvController implements Initializable {

    @FXML
    private AnchorPane body;
    @FXML
    private TableView<evenement> table;

    @FXML
    private TableColumn<evenement, Date> dateev;
    @FXML
    private TableColumn<evenement, String> desc;
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
    private TableColumn<evenement, String> imageEv;
    @FXML
    private TableColumn<evenement, String> typeev;
    @FXML
    private TableColumn<evenement, String> userev;
    @FXML
    private TableColumn<evenement, String> nomev;
    @FXML
    private TableColumn<evenement, String> etat_ev;
    @FXML
    private ImageView participer;
    @FXML
    private Button particper;
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
        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/AjouterEve.fxml"));
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
        UpdateEvController uc = new UpdateEvController();
        evenement c = new evenement();
        c = table.getSelectionModel().getSelectedItem();
//        System.out.println(c.toString());
        uc.SetEv(c);
        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/UpdateEv.fxml"));
        final Node node;
        try {
            node = fxmlLoader.load();
            AnchorPane pane = new AnchorPane(node);
            body.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(AfficherEvController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void RefrecheTable() {

        event_service ev = new event_service();
        ObservableList<evenement> list = FXCollections.observableArrayList();
        list.addAll(ev.read());

        nomev.setCellValueFactory(new PropertyValueFactory("nom_ev"));

        dateev.setCellValueFactory(new PropertyValueFactory("date"));
        imageEv.setCellValueFactory(new PropertyValueFactory("image_ev"));
        userev.setCellValueFactory(new PropertyValueFactory("id_user"));
        desc.setCellValueFactory(new PropertyValueFactory("desc_ev"));
        etat_ev.setCellValueFactory(new PropertyValueFactory("etat_evenement"));
        typeev.setCellValueFactory(new PropertyValueFactory("id_Cat"));
        table.setItems(list);
    }

    @FXML
    private void DeleteEv(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppresssion");
        alert.setContentText("Voulez-vous vraiment supprimer cet evenement ?");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            event_service es = new event_service();
            es.delete(table.getSelectionModel().getSelectedItem().getId_ev());
            RefrecheTable();

        }
    }

    @FXML
    private void rechercheev(KeyEvent event) {
        event_service ev = new event_service();
        ObservableList<evenement> list = FXCollections.observableArrayList();
        list.addAll(ev.readByName(recherche.getText()));

        nomev.setCellValueFactory(new PropertyValueFactory("nom_ev"));
        typeev.setCellValueFactory(new PropertyValueFactory("type_ev"));
        dateev.setCellValueFactory(new PropertyValueFactory("date"));
        imageEv.setCellValueFactory(new PropertyValueFactory("image_ev"));
        userev.setCellValueFactory(new PropertyValueFactory("id_user"));
        desc.setCellValueFactory(new PropertyValueFactory("desc_ev"));
        etat_ev.setCellValueFactory(new PropertyValueFactory("etat_evenement"));
        table.setItems(list);

    }

    @FXML
    private void Retour(ActionEvent event) {
    }

    @FXML
    private void AddPArticipation(MouseEvent event) {

    }

    @FXML
    private void addParticiper(ActionEvent event) {
        AjouterReservationController uc = new AjouterReservationController();
        evenement c = new evenement();
        c = table.getSelectionModel().getSelectedItem();
//        System.out.println(c.toString());

        Reservation res = new Reservation(c, new User(9));
        ReservationService rs = new ReservationService();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("l'evenement est ajouté avec succé");
        alert.showAndWait();
        rs.insert(res);
        Reservation r1 = rs.getLatest();
        rs.readQR(r1.getId_reservation());
        System.out.println(r1.getId_reservation());

    }

    public void mailSender() {
        String host = "elmaderssa2023@gmail.com";  //← my email address
        final String user = "elmaderssa2023@gmail.com";//← my email address
        final String password = "mondher123";//change accordingly   //← my email password

        String to = "yassinemanaa27@gmail.com";//→ the EMAIL i want to send TO →

        // session object
        Properties props = new Properties();
        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        //My message :
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(" NOTIFICATION APPOINTEMENTT !!! ");
            //Text in emial :
            //message.setText("  → Text message for Your Appointement ← ");
            //Html code in email :
            message.setContent(
                    "<h1 style =\"color:red\" >DON'T MISS YOUR APPOINTEMENT !! </h1> <br/> <img width=\"50%\" height=\"50%\" src=https://i.imgur.com/iYcBkOf.png>",
                    "text/html");

            //send the message
            Transport.send(message);

            System.out.println("message sent successfully via mail ... !!! ");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void AfficheQR(ActionEvent event) {
    }

}
