/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
 import entites.Prerequis;
import entites.Competences;
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

import services.ServiceFormation;
import services.ServiceCompetences;
import services.ServicePrerequis;
import services.ServiceCategorie;
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
import entities.Examen;
import entities.Participation;
import java.io.IOException;
import java.security.Security;
import java.sql.PreparedStatement;
import static java.util.Arrays.equals;
import static java.util.Arrays.equals;
import static java.util.Arrays.equals;
import java.util.Properties;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import services.ExamenService;
import services.ParticipationsService;
import services.UtilisateurService;

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
    @FXML
    private TableColumn<Formation, String> colpart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showformation();
        loadingg();
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
           ExamenService SE= new ExamenService();
        ObservableList<Examen> ListCat =  SE.afficher() ; 
        
        
        colnomExamen.setCellValueFactory(new PropertyValueFactory<Examen,String>("nomExamen"));
        //colidC.setCellValueFactory(new PropertyValueFactory<Categorie,Long>("idCategorie"));
        
        
        tabExam.setItems(ListCat);
        
        
        
    }
       
           private void loadingg() {

        showformation();

        colidformation.setCellValueFactory(new PropertyValueFactory<Formation,Long>("idFormation"));
        colsujet.setCellValueFactory(new PropertyValueFactory<Formation,String>("Sujet"));
        coldescription.setCellValueFactory(new PropertyValueFactory<Formation,String>("Description"));
        coldiff.setCellValueFactory(new PropertyValueFactory<Formation,String>("Difficulté"));
        colduree.setCellValueFactory(new PropertyValueFactory<Formation,Integer>("durée"));
        colidCompetence.setCellValueFactory(new PropertyValueFactory<Formation,Long>("nomCompetence"));
        colidCategorie.setCellValueFactory(new PropertyValueFactory<Formation,Long>("nomCategorie"));
        colidPrerequis.setCellValueFactory(new PropertyValueFactory<Formation,Long>("nomPrerequis"));
        colidExamen.setCellValueFactory(new PropertyValueFactory<Formation,Long>("nomExamen"));

        //add cell of button edit 
        Callback<TableColumn<Formation, String>, TableCell<Formation, String>> cellFoctory = (TableColumn<Formation, String> param) -> {
            // make cell containing buttons
            final TableCell<Formation, String> cell = new TableCell<Formation, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        FontAwesomeIconView ParticipateIcon = new FontAwesomeIconView(FontAwesomeIcon.PLUS);

     

                        ParticipateIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#00E676;"
                        );

      

                        ParticipateIcon.setOnMouseClicked((MouseEvent event) -> {

                            if (tabFormation.getSelectionModel().getSelectedItem() != null) {
                                System.out.println("participer a une formation ......");
                                ParticipationsService PS = new ParticipationsService();
                                Formation f = tabFormation.getSelectionModel().getSelectedItem();
                                long x = 1;
                                Participation p = new Participation(x,f.getIdFormation());
                                PS.ajouter(p);
                                
                                
                                
                                
                                // send mail about formation  participation : made by gouiaa

                                String username = "springforfever@gmail.com";
                                String password = "kmcovmkdwmxwscsz";
                                Properties props = new Properties();
                                Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                                props.put("mail.smtp.port", "465");
                                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                                props.put("mail.smtp.ssl.enable", true); 
                                props.put("mail.smtp.ssl.protocols", "TLSv1.2");
                                props.put("mail.smtp.socketFactory.port", "465");
                                props.put("mail.smtp.socketFactory.fallback", "false");
                                props.put("mail.smtp.host", "smtp.gmail.com");
                                props.put("mail.smtp.auth", "true");
                                props.setProperty("mail.debug", "true");
                                props.setProperty("mail.transport.protocol", "smtp");
                                props.put("mail.smtp.starttls.enable", "true"); 
                                Session session = Session.getInstance(props, new javax.mail.Authenticator() {

                                    protected PasswordAuthentication getPasswordAuthentication() {
                                        return new PasswordAuthentication(username, password);
                                    }
                                });

                                try {
                                    Address a = new InternetAddress("springforfever@gmail.com");
      
                                    Message message = new MimeMessage(session);
                                    message.setFrom(new InternetAddress("springforfever@gmail.com"));
                                    
                                    
                                    UtilisateurService US = new UtilisateurService() ;
                                    ExamenService  ES = new ExamenService()  ;
                                     
                                    Examen CurrentExam = ES.getExamById(f.getIdExamen()) ;
                                  //  User currentUser = US.getByUserId(CurrentExam.get)
                                    
                                    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("springforfever@gmail.com") );
                                    message.setSubject("formation news from elmadrsa");
                                    message.setText("Bonjour vous avez participer a la formatoin :" + f.getSujet());
                                    Transport.send(message);

                                } catch (MessagingException mex) {
                                    System.out.println("send failed, exception: " + mex.getMessage());
                                }

                                FXMLLoader loader = new FXMLLoader(getClass().getResource("ParticipationCrud.fxml"));
                                Parent root;
                                try {
                                    root = loader.load();
                                    tabFormation.getScene().setRoot(root);
                                } catch (IOException ex) {
                                    System.out.println("error");
                                }

                            }


                        });

                        HBox managebtn = new HBox(ParticipateIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(ParticipateIcon, new Insets(2, 3, 0, 2));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };
        colpart.setCellFactory(cellFoctory);
        showformation();


    }

    
    
}