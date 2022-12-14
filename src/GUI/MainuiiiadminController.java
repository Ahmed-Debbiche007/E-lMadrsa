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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Msi
 */
public class MainuiiiadminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void PROFILEADMIN(ActionEvent event) {

    }

    @FXML
    private void gotoprofileadmin(MouseEvent event) {
    }

    @FXML
    private void EXAMENADMIN(ActionEvent event) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void gotogestionexamADMIN(MouseEvent event) {
    }

    @FXML
    private void FORMATIONADMIN(ActionEvent event) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getResource("../gui/welcome.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void gotogestionformationADMIN(MouseEvent event) {
    }

    @FXML
    private void PUBLICATIONADMIN(ActionEvent event) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getResource("cat.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void gotogestionpubADMIN(MouseEvent event) {
    }

    @FXML
    private void EVENEMENTADMIN(ActionEvent event) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/AfficherEv.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void gotogestioneventADMIN(MouseEvent event) {
    }

    @FXML
    private void COURSPARTICULIERADMIN(ActionEvent event) {
    }

    @FXML
    private void gotogestioncoursparticulierADMIN(MouseEvent event) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getResource("Tutors/Home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void RECLAMATIONADMIN(ActionEvent event) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/AfficherReservation.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void gotoreclamationsADMIN(MouseEvent event) throws IOException {
        
    }

    @FXML
    private void DEMANDESADMIN(ActionEvent event) {
    }

    @FXML
    private void gestiondemandesADMIN(MouseEvent event) {
    }

    @FXML
    private void backtoMain(ActionEvent event) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getResource("nexte.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
