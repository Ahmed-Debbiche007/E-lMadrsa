/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.category;
import entities.post;
import entities.OLD;
import entities.User;
import static gui.CatController.staticpost;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import services.ServiceCategory;
import services.ServicePost;
import gui.PostController;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.util.Callback;
import javax.imageio.ImageIO;
import utils.Texttospeech;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class CatController implements Initializable {

    @FXML
    private TextField tfnomcat;
    @FXML
    private TextField tfimage;
    @FXML
    private TableView<category> tvcat;
    @FXML
    private TableColumn<category, String> colimage;
    @FXML
    private TableColumn<category, String> colnomcat;
    @FXML
    private TableColumn<category, ImageView> realimage;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    @FXML
    private Button edit2;
    @FXML
    private Button btnacceder;

    public static category staticcat;
    public static post staticpost;
    public static long staticuserid;
    //public static OLD staticuser = new OLD("LASAAD");
    public static User user;
    public static int voice = 0;
    public static int block = 0;
    public String img;
    
    
    public static User connectedUser= new User(2L,"hamma","rkhis");
    
    @FXML
    private Button chooseimg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         if (block == 0) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("text to speech ");
            alert.setHeaderText("text to speech ");
            alert.setContentText("would you like to activate text to speech ");
            Texttospeech t = new Texttospeech();

            t.speak("would you like to activate text to speech ?");

            t.speak("if so please press enter");

            t.speak("if not press the right arrow then enter");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                voice = 1;
                block = 1;

                alert.hide();
            } else {
                block = 1;
                voice = 0;
                alert.hide();
            }
        }
        showguicat();

    }

    public void showguicat() {
        ServiceCategory sc = new ServiceCategory();
        ObservableList<category> lista = sc.afficher();

        colnomcat.setCellValueFactory(new PropertyValueFactory<category, String>("categoryNAME"));
        colimage.setCellValueFactory(new PropertyValueFactory<category, String>("categoryIMAGE"));
        realimage.setCellValueFactory(new PropertyValueFactory<category, ImageView>("image"));
        lista.forEach(new Consumer<category>() {
            @Override
            public void accept(category item) {
                String path = "/images/"+item.getCategoryIMAGE();
                ImageView img =new ImageView(new Image(CatController.this.getClass().getResourceAsStream(path)));
                img.setFitHeight(50);
                img.setFitWidth(50);
                item.setImage(img);
            }
            
        });
        System.out.println(lista.get(0).getImage().getImage().getWidth());
        tvcat.setItems(lista);
        if (voice == 1) {
            Texttospeech t = new Texttospeech();
            t.speak("you have reached the category page");
        }

    }

    @FXML
    private void ajouterCategory(ActionEvent event) throws IOException {
        ServiceCategory sp = new ServiceCategory();

        if (!tfnomcat.getText().trim().matches(".*[0-9].*") && !img.trim().equals("")) {
            sp.ajouter(new category(tfnomcat.getText(), img)); //la méthode getText() retourne toujours une chaine de caractère 
            JOptionPane.showMessageDialog(null, "Category Ajoutée !");
            showguicat();
        } else {
            JOptionPane.showMessageDialog(null, " le champs doit contenir des lettres seulement ! ");
            
        }
        //showguicat();
    }

    @FXML
    private void supprimerCategory(ActionEvent event) {
        category c = tvcat.getSelectionModel().getSelectedItem();

        ServiceCategory sc = new ServiceCategory();

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation supp ");
        alert.setHeaderText("Confirmation suppression category intitulé : " + c.getCategoryNAME());
        alert.setContentText("Avec confirmation cette categorie va être supprimé d'un manière difinitive");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            sc.supprimer(c);
            JOptionPane.showMessageDialog(null, "category supprimée ! ");
            showguicat();
            alert.hide();
        } else {
            alert.hide();
        }

    }

    @FXML

    private void modifiercategory(ActionEvent event) {

        category c = tvcat.getSelectionModel().getSelectedItem();
        //System.out.println(" ***********"  + e);  
        ServiceCategory sc = new ServiceCategory();
        sc.modifier(new category(c.getCategoryID(), tfnomcat.getText(), img));
        JOptionPane.showMessageDialog(null, "categorie modifié ! ");
        showguicat();
    }

    @FXML
    private void editcat2(ActionEvent event) {
        if (tvcat.getSelectionModel().getSelectedItem() != null) {
            category c = tvcat.getSelectionModel().getSelectedItem();

            tfnomcat.setText(c.getCategoryNAME());
            //tfimage.setText(c.getCategoryIMAGE());

        }

    }

    @FXML
    private void acce(ActionEvent event) throws IOException {
        if (tvcat.getSelectionModel().getSelectedItem() != null) {
            staticcat = tvcat.getSelectionModel().getSelectedItem();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("post.fxml"));
            Parent root = loader.load();
            tvcat.getScene().setRoot(root);
            PostController pc = loader.getController();
            pc.setLbcatpost(staticcat.getCategoryNAME());
            if (voice == 1) {
                Texttospeech t = new Texttospeech();

                t.speak("it says" + staticcat.getCategoryNAME());
            }

        }

    }

    @FXML
    private void ajouterimg(ActionEvent event) throws IOException {
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Choose image");
        Window ownerWindow = null;
        File file = filechooser.showOpenDialog(ownerWindow);
        
        String command = "cp "+file.getAbsolutePath()+" "+System.getProperty("user.dir")+"\\src\\images\\"+file.getName();
        Process process = Runtime.getRuntime().exec(command);
        img = file.getName();

    }

   
}
