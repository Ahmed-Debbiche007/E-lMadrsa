/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import entites.Participation;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import utiles.DataDB;
import entites.Attestation;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import utiles.DataDB;
import javafx.scene.control.cell.PropertyValueFactory ;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class GestionAttestationController implements Initializable {

    @FXML
    private TableColumn<Participation, Long> coliduser;
    @FXML
    private TableColumn<Participation, Long> colidprenom;
    @FXML
    private TableColumn<Participation, Double> colRes;
    @FXML
    private TableView<Participation> tabGestionAtt;
    Connection cnx = DataDB.getInstance().getCnx();
    @FXML
    private TableColumn<Participation, Long> colidpart;
    @FXML
    private Button btGenererAtt;
    @FXML
    private TableColumn<Participation, Long> colnomFormation;
    @FXML
    private Button btajouterAtt;
    @FXML
    private TableView<Attestation> tabAttD;
    @FXML
    private TableColumn<Attestation, Long> colnomAtt;
    @FXML
    private TableColumn<Attestation, Long> colprenomAtt;
    @FXML
    private TableColumn<Attestation, Date> coldateAcq;
    @FXML
    private Button btmodifAtt;
    @FXML
    private Button btSupprimAtt;
    @FXML
    private TextField tfDate;
    @FXML
    private Button btretour;
    @FXML
    private Button btBestForm;
    @FXML
    private TextField tfBestForm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showParticipation();
        showAttestation();
        // TODO
    }    
     public ObservableList<Participation> afficher() {
        System.out.println("1");
        ObservableList<Participation> list = FXCollections.observableArrayList();
       
        
        

         try {
            String requete = "SELECT * from participation join user on user.idUser=participation.idUser JOIN formation on participation.idFormation=formation.idFormation; ";
            PreparedStatement st = cnx.prepareStatement(requete) ;
            ResultSet rs = st.executeQuery(requete);
            
           
            System.out.println(rs);
            while (rs.next()) {
               
                
             
                list.add(new Participation(rs.getLong("idParticipation"), rs.getLong("idUser"), rs.getLong("idFormation"),rs.getLong("resultat"),rs.getString("nom"),rs.getString("Prenom"),rs.getString("sujet")));
                System.out.println("heeeeeeeeeeey" + list);
            
            
            }
            
            
            
            

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }
    public void showParticipation(){
        ObservableList<Participation> ListCat =  afficher() ; 
        //System.out.println("pas de probleme");
        Participation P = new Participation();
        System.out.println(ListCat.size());
        
        colidpart.setCellValueFactory(new PropertyValueFactory<Participation,Long>("idParticipation"));
        coliduser.setCellValueFactory(new PropertyValueFactory<Participation,Long>("nom"));
        
        //colidPrerequis.setCellValueFactory(new PropertyValueFactory<Formation,Long>("idPrerequis"));
        colidprenom.setCellValueFactory(new PropertyValueFactory<Participation,Long>("prenom"));
        colRes.setCellValueFactory(new PropertyValueFactory<Participation,Double>("resultat"));
         colnomFormation.setCellValueFactory(new PropertyValueFactory<Participation,Long>("sujet"));
        
        
        tabGestionAtt.setItems(ListCat);
        //System.out.println("pas de probleme2");
        
        
        
        
        
        
        
        //colidC.setCellValueFactory(new PropertyValueFactory<Categorie,Long>("idCategorie"));
        
        //System.out.println("Pas de Soucis ");
        //tabFormation.setItems(ListCat);
        System.out.println("pas de probleme2");
        
        
    }

    @FXML
    private void GénererAtt(ActionEvent event) throws DocumentException  {
       Participation P = tabGestionAtt.getSelectionModel().getSelectedItem() ;
        
        Document Doc = new Document();
        try {
            PdfWriter.getInstance(Doc,new FileOutputStream("C:\\Users\\User\\Documents\\Attestation\\Etudiant.pdf") );
            Doc.open();
            Doc.add(new Paragraph("E-lmadrsa "));
            Image img= Image.getInstance("C:\\Users\\User\\Documents\\Att1.png ");
            img.scaleAbsoluteHeight(90);
            img.scaleAbsoluteWidth(600);
            img.setAlignment(Image.ALIGN_CENTER);
            Doc.add(img);
            Doc.add(new Paragraph(" "));
            Doc.add(new Paragraph("Je soussigné, Ahmed Gouiaa, agissant en qualité de responsable de  l'organisme de formation E-lmadrsa atteste que :\n" +"\n" +"Madame / Monsieur " + P.getNom()+"  "+ P.getPrenom() +"\n"
            + "A suivi avec assiduité et réussite une formation de " +P.getSujet()+" au sein de notre plateform E-lmadrsa avec passage d un examen  \n"+"Le Resultat obtenu est : " + P.getResultat() +"%"));
            Doc.add(new Paragraph("\n "));
            Doc.add(new Paragraph("\n "));
            Doc.add(new Paragraph("\n "));
            Image img1 = Image.getInstance("C:\\Users\\User\\Documents\\1.png ");
            img1.setAlignment(Image.ALIGN_RIGHT);
            Doc.add(img1);
            
            //Doc.add(new Paragraph("atteste que :\n" +"\n" +"Madame / Monsieur " + P.getNom()+ P.getPrenom() ));
            Doc.close();
            Desktop.getDesktop().open(new File("C:\\Users\\User\\Documents\\Attestation\\Etudiant.pdf"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionAttestationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadElementException ex) {
            Logger.getLogger(GestionAttestationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionAttestationController.class.getName()).log(Level.SEVERE, null, ex);
        }

        


    }
     public void showAttestation(){
         ServiceAttestation SA = new ServiceAttestation ();
        ObservableList<Attestation> ListCat =  SA.afficher_Att(); 
       
        
        colnomAtt.setCellValueFactory(new PropertyValueFactory<Attestation,Long>("nom"));
        colprenomAtt.setCellValueFactory(new PropertyValueFactory<Attestation,Long>("prenom"));
        coldateAcq.setCellValueFactory(new PropertyValueFactory<Attestation,Date>("dateAcq"));
        tabAttD.setItems(ListCat);
        
        System.out.println("pas de probleme2");
        
        
    }

    @FXML
    private void AjouterAtt(ActionEvent event) throws ParseException {
        Participation P= tabGestionAtt.getSelectionModel().getSelectedItem();
        ServiceAttestation spA = new ServiceAttestation();
        System.out.println("1");
        Attestation A = new Attestation();
        
        System.out.println("object  Attestation Created");
        A.setIdParticipation(P.getIdParticipation()); 
        System.out.println("idParticipation work");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
        java.util.Date dateStr = formatter.parse(tfDate.getText());
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
        showAttestation();
        tfDate.setText("");
    }

    @FXML
    private void ModiferAtt(ActionEvent event) throws ParseException {
         Attestation A =tabAttD.getSelectionModel().getSelectedItem();
         
         
        
        ServiceAttestation spAM= new ServiceAttestation();
        System.out.println("Service Attestation Created");
       
        System.out.println("object  Attestation Created");
        A.setIdParticipation(A.getIdParticipation());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // your template here
        java.util.Date dateStr = formatter.parse(tfDate.getText());
        java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());
        A.setDateAcq(dateDB);
        spAM.modifier_attestation(A);
        JOptionPane.showMessageDialog(null,"Attestation Modifiée ! ");
        showAttestation();
    }

    @FXML
    private void SupprimerAtt(ActionEvent event) {
        Attestation A = tabAttD.getSelectionModel().getSelectedItem();
        
        ServiceAttestation spAM= new ServiceAttestation();
        System.out.println("Service Attestation Created");
        spAM.supprimer_attestation(A);
        JOptionPane.showMessageDialog(null,"Attestation Supprimée ! ");
        showAttestation();
    }

    @FXML
    private void RetourAccueil(ActionEvent event) throws IOException {
         Stage stage ;
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void BestForm(ActionEvent event) {
         ObservableList<Participation> list = FXCollections.observableArrayList();
          
       
        
        

         try {
            String requete = "SELECT *  FROM participation JOIN formation ON participation.idFormation=formation.idFormation GROUP BY sujet ORDER BY COUNT(participation.idFormation) DESC LIMIT 1 ";
            PreparedStatement st = cnx.prepareStatement(requete) ;
            ResultSet rs = st.executeQuery(requete);
            
           
            System.out.println(rs);
            while (rs.next()) {
               
                
             
                list.add(new Participation(rs.getLong("idParticipation"), rs.getLong("idUser"), rs.getLong("idFormation"),rs.getLong("resultat"),rs.getString("sujet")));
                System.out.println("heeeeeeeeeeey" + list);
            
            
            }
            
            
            
            

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
         Participation P = new Participation() ;
         String ch= list.get(0).getSujet();
          tfBestForm.setText(ch);
         
         
         
    }
         

        
         
       
        
        

         

    
}
