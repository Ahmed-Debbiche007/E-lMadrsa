/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Personne;
import entities.Quiz;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import services.QuizService;
import services.ServicePersonne;

/**
 * FXML Controller class
 *
 * @author Msi
 */
public class AjoutPersonneController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterPersonne(ActionEvent event) throws IOException {
        
        ServicePersonne  SP = new ServicePersonne() ;
        SP.ajouter(new Personne(tfNom.getText(),tfPrenom.getText()));
        
        JOptionPane.showMessageDialog(null,"Personne Ajoutée ! ");
        
        
        //redirection vers l'interface thenya 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("detailPersonne.fxml")) ;
        Parent root = loader.load() ; 
        tfNom.getScene().setRoot(root);
        
        
        DetailPersonneController dpc = loader.getController();
        dpc.setLbNom(tfNom.getText());
        dpc.setLbPrenom(tfPrenom.getText());
        
        
        
        
        
        
        
        
        
        
        
  
    }
    
}
