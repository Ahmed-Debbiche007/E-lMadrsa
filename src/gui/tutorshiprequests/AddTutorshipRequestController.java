/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui.tutorshiprequests;

import entities.RequestType;
import entities.TutorshipRequest;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javax.swing.JOptionPane;
import services.TutorshipRequestService;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class AddTutorshipRequestController implements Initializable {
    
    @FXML
    private DatePicker cldate;
    @FXML
    private Slider hslider;
    @FXML
    private Slider mslider;
    @FXML
    private Button bvalider;
    @FXML
    private ComboBox<RequestType> cmtype;
    @FXML
    private TextArea tobject;
    @FXML
    private Button banuuler;
    @FXML
    private ComboBox<?> cmtutor;
    @FXML
    private Label lheures;
    @FXML
    private Label lminutes;
    ObservableList typeChoices = FXCollections.observableArrayList("MessagesChat","VideoChat");
    @FXML
    private Label datel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hslider.valueProperty().addListener((observable, oldValue, newValue) -> {            
            lheures.setText(Double.toString(newValue.intValue()));            
        });
        
        mslider.valueProperty().addListener((observable, oldValue, newValue) -> {            
            lminutes.setText(Double.toString(newValue.intValue()));            
        });
        
        cmtype.getItems().setAll(typeChoices) ;
    }    
    
    @FXML
    private void valider(ActionEvent event) {
        TutorshipRequestService sp = new TutorshipRequestService();
        String date =cldate.getValue().toString()+" "+(int)hslider.getValue()+":"+(int)mslider.getValue()+":00";
        Timestamp time = Timestamp.valueOf(date);           
        sp.add(new TutorshipRequest((long)3,(long)3,tobject.getText(),cmtype.getValue().toString(),time));
        JOptionPane.showMessageDialog(null,"Demande Ajoutée ! ");
    }
    
    @FXML
    private void annuler(ActionEvent event) {
    }

    
}
