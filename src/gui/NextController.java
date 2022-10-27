/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import static gui.AuthController.connectedUser;

/**
 * FXML Controller class
 *
 * @author Nour
 */
public class NextController implements Initializable {

    @FXML
    private Button btndeconnect;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnUser;
    @FXML
    private Button btnrecord;
    @FXML
    private Button btnPending;

    /**
     * Initializes the controller class.
     */
    @FXML
    private void Retour(ActionEvent event) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getResource("auth.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void goadmin(ActionEvent event) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getResource("AjoutPersonne.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        connectedUser = null;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @FXML
    private void goapprove(ActionEvent event) throws IOException {

        Stage stage;
        Parent root = FXMLLoader.load(getClass().getResource("PendinUsers.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void toHome(ActionEvent event) throws IOException {

        Stage stage;

        if (AuthController.connectedUser.getrole().name().equals("Student")) {
            Parent root = FXMLLoader.load(getClass().getResource("mainuiiistudent.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else if (AuthController.connectedUser.getrole().name().equals("Tutor")) {
            Parent root = FXMLLoader.load(getClass().getResource("mainuiiiteacher.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (AuthController.connectedUser.getrole().name().equals("Admin")) {

            Parent root = FXMLLoader.load(getClass().getResource("mainuiiiadmin.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

    }

}
