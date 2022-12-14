/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui.Tutors;

import entities.RequestType;
import entities.TutorshipSession;
import entities.User;
import gui.AjoutUserController;
import static gui.AuthController.connectedUser;
import java.io.IOException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javax.swing.JOptionPane;
import outils.CalendarQuickstart;
import services.TutorshipSessionService;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class UpdateTutorshipSessionController implements Initializable {

    @FXML
    private DatePicker cldate;
    @FXML
    private Button bvalider;
    @FXML
    private ComboBox<String> cmtype;
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
    @FXML
    private Spinner<Integer> hspinner;
    @FXML
    private Spinner<Integer> mspinner;
    ObservableList typeChoices = FXCollections.observableArrayList("MessagesChat","VideoChat");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         cmtype.getItems().setAll(typeChoices) ;
    }    

    @FXML
    private void valider(ActionEvent event) throws IOException, GeneralSecurityException {
        TutorsTutorshipSessionsController ttsc = new TutorsTutorshipSessionsController();
        TutorshipSession t = ttsc.getT();
        TutorshipSessionService sp = new TutorshipSessionService();
        String date = cldate.getValue().toString() + " " + (int) hspinner.getValue() + ":" + (int) mspinner.getValue() + ":00";
        Timestamp time = Timestamp.valueOf(date);
        AjoutUserController cs = new AjoutUserController();
        UtilisateurService service = new UtilisateurService();
        User student = service.getByUserId((int)t.getIdStudent());
        User u = connectedUser; 
        String url = null;
        if(t.getType().name().equals("MessagesChat")){
            CalendarQuickstart calendar = new CalendarQuickstart();
            String time1 = t.decompose().get(0)+"T"+t.decompose().get(1)+":"+t.decompose().get(2)+":00Z";
             url = calendar.generateMeetURL("Modified", time1, student) ;
         }
        sp.update(new TutorshipSession(t.getIdTutorshipSession(),t.getIdTutor(),t.getIdStudent(),t.getIdRequest(),url, cmtype.getValue(),time));
        JOptionPane.showMessageDialog(null,"Demande Modifiée ! ");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TutorsTutorshipSessions.fxml"));
            Parent root ; 
        
            root = loader.load();
            mspinner.getScene().setRoot(root);
    }

    @FXML
    private void annuler(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TutorsTutorshipSessions.fxml"));
            Parent root ; 
        
            root = loader.load();
            mspinner.getScene().setRoot(root);
    }
    
    public void setCldate(LocalDate cldate) {
        
        this.cldate.setValue(cldate);
    }

    public void setHspinner(int hspinner) {
        this.hspinner.getValueFactory().setValue(hspinner);
    }

    public void setMspinner(int mspinner) {
        this.mspinner.getValueFactory().setValue(mspinner);
    }

    

    public void setCmtype(String cmtype) {
        this.cmtype.setValue(cmtype);
    }


    public void setCmtutor(RequestType cmtype) {
        
    }

   
    
}
