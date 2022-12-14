/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Controller.AfficherEvController;
import entities.CategorieEv;
import entities.User;
import entities.evenement;
import java.io.File;
import java.io.IOException;
import services.event_service;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import static jdk.nashorn.tools.ShellFunctions.input;
import services.CategorieEvService;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author lmol
 */
public class UpdateEvController implements Initializable {

    @FXML
    private AnchorPane body;
    private TextField tfImage;
    @FXML
    private Button Update;
    @FXML
    private TextField tfnom;
    @FXML
    private TextArea tadesc;
    @FXML
    private Button retourc;
    @FXML
    private ImageView imgNom;
    @FXML
    private ComboBox<CategorieEv> Type_ev;
    @FXML
    private ComboBox<String> user_ev;
    @FXML
    private DatePicker date;
    private static final evenement ev = new evenement();
    @FXML
    private Button chooseimg;
    String img;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CategorieEvService cs=new CategorieEvService();
         cs.read().forEach((e) -> {
             Type_ev.getItems().add(e);
             System.out.println(ev);
             tfnom.setText(ev.getNom_ev());
             tadesc.setText(ev.getDesc_ev());
             Type_ev.getSelectionModel().select(ev.getId_categorie());
        });
         UtilisateurService ss = new UtilisateurService();
          ss.afficher().forEach(u->{
        user_ev.getItems().add(u.getNomUtilisateur());
        });
    }    

    @FXML
    private void UpdateEvenement(ActionEvent event) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
           CategorieEv te=Type_ev.getSelectionModel().getSelectedItem();
                  LocalDate dat = date.getValue();
                  String i= new String("en cors");

        evenement ee;
        ee = new evenement(ev.getId_ev(), te, tfnom.getText(), tadesc.getText(), img, ev.getId_user(), df.parse(date.getValue().toString()),"en cours");
        
        event_service eev = new event_service();
        eev.update(ee);
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("le evenement est Modifier avec succé");
        alert.show();
        
    }

    @FXML
    private void Retour(ActionEvent event) {
         final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/AfficherEv.fxml"));
        final Node node;
        try {
            node = fxmlLoader.load();
            AnchorPane pane=new AnchorPane(node);
            body.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(AfficherEvController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public void SetEv(evenement e){
        ev.setId_ev(e.getId_ev());
        ev.setNom_ev(e.getNom_ev());
        ev.setId_categorie(e.getId_categorie());
        ev.setDate(e.getDate());
        ev.setDesc_ev(e.getDesc_ev());
        ev.setImage_ev(e.getImage_ev());
        ev.setId_user(e.getId_user());
       
        
}

    @FXML
    private void chooseimg(ActionEvent event) {
        FileChooser filechooser= new FileChooser();
         filechooser.setTitle("Choose image");
        Window ownerWindow = null;
           File file = filechooser.showOpenDialog(ownerWindow);
          img=file.getAbsolutePath();
    }
    
}
