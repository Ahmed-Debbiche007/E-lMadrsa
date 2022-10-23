/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;
import Listners.NewScreenListener;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
 import entities.Examen;
import entities.Question; 
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
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
    private RadioButton option4;
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
    private long min, sec, hr, totalSec = 0; //250 4 min 10 sec
    private Timer timer;


 

    private String format(long value) {
        if (value < 10) {
            return 0 + "" + value;
        }

        return value + "";
    }

    public void convertTime() {

        min = TimeUnit.SECONDS.toMinutes(totalSec);
        sec = totalSec - (min * 60);
        hr = TimeUnit.MINUTES.toHours(min);
        min = min - (hr * 60);
        time.setText(format(hr) + ":" + format(min) + ":" + format(sec));

        totalSec--;
    }

    private void setTimer() {
        totalSec = this.questionList.size() * 2;
        this.timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("After 1 sec...");
                        convertTime();
                        /*
                        if (totalSec <= 0) {
                            timer.cancel();
                            time.setText("00:00:00");
                            // saveing data to database
                            submit(null);
                            Notifications.create()
                                    .title("Error")
                                    .text("TIme Up")
                                    .position(Pos.BOTTOM_RIGHT)
                                    .showError();
                        }
                        */
                    }
                });
            }
        };

        timer.schedule(timerTask, 0, 10000);
    }
     private void renderProgress() {
                 for (int i = 0; i < this.questionList.size(); i++) {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    getClass()
                            .getResource("ProgressCircleFXML.fxml"));
            try {
                Node node = fxmlLoader.load();
                ProgressCircleFXMLController  progressCircleFXMLController  = fxmlLoader.getController();
                progressCircleFXMLController.setNumber(i + 1);
                progressCircleFXMLController.setDefaultColor();
                progressPane.getChildren().add(node);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
     }

    
 private void setNextQuestion() {
        System.out.println("current : " + currentIndex) ; System.out.println("size : " + questionList.size()) ; 
        
        
                if (!(currentIndex >= questionList.size())) {
/*
            {
                // chaning the color
                Node circleNode = this.progressPane.getChildren().get(currentIndex);
                ProgressCircleFXMLController controller = (ProgressCircleFXMLController) circleNode.getUserData();
                controller.setCurrentQuestionColor();
            }
*/
            this.currentQuestion = this.questionList.get(currentIndex);
          
 
 
            this.currentQuestion.setOption1(currentQuestion.getOption1());
            this.currentQuestion.setOption2(currentQuestion.getOption2());
            this.currentQuestion.setOption3(this.currentQuestion.getOption3());
  /*
           this.question.setText(this.currentQuestion.getEnnonce());
            this.option1.setText(options.get(0));
             this.option2.setText(options.get(1));
           this.option3.setText(options.get(2));
//            this.option4.setText(options.get(3));
            */

            this.questionsObservable.setQuestion(this.currentQuestion);
            currentIndex++;
        } else {
                              hideNextQuestionButton();
            showSubmitQuizButton();
                    System.out.println("exam completed ") ; 
                 
  
                
        }
        
        
     }
 private void getData() {
        if (examen != null) {            ExamenService Es = new ExamenService() ;

            
            this.questionList = Es.getQuestions(examen.getIdExamen());
            Collections.shuffle(this.questionList);
            //renderProgress();
            setNextQuestion();
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
        
//        Node circleNode = this.progressPane.getChildren().get(currentIndex - 1);
      //  ProgressCircleFXMLController controller = (ProgressCircleFXMLController) circleNode.getUserData();
System.out.println("rights :" +numberOfRightAnswers) ; 
/*
        if (isRight) {
            controller.setRightAnsweredColor();
        } else {
            controller.setWrongAnsweredColor();
        }
    }

*/
        this.setNextQuestion();

    }
    @FXML
    private void submit(ActionEvent event) throws IOException {
        /*
                System.out.println(this.studentAnswers);
         boolean result = quizResult.save(this.studentAnswers);
        if (result) {
            Notifications.create()
                    .title("Message")
                    .text("You Succesfully Attemped Quiz...")
                    .position(Pos.BOTTOM_RIGHT)
                    .showInformation();
            timer.cancel();
            openResultScreen();
        } else {
            Notifications.create()
                    .title("Error")
                    .text("Something Went Wrong..")
                    .position(Pos.BOTTOM_RIGHT)
                    .showError();
        }
*/       
                    Notifications.create()
                    .title("Message")
                    .text("You Succesfully Attemped Quiz...")
                    .position(Pos.BOTTOM_RIGHT)
                    .showInformation();
                    
                            try {
                                    FXMLLoader loader = new FXMLLoader(getClass().getResource("resultatUI.fxml")) ;
                                    Parent root = loader.load() ; 
                                    question.getScene().setRoot(root);
          //  Region node = fxmlLoader.load();
                     ResultatUIController controller = loader.getController();
                     System.out.println("user answers : " + this.studentAnswers) ; 
                     System.out.println("number of right answers :  : " + this.numberOfRightAnswers) ; 
                     System.out.println("exam :  :  : " + this.examen) ; 
                     System.out.println("question list  :  :  : " + this.questionList) ; 
                     
            controller.setValues(this.studentAnswers , numberOfRightAnswers , examen , questionList);
            
            
                                 System.out.println("get from other scree for ensure the set of values :  :  :  : " + controller.getNumberOfRightAnswers()) ; 

          // this.screenListener.removeTopScreen();
           // this.screenListener.ChangeScreen(node);
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
