/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import com.google.common.hash.Hashing;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import static gui.AuthController.connectedUser;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class NvmdpController implements Initializable {

    @FXML
    private TextField nvmdp;
    @FXML
    private TextField cmdp;
    @FXML
    private Button excute;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void execute(ActionEvent event) throws IOException {
        if (nvmdp.getText().length() < 8) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error Message");
            alerta.setHeaderText(null);
            alerta.setContentText("Invalid Password!");
            alerta.showAndWait();

        } else if (!nvmdp.getText().equals(cmdp.getText())) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error Message");
            alerta.setHeaderText(null);
            alerta.setContentText("Unmatching Password!");
            alerta.showAndWait();

        } else {
            String hashPass = Hashing.sha256().hashString(nvmdp.getText(), StandardCharsets.UTF_8).toString();
            connectedUser.setmotDePasee(hashPass);
            UtilisateurService u = new UtilisateurService();
            u.updatePassword(connectedUser);
            Stage stage;
            Parent root = FXMLLoader.load(getClass().getResource("auth.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

}
