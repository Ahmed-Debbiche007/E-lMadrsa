/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

 import entities.Participation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
 import services.ParticipationService;

/**
 * FXML Controller class
 *
 * @author Msi
 */
public class ParticipationCrudController implements Initializable {

    @FXML
    private TableView<Participation> tvParticipations;
    @FXML
    private TableColumn<Participation, Double> colDtParticipation;
    @FXML
    private TableColumn<Participation, Long> coluser;
    @FXML
    private TableColumn<Participation, Long> colFormation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showParticipants() ;
        // TODO
    }    

    
    
              public void showParticipants() {
        ParticipationService PS = new ParticipationService() ; 
        ObservableList<Participation> list = PS.afficher() ;
        System.out.println(list ) ; 
        colDtParticipation.setCellValueFactory(new PropertyValueFactory<Participation,Double>("resultat"));
        coluser.setCellValueFactory(new PropertyValueFactory<Participation,Long>("idUser"));
        colFormation.setCellValueFactory(new PropertyValueFactory<Participation,Long>("idFormation"));
        System.out.println(list);
        tvParticipations.setItems(list);
        
    }
    
    
    
    
    @FXML
    private void backToMainInterface(ActionEvent event) throws IOException {
    Stage stage ;
    Parent root = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    Scene scene=new Scene(root);
    stage.setScene(scene);
    stage.show();
    }
    
}
