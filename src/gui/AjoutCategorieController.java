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
import entites.Formation;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import services.ServiceFormation;


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
    @FXML
    private Button btenregistrer;
    @FXML
    private Button btchercherformation;
    @FXML
    private TableView<Formation> tabformationcat;
    @FXML
    private TableColumn<Formation, String> colnomformation;
    
    
    

    
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("work");
        showcategorie();
        //String ch1= filtrer();
        //System.out.println(ch1);
        
        
    
       
        
        
        // TODO@FXML
    
    }    
    

    @FXML
    private void modifcategorie(ActionEvent event) {
        if(TabCategorie.getSelectionModel().getSelectedItem()!=null) {
             Categorie C =TabCategorie.getSelectionModel().getSelectedItem();
             tfNomC.setText(C.getNomCategorie());
        }
        
        
    }
    

    @FXML
    private void ajoutcat(ActionEvent event) {
        ServiceCategorie sp = new ServiceCategorie();
        System.out.println("1");
        //Categorie C = new Categorie();
        System.out.println("2");
        //C.setNomCategorie(tfNomC.getText());
        System.out.println("3");
        String oldValue = tfNomC.getText();
        if(tfNomC.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null," Veuillez remplir le champs nom Categorie ! ");
            }
        if(sp.VerifUninciteCategorie(tfNomC.getText().trim())!=null){
            JOptionPane.showMessageDialog(null," Cette Catégorie existe déjà  ! ");
            
        }
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
                        tfNomC.setText("");
                    
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
    
    public void showcategorie(){

        ServiceCategorie SC = new ServiceCategorie();
        ObservableList<Categorie> ListCat = SC.afficher() ; 

        
        
         
    

        
        ColNomC.setCellValueFactory(new PropertyValueFactory<Categorie,String>("nomCategorie"));
        //colidC.setCellValueFactory(new PropertyValueFactory<Categorie,Long>("idCategorie"));
        
        
        TabCategorie.setItems(ListCat);
        
        
        
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

    @FXML
    private void enregistrercategorie(ActionEvent event) {
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
        tfNomC.setText("");
        
        
    }
    

    @FXML
    private void chercherformation(ActionEvent event) {
         ServiceCategorie SC = new ServiceCategorie();
         ServiceFormation SF = new ServiceFormation();
         ObservableList<Categorie> ListCat1 =  SC.afficher() ;
          ObservableList<Formation> ListCat =  SF.afficher_catformation () ;
          
          int i,j,i1 =0;
          Boolean test = false;
        /*Predicate<String> predicate = new Predicate<String>() {
            
            public boolean delegate(String value) {
                return value.matches(".+rice");
            }
        };
         ilteredObservableList<String> filteredList= createFilter(ListCat1, predicate);*/
        
        String ch= ListCat1.get(0).getNomCategorie();
        String ch1= "";
        i1=ListCat1.size();
        i=ListCat.size();
        List  l =ListCat1;
        Long m= Long.MIN_VALUE;
        Long m1 = Long.MIN_VALUE;
        
        for(j=0;j<i;j++){
            String join=ListCat.get(j).getSujet();
            System.out.println(join);
        }
        for(j=0;j<i1;j++){
            
            ch1= ListCat1.get(j).getNomCategorie();
            
            
            if(ch1.equals(tfNomC.getText())){
                 test =true;
                System.out.println("true");
                m=ListCat1.get(j).getIdCategorie();
                ch1= ListCat1.get(j).getNomCategorie();
                System.out.println(m);
                System.out.println(ch1);
            }
                
                
                
                
                
           }
        if (test==false){
            JOptionPane.showMessageDialog(null," Pas des Formations dans cette catégorie ! ");
            
        }
        else {
            
            while(j<=ListCat.size()){
                
                m1=ListCat.get(j).getIdCategorie();
                System.out.println(m1);
                
                if(m1!=m){
                    ListCat.remove(j)       ;
                    j++;
                    
                    
                }
            }
       
            System.out.println(ListCat.size());
            colnomformation.setCellValueFactory(new PropertyValueFactory<Formation,String>("sujet"));
            //colidC.setCellValueFactory(new PropertyValueFactory<Categorie,Long>("idCategorie"));
        
        System.out.println("Pas de Soucis ");
       tabformationcat.setItems(ListCat);
        }
            
            
            
            
       
          
    }
    public String filtrer(){
         ServiceCategorie SC = new ServiceCategorie();
         ServiceFormation SF = new ServiceFormation();
         ObservableList<Categorie> ListCat1 =  SC.afficher() ;
          ObservableList<Formation> ListCat =  SF.afficher_catformation () ;
          
          int i,j,i1,n =0;
        /*Predicate<String> predicate = new Predicate<String>() {
            
            public boolean delegate(String value) {
                return value.matches(".+rice");
            }
        };
         ilteredObservableList<String> filteredList= createFilter(ListCat1, predicate);*/
        
        String ch= ListCat1.get(0).getNomCategorie();
        String ch1= "";
        i1=ListCat1.size();
        i=ListCat.size();
        
        List  l =ListCat1;
        Long m= Long.MIN_VALUE;
        Long m1 = Long.MIN_VALUE;
        //j=l.size();
        /*System.out.println(l.get(0));
        System.out.println(l.get(1));
        System.out.println(l.get(2));
        System.out.println(l.size());
        System.out.println(i);*/
        
        
        
        
       /* for (i=0;i<j;i++) {
            /*HashMap<Integer, String> map=(HashMap<Integer, String>) l.get(i);
             for (Map.Entry m : map.entrySet()) {
            System.out.println("ID: "+m.getKey()+", Nom: "+m.getValue());
            l.get(i).toString();
        }*/ 
        for(j=0;j<i1;j++){
            ch1= ListCat1.get(j).getNomCategorie();
            System.out.println(ch1);
            if(ch1==tfNomC.getText()){
                m=ListCat1.get(j).getIdCategorie();
                n++;
                
                
                
                
            }
            for(j=0;j<i;j++){
                m1=ListCat.get(j).getIdCategorie();
                if(m1!=m){
                    ListCat.remove(j);
                    
                }
            }
            colnomformation.setCellValueFactory(new PropertyValueFactory<Formation,String>("sujet"));
        //colidC.setCellValueFactory(new PropertyValueFactory<Categorie,Long>("idCategorie"));
        
        System.out.println("Pas de Soucis ");
       tabformationcat.setItems(ListCat);
            
            
            
            
        }
            
            
       
        return ch ;
       
        
    }
    
    
}

