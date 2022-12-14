/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.ByteMatrix;
import com.google.zxing.qrcode.encoder.QRCode;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.javafx.iio.ImageStorage.ImageType;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import entities.Participation;
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
import java.io.ByteArrayOutputStream;
import java.nio.file.Paths;
import services.ServiceGestionAttestation;
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
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utiles.DataDB;
import javafx.scene.control.cell.PropertyValueFactory ;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author User
 */
public class GestionAttestationController implements Initializable {

    @FXML
    private TableColumn<Participation, String> coliduser;
    @FXML
    private TableColumn<Participation, String> colidprenom;
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
    private Button btStat;
    @FXML
    private Label idLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showDemande_Attestation();
        showAttestation();
        // TODO
    }    
 
            
            
            
 

       
    public void showDemande_Attestation(){
        ServiceGestionAttestation  SGA = new ServiceGestionAttestation();
        ObservableList<Participation> ListCat =  SGA.afficher_DemandeAttestation() ; 
        //System.out.println("pas de probleme");
        Participation P = new Participation();
        System.out.println(ListCat.size());
        
        colidpart.setCellValueFactory(new PropertyValueFactory<Participation,Long>("idParticipation"));
        coliduser.setCellValueFactory(new PropertyValueFactory<Participation,String>("nom"));
        
        //colidPrerequis.setCellValueFactory(new PropertyValueFactory<Formation,Long>("idPrerequis"));
        colidprenom.setCellValueFactory(new PropertyValueFactory<Participation,String>("prenom"));
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
    private void GénererAtt(ActionEvent event) throws DocumentException, WriterException, IOException  {
       Participation P = tabGestionAtt.getSelectionModel().getSelectedItem() ;
        
        Document Doc = new Document();
        GenererCodeQR();
        try {
            PdfWriter.getInstance(Doc,new FileOutputStream(System.getProperty("user.dir")+"/src/images/att.pdf") );
            Doc.open();
            Doc.add(new Paragraph("E-lmadrsa "));
            Image img= Image.getInstance(System.getProperty("user.dir")+"/src/images/symfony_black_01.png");
            img.scaleAbsoluteHeight(90);
            img.scaleAbsoluteWidth(600);
            img.setAlignment(Image.ALIGN_CENTER);
            Doc.add(img);
            Doc.add(new Paragraph(" "));
            Doc.add(new Paragraph("Je soussigné, Ahmed Gouiaa, agissant en qualité de responsable de  l'organisme de formation E-lmadrsa atteste que :\n" +"\n" +"Madame / Monsieur " + P.getNom()+ "  "+ P.getPrenom() +"\n"
            + "A suivi avec assiduité et réussite une formation de " +P.getSujet()+" au sein de notre plateform E-lmadrsa avec passage d un examen  \n"+"Le Resultat obtenu est : " + P.getResultat() +"%"));
            Doc.add(new Paragraph("\n "));
            Doc.add(new Paragraph("\n "));
            Doc.add(new Paragraph("\n "));
            Image img1 = Image.getInstance(System.getProperty("user.dir")+"/src/images/symfony_black_01.png");
            img1.setAlignment(Image.ALIGN_LEFT);
            img1.scaleAbsoluteHeight(70);
            img1.scaleAbsoluteWidth(400);
            Doc.add(img1);
            Image img2 = Image.getInstance(System.getProperty("user.dir")+"/src/images/code.png");
            img2.setAlignment(Image.ORIGINAL_PNG);
            img2.scaleAbsoluteHeight(200);
            img2.scaleAbsoluteWidth(200);
            Doc.add(img2);
            
            
            //Doc.add(new Paragraph("atteste que :\n" +"\n" +"Madame / Monsieur " + P.getNom()+ P.getPrenom() ));
            Doc.close();
            Desktop.getDesktop().open(new File(System.getProperty("user.dir")+"/src/images/att.pdf"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionAttestationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadElementException ex) {
            Logger.getLogger(GestionAttestationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionAttestationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        


    }
     public void showAttestation(){
         ServiceGestionAttestation SA = new ServiceGestionAttestation ();
        ObservableList<Attestation> ListCat =  SA.afficher_Att(); 
       
        
        colnomAtt.setCellValueFactory(new PropertyValueFactory<Attestation,Long>("nom"));
        colprenomAtt.setCellValueFactory(new PropertyValueFactory<Attestation,Long>("prenom"));
        coldateAcq.setCellValueFactory(new PropertyValueFactory<Attestation,Date>("dateAcq"));
        tabAttD.setItems(ListCat);
        
        System.out.println("pas de probleme2");
        
        
    }
     public void GenererCodeQR() throws WriterException, IOException{
         Participation P = tabGestionAtt.getSelectionModel().getSelectedItem() ;
         String details=" Cette Attestation est délivrée à "+P.getNom()+""+ P.getPrenom()+ " aprés son réussite à la formation "+P.getSujet()+" Par E-lmadrsa";
        String path = System.getProperty("user.dir")+"/src/images/code.png";
         BitMatrix matrix = new MultiFormatWriter().encode(details, BarcodeFormat.QR_CODE, 500, 500) ;
         MatrixToImageWriter.writeToFile(matrix,"png", new File(path));
     }

    @FXML
    private void AjouterAtt(ActionEvent event) throws ParseException {
        Participation P= tabGestionAtt.getSelectionModel().getSelectedItem();
        ServiceGestionAttestation spA = new ServiceGestionAttestation();
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
         
         
        
        ServiceGestionAttestation spAM= new ServiceGestionAttestation();
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
        
        ServiceGestionAttestation spAM= new ServiceGestionAttestation();
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
         ObservableList<Participation> list2 = FXCollections.observableArrayList();
         int i,j=0;
         i=list2.size();
         
          
       
        
        

         try {
            String requete = "SELECT *  FROM participation JOIN formation ON participation.idFormation=formation.idFormation GROUP BY sujet ORDER BY COUNT(participation.idFormation) DESC LIMIT 1 ";
            PreparedStatement st = cnx.prepareStatement(requete) ;
            ResultSet rs = st.executeQuery(requete);
            
           
            System.out.println(rs);
            while (rs.next()) {
               
                
             
                list.add(new Participation(rs.getLong("idParticipation"), rs.getLong("idUser"), rs.getLong("idFormation"),rs.getLong("resultat"),rs.getString("sujet")));
                //System.out.println("heeeeeeeeeeey" + list);
            
            
            }
            
            
            
            

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
         Participation P = new Participation() ;
         String ch= list.get(0).getSujet();
          
          idLabel.setText(ch);
            
            
            

        
           
            
           
           
           
           
           
           
         
         
         
    }

    @FXML
    private void StatFormation(ActionEvent event) throws IOException {
        Stage stage ;
        Parent root = FXMLLoader.load(getClass().getResource("LineChart.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
         

        
         
       
        
        

         

    
}
