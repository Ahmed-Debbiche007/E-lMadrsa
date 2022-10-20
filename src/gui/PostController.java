/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.category;
import entities.post;
import static gui.CatController.staticcat;
import static gui.CatController.staticpost;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Optional;
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
import services.ServiceCategory;
import services.ServicePost;
import gui.Post_edit_addController;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class PostController implements Initializable {

    @FXML
    private TableView<post> tvpost;
    @FXML
    private Label lbcatpost;
    @FXML
    public TableColumn<post, String> colposttitle;
    @FXML
    public TableColumn<post, String> colpostedby;
    @FXML
    public TableColumn<post, String> colpostvotes;
    @FXML
    public TableColumn<post, String> colpostcomments;
    @FXML
    public TableColumn<post, Timestamp> colpostdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        showguipost();
        
    }    

    public TableView<post> getTvpost() {
        return tvpost;
    }

    public void setTvpost(TableView<post> tvpost) {
        this.tvpost = tvpost;
    }

    public Label getLbcatpost() {
        return lbcatpost;
    }

    public void setLbcatpost(String lbcatpost) {
        this.lbcatpost.setText(lbcatpost) ;
    }
    
    
    
    
    
    
     public void showguipost(){
    ServicePost sp = new ServicePost();   
        ObservableList<post> lista = sp.afficherpp(staticcat);
    
    
    colposttitle.setCellValueFactory(new PropertyValueFactory<post,String>("postTITLE"));
    colpostedby.setCellValueFactory(new PropertyValueFactory<post,String>("userID"));
    colpostvotes.setCellValueFactory(new PropertyValueFactory<post,String>("postVOTE"));
    colpostcomments.setCellValueFactory(new PropertyValueFactory<post,String>("postNBCOM"));
    colpostdate.setCellValueFactory(new PropertyValueFactory<post,Timestamp>("postDATE"));
    
    
    tvpost.setItems(lista);
    
    
    }
    
     @FXML
    private void supprimerpost(ActionEvent event) {
        post p = tvpost.getSelectionModel().getSelectedItem();
      
        ServicePost sp = new ServicePost();
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation supp ");
        alert.setHeaderText("Confirmation suppression publication intitulée : " + p.getPostTITLE());
        alert.setContentText("Avec confirmation cette PUBLICATION va être supprimé d'un manière difinitive");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        sp.supprimer(p);
        JOptionPane.showMessageDialog(null,"publication supprimée ! ");
        showguipost();
        alert.hide();
         } else {
            alert.hide();
        }
       
        
        

    }
    
    @FXML
    private void modifierpost(ActionEvent event) throws IOException {
                     if(tvpost.getSelectionModel().getSelectedItem()!=null) {
             staticpost = tvpost.getSelectionModel().getSelectedItem();
             FXMLLoader loader= new FXMLLoader(getClass().getResource("post_edit_add.fxml"));
        Parent root =loader.load();
        tvpost.getScene().setRoot(root); 
        
        Post_edit_addController pea=loader.getController();
         pea.getTapostcontent().setText(staticpost.getPostCONTENT());
         pea.getTaposttitle().setText(staticpost.getPostTITLE());
         pea.getTfuseridpost().setText(Long.toString(staticpost.getUserID()));
        
             
               
    }    
                  
    }
    
     @FXML
    private void kbalajouterpost(ActionEvent event) throws IOException {
                     
        FXMLLoader loader= new FXMLLoader(getClass().getResource("post_edit_add.fxml"));
        Parent root =loader.load();
        tvpost.getScene().setRoot(root); 
        //Post_edit_addController pes=loader.getController();
        //pes.getTfuseridpost().setText(Long.toString(staticpost.getUserID()));
      
                  
    }
     @FXML
    private void BackToMain(ActionEvent event) throws IOException {
            Stage stage ;
    Parent root = FXMLLoader.load(getClass().getResource("cat.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    Scene scene=new Scene(root);
    stage.setScene(scene);
    //stage.show();
    }
    
    @FXML
    private void acceder(ActionEvent event) throws IOException {
                     if(tvpost.getSelectionModel().getSelectedItem()!=null) {
             staticpost = tvpost.getSelectionModel().getSelectedItem();
             FXMLLoader loader= new FXMLLoader(getClass().getResource("comment.fxml"));
        Parent root =loader.load();
        tvpost.getScene().setRoot(root); 
        //PostController pc =loader.getController();
        //pc.setLbcatpost(staticcat.getCategoryNAME());
        CommentController cc =loader.getController();
        cc.setLbposttitle(staticpost.getPostTITLE());
        cc.setLbpostcontent(staticpost.getPostCONTENT());
        
             
               
    }    
    
    } 
}
