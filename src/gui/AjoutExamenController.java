/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entites.Categorie;
import entites.Formation;
import entites.difficulté;
import entities.Examen;
 import java.io.IOException;
 import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
 import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
 import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
 import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
 import javax.swing.JOptionPane;
import outils.MyDB;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;

import services.ExamenService;
import services.ServiceCategorie;
import services.ServiceFormation;
 
/**
 * FXML Controller class
 *
 * @author Msi
 */
public class AjoutExamenController implements Initializable {

    @FXML
    private TextField tfNomExamen;
    @FXML
    private TextField tfPourcentageExamen;
    @FXML
    private TextField tfDureeExamen;
    @FXML
    private TableView<Examen> tvExamens;
    @FXML
    private TableColumn<Examen, String> colNomExamen;
    @FXML
    private TableColumn<Examen, Double> colPourcentageExamen;
    @FXML
    private TableColumn<Examen, Integer> colDureeExamen;
    @FXML
    private TableView<Formation> tvFormations;
    @FXML
    private TableColumn<Formation, String> colSujetFormation;
    @FXML
    private TableView<Categorie> tvCategories;
    @FXML
    private TableColumn<Categorie, String> colNomCategorie;
    @FXML
    private TableColumn<Examen,Long > colFormationex;
    @FXML
    private TableColumn<Examen,Long > colCategorieex;

    /**
     * Initializes the controller class.
     */
    
 
    
    
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        showExams() ;
        showcategorie() ;
        showformation() ;
         // TODO
    }    

    @FXML
    private void ajuoterExamen(ActionEvent event) throws IOException {
        
        
        if (tfNomExamen.getText().trim().equals("") ||
                (tfPourcentageExamen.getText().trim().isEmpty()||
                tfDureeExamen.getText().trim().isEmpty()))  
                     {
                     Notifications.create()
                    .darkStyle()
                    .position(Pos.CENTER)
                    .text("tout les champs doivent être remplis")
                    .title("Exam Title").showError();
                     }     
        else  {
 
 
            
 
 
       
        ExamenService  SE = new ExamenService() ;
            if(SE.countExams(tfNomExamen.getText().trim())!=null)
                {
                     Notifications.create()
                    .darkStyle()
                    .position(Pos.CENTER)
                    .text("this exam name already exist")
                    .title("Exam Title").showError();
                }        
       
           Formation f =  tvFormations.getSelectionModel().getSelectedItem() ;
           Categorie c =  tvCategories.getSelectionModel().getSelectedItem() ; 
           Examen newExam = new Examen(  tfNomExamen.getText()  ,   Double.parseDouble(tfPourcentageExamen.getText())     , Integer.parseInt(tfDureeExamen.getText() )    , f.getIdFormation() , c.getIdCategorie()   ) ; 
           SE.ajouter(newExam);
                                Notifications.create()
                    .darkStyle()
                    .position(Pos.CENTER)
                    .text("Examen ajouté avec succée")
                    .title("Exam Title").showInformation();
           showExams() ;
           //JOptionPane.showMessageDialog(null,"examen Ajoutée ! ");
        
 
        
        }
 
    }

    @FXML
    private void modifierExamen(ActionEvent event) {
        

      
        
        
        Examen e = tvExamens.getSelectionModel().getSelectedItem();
        //System.out.println(" ***********"  + e);  
        ExamenService  SE = new ExamenService() ;
        SE.modifier(new Examen( e.getIdExamen(),  tfNomExamen.getText()  ,   Double.parseDouble(tfPourcentageExamen.getText())     , Integer.parseInt(tfDureeExamen.getText())      ));
        JOptionPane.showMessageDialog(null,"examen modifié ! ");
        showExams() ;
     }
    
    
    
 
    

    @FXML
    private void supprimerExamen(ActionEvent event) {
        Examen e = tvExamens.getSelectionModel().getSelectedItem();
        //System.out.println(" ***********"  + e);  
        ExamenService  SE = new ExamenService() ;
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation supp ");
        alert.setHeaderText("Confirmation suppression Examen intitulé : " + e.getNomExamen());
        alert.setContentText("Avec confirmation cet examen va être supprimé d'un manière difinitive");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        SE.supprimer(e);
        JOptionPane.showMessageDialog(null,"examen supprimé ! ");
        showExams() ;
        alert.hide();
         } else {
            alert.hide();
        }
        
        

    }
    
      public void showExams() {
        ExamenService SE = new ExamenService() ; 
        ObservableList<Examen> list = SE.afficher() ;
        System.out.println(list ) ; 
        colNomExamen.setCellValueFactory(new PropertyValueFactory<Examen,String>("nomExamen"));
        colPourcentageExamen.setCellValueFactory(new PropertyValueFactory<Examen,Double>("Pourcentage"));
        colDureeExamen.setCellValueFactory(new PropertyValueFactory<Examen,Integer>("DureeExamen"));
        colFormationex.setCellValueFactory(new PropertyValueFactory<Examen,Long>("nomFor"));
        colCategorieex.setCellValueFactory(new PropertyValueFactory<Examen,Long>("nomCat"));
        
        System.out.println("///////////////////////" + list); 
 
        System.out.println(list); 
        list.forEach((e)->{
            ServiceCategorie es = new ServiceCategorie() ; 

                });
        System.out.println(list);

        tvExamens.setItems(list);
        
         
        
        
    }

    @FXML
    private void BackToMain(ActionEvent event) throws IOException {
    Stage stage ;
    Parent root = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    Scene scene=new Scene(root);
    stage.setScene(scene);
    stage.show();
    }

    
    
 

    @FXML
    private void editExam(ActionEvent event) {
                     if(tvExamens.getSelectionModel().getSelectedItem()!=null) {
             Examen t = tvExamens.getSelectionModel().getSelectedItem();
             tfNomExamen.setText(t.getNomExamen());
             tfPourcentageExamen.setText(t.getPourcentage().toString());
             tfDureeExamen.setText(Integer.toString(t.getDureeExamen()));
               
    }                
    }
    
    
        public void showcategorie(){
            ServiceCategorie SC = new ServiceCategorie() ;
        ObservableList<Categorie> ListCat =  SC.afficher() ; 
        colNomCategorie.setCellValueFactory(new PropertyValueFactory<Categorie,String>("nomCategorie"));
        tvCategories.setItems(ListCat);
        System.out.print("*****" + ListCat);  
    }
        
        public void showformation(){
        ServiceFormation SF = new ServiceFormation() ;
        ObservableList<Formation> ListCat =  SF.afficher() ; 
        colSujetFormation.setCellValueFactory(new PropertyValueFactory<Formation,String>("Sujet"));
        tvFormations.setItems(ListCat);
            System.out.print("*****" + ListCat);   
    }

    @FXML
    private void GOTOEXAM(ActionEvent event) {
        try {
            /*
            //redirection vers l'interface thenya
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("detailPersonne.fxml")) ;
            //Parent root = loader.load() ;
            Examen e = tvExamens.getSelectionModel().getSelectedItem() ;
            
            Node node = (Node) event.getSource();
            
            // Step 3
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            
            
            try {
            // Step 4
            
            
            
            Parent root = FXMLLoader.load(getClass().getResource("oneExamINterface.fxml"));
            
            
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("detailPersonne.fxml")) ;
            Parent root1 = loader.load() ;
            OneExamINterfaceController dpc = loader.getController();
            dpc.setExamName(e.getNomExamen());
            
            // Step 7
            stage.show();
            } catch (IOException ex) {
            System.err.println(String.format("Errorffffffffffffffffffffffffffff: %s", ex.getMessage()));
            }
            */
            
            
            
            
            
            
            // Step 1
            Examen e = tvExamens.getSelectionModel().getSelectedItem() ;   Node node = (Node) event.getSource();
            
            
            // Step 2
            System.out.print("dddddddddddddddddddddddddddddddddddddddddddddddddddd");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("oneExamINterface.fxml"));
            System.out.print("tttttttttttttttttt");
            Parent root = loader.load() ;
            tvExamens.getScene().setRoot(root);
            
            
            // Step 3
            OneExamINterfaceController controller =  loader.getController();
            System.out.println(e.getNomExamen());
            controller.setExamName(e.getNomExamen());
        } catch (IOException ex) {
            System.out.print("hahahahahhahahahhaha");        }
 
 
        
        
       
    }

    @FXML
    private void createQuestionGUI(ActionEvent event) throws IOException {
        
        
                    
            //  charger le new exam created 
            Examen e = tvExamens.getSelectionModel().getSelectedItem() ;
            Node node = (Node) event.getSource();
            // go to the next interface : create questions 
            FXMLLoader loader = new FXMLLoader(getClass().getResource("oneExamINterface.fxml"));
            Parent root = loader.load() ;
            tvExamens.getScene().setRoot(root);
            // Step 3
            OneExamINterfaceController controller =  loader.getController();
            System.out.println(e.getNomExamen());
            controller.setExamName(e.getNomExamen());
 
        
        
    }
        
    
    
    
    
    
}
