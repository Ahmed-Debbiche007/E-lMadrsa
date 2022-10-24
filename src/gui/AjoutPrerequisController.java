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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import utiles.DataDB;
import javafx.scene.control.cell.PropertyValueFactory ;
import javax.swing.JOptionPane;
import entites.Prerequis;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.ServicePrerequis;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AjoutPrerequisController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private Button btajout;
    @FXML
    private Button btmodif;
    @FXML
    private Button btsupprimer;
    @FXML
    private TableView<Prerequis> tab;
    @FXML
    private TableColumn<Prerequis, Long> colid;
    @FXML
    private TableColumn<Prerequis, String> colnom;
    Connection cnx = DataDB.getInstance().getCnx();
    @FXML
    private Button idretour;
    @FXML
    private Button btenr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showprerequis();
        // TODO
    }    

    @FXML
    private void ajoutprerequis(ActionEvent event) {
        ServicePrerequis spP= new ServicePrerequis();
        System.out.println("Service prerequis Created");
        Prerequis P = new Prerequis();
        System.out.println("object  prerequis Created");
        P.setNomPrerequis(tfnom.getText());
        spP.ajouter_Prerequis(P);
        JOptionPane.showMessageDialog(null,"Prerequis Ajoutée ! ");
        showprerequis();
        
    }

    @FXML
    private void modifprerequis(ActionEvent event) {
        if(tab.getSelectionModel().getSelectedItem()!=null) {
             Prerequis P =tab.getSelectionModel().getSelectedItem();
             tfnom.setText(P.getNomPrerequis());
        }
    }

    @FXML
    private void supprimerprerequis(ActionEvent event) {
        Prerequis P =tab.getSelectionModel().getSelectedItem();
        ServicePrerequis spPM= new ServicePrerequis();
        System.out.println("Service prerequis Created");
        spPM.supprimer_prerequis(P);
        JOptionPane.showMessageDialog(null,"Prerequis Supprimée ! ");
        showprerequis();
        
        
    }
     public ObservableList<Prerequis> afficher() {
        System.out.println("1");
        ObservableList<Prerequis> list = FXCollections.observableArrayList();

        try {
            String requete = "SELECT idPrerequis,nomPrerequis FROM Prerequis ";
            Statement st = cnx.createStatement();
           
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()) {
                list.add(new Prerequis(rs.getLong(1),rs.getString(2)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
     public void showprerequis(){
        ObservableList<Prerequis> ListCat =  afficher() ; 
        System.out.println("pas de probleme");
        
        colnom.setCellValueFactory(new PropertyValueFactory<Prerequis,String>("nomPrerequis"));
        //colidC.setCellValueFactory(new PropertyValueFactory<Categorie,Long>("idCategorie"));
        
        System.out.println("Pas de Soucis ");
        tab.setItems(ListCat);
        System.out.println("pas de probleme2");
        
        
    }

    @FXML
    private void retourprerequis(ActionEvent event) throws IOException {
        Stage stage ;
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void enregistpre(ActionEvent event) {
        Prerequis P =tab.getSelectionModel().getSelectedItem();
        ServicePrerequis spPM= new ServicePrerequis();
        System.out.println("Service prerequis Created");
        
        System.out.println("object  prerequis Created");
        P.setNomPrerequis(tfnom.getText());
        spPM.modifier_prerequise(P);
        JOptionPane.showMessageDialog(null,"Prerequis Modifiée ! ");
        showprerequis();
        tfnom.setText("");
    }
    
}
