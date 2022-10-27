/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import com.google.common.hash.Hashing;
import entities.User;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.JOptionPane;
import outils.MailValidator;
import services.UtilisateurService;

/**
 * FXML Controller class
 *
 * @author Nour
 */
public class AjoutPersonneController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private Button btnAjoute;
    @FXML
    private TextField tfNomUtilisateur;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfmotdepasse;
    @FXML
    private DatePicker tfdatenaissance;
    @FXML
    private Button btnModifie;
    @FXML
    private Button btnSupprime;
    @FXML
    private TableView<User> tvUtilisateur;
    @FXML
    private TableColumn<User, String> colNom;
    @FXML
    private TableColumn<User, String> colPrenom;
    @FXML
    private TableColumn<User, String> colNomUtilisateur;
    @FXML
    private TableColumn<User, String> coltlf;
    @FXML
    private TableColumn<User, String> colemail;
    @FXML
    private TableColumn<User, String> coldatenaissance;
    @FXML
    private TableColumn<User, String> colImage;

    @FXML
    private Button btnselecte;
    @FXML
    private Button btndcnx;
    @FXML
    private TextField tftel;
    @FXML
    private TextField tfdate;

    private Connection connect;
    private Statement statement;
    private PreparedStatement prepare;
    private ResultSet result;
    @FXML
    private ComboBox<String> tfrole;
    @FXML
    private TableColumn<User, String> colrole;
    ObservableList typeChoices = FXCollections.observableArrayList("Student", "Admin", "Tutor");
    ObservableList rolesList = FXCollections.observableArrayList("All", "Student", "Admin", "Tutor");

    @FXML
    private ComboBox<String> roles;

    String img;

    /**
     * Initializes the controller class.
     */
    public void afficherPersonne() {

        UtilisateurService us = new UtilisateurService();
        ObservableList<User> liste = us.afficher();

        colNom.setCellValueFactory(new PropertyValueFactory<User, String>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<User, String>("prenom"));
        colNomUtilisateur.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getnomUtilisateur()));
        coltlf.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().gettel()));
        colemail.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getemail()));
        colrole.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getrole().toString()));
        coldatenaissance.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getdateNaissance().toString()));
        colImage.setCellValueFactory(new PropertyValueFactory<User, String>("image"));

        tvUtilisateur.setItems(liste);

    }

    @FXML
    private void ajouterPersonne(ActionEvent event) throws ParseException {
        MailValidator m = new MailValidator();
        UtilisateurService us = new UtilisateurService();

        if (tfNom.getText().isEmpty() | tfPrenom.getText().isEmpty() | tfNomUtilisateur.getText().isEmpty() | tfrole.getValue().isEmpty() | tftel.getText().isEmpty() | tfemail.getText().isEmpty() | tfmotdepasse.getText().isEmpty()) {
            Alert alertt = new Alert(Alert.AlertType.ERROR);
            alertt.setTitle("Error Message");
            alertt.setHeaderText(null);
            alertt.setContentText("Enter all your informations!");
        } else if (us.usernameExists(tfNomUtilisateur.getText())) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error Message");
            alerta.setHeaderText(null);
            alerta.setContentText("Username Exists!");
            alerta.showAndWait();
        } else if (us.getByMail(tfemail.getText()) != null) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error Message");
            alerta.setHeaderText(null);
            alerta.setContentText("Email Exists!");
            alerta.showAndWait();
        } else if (tfmotdepasse.getText().length() < 8) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error Message");
            alerta.setHeaderText(null);
            alerta.setContentText("Invalid Password!");
            alerta.showAndWait();

        } else if (!m.validationEmail(tfemail.getText())) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error Message");
            alerta.setHeaderText(null);
            alerta.setContentText("Invalid Email!");
            alerta.showAndWait();
        } else {

            String hashPass = Hashing.sha256().hashString(tfmotdepasse.getText(), StandardCharsets.UTF_8).toString();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dateStr = df.parse(tfdatenaissance.getValue().toString());
            java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());

            User u = new User(tfNom.getText(), tfPrenom.getText(), tfNomUtilisateur.getText(), tftel.getText(), tfemail.getText(), hashPass, (Date) dateDB, img, tfrole.getValue().toString(), true);
            us.ajouter(u);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sign up Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully create new user!");
            alert.showAndWait();

            afficherPersonne();

            tfNom.setText("");
            tfPrenom.setText("");
            tfNomUtilisateur.setText("");
            tftel.setText("");
            tfemail.setText("");
            tfdatenaissance.getEditor().clear();
            
            tfrole.setValue("");
        }
    }

    @FXML
    private void supprimerPersonne(ActionEvent event) {
        User n = tvUtilisateur.getSelectionModel().getSelectedItem();

        UtilisateurService us = new UtilisateurService();
        us.supprimer(n);
        JOptionPane.showMessageDialog(null, "User Supprimée ! ");
        afficherPersonne();
    }

    @FXML
    private void modifierPersonne(ActionEvent event) throws ParseException {

        String hashPass = Hashing.sha256().hashString(tfmotdepasse.getText(), StandardCharsets.UTF_8).toString();
        User n = x;
        UtilisateurService us = new UtilisateurService();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dateStr = df.parse(n.getdateNaissance().toString());
        java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());

        n.setdateNaissance(dateDB);
        n.setNom(tfNom.getText());
        n.setPrenom(tfPrenom.getText());
        n.setnomUtilisateur(tfNomUtilisateur.getText());
        n.settel(tftel.getText());
        n.setemail(tfemail.getText());
        n.setmotDePasee(hashPass);
        if (!img.isEmpty()) {
            n.setImage(img);
        }
        n.setRole(tfrole.getValue());

        us.modifier(n);
        JOptionPane.showMessageDialog(null, "user modifié ! ");
        afficherPersonne();
    }
    User x;

    @FXML
    private void editcat2(ActionEvent event) {
        if (tvUtilisateur.getSelectionModel().getSelectedItem() != null) {
            User n = tvUtilisateur.getSelectionModel().getSelectedItem();
            x = n;
            tfNom.setText(n.getNom());
            tfPrenom.setText(n.getPrenom());
            tfNomUtilisateur.setText(n.getnomUtilisateur());
            tftel.setText(n.gettel());
            tfemail.setText(n.getemail());
            tfdatenaissance.setValue(n.getdateNaissance().toLocalDate());
            img=n.getImage();
            tfrole.setValue(n.getrole().name());

        }
    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getResource("auth.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherPersonne();
        tfrole.getItems().setAll(typeChoices);
        roles.getItems().setAll(rolesList);
        roles.setValue(rolesList.get(0).toString());

    }

    @FXML
    private void refresh(ActionEvent event) {
        String role = roles.getValue().toString();
        if (role.equals("All")) {
            afficherPersonne();
        } else {

            UtilisateurService us = new UtilisateurService();
            ObservableList<User> liste = us.getAllByMail(role);

            colNom.setCellValueFactory(new PropertyValueFactory<User, String>("nom"));
            colPrenom.setCellValueFactory(new PropertyValueFactory<User, String>("prenom"));
            colNomUtilisateur.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getnomUtilisateur()));
            coltlf.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().gettel()));
            colemail.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getemail()));
            colrole.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getrole().toString()));
            coldatenaissance.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getdateNaissance().toString()));
            colImage.setCellValueFactory(new PropertyValueFactory<User, String>("image"));

            tvUtilisateur.setItems(liste);

        }
        //System.out.println(liste);

    }

    @FXML
    private void ajouterimage(ActionEvent event) throws IOException {
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Choose image");
        Window ownerWindow = null;
        File file = filechooser.showOpenDialog(ownerWindow);
        String command = "cp " + file.getAbsolutePath() + " " + System.getProperty("user.dir") + "/src/images/users/" + file.getName();
        Process process = Runtime.getRuntime().exec(command);

        img = file.getName();
    }

}
