/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui.tutorshipSessions;

import entities.RequestType;
import java.net.URL;
import java.time.LocalDate;
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

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class UpdateTutorshipSessionController implements Initializable {

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
    private Button banuuler;
    @FXML
    private ComboBox<?> cmtutor;
    @FXML
    private Label lheures;
    @FXML
    private Label lminutes;
    @FXML
    private Label datel;

    ObservableList typeChoices = FXCollections.observableArrayList("MessagesChat","VideoChat");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             
        cmtype.getItems().setAll(typeChoices) ;
    }    

    @FXML
    private void valider(ActionEvent event) {
    }

    @FXML
    private void annuler(ActionEvent event) {
    }
     public void setCldate(LocalDate cldate) {
        
        this.cldate.setValue(cldate);
    }

    public void setHslider(double h) {
        this.hslider.setValue(h);
    }

    public void setMslider(double m) {
        this.mslider.setValue(m);
    }

    public void setCmtype(RequestType cmtype) {
        this.cmtype.setValue(cmtype);
    }


    public void setCmtutor(RequestType cmtype) {
        
    }

    public void setLheures(double lheures) {
        this.lheures.setText(Double.toString(lheures));
    }

    public void setLminutes(double lminutes) {
        this.lminutes.setText(Double.toString(lminutes));
    }
}
