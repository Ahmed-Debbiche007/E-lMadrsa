/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Examen;
import entities.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
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
import services.ExamenService;
import services.ReclamationServices;
import services.ServiceCategorie;

/**
 * FXML Controller class
 *
 * @author Msi
 */
public class ListReclamationsController implements Initializable {

    @FXML
    private TableView<Reclamation> tvReclamations;
    @FXML
    private TableColumn<Reclamation, String> colSujet;
    @FXML
    private TableColumn<Reclamation, String> colDesc;
    @FXML
    private TableColumn<Reclamation, Date> colDate;
    @FXML
    private TableColumn<Reclamation, Long> colUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showReclamations() ;
        // TODO
    }    
    
    
    public void showReclamations() {
        
    
    
            ReclamationServices RS = new ReclamationServices() ; 
        ObservableList<Reclamation> list = RS.afficher() ;
        System.out.println(list ) ; 
        colSujet.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("sujet"));
        colDesc.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("Description"));
        colDate.setCellValueFactory(new PropertyValueFactory<Reclamation,Date>("dateRec"));
        colUser.setCellValueFactory(new PropertyValueFactory<Reclamation,Long>("UserId"));
       
        
        System.out.println("///////////////////////" + list); 
 
 

        tvReclamations.setItems(list);
    
    }

    @FXML
    private void backtomain(ActionEvent event) throws IOException {
            Stage stage ;
    Parent root = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    Scene scene=new Scene(root);
    stage.setScene(scene);
    stage.show();
    }
    
    
}
