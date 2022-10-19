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
    private void ajuoterExamen(ActionEvent event) {
        
        
        if (tfNomExamen.getText().trim().equals(""))  
                    JOptionPane.showMessageDialog(null," Veuillez remplir le champs nom examen ! ");
        if (tfPourcentageExamen.getText().trim().isEmpty())  
                    JOptionPane.showMessageDialog(null," Veuillez remplir le champs pourcentage ! ");
        if (tfDureeExamen.getText().trim().isEmpty())  
                    JOptionPane.showMessageDialog(null," Veuillez remplir le champs durée examen ! ");
 
        
        
        
        
        
        
       
        ExamenService  SE = new ExamenService() ;
           Formation f =  tvFormations.getSelectionModel().getSelectedItem() ;
           Categorie c =  tvCategories.getSelectionModel().getSelectedItem() ; 
           
        SE.ajouter(new Examen(  tfNomExamen.getText()  ,   Double.parseDouble(tfPourcentageExamen.getText())     , Integer.parseInt(tfDureeExamen.getText() )    , f.getIdFormation() , c.getIdCategorie()   ));
        showExams() ;
        JOptionPane.showMessageDialog(null,"examen Ajoutée ! ");
        
        
        //redirection vers l'interface thenya 
        /*
        FXMLLoader loader = new FXMLLoader(getClass().getResource("detailPersonne.fxml")) ;
        Parent root = loader.load() ; 
        tfNomExamen.getScene().setRoot(root);
        */
        
 
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
    
    
    
    /*
        public  ObservableList<Examen> afficher() {
                   ObservableList<Examen>  listExamen =  FXCollections.observableArrayList() ;
                       Connection cnx ; 
                       cnx = MyDB.getInstance().getCnx();
            try {
                String req = "select * from Examen" ;
                PreparedStatement st = cnx.prepareStatement(req) ; 
                 ResultSet rs = st.executeQuery(req) ;
 
                
                            while (rs.next()) {
                listExamen.add(new Examen( rs.getLong("idExamen"),rs.getString("nomExamen"), rs.getDouble("pourcentage"), rs.getInt("DureeExamen")));
            }    
            } catch (SQLException ex) {
                System.out.println("error occured" +ex.getMessage());  
            }
              return listExamen ;
     }
    
    */
    

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
    }
        
            public void showformation(){
         ServiceFormation SF = new ServiceFormation() ;
        ObservableList<Formation> ListCat =  SF.afficher() ; 
        colSujetFormation.setCellValueFactory(new PropertyValueFactory<Formation,String>("Sujet"));
        tvFormations.setItems(ListCat);

    }
        
    
    
    
    
    
}
