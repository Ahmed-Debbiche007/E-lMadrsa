/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;
import Listners.NewScreenListener;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
 import entities.Examen;
import entities.Participation;
import entities.Question; 
import java.io.IOException;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
 
 import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
 import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
 
import services.ExamenService;
import services.ParticipationsService;
/**
 * FXML Controller class
 *
 * @author Msi
 */
public class QuestionsScreenController implements Initializable {


   
   
    private class QuestionsObservable {
        Property<String> question = new SimpleStringProperty();
        Property<String> option1 = new SimpleStringProperty();
        Property<String> option2 = new SimpleStringProperty();
        Property<String> option3 = new SimpleStringProperty();
         Property<String> answer = new SimpleStringProperty();

        public void setQuestion(Question question) {
            this.question.setValue(question.getEnnonce());
            this.option1.setValue(question.getOption1());
            this.option2.setValue(question.getOption2());
            this.option3.setValue(question.getOption3());
            this.answer.setValue(question.getAnswer());
        }
    }
    @FXML
    private FlowPane progressPane;
     @FXML
    private Label title;
    @FXML
    private Label time;
    @FXML
    private Label question;
    @FXML
    private RadioButton option1;
    @FXML
    private ToggleGroup options;
    @FXML
    private RadioButton option2;
    @FXML
    private RadioButton option3;
     @FXML
    private Button next;
    @FXML
    private Button submit;
      
    
    
    
    private NewScreenListener screenListener;

    private Examen examen  ;
    private List<Question> questionList;
    private Question currentQuestion;
    int currentIndex = 0;
    private QuestionsObservable questionsObservable;
    private Map<Question, String> studentAnswers = new HashMap<>();
    private Integer numberOfRightAnswers = 0;

    public void setExamen(Examen examen) {
        this.examen = examen;
                this.title.setText(this.examen.getNomExamen());
                         //this.currentIndex =0;

         this.getData();
    }

    public Examen getExamen() {
        return examen;
    }

    public void setOption1(RadioButton option1) {
        this.option1 = option1;
    }

    public void setOption2(RadioButton option2) {
        this.option2 = option2;
    }

    public void setOption3(RadioButton option3) {
        this.option3 = option3;
    }
 


 
 
 
  

 

 

    

 private void getData() {
        if (examen != null) {            ExamenService Es = new ExamenService() ;

            
            this.questionList = Es.getQuestions(examen.getIdExamen());
            Collections.shuffle(this.questionList);
            //renderProgress();
             setNextQuestion();
             System.out.println("curerent index fel function mta getdata " + this.currentIndex);
            //setTimer();
        }
    }

 
   private void hideNextQuestionButton() {
        this.next.setVisible(false);
    }

    private void showNextQuestionButton() {
        this.next.setVisible(true);
    }
     private void hideSubmitQuizButton() {
        this.submit.setVisible(false);
    }

    private void showSubmitQuizButton() {
        this.submit.setVisible(true);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         

        System.out.println("************** current indexxxxx " + this.currentIndex );
        this.showNextQuestionButton();
        this.hideSubmitQuizButton();

        this.questionsObservable = new QuestionsObservable();
        bindFields();

        this.option1.setSelected(true);
    }    
    private void bindFields() {
        this.question.textProperty().bind(this.questionsObservable.question);
         this.option3.textProperty().bind(this.questionsObservable.option3);
        this.option2.textProperty().bind(this.questionsObservable.option2);
        this.option1.textProperty().bind(this.questionsObservable.option1);
    }



    @FXML
    private void nextQuestions(ActionEvent event) {
        boolean isRight = false;
         
            // checking answer
            RadioButton selectedButton = (RadioButton) options.getSelectedToggle();
            String userAnswer = selectedButton.getText();
            String rightAnswer = this.currentQuestion.getAnswer();
            if (userAnswer.trim().equalsIgnoreCase(rightAnswer.trim())) {
                isRight = true;
                this.numberOfRightAnswers++;
            }

            // saving Answer to hashMap
            studentAnswers.put(this.currentQuestion, userAnswer);

            System.out.println("rights :" +numberOfRightAnswers) ; 

 
           
            setNextQuestion();

    }
     private void setNextQuestion() {
        System.out.println("current : " + currentIndex) ; System.out.println("size : " + questionList.size()+ "number of r a" + this.numberOfRightAnswers ) ; 
        System.out.println("******** current question : "+this.currentQuestion) ;
        
             if (!(currentIndex >= questionList.size())) {
            this.currentQuestion = this.questionList.get(currentIndex);
            System.out.println("******** current question : "+this.currentQuestion) ;System.out.println("******** all questions : "+this.questionList) ; 
            this.currentQuestion.setOption1(currentQuestion.getOption1());
            this.currentQuestion.setOption2(currentQuestion.getOption2());
            this.currentQuestion.setOption3(currentQuestion.getOption3());
            this.questionsObservable.setQuestion(this.currentQuestion);
            currentIndex++;
        } else {
                             this.currentQuestion = this.questionList.get(0);
            System.out.println("******** current question : "+this.currentQuestion) ;System.out.println("******** all questions : "+this.questionList) ; 
            this.currentQuestion.setOption1(currentQuestion.getOption1());
            this.currentQuestion.setOption2(currentQuestion.getOption2());
            this.currentQuestion.setOption3(currentQuestion.getOption3());
            this.questionsObservable.setQuestion(this.currentQuestion);
            hideNextQuestionButton();
            showSubmitQuizButton();
            System.out.println("exam completed ") ; 
                 
  
                
        }
        
        
     }
    @FXML
    private void submit(ActionEvent event) throws IOException {

          
        
        
         boolean isRight = false;
         
            // checking answer
            RadioButton selectedButton = (RadioButton) options.getSelectedToggle();
            String userAnswer = selectedButton.getText();
            String rightAnswer = this.currentQuestion.getAnswer();
            if (userAnswer.trim().equalsIgnoreCase(rightAnswer.trim())) {
                isRight = true;
                this.numberOfRightAnswers++;
            }

             studentAnswers.put(this.currentQuestion, userAnswer);
        
         System.out.println("rights :" +numberOfRightAnswers) ; 


        
        
                   // setNextQuestion() ; 
                    Notifications.create()
                    .title("Message")
                    .text("You Succesfully Attemped Quiz...")
                    .position(Pos.BOTTOM_RIGHT)
                    .showInformation();
                    
                            try {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("resultatUI.fxml")) ;
                                Parent root = loader.load() ; 
                                question.getScene().setRoot(root);
                                ResultatUIController controller = loader.getController();
                                System.out.println("user answers : " + this.studentAnswers) ; 
                                System.out.println("number of right answers :  : " + this.numberOfRightAnswers) ; 
                                System.out.println("exam :  :  : " + this.examen) ; 
                                System.out.println("question list  :  :  : " + this.questionList) ; 
                               double d ;
                                   d  =  this.numberOfRightAnswers *100 ;
                                   d= d/this.questionList.size() ;
                                                                       System.out.println("****---" + this.questionList.size() );
                                   System.out.println("****---" + this.numberOfRightAnswers );

                                   System.out.println("****---" +  d );
                                  DecimalFormat df = new DecimalFormat("0.00");
                                  df.setRoundingMode(RoundingMode.UP);
                                  
                                  
 
                                controller.setResultlb(String.valueOf(this.numberOfRightAnswers)+"/"+String.valueOf(this.questionList.size()));
                                controller.setTauxlb(String.valueOf(df.format(d)) + "%"); 
                                controller.setValues(this.studentAnswers , numberOfRightAnswers , examen , questionList);
                                
                                if (examen.getPourcentage()< d){
                                    controller.setDescisionlb("Admin !  félciitation ! ");
                                }  
                                else {
                                 controller.setDescisionlb("Refusé ! ");
                                
                                }
                                /*
                                ParticipationsService PS = new ParticipationsService() ;
                                long l = 2 ; 
                                long  p = PS.getParticipation(l, examen.getFormationId());
                                PS.AffecterResultat(d,p);
                                */
                                    
                                
                                     
                                
                                
                                
                                 System.out.println("get from other scree for ensure the set of values :  :  :  : " + this.numberOfRightAnswers) ; 

 
                                } catch (IOException ex) {
                                    System.out.println(ex.getLocalizedMessage()) ; 

                                }
                    
                            
    
                            
   

    }
    private void openResultScreen() {
        

        try {
                           FXMLLoader fxmlLoader = new FXMLLoader(getClass().
                getResource("resultatUI.fxml"));
            Region node = fxmlLoader.load();
                      ResultatUIController controller = fxmlLoader.getController();
            controller.setValues(this.studentAnswers , numberOfRightAnswers , examen , questionList);
          // this.screenListener.removeTopScreen();
           // this.screenListener.ChangeScreen(node);
        } catch (IOException ex) {
            System.out.println(ex.getCause()) ; 
            
        }
    }
    @FXML
    private void exitfromExam(ActionEvent event) throws IOException {
            Stage stage ;
    Parent root = FXMLLoader.load(getClass().getResource("MainUI.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    Scene scene=new Scene(root);
    stage.setScene(scene);
    stage.show();
    }
    
}
