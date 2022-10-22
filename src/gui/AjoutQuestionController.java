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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.ExamenService;
import services.QuestionService;
import services.QuizService;

/**
 * FXML Controller class
 *
 * @author Msi
 */
public class AjoutQuestionController implements Initializable {

    @FXML
    private TextField lbEnnonce;
    @FXML
    private TableView<Question> tvQuestion;
    @FXML
    private TableColumn<Question,String> colEnnonce;
    private TableColumn<Question, Long> colIdQuiz;
     private TableColumn<Quiz,String> colQuizName;
    @FXML
    private Label idExamlabel;
    @FXML
    private TextField lbOption1;
    @FXML
    private TableColumn<Question, String> coloption1;
    @FXML
    private TableColumn<Question, String> coloption2;
    @FXML
    private TableColumn<Question, String> coloption3;
    @FXML
    private TableColumn<Question, String> colanswer;
    @FXML
    private TableColumn<Question, String> colExamtvQuestions;
    @FXML
    private TableView<Examen> tvExams;
    @FXML
    private TableColumn<Examen, String> colNomExamtvExams;
    @FXML
    private TextField lbOption2;
    @FXML
    private TextField lbOption3;
    @FXML
    private RadioButton option1;
    @FXML
    private ToggleGroup options;
    @FXML
    private RadioButton option2;
    @FXML
    private RadioButton option3;

    public void setIdExamlabel(String idExamlabel) {
        this.idExamlabel.setText(idExamlabel);
    }

    public Label getIdExamlabel() {
        return idExamlabel;
    }
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RadioButtonSetup() ;
  
        
        
        
       showQuestions();
        showExams() ;
        
        
        
        
      }    
    
    public void  RadioButtonSetup() {
        
        options = new ToggleGroup();
        option1.setToggleGroup(options);
        option2.setToggleGroup(options);
        option3.setToggleGroup(options);
    }
        
     
    @FXML
    private void ajuoterQuestion(ActionEvent event) {
       

        /*
        if (lbEnnonce.getText().trim().isEmpty() ||
                lbOption1.getText().isEmpty() ||
                lbOption2.getText().isEmpty() ||
                lbOption3.getText().isEmpty()||
                selectedOption==null)  
                    JOptionPane.showMessageDialog(null," Veuillez remplir tous les champs   ! ");
*/
      

            
        
        
        
     
        
        
        /* 
                else 
        
        {
        */
        QuestionService  QS = new QuestionService() ;
        Examen e = tvExams.getSelectionModel().getSelectedItem() ;
                            String ans = null ;
    Toggle selectedOption = options.getSelectedToggle() ; 

                    if(selectedOption == option1){
                ans = lbOption1.getText().trim();
                 }else if(selectedOption == option2){
                ans = lbOption2.getText().trim();
                 }
                  else if(selectedOption == option3){
                ans = lbOption3.getText().trim();
                   }
        System.out.print("*******" + ans  );
        QS.ajouter(new Question(lbEnnonce.getText() , lbOption1.getText()    ,    lbOption2.getText() , lbOption3.getText() ,ans,  e.getIdExamen()));
       
        
         JOptionPane.showMessageDialog(null,"Question Ajoutée ! ");
        showQuestions() ;
        //}
        
    }

    @FXML
    private void modifierQuestion(ActionEvent event) {
        
        Toggle selectedOption = options.getSelectedToggle() ; 
        
                            String ans = "";

                    if(selectedOption == option1){
                ans = lbOption1.getText().trim();
                 }else if(selectedOption == option2){
                ans = lbOption2.getText().trim();
            }
            else if(selectedOption == option3){
                ans = lbOption3.getText().trim();
            }
        Question q = tvQuestion.getSelectionModel().getSelectedItem();
        QuestionService  QE = new QuestionService() ;
        QE.modifier(new Question(q.getIdQuestion() , lbEnnonce.getText() , lbOption1.getText()    ,    lbOption2.getText() , lbOption3.getText() ,ans,  q.getIdExamen()));
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
        coloption1.setCellValueFactory(new PropertyValueFactory<Question,String>("option1"));
        coloption2.setCellValueFactory(new PropertyValueFactory<Question,String>("option2"));
        coloption3.setCellValueFactory(new PropertyValueFactory<Question,String>("option3"));
        colanswer.setCellValueFactory(new PropertyValueFactory<Question,String>("answer"));
        colExamtvQuestions.setCellValueFactory(new PropertyValueFactory<Question,String>("nomExamen"));
        System.out.println("list questionsssssssssss" + list);
        tvQuestion.setItems(list);        
    }

    @FXML
    private void editQuestion(ActionEvent event) {
    }
    
                      public void showExams() {
                    ExamenService  QS = new  ExamenService() ;
                    ObservableList<Examen> list = QS.afficher() ;
                    System.out.println(list ) ; 
                    colNomExamtvExams.setCellValueFactory(new PropertyValueFactory<Examen,String>("nomExamen"));
                    System.out.println(list);
                    tvExams.setItems(list);
                    System.out.println("pppppppppppp"  +  list ) ;
        
    }
    
}
