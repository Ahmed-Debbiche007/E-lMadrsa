/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class WelcomeController implements Initializable {

    @FXML
    private Button btformation;
    @FXML
    private Button BTCOMP;
    @FXML
    private Button btcategorie;
    @FXML
    private Button btPrerequis;
    @FXML
    private Button BtGestionAtt;
    @FXML
    private Button BtFiltrer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void crudformation(ActionEvent event) throws IOException {
        
        
            
            
        Stage stage ;
        Parent root = FXMLLoader.load(getClass().getResource("AjoutFormation.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

            

            
             
               
       
                     
    
    }

    @FXML
    private void crudcomp(ActionEvent event) throws IOException {
        Stage stage ;
        Parent root = FXMLLoader.load(getClass().getResource("AjoutCompetences.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void crudcategorie(ActionEvent event) throws IOException {
        Stage stage ;
        Parent root = FXMLLoader.load(getClass().getResource("AjoutCategorie.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void crudprerequis(ActionEvent event) throws IOException {
        Stage stage ;
        Parent root = FXMLLoader.load(getClass().getResource("AjoutPrerequis.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    

    @FXML
    private void GestionAtt(ActionEvent event) throws IOException {
        Stage stage ;
        Parent root = FXMLLoader.load(getClass().getResource("GestionAttestation.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void FilterFormationCat(ActionEvent event) throws IOException {
        Stage stage ;
        Parent root = FXMLLoader.load(getClass().getResource("Filtrage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
