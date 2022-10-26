/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this templateé
 */
package gui;
import static gui.CatController.connectedUser;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.comment;
import entities.post;
import entities.vote;
import entities.votecomment;
import static gui.CatController.staticcat;
import static gui.CatController.staticpost;

import static gui.CatController.voice;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import javax.swing.JOptionPane;
import services.ServiceComment;
import services.ServicePost;
import services.ServiceVote;
import services.ServiceVotecomment;
import utils.Texttospeech;

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
    private TableColumn<comment, String> colvotecom;
    @FXML
    private TableColumn<comment, String> comaction;
    @FXML
    private TextArea tfcomment;
    @FXML
    private Label lbpostvote;

    public Label getLbposttitle() {
        return lbposttitle;
    }

    public void setLbposttitle(String lbposttitle) {
        this.lbposttitle.setText(lbposttitle);
    }
        

    public Label getLbpostcontent() {
        return lbpostcontent;
    }

    public void setLbpostcontent(String lbpostcontent) {
        this.lbpostcontent.setText(lbpostcontent);
        //Texttospeech t= new Texttospeech();
       // t.speak(lbpostcontent);
    }

    public Label getLbpostvote() {
        return lbpostvote;
    }

    public void setLbpostvote(String lbpostvote) {
        this.lbpostvote.setText(lbpostvote);
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
        
        loadingg();
    }    
     
     public void showguicomment(){
    ServiceComment scom = new ServiceComment();   
    ObservableList<comment> lista = scom.afficherpp(staticpost);
    
    
    colusercom.setCellValueFactory(new PropertyValueFactory<comment,String>("userNAME"));
    colcom.setCellValueFactory(new PropertyValueFactory<comment,String>("commentCONTENT"));
    coldatecom.setCellValueFactory(new PropertyValueFactory<comment,Timestamp>("commentDATE"));
    colvotecom.setCellValueFactory(new PropertyValueFactory<comment,String>("commentVOTE"));
    
    tvcomment.setItems(lista);
   
    
    }
    
    
    
    
    @FXML
    private void BackToMain(ActionEvent event) throws IOException {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("post.fxml"));
        Parent root =loader.load();
        lbpostcontent.getScene().setRoot(root); 
        PostController pc =loader.getController();
        pc.setLbcatpost(staticcat.getCategoryNAME());
        if (voice==1){
        Texttospeech t= new Texttospeech();
         t.speak("you have returned to the post page");}
    
    }
    
    @FXML
    private void ajouterCOMMENT(ActionEvent event) throws IOException {
        ServiceComment scom = new ServiceComment();
       
        
        
       if (!tfcomment.getText().trim().equals("")) {
           scom.ajouter(new comment(tfcomment.getText())); //la méthode getText() retourne toujours une chaine de caractère 
        JOptionPane.showMessageDialog(null,"COMMENT ADDED !");
        showguicomment();
        } else {
           JOptionPane.showMessageDialog(null," FIELD SHOULD NOT BE EMPTY ");
        }
       
       
        
        
     
    }
    
    @FXML
    private void supprimerComment(ActionEvent event) {
        comment c = tvcomment.getSelectionModel().getSelectedItem();
        if ((connectedUser.getrole().equals("Admin"))||(connectedUser.getId()==c.getUserID())){
      
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
        }}else{Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("WARNING");
        alert.setHeaderText("THIS POST DOES NOT BELONG TO YOU ");}
       
        
       
        
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
        if ((connectedUser.getrole().equals("Admin"))||(connectedUser.getId()==c.getUserID())){
        //System.out.println(" ***********"  + e);  
        ServiceComment sc = new ServiceComment();
        sc.modifier(new comment( c.getCommentID(),tfcomment.getText()));
        JOptionPane.showMessageDialog(null,"commentaire modifié ! ");
        showguicomment();
     }else{Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("WARNING");
        alert.setHeaderText("THIS POST DOES NOT BELONG TO YOU ");}
    
    
    
    
    }
    
    
    public void upvote1(ActionEvent event) {
        ServiceVote sv = new ServiceVote();
         post p = staticpost;
         ServicePost sp = new ServicePost();
         p.setUserID(connectedUser.getId());
         vote v =new vote(connectedUser.getId(),p.getPostID(),1);
             
         if (sv.isdisliked(p))
         {   
             
             sv.modifier(v) ;
             sp.plusone(p);
             p.setPostVOTE(p.getPostVOTE()+1);
             sp.plusone(p);
             p.setPostVOTE(p.getPostVOTE()+1);
             lbpostvote.setText(Integer.toString(p.getPostVOTE()));
         }
         else if (sv.isliked(p)){ 
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("WARNING ");
        alert.setHeaderText("already upvoted");
        

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            
            alert.hide();
        } else {
            alert.hide();
        }
         System.out.println("already liked");
         
         }
         else
         {
          sv.like(v);
          sv.modifier(v) ;
          sp.plusone(p);
          lbpostvote.setText(Integer.toString(p.getPostVOTE()));
         }
     }
    
    public void downvote1(ActionEvent event) {
         ServiceVote sv = new ServiceVote();
         post p = staticpost;
         ServicePost sp = new ServicePost();
         p.setUserID(connectedUser.getId());
         vote v =new vote(connectedUser.getId(),p.getPostID(),-1);
             
         if (sv.isliked(p))
         {   
             
             sv.modifier(v) ;
             sp.minusone(p);
             p.setPostVOTE(p.getPostVOTE()-1);
             sp.minusone(p);
             p.setPostVOTE(p.getPostVOTE()-1);
             
             lbpostvote.setText(Integer.toString(p.getPostVOTE()));
         }else if (sv.isdisliked(p)){ 
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("WARNING");
        alert.setHeaderText("already downvoted ");
        

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            
            alert.hide();
        } else {
            alert.hide();
        }
         System.out.println("already disliked");
         
         }else{
          sv.dislike(v);
          sv.modifier(v) ;
         sp.minusone(p);
         lbpostvote.setText(Integer.toString(p.getPostVOTE()));
         }
   
     } 
   
     @FXML
    public void hover(){
        if (voice==1){
    
    Texttospeech t= new Texttospeech();
        
        t.speak("click to return to the post page");}
    
    }
    
    
    
    
    
    
    
    private void loadingg() {

        showguicomment();
       
        colusercom.setCellValueFactory(new PropertyValueFactory<comment, String>("userID"));
        colcom.setCellValueFactory(new PropertyValueFactory<comment, String>("commentCONTENT"));
        colvotecom.setCellValueFactory(new PropertyValueFactory<comment, String>("commentVOTE"));
        coldatecom.setCellValueFactory(new PropertyValueFactory<comment, Timestamp>("commentDATE"));

        //add cell of button edit 
        Callback<TableColumn<comment, String>, TableCell<comment, String>> cellFoctory = (TableColumn<comment, String> param) -> {
            // make cell containing buttons
            final TableCell<comment, String> cell = new TableCell<comment, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.SAFARI);
                        FontAwesomeIconView upicon = new FontAwesomeIconView(FontAwesomeIcon.ARROW_UP);
                        FontAwesomeIconView downicon  = new FontAwesomeIconView(FontAwesomeIcon.ARROW_DOWN);

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
                        upicon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#000000"
                        );
                        downicon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#000000;"
                        );
                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                            
                            comment c = tvcomment.getSelectionModel().getSelectedItem();
        if ((connectedUser.getrole().equals("Admin"))||(connectedUser.getId()==c.getUserID())){
      
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
        }}else{Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("WARNING");
        alert.setHeaderText("THIS POST DOES NOT BELONG TO YOU ");
        alert.show();}

                        });
                        editIcon.setOnMouseClicked((MouseEvent event) -> {
                            comment c = tvcomment.getSelectionModel().getSelectedItem();
        if ((connectedUser.getrole().equals("Admin"))||(connectedUser.getId()==c.getUserID())){
        //System.out.println(" ***********"  + e);  
        ServiceComment sc = new ServiceComment();
        sc.modifier(new comment( c.getCommentID(),tfcomment.getText()));
        JOptionPane.showMessageDialog(null,"commentaire modifié ! ");
        showguicomment();
     }else{Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("WARNING");
        alert.setHeaderText("THIS POST DOES NOT BELONG TO YOU ");
        alert.show();}
    
                        });
                        upicon.setOnMouseClicked((MouseEvent event) -> {
                               
                            upvote();
                           showguicomment();
                            upicon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#00E676;"
                                            );
                            downicon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#000000;"
                        );
                            

                        });
                        downicon.setOnMouseClicked((MouseEvent event) -> {
                            
                            downvote();
                            showguicomment();
                            downicon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#ff1744;"
                        );
                            upicon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#000000;"
                        );
                            showguicomment();
                        });

                        HBox managebtn = new HBox(editIcon, deleteIcon,upicon,downicon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));
                        HBox.setMargin(upicon, new Insets(3, 3, 0, 4));
                        HBox.setMargin(downicon, new Insets(3, 4, 0, 3));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };
        comaction.setCellFactory(cellFoctory);
        showguicomment();
        if (voice==1){
         Texttospeech t= new Texttospeech();
         
        t.speak(" reading post "+staticpost.getPostCONTENT());}
        //studentsTable.setItems(StudentList);
        //tvpost.setItems(lista);

    }
    
    
    
    
    
    
    public void upvote() {
         
         ServiceVotecomment sv = new ServiceVotecomment();
         comment p = tvcomment.getSelectionModel().getSelectedItem();
         ServiceComment sp = new ServiceComment();
         p.setUserID(connectedUser.getId());
         votecomment v =new votecomment(connectedUser.getId(),p.getCommentID(),1);
             
         if (sv.isdisliked(p))
         {   
             
             sv.modifier(v) ;
             sp.plusone(p);
             p.setCommentVOTE(p.getCommentVOTE()+1);
             sp.plusone(p);
         }
         else if (sv.isliked(p)){ 
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("WARNING ");
        alert.setHeaderText("already upvoted");
        

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            
            alert.hide();
        } else {
            alert.hide();
        }
         System.out.println("already liked");
         
         }
         else
         {
          sv.like(v);
          sv.modifier(v) ;
          sp.plusone(p);
         }
   
     }
             
     public void downvote() {
         
         ServiceVotecomment sv = new ServiceVotecomment();
         comment p = tvcomment.getSelectionModel().getSelectedItem();
         ServiceComment sp = new ServiceComment();
         p.setUserID(connectedUser.getId());
         votecomment v =new votecomment(connectedUser.getId(),p.getCommentID(),-1);
             
         if (sv.isliked(p))
         {   
             
             sv.modifier(v) ;
             sp.minusone(p);
                p.setCommentVOTE(p.getCommentVOTE()-1);
             sp.minusone(p);
         }else if (sv.isdisliked(p)){ 
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("WARNING");
        alert.setHeaderText("already downvoted ");
        

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            
            alert.hide();
        } else {
            alert.hide();
        }
         System.out.println("already disliked");
         
         }else{
          sv.dislike(v);
          sv.modifier(v) ;
         sp.minusone(p);
         }
   
     } 
         
}

    

