/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entites.Categorie;
import entites.Formation;
import entities.Examen;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import services.ExamenService;
import services.ServiceCategorie;
import services.ServiceFormation;

 
/**
 * FXML Controller class
 *
 * @author Msi
 */
public class UseraddexamController implements Initializable {

    @FXML
    private ToggleGroup options;
    @FXML
    private TextField tfNomExamen;
    @FXML
    private TextField tfPourcentageExamen;
    @FXML
    private TextField tfDureeExamen;
    @FXML
    private TableView<Categorie> tvCategories;
    @FXML
    private TableView<Formation> tvFormations;
    @FXML
    private TextField lboption1;
    @FXML
    private TextField lboption3;
    @FXML
    private TextField lboption2;
    @FXML
    private RadioButton option1;
    @FXML
    private RadioButton option2;
    @FXML
    private RadioButton option3;
    @FXML
    private TextField lbEnnonce;
    @FXML
    private TableColumn<Categorie, String> colNomCategorie;
    @FXML
    private TableColumn<Formation, String> colSujetFormation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        radioButtonSetup();
        showcategorie() ;
        showformation() ;
        // TODO
    }    
        private void radioButtonSetup(){
        options = new ToggleGroup();
        option1.setToggleGroup(options);
        option2.setToggleGroup(options);
        option3.setToggleGroup(options);
     }
    

    @FXML
    private void backtommain(ActionEvent event) throws IOException {
     Stage stage ;
    Parent root = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    Scene scene=new Scene(root);
    stage.setScene(scene);
    stage.show();
     }

    @FXML
    private void ajuoterExamen(ActionEvent event) {
                if(tfNomExamen.getText().trim().isEmpty()){
            Notifications.create()
                    .darkStyle()
                    .position(Pos.CENTER)
                     .text("Enter valid Exam Title")
                    .title("Exam Title").showError();
        
             /*   
        if (tfNomExamen.getText().trim().equals(""))  
                    JOptionPane.showMessageDialog(null," Veuillez remplir le champs nom examen ! ");
        if (tfPourcentageExamen.getText().trim().isEmpty())  
                    JOptionPane.showMessageDialog(null," Veuillez remplir le champs pourcentage ! ");
        if (tfDureeExamen.getText().trim().isEmpty())  
                    JOptionPane.showMessageDialog(null," Veuillez remplir le champs durée examen ! ");
 
        */
        
        
        
        
        
       
        ExamenService  SE = new ExamenService() ;
           Formation f =  tvFormations.getSelectionModel().getSelectedItem() ;
           Categorie c =  tvCategories.getSelectionModel().getSelectedItem() ; 
           Examen newExam = new Examen(  tfNomExamen.getText()  ,   Double.parseDouble(tfPourcentageExamen.getText())     , Integer.parseInt(tfDureeExamen.getText() )    , f.getIdFormation() , c.getIdCategorie()   ) ; 
           SE.ajouter(newExam);
            JOptionPane.showMessageDialog(null,"examen Ajoutée ! ");
        
 
            
            
            
 
        
        
        
        
        
        
        
    }
    }

    @FXML
    private void addNextQuestion(ActionEvent event) {
    }

    @FXML
     public void submitExam(ActionEvent event) {
    }
    
            public void showcategorie(){
            ServiceCategorie SC = new ServiceCategorie() ;
        ObservableList<Categorie> ListCat =  SC.afficher() ; 
        colNomCategorie.setCellValueFactory(new PropertyValueFactory<Categorie,String>("nomCategorie"));
        tvCategories.setItems(ListCat);
    }
        
        public void showformation(){
        ServiceFormation SF = new ServiceFormation() ;
        ObservableList<Formation> ListCat =  SF.afficher() ; 
        colSujetFormation.setCellValueFactory(new PropertyValueFactory<Formation,String>("Sujet"));
        tvFormations.setItems(ListCat);

    }


 
    
}
