
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui.Students;

import gui.tutorshipSessions.*;
import gui.tutorshiprequests.*;
import entities.TutorshipRequest;
import entities.TutorshipSession;
import entities.User;
import gui.AjoutUserController;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import outils.chat.client.Client;
import outils.chat.client.ClientApplication;
import static outils.chat.server.ServerApplication.threads;
import services.TutorshipRequestService;
import services.TutorshipSessionService;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class StudentTutorshipSessionsController implements Initializable {

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
    private Button annuler;

    private static TutorshipSession t;
    @FXML
    private Button connecter;

    @FXML
    private AnchorPane ap;
    private ArrayList<Thread> threads;

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
            AjoutUserController cs = new AjoutUserController();
            User u = cs.getU();
            clstudnet.setCellValueFactory(new PropertyValueFactory<TutorshipSession, Long>("idStudent"));
            cltutor.setCellValueFactory(new PropertyValueFactory<TutorshipSession, Long>("idTutor"));
            cltype.setCellValueFactory(new PropertyValueFactory<TutorshipSession, String>("type"));
            cldate.setCellValueFactory(new PropertyValueFactory<TutorshipSession, Timestamp>("date"));
            clurl.setCellValueFactory(new PropertyValueFactory<TutorshipSession, String>("url"));
            Sessions.setItems(sp.getSingle("idStudent", u.getId()));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void annuler(ActionEvent event) throws IOException {
        if (Sessions.getSelectionModel().getSelectedItem() != null) {
            TutorshipSession t = Sessions.getSelectionModel().getSelectedItem();
            TutorshipSessionService sp = new TutorshipSessionService();
            sp.delete(t);
            show();
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("./Home.fxml"));
            Parent root;

            root = loader.load();
            Sessions.getScene().setRoot(root);
        }
    }

    public TutorshipSession getT() {
        return t;
    }

    @FXML
    private void connecter(ActionEvent event) throws IOException {
        AjoutUserController cs = new AjoutUserController();
        User u = cs.getU();
        Client client = new Client("localhost", 8080, u.getNom());
        Thread clientThread = new Thread(client);
        clientThread.setDaemon(true);
        clientThread.start();
        threads = new ArrayList<Thread>();
        threads.add(clientThread);
        ClientApplication ca = new ClientApplication() ;
        Stage primaryStage = (Stage) ap.getScene().getWindow();
        primaryStage.close();
        primaryStage.setScene(ca.makeChatUI(client));
        primaryStage.show();
    }

}
