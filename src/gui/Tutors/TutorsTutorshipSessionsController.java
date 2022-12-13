/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui.Tutors;

import entities.TutorshipSession;
import entities.User;
import gui.AjoutUserController;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import outils.chat.client.Client;
import outils.chat.client.ClientApplication;

import services.TutorshipSessionService;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class TutorsTutorshipSessionsController implements Initializable {

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
    private ArrayList<Thread> threads;
    @FXML
    private Button connecter;
    @FXML
    private AnchorPane ap;

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
            clstudnet.setCellValueFactory(new PropertyValueFactory<TutorshipSession, Long>("nomStudent"));
            cltype.setCellValueFactory(new PropertyValueFactory<TutorshipSession, String>("type"));
            cldate.setCellValueFactory(new PropertyValueFactory<TutorshipSession, Timestamp>("date"));
            clurl.setCellValueFactory(new PropertyValueFactory<TutorshipSession, String>("url"));
            Sessions.setItems(sp.getList("id_tutor_id", u.getId()));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
        if (Sessions.getSelectionModel().getSelectedItem() != null) {
            t = Sessions.getSelectionModel().getSelectedItem();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateTutorshipSession.fxml"));
            Parent root;

            root = loader.load();
            Sessions.getScene().setRoot(root);
            UpdateTutorshipSessionController trc = loader.getController();
            trc.setCmtype(t.getType().name());
            trc.setCldate(LocalDate.parse(t.decompose().get(0)));
            trc.setHspinner(Integer.parseInt(t.decompose().get(1)));
            trc.setMspinner(Integer.parseInt(t.decompose().get(2)));

        }
    }

    @FXML
    private void annuler(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root;
        root = loader.load();
        Sessions.getScene().setRoot(root);

    }

    public TutorshipSession getT() {
        return t;
    }

    @FXML
    private void connecter(ActionEvent event) throws IOException, InterruptedException {
        t = Sessions.getSelectionModel().getSelectedItem();
        if (t.getType().name().equals("MessagesChat")) {
            this.clientchatapp(t).show();
        }else {
            String command = "cmd /c start "+t.getUrl();

        Process process = Runtime.getRuntime().exec(command);


        }
    }

    private Stage clientchatapp(TutorshipSession t) throws IOException, InterruptedException {
        Thread.sleep(3000);
        AjoutUserController cs = new AjoutUserController();
        User u = cs.getU();
        Client client = new Client("localhost", 8082, u.getNom());
        Thread clientThread = new Thread(client);
        clientThread.setDaemon(true);
        clientThread.start();
        threads = new ArrayList<Thread>();
        threads.add(clientThread);
        ClientApplication ca = new ClientApplication();
        Stage primaryStage = (Stage) ap.getScene().getWindow();
        primaryStage.close();
        primaryStage.setScene(ca.makeChatUI(client, (int) t.getIdTutorshipSession()));
        return primaryStage;
    }

   
}
