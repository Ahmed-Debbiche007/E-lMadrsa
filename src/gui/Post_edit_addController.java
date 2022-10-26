/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;
import static gui.CatController.connectedUser;
import entities.category;
import entities.post;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import services.ServiceCategory;
import services.ServicePost;
import static gui.CatController.staticcat;
import static gui.CatController.staticpost;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class Post_edit_addController implements Initializable {

    @FXML
    private TextArea tapostcontent;
    @FXML
    private TextArea taposttitle;
    @FXML
    private TextField tfuseridpost;

    public TextArea getTapostcontent() {
        return tapostcontent;
    }

    public void setTapostcontent(TextArea tapostcontent) {
        this.tapostcontent = tapostcontent;
    }

    public TextArea getTaposttitle() {
        return taposttitle;
    }

    public void setTaposttitle(TextArea taposttitle) {
        this.taposttitle = taposttitle;
    }

    public TextField getTfuseridpost() {
        return tfuseridpost;
    }

    public void setTfuseridpost(TextField tfuseridpost) {
        this.tfuseridpost = tfuseridpost;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     @FXML
    private void ajouterPost(ActionEvent event) throws IOException {
        ServicePost sp = new ServicePost();
         
        
        sp.ajouter(new post(taposttitle.getText(),tapostcontent.getText())); //la méthode getText() retourne toujours une chaine de caractère 
        JOptionPane.showMessageDialog(null,"POST ADDED !");
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("post.fxml"));
        Parent root =loader.load();
        tapostcontent.getScene().setRoot(root); 
        PostController pc =loader.getController();
        pc.setLbcatpost(staticcat.getCategoryNAME());
    }
     @FXML
    private void modifierPost(ActionEvent event) throws IOException {
        ///post p=tvpost.getSelectionModel().getSelectedItem();
       
        ServicePost sp = new ServicePost();
         
        
        sp.modifier(new post(staticpost.getPostID(),taposttitle.getText(),tapostcontent.getText())); //la méthode getText() retourne toujours une chaine de caractère 
        JOptionPane.showMessageDialog(null,"publication modifiée !");
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("post.fxml"));
        Parent root =loader.load();
        tapostcontent.getScene().setRoot(root); 
        PostController pc =loader.getController();
        pc.setLbcatpost(staticcat.getCategoryNAME());}
       

    }
    
    
    
    

