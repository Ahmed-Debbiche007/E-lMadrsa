/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Role;
import entities.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import outils.SendSMS;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class PendinUsers implements Initializable {
 @FXML
    private TableView<User> tvUtilisateur;
    @FXML
    private TableColumn<User, String> colNom;
    @FXML
    private TableColumn<User, String> colPrenom;
    @FXML
    private TableColumn<User, String> colNomUtilisateur;
    @FXML
    private TableColumn<User, String> coltlf;
    @FXML
    private TableColumn<User, String> colemail;
    @FXML
    private TableColumn<User, Date> coldatenaissance;
    @FXML
    private TableColumn<User, String> colImage;
    @FXML
    private TableColumn<User, Role> colrole;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       afficherPersonne();
    }    

    @FXML
    private void approve(ActionEvent event) {
        User u = tvUtilisateur.getSelectionModel().getSelectedItem();
        UtilisateurService us = new UtilisateurService();
        u.setApproved(true);
        us.approve(u);
        SendSMS s = new SendSMS();
        String body = "Hello "+u.getNom()+" "+u.getPrenom()+": Your account has been approved!";
//        s.apiTwilio(body);
        afficherPersonne();
    }

    @FXML
    private void delete(ActionEvent event) {
        User u = tvUtilisateur.getSelectionModel().getSelectedItem();
        UtilisateurService us = new UtilisateurService();
        us.supprimer(u);
        afficherPersonne();
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Stage stage ;
        Parent root = FXMLLoader.load(getClass().getResource("nexte.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void afficherPersonne() {

        UtilisateurService us = new UtilisateurService();
        ObservableList<User> liste = us.afficherPending();

        colNom.setCellValueFactory(new PropertyValueFactory<User, String>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<User, String>("prenom"));
        colNomUtilisateur.setCellValueFactory(new PropertyValueFactory<User, String>("nomUtilisateur"));
        coltlf.setCellValueFactory(new PropertyValueFactory<User, String>("tel"));
        colemail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        colrole.setCellValueFactory(new PropertyValueFactory<User, Role>("role"));
        coldatenaissance.setCellValueFactory(new PropertyValueFactory<User, Date>("dateNaissance"));
        colImage.setCellValueFactory(new PropertyValueFactory<User, String>("image"));
        colImage.setCellValueFactory(new PropertyValueFactory<User, String>("image"));

        tvUtilisateur.setItems(liste);
        System.out.println(liste);
       

    }

    
}
