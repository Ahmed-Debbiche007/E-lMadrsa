/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import entites.Attestation;
import java.io.IOException;
import services.ServiceAttestation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class AjoutAttestationController implements Initializable {

    @FXML
    private TextField tfdateA;
    @FXML
    private Button btAjout;
    @FXML
    private Button btModifer;
    @FXML
    private Button btSupprimer;
    @FXML
    private TableView<Attestation> tabAttestation;
    @FXML
    private TableColumn<Attestation, Long> colidA;
    @FXML
    private TableColumn<Attestation, Long> colidparticipation;
    @FXML
    private TableColumn<Attestation, Date> coldate;
    Connection cnx = DataDB.getInstance().getCnx();
    @FXML
    private Button btretour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showattestation();
        // TODO
    }    

    @FXML
    private void ajoutAtt(ActionEvent event) throws ParseException {
        ServiceAttestation spA = new ServiceAttestation();
        System.out.println("1");
        Attestation A = new Attestation();
        System.out.println("object  Attestation Created");
        A.setIdParticipation(Long.remainderUnsigned(6,3)); 
        System.out.println("idParticipation work");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
        java.util.Date dateStr = formatter.parse(tfdateA.getText());
        java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
        //C.setNomCategorie(tfNomC.getText());
        //LocalDate dat = date.getValue();
        //if(dateDB.after(LocalDate.now())==true){
            
        //} 
        //}
         A.setDateAcq(dateDB);
        System.out.println("Pas de problem !! ");
        spA.ajouter_attestation(A);
        JOptionPane.showMessageDialog(null,"Attestation Ajoutée ! ");
        showattestation();
    }

    @FXML
    private void modifAtt(ActionEvent event) throws ParseException {
        Attestation A =tabAttestation.getSelectionModel().getSelectedItem();
        
        ServiceAttestation spAM= new ServiceAttestation();
        System.out.println("Service Attestation Created");
       
        System.out.println("object  Attestation Created");
        A.setIdParticipation(Long.remainderUnsigned(3,3));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
        java.util.Date dateStr = formatter.parse(tfdateA.getText());
        java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
        A.setDateAcq(dateDB);
        spAM.modifier_attestation(A);
        JOptionPane.showMessageDialog(null,"Attestation Modifiée ! ");
        showattestation();
        
    }

    @FXML
    private void supprimerAtt(ActionEvent event) {
        Attestation A =tabAttestation.getSelectionModel().getSelectedItem();
        
        ServiceAttestation spAM= new ServiceAttestation();
        System.out.println("Service Attestation Created");
        spAM.supprimer_attestation(A);
        JOptionPane.showMessageDialog(null,"Attestation Supprimée ! ");
        showattestation();
        
        
    }
    public ObservableList<Attestation> afficher() {
        System.out.println("1");
        ObservableList<Attestation> list = FXCollections.observableArrayList();

        try {
            String requete = "SELECT * FROM Attestation ";
            Statement st = cnx.createStatement();
           
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()) {
                list.add(new Attestation(rs.getLong("idAttestation"),rs.getLong("idparticipation"),rs.getDate("dateAcq")));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    public void showattestation(){
        ObservableList<Attestation> ListCat =  afficher() ; 
        System.out.println("pas de probleme");
        
       coldate.setCellValueFactory(new PropertyValueFactory<Attestation,Date>("dateAcq"));
        //colidC.setCellValueFactory(new PropertyValueFactory<Categorie,Long>("idCategorie"));
        
        System.out.println("Pas de Soucis ");
        tabAttestation.setItems(ListCat);
        System.out.println("pas de probleme2");
        
        
    }

    @FXML
    private void retourattestation(ActionEvent event) throws IOException {
        Stage stage ;
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
