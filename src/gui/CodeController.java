/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Recup;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import static gui.AuthController.connectedUser;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.RecupService;
/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class CodeController implements Initializable {

    @FXML
    private TextField code;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void verify(ActionEvent event) throws IOException {
        
        RecupService rs = new RecupService();
        Recup r = rs.getByUserId(connectedUser.getId());
        if (r.getCode().equals(code.getText())){
            Stage stage;
            rs.supprimer(r);
        Parent root = FXMLLoader.load(getClass().getResource("nvmdp.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error Message");
            alerta.setHeaderText(null);
            alerta.setContentText("Wrong Code");
            alerta.showAndWait();
        }
    }
    
}
