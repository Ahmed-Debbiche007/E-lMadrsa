/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;
import static gui.CatController.connectedUser;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import entities.post;
import entities.vote;
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
import static gui.CatController.connectedUser;
import static gui.CatController.voice;
import services.ServiceVote;
import utils.Texttospeech;
///////////////////////////////////////////

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
    @FXML
    public TableColumn<post, String> action;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //connectedUser.getId()=1;
        // TODO
        //showguipost();
        loadingg();

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
        this.lbcatpost.setText(lbcatpost);
    }

    public void showguipost() {
        ServicePost sp = new ServicePost();
        ObservableList<post> lista = sp.afficherpp(staticcat);

        colposttitle.setCellValueFactory(new PropertyValueFactory<post, String>("postTITLE"));
        colpostedby.setCellValueFactory(new PropertyValueFactory<post, String>("userNAME"));
        colpostvotes.setCellValueFactory(new PropertyValueFactory<post, String>("postVOTE"));
        colpostcomments.setCellValueFactory(new PropertyValueFactory<post, String>("postNBCOM"));
        colpostdate.setCellValueFactory(new PropertyValueFactory<post, Timestamp>("postDATE"));
        System.out.println(lista);
                
        tvpost.setItems(lista);

    }

    @FXML
    private void supprimerpost(ActionEvent event) {
        
        post p = tvpost.getSelectionModel().getSelectedItem();
        
        if ((connectedUser.getrole().equals("Admin"))||(connectedUser.getId()==p.getUserID())){
        
         ServicePost sp = new ServicePost();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation supp ");
        alert.setHeaderText("Confirmation suppression publication intitulée : " + p.getPostTITLE());
        alert.setContentText("Avec confirmation cette PUBLICATION va être supprimé d'un manière difinitive");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            sp.supprimer(p);
            JOptionPane.showMessageDialog(null, "publication supprimée ! ");
            showguipost();
            alert.hide();
        } else {
            alert.hide();
        }
        
        
        
        
        }

        else{Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("WARNING");
        alert.setHeaderText("THIS POST DOES NOT BELONG TO YOU ");}

    }

    @FXML
    private void modifierpost(ActionEvent event) throws IOException {
        
        if (tvpost.getSelectionModel().getSelectedItem() != null) {
            staticpost = tvpost.getSelectionModel().getSelectedItem();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("post_edit_add.fxml"));
            Parent root = loader.load();
            tvpost.getScene().setRoot(root);

            Post_edit_addController pea = loader.getController();
            pea.getTapostcontent().setText(staticpost.getPostCONTENT());
            pea.getTaposttitle().setText(staticpost.getPostTITLE());
            pea.getTfuseridpost().setText(Long.toString(staticpost.getUserID()));

        }
        
    }

    @FXML
    private void kbalajouterpost(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("post_edit_add.fxml"));
        Parent root = loader.load();
        tvpost.getScene().setRoot(root);
        //Post_edit_addController pes=loader.getController();
        //pes.getTfuseridpost().setText(Long.toString(staticpost.getUserID()));

    }

    @FXML
    private void BackToMain(ActionEvent event) throws IOException {
        Stage stage;
        Parent root = FXMLLoader.load(getClass().getResource("cat.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        //stage.show();
    }

    @FXML
    private void acceder(ActionEvent event) throws IOException {
        if (tvpost.getSelectionModel().getSelectedItem() != null) {
            staticpost = tvpost.getSelectionModel().getSelectedItem();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("comment.fxml"));
            Parent root = loader.load();
            tvpost.getScene().setRoot(root);
            //PostController pc =loader.getController();
            //pc.setLbcatpost(staticcat.getCategoryNAME());
            CommentController cc = loader.getController();
            cc.setLbposttitle(staticpost.getPostTITLE());
            cc.setLbpostcontent(staticpost.getPostCONTENT());
            cc.setLbpostvote(Integer.toString(staticpost.getPostVOTE()));
            
            
             
                                          

        }

    } 
     @FXML
    public void hoveraccpost(){
        if (voice==1){
            if (tvpost.getSelectionModel().getSelectedItem() != null) {
    
                Texttospeech t= new Texttospeech();
        
                t.speak("you are about to reach the post"+tvpost.getSelectionModel().getSelectedItem().getPostTITLE());}
             if (tvpost.getSelectionModel().getSelectedItem() == null){
              Texttospeech t= new Texttospeech();
        
                t.speak("please select a post before clicking");}
    
    }
    
    }

    private void loadingg() {

        showguipost();
        
         
        colposttitle.setCellValueFactory(new PropertyValueFactory<post, String>("postTITLE"));
        colpostedby.setCellValueFactory(new PropertyValueFactory<post, String>("userID"));
        colpostvotes.setCellValueFactory(new PropertyValueFactory<post, String>("postVOTE"));
        colpostcomments.setCellValueFactory(new PropertyValueFactory<post, String>("postNBCOM"));
        colpostdate.setCellValueFactory(new PropertyValueFactory<post, Timestamp>("postDATE"));

        //add cell of button edit 
        Callback<TableColumn<post, String>, TableCell<post, String>> cellFoctory = (TableColumn<post, String> param) -> {
            // make cell containing buttons
            final TableCell<post, String> cell = new TableCell<post, String>() {
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
                           post p = tvpost.getSelectionModel().getSelectedItem();
        
        if ((connectedUser.getrole().equals("Admin"))||(connectedUser.getId()==p.getUserID())){
        
         ServicePost sp = new ServicePost();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation supp ");
        alert.setHeaderText("Confirmation suppression publication intitulée : " + p.getPostTITLE());
        alert.setContentText("Avec confirmation cette PUBLICATION va être supprimé d'un manière difinitive");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            sp.supprimer(p);
            JOptionPane.showMessageDialog(null, "publication supprimée ! ");
            showguipost();
            alert.hide();
        } else {
            alert.hide();
        }
        
        
        
        
        }else{Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("WARNING");
        alert.setHeaderText("THIS POST DOES NOT BELONG TO YOU ");
        alert.show();
        }
        
                        });
                        editIcon.setOnMouseClicked((MouseEvent event) -> {
                            post p=tvpost.getSelectionModel().getSelectedItem();
                            if ((connectedUser.getrole().equals("Admin"))||(connectedUser.getId()==p.getUserID())){
                            if (tvpost.getSelectionModel().getSelectedItem() != null) {
                                staticpost = tvpost.getSelectionModel().getSelectedItem();
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("post_edit_add.fxml"));
                                Parent root;
                                try {
                                    root = loader.load();
                                    tvpost.getScene().setRoot(root);
                                } catch (IOException ex) {
                                    Logger.getLogger(PostController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                

                                Post_edit_addController pea = loader.getController();
                                pea.getTapostcontent().setText(staticpost.getPostCONTENT());
                                pea.getTaposttitle().setText(staticpost.getPostTITLE());
                                pea.getTfuseridpost().setText(Long.toString(staticpost.getUserID()));}

                            } else{Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("WARNING");
        alert.setHeaderText("THIS POST DOES NOT BELONG TO YOU ");
                            alert.show();}

                        });
                        upicon.setOnMouseClicked((MouseEvent event) -> {

                            upvote();
                           showguipost();
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
                            showguipost();
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
                            showguipost();
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
        action.setCellFactory(cellFoctory);
        showguipost();
        
        //studentsTable.setItems(StudentList);
        //tvpost.setItems(lista);

    }
    
    

    
     public void upvote() {
         
         ServiceVote sv = new ServiceVote();
         post p = tvpost.getSelectionModel().getSelectedItem();
         ServicePost sp = new ServicePost();
         p.setUserID(connectedUser.getId());
         vote v =new vote(connectedUser.getId(),p.getPostID(),1);
             
         if (sv.isdisliked(p))
         {   
             
             sv.modifier(v) ;
             sp.plusone(p);
             p.setPostVOTE(p.getPostVOTE()+1);
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
         
         ServiceVote sv = new ServiceVote();
         post p = tvpost.getSelectionModel().getSelectedItem();
         ServicePost sp = new ServicePost();
         p.setUserID(connectedUser.getId());
         vote v =new vote(connectedUser.getId(),p.getPostID(),-1);
             
         if (sv.isliked(p))
         {   
             
             sv.modifier(v) ;
             sp.minusone(p);
             p.setPostVOTE(p.getPostVOTE()-1);
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
