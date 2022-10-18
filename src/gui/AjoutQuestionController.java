/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Examen;
 import entities.Question;
import entities.Quiz;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import outils.MyDB;
import services.ExamenService;
import services.QuestionService;

/**
 * FXML Controller class
 *
 * @author Msi
 */
public class AjoutQuestionController implements Initializable {

    @FXML
    private TextArea lbEnnonce;
    @FXML
    private TextField lbIdQuiz;
    @FXML
    private TableView<Question> tvQuestion;
    @FXML
    private TableColumn<Question,String> colEnnonce;
    @FXML
    private TableColumn<Question, Long> colIdQuiz;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showQuestions();
      }    

    @FXML
    private void ajuoterQuestion(ActionEvent event) {
        
                QuestionService  QS = new QuestionService() ;
        QS.ajouter(new Question(lbEnnonce.getText()));
        JOptionPane.showMessageDialog(null,"Question Ajoutée ! ");
        showQuestions() ;
        
        
    }

    @FXML
    private void modifierQuestion(ActionEvent event) {
        Question q = tvQuestion.getSelectionModel().getSelectedItem();
        QuestionService  QE = new QuestionService() ;
        QE.modifier(new Question(q.getIdQuestion(),lbEnnonce.getText()));
        JOptionPane.showMessageDialog(null,"Question modifié ! ");
        showQuestions() ;
    }

    @FXML
    private void supprimerQuestion(ActionEvent event) {
        
                Question q = tvQuestion.getSelectionModel().getSelectedItem();
        //System.out.println(" ***********"  + e);  
        QuestionService  QS = new QuestionService() ;
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation supp ");
        alert.setHeaderText("Confirmation suppression question intitulé : " + q.getEnnonce());
        alert.setContentText("Avec confirmation cette question  va être supprimé d'un manière difinitive");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        QS.supprimer(q);
        JOptionPane.showMessageDialog(null,"examen supprimé ! ");
        showQuestions() ;
        alert.hide();
         } else {
            alert.hide();
        }
        
    }

    
    
    @FXML
    private void BackToMain(ActionEvent event) throws IOException {
    Stage stage ;
    Parent root = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    Scene scene=new Scene(root);
    stage.setScene(scene);
    stage.show();
    
    }
    
    
    
    
    
            public  ObservableList<Question> afficher() {
                   ObservableList<Question>  listQuestion =  FXCollections.observableArrayList() ;
                       Connection cnx ; 
                       cnx = MyDB.getInstance().getCnx();
            try {
                String req = "select * from Question" ;
                PreparedStatement st = cnx.prepareStatement(req) ; 
                 ResultSet rs = st.executeQuery(req) ;
 
                
                            while (rs.next()) {
                listQuestion.add(new Question( rs.getLong("idQuestion"),rs.getString("ennonce") ));
            }    
            } catch (SQLException ex) {
                System.out.println("error occured");  
            }
              return listQuestion ;
     }
          public void showQuestions() {
        ObservableList<Question> list = afficher() ;
        System.out.println(list ) ; 
        colEnnonce.setCellValueFactory(new PropertyValueFactory<Question,String>("ennonce"));
         colIdQuiz.setCellValueFactory(new PropertyValueFactory<Question,Long>("idQuiz"));
        System.out.println(list);
        tvQuestion.setItems(list);        
    }
    
}
