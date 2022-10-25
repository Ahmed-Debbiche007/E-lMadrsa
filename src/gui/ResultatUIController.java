/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;
import entities.Examen;
import entities.Question;
import entities.User;
import java.net.URL;
import java.sql.Date;
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
    @FXML
    private Label resultlb;
    @FXML
    private Label tauxlb;
    @FXML
    private Label Descisionlb;

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

    public Label getResultlb() {
        return resultlb;
    }

    public void setResultlb(String resultlb) {
        this.resultlb.setText(resultlb) ; 
    }

    public void setDescisionlb(String Descisionlb) {
        this.Descisionlb.setText(Descisionlb) ;
    }

    public Integer getAttemped() {
        return attemped;
    }

    public Label getDescisionlb() {
        return Descisionlb;
    }

 

    public void setTauxlb(String tauxlb) {
        this.tauxlb.setText(tauxlb); 
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
       // System.out.println("*****" + );
       
        
Stage newStage = new Stage();
// Stage thisStage = (Stage) resulttitle.getScene().getWindow();
// cene thisScene = (Scene) resulttitle.getScene().;
      setValuesToChart(newStage);
        //renderQuestions();
    }
    
    
    
    
        private void renderQuestions(){

    }


    private void setValuesToChart(Stage stage ){
        System.out.println("attemped : " + this.attemped) ;  System.out.println(" not attemped : " + this.notAttemped) ; 
                Scene scene = new Scene(new Group());
 
                       
         ObservableList<PieChart.Data> scoreChartData = FXCollections.observableArrayList(new PieChart.Data(
                String.format("Réponses correctes (%d)", this.numberOfRightAnswers) , this.numberOfRightAnswers),new PieChart.Data(String.format("réponses fausses (%d)", (this.questionList.size()-this.numberOfRightAnswers)) , (this.questionList.size()-this.numberOfRightAnswers)));
        
            scoreChart =  new PieChart(scoreChartData);
            //scoreChart.setLegendVisible(false);
                    ((Group) scene.getRoot()).getChildren().add(scoreChart);
       try
      {
         scene.getStylesheets().add("../style/chart.css");
      }
      catch (Exception ex)
      {
         System.err.println("Cannot acquire stylesheet: " + ex.toString());
      }

        stage.setScene(scene);
        stage.show();

    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
      // System.out.println("******" + this.examen.getPourcentage()) ; 
     //  System.out.println((this.tauxlb) ) ; 
       
        /*
        if ( this.examen.getPourcentage()  <  Double.parseDouble(this.tauxlb)) {
            Descisionlb.setText("Admin ! , félicitations"); 
        }
        */
        
        System.out.println("exam : " +this.examen) ; 
 

    }
    
      private void applyCustomColorSequence(ObservableList<PieChart.Data> pieChartData, String... pieColors) {
    int i = 0;
    for (PieChart.Data data : pieChartData) {
      data.getNode().setStyle("-fx-pie-color: " + pieColors[i % pieColors.length] + ";");
      i++;
    }
  }
    
    
}
