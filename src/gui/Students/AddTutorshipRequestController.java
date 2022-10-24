/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui.Students;

import entities.RequestType;
import entities.TutorshipRequest;
import entities.User;
import gui.AjoutUserController;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javax.swing.JOptionPane;
import services.TutorshipRequestService;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class AddTutorshipRequestController implements Initializable {

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
    ObservableList typeChoices = FXCollections.observableArrayList("MessagesChat", "VideoChat");
    @FXML
    private Label datel;
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
        if (tobject.getText().equals("") || cmtype.getValue().equals("") || cldate.getValue() == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Eror Message");
            alert.setHeaderText(null);
            alert.setContentText("Demande Invalide!");
            alert.showAndWait();
        } else {
            TutorshipRequestService sp = new TutorshipRequestService();
            String date = cldate.getValue().toString() + " " + (int) hspinner.getValue() + ":" + (int) mspinner.getValue() + ":00";
            Timestamp time = Timestamp.valueOf(date);
            AjoutUserController cs = new AjoutUserController();
            User u = cs.getU();
            sp.add(new TutorshipRequest((long) 1, u.getId(), tobject.getText(), cmtype.getValue(), time));
            JOptionPane.showMessageDialog(null, "Demande Ajoutée ! ");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            Parent root;

            root = loader.load();
            lheures.getScene().setRoot(root);
        }
    }

    @FXML
    private void annuler(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root;

        root = loader.load();
        lheures.getScene().setRoot(root);
    }

}
