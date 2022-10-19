/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui.tutorshiprequests;

import entities.RequestType;
import entities.TutorshipRequest;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import gui.tutorshiprequests.TutorshipRequestsController;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javax.swing.JOptionPane;
import services.TutorshipRequestService;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class UpdateTutorshipRequestController implements Initializable {

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
    @FXML
    private Label datel;
    
    ObservableList typeChoices = FXCollections.observableArrayList("MessagesChat","VideoChat");

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
    private void valider(ActionEvent event) throws IOException {
        TutorshipRequestsController trc = new TutorshipRequestsController();
        TutorshipRequestService sp = new TutorshipRequestService();
        TutorshipRequest t =trc.getT();
        System.out.println(t);
        String date =cldate.getValue().toString()+" "+(int)hslider.getValue()+":"+(int)mslider.getValue()+":00";
        Timestamp time = Timestamp.valueOf(date);           
        sp.update(new TutorshipRequest(t.getIdRequest(), (long)3,(long)3,tobject.getText(),cmtype.getValue().toString(),time));
        JOptionPane.showMessageDialog(null,"Demande Modifiée ! ");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TutorshipRequests.fxml"));
            Parent root ; 
        
            root = loader.load();
            mslider.getScene().setRoot(root);
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

    public void setTobject(String tobject) {
        this.tobject.setText(tobject);
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
