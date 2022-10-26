/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import entites.Formation;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ItemController implements Initializable {

    
    @FXML
    private Label textArea1;
    @FXML
    private Label idlabel11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    public void setData(Formation F){
        idlabel11.setText(F.getSujet());
        textArea1.setText(F.getDescription());
        textArea1.setMinWidth(Region.USE_COMPUTED_SIZE);
        textArea1.setMinWidth(Region.USE_COMPUTED_SIZE);
        textArea1.setPrefWidth(Region.USE_COMPUTED_SIZE);
        textArea1.setMaxWidth(Region.USE_COMPUTED_SIZE);
        
        textArea1.setMinHeight(Region.USE_COMPUTED_SIZE);
        textArea1.setPrefHeight(Region.USE_COMPUTED_SIZE);
        textArea1.setMaxHeight(Region.USE_COMPUTED_SIZE);
        /*textArea1.setMinWidth(Region.USE_COMPUTED_SIZE);
        textArea1.setPrefWidth(Region.USE_COMPUTED_SIZE);
        textArea1.setMaxWidth(Region.USE_COMPUTED_SIZE);
        
        textArea1.setMinHeight(Region.USE_COMPUTED_SIZE);
        textArea1.setPrefHeight(Region.USE_COMPUTED_SIZE);
        textArea1.setMaxHeight(Region.USE_COMPUTED_SIZE);*/
        
        
        
        
        
        
    }
    
}
