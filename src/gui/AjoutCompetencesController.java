/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import entites.Competences;
import java.io.IOException;
import services.ServiceCompetences;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import utiles.DataDB;
import javafx.scene.control.cell.PropertyValueFactory ;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AjoutCompetencesController implements Initializable {

    @FXML
    private TextField tfnomComp;
    @FXML
    private Button btAjout;
    @FXML
    private Button btmodif;
    @FXML
    private Button btsupprimer;
    @FXML
    private TableView<Competences> tabcomp;
    @FXML
    private TableColumn<Competences, Long> colidcomp;
    @FXML
    private TableColumn<Competences, String> colnomcomp;
    Connection cnx = DataDB.getInstance().getCnx();
    @FXML
    private Button btret;
    @FXML
    private Button btenregistrcomp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showcompetences();
        // TODO
    }    

    @FXML
    private void ajoutcomp(ActionEvent event) {
        ServiceCompetences sp = new ServiceCompetences();
        System.out.println("1");
        //Categorie C = new Categorie();
        System.out.println("2");
        //C.setNomCategorie(tfNomC.getText());
        //System.out.println("3");
        //sp.ajouter_categorie(new Competenecs(tfNomC.getText()));
        Competences Comp = new Competences ();
        System.out.println("object  competence Created");
        String oldValue = tfnomComp.getText();
        if(tfnomComp.getText().trim().equals(""))
            JOptionPane.showMessageDialog(null," Veuillez remplir le champs nom Competence ! ");
        else{
        //int numSms = Integer.parseInt(oldValue);
        try {
            
            
            
                        int numSms = Integer.parseInt(oldValue);
			System.out.println("le nom de Competence ");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Nom Competence Erreur");
                        alert.setHeaderText(null);
                        alert.setContentText("La competence saisie n'a pas un format valide ");
                        alert.showAndWait();
		} catch (NumberFormatException e){
                        Comp.setNomCompetence(tfnomComp.getText());
                        sp.ajouter_competence(Comp);
                        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setContentText("La Competence est ajouté avec succé");
                        alert.showAndWait();
                        showcompetences();

                        tfnomComp.setText("");
                    
			System.out.println("La chaine contient au moins un caractère");
		}
        
    }
    }

    @FXML
    private void modifcomp(ActionEvent event) {
        if(tabcomp.getSelectionModel().getSelectedItem()!=null) {
             Competences C =tabcomp.getSelectionModel().getSelectedItem();
             tfnomComp.setText(C.getNomCompetence());
        }
    }

    @FXML
    private void supprimercat(ActionEvent event) {
        Competences Comp =tabcomp.getSelectionModel().getSelectedItem();
        ServiceCompetences sp = new ServiceCompetences();
        System.out.println("1");
        sp.supprimer_competence(Comp);
        JOptionPane.showMessageDialog(null,"Competence Modifiée ! ");
        showcompetences();
    }
    
    public void showcompetences(){
        ServiceCompetences Scomp = new ServiceCompetences();
        ObservableList<Competences> ListCat =  Scomp.afficher() ; 
        System.out.println("pas de probleme");
        
        colnomcomp.setCellValueFactory(new PropertyValueFactory<Competences,String>("nomCompetence"));
        //colidC.setCellValueFactory(new PropertyValueFactory<Categorie,Long>("idCategorie"));
        
        System.out.println("Pas de Soucis ");
        tabcomp.setItems(ListCat);
        System.out.println("pas de probleme2");
        
        
    }

    @FXML
    private void retourcomp(ActionEvent event) throws IOException {
        Stage stage ;
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void enregistermodif(ActionEvent event) {
        Competences Comp =tabcomp.getSelectionModel().getSelectedItem();
        ServiceCompetences sp = new ServiceCompetences();
        System.out.println("1");
         Comp.setNomCompetence(tfnomComp.getText());
         sp.modifier_competence(Comp);
         System.out.println("ok ");
        JOptionPane.showMessageDialog(null,"Competence Modifiée ! ");
        showcompetences();
        tfnomComp.setText("");
        
    }
    
}
