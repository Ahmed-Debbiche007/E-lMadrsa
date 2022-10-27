/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Controller.AfficherEvController;
import entities.CategorieEv;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import services.CategorieEvService;

/**
 * FXML Controller class
 *
 * @author lmol
 */
public class AjouterCategorieController implements Initializable {

    @FXML
    private AnchorPane body;
    @FXML
    private TextField tfcat;
    @FXML
    private Button addcat;
    @FXML
    private Button retourres;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Ajoutercat(ActionEvent event) {
        if(tfcat.getText().isEmpty()){
          Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Veuiilez remplir tout les champs");
        alert.showAndWait();
        
        }else{
        CategorieEv c = new CategorieEv(tfcat.getText());
        CategorieEvService cs = new CategorieEvService();
        cs.insert(c);}
    }

    @FXML
    private void Retour(ActionEvent event) {
         final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/Categorie.fxml"));
        final Node node;
        try {
            node = fxmlLoader.load();
            AnchorPane pane=new AnchorPane(node);
            body.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(AfficherEvController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
