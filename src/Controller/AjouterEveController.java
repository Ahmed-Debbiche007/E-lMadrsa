/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.net.URL;
import entities.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import services.*;
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
import outils.SendMail;
import test.javaMailUtil;

/**
 * FXML Controller class
 *
 * @author lmol
 */
public class AjouterEveController implements Initializable {

    @FXML
    private AnchorPane body;
    @FXML
    private TextField tfImage;
    @FXML
    private Button add;
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
    @FXML
    private Button chImage;
    String img;
    public static final String ACCOUNT_SID = System.getenv("ACc2294319aa2eaba8e91273055538a50e");
    public static final String AUTH_TOKEN = "54df389d2dfc92cb4caee9de31578a4e";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CategorieEvService cs = new CategorieEvService();
        UtilisateurService ss = new UtilisateurService();
        cs.read().forEach((e) -> {
            Type_ev.getItems().add(e);
        });

        ss.afficher().forEach(u->{
        user_ev.getItems().add(u.getNomUtilisateur());
        });
    }

    @FXML
    private void AjouterEvenement(ActionEvent event) throws ParseException, Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String us = user_ev.getSelectionModel().getSelectedItem();
        UtilisateurService ss = new UtilisateurService();
        User uu = ss.getByUserName(us);
        CategorieEv Ts = Type_ev.getSelectionModel().getSelectedItem();
        LocalDate dat = date.getValue();
        if (tfnom.getText().isEmpty() || Type_ev.getSelectionModel().isEmpty() || tadesc.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Veuiilez remplir tout les champs");
            alert.showAndWait();
        } else if (dat.isAfter(LocalDate.now())) {
            evenement ev;
            ev = new evenement(Ts, tfnom.getText(), tadesc.getText(), img, (int) (long)uu.getId(), df.parse(date.getValue().toString()), "en cours");
            event_service evs = new event_service();
            evs.insert(ev);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("l'evenement est ajouté avec succé");
            alert.showAndWait();
            /*Twilio.init(
   System.getenv("ACc2294319aa2eaba8e91273055538a50e"),
   System.getenv("d12bb8dc7c5c5eb8a39231e60cef4491"));
             */
            
            SendMail.send("New Event", ev.toString(), "ahmed.debbiche@esprit.tn");
            Twilio.init("ACc2294319aa2eaba8e91273055538a50e", "54df389d2dfc92cb4caee9de31578a4e");
            
            Message message = Message.creator(
                    new PhoneNumber("+21655105372"),
                    new PhoneNumber("+18654137235"),
                    "Il ya un nouveau evenement:"+ev.getNom_ev()+"le"+ev.getDate().toString())
                    .create();

            

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("date erreur");
            alert.setHeaderText(null);
            alert.setContentText("la date saisie n'est pas valide ");
            alert.showAndWait();
        }
    }

    @FXML
    private void Retour(ActionEvent event) {
        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/AfficherEv.fxml"));
        final Node node;
        try {
            node = fxmlLoader.load();
            AnchorPane pane = new AnchorPane(node);
            body.getChildren().setAll(pane);
        } catch (IOException ex) {
            Logger.getLogger(AfficherEvController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     @FXML
     private void choisirImage(ActionEvent event) throws IOException {
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Choose image");
        Window ownerWindow = null;
        File file = filechooser.showOpenDialog(ownerWindow);


        if (file.getAbsoluteFile().toString() != null) {
            File source = new File(file.getAbsolutePath());
            File destination = new File("/home/ahmed/PiDev/E-lMadrsa-Web/public/uploads/images/" + file.getName());
            copy(source, destination);
        }

        img = file.getName();

    }

    private void copy(File source, File destination) throws IOException {

        InputStream input = null;
        OutputStream output = null;
        try {
            // Create FileInputStream and FileOutputStream objects
            input = new FileInputStream(source);
            output = new FileOutputStream(destination);
            byte[] buf = new byte[1024];
            int bytesRead;

            // Write bytes to the destination
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not copy the file to the destination: " + destination.getPath() + ". Check if the folder or file already exists.");
        } finally {
            // Close the streams
            if (input != null) {
                input.close();
            }

            if (output != null) {
                output.close();
            }
        }

        System.out.println("File copied");
 
    }

}
