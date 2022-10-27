/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Controller.AfficherEvController;
import entities.CategorieEv;
import entities.Reservation;
import entities.evenement;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import services.CategorieEvService;
import services.ReservationService;
import services.event_service;

/**
 * FXML Controller class
 *
 * @author lmol
 */
public class CategorieController implements Initializable {

    @FXML
    private AnchorPane body;
    @FXML
    private TableView<CategorieEv> table;
    @FXML
    private TableColumn<CategorieEv, String> cate;
    @FXML
    private Button addcat;
    @FXML
    private Button updatecat;
    @FXML
    private Button deletecat;
    @FXML
    private TextField recherche;
    @FXML
    private Button retourc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RefrecheTable();
        // TODO
    }    

    @FXML
    private void OpenAddcat(ActionEvent event) {
         final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/AjouterCategorie.fxml"));
        final Node node;
        try {
            node = fxmlLoader.load();
            AnchorPane pane=new AnchorPane(node);
            body.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(AfficherEvController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @FXML
    private void OpenUpdatecat(ActionEvent event) {
        ModifierCategorieController uc = new ModifierCategorieController();
         CategorieEv c=new CategorieEv();
        c=table.getSelectionModel().getSelectedItem();
//        System.out.println(c.toString());
        uc.SetEv(c);
          final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/ModifierCategorie.fxml"));
        final Node node;
        try {
            node = fxmlLoader.load();
            AnchorPane pane=new AnchorPane(node);
            body.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(AfficherEvController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @FXML
    private void Deletecat(ActionEvent event) {
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppresssion");
        alert.setContentText("Voulez-vous vraiment supprimer cette équipe ?");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            CategorieEvService es = new CategorieEvService();
            es.deletename(table.getSelectionModel().getSelectedItem().getType_ev());
            RefrecheTable();

        }
    }

    @FXML
    private void rechercheev(KeyEvent event) {
    }

    @FXML
    private void Retour(ActionEvent event) {
    }
     private void RefrecheTable(){
         
        CategorieEvService  ev =new CategorieEvService();
        ObservableList<CategorieEv> list = FXCollections.observableArrayList();
        list.addAll(ev.read());
       
        
        cate.setCellValueFactory(new PropertyValueFactory ("type_ev") );
        table.setItems(list);
    }
}
