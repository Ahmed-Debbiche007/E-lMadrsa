/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Msi
 */
public class AjoutQuizController implements Initializable {

    @FXML
    private TableView<?> tvQuiz;
    @FXML
    private TableColumn<?, ?> colNomExamen;
    @FXML
    private TableColumn<?, ?> colPourcentageExamen;
    @FXML
    private TableColumn<?, ?> colDureeExamen;
    @FXML
    private TextField lbNomQuiz;
    @FXML
    private TextField lbExamenId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajuoterQuiz(ActionEvent event) {
    }

    @FXML
    private void modifierQuiz(ActionEvent event) {
    }

    @FXML
    private void supprimerQuiz(ActionEvent event) {
    }

    @FXML
    private void BackToMain(ActionEvent event) {
    }
    
}
