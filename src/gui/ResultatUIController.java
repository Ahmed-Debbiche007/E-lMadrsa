/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Examen;
import entities.Question;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Msi
 */
public class ResultatUIController implements Initializable {
        public PieChart attempedChart;
    public PieChart scoreChart;
    public VBox questionsContainer;

    // not fxml varibale
    private Map<Question , String> userAnswers ;
    private Integer numberOfRightAnswers = 0;
    private Examen examen ;
    private List<Question> questionList;
    private Integer notAttemped = 0 ;
    private Integer attemped = 0 ;
    @FXML
    private Label resulttitle;

    public void setNumberOfRightAnswers(Integer numberOfRightAnswers) {
        this.numberOfRightAnswers = numberOfRightAnswers;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public void setNotAttemped(Integer notAttemped) {
        this.notAttemped = notAttemped;
    }

    public void setAttemped(Integer attemped) {
        this.attemped = attemped;
    }

    public Map<Question, String> getUserAnswers() {
        return userAnswers;
    }

    public Integer getNumberOfRightAnswers() {
        return numberOfRightAnswers;
    }

    public Examen getExamen() {
        return examen;
    }

    public Integer getNotAttemped() {
        return notAttemped;
    }

    public Integer getAttemped() {
        return attemped;
    }
    
    public void  setValues(Map<Question, String> userAnswers,
                           Integer numberOfRightAnswers, Examen examen,
                           List<Question> questionList) {
        this.userAnswers = userAnswers;
        this.numberOfRightAnswers = numberOfRightAnswers;
        this.examen = examen;
        this.questionList = questionList;

        this.attemped = this.userAnswers.keySet().size();
        this.notAttemped = this.questionList.size() - attemped;
        
//Stage newStage = new Stage();
 Stage thisStage = (Stage) resulttitle.getScene().getWindow();
 //Scene thisScene = (Scene) resulttitle.getScene().;
      setValuesToChart(thisStage);
        //renderQuestions();
    }
    
    
    
    
        private void renderQuestions(){
            /*
        for(int i = 0 ; i < this.questionList.size() ; i ++){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().
                    getResource("/fxml/student/QuizResultSingleQuestionFXML.fxml"));

            try {
                Node node = fxmlLoader.load();
                QuizResultSingleQuestionFXMLController controller= fxmlLoader.getController();
                controller.setValues(this.questionList.get(i) , this.userAnswers.get(this.questionList.get(i)));
                questionsContainer.getChildren().add(node);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            */
    }


    private void setValuesToChart(Stage stage ){
        System.out.println("attemped : " + this.attemped) ; 
                Scene scene = new Scene(new Group());
 
        /*
                ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(  new PieChart.Data("taux des réponses vrais",10 ),
                        
                new PieChart.Data("taux des réponses fausses", 50)) ; 
                */
        //ObservableList<PieChart.Data> attempedData = this.attempedChart.getData();
        //attempedData.add(new PieChart.Data(String.format("Attemped (%d)", this.attemped) , this.attemped));
       // attempedData.add(new PieChart.Data(String.format("Not Attemped (%d)", this.notAttemped) , this.notAttemped));


        ObservableList<PieChart.Data> scoreChartData = FXCollections.observableArrayList(new PieChart.Data(
                String.format("Right Answers (%d)", this.numberOfRightAnswers) , this.numberOfRightAnswers),new PieChart.Data(String.format("Not Attemped (%d)", this.notAttemped) , this.notAttemped));
        
      scoreChart =    new PieChart(scoreChartData);
         ((Group) scene.getRoot()).getChildren().add(scoreChart);
        stage.setScene(scene);
        stage.show();

    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("exam : " +this.examen) ; 
         
    }
    
}
