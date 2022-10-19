/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AfficheCategorieController implements Initializable {
    private Label labelcategorie;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public Label getLabelcategorie() {
        return labelcategorie;
    }

    public void setLabelcategorie(String labelCategorie) {
        this.labelcategorie.setText(labelCategorie);
    }
    
    
}
