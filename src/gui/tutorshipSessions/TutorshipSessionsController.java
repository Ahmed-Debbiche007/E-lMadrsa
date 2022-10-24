
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui.tutorshipSessions;

import entities.TutorshipRequest;
import entities.TutorshipSession;
import java.io.IOException;
import java.net.URL;
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
import services.TutorshipRequestService;
import services.TutorshipSessionService;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class TutorshipSessionsController implements Initializable {

    @FXML
    private TableColumn<TutorshipSession, Long> clstudnet;
    @FXML
    private TableColumn<TutorshipSession, Long> cltutor;
    @FXML
    private TableColumn<TutorshipSession, String> cltype;
    @FXML
    private TableColumn<TutorshipSession, Timestamp> cldate;
    @FXML
    private TableColumn<TutorshipSession, String> clurl;
    @FXML
    private TableView<TutorshipSession> Sessions;
    private Button valider;
    @FXML
    private Button modifier;
    @FXML
    private Button annuler;
    
    private static TutorshipSession t;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        show();
    }

    public void show() {
        TutorshipSessionService sp = new TutorshipSessionService();
        try {
            clstudnet.setCellValueFactory(new PropertyValueFactory<TutorshipSession, Long>("idStudent"));
            cltutor.setCellValueFactory(new PropertyValueFactory<TutorshipSession, Long>("idTutor"));
            cltype.setCellValueFactory(new PropertyValueFactory<TutorshipSession, String>("type"));
            cldate.setCellValueFactory(new PropertyValueFactory<TutorshipSession, Timestamp>("date"));
            clurl.setCellValueFactory(new PropertyValueFactory<TutorshipSession, String>("url"));
            Sessions.setItems(sp.getAll());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    

    @FXML
    private void modifier(ActionEvent event) throws IOException {
       if (Sessions.getSelectionModel().getSelectedItem() != null) {
            t = Sessions.getSelectionModel().getSelectedItem();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateTutorshipSession.fxml"));
            Parent root ; 
        
            root = loader.load();
            annuler.getScene().setRoot(root);
            UpdateTutorshipSessionController trc = loader.getController();
            trc.setCmtype(t.getType());
            trc.setCldate(LocalDate.parse(t.decompose().get(0)));
            trc.setHslider(Double.parseDouble(t.decompose().get(1)));
            trc.setMslider(Double.parseDouble(t.decompose().get(2)));
       
    }
    }
    @FXML
    private void annuler(ActionEvent event) {
       /* if (Sessions.getSelectionModel().getSelectedItem() != null) {
            TutorshipSession t = Sessions.getSelectionModel().getSelectedItem();
            TutorshipSessionService sp = new TutorshipSessionService();
            sp.delete(t);
            show();
        }else{
            System.out.println("Ahla");
        }*/
    }

    public TutorshipSession getT() {
        return t;
    }

    
}
