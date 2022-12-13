/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import com.google.common.hash.Hashing;
import entities.User;
import static gui.AuthController.connectedUser;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import services.UtilisateurService;


/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class AjoutUserController implements Initializable {

    @FXML
    private TextField fnom;
    @FXML
    private PasswordField fprenom;
    @FXML
    private TextField fprenomshow;
    @FXML
    private CheckBox check;

    /**
     * Initializes the controller class.
     * 
     */
    private static User u1 ;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void AjoutPersonne(ActionEvent event) throws IOException {
        UtilisateurService SP = new UtilisateurService();
        User u = SP.getByUserName(fnom.getText());
        //System.out.println(u);
        String pass;
        if (check.isSelected()) {
            pass = fprenomshow.getText();
        }else{
            pass = fprenom.getText();
        }
        String  hashPass = Hashing.sha256().hashString(pass, StandardCharsets.UTF_8).toString();
        
        if (u.getmotDePasse().equals(hashPass)) {
            JOptionPane.showMessageDialog(null, "Connected ");
            u1 = u;
            FXMLLoader loader = null;
            if (u.getrole().name().equals("Student")){
                loader = new FXMLLoader(getClass().getResource("./Students/Home.fxml"));
            }
            if (u.getrole().name().equals("Tutor")){
                loader = new FXMLLoader(getClass().getResource("./Tutors/Home.fxml"));
            }
            
            Parent root ; 
        
            root = loader.load();
            check.getScene().setRoot(root);
        } else {
            JOptionPane.showMessageDialog(null, "Error! ");
        }
        /* JOptionPane.showMessageDialog(null,"Personne Ajoutée ! ");
      
        
        
        //redirection vers l'interface thenya 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailPersonne.fxml")) ;
        Parent root ; 
        
            root = loader.load();
            fnom.getScene().setRoot(root);
        
        
        DetailPersonneController dpc = loader.getController();
        dpc.setTfnom(fnom.getText());
        dpc.setTfprenom(fprenom.getText());
        
         */

    }

    public User getU() {
        return u1;
    }
    

    @FXML
    private void showpassword(ActionEvent event) {
        if (check.isSelected()) {
            fprenom.setOpacity(0);
            fprenomshow.setOpacity(1);
            fprenomshow.setText(fprenom.getText());
        }else{
             fprenom.setOpacity(1);
            fprenomshow.setOpacity(0);
            fprenom.setText(fprenomshow.getText());
        }
    }

}
