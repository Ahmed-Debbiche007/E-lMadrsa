/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import javafx.scene.control.TextField;
import entites.Formation;
import services.ServiceFormation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;

import utiles.DataDB;

import entites.difficulté;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.Participation;

import java.io.IOException;
import java.net.URL;
import java.security.Security;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import services.ParticipationsService;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;

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
    @FXML
    private TableColumn<Formation, String> colpart;
    private ObservableList<Formation> ListCat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadingg();
        // TODO
    }

    @FXML
    private void ajoutformation(ActionEvent event) {
        ServiceFormation sp = new ServiceFormation();
        System.out.println("création d'un objet Service Formation SUCCED");

        Formation F = new Formation();

        System.out.println(" objet Formation created SUCCED");
        if (tfSujet.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, " Veuillez remplir le champs nom formation ! ");
        } else {
            F.setSujet(tfSujet.getText());
            System.out.println(" 11");
            F.setDescription(tfDescription.getText());

            System.out.println(" 12");
            if (checkFacile.isSelected()) {
                F.setDifficulté(difficulté.FACILE);
            }
            if (checkMoyen.isSelected()) {
                F.setDifficulté(difficulté.MOYEN);
            }
            if (checkDifficile.isSelected()) {
                F.setDifficulté(difficulté.DIFFICILE);
            }
            //F.setDifficulté(difficulté.DIFFICILE);
            System.out.println("13");
            int resultat = Integer.parseInt(tfDuree.getText());
            F.setDurée(resultat);
            System.out.println("14");
            F.setIdPrerequis(Long.remainderUnsigned(3, 3));
            System.out.println("15");
            F.setIdCompetence(Long.remainderUnsigned(2, 8));
            System.out.println("16");
            F.setIdCategorie(Long.remainderUnsigned(1, 7));
            System.out.println("17");
            F.setIdExamen(Long.remainderUnsigned(9, 9));
            System.out.println("18");
            sp.ajouter_formation(F);
            JOptionPane.showMessageDialog(null, "Formation Ajoutée! ");
            showformation();
        }

    }

    @FXML
    private void supprimerformation(ActionEvent event) {

        Formation F = tabFormation.getSelectionModel().getSelectedItem();
        ServiceFormation sp = new ServiceFormation();
        sp.supprimer_formation(F);
        JOptionPane.showMessageDialog(null, "Formation Supprimée ! ");
        showformation();
    }

    @FXML
    private void modifformation(ActionEvent event) {
        if (tabFormation.getSelectionModel().getSelectedItem() != null) {
            Formation F = tabFormation.getSelectionModel().getSelectedItem();

            tfDescription.setText(F.getDescription());
            tfSujet.setText(F.getSujet());
            if (F.getDifficulté() == difficulté.FACILE) {
                checkFacile.setSelected(true);
                checkMoyen.setSelected(false);
                checkDifficile.setSelected(false);
                checkFacile.setIndeterminate(true);
                checkMoyen.setIndeterminate(true);
                checkDifficile.setIndeterminate(true);

            }
            if (F.getDifficulté() == difficulté.MOYEN) {
                checkFacile.setSelected(false);
                checkMoyen.setSelected(true);
                checkDifficile.setSelected(false);
                checkFacile.setIndeterminate(true);
                checkMoyen.setIndeterminate(true);
                checkDifficile.setIndeterminate(true);
            }
            if (F.getDifficulté() == difficulté.DIFFICILE) {
                checkFacile.setSelected(false);
                checkMoyen.setSelected(false);
                checkDifficile.setSelected(true);
                checkFacile.setIndeterminate(true);
                checkMoyen.setIndeterminate(true);
                checkDifficile.setIndeterminate(true);
            }
            tfDuree.setText("" + F.getDurée());

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
                list.add(new Formation(rs.getLong("idFormation"), rs.getString("sujet"), rs.getString("description"), rs.getInt("durée"), rs.getLong(6), rs.getLong(7), rs.getLong(8), rs.getLong(8)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }

    public void showformation() {
        ListCat = afficher();
        System.out.println("pas de probleme");

        colidformation.setCellValueFactory(new PropertyValueFactory<Formation, Long>("idFormation"));
        colsujet.setCellValueFactory(new PropertyValueFactory<Formation, String>("Sujet"));
        coldescription.setCellValueFactory(new PropertyValueFactory<Formation, String>("Description"));
        coldiff.setCellValueFactory(new PropertyValueFactory<Formation, difficulté>("Difficulté"));
        colduree.setCellValueFactory(new PropertyValueFactory<Formation, Integer>("durée"));
        colidPrerequis.setCellValueFactory(new PropertyValueFactory<Formation, Long>("idPrerequis"));
        colidCompetence.setCellValueFactory(new PropertyValueFactory<Formation, Long>("idCompetence"));
        colidExamen.setCellValueFactory(new PropertyValueFactory<Formation, Long>("idExamen"));
        colidCategorie.setCellValueFactory(new PropertyValueFactory<Formation, Long>("idCategorie"));
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
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void enregistrermodif(ActionEvent event) {
        Formation F = tabFormation.getSelectionModel().getSelectedItem();
        ServiceFormation sp = new ServiceFormation();
        System.out.println("création d'un objet Service Formation SUCCED");
        F.setSujet(tfSujet.getText());
        F.setDescription(tfDescription.getText());

        System.out.println(" 12");
        if (checkFacile.isSelected()) {
            F.setDifficulté(difficulté.FACILE);
        }
        if (checkMoyen.isSelected()) {
            F.setDifficulté(difficulté.MOYEN);
        }
        if (checkDifficile.isSelected()) {
            F.setDifficulté(difficulté.DIFFICILE);
        }
        //F.setDifficulté(difficulté.DIFFICILE);
        System.out.println("13");
        int resultat = Integer.parseInt(tfDuree.getText());
        F.setDurée(resultat);

        System.out.println("14");
        sp.modifier_formation(F);
        JOptionPane.showMessageDialog(null, "Formation Modifiée");
        showformation();

    }

    private void loadingg() {

        showformation();

        colidformation.setCellValueFactory(new PropertyValueFactory<Formation, Long>("idFormation"));
        colsujet.setCellValueFactory(new PropertyValueFactory<Formation, String>("Sujet"));
        coldescription.setCellValueFactory(new PropertyValueFactory<Formation, String>("Description"));
        coldiff.setCellValueFactory(new PropertyValueFactory<Formation, difficulté>("Difficulté"));
        colduree.setCellValueFactory(new PropertyValueFactory<Formation, Integer>("durée"));
        colidPrerequis.setCellValueFactory(new PropertyValueFactory<Formation, Long>("idPrerequis"));
        colidCompetence.setCellValueFactory(new PropertyValueFactory<Formation, Long>("idCompetence"));
        colidExamen.setCellValueFactory(new PropertyValueFactory<Formation, Long>("idExamen"));
        colidCategorie.setCellValueFactory(new PropertyValueFactory<Formation, Long>("idCategorie"));

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

                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PLUS);

                        deleteIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#ff1744;"
                        );

                        editIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#00E676;"
                        );

                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {

                            System.out.println("participer a une formation ......");

                        }
                        );

                        editIcon.setOnMouseClicked((MouseEvent event) -> {

                            if (tabFormation.getSelectionModel().getSelectedItem() != null) {
                                System.out.println("participer a une formation ......");
                                ParticipationsService PS = new ParticipationsService();
                                Formation f = tabFormation.getSelectionModel().getSelectedItem();
                                long x = 1;
                                Participation p = new Participation(f.getIdFormation(), x);
                                PS.ajouter(p);

                                String username = "springforfever@gmail.com";
                                String password = "kmcovmkdwmxwscsz";
                                Properties props = new Properties();
                                		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());


               

                                props.put("mail.smtp.port", "465");
                               props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                                 
//props.put("mail.smtp.starttls.enable", true); 
props.put("mail.smtp.ssl.enable", true); 
                               props.put("mail.smtp.ssl.protocols", "TLSv1.2");
                                //props.put("mail.smtp.starttls.required", true);

                                  props.put("mail.smtp.socketFactory.port", "465");
                                 props.put("mail.smtp.socketFactory.fallback", "false");
                                props.put("mail.smtp.host", "smtp.gmail.com");
                                props.put("mail.smtp.auth", "true");
                                 
                                 //props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
                                props.setProperty("mail.debug", "true");
                
                
                

               		props.setProperty("mail.transport.protocol", "smtp");
                                                         props.put("mail.smtp.starttls.enable", "true"); 
/*
		props.setProperty("mail.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
		"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.quitwait", "false");
               */
                                Session session = Session.getInstance(props, new javax.mail.Authenticator() {

                                    protected PasswordAuthentication getPasswordAuthentication() {
                                        return new PasswordAuthentication(username, password);
                                    }
                                });

                                try {
                                    Address a = new InternetAddress("springforfever@gmail.com");
      
                                    Message message = new MimeMessage(session);
                                    message.setFrom(new InternetAddress("springforfever@gmail.com"));
                                    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("springforfever@gmail.com") );
                                    message.setSubject("formation news from elmadrsa");
                                    message.setText("Bonjour vous avez participer a la formatoin :" + f.getSujet());
                                    Transport.send(message);
                                    //transport.send(message);transport.connect(mailServer, port, username, password);
                                       // transport.sendMessage(message, message.getAllRecipients());
                                    
                                    
 
                                } catch (MessagingException mex) {
                                    System.out.println("send failed, exception: " + mex.getMessage());
                                }

                                // }
                                /*                 
                                
     Properties props = new Properties();
     props.put("mail.smtp.host", "smtp.gmail.com");
     props.setProperty("mail.smtp.password", "springfever2019");
     props.setProperty("mail.smtp.user", "e lmadrsa");
     props.put("mail.smtp.auth", true); 
     char[] pass = {'s', 'p', 'r', 'i', 'n','g','2','0','1','9'};
      
     Session session = Session.getDefaultInstance(props, 
    new javax.mail.Authenticator(){
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(
                "springforfever@gmail.com", password);
        }
});
      
 
   // Session session = Session.getInstance(props, null);

    try {
        MimeMessage msg = new MimeMessage(session);
        String adresse = "springforfever@gmail.com"  ;
        
         msg.setFrom(new InternetAddress(adresse) );
        msg.setRecipients(Message.RecipientType.TO,
                          "springforfever@gmail.com");
        msg.setSubject("elmadrsa hello world example");
        msg.setSentDate(new Date());
        msg.setText("vous avez partciper a la formation  : "+f.getSujet());
        Transport.send(msg);
       // Transport.send(msg,"e lmadrsa","springfever2019");
       // Transport.send(msg, "me@example.com", "my-password");
    } catch (MessagingException mex) {
        System.out.println("send failed, exception: " + mex);
    }
                                
                                
                                 */
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("ParticipationCrud.fxml"));
                                Parent root;
                                try {
                                    root = loader.load();
                                    tabFormation.getScene().setRoot(root);
                                } catch (IOException ex) {
                                    System.out.println("error");
                                }

                            }

                            /*
                                Post_edit_addController pea = loader.getController();
                                pea.getTapostcontent().setText(staticpost.getPostCONTENT());
                                pea.getTaposttitle().setText(staticpost.getPostTITLE());
                                pea.getTfuseridpost().setText(Long.toString(staticpost.getUserID()));
                             */
                        });

                        HBox managebtn = new HBox(editIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };
        colpart.setCellFactory(cellFoctory);

        showformation();
        //studentsTable.setItems(StudentList);
        //tabFormation.setItems(this.ListCat);

    }

}
