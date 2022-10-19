/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class AjoutUserController implements Initializable {

    @FXML
    private TextField fnom;
    @FXML
    private TextField fprenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjoutPersonne(ActionEvent event) throws IOException  {
         UserService  SP = new UserService() ;
        SP.ajouterUser(new User(fnom.getText(),fprenom.getText()));
        JOptionPane.showMessageDialog(null,"Personne Ajoutée ! ");
      
        
        
        //redirection vers l'interface thenya 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailPersonne.fxml")) ;
        Parent root ; 
        
            root = loader.load();
            fnom.getScene().setRoot(root);
        
        
        DetailPersonneController dpc = loader.getController();
        dpc.setTfnom(fnom.getText());
        dpc.setTfprenom(fprenom.getText());
        
        
        
    }
    
}
