/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

 import entities.Question;
import entities.Quiz;

import java.io.IOException;
import java.net.URL;

import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.QuestionService;
import services.QuizService;

/**
 * FXML Controller class
 *
 * @author Msi
 */
public class AjoutQuestionController implements Initializable {

    @FXML
    private TextArea lbEnnonce;
    @FXML
    private TableView<Question> tvQuestion;
    @FXML
    private TableColumn<Question,String> colEnnonce;
    private TableColumn<Question, Long> colIdQuiz;
    @FXML
    private TableView<Quiz> tvQuiz;
    @FXML
    private TableColumn<Quiz,String> colQuizName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       showQuestions();
        showQuiz() ;
      }    

    @FXML
    private void ajuoterQuestion(ActionEvent event) {
        
        QuestionService  QS = new QuestionService() ;
        Quiz q = tvQuiz.getSelectionModel().getSelectedItem() ;
        QS.ajouter(new Question(lbEnnonce.getText(),q.getIdQuizz()));
        System.out.println("id du quiz séléctionné : " + q.getIdQuizz()) ; 
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
    
    

          public void showQuestions() {
        QuestionService QS = new QuestionService() ;
        ObservableList<Question> list = QS.afficher() ;
        System.out.println(list ) ; 
        colEnnonce.setCellValueFactory(new PropertyValueFactory<Question,String>("ennonce"));
        System.out.println(list);
        tvQuestion.setItems(list);        
    }

    @FXML
    private void editQuestion(ActionEvent event) {
    }
    
                      public void showQuiz() {
                    QuizService QS= new QuizService() ;
                    ObservableList<Quiz> list = QS.afficher() ;
                    System.out.println(list ) ; 
                    colQuizName.setCellValueFactory(new PropertyValueFactory<Quiz,String>("nameQuizz"));
                    System.out.println(list);
                    tvQuiz.setItems(list);
                    System.out.println("pppppppppppp"  +  list ) ;
        
    }
    
}
