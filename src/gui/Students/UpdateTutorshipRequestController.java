/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui.Students;

import gui.tutorshiprequests.*;
import entities.RequestType;
import entities.TutorshipRequest;
import entities.User;
import gui.AjoutUserController;
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
import javafx.scene.control.Spinner;
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
    private Slider hslider;
    private Slider mslider;
    @FXML
    private Button bvalider;
    @FXML
    private ComboBox<String> cmtype;
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
    @FXML
    private Spinner<Integer> hspinner;
    @FXML
    private Spinner<Integer> mspinner;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cmtype.getItems().setAll(typeChoices);
    }

    @FXML
    private void valider(ActionEvent event) throws IOException {
        StudentTutorshipRequestsController trc = new StudentTutorshipRequestsController();
        TutorshipRequest t =trc.getT();
        TutorshipRequestService sp = new TutorshipRequestService();
        String date = cldate.getValue().toString() + " " + (int) hspinner.getValue() + ":" + (int) mspinner.getValue() + ":00";
        Timestamp time = Timestamp.valueOf(date);
        AjoutUserController cs = new AjoutUserController();
        User u = cs.getU();          
        sp.update(new TutorshipRequest(t.getIdRequest(),  u.getId(), (long)3,tobject.getText(),cmtype.getValue(),time));
        JOptionPane.showMessageDialog(null,"Demande Modifiée ! ");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            Parent root ; 
        
            root = loader.load();
            mspinner.getScene().setRoot(root);
    }

    @FXML
    private void annuler(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("./Home.fxml"));
            Parent root;

            root = loader.load();
            mspinner.getScene().setRoot(root);
    }
    public void setCldate(LocalDate cldate) {
        
        this.cldate.setValue(cldate);
    }


    public void setCmtype(RequestType cmtype) {
        this.cmtype.setValue(cmtype.name());
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

    public void setHspinner(int hspinner) {
        this.hspinner.getValueFactory().setValue(hspinner);
    }

    public void setMspinner(int mspinner) {
        this.mspinner.getValueFactory().setValue(mspinner);
    }
    
    
    
    
}
