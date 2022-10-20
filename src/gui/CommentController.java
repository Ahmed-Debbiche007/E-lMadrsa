/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.comment;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import services.ServiceComment;

/**
 * FXML Controller class
 *
 * @author SBS
 */
public class CommentController implements Initializable {

    @FXML
    private Label lbposttitle;
    @FXML
    private Label lbpostcontent;
    @FXML
    private TableView<comment> tvcomment;
    @FXML
    private TableColumn<comment, String> colusercom;
    @FXML
    private TableColumn<comment, String> colcom;
    @FXML
    private TableColumn<comment, Timestamp> coldatecom;
    @FXML
    private TextArea tfcomment;

    public Label getLbposttitle() {
        return lbposttitle;
    }

    public void setLbposttitle(String lbposttitle) {
        this.lbposttitle.setText(lbposttitle);}
        

    public Label getLbpostcontent() {
        return lbpostcontent;
    }

    public void setLbpostcontent(String lbpostcontent) {
        this.lbpostcontent.setText(lbpostcontent);
    }

    public TableView<comment> getTvcomment() {
        return tvcomment;
    }

    public void setTvcomment(TableView<comment> tvcomment) {
        this.tvcomment = tvcomment;
    }
     
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showguicomment();
    }    
     
     public void showguicomment(){
    ServiceComment scom = new ServiceComment();   
     ObservableList<comment> lista = scom.afficherpp(staticpost);
    
    
    colusercom.setCellValueFactory(new PropertyValueFactory<comment,String>("userID"));
    colcom.setCellValueFactory(new PropertyValueFactory<comment,String>("commentCONTENT"));
    coldatecom.setCellValueFactory(new PropertyValueFactory<comment,Timestamp>("commentDATE"));
    
    
    tvcomment.setItems(lista);
    
    
    }
    
    
    
    
    @FXML
    private void BackToMain(ActionEvent event) throws IOException {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("post.fxml"));
        Parent root =loader.load();
        lbpostcontent.getScene().setRoot(root); 
        PostController pc =loader.getController();
        pc.setLbcatpost(staticcat.getCategoryNAME());
    
    }
    
    @FXML
    private void ajouterCOMMENT(ActionEvent event) throws IOException {
        ServiceComment scom = new ServiceComment();
       
        
        
       if (!tfcomment.getText().trim().equals("")) {
           scom.ajouter(new comment(tfcomment.getText())); //la méthode getText() retourne toujours une chaine de caractère 
        JOptionPane.showMessageDialog(null,"Commentaire Ajouté !");
        showguicomment();
        } else {
           JOptionPane.showMessageDialog(null," le champs ne doit pas etre vide ");
        }
       
       
        
        
     
    }
    
    @FXML
    private void supprimerComment(ActionEvent event) {
        comment c = tvcomment.getSelectionModel().getSelectedItem();
      
        ServiceComment sc = new ServiceComment();
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation supp ");
        alert.setHeaderText("Confirmation suppression commentaire");
        alert.setContentText("Avec confirmation cette categorie va être supprimé commentaire difinitive");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        sc.supprimer(c);
        JOptionPane.showMessageDialog(null,"commentaire supprimé ! ");
        showguicomment();
        alert.hide();
         } else {
            alert.hide();
        }
       
        
       
        
    }
    
    @FXML
    private void editcat2(ActionEvent event) {
                     if(tvcomment.getSelectionModel().getSelectedItem()!=null) {
             comment c = tvcomment.getSelectionModel().getSelectedItem();
             

             tfcomment.setText(c.getCommentCONTENT());
          
             
               
    }    
                     
    }
    
    
    @FXML
    
    private void modifiercomment(ActionEvent event) {
        
        comment c = tvcomment.getSelectionModel().getSelectedItem();
        //System.out.println(" ***********"  + e);  
        ServiceComment sc = new ServiceComment();
        sc.modifier(new comment( c.getCommentID(),tfcomment.getText()));
        JOptionPane.showMessageDialog(null,"commentaire modifié ! ");
        showguicomment();
     }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
