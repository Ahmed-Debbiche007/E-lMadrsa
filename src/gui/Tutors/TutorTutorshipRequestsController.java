
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui.Tutors;

import entities.ChatSession;
import entities.TutorshipRequest;
import entities.TutorshipSession;
import entities.User;
import gui.AjoutUserController;
import java.io.IOException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import outils.CalendarQuickstart;
import services.ChatSessionService;
import services.TutorshipRequestService;
import services.TutorshipSessionService;

import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class TutorTutorshipRequestsController implements Initializable {

    @FXML
    private TableColumn<TutorshipRequest, Long> clstudnet;
    @FXML
    private TableColumn<TutorshipRequest, Long> cltutor;
    @FXML
    private TableColumn<TutorshipRequest, String> cltype;
    @FXML
    private TableColumn<TutorshipRequest, Timestamp> cldate;
    @FXML
    private TableColumn<TutorshipRequest, String> clobject;
    @FXML
    private TableView<TutorshipRequest> requests;
    @FXML
    private Button valider;
    @FXML
    private Button annuler;

    private static TutorshipRequest t;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        show();
    }

    public void show() {
        TutorshipRequestService sp = new TutorshipRequestService();
        try {
            AjoutUserController cs = new AjoutUserController();
            User u = cs.getU();
            clstudnet.setCellValueFactory(new PropertyValueFactory<TutorshipRequest, Long>("nomStudent"));
            cltype.setCellValueFactory(new PropertyValueFactory<TutorshipRequest, String>("requestType"));
            cldate.setCellValueFactory(new PropertyValueFactory<TutorshipRequest, Timestamp>("sessionDate"));
            clobject.setCellValueFactory(new PropertyValueFactory<TutorshipRequest, String>("requestBody"));
            requests.setItems(sp.getList("idStudent", u.getId()));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }


    @FXML
    private void annuler(ActionEvent event) throws IOException {
        if (requests.getSelectionModel().getSelectedItem() != null) {
            TutorshipRequest t = requests.getSelectionModel().getSelectedItem();
            TutorshipRequestService sp = new TutorshipRequestService();
            sp.delete(t);
            show();
        } else {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            Parent root ; 
        
            root = loader.load();
            requests.getScene().setRoot(root);
        }
    }

    public TutorshipRequest getT() {
        return t;
    }
@FXML
    private void valider(ActionEvent event) throws IOException, GeneralSecurityException {
        TutorshipRequest t = requests.getSelectionModel().getSelectedItem();
        TutorshipRequestService ts = new TutorshipRequestService();
        UtilisateurService service = new UtilisateurService();
        User student = service.getByUserId((int)t.getIdStudent());
        ts.delete(t);
         String url = null;
        if(t.getRequestType().name().equals("VideoChat")){
            CalendarQuickstart calendar = new CalendarQuickstart();
            String time = t.decompose().get(0)+"T"+t.decompose().get(1)+":"+t.decompose().get(2)+":00Z";
             url = calendar.generateMeetURL(t.getRequestBody(), time, student) ;
         }
        TutorshipSession s = new TutorshipSession(t.getIdTutor(), t.getIdStudent(), t.getIdRequest(), url,t.getRequestType(),t.getSessionDate());
        TutorshipSessionService ss = new TutorshipSessionService();
        ss.add(s);
        s = ss.getLatest();
        if(t.getRequestType().name().equals("MessagesChat")){
            ChatSessionService cs = new ChatSessionService();
        cs.add(new ChatSession(s.getIdTutorshipSession()));
        }
        
        JOptionPane.showMessageDialog(null, "Sceance Planifiée! ");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            Parent root ; 
        
            root = loader.load();
            requests.getScene().setRoot(root);
    }
}
