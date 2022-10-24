/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entites.Categorie;
import entites.Prerequis;
import entites.Competences;
import entites.Categorie;
import entites.Examen;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import entites.Formation;

import services.ServiceFormation;
import services.ServiceCompetences;
import services.ServicePrerequis;
import services.ServiceCategorie;
import services.ServiceExamen;
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
import entites.difficulté;
import java.io.IOException;
import java.sql.PreparedStatement;
import static java.util.Arrays.equals;
import static java.util.Arrays.equals;
import static java.util.Arrays.equals;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AjoutFormationController implements Initializable {

    @FXML
    private CheckBox checkFacile;
    @FXML
    private CheckBox checkMoyen;
    @FXML
    private CheckBox checkDifficile;
    @FXML
    private TextField tfSujet;
    @FXML
    private TextField tfDescription;
    @FXML
    private TextField tfDuree;
    @FXML
    private Button btAjout;
    @FXML
    private Button btsupprimer;
    @FXML
    private Button btmodif;
    @FXML
    private TableView<Formation> tabFormation;
    @FXML
    private TableColumn<Formation, Long> colidformation;
    @FXML
    private TableColumn<Formation, String> colsujet;
    @FXML
    private TableColumn<Formation, String> coldescription;
    @FXML
    private TableColumn<Formation, String> coldiff;
    @FXML
    private TableColumn<Formation, Integer> colduree;
    @FXML
    private TableColumn<Formation, Long> colidPrerequis;
    @FXML
    private TableColumn<Formation, Long> colidCompetence;
    @FXML
    private TableColumn<Formation, Long> colidCategorie;
    @FXML
    private TableColumn<Formation, Long> colidExamen;
    Connection cnx = DataDB.getInstance().getCnx();
    @FXML
    private Button btretour;
    @FXML
    private Button btenregistrer;
    @FXML
    private TableColumn<Prerequis, Long> colidPreA;
    @FXML
    private TableColumn<Prerequis, String> colnomPrerequis;
    @FXML
    private TableColumn<Competences, Long> colidCompetenceA;
    @FXML
    private TableColumn<Competences, String> colnomComp;
    @FXML
    private TableView<Prerequis> tabPre;
    @FXML
    private TableView<Competences> tabcomp;
    @FXML
    private TableView<Categorie> tabCat;
    @FXML
    private TableColumn<Categorie,Long> colidCat;
    @FXML
    private TableColumn<Categorie, String> colnomCat;
    @FXML
    private TableView<Examen> tabExam;
    @FXML
    private TableColumn<Examen, Long> colidexamen;
    @FXML
    private TableColumn<Examen, String> colnomExamen;
    private TableColumn<Formation, String> colcat;
    private TableColumn<Formation, String> colcomp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showformation();
        showcompetences();
         showprerequis();
         showcategorie();
         showcExamen();
        // TODO
    }    
    


    @FXML
    private void ajoutformation(ActionEvent event) {
        ServiceFormation sp = new ServiceFormation();
        System.out.println("création d'un objet Service Formation SUCCED");
        
        Formation F= new Formation();
        
        System.out.println(" objet Formation created SUCCED");
        
        if(tfSujet.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null," Attention, Veuillez remplir le champs Sujet ! ");
         }
        
        if(sp.VerifUninciteFormation(tfSujet.getText().trim())!=null){
            JOptionPane.showMessageDialog(null," Ce Sujet de formation Existe déjà  ! ");
            
            
        }
        else{
        Prerequis P = tabPre.getSelectionModel().getSelectedItem() ;
        Competences Comp = tabcomp.getSelectionModel().getSelectedItem() ;
        Examen E = tabExam.getSelectionModel().getSelectedItem() ;
        Categorie C = tabCat.getSelectionModel().getSelectedItem() ;
        F.setSujet(tfSujet.getText());
        System.out.println(" 11");
        if(tfDescription.getText().trim().equals(""))
            JOptionPane.showMessageDialog(null," Attention, Veuillez remplir le champs Description ! ");
        else{
        
        F.setDescription(tfDescription.getText());
        
        System.out.println(" 12");
        if(checkFacile.isSelected()){
            F.setDifficulté("facile");
        }
        if (checkMoyen.isSelected()){
            F.setDifficulté("moyen");
        }
        if(checkDifficile.isSelected()){
            F.setDifficulté("difficile");
        }
        //F.setDifficulté(difficulté.DIFFICILE);
        System.out.println("13");
        if(tfDuree.getText().trim().equals(""))
            JOptionPane.showMessageDialog(null," Attention, Veuillez remplir le champs Durée ! ");
        
        int resultat = Integer.parseInt(tfDuree.getText());
        F.setDurée(resultat);
        System.out.println("14");
        F.setIdPrerequis(P.getIdPrerequis());
        System.out.println("15");
        F.setIdCompetence(Comp.getIdCompetence());
        System.out.println("16");
        F.setIdCategorie(C.getIdCategorie());
        System.out.println("17");
        F.setIdExamen(E.getIdExamen());
        System.out.println("18");
        sp.ajouter_formation(F);
        JOptionPane.showMessageDialog(null,"Formation Ajoutée! ");
         showformation();
         tfSujet.setText("");
         tfDescription.setText("");
         tfDuree.setText("");
         checkFacile.setSelected(false);
         checkMoyen.setSelected(false);
         checkDifficile.setSelected(false);
         
         
        
        }
        }
        
    }

    @FXML
    private void supprimerformation(ActionEvent event) { 
        
        
        Formation F =tabFormation.getSelectionModel().getSelectedItem();
        ServiceFormation sp = new ServiceFormation();
        sp.supprimer_formation(F);
        JOptionPane.showMessageDialog(null,"Formation Supprimée ! ");
        showformation();
    }

    @FXML
    private void modifformation(ActionEvent event) {
       if(tabFormation.getSelectionModel().getSelectedItem()!=null) {
             Formation F = tabFormation.getSelectionModel().getSelectedItem();
             

             tfDescription.setText(F.getDescription());
             tfSujet.setText(F.getSujet());
             if(F.getDifficulté()=="facile"){
                 checkFacile.setSelected(true);
                 checkMoyen.setSelected(false);
                 checkDifficile.setSelected(false);   
                 checkFacile.setIndeterminate(true);
                 checkMoyen.setIndeterminate(true);
                 checkDifficile.setIndeterminate(true);
                 
             }
             if(F.getDifficulté()=="Moyen"){
                 checkFacile.setSelected(false);
                 checkMoyen.setSelected(true);
                 checkDifficile.setSelected(false);   
                 checkFacile.setIndeterminate(true);
                 checkMoyen.setIndeterminate(true);
                 checkDifficile.setIndeterminate(true);
             }
             if(F.getDifficulté()=="difficile"){
                 checkFacile.setSelected(false);
                 checkMoyen.setSelected(false);
                 checkDifficile.setSelected(true);
                 checkFacile.setIndeterminate(true);
                 checkMoyen.setIndeterminate(true);
                 checkDifficile.setIndeterminate(true);
             }
             tfDuree.setText(""+F.getDurée());
             
       
    }
    }
    public ObservableList<Formation> afficher() {
        System.out.println("1");
        ObservableList<Formation> list = FXCollections.observableArrayList();
       
        
        

         try {
            String requete = "SELECT * FROM formation JOIN categorie ON formation.idCategorie=categorie.idCategorie JOIN competences On formation.idCompetence= competences.idCompetence JOIN prerequis ON formation.idPrerequis=prerequis.idPrerequis JOIN examen ON examen.idExamen=formation.idExamen;";
            PreparedStatement st = cnx.prepareStatement(requete) ;
            ResultSet rs = st.executeQuery(requete);
            difficulté dif [] = difficulté.values();
            System.out.println(dif[0]);
            System.out.println(rs);
            while (rs.next()) {
               
                
             
                list.add(new Formation(rs.getLong("idFormation"), rs.getString("sujet"), rs.getString("description"),rs.getString("difficulté"),rs.getInt("durée"),rs.getLong("idPrerequis"),rs.getLong("idCompetence"),rs.getLong("idExamen"),rs.getLong("idCategorie"),rs.getString("nomCategorie"),rs.getString("nomCompetence"),rs.getString("nomPrerequis"),rs.getString("nomExamen")));
                System.out.println("heeeeeeeeeeey" + list);
            
            
            }
            
            
            
            

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    public void showformation(){
        ObservableList<Formation> ListCat =  afficher() ; 
        //System.out.println("pas de probleme");
        Formation F = new Formation();
        System.out.println(ListCat.size());
        
        colidformation.setCellValueFactory(new PropertyValueFactory<Formation,Long>("idFormation"));
        colsujet.setCellValueFactory(new PropertyValueFactory<Formation,String>("Sujet"));
        coldescription.setCellValueFactory(new PropertyValueFactory<Formation,String>("Description"));
        coldiff.setCellValueFactory(new PropertyValueFactory<Formation,String>("Difficulté"));
        colduree.setCellValueFactory(new PropertyValueFactory<Formation,Integer>("durée"));
        
        colidCompetence.setCellValueFactory(new PropertyValueFactory<Formation,Long>("nomCompetence"));
        colidCategorie.setCellValueFactory(new PropertyValueFactory<Formation,Long>("nomCategorie"));
        colidPrerequis.setCellValueFactory(new PropertyValueFactory<Formation,Long>("nomPrerequis"));
        colidExamen.setCellValueFactory(new PropertyValueFactory<Formation,Long>("nomExamen"));
         
        ListCat.forEach((e)->{
            ServiceCategorie es = new ServiceCategorie() ; 
               // e.setNomCat(es.getById(e.getIdExamen()).getNomCategorie());
                //System.out.println(es.getById(e.getIdExamen()).getNomCategorie()) ; 
               //e.setNomFor(nomFor);
          
                });
        //colcat.setCellValueFactory(new PropertyValueFactory<Formation,String>("nomCategorie"));
         //System.out.println(ListCat);
        //colcomp.setCellValueFactory(new PropertyValueFactory<Formation,String>("nomCompetence"));
        //System.out.println("Pas de Soucis ");
        tabFormation.setItems(ListCat);
        //System.out.println("pas de probleme2");
        
        
        
        
        
        
        
        //colidC.setCellValueFactory(new PropertyValueFactory<Categorie,Long>("idCategorie"));
        
        //System.out.println("Pas de Soucis ");
        //tabFormation.setItems(ListCat);
        System.out.println("pas de probleme2");
        
        
    }

    @FXML
    private void retourformation(ActionEvent event) throws IOException {
        Stage stage ;
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void enregistrermodif(ActionEvent event) {
       Formation F =tabFormation.getSelectionModel().getSelectedItem();
       ServiceFormation sp = new ServiceFormation();
       System.out.println("création d'un objet Service Formation SUCCED");
       F.setSujet(tfSujet.getText());
       F.setDescription(tfDescription.getText());
        
        System.out.println(" 12");
        if(checkFacile.isSelected()){
            F.setDifficulté("facile");
        }
        if (checkMoyen.isSelected()){
            F.setDifficulté("moyen");
        }
        if(checkDifficile.isSelected()){
            F.setDifficulté("difficile");
        }
        //F.setDifficulté(difficulté.DIFFICILE);
        System.out.println("13");
        int resultat = Integer.parseInt(tfDuree.getText());
        F.setDurée(resultat);
        
        System.out.println("14");
        sp.modifier_formation(F);
        JOptionPane.showMessageDialog(null,"Formation Modifiée");
        showformation();
        tfSujet.setText("");
        tfDescription.setText("");
        tfDuree.setText("");
        
        
    }
     public ObservableList<Prerequis> afficher_Pre() {
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
        ObservableList<Prerequis> ListCat =  afficher_Pre() ; 
        System.out.println("pas de probleme");
        
        colnomPrerequis.setCellValueFactory(new PropertyValueFactory<Prerequis,String>("nomPrerequis"));
        //colidC.setCellValueFactory(new PropertyValueFactory<Categorie,Long>("idCategorie"));
        
        System.out.println("Pas de Soucis ");
        tabPre.setItems(ListCat);
        System.out.println("pas de probleme2");
        
        
    }
      public ObservableList<Competences> afficher_comp() {
        System.out.println("1");
        ObservableList<Competences> list = FXCollections.observableArrayList();

        try {
            String requete = "SELECT idCompetence,nomCompetence FROM Competences ";
            Statement st = cnx.createStatement();
           
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()) {
                list.add(new Competences(rs.getLong(1),rs.getString(2)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
       public void showcompetences(){
        ObservableList<Competences> ListCat =  afficher_comp() ; 
        //System.out.println("pas de probleme");
        
        colnomComp.setCellValueFactory(new PropertyValueFactory<Competences,String>("nomCompetence"));
        //colidC.setCellValueFactory(new PropertyValueFactory<Categorie,Long>("idCategorie"));
        
        //System.out.println("Pas de Soucis ");
        tabcomp.setItems(ListCat);
        //System.out.println("pas de probleme2");
        
        
    }
       public ObservableList<Categorie> afficher_cat() {
        
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
        ObservableList<Categorie> ListCat =  afficher_cat() ; 
        
        
        colnomCat.setCellValueFactory(new PropertyValueFactory<Categorie,String>("nomCategorie"));
        //colidC.setCellValueFactory(new PropertyValueFactory<Categorie,Long>("idCategorie"));
        
        
        tabCat.setItems(ListCat);
        
        
        
    }
       public void showcExamen(){
           ServiceExamen SE= new ServiceExamen();
        ObservableList<Examen> ListCat =  SE.afficher() ; 
        
        
        colnomExamen.setCellValueFactory(new PropertyValueFactory<Examen,String>("nomExamen"));
        //colidC.setCellValueFactory(new PropertyValueFactory<Categorie,Long>("idCategorie"));
        
        
        tabExam.setItems(ListCat);
        
        
        
    }

    
    
}
