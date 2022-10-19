/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entites.Categorie;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javax.swing.JOptionPane;
import services.ServiceCategorie;
import gui.AfficheCategorieController;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import utiles.DataDB;
import javafx.scene.control.cell.PropertyValueFactory ; 
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author User
 */
public class AjoutCategorieController implements Initializable {
    @FXML
    private TextField tfNomC ;
    @FXML
    private Button btAjoutC; 
    @FXML
    private Button btmodif; 
    @FXML
    private Button btsupp; 
    @FXML
    private TableView<Categorie> TabCategorie; 
    @FXML
    private TableColumn<Categorie,String> ColNomC;
    @FXML
    private TableColumn<Categorie,Long> colidC;
    Connection cnx = DataDB.getInstance().getCnx();
    @FXML
    private Button btretour;
    
    
    

    
    /*private void ajoutercategorie(ActionEvent event) throws IOException{
            ServiceCategorie sp = new ServiceCategorie();
            Categorie C = new Categorie();
            C.setNomCategorie(tfNomC.getText());
            sp.ajouter_categorie(C);//la méthode getText() retourne toujours une chaine de caractère 
            JOptionPane.showMessageDialog(null,"Categorie Ajoutée !");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficheCategorie.fxml"));
            Parent root = loader.load();
            tfNomC.getScene().setRoot(root);
            AfficheCategorieController auc = loader.getController();
            auc.setLabelcategorie(tfNomC.getText());*/
     
           
    //}//
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("work");
        showcategorie();
        
        
    
       
        
        
        // TODO@FXML
    
    }    
    /*private void ajoutercategorie(ActionEvent event) throws IOException{
            ServiceCategorie sp = new ServiceCategorie();
            Categorie C = new Categorie();
            C.setNomCategorie(tfNomC.getText());
            sp.ajouter_categorie(C);//la méthode getText() retourne toujours une chaine de caractère 
            JOptionPane.showMessageDialog(null,"Categorie Ajoutée !");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjoutCategorie.fxml"));
            Parent root = loader.load();
            tfNomC.getScene().setRoot(root);
    }*/ 

    @FXML
    private void modifcategorie(ActionEvent event) {
        Categorie C =TabCategorie.getSelectionModel().getSelectedItem();
        ServiceCategorie sp = new ServiceCategorie();
        System.out.println("1");
        //Categorie C = new Categorie();
        System.out.println("2");
        C.setNomCategorie(tfNomC.getText());
        
        System.out.println("3");
        sp.modifier_categorie(C);
        System.out.println("ok ");
        JOptionPane.showMessageDialog(null,"Categorie modifié ! ");
        showcategorie();
        
    }
    /*@FXML
    private void modifierQuestion(ActionEvent event) {
        Question q = tvQuestion.getSelectionModel().getSelectedItem();
        QuestionService  QE = new QuestionService() ;
        QE.modifier(new Question(q.getIdQuestion(),lbEnnonce.getText()));
        JOptionPane.showMessageDialog(null,"Question modifié ! ");
        showQuestions() ;
    }*/

    @FXML
    private void ajoutcat(ActionEvent event) {
        ServiceCategorie sp = new ServiceCategorie();
        System.out.println("1");
        //Categorie C = new Categorie();
        System.out.println("2");
        //C.setNomCategorie(tfNomC.getText());
        System.out.println("3");
        String oldValue = tfNomC.getText();
        if(tfNomC.getText().trim().equals(""))
            JOptionPane.showMessageDialog(null," Veuillez remplir le champs nom formation ! ");
        else{
        //int numSms = Integer.parseInt(oldValue);
        try {
            
            
            
                        int numSms = Integer.parseInt(oldValue);
			System.out.println("La chaine correspond à un numéro de SMS");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Nom Categorie Erreur");
                        alert.setHeaderText(null);
                        alert.setContentText("la Categorie saisie n'a pas un format valide ");
                        alert.showAndWait();
		} catch (NumberFormatException e){
                        sp.ajouter_categorie(new Categorie(tfNomC.getText()));
                        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setContentText("La categorie est ajouté avec succé");
                        alert.showAndWait();
                        showcategorie();
                    
			System.out.println("La chaine contient au moins un caractère");
		}
        
        /*if (!oldValue.matches(("[a-z]"))&& oldValue.matches(("[0-9]"))){
            sp.ajouter_categorie(new Categorie(tfNomC.getText()));
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("La categorie est ajouté avec succé");
            alert.showAndWait();
            showcategorie();

            }
        else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Nom Categorie Erreur");
                alert.setHeaderText(null);
                alert.setContentText("la Categorie saisie n'a pas un format valide ");
                alert.showAndWait();
            }*/
        //sp.ajouter_categorie(new Categorie(tfNomC.getText()));
        System.out.println("ok ");
        //JOptionPane.showMessageDialog(null,"Categorie Ajoutée ! ");
        //showcategorie();
            
        
    }
    }

    @FXML
    private void supprimercat(ActionEvent event) {
        Categorie C =TabCategorie.getSelectionModel().getSelectedItem();
        ServiceCategorie sp = new ServiceCategorie();
        System.out.println("1");
        sp.supprimer_categorie(C);
        System.out.println("ok ");
        JOptionPane.showMessageDialog(null,"Categorie Supprimée ! ");
        showcategorie();
    }
    public ObservableList<Categorie> afficher() {
        System.out.println("1");
        ObservableList<Categorie> list = FXCollections.observableArrayList();

        try {
            String requete = "SELECT idCategorie,nomCategorie FROM Categorie ";
           Statement st = cnx.createStatement();
           
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()) {
                list.add(new Categorie(rs.getLong(1),rs.getString(2)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    public void showcategorie(){
        ObservableList<Categorie> ListCat =  afficher() ; 
        System.out.println("pas de probleme");
        
        ColNomC.setCellValueFactory(new PropertyValueFactory<Categorie,String>("nomCategorie"));
        //colidC.setCellValueFactory(new PropertyValueFactory<Categorie,Long>("idCategorie"));
        
        System.out.println("Pas de Soucis ");
        TabCategorie.setItems(ListCat);
        System.out.println("pas de probleme2");
        
        
    }

    @FXML
    private void retourcat(ActionEvent event) throws IOException {
        Stage stage ;
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
