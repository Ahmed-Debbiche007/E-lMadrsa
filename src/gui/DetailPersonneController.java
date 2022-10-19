/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class DetailPersonneController implements Initializable {

    @FXML
    private Label tfnom;
    @FXML
    private Label tfprenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setTfnom(String tfnom) {
        this.tfnom.setText(tfnom) ;
    }

    public void setTfprenom(String tfprenom) {
        this.tfprenom.setText(tfprenom);
    }
    
    
}
