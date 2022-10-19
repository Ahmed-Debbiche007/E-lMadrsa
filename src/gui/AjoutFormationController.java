    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entites.Categorie;
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
import entites.difficulté;
import services.ServiceFormation;
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
    private TableColumn<Formation, difficulté> coldiff;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showformation();
        // TODO
    }    

    @FXML
    private void ajoutformation(ActionEvent event) {
        ServiceFormation sp = new ServiceFormation();
        System.out.println("création d'un objet Service Formation SUCCED");
        
        Formation F= new Formation();
        
        System.out.println(" objet Formation created SUCCED");
        if(tfSujet.getText().trim().equals(""))
            JOptionPane.showMessageDialog(null," Veuillez remplir le champs nom formation ! ");
        else{
        F.setSujet(tfSujet.getText());
        System.out.println(" 11");
        F.setDescription(tfDescription.getText());
        
        System.out.println(" 12");
        if(checkFacile.isSelected()){
            F.setDifficulté(difficulté.FACILE);
        }
        if (checkMoyen.isSelected()){
            F.setDifficulté(difficulté.MOYEN);
        }
        if(checkDifficile.isSelected()){
            F.setDifficulté(difficulté.DIFFICILE);
        }
        //F.setDifficulté(difficulté.DIFFICILE);
        System.out.println("13");
        int resultat = Integer.parseInt(tfDuree.getText());
        F.setDurée(resultat);
        System.out.println("14");
        F.setIdPrerequis(Long.remainderUnsigned(3,3));
        System.out.println("15");
        F.setIdCompetence(Long.remainderUnsigned(2,8));
        System.out.println("16");
        F.setIdCategorie(Long.remainderUnsigned(1,7));
        System.out.println("17");
        F.setIdExamen(Long.remainderUnsigned(9,9));
        System.out.println("18");
        sp.ajouter_formation(F);
        JOptionPane.showMessageDialog(null,"Formation Ajoutée! ");
         showformation();
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
             if(F.getDifficulté()==difficulté.FACILE){
                 checkFacile.setSelected(true);
                 checkMoyen.setSelected(false);
                 checkDifficile.setSelected(false);   
                 checkFacile.setIndeterminate(true);
                 checkMoyen.setIndeterminate(true);
                 checkDifficile.setIndeterminate(true);
                 
             }
             if(F.getDifficulté()==difficulté.MOYEN){
                 checkFacile.setSelected(false);
                 checkMoyen.setSelected(true);
                 checkDifficile.setSelected(false);   
                 checkFacile.setIndeterminate(true);
                 checkMoyen.setIndeterminate(true);
                 checkDifficile.setIndeterminate(true);
             }
             if(F.getDifficulté()==difficulté.DIFFICILE){
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
            String requete = "SELECT idFormation,sujet,description,durée,idPrerequis,idCompetence,idExamen,idCategorie FROM Formation";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                list.add(new Formation(rs.getLong("idFormation"), rs.getString("sujet"), rs.getString("description"),rs.getInt("durée"),rs.getLong(6),rs.getLong(7),rs.getLong(8),rs.getLong(8)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    public void showformation(){
        ObservableList<Formation> ListCat =  afficher() ; 
        System.out.println("pas de probleme");
        
        colidformation.setCellValueFactory(new PropertyValueFactory<Formation,Long>("idFormation"));
        colsujet.setCellValueFactory(new PropertyValueFactory<Formation,String>("Sujet"));
        coldescription.setCellValueFactory(new PropertyValueFactory<Formation,String>("Description"));
        coldiff.setCellValueFactory(new PropertyValueFactory<Formation,difficulté>("Difficulté"));
        colduree.setCellValueFactory(new PropertyValueFactory<Formation,Integer>("durée"));
        colidPrerequis.setCellValueFactory(new PropertyValueFactory<Formation,Long>("idPrerequis"));
        colidCompetence.setCellValueFactory(new PropertyValueFactory<Formation,Long>("idCompetence"));
        colidExamen.setCellValueFactory(new PropertyValueFactory<Formation,Long>("idExamen"));
        colidCategorie.setCellValueFactory(new PropertyValueFactory<Formation,Long>("idCategorie"));
        System.out.println("Pas de Soucis ");
        tabFormation.setItems(ListCat);
        System.out.println("pas de probleme2");
        
        
        
        
        
        
        
        //colidC.setCellValueFactory(new PropertyValueFactory<Categorie,Long>("idCategorie"));
        
        System.out.println("Pas de Soucis ");
        tabFormation.setItems(ListCat);
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
            F.setDifficulté(difficulté.FACILE);
        }
        if (checkMoyen.isSelected()){
            F.setDifficulté(difficulté.MOYEN);
        }
        if(checkDifficile.isSelected()){
            F.setDifficulté(difficulté.DIFFICILE);
        }
        //F.setDifficulté(difficulté.DIFFICILE);
        System.out.println("13");
        int resultat = Integer.parseInt(tfDuree.getText());
        F.setDurée(resultat);
        
        System.out.println("14");
        sp.modifier_formation(F);
        JOptionPane.showMessageDialog(null,"Formation Modifiée");
        showformation();
        
    }
    
    
}
